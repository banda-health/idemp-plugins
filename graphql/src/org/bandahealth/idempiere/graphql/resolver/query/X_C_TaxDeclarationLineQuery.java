package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTaxDeclarationLine;

/**
 * Generated Query Resolver for C_TaxDeclarationLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_TaxDeclarationLineQuery extends POQuery<MTaxDeclarationLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTaxDeclarationLine.Table_Name;
	}

	public Connection<MTaxDeclarationLine> C_TaxDeclarationLineGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
