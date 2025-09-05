package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.bandahealth.idempiere.graphql.model.PagingInfo;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.PO;

import java.util.List;

public abstract class POQuery<T extends PO> {
	protected abstract String getTableName();

	public Connection<T> Get(int page, int pageSize, String sort, String filter, String where, List<Object> parameters,
			DataFetchingEnvironment environment) {
		return Repository.get(getTableName(), null, new PagingInfo(page, pageSize), sort, filter,
				Repository.parseApiWhereClauseAndParameters(where, parameters), parameters, null, environment);
	}
}
