package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDistributionLine;

/**
 * Generated Query Resolver for GL_DistributionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_GL_DistributionLineQuery extends POQuery<MDistributionLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDistributionLine.Table_Name;
	}

	public Connection<MDistributionLine> GL_DistributionLineGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
