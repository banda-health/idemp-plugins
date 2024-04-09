package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDepreciationMethod;

/**
 * Generated Query Resolver for A_Depreciation_Method - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Depreciation_MethodQuery extends POQuery<MDepreciationMethod> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDepreciationMethod.Table_Name;
	}

	public Connection<MDepreciationMethod> A_Depreciation_MethodGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
