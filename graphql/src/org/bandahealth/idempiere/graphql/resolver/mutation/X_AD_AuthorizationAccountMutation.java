package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_AuthorizationAccountInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_AuthorizationAccountInput;
import org.compiere.model.MAuthorizationAccount;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_AuthorizationAccount - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_AuthorizationAccountMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_AuthorizationAccountInput.Table_Name;
	}

	public MAuthorizationAccount AD_AuthorizationAccountSave(I_AD_AuthorizationAccountInput Entity, DataFetchingEnvironment environment) {
		return (MAuthorizationAccount) super.save((X_AD_AuthorizationAccountInput) Entity, environment);
	}

	public List<MAuthorizationAccount> AD_AuthorizationAccountSaveMany(List<I_AD_AuthorizationAccountInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_AuthorizationAccountInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MAuthorizationAccount) entity).collect(Collectors.toList());
	}

	public boolean AD_AuthorizationAccountDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
