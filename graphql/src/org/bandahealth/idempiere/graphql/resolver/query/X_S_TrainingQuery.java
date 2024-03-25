package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_S_Training;

/**
 * Generated Query Resolver for S_Training - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_S_TrainingQuery extends POQuery<X_S_Training> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_S_Training.Table_Name;
	}

	public Connection<X_S_Training> S_TrainingGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
