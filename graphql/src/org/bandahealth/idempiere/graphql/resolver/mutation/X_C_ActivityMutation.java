package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_ActivityInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_ActivityInput;
import org.compiere.model.MActivity;

import java.util.List;

/**
 * Generated Query Resolver for C_Activity - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_ActivityMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_ActivityInput.Table_Name;
	}

	public MActivity C_ActivitySave(I_C_ActivityInput input, DataFetchingEnvironment environment) {
		return (MActivity) super.save((X_C_ActivityInput) input, environment);
	}

	public boolean C_ActivityDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
