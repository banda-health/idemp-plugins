package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MUserDefTab;

/**
 * Generated Query Resolver for AD_UserDef_Tab - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_UserDef_TabQuery extends POQuery<MUserDefTab> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MUserDefTab.Table_Name;
	}

	public Connection<MUserDefTab> AD_UserDef_TabGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
