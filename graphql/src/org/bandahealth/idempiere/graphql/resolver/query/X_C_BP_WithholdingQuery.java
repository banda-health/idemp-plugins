package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_BP_Withholding;

/**
 * Generated Query Resolver for C_BP_Withholding - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_BP_WithholdingQuery extends POQuery<X_C_BP_Withholding> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_BP_Withholding.Table_Name;
	}

	public Connection<X_C_BP_Withholding> C_BP_WithholdingGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
