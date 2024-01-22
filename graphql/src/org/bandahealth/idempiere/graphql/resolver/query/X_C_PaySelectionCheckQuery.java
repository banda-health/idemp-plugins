package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPaySelectionCheck;

/**
 * Generated Query Resolver for C_PaySelectionCheck - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_PaySelectionCheckQuery extends POQuery<MPaySelectionCheck> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPaySelectionCheck.Table_Name;
	}

	public Connection<MPaySelectionCheck> C_PaySelectionCheckGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
