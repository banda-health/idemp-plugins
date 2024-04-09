package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPaymentTerm;

/**
 * Generated Query Resolver for C_PaymentTerm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_PaymentTermQuery extends POQuery<MPaymentTerm> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPaymentTerm.Table_Name;
	}

	public Connection<MPaymentTerm> C_PaymentTermGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
