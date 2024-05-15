package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MClient_BH;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ClientInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ClientInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Client - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_ClientMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ClientInput.Table_Name;
	}

	public MClient_BH AD_ClientSave(I_AD_ClientInput Entity, DataFetchingEnvironment environment) {
		return (MClient_BH) super.save((X_AD_ClientInput) Entity, environment);
	}

	public List<MClient_BH> AD_ClientSaveMany(List<I_AD_ClientInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_ClientInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MClient_BH) entity).collect(Collectors.toList());
	}

	public boolean AD_ClientDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
