package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Asset_TransferInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Asset_TransferInput;
import org.compiere.model.MAssetTransfer;

import java.util.List;

/**
 * Generated Query Resolver for A_Asset_Transfer - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_A_Asset_TransferMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_TransferInput.Table_Name;
	}

	public MAssetTransfer A_Asset_TransferSave(I_A_Asset_TransferInput input, DataFetchingEnvironment environment) {
		return (MAssetTransfer) super.save((X_A_Asset_TransferInput) input, environment);
	}

	public boolean A_Asset_TransferDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
