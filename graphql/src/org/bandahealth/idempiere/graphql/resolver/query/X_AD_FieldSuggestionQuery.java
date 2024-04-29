package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MFieldSuggestion;

/**
 * Generated Query Resolver for AD_FieldSuggestion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_FieldSuggestionQuery extends POQuery<MFieldSuggestion> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MFieldSuggestion.Table_Name;
	}

	public Connection<MFieldSuggestion> AD_FieldSuggestionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
