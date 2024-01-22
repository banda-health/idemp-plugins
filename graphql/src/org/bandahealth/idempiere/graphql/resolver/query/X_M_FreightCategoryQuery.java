package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MFreightCategory;

/**
 * Generated Query Resolver for M_FreightCategory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_FreightCategoryQuery extends POQuery<MFreightCategory> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MFreightCategory.Table_Name;
	}

	public Connection<MFreightCategory> M_FreightCategoryGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
