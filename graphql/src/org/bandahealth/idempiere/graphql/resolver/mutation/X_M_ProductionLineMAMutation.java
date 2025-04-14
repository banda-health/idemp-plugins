package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ProductionLineMAInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ProductionLineMAInput;
import org.compiere.model.MProductionLineMA;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_ProductionLineMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_ProductionLineMAMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ProductionLineMAInput.Table_Name;
	}

	public MProductionLineMA M_ProductionLineMASave(I_M_ProductionLineMAInput Entity, DataFetchingEnvironment environment) {
		return (MProductionLineMA) super.save((X_M_ProductionLineMAInput) Entity, environment);
	}

	public List<MProductionLineMA> M_ProductionLineMASaveMany(List<I_M_ProductionLineMAInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_ProductionLineMAInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MProductionLineMA) entity).collect(Collectors.toList());
	}

	public boolean M_ProductionLineMADelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
