package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_ProjectTypeInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_ProjectTypeInput;
import org.compiere.model.MProjectType;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_ProjectType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_ProjectTypeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_ProjectTypeInput.Table_Name;
	}

	public MProjectType C_ProjectTypeSave(I_C_ProjectTypeInput entity, DataFetchingEnvironment environment) {
		return (MProjectType) super.save((X_C_ProjectTypeInput) entity, environment);
	}

	public List<MProjectType> C_ProjectTypeSaveMany(List<I_C_ProjectTypeInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_ProjectTypeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MProjectType) entity).collect(Collectors.toList());
	}

	public boolean C_ProjectTypeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
