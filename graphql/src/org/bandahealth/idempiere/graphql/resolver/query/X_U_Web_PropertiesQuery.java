package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MWebProperties;

/**
 * Generated Query Resolver for U_Web_Properties - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_U_Web_PropertiesQuery extends POQuery<MWebProperties> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MWebProperties.Table_Name;
	}

	public Connection<MWebProperties> U_Web_PropertiesGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
