package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_CM_ChatEntryInput;
import org.bandahealth.idempiere.graphql.model.input.X_CM_ChatEntryInput;
import org.compiere.model.MChatEntry;

import java.util.List;

/**
 * Generated Query Resolver for CM_ChatEntry - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_CM_ChatEntryMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_CM_ChatEntryInput.Table_Name;
	}

	public MChatEntry CM_ChatEntrySave(I_CM_ChatEntryInput input, DataFetchingEnvironment environment) {
		return (MChatEntry) super.save((X_CM_ChatEntryInput) input, environment);
	}

	public boolean CM_ChatEntryDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
