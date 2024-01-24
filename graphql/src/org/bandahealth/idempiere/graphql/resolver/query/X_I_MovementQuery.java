package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.eevolution.model.X_I_Movement;

/**
 * Generated Query Resolver for I_Movement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_I_MovementQuery extends POQuery<X_I_Movement> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_I_Movement.Table_Name;
	}

	public Connection<X_I_Movement> I_MovementGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
