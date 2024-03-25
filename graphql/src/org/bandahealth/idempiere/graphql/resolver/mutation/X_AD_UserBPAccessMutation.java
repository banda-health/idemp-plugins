package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_UserBPAccessInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_UserBPAccessInput;
import org.compiere.model.MUserBPAccess;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_UserBPAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_UserBPAccessMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_UserBPAccessInput.Table_Name;
	}

	public MUserBPAccess AD_UserBPAccessSave(I_AD_UserBPAccessInput entity, DataFetchingEnvironment environment) {
		return (MUserBPAccess) super.save((X_AD_UserBPAccessInput) entity, environment);
	}

	public List<MUserBPAccess> AD_UserBPAccessSaveMany(List<I_AD_UserBPAccessInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_UserBPAccessInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MUserBPAccess) entity).collect(Collectors.toList());
	}

	public boolean AD_UserBPAccessDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
