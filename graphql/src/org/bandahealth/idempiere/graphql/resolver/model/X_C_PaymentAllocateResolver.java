package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AllocationLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaymentDataLoader;
import org.compiere.model.MAllocationLine;
import org.compiere.model.MPaymentAllocate;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_PaymentAllocate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_PaymentAllocateResolver extends POResolver<MPaymentAllocate> implements GraphQLResolver<MPaymentAllocate> {



	/**
	 * Get Allocation Line.
	 *
	 * @return Allocation Line
	 */
	public CompletableFuture<MAllocationLine> C_AllocationLine(MPaymentAllocate entity, DataFetchingEnvironment environment) {
		if (entity.getC_AllocationLine_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MAllocationLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_AllocationLineDataLoader.DATALOADER_C_AllocationLine_BY_ID);
		return dataLoader.load(entity.getC_AllocationLine_ID());
	}


	/**
	 * Get Invoice.
	 *
	 * @return Invoice Identifier
	 */
	public CompletableFuture<MInvoice_BH> C_Invoice(MPaymentAllocate entity, DataFetchingEnvironment environment) {
		if (entity.getC_Invoice_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MInvoice_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoiceDataLoader.DATALOADER_C_Invoice_BY_ID);
		return dataLoader.load(entity.getC_Invoice_ID());
	}


	/**
	 * Get Payment.
	 *
	 * @return Payment identifier
	 */
	public CompletableFuture<MPayment_BH> C_Payment(MPaymentAllocate entity, DataFetchingEnvironment environment) {
		if (entity.getC_Payment_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MPayment_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PaymentDataLoader.DATALOADER_C_Payment_BY_ID);
		return dataLoader.load(entity.getC_Payment_ID());
	}

}
