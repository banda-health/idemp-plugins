package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_Sequence_No;

/**
 * Generated Query Resolver for AD_Sequence_No - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Sequence_NoQuery extends POQuery<X_AD_Sequence_No> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_Sequence_No.Table_Name;
	}

	public Connection<X_AD_Sequence_No> AD_Sequence_NoGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
