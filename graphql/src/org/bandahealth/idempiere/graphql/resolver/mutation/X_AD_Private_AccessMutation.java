package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Private_AccessInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_Private_AccessInput;
import org.compiere.model.MPrivateAccess;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Private_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_Private_AccessMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Private_AccessInput.Table_Name;
	}

	public MPrivateAccess AD_Private_AccessSave(I_AD_Private_AccessInput Entity, DataFetchingEnvironment environment) {
		return (MPrivateAccess) super.save((X_AD_Private_AccessInput) Entity, environment);
	}

	public List<MPrivateAccess> AD_Private_AccessSaveMany(List<I_AD_Private_AccessInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_Private_AccessInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MPrivateAccess) entity).collect(Collectors.toList());
	}

	public boolean AD_Private_AccessDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
