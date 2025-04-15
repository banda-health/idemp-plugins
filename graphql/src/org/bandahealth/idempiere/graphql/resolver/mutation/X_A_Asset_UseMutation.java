package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Asset_UseInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Asset_UseInput;
import org.compiere.model.MAssetUse;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for A_Asset_Use - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_A_Asset_UseMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_UseInput.Table_Name;
	}

	public MAssetUse A_Asset_UseSave(I_A_Asset_UseInput Entity, DataFetchingEnvironment environment) {
		return (MAssetUse) super.save((X_A_Asset_UseInput) Entity, environment);
	}

	public List<MAssetUse> A_Asset_UseSaveMany(List<I_A_Asset_UseInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_A_Asset_UseInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MAssetUse) entity).collect(Collectors.toList());
	}

	public boolean A_Asset_UseDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
