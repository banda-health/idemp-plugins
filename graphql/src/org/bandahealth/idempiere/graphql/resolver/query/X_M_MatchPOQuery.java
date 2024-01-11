package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MMatchPO;

/**
 * Generated Query Resolver for M_MatchPO - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_MatchPOQuery extends POQuery<MMatchPO> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MMatchPO.Table_Name;
	}

	public Connection<MMatchPO> M_MatchPOGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
