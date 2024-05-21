package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_ASP_Ref_List;

/**
 * Generated Query Resolver for ASP_Ref_List - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_ASP_Ref_ListQuery extends POQuery<X_ASP_Ref_List> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_ASP_Ref_List.Table_Name;
	}

	public Connection<X_ASP_Ref_List> ASP_Ref_ListGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
