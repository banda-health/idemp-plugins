package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_GreetingInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_GreetingInput;
import org.compiere.model.X_C_Greeting;

import java.util.List;

/**
 * Generated Query Resolver for C_Greeting - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_GreetingMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_GreetingInput.Table_Name;
	}

	public X_C_Greeting C_GreetingSave(I_C_GreetingInput input, DataFetchingEnvironment environment) {
		return (X_C_Greeting) super.save((X_C_GreetingInput) input, environment);
	}

	public boolean C_GreetingDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
