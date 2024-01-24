package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_PeriodInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_PeriodInput;
import org.compiere.model.MPeriod;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_Period - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_PeriodMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_PeriodInput.Table_Name;
	}

	public MPeriod C_PeriodSave(I_C_PeriodInput entity, DataFetchingEnvironment environment) {
		return (MPeriod) super.save((X_C_PeriodInput) entity, environment);
	}

	public List<MPeriod> C_PeriodSaveMany(List<I_C_PeriodInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_PeriodInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MPeriod) entity).collect(Collectors.toList());
	}

	public boolean C_PeriodDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
