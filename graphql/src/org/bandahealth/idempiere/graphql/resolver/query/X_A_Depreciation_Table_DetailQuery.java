package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_A_Depreciation_Table_Detail;

/**
 * Generated Query Resolver for A_Depreciation_Table_Detail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Depreciation_Table_DetailQuery extends POQuery<X_A_Depreciation_Table_Detail> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_A_Depreciation_Table_Detail.Table_Name;
	}

	public Connection<X_A_Depreciation_Table_Detail> A_Depreciation_Table_DetailGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
