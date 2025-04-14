package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ForecastInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ForecastInput;
import org.compiere.model.MForecast;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_Forecast - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_ForecastMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ForecastInput.Table_Name;
	}

	public MForecast M_ForecastSave(I_M_ForecastInput Entity, DataFetchingEnvironment environment) {
		return (MForecast) super.save((X_M_ForecastInput) Entity, environment);
	}

	public List<MForecast> M_ForecastSaveMany(List<I_M_ForecastInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_ForecastInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MForecast) entity).collect(Collectors.toList());
	}

	public boolean M_ForecastDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
