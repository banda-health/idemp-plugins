package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Task_AccessInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_Task_AccessInput;
import org.compiere.model.MTaskAccess;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Task_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_Task_AccessMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Task_AccessInput.Table_Name;
	}

	public MTaskAccess AD_Task_AccessSave(I_AD_Task_AccessInput Entity, DataFetchingEnvironment environment) {
		return (MTaskAccess) super.save((X_AD_Task_AccessInput) Entity, environment);
	}

	public List<MTaskAccess> AD_Task_AccessSaveMany(List<I_AD_Task_AccessInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_Task_AccessInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MTaskAccess) entity).collect(Collectors.toList());
	}

	public boolean AD_Task_AccessDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
