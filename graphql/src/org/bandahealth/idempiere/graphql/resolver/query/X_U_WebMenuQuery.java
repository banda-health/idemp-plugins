package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MWebMenu;

/**
 * Generated Query Resolver for U_WebMenu - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_U_WebMenuQuery extends POQuery<MWebMenu> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MWebMenu.Table_Name;
	}

	public Connection<MWebMenu> U_WebMenuGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
