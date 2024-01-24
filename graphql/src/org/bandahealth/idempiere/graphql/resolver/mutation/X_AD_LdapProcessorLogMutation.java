package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_LdapProcessorLogInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_LdapProcessorLogInput;
import org.compiere.model.MLdapProcessorLog;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_LdapProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_LdapProcessorLogMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_LdapProcessorLogInput.Table_Name;
	}

	public MLdapProcessorLog AD_LdapProcessorLogSave(I_AD_LdapProcessorLogInput entity, DataFetchingEnvironment environment) {
		return (MLdapProcessorLog) super.save((X_AD_LdapProcessorLogInput) entity, environment);
	}

	public List<MLdapProcessorLog> AD_LdapProcessorLogSaveMany(List<I_AD_LdapProcessorLogInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_LdapProcessorLogInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MLdapProcessorLog) entity).collect(Collectors.toList());
	}

	public boolean AD_LdapProcessorLogDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
