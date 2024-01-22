package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_InfoProcess;

/**
 * Generated Query Resolver for AD_InfoProcess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_InfoProcessQuery extends POQuery<X_AD_InfoProcess> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_InfoProcess.Table_Name;
	}

	public Connection<X_AD_InfoProcess> AD_InfoProcessGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
