package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.X_BH_I_Product_Quantity;
import org.bandahealth.idempiere.graphql.model.Connection;

/**
 * Generated Query Resolver for BH_I_Product_Quantity - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_I_Product_QuantityQuery extends POQuery<X_BH_I_Product_Quantity> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_BH_I_Product_Quantity.Table_Name;
	}

	public Connection<X_BH_I_Product_Quantity> BH_I_Product_QuantityGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
