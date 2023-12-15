package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.bandahealth.idempiere.graphql.model.PagingInfo;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.PO;

public abstract class POQuery<T extends PO> {
	protected abstract String getTableName();

	public Connection<MBHVisit> get(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return Repository.get(getTableName(), null, new PagingInfo(page, pageSize), sort, filter, environment);
	}
}
