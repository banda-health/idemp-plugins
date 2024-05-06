package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Asset_AcctInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Asset_AcctInput;
import org.compiere.model.MAssetAcct;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for A_Asset_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Asset_AcctMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_AcctInput.Table_Name;
	}

	public MAssetAcct A_Asset_AcctSave(I_A_Asset_AcctInput Entity, DataFetchingEnvironment environment) {
		return (MAssetAcct) super.save((X_A_Asset_AcctInput) Entity, environment);
	}

	public List<MAssetAcct> A_Asset_AcctSaveMany(List<I_A_Asset_AcctInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_A_Asset_AcctInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MAssetAcct) entity).collect(Collectors.toList());
	}

	public boolean A_Asset_AcctDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
