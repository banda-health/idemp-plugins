package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAssetAcct;

/**
 * Generated Query Resolver for A_Asset_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Asset_AcctQuery extends POQuery<MAssetAcct> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAssetAcct.Table_Name;
	}

	public Connection<MAssetAcct> A_Asset_AcctGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
