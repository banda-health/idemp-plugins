package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MUserDefWin;

/**
 * Generated Query Resolver for AD_UserDef_Win - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_UserDef_WinQuery extends POQuery<MUserDefWin> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MUserDefWin.Table_Name;
	}

	public Connection<MUserDefWin> AD_UserDef_WinGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
