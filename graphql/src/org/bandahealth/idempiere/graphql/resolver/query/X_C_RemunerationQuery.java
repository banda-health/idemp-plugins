package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_Remuneration;

/**
 * Generated Query Resolver for C_Remuneration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_RemunerationQuery extends POQuery<X_C_Remuneration> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_Remuneration.Table_Name;
	}

	public Connection<X_C_Remuneration> C_RemunerationGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
