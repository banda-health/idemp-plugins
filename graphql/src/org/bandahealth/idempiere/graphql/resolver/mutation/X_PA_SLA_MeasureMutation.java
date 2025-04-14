package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_SLA_MeasureInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_SLA_MeasureInput;
import org.compiere.model.X_PA_SLA_Measure;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for PA_SLA_Measure - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_PA_SLA_MeasureMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_SLA_MeasureInput.Table_Name;
	}

	public X_PA_SLA_Measure PA_SLA_MeasureSave(I_PA_SLA_MeasureInput Entity, DataFetchingEnvironment environment) {
		return (X_PA_SLA_Measure) super.save((X_PA_SLA_MeasureInput) Entity, environment);
	}

	public List<X_PA_SLA_Measure> PA_SLA_MeasureSaveMany(List<I_PA_SLA_MeasureInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_PA_SLA_MeasureInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_PA_SLA_Measure) entity).collect(Collectors.toList());
	}

	public boolean PA_SLA_MeasureDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
