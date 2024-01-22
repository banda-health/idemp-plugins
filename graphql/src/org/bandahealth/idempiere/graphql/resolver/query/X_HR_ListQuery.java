package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.eevolution.model.X_HR_List;

/**
 * Generated Query Resolver for HR_List - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_HR_ListQuery extends POQuery<X_HR_List> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_HR_List.Table_Name;
	}

	public Connection<X_HR_List> HR_ListGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
