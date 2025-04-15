package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MChargeType_BH;
import org.bandahealth.idempiere.graphql.model.input.I_C_ChargeTypeInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_ChargeTypeInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_ChargeType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_ChargeTypeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_ChargeTypeInput.Table_Name;
	}

	public MChargeType_BH C_ChargeTypeSave(I_C_ChargeTypeInput Entity, DataFetchingEnvironment environment) {
		return (MChargeType_BH) super.save((X_C_ChargeTypeInput) Entity, environment);
	}

	public List<MChargeType_BH> C_ChargeTypeSaveMany(List<I_C_ChargeTypeInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_ChargeTypeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MChargeType_BH) entity).collect(Collectors.toList());
	}

	public boolean C_ChargeTypeDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
