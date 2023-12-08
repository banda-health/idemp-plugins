package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.bandahealth.idempiere.graphql.model.PagingInfo;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.bandahealth.idempiere.graphql.utils.EntityConfiguration;

public class X_BH_VisitQuery implements GraphQLQueryResolver {
	public Connection<MBHVisit> BH_VisitGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return Repository.get(MBHVisit.Table_Name, new PagingInfo(page, pageSize), sort, filter, environment, null,
				new EntityConfiguration() {{
					setShouldUseContextClientId(true);
					setShouldFetchFromSystemClient(false);
				}});
	}
}
