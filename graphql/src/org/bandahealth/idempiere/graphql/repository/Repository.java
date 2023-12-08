package org.bandahealth.idempiere.graphql.repository;

import graphql.schema.DataFetchingEnvironment;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.bandahealth.idempiere.graphql.model.PagingInfo;
import org.bandahealth.idempiere.graphql.utils.EntityConfiguration;
import org.bandahealth.idempiere.graphql.utils.FilterUtil;
import org.bandahealth.idempiere.graphql.utils.QueryUtil;
import org.bandahealth.idempiere.graphql.utils.SortUtil;
import org.compiere.model.PO;
import org.compiere.model.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Repository {
	public static <T extends PO> Connection<T> get(String tableName, PagingInfo pagingInfo, String sort, String filter,
			DataFetchingEnvironment environment, String transactionName, EntityConfiguration entityConfiguration) {
		Properties idempiereContext = BandaGraphQLContext.getCtx(environment);
		try {
			List<Object> parameters = new ArrayList<>();
			String whereClause =
					FilterUtil.getWhereClauseFromFilter(tableName, filter, parameters, entityConfiguration, idempiereContext);
			Query query = new Query(idempiereContext, tableName, whereClause, transactionName).setParameters(parameters);

			String orderBy = SortUtil.getOrderByClauseFromSort(tableName, sort);
			if (orderBy != null) {
				query = query.setOrderBy(orderBy);
			}

			// If the paging info wasn't requested in the payload, don't do an extra DB call to get it
			if (QueryUtil.isTotalCountRequested(environment)) {
				// get total count without pagination parameters
				pagingInfo.setTotalCount(query.count());
			}

			List<T> results = new ArrayList<>();
			// If the results weren't requested in the payload (say a consumer just wants to know the count of entities
			// matching a specified filter), don't do an extra DB call to get them
			if (QueryUtil.areResultsRequested(environment)) {
				// set pagination params
				query = query.setPage(pagingInfo.getPageSize(), pagingInfo.getPage());
				results = query.list();
			}
			return new Connection<>(results, pagingInfo);
		} catch (Exception ex) {
			throw new AdempiereException(ex);
		}
	}
}
