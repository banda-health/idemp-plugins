package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_SchedulerRecipientInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_SchedulerRecipientInput;
import org.compiere.model.MSchedulerRecipient;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_SchedulerRecipient - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_SchedulerRecipientMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_SchedulerRecipientInput.Table_Name;
	}

	public MSchedulerRecipient AD_SchedulerRecipientSave(I_AD_SchedulerRecipientInput entity, DataFetchingEnvironment environment) {
		return (MSchedulerRecipient) super.save((X_AD_SchedulerRecipientInput) entity, environment);
	}

	public List<MSchedulerRecipient> AD_SchedulerRecipientSaveMany(List<I_AD_SchedulerRecipientInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_SchedulerRecipientInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MSchedulerRecipient) entity).collect(Collectors.toList());
	}

	public boolean AD_SchedulerRecipientDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
