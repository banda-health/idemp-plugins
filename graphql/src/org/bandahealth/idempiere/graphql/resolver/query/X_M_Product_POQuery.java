package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MProductPO;

/**
 * Generated Query Resolver for M_Product_PO - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_Product_POQuery extends POQuery<MProductPO> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MProductPO.Table_Name;
	}

	public Connection<MProductPO> M_Product_POGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
