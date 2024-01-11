package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MTabNavBtnTab;
import org.bandahealth.idempiere.graphql.model.Connection;

/**
 * Generated Query Resolver for BH_TabNavBtn_Tab - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_TabNavBtn_TabQuery extends POQuery<MTabNavBtnTab> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTabNavBtnTab.Table_Name;
	}

	public Connection<MTabNavBtnTab> BH_TabNavBtn_TabGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
