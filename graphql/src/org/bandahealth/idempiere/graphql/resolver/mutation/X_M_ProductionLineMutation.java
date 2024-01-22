package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ProductionLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ProductionLineInput;
import org.compiere.model.MProductionLine;

import java.util.List;

/**
 * Generated Query Resolver for M_ProductionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_ProductionLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ProductionLineInput.Table_Name;
	}

	public MProductionLine M_ProductionLineSave(I_M_ProductionLineInput input, DataFetchingEnvironment environment) {
		return (MProductionLine) super.save((X_M_ProductionLineInput) input, environment);
	}

	public boolean M_ProductionLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
