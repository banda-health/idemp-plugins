package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Asset_Group_AcctInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Asset_Group_AcctInput;
import org.compiere.model.MAssetGroupAcct;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for A_Asset_Group_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_A_Asset_Group_AcctMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_Group_AcctInput.Table_Name;
	}

	public MAssetGroupAcct A_Asset_Group_AcctSave(I_A_Asset_Group_AcctInput Entity, DataFetchingEnvironment environment) {
		return (MAssetGroupAcct) super.save((X_A_Asset_Group_AcctInput) Entity, environment);
	}

	public List<MAssetGroupAcct> A_Asset_Group_AcctSaveMany(List<I_A_Asset_Group_AcctInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_A_Asset_Group_AcctInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MAssetGroupAcct) entity).collect(Collectors.toList());
	}

	public boolean A_Asset_Group_AcctDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
