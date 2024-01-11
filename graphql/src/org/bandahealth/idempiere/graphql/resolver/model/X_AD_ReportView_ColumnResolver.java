package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ColumnDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ReportViewDataLoader;
import org.compiere.model.MColumn;
import org.compiere.model.MReportView;
import org.compiere.model.X_AD_ReportView_Column;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_ReportView_Column - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ReportView_ColumnResolver extends POResolver<X_AD_ReportView_Column> implements GraphQLResolver<X_AD_ReportView_Column> {



	/**
	 * Get Column.
	 *
	 * @return Column in the table
	 */
	public CompletableFuture<MColumn> AD_Column(X_AD_ReportView_Column entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Column_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MColumn> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ColumnDataLoader.AD_Column_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Column_ID());
	}


	/**
	 * Get Report View.
	 *
	 * @return View used to generate this report
	 */
	public CompletableFuture<MReportView> AD_ReportView(X_AD_ReportView_Column entity, DataFetchingEnvironment environment) {
		if (entity.getAD_ReportView_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MReportView> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ReportViewDataLoader.AD_ReportView_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_ReportView_ID());
	}

}
