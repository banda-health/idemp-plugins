package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHFeatureFlagRule;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Feature_Flag_RuleInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Feature_Flag_RuleInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Feature_Flag_Rule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Feature_Flag_RuleMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Feature_Flag_RuleInput.Table_Name;
	}

	public MBHFeatureFlagRule BH_Feature_Flag_RuleSave(I_BH_Feature_Flag_RuleInput Entity, DataFetchingEnvironment environment) {
		return (MBHFeatureFlagRule) super.save((X_BH_Feature_Flag_RuleInput) Entity, environment);
	}

	public List<MBHFeatureFlagRule> BH_Feature_Flag_RuleSaveMany(List<I_BH_Feature_Flag_RuleInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_Feature_Flag_RuleInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHFeatureFlagRule) entity).collect(Collectors.toList());
	}

	public boolean BH_Feature_Flag_RuleDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
