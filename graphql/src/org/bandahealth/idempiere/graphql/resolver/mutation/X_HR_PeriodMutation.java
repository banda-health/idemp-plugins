package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_HR_PeriodInput;
import org.bandahealth.idempiere.graphql.model.input.X_HR_PeriodInput;
import org.eevolution.model.X_HR_Period;

import java.util.List;

/**
 * Generated Query Resolver for HR_Period - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_HR_PeriodMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_HR_PeriodInput.Table_Name;
	}

	public X_HR_Period HR_PeriodSave(I_HR_PeriodInput input, DataFetchingEnvironment environment) {
		return (X_HR_Period) super.save((X_HR_PeriodInput) input, environment);
	}

	public boolean HR_PeriodDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
