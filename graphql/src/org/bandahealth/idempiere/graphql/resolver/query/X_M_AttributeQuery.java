package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAttribute;

/**
 * Generated Query Resolver for M_Attribute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_AttributeQuery extends POQuery<MAttribute> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAttribute.Table_Name;
	}

	public Connection<MAttribute> M_AttributeGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
