package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_InvoicePayScheduleInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_InvoicePayScheduleInput;
import org.compiere.model.MInvoicePaySchedule;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_InvoicePaySchedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_InvoicePayScheduleMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_InvoicePayScheduleInput.Table_Name;
	}

	public MInvoicePaySchedule C_InvoicePayScheduleSave(I_C_InvoicePayScheduleInput entity, DataFetchingEnvironment environment) {
		return (MInvoicePaySchedule) super.save((X_C_InvoicePayScheduleInput) entity, environment);
	}

	public List<MInvoicePaySchedule> C_InvoicePayScheduleSaveMany(List<I_C_InvoicePayScheduleInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_InvoicePayScheduleInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MInvoicePaySchedule) entity).collect(Collectors.toList());
	}

	public boolean C_InvoicePayScheduleDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
