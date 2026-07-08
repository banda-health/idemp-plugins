package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHFieldRule;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Field_RuleInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Field_RuleInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Field_Rule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Field_RuleMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Field_RuleInput.Table_Name;
	}

	public MBHFieldRule BH_Field_RuleSave(I_BH_Field_RuleInput Entity, DataFetchingEnvironment environment) {
		return (MBHFieldRule) super.save((X_BH_Field_RuleInput) Entity, environment);
	}

	public List<MBHFieldRule> BH_Field_RuleSaveMany(List<I_BH_Field_RuleInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_Field_RuleInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHFieldRule) entity).collect(Collectors.toList());
	}

	public boolean BH_Field_RuleDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
