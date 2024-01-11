package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MProductBOM;

/**
 * Generated Query Resolver for M_Product_BOM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_Product_BOMQuery extends POQuery<MProductBOM> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MProductBOM.Table_Name;
	}

	public Connection<MProductBOM> M_Product_BOMGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
