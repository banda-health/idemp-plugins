package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Asset_ChangeInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Asset_ChangeInput;
import org.compiere.model.MAssetChange;

import java.util.List;

/**
 * Generated Query Resolver for A_Asset_Change - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_A_Asset_ChangeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_ChangeInput.Table_Name;
	}

	public MAssetChange A_Asset_ChangeSave(I_A_Asset_ChangeInput input, DataFetchingEnvironment environment) {
		return (MAssetChange) super.save((X_A_Asset_ChangeInput) input, environment);
	}

	public boolean A_Asset_ChangeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
