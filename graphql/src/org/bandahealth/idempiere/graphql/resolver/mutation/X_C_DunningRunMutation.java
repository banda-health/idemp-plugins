package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_DunningRunInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_DunningRunInput;
import org.compiere.model.MDunningRun;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_DunningRun - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_DunningRunMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_DunningRunInput.Table_Name;
	}

	public MDunningRun C_DunningRunSave(I_C_DunningRunInput Entity, DataFetchingEnvironment environment) {
		return (MDunningRun) super.save((X_C_DunningRunInput) Entity, environment);
	}

	public List<MDunningRun> C_DunningRunSaveMany(List<I_C_DunningRunInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_DunningRunInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MDunningRun) entity).collect(Collectors.toList());
	}

	public boolean C_DunningRunDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
