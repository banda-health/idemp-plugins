package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_AlertRuleInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_AlertRuleInput;
import org.compiere.model.MAlertRule;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_AlertRule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_AlertRuleMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_AlertRuleInput.Table_Name;
	}

	public MAlertRule AD_AlertRuleSave(I_AD_AlertRuleInput entity, DataFetchingEnvironment environment) {
		return (MAlertRule) super.save((X_AD_AlertRuleInput) entity, environment);
	}

	public List<MAlertRule> AD_AlertRuleSaveMany(List<I_AD_AlertRuleInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_AlertRuleInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MAlertRule) entity).collect(Collectors.toList());
	}

	public boolean AD_AlertRuleDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
