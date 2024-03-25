package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_A_Depreciation_Table_Header;

/**
 * Generated Query Resolver for A_Depreciation_Table_Header - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Depreciation_Table_HeaderQuery extends POQuery<X_A_Depreciation_Table_Header> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_A_Depreciation_Table_Header.Table_Name;
	}

	public Connection<X_A_Depreciation_Table_Header> A_Depreciation_Table_HeaderGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
