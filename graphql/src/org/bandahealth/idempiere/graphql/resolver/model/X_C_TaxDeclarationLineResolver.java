package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AllocationLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxDeclarationDataLoader;
import org.compiere.model.MAllocationLine;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MTax;
import org.compiere.model.MTaxDeclaration;
import org.compiere.model.MTaxDeclarationLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_TaxDeclarationLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_TaxDeclarationLineResolver extends POResolver<MTaxDeclarationLine> implements GraphQLResolver<MTaxDeclarationLine> {



	/**
	 * Get Allocation Line.
	 *
	 * @return Allocation Line
	 */
	public CompletableFuture<MAllocationLine> C_AllocationLine(MTaxDeclarationLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_AllocationLine_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MAllocationLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_AllocationLineDataLoader.DATALOADER_C_AllocationLine_BY_ID);
		return dataLoader.load(entity.getC_AllocationLine_ID());
	}


	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(MTaxDeclarationLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public CompletableFuture<MCurrency_BH> C_Currency(MTaxDeclarationLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MCurrency_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.DATALOADER_C_Currency_BY_ID);
		return dataLoader.load(entity.getC_Currency_ID());
	}


	/**
	 * Get Invoice.
	 *
	 * @return Invoice Identifier
	 */
	public CompletableFuture<MInvoice_BH> C_Invoice(MTaxDeclarationLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_Invoice_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MInvoice_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoiceDataLoader.DATALOADER_C_Invoice_BY_ID);
		return dataLoader.load(entity.getC_Invoice_ID());
	}


	/**
	 * Get Invoice Line.
	 *
	 * @return Invoice Detail Line
	 */
	public CompletableFuture<MInvoiceLine> C_InvoiceLine(MTaxDeclarationLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_InvoiceLine_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MInvoiceLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoiceLineDataLoader.DATALOADER_C_InvoiceLine_BY_ID);
		return dataLoader.load(entity.getC_InvoiceLine_ID());
	}


	/**
	 * Get Tax.
	 *
	 * @return Tax identifier
	 */
	public CompletableFuture<MTax> C_Tax(MTaxDeclarationLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_Tax_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MTax> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_TaxDataLoader.DATALOADER_C_Tax_BY_ID);
		return dataLoader.load(entity.getC_Tax_ID());
	}


	/**
	 * Get Tax Declaration.
	 *
	 * @return Define the declaration to the tax authorities
	 */
	public CompletableFuture<MTaxDeclaration> C_TaxDeclaration(MTaxDeclarationLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_TaxDeclaration_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MTaxDeclaration> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_TaxDeclarationDataLoader.DATALOADER_C_TaxDeclaration_BY_ID);
		return dataLoader.load(entity.getC_TaxDeclaration_ID());
	}

	public Boolean IsManual(MTaxDeclarationLine entity, DataFetchingEnvironment environment) {
		return entity.isManual();
	}

}
