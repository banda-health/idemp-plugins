package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.graphql.model.input.I_C_ChargeInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_ChargeInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_Charge - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_ChargeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_ChargeInput.Table_Name;
	}

	public MCharge_BH C_ChargeSave(I_C_ChargeInput Entity, DataFetchingEnvironment environment) {
		return (MCharge_BH) super.save((X_C_ChargeInput) Entity, environment);
	}

	public List<MCharge_BH> C_ChargeSaveMany(List<I_C_ChargeInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_ChargeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MCharge_BH) entity).collect(Collectors.toList());
	}

	public boolean C_ChargeDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
