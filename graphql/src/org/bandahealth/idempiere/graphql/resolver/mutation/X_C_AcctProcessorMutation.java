package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_AcctProcessorInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_AcctProcessorInput;
import org.compiere.model.MAcctProcessor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_AcctProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_AcctProcessorMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_AcctProcessorInput.Table_Name;
	}

	public MAcctProcessor C_AcctProcessorSave(I_C_AcctProcessorInput Entity, DataFetchingEnvironment environment) {
		return (MAcctProcessor) super.save((X_C_AcctProcessorInput) Entity, environment);
	}

	public List<MAcctProcessor> C_AcctProcessorSaveMany(List<I_C_AcctProcessorInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_AcctProcessorInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MAcctProcessor) entity).collect(Collectors.toList());
	}

	public boolean C_AcctProcessorDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
