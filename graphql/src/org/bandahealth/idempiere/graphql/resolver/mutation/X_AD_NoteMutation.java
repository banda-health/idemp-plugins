package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_NoteInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_NoteInput;
import org.compiere.model.MNote;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Note - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_NoteMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_NoteInput.Table_Name;
	}

	public MNote AD_NoteSave(I_AD_NoteInput Entity, DataFetchingEnvironment environment) {
		return (MNote) super.save((X_AD_NoteInput) Entity, environment);
	}

	public List<MNote> AD_NoteSaveMany(List<I_AD_NoteInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_NoteInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MNote) entity).collect(Collectors.toList());
	}

	public boolean AD_NoteDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
