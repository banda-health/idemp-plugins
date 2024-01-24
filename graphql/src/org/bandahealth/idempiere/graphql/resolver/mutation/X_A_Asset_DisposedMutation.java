package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Asset_DisposedInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Asset_DisposedInput;
import org.compiere.model.MAssetDisposed;

import java.util.List;

/**
 * Generated Query Resolver for A_Asset_Disposed - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_DisposedMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_DisposedInput.Table_Name;
	}

	public MAssetDisposed A_Asset_DisposedSave(I_A_Asset_DisposedInput input, DataFetchingEnvironment environment) {
		return (MAssetDisposed) super.save((X_A_Asset_DisposedInput) input, environment);
	}

	public boolean A_Asset_DisposedDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
