package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_LotInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_LotInput;
import org.compiere.model.MLot;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_Lot - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_LotMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_LotInput.Table_Name;
	}

	public MLot M_LotSave(I_M_LotInput Entity, DataFetchingEnvironment environment) {
		return (MLot) super.save((X_M_LotInput) Entity, environment);
	}

	public List<MLot> M_LotSaveMany(List<I_M_LotInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_LotInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MLot) entity).collect(Collectors.toList());
	}

	public boolean M_LotDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
