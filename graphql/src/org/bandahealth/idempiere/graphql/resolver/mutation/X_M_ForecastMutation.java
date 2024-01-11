package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ForecastInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ForecastInput;
import org.compiere.model.MForecast;

import java.util.List;

/**
 * Generated Query Resolver for M_Forecast - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ForecastMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ForecastInput.Table_Name;
	}

	public MForecast M_ForecastSave(I_M_ForecastInput input, DataFetchingEnvironment environment) {
		return (MForecast) super.save((X_M_ForecastInput) input, environment);
	}

	public boolean M_ForecastDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
