package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_AllUsers_VInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_AllUsers_VInput;
import org.compiere.model.X_AD_AllUsers_V;

import java.util.List;

/**
 * Generated Query Resolver for AD_AllUsers_V - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_AllUsers_VMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_AllUsers_VInput.Table_Name;
	}

	public X_AD_AllUsers_V AD_AllUsers_VSave(I_AD_AllUsers_VInput input, DataFetchingEnvironment environment) {
		return (X_AD_AllUsers_V) super.save((X_AD_AllUsers_VInput) input, environment);
	}

	public boolean AD_AllUsers_VDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
