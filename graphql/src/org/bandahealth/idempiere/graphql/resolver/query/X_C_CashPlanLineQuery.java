package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCashPlanLine;

/**
 * Generated Query Resolver for C_CashPlanLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_CashPlanLineQuery extends POQuery<MCashPlanLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCashPlanLine.Table_Name;
	}

	public Connection<MCashPlanLine> C_CashPlanLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
