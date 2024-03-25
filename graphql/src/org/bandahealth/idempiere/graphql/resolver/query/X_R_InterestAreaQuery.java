package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MInterestArea;

/**
 * Generated Query Resolver for R_InterestArea - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_InterestAreaQuery extends POQuery<MInterestArea> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MInterestArea.Table_Name;
	}

	public Connection<MInterestArea> R_InterestAreaGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
