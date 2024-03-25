package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_CashInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_CashInput;
import org.compiere.model.MCash;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_Cash - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_CashMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_CashInput.Table_Name;
	}

	public MCash C_CashSave(I_C_CashInput entity, DataFetchingEnvironment environment) {
		return (MCash) super.save((X_C_CashInput) entity, environment);
	}

	public List<MCash> C_CashSaveMany(List<I_C_CashInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_CashInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MCash) entity).collect(Collectors.toList());
	}

	public boolean C_CashDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
