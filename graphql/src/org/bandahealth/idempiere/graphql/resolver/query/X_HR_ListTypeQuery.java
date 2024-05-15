package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.eevolution.model.X_HR_ListType;

/**
 * Generated Query Resolver for HR_ListType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_HR_ListTypeQuery extends POQuery<X_HR_ListType> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_HR_ListType.Table_Name;
	}

	public Connection<X_HR_ListType> HR_ListTypeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
