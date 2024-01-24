package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_InvoiceBatchInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_InvoiceBatchInput;
import org.compiere.model.MInvoiceBatch;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_InvoiceBatch - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_InvoiceBatchMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_InvoiceBatchInput.Table_Name;
	}

	public MInvoiceBatch C_InvoiceBatchSave(I_C_InvoiceBatchInput entity, DataFetchingEnvironment environment) {
		return (MInvoiceBatch) super.save((X_C_InvoiceBatchInput) entity, environment);
	}

	public List<MInvoiceBatch> C_InvoiceBatchSaveMany(List<I_C_InvoiceBatchInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_InvoiceBatchInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MInvoiceBatch) entity).collect(Collectors.toList());
	}

	public boolean C_InvoiceBatchDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
