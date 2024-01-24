package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Asset_TypeInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Asset_TypeInput;
import org.compiere.model.MAssetType;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for A_Asset_Type - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_A_Asset_TypeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_TypeInput.Table_Name;
	}

	public MAssetType A_Asset_TypeSave(I_A_Asset_TypeInput entity, DataFetchingEnvironment environment) {
		return (MAssetType) super.save((X_A_Asset_TypeInput) entity, environment);
	}

	public List<MAssetType> A_Asset_TypeSaveMany(List<I_A_Asset_TypeInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_A_Asset_TypeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MAssetType) entity).collect(Collectors.toList());
	}

	public boolean A_Asset_TypeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
