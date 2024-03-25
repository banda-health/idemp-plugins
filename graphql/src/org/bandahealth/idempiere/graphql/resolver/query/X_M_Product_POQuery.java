package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProductPO_BH;
import org.bandahealth.idempiere.graphql.model.Connection;

/**
 * Generated Query Resolver for M_Product_PO - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_Product_POQuery extends POQuery<MProductPO_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MProductPO_BH.Table_Name;
	}

	public Connection<MProductPO_BH> M_Product_POGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
