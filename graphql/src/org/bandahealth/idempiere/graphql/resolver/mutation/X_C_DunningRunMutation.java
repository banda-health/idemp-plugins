package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_DunningRunInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_DunningRunInput;
import org.compiere.model.MDunningRun;

import java.util.List;

/**
 * Generated Query Resolver for C_DunningRun - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_DunningRunMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_DunningRunInput.Table_Name;
	}

	public MDunningRun C_DunningRunSave(I_C_DunningRunInput input, DataFetchingEnvironment environment) {
		return (MDunningRun) super.save((X_C_DunningRunInput) input, environment);
	}

	public boolean C_DunningRunDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
