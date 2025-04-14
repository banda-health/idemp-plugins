package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_PaySelectionInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_PaySelectionInput;
import org.compiere.model.MPaySelection;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_PaySelection - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_PaySelectionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_PaySelectionInput.Table_Name;
	}

	public MPaySelection C_PaySelectionSave(I_C_PaySelectionInput Entity, DataFetchingEnvironment environment) {
		return (MPaySelection) super.save((X_C_PaySelectionInput) Entity, environment);
	}

	public List<MPaySelection> C_PaySelectionSaveMany(List<I_C_PaySelectionInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_PaySelectionInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MPaySelection) entity).collect(Collectors.toList());
	}

	public boolean C_PaySelectionDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
