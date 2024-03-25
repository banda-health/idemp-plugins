package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTaxDeclaration;

/**
 * Generated Query Resolver for C_TaxDeclaration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_TaxDeclarationQuery extends POQuery<MTaxDeclaration> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTaxDeclaration.Table_Name;
	}

	public Connection<MTaxDeclaration> C_TaxDeclarationGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
