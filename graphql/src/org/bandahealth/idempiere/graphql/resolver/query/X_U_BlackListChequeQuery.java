package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MBlackListCheque;

/**
 * Generated Query Resolver for U_BlackListCheque - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_U_BlackListChequeQuery extends POQuery<MBlackListCheque> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBlackListCheque.Table_Name;
	}

	public Connection<MBlackListCheque> U_BlackListChequeGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
