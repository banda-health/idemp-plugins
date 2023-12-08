package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.graphql.model.input.M_C_BPartnerInput;
import org.bandahealth.idempiere.graphql.model.input.M_C_InvoiceInput;

import java.util.List;

public class X_C_BPartnerMutation implements GraphQLMutationResolver {
	public MBPartner_BH C_BPartnerSave(M_C_BPartnerInput input) {
		input.saveEx();
		// get by uuid for visit input
		return input;
	}

	public boolean C_BPartnerDelete(List<String> uuids) {
		return true;
	}
}
