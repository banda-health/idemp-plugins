package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAddressValidation;

/**
 * Generated Query Resolver for C_AddressValidation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_AddressValidationQuery extends POQuery<MAddressValidation> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAddressValidation.Table_Name;
	}

	public Connection<MAddressValidation> C_AddressValidationGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
