package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MFreight;

/**
 * Generated Query Resolver for M_Freight - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_FreightQuery extends POQuery<MFreight> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MFreight.Table_Name;
	}

	public Connection<MFreight> M_FreightGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
