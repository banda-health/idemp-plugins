package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_InvoiceLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_InvoiceLineInput;
import org.compiere.model.MInvoiceLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_InvoiceLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_InvoiceLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_InvoiceLineInput.Table_Name;
	}

	public MInvoiceLine C_InvoiceLineSave(I_C_InvoiceLineInput Entity, DataFetchingEnvironment environment) {
		return (MInvoiceLine) super.save((X_C_InvoiceLineInput) Entity, environment);
	}

	public List<MInvoiceLine> C_InvoiceLineSaveMany(List<I_C_InvoiceLineInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_InvoiceLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MInvoiceLine) entity).collect(Collectors.toList());
	}

	public boolean C_InvoiceLineDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
