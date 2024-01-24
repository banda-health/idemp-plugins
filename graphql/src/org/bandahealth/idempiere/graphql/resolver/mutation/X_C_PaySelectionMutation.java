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
 * @version Release 8.2 - $Id$
 */
public class X_C_PaySelectionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_PaySelectionInput.Table_Name;
	}

	public MPaySelection C_PaySelectionSave(I_C_PaySelectionInput entity, DataFetchingEnvironment environment) {
		return (MPaySelection) super.save((X_C_PaySelectionInput) entity, environment);
	}

	public List<MPaySelection> C_PaySelectionSaveMany(List<I_C_PaySelectionInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_PaySelectionInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MPaySelection) entity).collect(Collectors.toList());
	}

	public boolean C_PaySelectionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
