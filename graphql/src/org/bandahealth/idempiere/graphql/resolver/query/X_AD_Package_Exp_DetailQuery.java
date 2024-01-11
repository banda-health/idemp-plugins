package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPackageExpDetail;

/**
 * Generated Query Resolver for AD_Package_Exp_Detail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Package_Exp_DetailQuery extends POQuery<MPackageExpDetail> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPackageExpDetail.Table_Name;
	}

	public Connection<MPackageExpDetail> AD_Package_Exp_DetailGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
