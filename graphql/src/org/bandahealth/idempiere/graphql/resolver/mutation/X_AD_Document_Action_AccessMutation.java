package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Document_Action_AccessInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_Document_Action_AccessInput;
import org.compiere.model.X_AD_Document_Action_Access;

import java.util.List;

/**
 * Generated Query Resolver for AD_Document_Action_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Document_Action_AccessMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Document_Action_AccessInput.Table_Name;
	}

	public X_AD_Document_Action_Access AD_Document_Action_AccessSave(I_AD_Document_Action_AccessInput input, DataFetchingEnvironment environment) {
		return (X_AD_Document_Action_Access) super.save((X_AD_Document_Action_AccessInput) input, environment);
	}

	public boolean AD_Document_Action_AccessDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
