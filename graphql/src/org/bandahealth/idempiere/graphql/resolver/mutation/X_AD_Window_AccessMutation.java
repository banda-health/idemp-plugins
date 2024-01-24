package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MWindowAccess_BH;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Window_AccessInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_Window_AccessInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Window_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Window_AccessMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Window_AccessInput.Table_Name;
	}

	public MWindowAccess_BH AD_Window_AccessSave(I_AD_Window_AccessInput entity, DataFetchingEnvironment environment) {
		return (MWindowAccess_BH) super.save((X_AD_Window_AccessInput) entity, environment);
	}

	public List<MWindowAccess_BH> AD_Window_AccessSaveMany(List<I_AD_Window_AccessInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_Window_AccessInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MWindowAccess_BH) entity).collect(Collectors.toList());
	}

	public boolean AD_Window_AccessDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
