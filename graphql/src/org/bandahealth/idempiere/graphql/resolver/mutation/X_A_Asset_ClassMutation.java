package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Asset_ClassInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Asset_ClassInput;
import org.compiere.model.MAssetClass;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for A_Asset_Class - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_A_Asset_ClassMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_ClassInput.Table_Name;
	}

	public MAssetClass A_Asset_ClassSave(I_A_Asset_ClassInput entity, DataFetchingEnvironment environment) {
		return (MAssetClass) super.save((X_A_Asset_ClassInput) entity, environment);
	}

	public List<MAssetClass> A_Asset_ClassSaveMany(List<I_A_Asset_ClassInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_A_Asset_ClassInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MAssetClass) entity).collect(Collectors.toList());
	}

	public boolean A_Asset_ClassDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
