package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.model.input.I_AD_UserInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_UserInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_User - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_UserMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_UserInput.Table_Name;
	}

	public MUser_BH AD_UserSave(I_AD_UserInput entity, DataFetchingEnvironment environment) {
		return (MUser_BH) super.save((X_AD_UserInput) entity, environment);
	}

	public List<MUser_BH> AD_UserSaveMany(List<I_AD_UserInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_UserInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MUser_BH) entity).collect(Collectors.toList());
	}

	public boolean AD_UserDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
