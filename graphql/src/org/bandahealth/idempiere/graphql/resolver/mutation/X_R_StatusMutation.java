package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_StatusInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_StatusInput;
import org.compiere.model.MStatus;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for R_Status - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_R_StatusMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_StatusInput.Table_Name;
	}

	public MStatus R_StatusSave(I_R_StatusInput entity, DataFetchingEnvironment environment) {
		return (MStatus) super.save((X_R_StatusInput) entity, environment);
	}

	public List<MStatus> R_StatusSaveMany(List<I_R_StatusInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_R_StatusInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MStatus) entity).collect(Collectors.toList());
	}

	public boolean R_StatusDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
