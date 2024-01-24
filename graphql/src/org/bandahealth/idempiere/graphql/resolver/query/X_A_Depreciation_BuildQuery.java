package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDepreciationBuild;

/**
 * Generated Query Resolver for A_Depreciation_Build - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Depreciation_BuildQuery extends POQuery<MDepreciationBuild> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDepreciationBuild.Table_Name;
	}

	public Connection<MDepreciationBuild> A_Depreciation_BuildGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
