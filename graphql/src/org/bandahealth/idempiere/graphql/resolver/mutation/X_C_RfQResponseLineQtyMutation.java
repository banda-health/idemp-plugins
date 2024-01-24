package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_RfQResponseLineQtyInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_RfQResponseLineQtyInput;
import org.compiere.model.MRfQResponseLineQty;

import java.util.List;

/**
 * Generated Query Resolver for C_RfQResponseLineQty - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_RfQResponseLineQtyMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_RfQResponseLineQtyInput.Table_Name;
	}

	public MRfQResponseLineQty C_RfQResponseLineQtySave(I_C_RfQResponseLineQtyInput input, DataFetchingEnvironment environment) {
		return (MRfQResponseLineQty) super.save((X_C_RfQResponseLineQtyInput) input, environment);
	}

	public boolean C_RfQResponseLineQtyDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
