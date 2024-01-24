package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_MeasureCalcInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_MeasureCalcInput;
import org.compiere.model.MMeasureCalc;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for PA_MeasureCalc - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_MeasureCalcMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_MeasureCalcInput.Table_Name;
	}

	public MMeasureCalc PA_MeasureCalcSave(I_PA_MeasureCalcInput entity, DataFetchingEnvironment environment) {
		return (MMeasureCalc) super.save((X_PA_MeasureCalcInput) entity, environment);
	}

	public List<MMeasureCalc> PA_MeasureCalcSaveMany(List<I_PA_MeasureCalcInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_PA_MeasureCalcInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MMeasureCalc) entity).collect(Collectors.toList());
	}

	public boolean PA_MeasureCalcDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
