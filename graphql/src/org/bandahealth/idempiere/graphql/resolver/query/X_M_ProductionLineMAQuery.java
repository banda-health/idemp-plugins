package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MProductionLineMA;

/**
 * Generated Query Resolver for M_ProductionLineMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_ProductionLineMAQuery extends POQuery<MProductionLineMA> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MProductionLineMA.Table_Name;
	}

	public Connection<MProductionLineMA> M_ProductionLineMAGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
