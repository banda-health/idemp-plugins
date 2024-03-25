package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_T_BOM_Indented;

/**
 * Generated Query Resolver for T_BOM_Indented - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_T_BOM_IndentedQuery extends POQuery<X_T_BOM_Indented> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_T_BOM_Indented.Table_Name;
	}

	public Connection<X_T_BOM_Indented> T_BOM_IndentedGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
