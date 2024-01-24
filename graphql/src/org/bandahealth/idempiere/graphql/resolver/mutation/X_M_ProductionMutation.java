package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ProductionInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ProductionInput;
import org.compiere.model.MProduction;

import java.util.List;
import java.util.stream.Collectors;

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

	public MProduction M_ProductionSave(I_M_ProductionInput entity, DataFetchingEnvironment environment) {
		return (MProduction) super.save((X_M_ProductionInput) entity, environment);
	}

	public List<MProduction> M_ProductionSaveMany(List<I_M_ProductionInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_ProductionInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MProduction) entity).collect(Collectors.toList());
	}

	public boolean M_ProductionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
