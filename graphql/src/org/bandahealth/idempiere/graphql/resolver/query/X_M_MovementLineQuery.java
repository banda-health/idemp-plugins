package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MMovementLine;

/**
 * Generated Query Resolver for M_MovementLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_MovementLineQuery extends POQuery<MMovementLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MMovementLine.Table_Name;
	}

	public Connection<MMovementLine> M_MovementLineGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
