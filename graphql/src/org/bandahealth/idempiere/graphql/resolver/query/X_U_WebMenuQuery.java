package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MWebMenu;

/**
 * Generated Query Resolver for U_WebMenu - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_U_WebMenuQuery extends POQuery<MWebMenu> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MWebMenu.Table_Name;
	}

	public Connection<MWebMenu> U_WebMenuGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
