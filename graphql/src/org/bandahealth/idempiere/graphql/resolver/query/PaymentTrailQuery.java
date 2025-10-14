package org.bandahealth.idempiere.graphql.resolver.query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.bandahealth.idempiere.graphql.model.FilterTableData;
import org.bandahealth.idempiere.graphql.model.PagingInfo;
import org.bandahealth.idempiere.graphql.model.PaymentTrail;
import org.bandahealth.idempiere.graphql.utils.FilterUtil;
import org.bandahealth.idempiere.graphql.utils.QueryUtil;
import org.bandahealth.idempiere.graphql.utils.SortUtil;
import org.bandahealth.idempiere.graphql.utils.SqlUtil;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.SystemIDs;
import org.compiere.util.DB;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.compiere.util.Env;

public class PaymentTrailQuery implements GraphQLQueryResolver {

	public Connection<PaymentTrail> PaymentTrailGet(int Page, int PageSize, String Sort,
			String Filter, DataFetchingEnvironment environment) {
		PagingInfo pagingInfo = new PagingInfo(Page, PageSize);
		String functionName = "bh_get_payment_trail";
		List<Object> parameters = new ArrayList<>();

		// validate filter
		String whereClause =
				FilterUtil.getWhereClauseFromFilter(new FilterTableData(BandaGraphQLContext.getCtx(environment),
						functionName,
						Map.ofEntries(
								Map.entry("ad_client_id", SystemIDs.REFERENCE_DATATYPE_INTEGER),
								Map.entry("bh_visit_id", SystemIDs.REFERENCE_DATATYPE_INTEGER),
								Map.entry("c_invoice_id", SystemIDs.REFERENCE_DATATYPE_INTEGER),
								Map.entry("c_bpartner_id", SystemIDs.REFERENCE_DATATYPE_INTEGER),
								Map.entry("c_payment_id", SystemIDs.REFERENCE_DATATYPE_INTEGER),
								Map.entry("date", SystemIDs.REFERENCE_DATATYPE_DATETIME),
								Map.entry("created", SystemIDs.REFERENCE_DATATYPE_DATETIME),
								Map.entry("updated", SystemIDs.REFERENCE_DATATYPE_DATETIME),
								Map.entry("ordering_date", SystemIDs.REFERENCE_DATATYPE_DATETIME),
								Map.entry("createdby", SystemIDs.REFERENCE_DATATYPE_INTEGER),
								Map.entry("c_order_id", SystemIDs.REFERENCE_DATATYPE_INTEGER),
								Map.entry("charged", SystemIDs.REFERENCE_DATATYPE_AMOUNT),
								Map.entry("paid", SystemIDs.REFERENCE_DATATYPE_AMOUNT),
								Map.entry("open_balance", SystemIDs.REFERENCE_DATATYPE_AMOUNT),
								Map.entry("base_reversal_c_invoice_id", SystemIDs.REFERENCE_DATATYPE_INTEGER),
								Map.entry("base_reversal_c_payment_id", SystemIDs.REFERENCE_DATATYPE_INTEGER)
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

		List<PaymentTrail> results = new ArrayList<>();
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
					"SELECT ad_client_id, c_invoice_id, c_bpartner_id, c_payment_id, date, created, updated, createdby, " +
							"c_order_id, charged, paid, open_balance, base_reversal_c_invoice_id, base_reversal_c_payment_id, " +
							"ordering_date, bh_visit_id FROM " + functionName + "(" + Env.getAD_Client_ID(Env.getCtx()) + ") WHERE " +
							whereClause + orderByClause;
			query = DB.getDatabase().addPagingSQL(query, recordsToSkip + 1, pageSize <= 0 ? 0 : recordsToSkip + pageSize);
			SqlUtil.executeQuery(query, parameters, null, resultSet -> {
				PaymentTrail result = new PaymentTrail();
				//
				try {
					result.setClientId(resultSet.getInt(1));
					result.setInvoiceId(resultSet.getInt(2));
					result.setBusinessPartnerId(resultSet.getInt(3));
					result.setPaymentId(resultSet.getInt(4));
					result.setDate(resultSet.getTimestamp(5));
					result.setCreated(resultSet.getTimestamp(6));
					result.setUpdated(resultSet.getTimestamp(7));
					result.setCreatedBy(resultSet.getInt(8));
					result.setOrderId(resultSet.getInt(9));
					result.setCharged(resultSet.getBigDecimal(10));
					result.setPaid(resultSet.getBigDecimal(11));
					result.setOpenBalance(resultSet.getBigDecimal(12));
					result.setBaseReversalInvoiceId(resultSet.getInt(13));
					result.setBaseReversalPaymentId(resultSet.getInt(14));
					result.setOrderingDate(resultSet.getTimestamp(15));
					result.setVisitId(resultSet.getInt(16));
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
				//
				results.add(result);
			});
		}

		return new Connection<>(results, pagingInfo);
	}
}
