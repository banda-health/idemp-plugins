package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_PaySelectionCheckInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_PaySelectionCheckInput;
import org.compiere.model.MPaySelectionCheck;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_PaySelectionCheck - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_PaySelectionCheckMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_PaySelectionCheckInput.Table_Name;
	}

	public MPaySelectionCheck C_PaySelectionCheckSave(I_C_PaySelectionCheckInput Entity, DataFetchingEnvironment environment) {
		return (MPaySelectionCheck) super.save((X_C_PaySelectionCheckInput) Entity, environment);
	}

	public List<MPaySelectionCheck> C_PaySelectionCheckSaveMany(List<I_C_PaySelectionCheckInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_PaySelectionCheckInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MPaySelectionCheck) entity).collect(Collectors.toList());
	}

	public boolean C_PaySelectionCheckDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
