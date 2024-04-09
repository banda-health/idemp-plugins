package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_DocumentStatusInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_DocumentStatusInput;
import org.compiere.model.MDocumentStatus;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for PA_DocumentStatus - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_DocumentStatusMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_DocumentStatusInput.Table_Name;
	}

	public MDocumentStatus PA_DocumentStatusSave(I_PA_DocumentStatusInput Entity, DataFetchingEnvironment environment) {
		return (MDocumentStatus) super.save((X_PA_DocumentStatusInput) Entity, environment);
	}

	public List<MDocumentStatus> PA_DocumentStatusSaveMany(List<I_PA_DocumentStatusInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_PA_DocumentStatusInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MDocumentStatus) entity).collect(Collectors.toList());
	}

	public boolean PA_DocumentStatusDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
