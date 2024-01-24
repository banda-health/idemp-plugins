package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.graphql.model.input.I_C_ChargeInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_ChargeInput;

import java.util.List;

/**
 * Generated Query Resolver for C_Charge - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ChargeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_ChargeInput.Table_Name;
	}

	public MCharge_BH C_ChargeSave(I_C_ChargeInput input, DataFetchingEnvironment environment) {
		return (MCharge_BH) super.save((X_C_ChargeInput) input, environment);
	}

	public boolean C_ChargeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
