package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ProductionLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ProductionLineInput;
import org.compiere.model.MProductionLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_ProductionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_ProductionLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ProductionLineInput.Table_Name;
	}

	public MProductionLine M_ProductionLineSave(I_M_ProductionLineInput entity, DataFetchingEnvironment environment) {
		return (MProductionLine) super.save((X_M_ProductionLineInput) entity, environment);
	}

	public List<MProductionLine> M_ProductionLineSaveMany(List<I_M_ProductionLineInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_ProductionLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MProductionLine) entity).collect(Collectors.toList());
	}

	public boolean M_ProductionLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
