package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MElement;

/**
 * Generated Query Resolver for C_Element - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_ElementQuery extends POQuery<MElement> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MElement.Table_Name;
	}

	public Connection<MElement> C_ElementGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
