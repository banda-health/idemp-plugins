package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.eevolution.model.X_I_HR_Movement;

/**
 * Generated Query Resolver for I_HR_Movement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_I_HR_MovementQuery extends POQuery<X_I_HR_Movement> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_I_HR_Movement.Table_Name;
	}

	public Connection<X_I_HR_Movement> I_HR_MovementGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
