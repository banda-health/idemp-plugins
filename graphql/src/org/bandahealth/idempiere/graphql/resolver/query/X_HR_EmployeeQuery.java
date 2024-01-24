package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.eevolution.model.X_HR_Employee;

/**
 * Generated Query Resolver for HR_Employee - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_HR_EmployeeQuery extends POQuery<X_HR_Employee> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_HR_Employee.Table_Name;
	}

	public Connection<X_HR_Employee> HR_EmployeeGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
