package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MStatusCategory;

/**
 * Generated Query Resolver for R_StatusCategory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_StatusCategoryQuery extends POQuery<MStatusCategory> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MStatusCategory.Table_Name;
	}

	public Connection<MStatusCategory> R_StatusCategoryGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
