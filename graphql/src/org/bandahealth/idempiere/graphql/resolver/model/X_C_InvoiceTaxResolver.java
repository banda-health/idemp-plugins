package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxProviderDataLoader;
import org.compiere.model.MInvoiceTax;
import org.compiere.model.MTax;
import org.compiere.model.MTaxProvider;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_InvoiceTax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_InvoiceTaxResolver extends POResolver<MInvoiceTax> implements GraphQLResolver<MInvoiceTax> {



	/**
	 * Get Invoice.
	 *
	 * @return Invoice Identifier
	 */
	public CompletableFuture<MInvoice_BH> C_Invoice(MInvoiceTax entity, DataFetchingEnvironment environment) {
		if (entity.getC_Invoice_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInvoice_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoiceDataLoader.DATALOADER_C_Invoice_BY_ID);
		return dataLoader.load(entity.getC_Invoice_ID());
	}


	/**
	 * Get Tax.
	 *
	 * @return Tax identifier
	 */
	public CompletableFuture<MTax> C_Tax(MInvoiceTax entity, DataFetchingEnvironment environment) {
		if (entity.getC_Tax_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTax> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_TaxDataLoader.DATALOADER_C_Tax_BY_ID);
		return dataLoader.load(entity.getC_Tax_ID());
	}


	/**
	 * Get Tax Provider.
	 *
	 * @return Tax Provider
	 */
	public CompletableFuture<MTaxProvider> C_TaxProvider(MInvoiceTax entity, DataFetchingEnvironment environment) {
		if (entity.getC_TaxProvider_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTaxProvider> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_TaxProviderDataLoader.DATALOADER_C_TaxProvider_BY_ID);
		return dataLoader.load(entity.getC_TaxProvider_ID());
	}

	public Boolean IsTaxIncluded(MInvoiceTax entity, DataFetchingEnvironment environment) {
		return entity.isTaxIncluded();
	}

	public Boolean Processed(MInvoiceTax entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

}
