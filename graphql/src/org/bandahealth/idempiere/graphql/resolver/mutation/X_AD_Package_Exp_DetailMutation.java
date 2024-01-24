package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Package_Exp_DetailInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_Package_Exp_DetailInput;
import org.compiere.model.MPackageExpDetail;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Package_Exp_Detail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Package_Exp_DetailMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Package_Exp_DetailInput.Table_Name;
	}

	public MPackageExpDetail AD_Package_Exp_DetailSave(I_AD_Package_Exp_DetailInput entity, DataFetchingEnvironment environment) {
		return (MPackageExpDetail) super.save((X_AD_Package_Exp_DetailInput) entity, environment);
	}

	public List<MPackageExpDetail> AD_Package_Exp_DetailSaveMany(List<I_AD_Package_Exp_DetailInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_Package_Exp_DetailInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MPackageExpDetail) entity).collect(Collectors.toList());
	}

	public boolean AD_Package_Exp_DetailDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
