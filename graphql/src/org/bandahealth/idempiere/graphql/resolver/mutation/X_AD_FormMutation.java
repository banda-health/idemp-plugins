package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_FormInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_FormInput;
import org.compiere.model.MForm;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Form - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_FormMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_FormInput.Table_Name;
	}

	public MForm AD_FormSave(I_AD_FormInput entity, DataFetchingEnvironment environment) {
		return (MForm) super.save((X_AD_FormInput) entity, environment);
	}

	public List<MForm> AD_FormSaveMany(List<I_AD_FormInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_FormInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MForm) entity).collect(Collectors.toList());
	}

	public boolean AD_FormDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
