package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_LabelPrinterDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.compiere.model.MTable;
import org.compiere.model.X_AD_LabelPrinter;
import org.compiere.model.X_AD_PrintLabel;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_PrintLabel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_PrintLabelResolver extends POResolver<X_AD_PrintLabel> implements GraphQLResolver<X_AD_PrintLabel> {



	/**
	 * Get Label printer.
	 *
	 * @return Label Printer Definition
	 */
	public CompletableFuture<X_AD_LabelPrinter> AD_LabelPrinter(X_AD_PrintLabel entity, DataFetchingEnvironment environment) {
		if (entity.getAD_LabelPrinter_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_LabelPrinter> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_LabelPrinterDataLoader.AD_LabelPrinter_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_LabelPrinter_ID());
	}


	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable> AD_Table(X_AD_PrintLabel entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTable> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TableDataLoader.AD_Table_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Table_ID());
	}

	public Boolean IsLandscape(X_AD_PrintLabel entity, DataFetchingEnvironment environment) {
		return entity.isLandscape();
	}

}
