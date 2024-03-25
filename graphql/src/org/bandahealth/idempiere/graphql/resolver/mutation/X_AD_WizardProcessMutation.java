package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_WizardProcessInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_WizardProcessInput;
import org.compiere.model.X_AD_WizardProcess;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_WizardProcess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_WizardProcessMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_WizardProcessInput.Table_Name;
	}

	public X_AD_WizardProcess AD_WizardProcessSave(I_AD_WizardProcessInput entity, DataFetchingEnvironment environment) {
		return (X_AD_WizardProcess) super.save((X_AD_WizardProcessInput) entity, environment);
	}

	public List<X_AD_WizardProcess> AD_WizardProcessSaveMany(List<I_AD_WizardProcessInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_WizardProcessInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_WizardProcess) entity).collect(Collectors.toList());
	}

	public boolean AD_WizardProcessDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
