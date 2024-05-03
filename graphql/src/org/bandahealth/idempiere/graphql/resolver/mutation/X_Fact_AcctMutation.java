package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_Fact_AcctInput;
import org.bandahealth.idempiere.graphql.model.input.X_Fact_AcctInput;
import org.compiere.model.MFactAcct;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for Fact_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_Fact_AcctMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_Fact_AcctInput.Table_Name;
	}

	public MFactAcct Fact_AcctSave(I_Fact_AcctInput Entity, DataFetchingEnvironment environment) {
		return (MFactAcct) super.save((X_Fact_AcctInput) Entity, environment);
	}

	public List<MFactAcct> Fact_AcctSaveMany(List<I_Fact_AcctInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_Fact_AcctInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MFactAcct) entity).collect(Collectors.toList());
	}

	public boolean Fact_AcctDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
