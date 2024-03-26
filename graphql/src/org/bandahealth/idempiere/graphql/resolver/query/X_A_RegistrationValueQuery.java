package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_A_RegistrationValue;

/**
 * Generated Query Resolver for A_RegistrationValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_RegistrationValueQuery extends POQuery<X_A_RegistrationValue> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_A_RegistrationValue.Table_Name;
	}

	public Connection<X_A_RegistrationValue> A_RegistrationValueGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
