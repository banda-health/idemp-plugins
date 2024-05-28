package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.bandahealth.idempiere.graphql.repository.Repository;

public class MDocTypeQuery extends X_C_DocTypeQuery {
	@Override
	public Connection<MDocType_BH> C_DocTypeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		Repository.setClientIdNeeded();
		var results = super.Get(Page, PageSize, Sort, Filter, environment);
		Repository.clearClientIdNeeded();
		return results;
	}
}
