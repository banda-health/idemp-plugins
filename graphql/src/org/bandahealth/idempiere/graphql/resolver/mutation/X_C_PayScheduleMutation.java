package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_PayScheduleInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_PayScheduleInput;
import org.compiere.model.MPaySchedule;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_PaySchedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_PayScheduleMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_PayScheduleInput.Table_Name;
	}

	public MPaySchedule C_PayScheduleSave(I_C_PayScheduleInput Entity, DataFetchingEnvironment environment) {
		return (MPaySchedule) super.save((X_C_PayScheduleInput) Entity, environment);
	}

	public List<MPaySchedule> C_PayScheduleSaveMany(List<I_C_PayScheduleInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_PayScheduleInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MPaySchedule) entity).collect(Collectors.toList());
	}

	public boolean C_PayScheduleDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
