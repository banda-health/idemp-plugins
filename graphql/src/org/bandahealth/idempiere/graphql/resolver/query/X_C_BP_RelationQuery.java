package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_BP_Relation;

/**
 * Generated Query Resolver for C_BP_Relation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_BP_RelationQuery extends POQuery<X_C_BP_Relation> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_BP_Relation.Table_Name;
	}

	public Connection<X_C_BP_Relation> C_BP_RelationGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
