package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.eevolution.model.X_HR_Contract;

/**
 * Generated Query Resolver for HR_Contract - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_HR_ContractQuery extends POQuery<X_HR_Contract> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_HR_Contract.Table_Name;
	}

	public Connection<X_HR_Contract> HR_ContractGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
