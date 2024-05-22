package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_ChannelInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_ChannelInput;
import org.compiere.model.X_C_Channel;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_Channel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_ChannelMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_ChannelInput.Table_Name;
	}

	public X_C_Channel C_ChannelSave(I_C_ChannelInput Entity, DataFetchingEnvironment environment) {
		return (X_C_Channel) super.save((X_C_ChannelInput) Entity, environment);
	}

	public List<X_C_Channel> C_ChannelSaveMany(List<I_C_ChannelInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_ChannelInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_C_Channel) entity).collect(Collectors.toList());
	}

	public boolean C_ChannelDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
