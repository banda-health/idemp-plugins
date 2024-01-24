package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_StatusLineUsedInInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_StatusLineUsedInInput;
import org.compiere.model.MStatusLineUsedIn;

import java.util.List;

/**
 * Generated Query Resolver for AD_StatusLineUsedIn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_StatusLineUsedInMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_StatusLineUsedInInput.Table_Name;
	}

	public MStatusLineUsedIn AD_StatusLineUsedInSave(I_AD_StatusLineUsedInInput input, DataFetchingEnvironment environment) {
		return (MStatusLineUsedIn) super.save((X_AD_StatusLineUsedInInput) input, environment);
	}

	public boolean AD_StatusLineUsedInDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
