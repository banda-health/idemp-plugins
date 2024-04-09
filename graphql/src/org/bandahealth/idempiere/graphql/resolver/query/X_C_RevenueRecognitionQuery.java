package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRevenueRecognition;

/**
 * Generated Query Resolver for C_RevenueRecognition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_RevenueRecognitionQuery extends POQuery<MRevenueRecognition> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRevenueRecognition.Table_Name;
	}

	public Connection<MRevenueRecognition> C_RevenueRecognitionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
