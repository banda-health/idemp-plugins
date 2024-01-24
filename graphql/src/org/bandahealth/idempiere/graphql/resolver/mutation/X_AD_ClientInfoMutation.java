package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ClientInfoInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ClientInfoInput;
import org.compiere.model.MClientInfo;

import java.util.List;

/**
 * Generated Query Resolver for AD_ClientInfo - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ClientInfoMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ClientInfoInput.Table_Name;
	}

	public MClientInfo AD_ClientInfoSave(I_AD_ClientInfoInput input, DataFetchingEnvironment environment) {
		return (MClientInfo) super.save((X_AD_ClientInfoInput) input, environment);
	}

	public boolean AD_ClientInfoDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
