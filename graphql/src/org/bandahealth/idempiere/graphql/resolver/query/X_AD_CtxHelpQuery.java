package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCtxHelp;

/**
 * Generated Query Resolver for AD_CtxHelp - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_CtxHelpQuery extends POQuery<MCtxHelp> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCtxHelp.Table_Name;
	}

	public Connection<MCtxHelp> AD_CtxHelpGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
