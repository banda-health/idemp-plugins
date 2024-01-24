package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_AlertRecipientInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_AlertRecipientInput;
import org.compiere.model.MAlertRecipient;

import java.util.List;

/**
 * Generated Query Resolver for AD_AlertRecipient - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_AlertRecipientMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_AlertRecipientInput.Table_Name;
	}

	public MAlertRecipient AD_AlertRecipientSave(I_AD_AlertRecipientInput input, DataFetchingEnvironment environment) {
		return (MAlertRecipient) super.save((X_AD_AlertRecipientInput) input, environment);
	}

	public boolean AD_AlertRecipientDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
