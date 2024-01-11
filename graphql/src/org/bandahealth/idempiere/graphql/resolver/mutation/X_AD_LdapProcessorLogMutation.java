package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_LdapProcessorLogInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_LdapProcessorLogInput;
import org.compiere.model.MLdapProcessorLog;

import java.util.List;

/**
 * Generated Query Resolver for AD_LdapProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_LdapProcessorLogMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_LdapProcessorLogInput.Table_Name;
	}

	public MLdapProcessorLog AD_LdapProcessorLogSave(I_AD_LdapProcessorLogInput input, DataFetchingEnvironment environment) {
		return (MLdapProcessorLog) super.save((X_AD_LdapProcessorLogInput) input, environment);
	}

	public boolean AD_LdapProcessorLogDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
