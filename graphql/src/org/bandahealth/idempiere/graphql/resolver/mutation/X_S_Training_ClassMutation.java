package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_S_Training_ClassInput;
import org.bandahealth.idempiere.graphql.model.input.X_S_Training_ClassInput;
import org.compiere.model.X_S_Training_Class;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for S_Training_Class - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_S_Training_ClassMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_S_Training_ClassInput.Table_Name;
	}

	public X_S_Training_Class S_Training_ClassSave(I_S_Training_ClassInput entity, DataFetchingEnvironment environment) {
		return (X_S_Training_Class) super.save((X_S_Training_ClassInput) entity, environment);
	}

	public List<X_S_Training_Class> S_Training_ClassSaveMany(List<I_S_Training_ClassInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_S_Training_ClassInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_S_Training_Class) entity).collect(Collectors.toList());
	}

	public boolean S_Training_ClassDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
