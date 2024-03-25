package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.eevolution.model.X_HR_Attribute;

/**
 * Generated Query Resolver for HR_Attribute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_HR_AttributeQuery extends POQuery<X_HR_Attribute> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_HR_Attribute.Table_Name;
	}

	public Connection<X_HR_Attribute> HR_AttributeGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
