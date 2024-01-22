package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_UserBPAccessInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_UserBPAccessInput;
import org.compiere.model.X_AD_UserBPAccess;

import java.util.List;

/**
 * Generated Query Resolver for AD_UserBPAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_UserBPAccessMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_UserBPAccessInput.Table_Name;
	}

	public X_AD_UserBPAccess AD_UserBPAccessSave(I_AD_UserBPAccessInput input, DataFetchingEnvironment environment) {
		return (X_AD_UserBPAccess) super.save((X_AD_UserBPAccessInput) input, environment);
	}

	public boolean AD_UserBPAccessDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
