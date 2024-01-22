package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAttributeValue;

/**
 * Generated Query Resolver for M_AttributeValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_AttributeValueQuery extends POQuery<MAttributeValue> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAttributeValue.Table_Name;
	}

	public Connection<MAttributeValue> M_AttributeValueGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
