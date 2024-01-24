package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_InvoiceScheduleInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_InvoiceScheduleInput;
import org.compiere.model.MInvoiceSchedule;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_InvoiceSchedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_InvoiceScheduleMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_InvoiceScheduleInput.Table_Name;
	}

	public MInvoiceSchedule C_InvoiceScheduleSave(I_C_InvoiceScheduleInput entity, DataFetchingEnvironment environment) {
		return (MInvoiceSchedule) super.save((X_C_InvoiceScheduleInput) entity, environment);
	}

	public List<MInvoiceSchedule> C_InvoiceScheduleSaveMany(List<I_C_InvoiceScheduleInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_InvoiceScheduleInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MInvoiceSchedule) entity).collect(Collectors.toList());
	}

	public boolean C_InvoiceScheduleDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
