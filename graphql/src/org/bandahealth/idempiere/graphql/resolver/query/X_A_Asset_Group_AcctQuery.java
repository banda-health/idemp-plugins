package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAssetGroupAcct;

/**
 * Generated Query Resolver for A_Asset_Group_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_Group_AcctQuery extends POQuery<MAssetGroupAcct> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAssetGroupAcct.Table_Name;
	}

	public Connection<MAssetGroupAcct> A_Asset_Group_AcctGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
