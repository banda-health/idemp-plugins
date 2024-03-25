package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Password_HistoryInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_Password_HistoryInput;
import org.compiere.model.MPasswordHistory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Password_History - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Password_HistoryMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Password_HistoryInput.Table_Name;
	}

	public MPasswordHistory AD_Password_HistorySave(I_AD_Password_HistoryInput entity, DataFetchingEnvironment environment) {
		return (MPasswordHistory) super.save((X_AD_Password_HistoryInput) entity, environment);
	}

	public List<MPasswordHistory> AD_Password_HistorySaveMany(List<I_AD_Password_HistoryInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_Password_HistoryInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MPasswordHistory) entity).collect(Collectors.toList());
	}

	public boolean AD_Password_HistoryDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
