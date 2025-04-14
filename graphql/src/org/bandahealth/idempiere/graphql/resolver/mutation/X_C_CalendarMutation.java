package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_CalendarInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_CalendarInput;
import org.compiere.model.MCalendar;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_Calendar - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_CalendarMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_CalendarInput.Table_Name;
	}

	public MCalendar C_CalendarSave(I_C_CalendarInput Entity, DataFetchingEnvironment environment) {
		return (MCalendar) super.save((X_C_CalendarInput) Entity, environment);
	}

	public List<MCalendar> C_CalendarSaveMany(List<I_C_CalendarInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_CalendarInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MCalendar) entity).collect(Collectors.toList());
	}

	public boolean C_CalendarDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
