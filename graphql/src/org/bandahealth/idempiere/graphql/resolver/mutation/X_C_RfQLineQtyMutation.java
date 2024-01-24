package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_RfQLineQtyInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_RfQLineQtyInput;
import org.compiere.model.MRfQLineQty;

import java.util.List;

/**
 * Generated Query Resolver for C_RfQLineQty - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_RfQLineQtyMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_RfQLineQtyInput.Table_Name;
	}

	public MRfQLineQty C_RfQLineQtySave(I_C_RfQLineQtyInput input, DataFetchingEnvironment environment) {
		return (MRfQLineQty) super.save((X_C_RfQLineQtyInput) input, environment);
	}

	public boolean C_RfQLineQtyDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
