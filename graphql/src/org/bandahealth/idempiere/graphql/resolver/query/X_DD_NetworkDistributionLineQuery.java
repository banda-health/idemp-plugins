package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.eevolution.model.X_DD_NetworkDistributionLine;

/**
 * Generated Query Resolver for DD_NetworkDistributionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_DD_NetworkDistributionLineQuery extends POQuery<X_DD_NetworkDistributionLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_DD_NetworkDistributionLine.Table_Name;
	}

	public Connection<X_DD_NetworkDistributionLine> DD_NetworkDistributionLineGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
