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
 * @version Release 13 - $Id$
 */
public class X_AD_Role_IncludedMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Role_IncludedInput.Table_Name;
	}

	public MRoleIncluded AD_Role_IncludedSave(I_AD_Role_IncludedInput Entity, DataFetchingEnvironment environment) {
		return (MRoleIncluded) super.save((X_AD_Role_IncludedInput) Entity, environment);
	}

	public List<MRoleIncluded> AD_Role_IncludedSaveMany(List<I_AD_Role_IncludedInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_Role_IncludedInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MRoleIncluded) entity).collect(Collectors.toList());
	}

	public boolean AD_Role_IncludedDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
