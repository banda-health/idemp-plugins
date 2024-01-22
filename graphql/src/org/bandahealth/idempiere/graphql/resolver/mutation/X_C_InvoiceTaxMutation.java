package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_InvoiceTaxInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_InvoiceTaxInput;
import org.compiere.model.MInvoiceTax;

import java.util.List;

/**
 * Generated Query Resolver for C_InvoiceTax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_InvoiceTaxMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_InvoiceTaxInput.Table_Name;
	}

	public MInvoiceTax C_InvoiceTaxSave(I_C_InvoiceTaxInput input, DataFetchingEnvironment environment) {
		return (MInvoiceTax) super.save((X_C_InvoiceTaxInput) input, environment);
	}

	public boolean C_InvoiceTaxDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
