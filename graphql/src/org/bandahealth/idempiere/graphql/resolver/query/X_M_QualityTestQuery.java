package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MQualityTest;

/**
 * Generated Query Resolver for M_QualityTest - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_QualityTestQuery extends POQuery<MQualityTest> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MQualityTest.Table_Name;
	}

	public Connection<MQualityTest> M_QualityTestGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
