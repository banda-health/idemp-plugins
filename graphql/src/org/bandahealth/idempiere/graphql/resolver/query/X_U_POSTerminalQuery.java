package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPOSTerminal;

/**
 * Generated Query Resolver for U_POSTerminal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_U_POSTerminalQuery extends POQuery<MPOSTerminal> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPOSTerminal.Table_Name;
	}

	public Connection<MPOSTerminal> U_POSTerminalGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
