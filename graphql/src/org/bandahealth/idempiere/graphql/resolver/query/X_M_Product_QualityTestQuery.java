package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_M_Product_QualityTest;

/**
 * Generated Query Resolver for M_Product_QualityTest - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_Product_QualityTestQuery extends POQuery<X_M_Product_QualityTest> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_M_Product_QualityTest.Table_Name;
	}

	public Connection<X_M_Product_QualityTest> M_Product_QualityTestGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
