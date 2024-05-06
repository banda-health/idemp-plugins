package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MResolution;

/**
 * Generated Query Resolver for R_Resolution - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_ResolutionQuery extends POQuery<MResolution> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MResolution.Table_Name;
	}

	public Connection<MResolution> R_ResolutionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
