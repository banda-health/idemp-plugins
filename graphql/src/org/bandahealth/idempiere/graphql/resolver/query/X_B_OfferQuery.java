package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_B_Offer;

/**
 * Generated Query Resolver for B_Offer - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_B_OfferQuery extends POQuery<X_B_Offer> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_B_Offer.Table_Name;
	}

	public Connection<X_B_Offer> B_OfferGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
