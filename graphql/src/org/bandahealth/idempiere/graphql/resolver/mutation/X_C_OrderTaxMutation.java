package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_OrderTaxInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_OrderTaxInput;
import org.compiere.model.MOrderTax;

import java.util.List;

/**
 * Generated Query Resolver for C_OrderTax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_OrderTaxMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_OrderTaxInput.Table_Name;
	}

	public MOrderTax C_OrderTaxSave(I_C_OrderTaxInput input, DataFetchingEnvironment environment) {
		return (MOrderTax) super.save((X_C_OrderTaxInput) input, environment);
	}

	public boolean C_OrderTaxDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
