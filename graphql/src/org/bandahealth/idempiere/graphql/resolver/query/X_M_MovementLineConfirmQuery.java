package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MMovementLineConfirm;

/**
 * Generated Query Resolver for M_MovementLineConfirm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_MovementLineConfirmQuery extends POQuery<MMovementLineConfirm> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MMovementLineConfirm.Table_Name;
	}

	public Connection<MMovementLineConfirm> M_MovementLineConfirmGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
