package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_RequestUpdateInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_RequestUpdateInput;
import org.compiere.model.MRequestUpdate;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for R_RequestUpdate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_R_RequestUpdateMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_RequestUpdateInput.Table_Name;
	}

	public MRequestUpdate R_RequestUpdateSave(I_R_RequestUpdateInput Entity, DataFetchingEnvironment environment) {
		return (MRequestUpdate) super.save((X_R_RequestUpdateInput) Entity, environment);
	}

	public List<MRequestUpdate> R_RequestUpdateSaveMany(List<I_R_RequestUpdateInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_R_RequestUpdateInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MRequestUpdate) entity).collect(Collectors.toList());
	}

	public boolean R_RequestUpdateDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
