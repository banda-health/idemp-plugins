package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.M_Registration;

/**
 * Generated Query Resolver for AD_Registration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_RegistrationQuery extends POQuery<M_Registration> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return M_Registration.Table_Name;
	}

	public Connection<M_Registration> AD_RegistrationGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
