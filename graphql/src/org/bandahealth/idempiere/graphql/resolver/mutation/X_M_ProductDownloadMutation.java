package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ProductDownloadInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ProductDownloadInput;
import org.compiere.model.MProductDownload;

import java.util.List;

/**
 * Generated Query Resolver for M_ProductDownload - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_ProductDownloadMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ProductDownloadInput.Table_Name;
	}

	public MProductDownload M_ProductDownloadSave(I_M_ProductDownloadInput input, DataFetchingEnvironment environment) {
		return (MProductDownload) super.save((X_M_ProductDownloadInput) input, environment);
	}

	public boolean M_ProductDownloadDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
