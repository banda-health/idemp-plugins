package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRequestCategory;

/**
 * Generated Query Resolver for R_Category - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_CategoryQuery extends POQuery<MRequestCategory> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRequestCategory.Table_Name;
	}

	public Connection<MRequestCategory> R_CategoryGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
