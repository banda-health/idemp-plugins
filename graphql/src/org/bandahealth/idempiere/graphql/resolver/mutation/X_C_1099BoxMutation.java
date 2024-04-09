package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_1099BoxInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_1099BoxInput;
import org.compiere.model.X_C_1099Box;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_1099Box - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_1099BoxMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_1099BoxInput.Table_Name;
	}

	public X_C_1099Box C_1099BoxSave(I_C_1099BoxInput Entity, DataFetchingEnvironment environment) {
		return (X_C_1099Box) super.save((X_C_1099BoxInput) Entity, environment);
	}

	public List<X_C_1099Box> C_1099BoxSaveMany(List<I_C_1099BoxInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_1099BoxInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_C_1099Box) entity).collect(Collectors.toList());
	}

	public boolean C_1099BoxDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
