package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_DunningRunEntryInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_DunningRunEntryInput;
import org.compiere.model.MDunningRunEntry;

import java.util.List;

/**
 * Generated Query Resolver for C_DunningRunEntry - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_DunningRunEntryMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_DunningRunEntryInput.Table_Name;
	}

	public MDunningRunEntry C_DunningRunEntrySave(I_C_DunningRunEntryInput input, DataFetchingEnvironment environment) {
		return (MDunningRunEntry) super.save((X_C_DunningRunEntryInput) input, environment);
	}

	public boolean C_DunningRunEntryDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
