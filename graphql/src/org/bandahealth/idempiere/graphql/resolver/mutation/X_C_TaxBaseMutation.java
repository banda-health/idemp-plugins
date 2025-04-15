package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_TaxBaseInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_TaxBaseInput;
import org.eevolution.model.X_C_TaxBase;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_TaxBase - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_TaxBaseMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_TaxBaseInput.Table_Name;
	}

	public X_C_TaxBase C_TaxBaseSave(I_C_TaxBaseInput Entity, DataFetchingEnvironment environment) {
		return (X_C_TaxBase) super.save((X_C_TaxBaseInput) Entity, environment);
	}

	public List<X_C_TaxBase> C_TaxBaseSaveMany(List<I_C_TaxBaseInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_TaxBaseInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_C_TaxBase) entity).collect(Collectors.toList());
	}

	public boolean C_TaxBaseDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
