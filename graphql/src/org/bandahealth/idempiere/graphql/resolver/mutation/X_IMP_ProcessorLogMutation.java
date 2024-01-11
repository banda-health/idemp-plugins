package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_IMP_ProcessorLogInput;
import org.bandahealth.idempiere.graphql.model.input.X_IMP_ProcessorLogInput;
import org.compiere.model.X_IMP_ProcessorLog;

import java.util.List;

/**
 * Generated Query Resolver for IMP_ProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_IMP_ProcessorLogMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_IMP_ProcessorLogInput.Table_Name;
	}

	public X_IMP_ProcessorLog IMP_ProcessorLogSave(I_IMP_ProcessorLogInput input, DataFetchingEnvironment environment) {
		return (X_IMP_ProcessorLog) super.save((X_IMP_ProcessorLogInput) input, environment);
	}

	public boolean IMP_ProcessorLogDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
