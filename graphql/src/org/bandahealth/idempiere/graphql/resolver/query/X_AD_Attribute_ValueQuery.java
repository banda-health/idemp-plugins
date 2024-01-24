package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_Attribute_Value;

/**
 * Generated Query Resolver for AD_Attribute_Value - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Attribute_ValueQuery extends POQuery<X_AD_Attribute_Value> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_Attribute_Value.Table_Name;
	}

	public Connection<X_AD_Attribute_Value> AD_Attribute_ValueGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
