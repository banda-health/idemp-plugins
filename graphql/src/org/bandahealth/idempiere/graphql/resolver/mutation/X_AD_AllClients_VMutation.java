package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_AllClients_VInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_AllClients_VInput;
import org.compiere.model.X_AD_AllClients_V;

import java.util.List;

/**
 * Generated Query Resolver for AD_AllClients_V - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_AllClients_VMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_AllClients_VInput.Table_Name;
	}

	public X_AD_AllClients_V AD_AllClients_VSave(I_AD_AllClients_VInput input, DataFetchingEnvironment environment) {
		return (X_AD_AllClients_V) super.save((X_AD_AllClients_VInput) input, environment);
	}

	public boolean AD_AllClients_VDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
