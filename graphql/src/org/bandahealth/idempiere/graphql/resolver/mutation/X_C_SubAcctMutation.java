package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_SubAcctInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_SubAcctInput;
import org.compiere.model.X_C_SubAcct;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_SubAcct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_SubAcctMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_SubAcctInput.Table_Name;
	}

	public X_C_SubAcct C_SubAcctSave(I_C_SubAcctInput entity, DataFetchingEnvironment environment) {
		return (X_C_SubAcct) super.save((X_C_SubAcctInput) entity, environment);
	}

	public List<X_C_SubAcct> C_SubAcctSaveMany(List<I_C_SubAcctInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_SubAcctInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_C_SubAcct) entity).collect(Collectors.toList());
	}

	public boolean C_SubAcctDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
