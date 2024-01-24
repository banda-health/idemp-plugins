package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Form_AccessInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_Form_AccessInput;
import org.compiere.model.MFormAccess;

import java.util.List;

/**
 * Generated Query Resolver for AD_Form_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_Form_AccessMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Form_AccessInput.Table_Name;
	}

	public MFormAccess AD_Form_AccessSave(I_AD_Form_AccessInput input, DataFetchingEnvironment environment) {
		return (MFormAccess) super.save((X_AD_Form_AccessInput) input, environment);
	}

	public boolean AD_Form_AccessDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
