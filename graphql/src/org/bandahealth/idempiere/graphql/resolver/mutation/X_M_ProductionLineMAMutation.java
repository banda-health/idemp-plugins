package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ProductionLineMAInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ProductionLineMAInput;
import org.compiere.model.MProductionLineMA;

import java.util.List;

/**
 * Generated Query Resolver for M_ProductionLineMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_ProductionLineMAMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ProductionLineMAInput.Table_Name;
	}

	public MProductionLineMA M_ProductionLineMASave(I_M_ProductionLineMAInput input, DataFetchingEnvironment environment) {
		return (MProductionLineMA) super.save((X_M_ProductionLineMAInput) input, environment);
	}

	public boolean M_ProductionLineMADelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
