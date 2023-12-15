package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.bandahealth.idempiere.graphql.model.PagingInfo;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.bandahealth.idempiere.graphql.utils.EntityConfiguration;

public class X_BH_VisitQuery extends POQuery<MBHVisit> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHVisit.Table_Name;
	}

	public Connection<MBHVisit> BH_VisitGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
