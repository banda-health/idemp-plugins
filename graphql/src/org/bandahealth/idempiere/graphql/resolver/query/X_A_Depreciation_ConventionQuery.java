package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDepreciationConvention;

/**
 * Generated Query Resolver for A_Depreciation_Convention - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Depreciation_ConventionQuery extends POQuery<MDepreciationConvention> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDepreciationConvention.Table_Name;
	}

	public Connection<MDepreciationConvention> A_Depreciation_ConventionGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
