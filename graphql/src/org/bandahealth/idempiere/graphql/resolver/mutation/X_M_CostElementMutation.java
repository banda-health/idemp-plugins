package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_CostElementInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_CostElementInput;
import org.compiere.model.MCostElement;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_CostElement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_CostElementMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_CostElementInput.Table_Name;
	}

	public MCostElement M_CostElementSave(I_M_CostElementInput Entity, DataFetchingEnvironment environment) {
		return (MCostElement) super.save((X_M_CostElementInput) Entity, environment);
	}

	public List<MCostElement> M_CostElementSaveMany(List<I_M_CostElementInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_CostElementInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MCostElement) entity).collect(Collectors.toList());
	}

	public boolean M_CostElementDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
