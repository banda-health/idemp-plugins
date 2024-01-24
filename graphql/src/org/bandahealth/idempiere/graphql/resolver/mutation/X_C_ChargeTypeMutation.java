package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MChargeType_BH;
import org.bandahealth.idempiere.graphql.model.input.I_C_ChargeTypeInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_ChargeTypeInput;

import java.util.List;

/**
 * Generated Query Resolver for C_ChargeType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_ChargeTypeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_ChargeTypeInput.Table_Name;
	}

	public MChargeType_BH C_ChargeTypeSave(I_C_ChargeTypeInput input, DataFetchingEnvironment environment) {
		return (MChargeType_BH) super.save((X_C_ChargeTypeInput) input, environment);
	}

	public boolean C_ChargeTypeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
