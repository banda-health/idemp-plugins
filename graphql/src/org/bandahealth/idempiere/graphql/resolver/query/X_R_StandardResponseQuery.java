package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_R_StandardResponse;

/**
 * Generated Query Resolver for R_StandardResponse - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_StandardResponseQuery extends POQuery<X_R_StandardResponse> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_R_StandardResponse.Table_Name;
	}

	public Connection<X_R_StandardResponse> R_StandardResponseGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
