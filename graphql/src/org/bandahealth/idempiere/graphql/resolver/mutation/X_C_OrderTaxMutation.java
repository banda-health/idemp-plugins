package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_OrderTaxInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_OrderTaxInput;
import org.compiere.model.MOrderTax;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_OrderTax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_OrderTaxMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_OrderTaxInput.Table_Name;
	}

	public MOrderTax C_OrderTaxSave(I_C_OrderTaxInput Entity, DataFetchingEnvironment environment) {
		return (MOrderTax) super.save((X_C_OrderTaxInput) Entity, environment);
	}

	public List<MOrderTax> C_OrderTaxSaveMany(List<I_C_OrderTaxInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_OrderTaxInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MOrderTax) entity).collect(Collectors.toList());
	}

	public boolean C_OrderTaxDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
