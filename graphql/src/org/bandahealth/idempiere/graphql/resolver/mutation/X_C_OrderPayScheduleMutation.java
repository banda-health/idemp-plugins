package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_OrderPayScheduleInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_OrderPayScheduleInput;
import org.compiere.model.MOrderPaySchedule;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_OrderPaySchedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_OrderPayScheduleMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_OrderPayScheduleInput.Table_Name;
	}

	public MOrderPaySchedule C_OrderPayScheduleSave(I_C_OrderPayScheduleInput entity, DataFetchingEnvironment environment) {
		return (MOrderPaySchedule) super.save((X_C_OrderPayScheduleInput) entity, environment);
	}

	public List<MOrderPaySchedule> C_OrderPayScheduleSaveMany(List<I_C_OrderPayScheduleInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_OrderPayScheduleInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MOrderPaySchedule) entity).collect(Collectors.toList());
	}

	public boolean C_OrderPayScheduleDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
