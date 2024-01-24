package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MMatchInv;

/**
 * Generated Query Resolver for M_MatchInv - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_MatchInvQuery extends POQuery<MMatchInv> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MMatchInv.Table_Name;
	}

	public Connection<MMatchInv> M_MatchInvGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
