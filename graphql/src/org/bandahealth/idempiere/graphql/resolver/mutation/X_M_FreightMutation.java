package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_FreightInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_FreightInput;
import org.compiere.model.MFreight;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_Freight - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_FreightMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_FreightInput.Table_Name;
	}

	public MFreight M_FreightSave(I_M_FreightInput Entity, DataFetchingEnvironment environment) {
		return (MFreight) super.save((X_M_FreightInput) Entity, environment);
	}

	public List<MFreight> M_FreightSaveMany(List<I_M_FreightInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_FreightInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MFreight) entity).collect(Collectors.toList());
	}

	public boolean M_FreightDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
