package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDistributionRun;

/**
 * Generated Query Resolver for M_DistributionRun - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_DistributionRunQuery extends POQuery<MDistributionRun> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDistributionRun.Table_Name;
	}

	public Connection<MDistributionRun> M_DistributionRunGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
