package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDepreciation;

/**
 * Generated Query Resolver for A_Depreciation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_DepreciationQuery extends POQuery<MDepreciation> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDepreciation.Table_Name;
	}

	public Connection<MDepreciation> A_DepreciationGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
