package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Asset_ClassInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Asset_ClassInput;
import org.compiere.model.MAssetClass;

import java.util.List;

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

	public MAssetClass A_Asset_ClassSave(I_A_Asset_ClassInput input, DataFetchingEnvironment environment) {
		return (MAssetClass) super.save((X_A_Asset_ClassInput) input, environment);
	}

	public boolean A_Asset_ClassDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
