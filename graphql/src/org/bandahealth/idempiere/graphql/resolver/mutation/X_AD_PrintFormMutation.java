package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_PrintFormInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_PrintFormInput;
import org.compiere.model.X_AD_PrintForm;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_PrintForm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_PrintFormMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_PrintFormInput.Table_Name;
	}

	public X_AD_PrintForm AD_PrintFormSave(I_AD_PrintFormInput Entity, DataFetchingEnvironment environment) {
		return (X_AD_PrintForm) super.save((X_AD_PrintFormInput) Entity, environment);
	}

	public List<X_AD_PrintForm> AD_PrintFormSaveMany(List<I_AD_PrintFormInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_PrintFormInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_PrintForm) entity).collect(Collectors.toList());
	}

	public boolean AD_PrintFormDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
