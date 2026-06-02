package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHFeatureFlagRule;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Feature_Flag_RuleInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Feature_Flag_RuleInput;
import org.bandahealth.idempiere.graphql.utils.FeatureFlagMutationAuthorization;

import java.util.List;

public class MBHFeatureFlagRuleMutation extends X_BH_Feature_Flag_RuleMutation {

	@Override
	public MBHFeatureFlagRule BH_Feature_Flag_RuleSave(I_BH_Feature_Flag_RuleInput entity,
			DataFetchingEnvironment environment) {
		MBHFeatureFlagRule[] savedRule = new MBHFeatureFlagRule[1];
		FeatureFlagMutationAuthorization.runAsSystemAdministrator(environment,
				() -> savedRule[0] =
						(MBHFeatureFlagRule) super.save((X_BH_Feature_Flag_RuleInput) entity, environment));
		return savedRule[0];
	}

	@Override
	public boolean BH_Feature_Flag_RuleDelete(List<String> uUs, DataFetchingEnvironment environment) {
		boolean[] deleted = new boolean[1];
		FeatureFlagMutationAuthorization.runAsSystemAdministrator(environment,
				() -> deleted[0] = super.BH_Feature_Flag_RuleDelete(uUs, environment));
		return deleted[0];
	}
}
