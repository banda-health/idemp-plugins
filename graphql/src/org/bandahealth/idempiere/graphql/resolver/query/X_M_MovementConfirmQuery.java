package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MMovementConfirm;

/**
 * Generated Query Resolver for M_MovementConfirm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_MovementConfirmQuery extends POQuery<MMovementConfirm> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MMovementConfirm.Table_Name;
	}

	public Connection<MMovementConfirm> M_MovementConfirmGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
