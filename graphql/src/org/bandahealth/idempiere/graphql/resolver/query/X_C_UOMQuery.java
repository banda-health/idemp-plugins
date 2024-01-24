package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MUOM;

/**
 * Generated Query Resolver for C_UOM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_UOMQuery extends POQuery<MUOM> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MUOM.Table_Name;
	}

	public Connection<MUOM> C_UOMGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
