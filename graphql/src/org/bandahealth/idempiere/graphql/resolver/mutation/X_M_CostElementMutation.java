package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_CostElementInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_CostElementInput;
import org.compiere.model.MCostElement;

import java.util.List;

/**
 * Generated Query Resolver for M_CostElement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_CostElementMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_CostElementInput.Table_Name;
	}

	public MCostElement M_CostElementSave(I_M_CostElementInput input, DataFetchingEnvironment environment) {
		return (MCostElement) super.save((X_M_CostElementInput) input, environment);
	}

	public boolean M_CostElementDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
