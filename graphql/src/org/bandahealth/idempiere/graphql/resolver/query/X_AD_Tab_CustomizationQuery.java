package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_Tab_Customization;

/**
 * Generated Query Resolver for AD_Tab_Customization - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_Tab_CustomizationQuery extends POQuery<X_AD_Tab_Customization> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_Tab_Customization.Table_Name;
	}

	public Connection<X_AD_Tab_Customization> AD_Tab_CustomizationGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
