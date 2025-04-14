package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_SalesStageInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_SalesStageInput;
import org.compiere.model.X_C_SalesStage;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_SalesStage - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_SalesStageMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_SalesStageInput.Table_Name;
	}

	public X_C_SalesStage C_SalesStageSave(I_C_SalesStageInput Entity, DataFetchingEnvironment environment) {
		return (X_C_SalesStage) super.save((X_C_SalesStageInput) Entity, environment);
	}

	public List<X_C_SalesStage> C_SalesStageSaveMany(List<I_C_SalesStageInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_SalesStageInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_C_SalesStage) entity).collect(Collectors.toList());
	}

	public boolean C_SalesStageDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
