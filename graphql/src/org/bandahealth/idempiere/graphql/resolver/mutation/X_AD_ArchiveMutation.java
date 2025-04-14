package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ArchiveInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ArchiveInput;
import org.compiere.model.MArchive;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Archive - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_ArchiveMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ArchiveInput.Table_Name;
	}

	public MArchive AD_ArchiveSave(I_AD_ArchiveInput Entity, DataFetchingEnvironment environment) {
		return (MArchive) super.save((X_AD_ArchiveInput) Entity, environment);
	}

	public List<MArchive> AD_ArchiveSaveMany(List<I_AD_ArchiveInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_ArchiveInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MArchive) entity).collect(Collectors.toList());
	}

	public boolean AD_ArchiveDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
