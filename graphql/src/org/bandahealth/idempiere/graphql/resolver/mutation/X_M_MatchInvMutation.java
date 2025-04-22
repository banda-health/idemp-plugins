package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_MatchInvInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_MatchInvInput;
import org.compiere.model.MMatchInv;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_MatchInv - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_MatchInvMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_MatchInvInput.Table_Name;
	}

	public MMatchInv M_MatchInvSave(I_M_MatchInvInput Entity, DataFetchingEnvironment environment) {
		return (MMatchInv) super.save((X_M_MatchInvInput) Entity, environment);
	}

	public List<MMatchInv> M_MatchInvSaveMany(List<I_M_MatchInvInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_MatchInvInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MMatchInv) entity).collect(Collectors.toList());
	}

	public boolean M_MatchInvDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
