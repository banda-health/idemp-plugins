package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MProductionLine;

/**
 * Generated Query Resolver for M_ProductionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_ProductionLineQuery extends POQuery<MProductionLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MProductionLine.Table_Name;
	}

	public Connection<MProductionLine> M_ProductionLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
