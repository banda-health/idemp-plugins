package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_PromotionRewardInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_PromotionRewardInput;
import org.compiere.model.X_M_PromotionReward;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_PromotionReward - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_PromotionRewardMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_PromotionRewardInput.Table_Name;
	}

	public X_M_PromotionReward M_PromotionRewardSave(I_M_PromotionRewardInput entity, DataFetchingEnvironment environment) {
		return (X_M_PromotionReward) super.save((X_M_PromotionRewardInput) entity, environment);
	}

	public List<X_M_PromotionReward> M_PromotionRewardSaveMany(List<I_M_PromotionRewardInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_PromotionRewardInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_M_PromotionReward) entity).collect(Collectors.toList());
	}

	public boolean M_PromotionRewardDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
