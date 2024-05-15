package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ProductDownloadInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ProductDownloadInput;
import org.compiere.model.MProductDownload;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_ProductDownload - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_ProductDownloadMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ProductDownloadInput.Table_Name;
	}

	public MProductDownload M_ProductDownloadSave(I_M_ProductDownloadInput Entity, DataFetchingEnvironment environment) {
		return (MProductDownload) super.save((X_M_ProductDownloadInput) Entity, environment);
	}

	public List<MProductDownload> M_ProductDownloadSaveMany(List<I_M_ProductDownloadInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_ProductDownloadInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MProductDownload) entity).collect(Collectors.toList());
	}

	public boolean M_ProductDownloadDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
