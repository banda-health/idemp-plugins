package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MOrg;

/**
 * Generated Query Resolver for AD_Org - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_OrgQuery extends POQuery<MOrg> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MOrg.Table_Name;
	}

	public Connection<MOrg> AD_OrgGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
