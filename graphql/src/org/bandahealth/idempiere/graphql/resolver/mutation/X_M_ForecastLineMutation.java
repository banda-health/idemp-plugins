package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ForecastLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ForecastLineInput;
import org.compiere.model.MForecastLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_ForecastLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ForecastLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ForecastLineInput.Table_Name;
	}

	public MForecastLine M_ForecastLineSave(I_M_ForecastLineInput entity, DataFetchingEnvironment environment) {
		return (MForecastLine) super.save((X_M_ForecastLineInput) entity, environment);
	}

	public List<MForecastLine> M_ForecastLineSaveMany(List<I_M_ForecastLineInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_ForecastLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MForecastLine) entity).collect(Collectors.toList());
	}

	public boolean M_ForecastLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
