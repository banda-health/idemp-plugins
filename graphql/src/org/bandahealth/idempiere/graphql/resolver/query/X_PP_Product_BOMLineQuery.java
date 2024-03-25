package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.eevolution.model.MPPProductBOMLine;

/**
 * Generated Query Resolver for PP_Product_BOMLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PP_Product_BOMLineQuery extends POQuery<MPPProductBOMLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPPProductBOMLine.Table_Name;
	}

	public Connection<MPPProductBOMLine> PP_Product_BOMLineGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
