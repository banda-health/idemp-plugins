package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDistributionRunLine;

/**
 * Generated Query Resolver for M_DistributionRunLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_DistributionRunLineQuery extends POQuery<MDistributionRunLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDistributionRunLine.Table_Name;
	}

	public Connection<MDistributionRunLine> M_DistributionRunLineGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
