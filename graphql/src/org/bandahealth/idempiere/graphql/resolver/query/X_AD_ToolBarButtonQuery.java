package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MToolBarButton;

/**
 * Generated Query Resolver for AD_ToolBarButton - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_ToolBarButtonQuery extends POQuery<MToolBarButton> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MToolBarButton.Table_Name;
	}

	public Connection<MToolBarButton> AD_ToolBarButtonGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
