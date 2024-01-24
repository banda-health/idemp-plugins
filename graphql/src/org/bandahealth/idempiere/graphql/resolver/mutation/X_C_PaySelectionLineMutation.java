package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_PaySelectionLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_PaySelectionLineInput;
import org.compiere.model.MPaySelectionLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_PaySelectionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_PaySelectionLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_PaySelectionLineInput.Table_Name;
	}

	public MPaySelectionLine C_PaySelectionLineSave(I_C_PaySelectionLineInput entity, DataFetchingEnvironment environment) {
		return (MPaySelectionLine) super.save((X_C_PaySelectionLineInput) entity, environment);
	}

	public List<MPaySelectionLine> C_PaySelectionLineSaveMany(List<I_C_PaySelectionLineInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_PaySelectionLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MPaySelectionLine) entity).collect(Collectors.toList());
	}

	public boolean C_PaySelectionLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
