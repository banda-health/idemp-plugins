package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MGLCategory;

/**
 * Generated Query Resolver for GL_Category - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_GL_CategoryQuery extends POQuery<MGLCategory> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MGLCategory.Table_Name;
	}

	public Connection<MGLCategory> GL_CategoryGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
