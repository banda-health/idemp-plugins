package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MProjectType;

/**
 * Generated Query Resolver for C_ProjectType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_ProjectTypeQuery extends POQuery<MProjectType> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MProjectType.Table_Name;
	}

	public Connection<MProjectType> C_ProjectTypeGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
