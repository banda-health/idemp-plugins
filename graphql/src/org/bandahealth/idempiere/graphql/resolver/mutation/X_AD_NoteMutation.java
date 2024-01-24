package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_NoteInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_NoteInput;
import org.compiere.model.MNote;

import java.util.List;

/**
 * Generated Query Resolver for AD_Note - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_NoteMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_NoteInput.Table_Name;
	}

	public MNote AD_NoteSave(I_AD_NoteInput input, DataFetchingEnvironment environment) {
		return (MNote) super.save((X_AD_NoteInput) input, environment);
	}

	public boolean AD_NoteDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
