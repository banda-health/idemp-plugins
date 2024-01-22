package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHProductCategoryDefault;
import org.bandahealth.idempiere.graphql.model.Connection;

/**
 * Generated Query Resolver for BH_Product_CategoryDefault - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_Product_CategoryDefaultQuery extends POQuery<MBHProductCategoryDefault> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHProductCategoryDefault.Table_Name;
	}

	public Connection<MBHProductCategoryDefault> BH_Product_CategoryDefaultGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
