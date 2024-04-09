package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_MatchPOInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_MatchPOInput;
import org.compiere.model.MMatchPO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_MatchPO - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_MatchPOMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_MatchPOInput.Table_Name;
	}

	public MMatchPO M_MatchPOSave(I_M_MatchPOInput Entity, DataFetchingEnvironment environment) {
		return (MMatchPO) super.save((X_M_MatchPOInput) Entity, environment);
	}

	public List<MMatchPO> M_MatchPOSaveMany(List<I_M_MatchPOInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_MatchPOInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MMatchPO) entity).collect(Collectors.toList());
	}

	public boolean M_MatchPODelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
