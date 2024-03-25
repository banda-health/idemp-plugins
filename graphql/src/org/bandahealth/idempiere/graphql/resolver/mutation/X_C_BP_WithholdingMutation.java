package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_BP_WithholdingInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_BP_WithholdingInput;
import org.compiere.model.X_C_BP_Withholding;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_BP_Withholding - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_BP_WithholdingMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_BP_WithholdingInput.Table_Name;
	}

	public X_C_BP_Withholding C_BP_WithholdingSave(I_C_BP_WithholdingInput entity, DataFetchingEnvironment environment) {
		return (X_C_BP_Withholding) super.save((X_C_BP_WithholdingInput) entity, environment);
	}

	public List<X_C_BP_Withholding> C_BP_WithholdingSaveMany(List<I_C_BP_WithholdingInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_BP_WithholdingInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_C_BP_Withholding) entity).collect(Collectors.toList());
	}

	public boolean C_BP_WithholdingDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
