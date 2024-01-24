package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MUserDefWin;

/**
 * Generated Query Resolver for AD_UserDef_Win - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_UserDef_WinQuery extends POQuery<MUserDefWin> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MUserDefWin.Table_Name;
	}

	public Connection<MUserDefWin> AD_UserDef_WinGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
