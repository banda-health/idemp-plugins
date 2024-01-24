package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ClientShareInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ClientShareInput;
import org.compiere.model.MClientShare;

import java.util.List;

/**
 * Generated Query Resolver for AD_ClientShare - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ClientShareMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ClientShareInput.Table_Name;
	}

	public MClientShare AD_ClientShareSave(I_AD_ClientShareInput input, DataFetchingEnvironment environment) {
		return (MClientShare) super.save((X_AD_ClientShareInput) input, environment);
	}

	public boolean AD_ClientShareDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
