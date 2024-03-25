package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_InvoiceTaxInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_InvoiceTaxInput;
import org.compiere.model.MInvoiceTax;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_InvoiceTax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_InvoiceTaxMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_InvoiceTaxInput.Table_Name;
	}

	public MInvoiceTax C_InvoiceTaxSave(I_C_InvoiceTaxInput entity, DataFetchingEnvironment environment) {
		return (MInvoiceTax) super.save((X_C_InvoiceTaxInput) entity, environment);
	}

	public List<MInvoiceTax> C_InvoiceTaxSaveMany(List<I_C_InvoiceTaxInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_InvoiceTaxInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MInvoiceTax) entity).collect(Collectors.toList());
	}

	public boolean C_InvoiceTaxDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
