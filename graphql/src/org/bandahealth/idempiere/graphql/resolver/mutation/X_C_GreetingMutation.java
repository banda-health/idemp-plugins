package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_GreetingInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_GreetingInput;
import org.compiere.model.X_C_Greeting;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_Greeting - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_GreetingMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_GreetingInput.Table_Name;
	}

	public X_C_Greeting C_GreetingSave(I_C_GreetingInput entity, DataFetchingEnvironment environment) {
		return (X_C_Greeting) super.save((X_C_GreetingInput) entity, environment);
	}

	public List<X_C_Greeting> C_GreetingSaveMany(List<I_C_GreetingInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_GreetingInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_C_Greeting) entity).collect(Collectors.toList());
	}

	public boolean C_GreetingDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
