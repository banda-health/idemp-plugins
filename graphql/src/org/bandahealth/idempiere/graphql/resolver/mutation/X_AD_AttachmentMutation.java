package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_AttachmentInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_AttachmentInput;
import org.compiere.model.MAttachment;

import java.util.List;

/**
 * Generated Query Resolver for AD_Attachment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_AttachmentMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_AttachmentInput.Table_Name;
	}

	public MAttachment AD_AttachmentSave(I_AD_AttachmentInput input, DataFetchingEnvironment environment) {
		return (MAttachment) super.save((X_AD_AttachmentInput) input, environment);
	}

	public boolean AD_AttachmentDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
