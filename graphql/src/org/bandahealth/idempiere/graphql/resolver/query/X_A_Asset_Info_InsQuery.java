package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_A_Asset_Info_Ins;

/**
 * Generated Query Resolver for A_Asset_Info_Ins - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_Info_InsQuery extends POQuery<X_A_Asset_Info_Ins> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_Info_Ins.Table_Name;
	}

	public Connection<X_A_Asset_Info_Ins> A_Asset_Info_InsGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
