package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MSequence_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_SequenceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_WarehouseDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.X_C_BP_EDI;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_BP_EDI - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BP_EDIResolver extends POResolver<X_C_BP_EDI> implements GraphQLResolver<X_C_BP_EDI> {



	/**
	 * Get Sequence.
	 *
	 * @return Document Sequence
	 */
	public CompletableFuture<MSequence_BH> AD_Sequence(X_C_BP_EDI entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Sequence_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MSequence_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_SequenceDataLoader.DATALOADER_AD_Sequence_BY_ID);
		return dataLoader.load(entity.getAD_Sequence_ID());
	}


	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(X_C_BP_EDI entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartner_ID());
	}

	static Map<String, String> EDITYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("X", "cff0e010-d9b7-4dce-8261-c7dd9542cf63");
			put("E", "e46a81e4-9249-486e-b352-135924b95ea1");
			put("M", "6a96a77c-272e-41e1-a900-12666c58e9c0");
		}
	};
	public CompletableFuture<MRefList_BH> EDIType(X_C_BP_EDI entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getEDIType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(EDITYPE_UUIDS_BY_VALUE.get(entity.getEDIType()));
	}

	public Boolean IsAudited(X_C_BP_EDI entity, DataFetchingEnvironment environment) {
		return entity.isAudited();
	}

	public Boolean IsInfoSent(X_C_BP_EDI entity, DataFetchingEnvironment environment) {
		return entity.isInfoSent();
	}


	/**
	 * Get Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	public CompletableFuture<MWarehouse_BH> M_Warehouse(X_C_BP_EDI entity, DataFetchingEnvironment environment) {
		if (entity.getM_Warehouse_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MWarehouse_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_WarehouseDataLoader.DATALOADER_M_Warehouse_BY_ID);
		return dataLoader.load(entity.getM_Warehouse_ID());
	}

	public Boolean ReceiveInquiryReply(X_C_BP_EDI entity, DataFetchingEnvironment environment) {
		return entity.isReceiveInquiryReply();
	}

	public Boolean ReceiveOrderReply(X_C_BP_EDI entity, DataFetchingEnvironment environment) {
		return entity.isReceiveOrderReply();
	}

	public Boolean SendInquiry(X_C_BP_EDI entity, DataFetchingEnvironment environment) {
		return entity.isSendInquiry();
	}

	public Boolean SendOrder(X_C_BP_EDI entity, DataFetchingEnvironment environment) {
		return entity.isSendOrder();
	}

}
