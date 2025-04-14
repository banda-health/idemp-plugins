package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_ASP_FieldInput;
import org.bandahealth.idempiere.graphql.model.input.X_ASP_FieldInput;
import org.compiere.model.X_ASP_Field;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for ASP_Field - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_ASP_FieldMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_ASP_FieldInput.Table_Name;
	}

	public X_ASP_Field ASP_FieldSave(I_ASP_FieldInput Entity, DataFetchingEnvironment environment) {
		return (X_ASP_Field) super.save((X_ASP_FieldInput) Entity, environment);
	}

	public List<X_ASP_Field> ASP_FieldSaveMany(List<I_ASP_FieldInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_ASP_FieldInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_ASP_Field) entity).collect(Collectors.toList());
	}

	public boolean ASP_FieldDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
