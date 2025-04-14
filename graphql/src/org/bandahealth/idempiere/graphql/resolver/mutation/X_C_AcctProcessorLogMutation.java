package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_AcctProcessorLogInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_AcctProcessorLogInput;
import org.compiere.model.MAcctProcessorLog;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_AcctProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_AcctProcessorLogMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_AcctProcessorLogInput.Table_Name;
	}

	public MAcctProcessorLog C_AcctProcessorLogSave(I_C_AcctProcessorLogInput Entity, DataFetchingEnvironment environment) {
		return (MAcctProcessorLog) super.save((X_C_AcctProcessorLogInput) Entity, environment);
	}

	public List<MAcctProcessorLog> C_AcctProcessorLogSaveMany(List<I_C_AcctProcessorLogInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_AcctProcessorLogInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MAcctProcessorLog) entity).collect(Collectors.toList());
	}

	public boolean C_AcctProcessorLogDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
