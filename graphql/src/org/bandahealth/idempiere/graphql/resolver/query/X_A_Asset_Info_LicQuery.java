package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_A_Asset_Info_Lic;

/**
 * Generated Query Resolver for A_Asset_Info_Lic - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Asset_Info_LicQuery extends POQuery<X_A_Asset_Info_Lic> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_Info_Lic.Table_Name;
	}

	public Connection<X_A_Asset_Info_Lic> A_Asset_Info_LicGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
