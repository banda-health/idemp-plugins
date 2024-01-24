package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_DunningInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_DunningInput;
import org.compiere.model.MDunning;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_Dunning - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_DunningMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_DunningInput.Table_Name;
	}

	public MDunning C_DunningSave(I_C_DunningInput entity, DataFetchingEnvironment environment) {
		return (MDunning) super.save((X_C_DunningInput) entity, environment);
	}

	public List<MDunning> C_DunningSaveMany(List<I_C_DunningInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_DunningInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MDunning) entity).collect(Collectors.toList());
	}

	public boolean C_DunningDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
