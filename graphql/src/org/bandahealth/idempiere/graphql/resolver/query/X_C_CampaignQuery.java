package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCampaign;

/**
 * Generated Query Resolver for C_Campaign - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_CampaignQuery extends POQuery<MCampaign> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCampaign.Table_Name;
	}

	public Connection<MCampaign> C_CampaignGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
