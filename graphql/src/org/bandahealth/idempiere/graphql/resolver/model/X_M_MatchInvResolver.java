package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_AttributeSetInstanceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_InOutLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_MatchInvDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MInOutLine;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MMatchInv;
import org.compiere.model.MRefList;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_MatchInv - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_MatchInvResolver extends POResolver<MMatchInv> implements GraphQLResolver<MMatchInv> {



	/**
	 * Get Invoice Line.
	 *
	 * @return Invoice Detail Line
	 */
	public CompletableFuture<MInvoiceLine> C_InvoiceLine(MMatchInv entity, DataFetchingEnvironment environment) {
		if (entity.getC_InvoiceLine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInvoiceLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoiceLineDataLoader.C_InvoiceLine_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_InvoiceLine_ID());
	}


	/**
	 * Get Attribute Set Instance.
	 *
	 * @return Product Attribute Set Instance
	 */
	public CompletableFuture<MAttributeSetInstance_BH> M_AttributeSetInstance(MMatchInv entity, DataFetchingEnvironment environment) {
		if (entity.getM_AttributeSetInstance_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAttributeSetInstance_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_AttributeSetInstanceDataLoader.M_AttributeSetInstance_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_AttributeSetInstance_ID());
	}


	/**
	 * Get Shipment/Receipt Line.
	 *
	 * @return Line on Shipment or Receipt document
	 */
	public CompletableFuture<MInOutLine> M_InOutLine(MMatchInv entity, DataFetchingEnvironment environment) {
		if (entity.getM_InOutLine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInOutLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_InOutLineDataLoader.M_InOutLine_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_InOutLine_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(MMatchInv entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.M_Product_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Product_ID());
	}

	static Map<String, String> POSTED_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MMatchInv.POSTED_NotPosted, "f8a3fa32-e816-46b0-8ffa-8f75a9a6f8ce");
			put(MMatchInv.POSTED_Posted, "238cfb09-41c2-43ef-81d3-785f45e69eff");
			put(MMatchInv.POSTED_NotBalanced, "b356ec40-2b7c-45bd-ae61-5f62875b41ac");
			put(MMatchInv.POSTED_NotConvertibleNoRate, "1e0390a8-f7be-4e8b-bd9a-e7c56913f39d");
			put(MMatchInv.POSTED_PeriodClosed, "4afac137-c9db-4bbc-ac61-b0c642f7807e");
			put(MMatchInv.POSTED_PostPrepared, "b2188064-c2e1-4319-8d1d-59145d49842b");
			put(MMatchInv.POSTED_InvalidAccount, "3bd142e3-e397-42b9-ac64-b2c98d970426");
			put(MMatchInv.POSTED_PostingError, "bd259a9b-d9a3-4396-ae5c-124968ae3f4d");
			put(MMatchInv.POSTED_Deferred, "0630b5d2-0fe4-4ef8-9d2f-a14791c02c7d");
		}
	};
	public CompletableFuture<MRefList> Posted_RL(MMatchInv entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPosted())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(POSTED_UUIDS_BY_VALUE.get(entity.getPosted()));
	}


	/**
	 * Get Referenced Match Invoice.
	 *
	 * @return Referenced Match Invoice
	 */
	public CompletableFuture<MMatchInv> Ref_MatchInv(MMatchInv entity, DataFetchingEnvironment environment) {
		if (entity.getRef_MatchInv_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MMatchInv> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_MatchInvDataLoader.M_MatchInv_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getRef_MatchInv_ID());
	}


	/**
	 * Get Reversal ID.
	 *
	 * @return ID of document reversal
	 */
	public CompletableFuture<MMatchInv> Reversal(MMatchInv entity, DataFetchingEnvironment environment) {
		if (entity.getReversal_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MMatchInv> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_MatchInvDataLoader.M_MatchInv_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getReversal_ID());
	}

}
