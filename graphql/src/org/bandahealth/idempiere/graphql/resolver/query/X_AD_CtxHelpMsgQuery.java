package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCtxHelpMsg;

/**
 * Generated Query Resolver for AD_CtxHelpMsg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_CtxHelpMsgQuery extends POQuery<MCtxHelpMsg> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCtxHelpMsg.Table_Name;
	}

	public Connection<MCtxHelpMsg> AD_CtxHelpMsgGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
