package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_MailTextInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_MailTextInput;
import org.compiere.model.MMailText;

import java.util.List;

/**
 * Generated Query Resolver for R_MailText - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_R_MailTextMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_MailTextInput.Table_Name;
	}

	public MMailText R_MailTextSave(I_R_MailTextInput input, DataFetchingEnvironment environment) {
		return (MMailText) super.save((X_R_MailTextInput) input, environment);
	}

	public boolean R_MailTextDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
