package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_HR_PeriodInput;
import org.bandahealth.idempiere.graphql.model.input.X_HR_PeriodInput;
import org.eevolution.model.X_HR_Period;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for HR_Period - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_HR_PeriodMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_HR_PeriodInput.Table_Name;
	}

	public X_HR_Period HR_PeriodSave(I_HR_PeriodInput Entity, DataFetchingEnvironment environment) {
		return (X_HR_Period) super.save((X_HR_PeriodInput) Entity, environment);
	}

	public List<X_HR_Period> HR_PeriodSaveMany(List<I_HR_PeriodInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_HR_PeriodInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_HR_Period) entity).collect(Collectors.toList());
	}

	public boolean HR_PeriodDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
