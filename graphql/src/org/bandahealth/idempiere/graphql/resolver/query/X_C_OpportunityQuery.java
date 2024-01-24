package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MOpportunity;

/**
 * Generated Query Resolver for C_Opportunity - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_OpportunityQuery extends POQuery<MOpportunity> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MOpportunity.Table_Name;
	}

	public Connection<MOpportunity> C_OpportunityGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
