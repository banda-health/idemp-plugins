package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_M_DemandDetail;

/**
 * Generated Query Resolver for M_DemandDetail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_DemandDetailQuery extends POQuery<X_M_DemandDetail> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_M_DemandDetail.Table_Name;
	}

	public Connection<X_M_DemandDetail> M_DemandDetailGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
