package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ArchiveInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ArchiveInput;
import org.compiere.model.MArchive;

import java.util.List;

/**
 * Generated Query Resolver for AD_Archive - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_ArchiveMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ArchiveInput.Table_Name;
	}

	public MArchive AD_ArchiveSave(I_AD_ArchiveInput input, DataFetchingEnvironment environment) {
		return (MArchive) super.save((X_AD_ArchiveInput) input, environment);
	}

	public boolean AD_ArchiveDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
