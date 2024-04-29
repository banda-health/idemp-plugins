package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_Project_AcctInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_Project_AcctInput;
import org.compiere.model.X_C_Project_Acct;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_Project_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_Project_AcctMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_Project_AcctInput.Table_Name;
	}

	public X_C_Project_Acct C_Project_AcctSave(I_C_Project_AcctInput Entity, DataFetchingEnvironment environment) {
		return (X_C_Project_Acct) super.save((X_C_Project_AcctInput) Entity, environment);
	}

	public List<X_C_Project_Acct> C_Project_AcctSaveMany(List<I_C_Project_AcctInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_Project_AcctInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_C_Project_Acct) entity).collect(Collectors.toList());
	}

	public boolean C_Project_AcctDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
