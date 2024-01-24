package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_PromotionPreConditionInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_PromotionPreConditionInput;
import org.compiere.model.X_M_PromotionPreCondition;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_PromotionPreCondition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_PromotionPreConditionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_PromotionPreConditionInput.Table_Name;
	}

	public X_M_PromotionPreCondition M_PromotionPreConditionSave(I_M_PromotionPreConditionInput entity, DataFetchingEnvironment environment) {
		return (X_M_PromotionPreCondition) super.save((X_M_PromotionPreConditionInput) entity, environment);
	}

	public List<X_M_PromotionPreCondition> M_PromotionPreConditionSaveMany(List<I_M_PromotionPreConditionInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_PromotionPreConditionInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_M_PromotionPreCondition) entity).collect(Collectors.toList());
	}

	public boolean M_PromotionPreConditionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
