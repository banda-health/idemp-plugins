package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.eevolution.model.X_DD_NetworkDistribution;

/**
 * Generated Query Resolver for DD_NetworkDistribution - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_DD_NetworkDistributionQuery extends POQuery<X_DD_NetworkDistribution> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_DD_NetworkDistribution.Table_Name;
	}

	public Connection<X_DD_NetworkDistribution> DD_NetworkDistributionGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
