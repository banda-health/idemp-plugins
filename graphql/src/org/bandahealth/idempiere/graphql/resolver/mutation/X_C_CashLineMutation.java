package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_CashLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_CashLineInput;
import org.compiere.model.MCashLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_CashLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_CashLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_CashLineInput.Table_Name;
	}

	public MCashLine C_CashLineSave(I_C_CashLineInput entity, DataFetchingEnvironment environment) {
		return (MCashLine) super.save((X_C_CashLineInput) entity, environment);
	}

	public List<MCashLine> C_CashLineSaveMany(List<I_C_CashLineInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_CashLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MCashLine) entity).collect(Collectors.toList());
	}

	public boolean C_CashLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
