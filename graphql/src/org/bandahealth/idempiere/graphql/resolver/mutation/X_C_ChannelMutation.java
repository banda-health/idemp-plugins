package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_ChannelInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_ChannelInput;
import org.compiere.model.X_C_Channel;

import java.util.List;

/**
 * Generated Query Resolver for C_Channel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_ChannelMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_ChannelInput.Table_Name;
	}

	public X_C_Channel C_ChannelSave(I_C_ChannelInput input, DataFetchingEnvironment environment) {
		return (X_C_Channel) super.save((X_C_ChannelInput) input, environment);
	}

	public boolean C_ChannelDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
