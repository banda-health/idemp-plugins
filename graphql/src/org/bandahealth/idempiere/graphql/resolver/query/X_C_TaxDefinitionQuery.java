package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.eevolution.model.X_C_TaxDefinition;

/**
 * Generated Query Resolver for C_TaxDefinition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_TaxDefinitionQuery extends POQuery<X_C_TaxDefinition> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_TaxDefinition.Table_Name;
	}

	public Connection<X_C_TaxDefinition> C_TaxDefinitionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
