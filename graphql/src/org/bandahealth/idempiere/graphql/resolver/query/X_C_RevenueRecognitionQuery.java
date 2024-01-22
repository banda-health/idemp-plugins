package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRevenueRecognition;

/**
 * Generated Query Resolver for C_RevenueRecognition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_RevenueRecognitionQuery extends POQuery<MRevenueRecognition> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRevenueRecognition.Table_Name;
	}

	public Connection<MRevenueRecognition> C_RevenueRecognitionGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
