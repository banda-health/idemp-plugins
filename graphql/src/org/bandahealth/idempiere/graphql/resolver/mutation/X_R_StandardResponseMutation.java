package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_StandardResponseInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_StandardResponseInput;
import org.compiere.model.X_R_StandardResponse;

import java.util.List;

/**
 * Generated Query Resolver for R_StandardResponse - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_StandardResponseMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_StandardResponseInput.Table_Name;
	}

	public X_R_StandardResponse R_StandardResponseSave(I_R_StandardResponseInput input, DataFetchingEnvironment environment) {
		return (X_R_StandardResponse) super.save((X_R_StandardResponseInput) input, environment);
	}

	public boolean R_StandardResponseDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
