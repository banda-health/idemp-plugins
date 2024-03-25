package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_IMP_ProcessorInput;
import org.bandahealth.idempiere.graphql.model.input.X_IMP_ProcessorInput;
import org.compiere.model.MIMPProcessor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for IMP_Processor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_IMP_ProcessorMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_IMP_ProcessorInput.Table_Name;
	}

	public MIMPProcessor IMP_ProcessorSave(I_IMP_ProcessorInput entity, DataFetchingEnvironment environment) {
		return (MIMPProcessor) super.save((X_IMP_ProcessorInput) entity, environment);
	}

	public List<MIMPProcessor> IMP_ProcessorSaveMany(List<I_IMP_ProcessorInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_IMP_ProcessorInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MIMPProcessor) entity).collect(Collectors.toList());
	}

	public boolean IMP_ProcessorDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
