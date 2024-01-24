package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_LdapProcessorInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_LdapProcessorInput;
import org.compiere.model.MLdapProcessor;

import java.util.List;

/**
 * Generated Query Resolver for AD_LdapProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_LdapProcessorMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_LdapProcessorInput.Table_Name;
	}

	public MLdapProcessor AD_LdapProcessorSave(I_AD_LdapProcessorInput input, DataFetchingEnvironment environment) {
		return (MLdapProcessor) super.save((X_AD_LdapProcessorInput) input, environment);
	}

	public boolean AD_LdapProcessorDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
