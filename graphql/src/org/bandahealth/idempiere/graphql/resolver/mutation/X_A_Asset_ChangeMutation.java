package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Asset_ChangeInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Asset_ChangeInput;
import org.compiere.model.MAssetChange;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for A_Asset_Change - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_A_Asset_ChangeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_ChangeInput.Table_Name;
	}

	public MAssetChange A_Asset_ChangeSave(I_A_Asset_ChangeInput Entity, DataFetchingEnvironment environment) {
		return (MAssetChange) super.save((X_A_Asset_ChangeInput) Entity, environment);
	}

	public List<MAssetChange> A_Asset_ChangeSaveMany(List<I_A_Asset_ChangeInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_A_Asset_ChangeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MAssetChange) entity).collect(Collectors.toList());
	}

	public boolean A_Asset_ChangeDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
