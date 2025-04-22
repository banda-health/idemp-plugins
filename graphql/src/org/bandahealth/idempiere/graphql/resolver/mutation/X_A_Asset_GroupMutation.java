package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Asset_GroupInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Asset_GroupInput;
import org.compiere.model.MAssetGroup;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for A_Asset_Group - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_A_Asset_GroupMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_GroupInput.Table_Name;
	}

	public MAssetGroup A_Asset_GroupSave(I_A_Asset_GroupInput Entity, DataFetchingEnvironment environment) {
		return (MAssetGroup) super.save((X_A_Asset_GroupInput) Entity, environment);
	}

	public List<MAssetGroup> A_Asset_GroupSaveMany(List<I_A_Asset_GroupInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_A_Asset_GroupInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MAssetGroup) entity).collect(Collectors.toList());
	}

	public boolean A_Asset_GroupDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
