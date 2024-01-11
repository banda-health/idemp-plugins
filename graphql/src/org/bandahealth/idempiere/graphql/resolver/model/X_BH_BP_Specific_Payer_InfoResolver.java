package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHBPSpecificPayerInfo;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFld;
import org.bandahealth.idempiere.base.model.MInvoiceLine_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Payer_Info_FldDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceLineDataLoader;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_BP_Specific_Payer_Info - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_BP_Specific_Payer_InfoResolver extends POResolver<MBHBPSpecificPayerInfo> implements GraphQLResolver<MBHBPSpecificPayerInfo> {



	/**
	 * Get Payer Info Field.
	 *
	 * @return Payer Info Field
	 */
	public CompletableFuture<MBHPayerInfoFld> BH_Payer_Info_Fld(MBHBPSpecificPayerInfo entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Payer_Info_Fld_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBHPayerInfoFld> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_Payer_Info_FldDataLoader.BH_Payer_Info_Fld_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getBH_Payer_Info_Fld_ID());
	}


	/**
	 * Get Invoice Line.
	 *
	 * @return Invoice Detail Line
	 */
	public CompletableFuture<MInvoiceLine_BH> C_InvoiceLine(MBHBPSpecificPayerInfo entity, DataFetchingEnvironment environment) {
		if (entity.getC_InvoiceLine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInvoiceLine_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoiceLineDataLoader.C_InvoiceLine_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_InvoiceLine_ID());
	}

}
