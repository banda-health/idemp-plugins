package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MUserDefProc;

/**
 * Generated Query Resolver for AD_UserDef_Proc - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_UserDef_ProcQuery extends POQuery<MUserDefProc> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MUserDefProc.Table_Name;
	}

	public Connection<MUserDefProc> AD_UserDef_ProcGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
