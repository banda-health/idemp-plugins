package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_WithholdingInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_WithholdingInput;
import org.compiere.model.MWithholding;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_Withholding - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_WithholdingMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_WithholdingInput.Table_Name;
	}

	public MWithholding C_WithholdingSave(I_C_WithholdingInput entity, DataFetchingEnvironment environment) {
		return (MWithholding) super.save((X_C_WithholdingInput) entity, environment);
	}

	public List<MWithholding> C_WithholdingSaveMany(List<I_C_WithholdingInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_WithholdingInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MWithholding) entity).collect(Collectors.toList());
	}

	public boolean C_WithholdingDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
