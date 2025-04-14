package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Asset_RevalInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Asset_RevalInput;
import org.compiere.model.MAssetReval;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for A_Asset_Reval - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_A_Asset_RevalMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_RevalInput.Table_Name;
	}

	public MAssetReval A_Asset_RevalSave(I_A_Asset_RevalInput Entity, DataFetchingEnvironment environment) {
		return (MAssetReval) super.save((X_A_Asset_RevalInput) Entity, environment);
	}

	public List<MAssetReval> A_Asset_RevalSaveMany(List<I_A_Asset_RevalInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_A_Asset_RevalInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MAssetReval) entity).collect(Collectors.toList());
	}

	public boolean A_Asset_RevalDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
