package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRegistrationAttribute;

/**
 * Generated Query Resolver for A_RegistrationAttribute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_RegistrationAttributeQuery extends POQuery<MRegistrationAttribute> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRegistrationAttribute.Table_Name;
	}

	public Connection<MRegistrationAttribute> A_RegistrationAttributeGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
