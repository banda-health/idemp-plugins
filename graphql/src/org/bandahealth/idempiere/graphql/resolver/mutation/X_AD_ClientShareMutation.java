package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ClientShareInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ClientShareInput;
import org.compiere.model.MClientShare;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_ClientShare - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_ClientShareMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ClientShareInput.Table_Name;
	}

	public MClientShare AD_ClientShareSave(I_AD_ClientShareInput Entity, DataFetchingEnvironment environment) {
		return (MClientShare) super.save((X_AD_ClientShareInput) Entity, environment);
	}

	public List<MClientShare> AD_ClientShareSaveMany(List<I_AD_ClientShareInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_ClientShareInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MClientShare) entity).collect(Collectors.toList());
	}

	public boolean AD_ClientShareDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
