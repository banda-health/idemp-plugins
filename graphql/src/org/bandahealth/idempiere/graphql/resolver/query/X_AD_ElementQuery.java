package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.M_Element;

/**
 * Generated Query Resolver for AD_Element - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_ElementQuery extends POQuery<M_Element> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return M_Element.Table_Name;
	}

	public Connection<M_Element> AD_ElementGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
