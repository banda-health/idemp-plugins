package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_CostDetailInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_CostDetailInput;
import org.compiere.model.MCostDetail;

import java.util.List;

/**
 * Generated Query Resolver for M_CostDetail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_CostDetailMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_CostDetailInput.Table_Name;
	}

	public MCostDetail M_CostDetailSave(I_M_CostDetailInput input, DataFetchingEnvironment environment) {
		return (MCostDetail) super.save((X_M_CostDetailInput) input, environment);
	}

	public boolean M_CostDetailDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
