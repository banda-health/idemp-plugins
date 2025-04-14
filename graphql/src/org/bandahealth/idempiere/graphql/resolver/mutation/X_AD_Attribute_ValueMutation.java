package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Attribute_ValueInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_Attribute_ValueInput;
import org.compiere.model.X_AD_Attribute_Value;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Attribute_Value - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_Attribute_ValueMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Attribute_ValueInput.Table_Name;
	}

	public X_AD_Attribute_Value AD_Attribute_ValueSave(I_AD_Attribute_ValueInput Entity, DataFetchingEnvironment environment) {
		return (X_AD_Attribute_Value) super.save((X_AD_Attribute_ValueInput) Entity, environment);
	}

	public List<X_AD_Attribute_Value> AD_Attribute_ValueSaveMany(List<I_AD_Attribute_ValueInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_Attribute_ValueInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_Attribute_Value) entity).collect(Collectors.toList());
	}

	public boolean AD_Attribute_ValueDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
