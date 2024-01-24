package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_LdapAccessInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_LdapAccessInput;
import org.compiere.model.MLdapAccess;

import java.util.List;

/**
 * Generated Query Resolver for AD_LdapAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_LdapAccessMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_LdapAccessInput.Table_Name;
	}

	public MLdapAccess AD_LdapAccessSave(I_AD_LdapAccessInput input, DataFetchingEnvironment environment) {
		return (MLdapAccess) super.save((X_AD_LdapAccessInput) input, environment);
	}

	public boolean AD_LdapAccessDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
