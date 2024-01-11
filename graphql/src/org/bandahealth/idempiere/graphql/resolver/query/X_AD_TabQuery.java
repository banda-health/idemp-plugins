package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTab;

/**
 * Generated Query Resolver for AD_Tab - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_TabQuery extends POQuery<MTab> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTab.Table_Name;
	}

	public Connection<MTab> AD_TabGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
