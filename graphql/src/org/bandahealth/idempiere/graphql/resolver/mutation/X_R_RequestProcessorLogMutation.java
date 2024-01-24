package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_RequestProcessorLogInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_RequestProcessorLogInput;
import org.compiere.model.MRequestProcessorLog;

import java.util.List;

/**
 * Generated Query Resolver for R_RequestProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_R_RequestProcessorLogMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_RequestProcessorLogInput.Table_Name;
	}

	public MRequestProcessorLog R_RequestProcessorLogSave(I_R_RequestProcessorLogInput input, DataFetchingEnvironment environment) {
		return (MRequestProcessorLog) super.save((X_R_RequestProcessorLogInput) input, environment);
	}

	public boolean R_RequestProcessorLogDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
