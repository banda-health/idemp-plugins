package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MUserOrgAccess;

/**
 * Generated Query Resolver for AD_User_OrgAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_User_OrgAccessQuery extends POQuery<MUserOrgAccess> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MUserOrgAccess.Table_Name;
	}

	public Connection<MUserOrgAccess> AD_User_OrgAccessGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
