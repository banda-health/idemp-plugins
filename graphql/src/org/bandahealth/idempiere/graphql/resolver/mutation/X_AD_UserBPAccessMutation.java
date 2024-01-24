package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_UserBPAccessInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_UserBPAccessInput;
import org.compiere.model.X_AD_UserBPAccess;

import java.util.List;
import java.util.stream.Collectors;

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

	public X_AD_UserBPAccess AD_UserBPAccessSave(I_AD_UserBPAccessInput entity, DataFetchingEnvironment environment) {
		return (MUserBPX_AD_UserBPAccessAccess) super.save((X_AD_UserBPAccessInput) entity, environment);
	}

	public List<X_AD_UserBPAccess> AD_UserBPAccessSaveMany(List<I_AD_UserBPAccessInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_UserBPAccessInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_UserBPAccess) entity).collect(Collectors.toList());
	}

	public boolean AD_UserBPAccessDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
