package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_I_InvoiceInput;
import org.bandahealth.idempiere.graphql.model.input.X_I_InvoiceInput;
import org.compiere.model.X_I_Invoice;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for I_Invoice - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_I_InvoiceMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_I_InvoiceInput.Table_Name;
	}

	public X_I_Invoice I_InvoiceSave(I_I_InvoiceInput entity, DataFetchingEnvironment environment) {
		return (X_I_Invoice) super.save((X_I_InvoiceInput) entity, environment);
	}

	public List<X_I_Invoice> I_InvoiceSaveMany(List<I_I_InvoiceInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_I_InvoiceInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_I_Invoice) entity).collect(Collectors.toList());
	}

	public boolean I_InvoiceDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
