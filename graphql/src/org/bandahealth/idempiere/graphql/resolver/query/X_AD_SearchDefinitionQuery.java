package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MSearchDefinition;

/**
 * Generated Query Resolver for AD_SearchDefinition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_SearchDefinitionQuery extends POQuery<MSearchDefinition> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MSearchDefinition.Table_Name;
	}

	public Connection<MSearchDefinition> AD_SearchDefinitionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
