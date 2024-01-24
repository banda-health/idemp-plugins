package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ChartInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ChartInput;
import org.compiere.model.MChart;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Chart - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ChartMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ChartInput.Table_Name;
	}

	public MChart AD_ChartSave(I_AD_ChartInput entity, DataFetchingEnvironment environment) {
		return (MChart) super.save((X_AD_ChartInput) entity, environment);
	}

	public List<MChart> AD_ChartSaveMany(List<I_AD_ChartInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_ChartInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MChart) entity).collect(Collectors.toList());
	}

	public boolean AD_ChartDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
