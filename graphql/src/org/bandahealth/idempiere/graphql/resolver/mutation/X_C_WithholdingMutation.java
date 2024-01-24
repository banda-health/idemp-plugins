package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_WithholdingInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_WithholdingInput;
import org.compiere.model.MWithholding;

import java.util.List;

/**
 * Generated Query Resolver for C_Withholding - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_WithholdingMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_WithholdingInput.Table_Name;
	}

	public MWithholding C_WithholdingSave(I_C_WithholdingInput input, DataFetchingEnvironment environment) {
		return (MWithholding) super.save((X_C_WithholdingInput) input, environment);
	}

	public boolean C_WithholdingDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
