package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_LabelPrinterDataLoader;
import org.compiere.model.X_AD_LabelPrinter;
import org.compiere.model.X_AD_LabelPrinterFunction;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_LabelPrinterFunction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_LabelPrinterFunctionResolver extends POResolver<X_AD_LabelPrinterFunction> implements GraphQLResolver<X_AD_LabelPrinterFunction> {



	/**
	 * Get Label printer.
	 *
	 * @return Label Printer Definition
	 */
	public CompletableFuture<X_AD_LabelPrinter> AD_LabelPrinter(X_AD_LabelPrinterFunction entity, DataFetchingEnvironment environment) {
		if (entity.getAD_LabelPrinter_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_LabelPrinter> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_LabelPrinterDataLoader.DATALOADER_AD_LabelPrinter_BY_ID);
		return dataLoader.load(entity.getAD_LabelPrinter_ID());
	}

	public Boolean IsXYPosition(X_AD_LabelPrinterFunction entity, DataFetchingEnvironment environment) {
		return entity.isXYPosition();
	}

}
