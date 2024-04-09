package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_AddressValidationCfg;

/**
 * Generated Query Resolver for C_AddressValidationCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_AddressValidationCfgQuery extends POQuery<X_C_AddressValidationCfg> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_AddressValidationCfg.Table_Name;
	}

	public Connection<X_C_AddressValidationCfg> C_AddressValidationCfgGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
