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
 * @version Release 11 - $Id$
 */
public class X_C_PeriodMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_PeriodInput.Table_Name;
	}

	public MPeriod C_PeriodSave(I_C_PeriodInput Entity, DataFetchingEnvironment environment) {
		return (MPeriod) super.save((X_C_PeriodInput) Entity, environment);
	}

	public List<MPeriod> C_PeriodSaveMany(List<I_C_PeriodInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_PeriodInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MPeriod) entity).collect(Collectors.toList());
	}

	public boolean C_PeriodDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
