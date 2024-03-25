package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_User_SubstituteInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_User_SubstituteInput;
import org.compiere.model.X_AD_User_Substitute;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_User_Substitute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_User_SubstituteMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_User_SubstituteInput.Table_Name;
	}

	public X_AD_User_Substitute AD_User_SubstituteSave(I_AD_User_SubstituteInput entity, DataFetchingEnvironment environment) {
		return (X_AD_User_Substitute) super.save((X_AD_User_SubstituteInput) entity, environment);
	}

	public List<X_AD_User_Substitute> AD_User_SubstituteSaveMany(List<I_AD_User_SubstituteInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_User_SubstituteInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_User_Substitute) entity).collect(Collectors.toList());
	}

	public boolean AD_User_SubstituteDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
