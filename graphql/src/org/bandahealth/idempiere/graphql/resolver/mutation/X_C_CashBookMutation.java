package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_CashBookInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_CashBookInput;
import org.compiere.model.MCashBook;

import java.util.List;

/**
 * Generated Query Resolver for C_CashBook - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CashBookMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_CashBookInput.Table_Name;
	}

	public MCashBook C_CashBookSave(I_C_CashBookInput input, DataFetchingEnvironment environment) {
		return (MCashBook) super.save((X_C_CashBookInput) input, environment);
	}

	public boolean C_CashBookDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
