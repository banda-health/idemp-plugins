package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Val_RuleInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_Val_RuleInput;
import org.compiere.model.MValRule;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Val_Rule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_Val_RuleMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Val_RuleInput.Table_Name;
	}

	public MValRule AD_Val_RuleSave(I_AD_Val_RuleInput entity, DataFetchingEnvironment environment) {
		return (MValRule) super.save((X_AD_Val_RuleInput) entity, environment);
	}

	public List<MValRule> AD_Val_RuleSaveMany(List<I_AD_Val_RuleInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_Val_RuleInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MValRule) entity).collect(Collectors.toList());
	}

	public boolean AD_Val_RuleDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
