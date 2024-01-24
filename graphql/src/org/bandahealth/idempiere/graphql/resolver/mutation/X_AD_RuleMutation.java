package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_RuleInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_RuleInput;
import org.compiere.model.MRule;

import java.util.List;

/**
 * Generated Query Resolver for AD_Rule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_RuleMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_RuleInput.Table_Name;
	}

	public MRule AD_RuleSave(I_AD_RuleInput input, DataFetchingEnvironment environment) {
		return (MRule) super.save((X_AD_RuleInput) input, environment);
	}

	public boolean AD_RuleDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
