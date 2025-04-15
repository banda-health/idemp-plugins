package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_TaxTypeInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_TaxTypeInput;
import org.eevolution.model.X_C_TaxType;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_TaxType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_TaxTypeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_TaxTypeInput.Table_Name;
	}

	public X_C_TaxType C_TaxTypeSave(I_C_TaxTypeInput Entity, DataFetchingEnvironment environment) {
		return (X_C_TaxType) super.save((X_C_TaxTypeInput) Entity, environment);
	}

	public List<X_C_TaxType> C_TaxTypeSaveMany(List<I_C_TaxTypeInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_TaxTypeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_C_TaxType) entity).collect(Collectors.toList());
	}

	public boolean C_TaxTypeDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
