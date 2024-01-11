package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_CM_ChatInput;
import org.bandahealth.idempiere.graphql.model.input.X_CM_ChatInput;
import org.compiere.model.MChat;

import java.util.List;

/**
 * Generated Query Resolver for CM_Chat - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_CM_ChatMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_CM_ChatInput.Table_Name;
	}

	public MChat CM_ChatSave(I_CM_ChatInput input, DataFetchingEnvironment environment) {
		return (MChat) super.save((X_CM_ChatInput) input, environment);
	}

	public boolean CM_ChatDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
