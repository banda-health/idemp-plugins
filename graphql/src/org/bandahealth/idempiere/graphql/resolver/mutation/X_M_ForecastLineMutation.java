package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ForecastLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ForecastLineInput;
import org.compiere.model.MForecastLine;

import java.util.List;

/**
 * Generated Query Resolver for M_ForecastLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_ForecastLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ForecastLineInput.Table_Name;
	}

	public MForecastLine M_ForecastLineSave(I_M_ForecastLineInput input, DataFetchingEnvironment environment) {
		return (MForecastLine) super.save((X_M_ForecastLineInput) input, environment);
	}

	public boolean M_ForecastLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
