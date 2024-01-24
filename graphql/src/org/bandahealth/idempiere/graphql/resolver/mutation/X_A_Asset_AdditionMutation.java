package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Asset_AdditionInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Asset_AdditionInput;
import org.compiere.model.MAssetAddition;

import java.util.List;

/**
 * Generated Query Resolver for A_Asset_Addition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_A_Asset_AdditionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_AdditionInput.Table_Name;
	}

	public MAssetAddition A_Asset_AdditionSave(I_A_Asset_AdditionInput input, DataFetchingEnvironment environment) {
		return (MAssetAddition) super.save((X_A_Asset_AdditionInput) input, environment);
	}

	public boolean A_Asset_AdditionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
