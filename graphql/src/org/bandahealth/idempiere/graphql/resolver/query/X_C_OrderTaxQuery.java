package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MOrderTax;

/**
 * Generated Query Resolver for C_OrderTax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_OrderTaxQuery extends POQuery<MOrderTax> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MOrderTax.Table_Name;
	}

	public Connection<MOrderTax> C_OrderTaxGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
