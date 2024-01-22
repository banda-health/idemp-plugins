package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.graphql.model.input.I_C_InvoiceInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_InvoiceInput;

import java.util.List;

/**
 * Generated Query Resolver for C_Invoice - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_InvoiceMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_InvoiceInput.Table_Name;
	}

	public MInvoice_BH C_InvoiceSave(I_C_InvoiceInput input, DataFetchingEnvironment environment) {
		return (MInvoice_BH) super.save((X_C_InvoiceInput) input, environment);
	}

	public boolean C_InvoiceDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
