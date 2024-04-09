package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MViewComponent;

/**
 * Generated Query Resolver for AD_ViewComponent - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_ViewComponentQuery extends POQuery<MViewComponent> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MViewComponent.Table_Name;
	}

	public Connection<MViewComponent> AD_ViewComponentGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
