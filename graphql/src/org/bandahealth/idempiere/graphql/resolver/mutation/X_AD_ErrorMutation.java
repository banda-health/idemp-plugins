package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ErrorInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ErrorInput;
import org.compiere.model.X_AD_Error;

import java.util.List;

/**
 * Generated Query Resolver for AD_Error - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_ErrorMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ErrorInput.Table_Name;
	}

	public X_AD_Error AD_ErrorSave(I_AD_ErrorInput input, DataFetchingEnvironment environment) {
		return (X_AD_Error) super.save((X_AD_ErrorInput) input, environment);
	}

	public boolean AD_ErrorDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
