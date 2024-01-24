package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_SLA_MeasureInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_SLA_MeasureInput;
import org.compiere.model.MSLAMeasure;

import java.util.List;

/**
 * Generated Query Resolver for PA_SLA_Measure - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_PA_SLA_MeasureMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_SLA_MeasureInput.Table_Name;
	}

	public MSLAMeasure PA_SLA_MeasureSave(I_PA_SLA_MeasureInput input, DataFetchingEnvironment environment) {
		return (MSLAMeasure) super.save((X_PA_SLA_MeasureInput) input, environment);
	}

	public boolean PA_SLA_MeasureDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
