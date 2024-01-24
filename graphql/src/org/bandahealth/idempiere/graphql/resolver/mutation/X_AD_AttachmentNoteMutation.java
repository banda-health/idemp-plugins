package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_AttachmentNoteInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_AttachmentNoteInput;
import org.compiere.model.MAttachmentNote;

import java.util.List;

/**
 * Generated Query Resolver for AD_AttachmentNote - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_AttachmentNoteMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_AttachmentNoteInput.Table_Name;
	}

	public MAttachmentNote AD_AttachmentNoteSave(I_AD_AttachmentNoteInput input, DataFetchingEnvironment environment) {
		return (MAttachmentNote) super.save((X_AD_AttachmentNoteInput) input, environment);
	}

	public boolean AD_AttachmentNoteDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
