package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Tab_CustomizationInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_Tab_CustomizationInput;
import org.compiere.model.X_AD_Tab_Customization;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Tab_Customization - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_Tab_CustomizationMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Tab_CustomizationInput.Table_Name;
	}

	public X_AD_Tab_Customization AD_Tab_CustomizationSave(I_AD_Tab_CustomizationInput entity, DataFetchingEnvironment environment) {
		return (X_AD_Tab_Customization) super.save((X_AD_Tab_CustomizationInput) entity, environment);
	}

	public List<X_AD_Tab_Customization> AD_Tab_CustomizationSaveMany(List<I_AD_Tab_CustomizationInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_Tab_CustomizationInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_Tab_Customization) entity).collect(Collectors.toList());
	}

	public boolean AD_Tab_CustomizationDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
