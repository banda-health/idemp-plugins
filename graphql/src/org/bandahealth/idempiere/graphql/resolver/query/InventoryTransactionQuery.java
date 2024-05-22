package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.bandahealth.idempiere.graphql.model.FilterTableData;
import org.bandahealth.idempiere.graphql.model.InventoryTransaction;
import org.bandahealth.idempiere.graphql.model.PagingInfo;
import org.bandahealth.idempiere.graphql.utils.FilterUtil;
import org.bandahealth.idempiere.graphql.utils.QueryUtil;
import org.bandahealth.idempiere.graphql.utils.SortUtil;
import org.bandahealth.idempiere.graphql.utils.SqlUtil;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.util.DB;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InventoryTransactionQuery implements GraphQLQueryResolver {
	public Connection<InventoryTransaction> InventoryTransactionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		PagingInfo pagingInfo = new PagingInfo(Page, PageSize);
		String functionName = "bh_get_product_transactions";

		List<Object> parameters = new ArrayList<>();
		String whereClause =
				FilterUtil.getWhereClauseFromFilter(new FilterTableData(BandaGraphQLContext.getCtx(environment),
						functionName,
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
				), Filter, parameters);

		String orderByClause = "";
		if (!StringUtil.isNullOrEmpty(Sort)) {
			orderByClause = " ORDER BY " + SortUtil.getOrderByClauseFromSort(functionName, Sort);
		}

		// get total count without pagination parameters
		// If the paging info wasn't requested in the payload, don't do an extra DB call to get it
		if (QueryUtil.isTotalCountRequested(environment)) {
			pagingInfo.setTotalCount(
					SqlUtil.getCount(functionName + "(" + Env.getAD_Client_ID(Env.getCtx()) + ") WHERE ", whereClause,
							parameters));
		}

		List<InventoryTransaction> results = new ArrayList<>();
		// If the results weren't requested in the payload (say a consumer just wants to know the count of entities
		// matching a specified filter), don't do an extra DB call to get them
		if (QueryUtil.areResultsRequested(environment)) {
			//
			// If the total record count is less than what we'd get with our page parameters, reset the page
			if (pagingInfo.getPageSize() < 1) {
				pagingInfo.setPageSize(200);
			}
			// If the total record count is less than what we'd get with our page parameters, reset the page
			int firstRecordNumberOfRequestedPage = (pagingInfo.getPage() * pagingInfo.getPageSize()) + 1;
			if (pagingInfo.getTotalCount() != null && pagingInfo.getTotalCount() < firstRecordNumberOfRequestedPage) {
				pagingInfo.setPage(0);
			}
			//
			// set pagination params
			int pageSize = pagingInfo.getPageSize();
			int recordsToSkip = pagingInfo.getPage() * pageSize;
			String query = "SELECT created, m_transaction_id, c_order_id, m_movement_id, bh_visit_id, m_product_id, " +
					"m_locator_id, m_attributesetinstance_id, createdby, transaction_type, movementqty, " +
					"runningtotal_bylocator" + " FROM " + functionName + "(" + Env.getAD_Client_ID(Env.getCtx()) + ") WHERE " +
					whereClause + orderByClause;
			query = DB.getDatabase().addPagingSQL(query, recordsToSkip + 1, pageSize <= 0 ? 0 : recordsToSkip + pageSize);
			SqlUtil.executeQuery(query, parameters, null, resultSet -> {
				InventoryTransaction inventoryTransaction = new InventoryTransaction();
				//
				try {
					inventoryTransaction.setCreated(resultSet.getTimestamp(1));
					inventoryTransaction.setTransactionId(resultSet.getInt(2));
					inventoryTransaction.setOrderId(resultSet.getInt(3));
					inventoryTransaction.setMovementId(resultSet.getInt(4));
					inventoryTransaction.setVisitId(resultSet.getInt(5));
					inventoryTransaction.setProductId(resultSet.getInt(6));
					inventoryTransaction.setLocatorId(resultSet.getInt(7));
					inventoryTransaction.setAttributeSetInstanceId(resultSet.getInt(8));
					inventoryTransaction.setCreatedBy(resultSet.getInt(9));
					inventoryTransaction.setTransactionType(resultSet.getString(10));
					inventoryTransaction.setMovementQty(resultSet.getBigDecimal(11));
					inventoryTransaction.setRunningTotal(resultSet.getBigDecimal(12));
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
				//
				results.add(inventoryTransaction);
			});
		}

		return new Connection<>(results, pagingInfo);
	}
}
