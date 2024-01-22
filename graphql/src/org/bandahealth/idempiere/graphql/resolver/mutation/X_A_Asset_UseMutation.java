package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Asset_UseInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Asset_UseInput;
import org.compiere.model.MAssetUse;

import java.util.List;

/**
 * Generated Query Resolver for A_Asset_Use - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_A_Asset_UseMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_UseInput.Table_Name;
	}

	public MAssetUse A_Asset_UseSave(I_A_Asset_UseInput input, DataFetchingEnvironment environment) {
		return (MAssetUse) super.save((X_A_Asset_UseInput) input, environment);
	}

	public boolean A_Asset_UseDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
