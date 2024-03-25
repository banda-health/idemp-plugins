package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAttributeUse;

/**
 * Generated Query Resolver for M_AttributeUse - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_AttributeUseQuery extends POQuery<MAttributeUse> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAttributeUse.Table_Name;
	}

	public Connection<MAttributeUse> M_AttributeUseGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
