package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_CashBookInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_CashBookInput;
import org.compiere.model.MCashBook;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_CashBook - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_CashBookMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_CashBookInput.Table_Name;
	}

	public MCashBook C_CashBookSave(I_C_CashBookInput entity, DataFetchingEnvironment environment) {
		return (MCashBook) super.save((X_C_CashBookInput) entity, environment);
	}

	public List<MCashBook> C_CashBookSaveMany(List<I_C_CashBookInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_CashBookInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MCashBook) entity).collect(Collectors.toList());
	}

	public boolean C_CashBookDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
