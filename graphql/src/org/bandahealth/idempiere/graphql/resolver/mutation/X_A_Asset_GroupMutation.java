package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Asset_GroupInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Asset_GroupInput;
import org.compiere.model.MAssetGroup;

import java.util.List;

/**
 * Generated Query Resolver for A_Asset_Group - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_GroupMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_GroupInput.Table_Name;
	}

	public MAssetGroup A_Asset_GroupSave(I_A_Asset_GroupInput input, DataFetchingEnvironment environment) {
		return (MAssetGroup) super.save((X_A_Asset_GroupInput) input, environment);
	}

	public boolean A_Asset_GroupDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
