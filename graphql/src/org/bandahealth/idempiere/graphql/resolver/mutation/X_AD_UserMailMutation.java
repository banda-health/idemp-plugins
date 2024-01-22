package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_UserMailInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_UserMailInput;
import org.compiere.model.MUserMail;

import java.util.List;

/**
 * Generated Query Resolver for AD_UserMail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_UserMailMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_UserMailInput.Table_Name;
	}

	public MUserMail AD_UserMailSave(I_AD_UserMailInput input, DataFetchingEnvironment environment) {
		return (MUserMail) super.save((X_AD_UserMailInput) input, environment);
	}

	public boolean AD_UserMailDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
