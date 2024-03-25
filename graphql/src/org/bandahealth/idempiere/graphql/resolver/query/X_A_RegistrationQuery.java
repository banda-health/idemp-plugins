package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRegistration;

/**
 * Generated Query Resolver for A_Registration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_RegistrationQuery extends POQuery<MRegistration> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRegistration.Table_Name;
	}

	public Connection<MRegistration> A_RegistrationGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
