package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDistributionRunDetail;

/**
 * Generated Query Resolver for T_DistributionRunDetail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_T_DistributionRunDetailQuery extends POQuery<MDistributionRunDetail> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDistributionRunDetail.Table_Name;
	}

	public Connection<MDistributionRunDetail> T_DistributionRunDetailGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
