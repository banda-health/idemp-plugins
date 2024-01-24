package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_UserDef_FieldInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_UserDef_FieldInput;
import org.compiere.model.MUserDefField;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_UserDef_Field - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_UserDef_FieldMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_UserDef_FieldInput.Table_Name;
	}

	public MUserDefField AD_UserDef_FieldSave(I_AD_UserDef_FieldInput entity, DataFetchingEnvironment environment) {
		return (MUserDefField) super.save((X_AD_UserDef_FieldInput) entity, environment);
	}

	public List<MUserDefField> AD_UserDef_FieldSaveMany(List<I_AD_UserDef_FieldInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_UserDef_FieldInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MUserDefField) entity).collect(Collectors.toList());
	}

	public boolean AD_UserDef_FieldDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
