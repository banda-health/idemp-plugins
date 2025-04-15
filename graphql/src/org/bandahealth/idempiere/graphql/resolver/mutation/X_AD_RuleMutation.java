package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_RuleInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_RuleInput;
import org.compiere.model.MRule;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Rule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_RuleMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_RuleInput.Table_Name;
	}

	public MRule AD_RuleSave(I_AD_RuleInput Entity, DataFetchingEnvironment environment) {
		return (MRule) super.save((X_AD_RuleInput) Entity, environment);
	}

	public List<MRule> AD_RuleSaveMany(List<I_AD_RuleInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_RuleInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MRule) entity).collect(Collectors.toList());
	}

	public boolean AD_RuleDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
