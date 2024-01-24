package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_RegistrationAttributeInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_RegistrationAttributeInput;
import org.compiere.model.MRegistrationAttribute;

import java.util.List;

/**
 * Generated Query Resolver for A_RegistrationAttribute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_RegistrationAttributeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_RegistrationAttributeInput.Table_Name;
	}

	public MRegistrationAttribute A_RegistrationAttributeSave(I_A_RegistrationAttributeInput input, DataFetchingEnvironment environment) {
		return (MRegistrationAttribute) super.save((X_A_RegistrationAttributeInput) input, environment);
	}

	public boolean A_RegistrationAttributeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
