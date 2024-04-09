package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPackageExpDetail;

/**
 * Generated Query Resolver for AD_Package_Exp_Detail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Package_Exp_DetailQuery extends POQuery<MPackageExpDetail> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPackageExpDetail.Table_Name;
	}

	public Connection<MPackageExpDetail> AD_Package_Exp_DetailGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
