package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRevenueRecognitionRun;

/**
 * Generated Query Resolver for C_RevenueRecognition_Run - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_RevenueRecognition_RunQuery extends POQuery<MRevenueRecognitionRun> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRevenueRecognitionRun.Table_Name;
	}

	public Connection<MRevenueRecognitionRun> C_RevenueRecognition_RunGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
