package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_MeasureInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_MeasureInput;
import org.compiere.model.MMeasure;

import java.util.List;

/**
 * Generated Query Resolver for PA_Measure - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_MeasureMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_MeasureInput.Table_Name;
	}

	public MMeasure PA_MeasureSave(I_PA_MeasureInput input, DataFetchingEnvironment environment) {
		return (MMeasure) super.save((X_PA_MeasureInput) input, environment);
	}

	public boolean PA_MeasureDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
