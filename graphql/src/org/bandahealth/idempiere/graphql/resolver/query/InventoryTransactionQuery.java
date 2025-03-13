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
import org.compiere.model.SystemIDs;
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
								Map.entry("created", SystemIDs.REFERENCE_DATATYPE_DATETIME),
								Map.entry("m_transaction_id", SystemIDs.REFERENCE_DATATYPE_INTEGER),
								Map.entry("c_order_id", SystemIDs.REFERENCE_DATATYPE_INTEGER),
								Map.entry("m_movement_id", SystemIDs.REFERENCE_DATATYPE_INTEGER),
								Map.entry("bh_visit_id", SystemIDs.REFERENCE_DATATYPE_INTEGER),
								Map.entry("m_product_id", SystemIDs.REFERENCE_DATATYPE_INTEGER),
								Map.entry("m_locator_id", SystemIDs.REFERENCE_DATATYPE_INTEGER),
								Map.entry("m_attributesetinstance_id", SystemIDs.REFERENCE_DATATYPE_INTEGER),
								Map.entry("createdby", SystemIDs.REFERENCE_DATATYPE_INTEGER),
								Map.entry("transaction_type", SystemIDs.REFERENCE_DATATYPE_STRING),
								Map.entry("movementqty", SystemIDs.REFERENCE_DATATYPE_AMOUNT),
								Map.entry("runningtotal_bylocator", SystemIDs.REFERENCE_DATATYPE_AMOUNT)
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
