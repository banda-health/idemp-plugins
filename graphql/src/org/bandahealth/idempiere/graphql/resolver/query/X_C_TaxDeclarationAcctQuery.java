package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTaxDeclarationAcct;

/**
 * Generated Query Resolver for C_TaxDeclarationAcct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_TaxDeclarationAcctQuery extends POQuery<MTaxDeclarationAcct> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTaxDeclarationAcct.Table_Name;
	}

	public Connection<MTaxDeclarationAcct> C_TaxDeclarationAcctGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
