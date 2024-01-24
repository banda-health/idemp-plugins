package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_CM_ChatEntryInput;
import org.bandahealth.idempiere.graphql.model.input.X_CM_ChatEntryInput;
import org.compiere.model.MChatEntry;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for CM_ChatEntry - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_CM_ChatEntryMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_CM_ChatEntryInput.Table_Name;
	}

	public MChatEntry CM_ChatEntrySave(I_CM_ChatEntryInput entity, DataFetchingEnvironment environment) {
		return (MChatEntry) super.save((X_CM_ChatEntryInput) entity, environment);
	}

	public List<MChatEntry> CM_ChatEntrySaveMany(List<I_CM_ChatEntryInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_CM_ChatEntryInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MChatEntry) entity).collect(Collectors.toList());
	}

	public boolean CM_ChatEntryDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
