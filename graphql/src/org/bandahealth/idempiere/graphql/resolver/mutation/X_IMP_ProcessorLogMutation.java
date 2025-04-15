package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_IMP_ProcessorLogInput;
import org.bandahealth.idempiere.graphql.model.input.X_IMP_ProcessorLogInput;
import org.compiere.model.MIMPProcessorLog;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for IMP_ProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_IMP_ProcessorLogMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_IMP_ProcessorLogInput.Table_Name;
	}

	public MIMPProcessorLog IMP_ProcessorLogSave(I_IMP_ProcessorLogInput Entity, DataFetchingEnvironment environment) {
		return (MIMPProcessorLog) super.save((X_IMP_ProcessorLogInput) Entity, environment);
	}

	public List<MIMPProcessorLog> IMP_ProcessorLogSaveMany(List<I_IMP_ProcessorLogInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_IMP_ProcessorLogInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MIMPProcessorLog) entity).collect(Collectors.toList());
	}

	public boolean IMP_ProcessorLogDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
