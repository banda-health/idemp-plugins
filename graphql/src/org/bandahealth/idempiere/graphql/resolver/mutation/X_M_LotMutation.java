package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_LotInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_LotInput;
import org.compiere.model.MLot;

import java.util.List;

/**
 * Generated Query Resolver for M_Lot - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_LotMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_LotInput.Table_Name;
	}

	public MLot M_LotSave(I_M_LotInput input, DataFetchingEnvironment environment) {
		return (MLot) super.save((X_M_LotInput) input, environment);
	}

	public boolean M_LotDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
