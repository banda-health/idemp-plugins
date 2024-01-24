package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_Package_Imp_Detail;

/**
 * Generated Query Resolver for AD_Package_Imp_Detail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Package_Imp_DetailQuery extends POQuery<X_AD_Package_Imp_Detail> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_Package_Imp_Detail.Table_Name;
	}

	public Connection<X_AD_Package_Imp_Detail> AD_Package_Imp_DetailGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
