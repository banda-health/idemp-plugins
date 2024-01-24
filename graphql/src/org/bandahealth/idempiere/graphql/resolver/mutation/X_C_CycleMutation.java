package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_CycleInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_CycleInput;
import org.compiere.model.X_C_Cycle;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_Cycle - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_CycleMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_CycleInput.Table_Name;
	}

	public X_C_Cycle C_CycleSave(I_C_CycleInput entity, DataFetchingEnvironment environment) {
		return (X_C_Cycle) super.save((X_C_CycleInput) entity, environment);
	}

	public List<X_C_Cycle> C_CycleSaveMany(List<I_C_CycleInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_CycleInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_C_Cycle) entity).collect(Collectors.toList());
	}

	public boolean C_CycleDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
