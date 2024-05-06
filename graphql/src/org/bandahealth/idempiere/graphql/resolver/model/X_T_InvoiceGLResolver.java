package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PInstanceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ConversionTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DocTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MConversionType;
import org.compiere.model.MPInstance;
import org.compiere.model.X_T_InvoiceGL;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for T_InvoiceGL - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_T_InvoiceGLResolver extends POResolver<X_T_InvoiceGL> implements GraphQLResolver<X_T_InvoiceGL> {



	/**
	 * Get Process Instance.
	 *
	 * @return Instance of the process
	 */
	public CompletableFuture<MPInstance> AD_PInstance(X_T_InvoiceGL entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PInstance_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPInstance> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PInstanceDataLoader.DATALOADER_AD_PInstance_BY_ID);
		return dataLoader.load(entity.getAD_PInstance_ID());
	}

	static Map<String, String> APAR_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "b89746fc-e6cc-44a6-8291-ef55629afa9c");
			put("R", "edb178db-eddd-4d1d-b4de-00b2e8997c29");
			put("P", "b6285ada-df30-4694-a427-63d2d0cfb529");
		}
	};
	public CompletableFuture<MRefList_BH> APAR(X_T_InvoiceGL entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getAPAR())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(APAR_UUIDS_BY_VALUE.get(entity.getAPAR()));
	}


	/**
	 * Get Revaluation Conversion Type.
	 *
	 * @return Revaluation Currency Conversion Type
	 */
	public CompletableFuture<MConversionType> C_ConversionTypeReval(X_T_InvoiceGL entity, DataFetchingEnvironment environment) {
		if (entity.getC_ConversionTypeReval_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MConversionType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ConversionTypeDataLoader.DATALOADER_C_ConversionType_BY_ID);
		return dataLoader.load(entity.getC_ConversionTypeReval_ID());
	}


	/**
	 * Get Revaluation Document Type.
	 *
	 * @return Document Type for Revaluation Journal
	 */
	public CompletableFuture<MDocType_BH> C_DocTypeReval(X_T_InvoiceGL entity, DataFetchingEnvironment environment) {
		if (entity.getC_DocTypeReval_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MDocType_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DocTypeDataLoader.DATALOADER_C_DocType_BY_ID);
		return dataLoader.load(entity.getC_DocTypeReval_ID());
	}


	/**
	 * Get Invoice.
	 *
	 * @return Invoice Identifier
	 */
	public CompletableFuture<MInvoice_BH> C_Invoice(X_T_InvoiceGL entity, DataFetchingEnvironment environment) {
		if (entity.getC_Invoice_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInvoice_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoiceDataLoader.DATALOADER_C_Invoice_BY_ID);
		return dataLoader.load(entity.getC_Invoice_ID());
	}

	public Boolean IsAllCurrencies(X_T_InvoiceGL entity, DataFetchingEnvironment environment) {
		return entity.isAllCurrencies();
	}

}
