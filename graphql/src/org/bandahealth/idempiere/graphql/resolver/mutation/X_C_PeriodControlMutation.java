package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_PeriodControlInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_PeriodControlInput;
import org.compiere.model.MPeriodControl;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_PeriodControl - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_PeriodControlMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_PeriodControlInput.Table_Name;
	}

	public MPeriodControl C_PeriodControlSave(I_C_PeriodControlInput Entity, DataFetchingEnvironment environment) {
		return (MPeriodControl) super.save((X_C_PeriodControlInput) Entity, environment);
	}

	public List<MPeriodControl> C_PeriodControlSaveMany(List<I_C_PeriodControlInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_PeriodControlInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MPeriodControl) entity).collect(Collectors.toList());
	}

	public boolean C_PeriodControlDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
