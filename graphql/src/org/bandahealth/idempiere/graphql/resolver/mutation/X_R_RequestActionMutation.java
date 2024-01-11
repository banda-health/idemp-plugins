package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_RequestActionInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_RequestActionInput;
import org.compiere.model.MRequestAction;

import java.util.List;

/**
 * Generated Query Resolver for R_RequestAction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_RequestActionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_RequestActionInput.Table_Name;
	}

	public MRequestAction R_RequestActionSave(I_R_RequestActionInput input, DataFetchingEnvironment environment) {
		return (MRequestAction) super.save((X_R_RequestActionInput) input, environment);
	}

	public boolean R_RequestActionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
