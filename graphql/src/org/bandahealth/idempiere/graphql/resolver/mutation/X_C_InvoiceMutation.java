package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.graphql.model.input.M_C_InvoiceInput;

import java.util.List;

public class X_C_InvoiceMutation implements GraphQLMutationResolver {
	public MInvoice_BH C_InvoiceSave(M_C_InvoiceInput input) {
		input.saveEx();
		// get by uuid for visit input
		return input;
	}

	public boolean C_InvoiceDelete(List<String> uuids) {
		return true;
	}
}
