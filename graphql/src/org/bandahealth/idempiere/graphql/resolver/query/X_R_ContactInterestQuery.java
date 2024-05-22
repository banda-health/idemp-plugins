package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MContactInterest;

/**
 * Generated Query Resolver for R_ContactInterest - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_ContactInterestQuery extends POQuery<MContactInterest> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MContactInterest.Table_Name;
	}

	public Connection<MContactInterest> R_ContactInterestGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
