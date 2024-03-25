package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Role_IncludedInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_Role_IncludedInput;
import org.compiere.model.MRoleIncluded;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Role_Included - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Role_IncludedMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Role_IncludedInput.Table_Name;
	}

	public MRoleIncluded AD_Role_IncludedSave(I_AD_Role_IncludedInput entity, DataFetchingEnvironment environment) {
		return (MRoleIncluded) super.save((X_AD_Role_IncludedInput) entity, environment);
	}

	public List<MRoleIncluded> AD_Role_IncludedSaveMany(List<I_AD_Role_IncludedInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_Role_IncludedInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MRoleIncluded) entity).collect(Collectors.toList());
	}

	public boolean AD_Role_IncludedDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
