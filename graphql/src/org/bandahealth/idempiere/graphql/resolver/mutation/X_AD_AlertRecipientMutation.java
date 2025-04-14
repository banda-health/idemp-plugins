package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_AlertRecipientInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_AlertRecipientInput;
import org.compiere.model.MAlertRecipient;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_AlertRecipient - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_AlertRecipientMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_AlertRecipientInput.Table_Name;
	}

	public MAlertRecipient AD_AlertRecipientSave(I_AD_AlertRecipientInput Entity, DataFetchingEnvironment environment) {
		return (MAlertRecipient) super.save((X_AD_AlertRecipientInput) Entity, environment);
	}

	public List<MAlertRecipient> AD_AlertRecipientSaveMany(List<I_AD_AlertRecipientInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_AlertRecipientInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MAlertRecipient) entity).collect(Collectors.toList());
	}

	public boolean AD_AlertRecipientDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
