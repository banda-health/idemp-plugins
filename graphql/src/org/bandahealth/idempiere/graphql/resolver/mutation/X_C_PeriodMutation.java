package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_PeriodInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_PeriodInput;
import org.compiere.model.MPeriod;

import java.util.List;

/**
 * Generated Query Resolver for C_Period - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_PeriodMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_PeriodInput.Table_Name;
	}

	public MPeriod C_PeriodSave(I_C_PeriodInput input, DataFetchingEnvironment environment) {
		return (MPeriod) super.save((X_C_PeriodInput) input, environment);
	}

	public boolean C_PeriodDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
