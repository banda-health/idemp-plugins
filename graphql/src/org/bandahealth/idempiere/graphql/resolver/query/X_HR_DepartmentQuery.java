package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.eevolution.model.X_HR_Department;

/**
 * Generated Query Resolver for HR_Department - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_HR_DepartmentQuery extends POQuery<X_HR_Department> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_HR_Department.Table_Name;
	}

	public Connection<X_HR_Department> HR_DepartmentGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
