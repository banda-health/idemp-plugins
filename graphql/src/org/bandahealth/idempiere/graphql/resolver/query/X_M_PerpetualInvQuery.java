package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_M_PerpetualInv;

/**
 * Generated Query Resolver for M_PerpetualInv - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_PerpetualInvQuery extends POQuery<X_M_PerpetualInv> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_M_PerpetualInv.Table_Name;
	}

	public Connection<X_M_PerpetualInv> M_PerpetualInvGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
