package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_LdapProcessorInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_LdapProcessorInput;
import org.compiere.model.MLdapProcessor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_LdapProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_LdapProcessorMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_LdapProcessorInput.Table_Name;
	}

	public MLdapProcessor AD_LdapProcessorSave(I_AD_LdapProcessorInput Entity, DataFetchingEnvironment environment) {
		return (MLdapProcessor) super.save((X_AD_LdapProcessorInput) Entity, environment);
	}

	public List<MLdapProcessor> AD_LdapProcessorSaveMany(List<I_AD_LdapProcessorInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_LdapProcessorInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MLdapProcessor) entity).collect(Collectors.toList());
	}

	public boolean AD_LdapProcessorDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
