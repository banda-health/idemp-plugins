package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_PasswordRuleInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_PasswordRuleInput;
import org.compiere.model.MPasswordRule;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_PasswordRule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_PasswordRuleMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_PasswordRuleInput.Table_Name;
	}

	public MPasswordRule AD_PasswordRuleSave(I_AD_PasswordRuleInput entity, DataFetchingEnvironment environment) {
		return (MPasswordRule) super.save((X_AD_PasswordRuleInput) entity, environment);
	}

	public List<MPasswordRule> AD_PasswordRuleSaveMany(List<I_AD_PasswordRuleInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_PasswordRuleInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MPasswordRule) entity).collect(Collectors.toList());
	}

	public boolean AD_PasswordRuleDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
