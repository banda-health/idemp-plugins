package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_InvoiceBatchLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_InvoiceBatchLineInput;
import org.compiere.model.MInvoiceBatchLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_InvoiceBatchLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_InvoiceBatchLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_InvoiceBatchLineInput.Table_Name;
	}

	public MInvoiceBatchLine C_InvoiceBatchLineSave(I_C_InvoiceBatchLineInput entity, DataFetchingEnvironment environment) {
		return (MInvoiceBatchLine) super.save((X_C_InvoiceBatchLineInput) entity, environment);
	}

	public List<MInvoiceBatchLine> C_InvoiceBatchLineSaveMany(List<I_C_InvoiceBatchLineInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_InvoiceBatchLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MInvoiceBatchLine) entity).collect(Collectors.toList());
	}

	public boolean C_InvoiceBatchLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
