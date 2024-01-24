package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_T_ReplenishInput;
import org.bandahealth.idempiere.graphql.model.input.X_T_ReplenishInput;
import org.compiere.model.X_T_Replenish;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for T_Replenish - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_T_ReplenishMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_T_ReplenishInput.Table_Name;
	}

	public X_T_Replenish T_ReplenishSave(I_T_ReplenishInput entity, DataFetchingEnvironment environment) {
		return (X_T_Replenish) super.save((X_T_ReplenishInput) entity, environment);
	}

	public List<X_T_Replenish> T_ReplenishSaveMany(List<I_T_ReplenishInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_T_ReplenishInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_T_Replenish) entity).collect(Collectors.toList());
	}

	public boolean T_ReplenishDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
