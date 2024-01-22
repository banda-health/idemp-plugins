package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MLot;

/**
 * Generated Query Resolver for M_Lot - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_LotQuery extends POQuery<MLot> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MLot.Table_Name;
	}

	public Connection<MLot> M_LotGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
