package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_RegistrationProductInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_RegistrationProductInput;
import org.compiere.model.X_A_RegistrationProduct;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for A_RegistrationProduct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_A_RegistrationProductMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_RegistrationProductInput.Table_Name;
	}

	public X_A_RegistrationProduct A_RegistrationProductSave(I_A_RegistrationProductInput entity, DataFetchingEnvironment environment) {
		return (X_A_RegistrationProduct) super.save((X_A_RegistrationProductInput) entity, environment);
	}

	public List<X_A_RegistrationProduct> A_RegistrationProductSaveMany(List<I_A_RegistrationProductInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_A_RegistrationProductInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_A_RegistrationProduct) entity).collect(Collectors.toList());
	}

	public boolean A_RegistrationProductDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
