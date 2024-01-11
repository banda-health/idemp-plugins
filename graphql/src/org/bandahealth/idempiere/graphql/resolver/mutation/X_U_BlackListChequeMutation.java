package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_U_BlackListChequeInput;
import org.bandahealth.idempiere.graphql.model.input.X_U_BlackListChequeInput;
import org.compiere.model.MBlackListCheque;

import java.util.List;

/**
 * Generated Query Resolver for U_BlackListCheque - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_U_BlackListChequeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_U_BlackListChequeInput.Table_Name;
	}

	public MBlackListCheque U_BlackListChequeSave(I_U_BlackListChequeInput input, DataFetchingEnvironment environment) {
		return (MBlackListCheque) super.save((X_U_BlackListChequeInput) input, environment);
	}

	public boolean U_BlackListChequeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
