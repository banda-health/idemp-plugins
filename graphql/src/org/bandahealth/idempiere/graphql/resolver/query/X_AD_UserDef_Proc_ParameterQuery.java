package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MUserDefProcParameter;

/**
 * Generated Query Resolver for AD_UserDef_Proc_Parameter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_UserDef_Proc_ParameterQuery extends POQuery<MUserDefProcParameter> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MUserDefProcParameter.Table_Name;
	}

	public Connection<MUserDefProcParameter> AD_UserDef_Proc_ParameterGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
