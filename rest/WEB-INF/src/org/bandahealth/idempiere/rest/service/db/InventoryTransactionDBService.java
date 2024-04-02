package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MMovement_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.rest.model.AttributeSetInstance;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.BaseMetadata;
import org.bandahealth.idempiere.rest.model.FilterTableData;
import org.bandahealth.idempiere.rest.model.InventoryTransaction;
import org.bandahealth.idempiere.rest.model.Locator;
import org.bandahealth.idempiere.rest.model.Movement;
import org.bandahealth.idempiere.rest.model.Order;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.Transaction;
import org.bandahealth.idempiere.rest.model.User;
import org.bandahealth.idempiere.rest.model.Visit;
import org.bandahealth.idempiere.rest.utils.FilterUtil;
import org.bandahealth.idempiere.rest.utils.SortUtil;
import org.bandahealth.idempiere.rest.utils.SqlUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MLocator;
import org.compiere.model.MTransaction;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InventoryTransactionDBService {
	private CLogger log = CLogger.getCLogger(InventoryTransactionDBService.class);

	private final TransactionDBService transactionDBService = new TransactionDBService();
	private final OrderDBService orderDBService = new OrderDBService();
	private final MovementDBService movementDBService = new MovementDBService();
	private final VisitDBService visitDBService = new VisitDBService();
	private final UserDBService userDBService = new UserDBService();
	private final AttributeSetInstanceDBService attributeInstanceDBService = new AttributeSetInstanceDBService();
	private final LocatorDBService locatorDBService = new LocatorDBService();

	public BaseListResponse<InventoryTransaction> getAll(Paging pagingInfo, String sortJson, String filterJson) {
		try {
			EntityConfiguration entityConfiguration = new EntityConfiguration() {{
				setShouldUseContextClientId(true);
				setShouldFetchFromSystemClient(false);
			}};
			String functionName = "bh_get_product_transactions";

			List<Object> parameters = new ArrayList<>();
			String whereClause =
					FilterUtil.getWhereClauseFromFilter(new FilterTableData(functionName,
							Map.ofEntries(
									Map.entry("created", Timestamp.class),
									Map.entry("m_transaction_id", Integer.class),
									Map.entry("c_order_id", Integer.class),
									Map.entry("m_movement_id", Integer.class),
									Map.entry("bh_visit_id", Integer.class),
									Map.entry("m_product_id", Integer.class),
									Map.entry("m_locator_id", Integer.class),
									Map.entry("m_attributesetinstance_id", Integer.class),
									Map.entry("createdby", Integer.class),
									Map.entry("transaction_type", String.class),
									Map.entry("movementqty", BigDecimal.class),
									Map.entry("runningtotal_bylocator", BigDecimal.class)
							)
					), filterJson, parameters, entityConfiguration);

			String orderByClause = "";
			if (StringUtil.isNotNullAndEmpty(sortJson)) {
				orderByClause = " ORDER BY " + SortUtil.getOrderByClauseFromSort(functionName, sortJson);
			}

			// get total count without pagination parameters
			pagingInfo.setTotalRecordCount(
					SqlUtil.getCount(functionName + "(" + Env.getAD_Client_ID(Env.getCtx()) + ") WHERE ", whereClause,
							parameters));

			// If the total record count is less than what we'd get with our page parameters, reset the page
			int firstRecordNumberOfRequestedPage = (pagingInfo.getPage() * pagingInfo.getPageSize()) + 1;
			if (pagingInfo.getTotalRecordCount() < firstRecordNumberOfRequestedPage) {
				pagingInfo.setPage(0);
			}

			// set pagination params
			int pageSize = pagingInfo.getPageSize();
			int recordsToSkip = pagingInfo.getPage() * pageSize;
			String query = "SELECT created, m_transaction_id, c_order_id, m_movement_id, bh_visit_id, m_product_id, " +
					"m_locator_id, m_attributesetinstance_id, createdby, transaction_type, movementqty, runningtotal_bylocator" +
					" FROM " + functionName + "(" + Env.getAD_Client_ID(Env.getCtx()) + ") WHERE " + whereClause + orderByClause;
			query = DB.getDatabase().addPagingSQL(query, recordsToSkip + 1, pageSize <= 0 ? 0 : recordsToSkip + pageSize);
			List<InventoryTransaction> results = new ArrayList<>();
			SqlUtil.executeQuery(query, parameters, null, resultSet -> {
				InventoryTransaction inventoryTransaction = new InventoryTransaction();
				//
				try {
					inventoryTransaction.setCreatedTimestamp(resultSet.getTimestamp(1));
					inventoryTransaction.setTransactionId(resultSet.getInt(2));
					inventoryTransaction.setOrderId(resultSet.getInt(3));
					inventoryTransaction.setMovementId(resultSet.getInt(4));
					inventoryTransaction.setVisitId(resultSet.getInt(5));
					inventoryTransaction.setProductId(resultSet.getInt(6));
					inventoryTransaction.setLocatorId(resultSet.getInt(7));
					inventoryTransaction.setAttributeSetInstanceId(resultSet.getInt(8));
					inventoryTransaction.setCreatedById(resultSet.getInt(9));
					inventoryTransaction.setTransactionType(resultSet.getString(10));
					inventoryTransaction.setMovementQuantity(resultSet.getBigDecimal(11));
					inventoryTransaction.setRunningTotal(resultSet.getBigDecimal(12));
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
				//
				results.add(inventoryTransaction);
			});

			return new BaseListResponse<>(transformData(results), pagingInfo);
		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

	public List<InventoryTransaction> transformData(List<InventoryTransaction> inventoryTransactions) {
		// Get transactions
		List<MTransaction> transactions = new ArrayList<>(transactionDBService.getByIds(
				inventoryTransactions.stream().map(InventoryTransaction::getTransactionId).filter(id -> id > 0)
						.collect(Collectors.toSet())).values());
		Map<Integer, Transaction> transactionsById = transactions.isEmpty() ? new HashMap<>() :
				transactionDBService.transformData(transactions).stream()
						.collect(Collectors.toMap(BaseMetadata::getId, entity -> entity));

		// Get movements
		List<MMovement_BH> movements = new ArrayList<>(movementDBService.getByIds(
				inventoryTransactions.stream().map(InventoryTransaction::getMovementId).filter(id -> id > 0)
						.collect(Collectors.toSet())).values());
		Map<Integer, Movement> movementsById = movements.isEmpty() ? new HashMap<>() :
				movementDBService.transformData(movements).stream()
						.collect(Collectors.toMap(BaseMetadata::getId, entity -> entity));

		// Get visits
		List<MBHVisit> visits = new ArrayList<>(visitDBService.getByIds(
				inventoryTransactions.stream().map(InventoryTransaction::getVisitId).filter(id -> id > 0)
						.collect(Collectors.toSet())).values());
		Map<Integer, Visit> visitsById = visits.isEmpty() ? new HashMap<>() : visitDBService.transformData(visits).stream()
				.collect(Collectors.toMap(BaseMetadata::getId, entity -> entity));

		// Get movements
		List<MOrder_BH> orders = new ArrayList<>(orderDBService.getByIds(
				inventoryTransactions.stream().map(InventoryTransaction::getOrderId).filter(id -> id > 0)
						.collect(Collectors.toSet())).values());
		Map<Integer, Order> ordersById = orders.isEmpty() ? new HashMap<>() : orderDBService.transformData(orders).stream()
				.collect(Collectors.toMap(BaseMetadata::getId, entity -> entity));

		// Get users who created the records
		Map<Integer, User> usersById = userDBService.getByIds(
						inventoryTransactions.stream().map(InventoryTransaction::getCreatedById).collect(Collectors.toSet())).values()
				.stream().map(User::new).collect(Collectors.toMap(BaseMetadata::getId, entity -> entity));

		// Get attribute set instances
		Map<Integer, AttributeSetInstance> attributeSetInstancesById = attributeInstanceDBService.getByIds(
						inventoryTransactions.stream().map(InventoryTransaction::getAttributeSetInstanceId).filter(id -> id > 0)
								.collect(Collectors.toSet())).values().stream().map(AttributeSetInstance::new)
				.collect(Collectors.toMap(BaseMetadata::getId, entity -> entity));

		// Get locators
		List<MLocator> locators = new ArrayList<>(locatorDBService.getByIds(
				inventoryTransactions.stream().map(InventoryTransaction::getLocatorId).collect(Collectors.toSet())).values());
		Map<Integer, Locator> locatorsById = locators.isEmpty() ? new HashMap<>() :
				locatorDBService.transformData(locators).stream().collect(Collectors.toMap(Locator::getId, line -> line));

		return inventoryTransactions.stream().peek(inventoryTransaction -> {
			inventoryTransaction.setTransaction(transactionsById.getOrDefault(inventoryTransaction.getTransactionId(),
					null));
			inventoryTransaction.setMovement(movementsById.getOrDefault(inventoryTransaction.getMovementId(), null));
			inventoryTransaction.setVisit(visitsById.getOrDefault(inventoryTransaction.getVisitId(), null));
			inventoryTransaction.setOrder(ordersById.getOrDefault(inventoryTransaction.getOrderId(), null));
			inventoryTransaction.setUser(usersById.getOrDefault(inventoryTransaction.getCreatedById(), null));
			inventoryTransaction.setAttributeSetInstance(
					attributeSetInstancesById.getOrDefault(inventoryTransaction.getAttributeSetInstanceId(), null));
			inventoryTransaction.setLocator(locatorsById.getOrDefault(inventoryTransaction.getLocatorId(), null));
		}).collect(Collectors.toList());
	}
}
