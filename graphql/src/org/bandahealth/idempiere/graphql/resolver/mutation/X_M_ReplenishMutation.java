package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ReplenishInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ReplenishInput;
import org.compiere.model.MReplenish;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_Replenish - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_ReplenishMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ReplenishInput.Table_Name;
	}

	public MReplenish M_ReplenishSave(I_M_ReplenishInput Entity, DataFetchingEnvironment environment) {
		return (MReplenish) super.save((X_M_ReplenishInput) Entity, environment);
	}

	public List<MReplenish> M_ReplenishSaveMany(List<I_M_ReplenishInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_ReplenishInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MReplenish) entity).collect(Collectors.toList());
	}

	public boolean M_ReplenishDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
