package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_MailTextInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_MailTextInput;
import org.compiere.model.MMailText;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for R_MailText - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_R_MailTextMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_MailTextInput.Table_Name;
	}

	public MMailText R_MailTextSave(I_R_MailTextInput Entity, DataFetchingEnvironment environment) {
		return (MMailText) super.save((X_R_MailTextInput) Entity, environment);
	}

	public List<MMailText> R_MailTextSaveMany(List<I_R_MailTextInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_R_MailTextInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MMailText) entity).collect(Collectors.toList());
	}

	public boolean R_MailTextDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
