package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_ASP_Module;

/**
 * Generated Query Resolver for ASP_Module - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_ASP_ModuleQuery extends POQuery<X_ASP_Module> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_ASP_Module.Table_Name;
	}

	public Connection<X_ASP_Module> ASP_ModuleGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
