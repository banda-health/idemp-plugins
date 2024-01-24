package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_ASP_FieldInput;
import org.bandahealth.idempiere.graphql.model.input.X_ASP_FieldInput;
import org.compiere.model.X_ASP_Field;

import java.util.List;

/**
 * Generated Query Resolver for ASP_Field - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_ASP_FieldMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_ASP_FieldInput.Table_Name;
	}

	public X_ASP_Field ASP_FieldSave(I_ASP_FieldInput input, DataFetchingEnvironment environment) {
		return (X_ASP_Field) super.save((X_ASP_FieldInput) input, environment);
	}

	public boolean ASP_FieldDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
