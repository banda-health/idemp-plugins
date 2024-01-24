package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Depreciation_ForecastInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Depreciation_ForecastInput;
import org.compiere.model.X_A_Depreciation_Forecast;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for A_Depreciation_Forecast - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_A_Depreciation_ForecastMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Depreciation_ForecastInput.Table_Name;
	}

	public X_A_Depreciation_Forecast A_Depreciation_ForecastSave(I_A_Depreciation_ForecastInput entity, DataFetchingEnvironment environment) {
		return (X_A_Depreciation_Forecast) super.save((X_A_Depreciation_ForecastInput) entity, environment);
	}

	public List<X_A_Depreciation_Forecast> A_Depreciation_ForecastSaveMany(List<I_A_Depreciation_ForecastInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_A_Depreciation_ForecastInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_A_Depreciation_Forecast) entity).collect(Collectors.toList());
	}

	public boolean A_Depreciation_ForecastDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
