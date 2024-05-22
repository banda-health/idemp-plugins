package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MMatchInv;

/**
 * Generated Query Resolver for M_MatchInv - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_MatchInvQuery extends POQuery<MMatchInv> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MMatchInv.Table_Name;
	}

	public Connection<MMatchInv> M_MatchInvGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
