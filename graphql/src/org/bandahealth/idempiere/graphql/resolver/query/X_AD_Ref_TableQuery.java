package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRefTable;

/**
 * Generated Query Resolver for AD_Ref_Table - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Ref_TableQuery extends POQuery<MRefTable> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRefTable.Table_Name;
	}

	public Connection<MRefTable> AD_Ref_TableGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
