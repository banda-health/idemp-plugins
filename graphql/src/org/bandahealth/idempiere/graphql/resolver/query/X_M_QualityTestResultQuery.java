package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MQualityTestResult;

/**
 * Generated Query Resolver for M_QualityTestResult - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_QualityTestResultQuery extends POQuery<MQualityTestResult> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MQualityTestResult.Table_Name;
	}

	public Connection<MQualityTestResult> M_QualityTestResultGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
