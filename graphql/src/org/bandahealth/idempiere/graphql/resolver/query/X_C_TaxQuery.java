package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTax;

/**
 * Generated Query Resolver for C_Tax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_TaxQuery extends POQuery<MTax> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTax.Table_Name;
	}

	public Connection<MTax> C_TaxGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
