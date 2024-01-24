package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDepreciationWorkfile;

/**
 * Generated Query Resolver for A_Depreciation_Workfile - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Depreciation_WorkfileQuery extends POQuery<MDepreciationWorkfile> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDepreciationWorkfile.Table_Name;
	}

	public Connection<MDepreciationWorkfile> A_Depreciation_WorkfileGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
