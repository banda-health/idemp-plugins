package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_LdapAccessInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_LdapAccessInput;
import org.compiere.model.MLdapAccess;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_LdapAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_LdapAccessMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_LdapAccessInput.Table_Name;
	}

	public MLdapAccess AD_LdapAccessSave(I_AD_LdapAccessInput Entity, DataFetchingEnvironment environment) {
		return (MLdapAccess) super.save((X_AD_LdapAccessInput) Entity, environment);
	}

	public List<MLdapAccess> AD_LdapAccessSaveMany(List<I_AD_LdapAccessInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_LdapAccessInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MLdapAccess) entity).collect(Collectors.toList());
	}

	public boolean AD_LdapAccessDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
