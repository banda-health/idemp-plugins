package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ProductionInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ProductionInput;
import org.compiere.model.MProduction;

import java.util.List;

/**
 * Generated Query Resolver for M_Production - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ProductionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ProductionInput.Table_Name;
	}

	public MProduction M_ProductionSave(I_M_ProductionInput input, DataFetchingEnvironment environment) {
		return (MProduction) super.save((X_M_ProductionInput) input, environment);
	}

	public boolean M_ProductionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
