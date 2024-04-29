package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MMovementLineMA;

/**
 * Generated Query Resolver for M_MovementLineMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_MovementLineMAQuery extends POQuery<MMovementLineMA> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MMovementLineMA.Table_Name;
	}

	public Connection<MMovementLineMA> M_MovementLineMAGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
