package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_User_Substitute;

/**
 * Generated Query Resolver for AD_User_Substitute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_User_SubstituteQuery extends POQuery<X_AD_User_Substitute> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_User_Substitute.Table_Name;
	}

	public Connection<X_AD_User_Substitute> AD_User_SubstituteGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
