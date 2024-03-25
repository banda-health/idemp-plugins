package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_CM_ChatInput;
import org.bandahealth.idempiere.graphql.model.input.X_CM_ChatInput;
import org.compiere.model.MChat;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for CM_Chat - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_CM_ChatMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_CM_ChatInput.Table_Name;
	}

	public MChat CM_ChatSave(I_CM_ChatInput entity, DataFetchingEnvironment environment) {
		return (MChat) super.save((X_CM_ChatInput) entity, environment);
	}

	public List<MChat> CM_ChatSaveMany(List<I_CM_ChatInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_CM_ChatInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MChat) entity).collect(Collectors.toList());
	}

	public boolean CM_ChatDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
