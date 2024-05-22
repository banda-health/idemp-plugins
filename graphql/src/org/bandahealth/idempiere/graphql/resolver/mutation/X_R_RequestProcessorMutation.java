package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_RequestProcessorInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_RequestProcessorInput;
import org.compiere.model.MRequestProcessor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for R_RequestProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_RequestProcessorMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_RequestProcessorInput.Table_Name;
	}

	public MRequestProcessor R_RequestProcessorSave(I_R_RequestProcessorInput Entity, DataFetchingEnvironment environment) {
		return (MRequestProcessor) super.save((X_R_RequestProcessorInput) Entity, environment);
	}

	public List<MRequestProcessor> R_RequestProcessorSaveMany(List<I_R_RequestProcessorInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_R_RequestProcessorInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MRequestProcessor) entity).collect(Collectors.toList());
	}

	public boolean R_RequestProcessorDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
