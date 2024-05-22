package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDepreciationExp;

/**
 * Generated Query Resolver for A_Depreciation_Exp - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Depreciation_ExpQuery extends POQuery<MDepreciationExp> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDepreciationExp.Table_Name;
	}

	public Connection<MDepreciationExp> A_Depreciation_ExpGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
