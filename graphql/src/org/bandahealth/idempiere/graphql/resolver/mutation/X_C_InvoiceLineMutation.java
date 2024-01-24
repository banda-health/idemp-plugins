package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MInvoiceLine_BH;
import org.bandahealth.idempiere.graphql.model.input.I_C_InvoiceLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_InvoiceLineInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_InvoiceLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_InvoiceLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_InvoiceLineInput.Table_Name;
	}

	public MInvoiceLine_BH C_InvoiceLineSave(I_C_InvoiceLineInput entity, DataFetchingEnvironment environment) {
		return (MInvoiceLine_BH) super.save((X_C_InvoiceLineInput) entity, environment);
	}

	public List<MInvoiceLine_BH> C_InvoiceLineSaveMany(List<I_C_InvoiceLineInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_InvoiceLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MInvoiceLine_BH) entity).collect(Collectors.toList());
	}

	public boolean C_InvoiceLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
