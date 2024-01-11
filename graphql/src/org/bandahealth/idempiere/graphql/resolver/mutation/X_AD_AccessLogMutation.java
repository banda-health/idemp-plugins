package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_AccessLogInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_AccessLogInput;
import org.compiere.model.MAccessLog;

import java.util.List;

/**
 * Generated Query Resolver for AD_AccessLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_AccessLogMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_AccessLogInput.Table_Name;
	}

	public MAccessLog AD_AccessLogSave(I_AD_AccessLogInput input, DataFetchingEnvironment environment) {
		return (MAccessLog) super.save((X_AD_AccessLogInput) input, environment);
	}

	public boolean AD_AccessLogDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
