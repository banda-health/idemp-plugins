package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_DunningRunEntryInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_DunningRunEntryInput;
import org.compiere.model.MDunningRunEntry;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_DunningRunEntry - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_DunningRunEntryMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_DunningRunEntryInput.Table_Name;
	}

	public MDunningRunEntry C_DunningRunEntrySave(I_C_DunningRunEntryInput Entity, DataFetchingEnvironment environment) {
		return (MDunningRunEntry) super.save((X_C_DunningRunEntryInput) Entity, environment);
	}

	public List<MDunningRunEntry> C_DunningRunEntrySaveMany(List<I_C_DunningRunEntryInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_DunningRunEntryInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MDunningRunEntry) entity).collect(Collectors.toList());
	}

	public boolean C_DunningRunEntryDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
