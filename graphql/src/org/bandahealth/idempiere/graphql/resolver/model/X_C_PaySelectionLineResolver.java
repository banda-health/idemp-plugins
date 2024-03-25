package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaySelectionCheckDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaySelectionDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MPaySelection;
import org.compiere.model.MPaySelectionCheck;
import org.compiere.model.MPaySelectionLine;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_PaySelectionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_PaySelectionLineResolver extends POResolver<MPaySelectionLine> implements GraphQLResolver<MPaySelectionLine> {



	/**
	 * Get Invoice.
	 *
	 * @return Invoice Identifier
	 */
	public CompletableFuture<MInvoice_BH> C_Invoice(MPaySelectionLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_Invoice_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInvoice_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoiceDataLoader.DATALOADER_C_Invoice_BY_ID);
		return dataLoader.load(entity.getC_Invoice_ID());
	}


	/**
	 * Get Payment Selection.
	 *
	 * @return Payment Selection
	 */
	public CompletableFuture<MPaySelection> C_PaySelection(MPaySelectionLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_PaySelection_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPaySelection> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PaySelectionDataLoader.DATALOADER_C_PaySelection_BY_ID);
		return dataLoader.load(entity.getC_PaySelection_ID());
	}


	/**
	 * Get Pay Selection Check.
	 *
	 * @return Payment Selection Check
	 */
	public CompletableFuture<MPaySelectionCheck> C_PaySelectionCheck(MPaySelectionLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_PaySelectionCheck_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPaySelectionCheck> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PaySelectionCheckDataLoader.DATALOADER_C_PaySelectionCheck_BY_ID);
		return dataLoader.load(entity.getC_PaySelectionCheck_ID());
	}

	public Boolean IsManual(MPaySelectionLine entity, DataFetchingEnvironment environment) {
		return entity.isManual();
	}

	public Boolean IsSOTrx(MPaySelectionLine entity, DataFetchingEnvironment environment) {
		return entity.isSOTrx();
	}

	static Map<String, String> PAYMENTRULE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("B", "917130e3-2144-496c-9344-6cf4f7136293");
			put("K", "68dda00d-c015-498e-b91c-811bab809dab");
			put("T", "50bc3b86-6106-44df-88ee-1000243a9fcf");
			put("S", "056e0d26-2ff4-41c6-bde6-b35d888e555e");
			put("P", "fb2b6b8d-3288-4c3c-8d87-7521d4a5460a");
			put("D", "2c5f0a44-1d35-4528-802f-9204e46be31e");
			put("M", "c9fff752-a38e-4679-bcec-61f330d1a6cb");
			put("A", "c524815a-e048-4052-bab5-b7812e27cd64");
			put("b", "72629357-494a-4cb3-aecf-807141f1968b");
		}
	};
	public CompletableFuture<MRefList_BH> PaymentRule(MPaySelectionLine entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPaymentRule())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(PAYMENTRULE_UUIDS_BY_VALUE.get(entity.getPaymentRule()));
	}

	public Boolean Processed(MPaySelectionLine entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

}
