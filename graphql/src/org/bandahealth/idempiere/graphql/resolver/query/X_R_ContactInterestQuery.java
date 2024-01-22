package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MContactInterest;

/**
 * Generated Query Resolver for R_ContactInterest - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_R_ContactInterestQuery extends POQuery<MContactInterest> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MContactInterest.Table_Name;
	}

	public Connection<MContactInterest> R_ContactInterestGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
