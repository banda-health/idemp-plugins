package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_A_RegistrationAttribute;

/**
 * Generated Query Resolver for A_RegistrationAttribute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_RegistrationAttributeQuery extends POQuery<X_A_RegistrationAttribute> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_A_RegistrationAttribute.Table_Name;
	}

	public Connection<X_A_RegistrationAttribute> A_RegistrationAttributeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
