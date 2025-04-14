package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_BP_ShippingAcctInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_BP_ShippingAcctInput;
import org.compiere.model.X_C_BP_ShippingAcct;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_BP_ShippingAcct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_BP_ShippingAcctMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_BP_ShippingAcctInput.Table_Name;
	}

	public X_C_BP_ShippingAcct C_BP_ShippingAcctSave(I_C_BP_ShippingAcctInput Entity, DataFetchingEnvironment environment) {
		return (X_C_BP_ShippingAcct) super.save((X_C_BP_ShippingAcctInput) Entity, environment);
	}

	public List<X_C_BP_ShippingAcct> C_BP_ShippingAcctSaveMany(List<I_C_BP_ShippingAcctInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_BP_ShippingAcctInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_C_BP_ShippingAcct) entity).collect(Collectors.toList());
	}

	public boolean C_BP_ShippingAcctDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
