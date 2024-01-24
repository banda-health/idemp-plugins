package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_CycleInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_CycleInput;
import org.compiere.model.X_C_Cycle;

import java.util.List;

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

	public X_C_Cycle C_CycleSave(I_C_CycleInput input, DataFetchingEnvironment environment) {
		return (X_C_Cycle) super.save((X_C_CycleInput) input, environment);
	}

	public boolean C_CycleDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
