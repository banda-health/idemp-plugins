package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MUserPreference;

/**
 * Generated Query Resolver for AD_UserPreference - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_UserPreferenceQuery extends POQuery<MUserPreference> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MUserPreference.Table_Name;
	}

	public Connection<MUserPreference> AD_UserPreferenceGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
