package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.graphql.model.input.I_C_InvoiceInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_InvoiceInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_Invoice - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_InvoiceMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_InvoiceInput.Table_Name;
	}

	public MInvoice_BH C_InvoiceSave(I_C_InvoiceInput entity, DataFetchingEnvironment environment) {
		return (MInvoice_BH) super.save((X_C_InvoiceInput) entity, environment);
	}

	public List<MInvoice_BH> C_InvoiceSaveMany(List<I_C_InvoiceInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_InvoiceInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MInvoice_BH) entity).collect(Collectors.toList());
	}

	public boolean C_InvoiceDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
