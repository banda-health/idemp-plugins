package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MMessage_BH;
import org.bandahealth.idempiere.graphql.model.input.I_AD_MessageInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_MessageInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Message - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_MessageMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_MessageInput.Table_Name;
	}

	public MMessage_BH AD_MessageSave(I_AD_MessageInput Entity, DataFetchingEnvironment environment) {
		return (MMessage_BH) super.save((X_AD_MessageInput) Entity, environment);
	}

	public List<MMessage_BH> AD_MessageSaveMany(List<I_AD_MessageInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_MessageInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MMessage_BH) entity).collect(Collectors.toList());
	}

	public boolean AD_MessageDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
