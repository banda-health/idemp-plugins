package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Column_AccessInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_Column_AccessInput;
import org.compiere.model.MColumnAccess;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Column_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_Column_AccessMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Column_AccessInput.Table_Name;
	}

	public MColumnAccess AD_Column_AccessSave(I_AD_Column_AccessInput Entity, DataFetchingEnvironment environment) {
		return (MColumnAccess) super.save((X_AD_Column_AccessInput) Entity, environment);
	}

	public List<MColumnAccess> AD_Column_AccessSaveMany(List<I_AD_Column_AccessInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_Column_AccessInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MColumnAccess) entity).collect(Collectors.toList());
	}

	public boolean AD_Column_AccessDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
