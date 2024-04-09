package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Process_AccessInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_Process_AccessInput;
import org.compiere.model.MProcessAccess;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Process_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Process_AccessMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Process_AccessInput.Table_Name;
	}

	public MProcessAccess AD_Process_AccessSave(I_AD_Process_AccessInput Entity, DataFetchingEnvironment environment) {
		return (MProcessAccess) super.save((X_AD_Process_AccessInput) Entity, environment);
	}

	public List<MProcessAccess> AD_Process_AccessSaveMany(List<I_AD_Process_AccessInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_Process_AccessInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MProcessAccess) entity).collect(Collectors.toList());
	}

	public boolean AD_Process_AccessDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
