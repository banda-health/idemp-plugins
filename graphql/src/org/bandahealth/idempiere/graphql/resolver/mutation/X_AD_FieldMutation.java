package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MField_BH;
import org.bandahealth.idempiere.graphql.model.input.I_AD_FieldInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_FieldInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Field - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_FieldMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_FieldInput.Table_Name;
	}

	public MField_BH AD_FieldSave(I_AD_FieldInput Entity, DataFetchingEnvironment environment) {
		return (MField_BH) super.save((X_AD_FieldInput) Entity, environment);
	}

	public List<MField_BH> AD_FieldSaveMany(List<I_AD_FieldInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_FieldInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MField_BH) entity).collect(Collectors.toList());
	}

	public boolean AD_FieldDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
