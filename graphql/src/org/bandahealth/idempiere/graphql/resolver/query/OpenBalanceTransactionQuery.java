package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.bandahealth.idempiere.graphql.model.FilterTableData;
import org.bandahealth.idempiere.graphql.model.InventoryTransaction;
import org.bandahealth.idempiere.graphql.model.OpenBalanceTransaction;
import org.bandahealth.idempiere.graphql.model.PagingInfo;
import org.bandahealth.idempiere.graphql.utils.FilterUtil;
import org.bandahealth.idempiere.graphql.utils.QueryUtil;
import org.bandahealth.idempiere.graphql.utils.SortUtil;
import org.bandahealth.idempiere.graphql.utils.SqlUtil;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.SystemIDs;
import org.compiere.util.DB;
import org.compiere.util.Env;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OpenBalanceTransactionQuery implements GraphQLQueryResolver {
	public Connection<OpenBalanceTransaction> OpenBalanceTransactionGet(int Page, int PageSize, String Sort,
			String Filter,
			DataFetchingEnvironment environment) {
		PagingInfo pagingInfo = new PagingInfo(Page, PageSize);
		String functionName = "bh_get_bpartner_balance_transactions";

		List<Object> parameters = new ArrayList<>();
		String whereClause =
				FilterUtil.getWhereClauseFromFilter(new FilterTableData(BandaGraphQLContext.getCtx(environment),
						functionName,
						Map.ofEntries(
								Map.entry("ad_client_id", SystemIDs.REFERENCE_DATATYPE_INTEGER),
								Map.entry("c_invoice_id", SystemIDs.REFERENCE_DATATYPE_INTEGER),
								Map.entry("c_bpartner_id", SystemIDs.REFERENCE_DATATYPE_INTEGER),
								Map.entry("c_payment_id", SystemIDs.REFERENCE_DATATYPE_INTEGER),
								Map.entry("amount", SystemIDs.REFERENCE_DATATYPE_AMOUNT),
								Map.entry("bh_visit_id", SystemIDs.REFERENCE_DATATYPE_INTEGER),
								Map.entry("date", SystemIDs.REFERENCE_DATATYPE_DATETIME),
								Map.entry("created", SystemIDs.REFERENCE_DATATYPE_DATETIME),
								Map.entry("updated", SystemIDs.REFERENCE_DATATYPE_DATETIME),
								Map.entry("createdby", SystemIDs.REFERENCE_DATATYPE_INTEGER),
								Map.entry("open_balance", SystemIDs.REFERENCE_DATATYPE_AMOUNT)
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

		List<OpenBalanceTransaction> results = new ArrayList<>();
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
			String query =
					"SELECT ad_client_id, c_invoice_id, c_bpartner_id, c_payment_id, amount, bh_visit_id, date, created, " +
							"updated, createdby, open_balance FROM " + functionName + "(" + Env.getAD_Client_ID(Env.getCtx()) +
							") WHERE " + whereClause + orderByClause;
			query = DB.getDatabase().addPagingSQL(query, recordsToSkip + 1, pageSize <= 0 ? 0 : recordsToSkip + pageSize);
			SqlUtil.executeQuery(query, parameters, null, resultSet -> {
				OpenBalanceTransaction openBalanceTransaction = new OpenBalanceTransaction();
				//
				try {
					openBalanceTransaction.setClientId(resultSet.getInt(1));
					openBalanceTransaction.setInvoiceId(resultSet.getInt(2));
					openBalanceTransaction.setBusinessPartnerId(resultSet.getInt(3));
					openBalanceTransaction.setPaymentId(resultSet.getInt(4));
					openBalanceTransaction.setAmount(resultSet.getBigDecimal(5));
					openBalanceTransaction.setVisitId(resultSet.getInt(6));
					openBalanceTransaction.setDate(resultSet.getTimestamp(7));
					openBalanceTransaction.setCreated(resultSet.getTimestamp(8));
					openBalanceTransaction.setUpdated(resultSet.getTimestamp(9));
					openBalanceTransaction.setCreatedBy(resultSet.getInt(10));
					openBalanceTransaction.setOpenBalance(resultSet.getBigDecimal(11));
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
				//
				results.add(openBalanceTransaction);
			});
		}

		return new Connection<>(results, pagingInfo);
	}
}
