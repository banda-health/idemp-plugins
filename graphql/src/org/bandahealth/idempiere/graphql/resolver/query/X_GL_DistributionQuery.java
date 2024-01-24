package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDistribution;

/**
 * Generated Query Resolver for GL_Distribution - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_GL_DistributionQuery extends POQuery<MDistribution> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDistribution.Table_Name;
	}

	public Connection<MDistribution> GL_DistributionGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
