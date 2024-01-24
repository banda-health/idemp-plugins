package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_M_AttributeSetExclude;

/**
 * Generated Query Resolver for M_AttributeSetExclude - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_AttributeSetExcludeQuery extends POQuery<X_M_AttributeSetExclude> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_M_AttributeSetExclude.Table_Name;
	}

	public Connection<X_M_AttributeSetExclude> M_AttributeSetExcludeGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
