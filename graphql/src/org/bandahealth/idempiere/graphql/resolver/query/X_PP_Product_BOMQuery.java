package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.eevolution.model.MPPProductBOM;

/**
 * Generated Query Resolver for PP_Product_BOM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PP_Product_BOMQuery extends POQuery<MPPProductBOM> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPPProductBOM.Table_Name;
	}

	public Connection<MPPProductBOM> PP_Product_BOMGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
