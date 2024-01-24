package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_CostTypeInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_CostTypeInput;
import org.compiere.model.MCostType;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_CostType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_CostTypeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_CostTypeInput.Table_Name;
	}

	public MCostType M_CostTypeSave(I_M_CostTypeInput entity, DataFetchingEnvironment environment) {
		return (MCostType) super.save((X_M_CostTypeInput) entity, environment);
	}

	public List<MCostType> M_CostTypeSaveMany(List<I_M_CostTypeInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_CostTypeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MCostType) entity).collect(Collectors.toList());
	}

	public boolean M_CostTypeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
