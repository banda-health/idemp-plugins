package org.bandahealth.idempiere.rest.service.db;

import org.adempiere.exceptions.DBException;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MInventoryLine_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.X_BH_Stocktake_v;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.InventoryRecord;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.Product;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.bandahealth.idempiere.rest.utils.FilterUtil;
import org.bandahealth.idempiere.rest.utils.SortUtil;
import org.bandahealth.idempiere.rest.utils.SqlUtil;
import org.compiere.model.MWarehouse;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class InventoryRecordDBService extends BaseDBService<InventoryRecord, MInventoryLine_BH> {

	private final String DEFAULT_SEARCH_COLUMN = X_BH_Stocktake_v.COLUMNNAME_Product;
	private final String DEFAULT_SEARCH_CLAUSE = "LOWER(" + DEFAULT_SEARCH_COLUMN + ") " + LIKE_COMPARATOR + " ? ";
	private final String NO_DEFAULT_WAREHOUSE = "No warehouses defined for organization";
	private final String NO_PRODUCTS_ADDED = "No products were passed to initialize stock.";
	private final List<String> viewColumnsToUse = new ArrayList<>(
			Arrays.asList(X_BH_Stocktake_v.Table_Name + "." + X_BH_Stocktake_v.COLUMNNAME_M_Product_ID,
					X_BH_Stocktake_v.Table_Name + "." + X_BH_Stocktake_v.COLUMNNAME_M_Warehouse_ID,
					X_BH_Stocktake_v.Table_Name + "." + X_BH_Stocktake_v.COLUMNNAME_Product,
					X_BH_Stocktake_v.Table_Name + "." + X_BH_Stocktake_v.COLUMNNAME_expirationdate,
					X_BH_Stocktake_v.Table_Name + "." + X_BH_Stocktake_v.COLUMNNAME_quantity,
					X_BH_Stocktake_v.Table_Name + "." + X_BH_Stocktake_v.COLUMNNAME_ShelfLifeDays,
					X_BH_Stocktake_v.Table_Name + "." + X_BH_Stocktake_v.COLUMNNAME_M_AttributeSetInstance_ID,
					X_BH_Stocktake_v.Table_Name + "." + X_BH_Stocktake_v.COLUMNNAME_AD_Client_ID,
					X_BH_Stocktake_v.Table_Name + "." + X_BH_Stocktake_v.COLUMNNAME_AD_Org_ID,
					X_BH_Stocktake_v.Table_Name + "." + X_BH_Stocktake_v.COLUMNNAME_Created,
					X_BH_Stocktake_v.Table_Name + "." + X_BH_Stocktake_v.COLUMNNAME_CreatedBy,
					X_BH_Stocktake_v.Table_Name + "." + X_BH_Stocktake_v.COLUMNNAME_Description));
	protected CLogger log = CLogger.getCLogger(InventoryRecordDBService.class);
	@Autowired
	private ReferenceListDBService referenceListDBService;
	@Autowired
	private ProductDBService productDBService;
	@Autowired
	private AttributeSetInstanceDBService attributeSetInstanceDBService;

	public BaseListResponse<InventoryRecord> getInventory(Paging pagingInfo, String sortJson, String filterJson)
			throws DBException {
		String orderByClause = SortUtil.getOrderByClauseFromSort(X_BH_Stocktake_v.Table_Name, sortJson);
		return this.getInventory(pagingInfo, null, null, orderByClause, filterJson);
	}

	public BaseListResponse<InventoryRecord> searchInventory(Paging pagingInfo, String value, String sortColumn,
			String sortOrder, String filterJson) throws DBException {
		return this.getInventory(pagingInfo, value, null, getOrderByClause(sortColumn, sortOrder), filterJson);
	}

	/**
	 * Get the inventory of a particular product
	 *
	 * @param productId The ID of the product to get inventory for
	 * @return The product's inventory.
	 * @throws DBException
	 */
	public BigDecimal getProductInventoryCount(Integer productId, boolean includeExpired) throws DBException {
		BaseListResponse<InventoryRecord> inventoryList =
				this.getInventory(Paging.ALL.getInstance(), null, productId, null, null);

		return inventoryList.getResults().stream().filter(inventory -> !includeExpired || inventory.getShelfLife() >= 0)
				.reduce(BigDecimal.ZERO, (subtotal, item) -> subtotal.add(BigDecimal.valueOf(item.getQuantity())),
						BigDecimal::add);
	}

	public BaseListResponse<InventoryRecord> getProductInventory(Paging pagingInfo, Integer productId)
			throws DBException {
		return this.getInventory(pagingInfo, null, productId,
				getOrderByClause(X_BH_Stocktake_v.COLUMNNAME_expirationdate, ASCENDING_ORDER), null);
	}

	private String getOrderByClause(String sortColumn, String sortOrder) {
		if (sortColumn != null && !sortColumn.isEmpty() && sortOrder != null && !sortOrder.isEmpty() && viewColumnsToUse
				.stream().map(String::toLowerCase).collect(Collectors.toList()).contains(sortColumn)) {
			return sortColumn + " " + sortOrder + ORDERBY_NULLS_LAST;
		}
		return X_BH_Stocktake_v.Table_Name + "." + X_BH_Stocktake_v.COLUMNNAME_Product + " " + ASCENDING_ORDER +
				ORDERBY_NULLS_LAST;
	}

	private BaseListResponse<InventoryRecord> getInventory(Paging pagingInfo, String searchValue, Integer productId,
			String orderByClause, String filterJson) throws DBException {
		List<InventoryRecord> results = new ArrayList<>();

		StringBuilder sqlSelect = new StringBuilder().append("SELECT ").append(String.join(", ", viewColumnsToUse))
				.append(" FROM ").append(X_BH_Stocktake_v.Table_Name).append(" ");

		StringBuilder sqlJoin = new StringBuilder().append(" LEFT JOIN ").append(MWarehouse.Table_Name).append(" ON ")
				.append(MWarehouse.Table_Name + "." + MWarehouse.COLUMNNAME_M_Warehouse_ID).append(" = ")
				.append(X_BH_Stocktake_v.Table_Name + "." + X_BH_Stocktake_v.COLUMNNAME_M_Warehouse_ID).append(" ");

		StringBuilder sqlWhere = new StringBuilder().append("WHERE ")
				.append(X_BH_Stocktake_v.Table_Name + "." + X_BH_Stocktake_v.COLUMNNAME_AD_Client_ID).append(" =?")
				.append(AND_OPERATOR).append(X_BH_Stocktake_v.Table_Name + "." + X_BH_Stocktake_v.COLUMNNAME_AD_Org_ID)
				.append(" =?");

		List<Object> parameters = new ArrayList<>();
		parameters.add(Env.getAD_Client_ID(Env.getCtx()));
		parameters.add(Env.getAD_Org_ID(Env.getCtx()));

		sqlWhere.append(AND_OPERATOR)
				.append(FilterUtil.getWhereClauseFromFilter(X_BH_Stocktake_v.Table_Name, filterJson, parameters, true));

		if (searchValue != null && !searchValue.isEmpty()) {
			sqlWhere.append(AND_OPERATOR).append("LOWER(")
					.append(X_BH_Stocktake_v.Table_Name + "." + X_BH_Stocktake_v.COLUMNNAME_Product).append(") ")
					.append(LIKE_COMPARATOR).append(" ?");
			parameters.add("%" + searchValue.toLowerCase() + "%");
		}

		if (productId != null) {
			sqlWhere.append(AND_OPERATOR)
					.append(X_BH_Stocktake_v.Table_Name + "." + X_BH_Stocktake_v.COLUMNNAME_M_Product_ID)
					.append(EQUAL_OPERATOR).append(" ?");
			parameters.add(productId);
		}

		String sqlOrderBy = " order by " + (orderByClause == null ? getOrderByClause(null, null) : orderByClause);

		String sqlToUse = sqlSelect.append(sqlJoin).append(sqlWhere).append(sqlOrderBy).toString();

		if (pagingInfo.getPageSize() > 0) {
			if (DB.getDatabase().isPagingSupported()) {
				sqlToUse = DB.getDatabase().addPagingSQL(sqlToUse,
						(pagingInfo.getPageSize() * pagingInfo.getPage()) + 1,
						pagingInfo.getPageSize() * (pagingInfo.getPage() + 1));
			}
		}

		pagingInfo.setTotalRecordCount(getTotalRecordCount(sqlJoin.toString() + sqlWhere.toString(), parameters));
		SqlUtil.executeQuery(sqlToUse, parameters, null, resultSet -> {
			try {
				InventoryRecord inventoryRecord =
						new InventoryRecord(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
								DateUtil.parseDateOnly(resultSet.getTimestamp(4)), resultSet.getInt(5), resultSet.getInt(6),
								resultSet.getInt(7), resultSet.getInt(8), resultSet.getInt(9),
								DateUtil.parse(resultSet.getTimestamp(10)), resultSet.getInt(11), resultSet.getString(12));
				results.add(inventoryRecord);
			} catch (Exception ex) {
				log.warning("Error processing inventory items: " + ex.getMessage());
			}
		});

		// Batch other data calls
		Set<Integer> productIds =
				results.stream().map(InventoryRecord::getProductId).filter(inventoryProductId -> inventoryProductId > 0)
						.collect(Collectors.toSet());
		Map<Integer, MProduct_BH> productsById =
				productIds.isEmpty() ? new HashMap<>() : productDBService.getByIds(productIds);
		Set<Integer> attributeSetInstanceIds = results.stream().map(InventoryRecord::getAttributeSetInstanceId)
				.filter(attributeSetInstanceId -> attributeSetInstanceId > 0).collect(Collectors.toSet());
		Map<Integer, MAttributeSetInstance_BH> attributeSetInstancesById =
				attributeSetInstanceIds.isEmpty() ? new HashMap<>() :
						attributeSetInstanceDBService.getByIds(attributeSetInstanceIds);

		results.forEach(inventory -> {
			if (inventory.getProductId() > 0) {
				inventory.setProduct(new Product(productsById.get(inventory.getProductId())));
			}
			if (inventory.getAttributeSetInstanceId() > 0) {
				inventory.setAttributeSetInstanceUuid(
						attributeSetInstancesById.get(inventory.getAttributeSetInstanceId()).getM_AttributeSetInstance_UU());
			}
		});

		return new BaseListResponse<InventoryRecord>(results, pagingInfo);
	}

	/**
	 * Get Total Count
	 *
	 * @return
	 */
	private int getTotalRecordCount(String sqlWhere, List<Object> parameters) {
		return SqlUtil.getCount(X_BH_Stocktake_v.Table_Name, sqlWhere, parameters);
	}

	@Override
	public InventoryRecord saveEntity(InventoryRecord entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected InventoryRecord createInstanceWithDefaultFields(MInventoryLine_BH instance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected InventoryRecord createInstanceWithAllFields(MInventoryLine_BH instance) {
		InventoryRecord inventoryRecord = new InventoryRecord(instance);
//		 inventory.setShelfLife();
//		 inventory.setUpdateReasonUuid(DEFAULT_SEARCH_CLAUSE);
		return inventoryRecord;
	}

	@Override
	protected InventoryRecord createInstanceWithSearchFields(MInventoryLine_BH instance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected MInventoryLine_BH getModelInstance() {
		// TODO Auto-generated method stub
		return null;
	}


}