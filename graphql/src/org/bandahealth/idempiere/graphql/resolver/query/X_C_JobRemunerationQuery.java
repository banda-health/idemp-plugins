package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_JobRemuneration;

/**
 * Generated Query Resolver for C_JobRemuneration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_JobRemunerationQuery extends POQuery<X_C_JobRemuneration> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_JobRemuneration.Table_Name;
	}

	public Connection<X_C_JobRemuneration> C_JobRemunerationGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
