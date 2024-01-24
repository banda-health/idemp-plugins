package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MMessage_BH;
import org.bandahealth.idempiere.graphql.model.input.I_AD_MessageInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_MessageInput;

import java.util.List;

/**
 * Generated Query Resolver for AD_Message - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_MessageMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_MessageInput.Table_Name;
	}

	public MMessage_BH AD_MessageSave(I_AD_MessageInput input, DataFetchingEnvironment environment) {
		return (MMessage_BH) super.save((X_AD_MessageInput) input, environment);
	}

	public boolean AD_MessageDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
