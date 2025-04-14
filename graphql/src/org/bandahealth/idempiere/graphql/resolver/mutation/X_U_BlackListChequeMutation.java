package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_U_BlackListChequeInput;
import org.bandahealth.idempiere.graphql.model.input.X_U_BlackListChequeInput;
import org.compiere.model.MBlackListCheque;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for U_BlackListCheque - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_U_BlackListChequeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_U_BlackListChequeInput.Table_Name;
	}

	public MBlackListCheque U_BlackListChequeSave(I_U_BlackListChequeInput Entity, DataFetchingEnvironment environment) {
		return (MBlackListCheque) super.save((X_U_BlackListChequeInput) Entity, environment);
	}

	public List<MBlackListCheque> U_BlackListChequeSaveMany(List<I_U_BlackListChequeInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_U_BlackListChequeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBlackListCheque) entity).collect(Collectors.toList());
	}

	public boolean U_BlackListChequeDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
