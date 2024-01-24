package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ClientInfoInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ClientInfoInput;
import org.compiere.model.MClientInfo;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_ClientInfo - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_ClientInfoMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ClientInfoInput.Table_Name;
	}

	public MClientInfo AD_ClientInfoSave(I_AD_ClientInfoInput entity, DataFetchingEnvironment environment) {
		return (MClientInfo) super.save((X_AD_ClientInfoInput) entity, environment);
	}

	public List<MClientInfo> AD_ClientInfoSaveMany(List<I_AD_ClientInfoInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_ClientInfoInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MClientInfo) entity).collect(Collectors.toList());
	}

	public boolean AD_ClientInfoDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
