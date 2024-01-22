package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MBPartnerProduct;

/**
 * Generated Query Resolver for C_BPartner_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_BPartner_ProductQuery extends POQuery<MBPartnerProduct> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBPartnerProduct.Table_Name;
	}

	public Connection<MBPartnerProduct> C_BPartner_ProductGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
