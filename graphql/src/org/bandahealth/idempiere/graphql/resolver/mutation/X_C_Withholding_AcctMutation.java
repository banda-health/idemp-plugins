package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_Withholding_AcctInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_Withholding_AcctInput;
import org.compiere.model.X_C_Withholding_Acct;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_Withholding_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_Withholding_AcctMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_Withholding_AcctInput.Table_Name;
	}

	public X_C_Withholding_Acct C_Withholding_AcctSave(I_C_Withholding_AcctInput entity, DataFetchingEnvironment environment) {
		return (X_C_Withholding_Acct) super.save((X_C_Withholding_AcctInput) entity, environment);
	}

	public List<X_C_Withholding_Acct> C_Withholding_AcctSaveMany(List<I_C_Withholding_AcctInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_Withholding_AcctInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_C_Withholding_Acct) entity).collect(Collectors.toList());
	}

	public boolean C_Withholding_AcctDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
