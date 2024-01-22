package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MField_BH;
import org.bandahealth.idempiere.graphql.model.input.I_AD_FieldInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_FieldInput;

import java.util.List;

/**
 * Generated Query Resolver for AD_Field - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_FieldMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_FieldInput.Table_Name;
	}

	public MField_BH AD_FieldSave(I_AD_FieldInput input, DataFetchingEnvironment environment) {
		return (MField_BH) super.save((X_AD_FieldInput) input, environment);
	}

	public boolean AD_FieldDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
