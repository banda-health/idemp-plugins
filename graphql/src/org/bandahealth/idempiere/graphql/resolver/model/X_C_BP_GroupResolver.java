package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintColorDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DunningDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_DiscountSchemaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PriceListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MDiscountSchema;
import org.compiere.model.MDunning;
import org.compiere.model.MPriceList;
import org.compiere.model.X_AD_PrintColor;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_BP_Group - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_BP_GroupResolver extends POResolver<MBPGroup_BH> implements GraphQLResolver<MBPGroup_BH> {



	/**
	 * Get Print Color.
	 *
	 * @return Color used for printing and display
	 */
	public CompletableFuture<X_AD_PrintColor> AD_PrintColor(MBPGroup_BH entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PrintColor_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintColor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintColorDataLoader.DATALOADER_AD_PrintColor_BY_ID);
		return dataLoader.load(entity.getAD_PrintColor_ID());
	}

	public Boolean BH_Locked(MBPGroup_BH entity, DataFetchingEnvironment environment) {
		return entity.isBH_Locked();
	}

	public static Map<String, String> BH_SUBTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("I", "d8547f6d-5ad0-4025-b8f8-0f4796cf9d0f"); // Insurance
			put("W", "406d22a4-b3ee-48e4-9bba-7031f653aa06"); // Waiver
			put("D", "4782b135-a84e-4eb9-ae3d-88c872a030ce"); // Donation
		}
	};
	public CompletableFuture<MRefList_BH> BH_SubType(MBPGroup_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_SubType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_SUBTYPE_UUIDS_BY_VALUE.get(entity.getBH_SubType()));
	}


	/**
	 * Get Dunning.
	 *
	 * @return Dunning Rules for overdue invoices
	 */
	public CompletableFuture<MDunning> C_Dunning(MBPGroup_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Dunning_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MDunning> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DunningDataLoader.DATALOADER_C_Dunning_BY_ID);
		return dataLoader.load(entity.getC_Dunning_ID());
	}

	public Boolean IsConfidentialInfo(MBPGroup_BH entity, DataFetchingEnvironment environment) {
		return entity.isConfidentialInfo();
	}

	public Boolean IsDefault(MBPGroup_BH entity, DataFetchingEnvironment environment) {
		return entity.isDefault();
	}


	/**
	 * Get Discount Schema.
	 *
	 * @return Schema to calculate the trade discount percentage
	 */
	public CompletableFuture<MDiscountSchema> M_DiscountSchema(MBPGroup_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_DiscountSchema_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MDiscountSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_DiscountSchemaDataLoader.DATALOADER_M_DiscountSchema_BY_ID);
		return dataLoader.load(entity.getM_DiscountSchema_ID());
	}


	/**
	 * Get Price List.
	 *
	 * @return Unique identifier of a Price List
	 */
	public CompletableFuture<MPriceList> M_PriceList(MBPGroup_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_PriceList_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MPriceList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_PriceListDataLoader.DATALOADER_M_PriceList_BY_ID);
		return dataLoader.load(entity.getM_PriceList_ID());
	}


	/**
	 * Get PO Discount Schema.
	 *
	 * @return Schema to calculate the purchase trade discount percentage
	 */
	public CompletableFuture<MDiscountSchema> PO_DiscountSchema(MBPGroup_BH entity, DataFetchingEnvironment environment) {
		if (entity.getPO_DiscountSchema_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MDiscountSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_DiscountSchemaDataLoader.DATALOADER_M_DiscountSchema_BY_ID);
		return dataLoader.load(entity.getPO_DiscountSchema_ID());
	}


	/**
	 * Get Purchase Price List.
	 *
	 * @return Price List used by this Business Partner
	 */
	public CompletableFuture<MPriceList> PO_PriceList(MBPGroup_BH entity, DataFetchingEnvironment environment) {
		if (entity.getPO_PriceList_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MPriceList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_PriceListDataLoader.DATALOADER_M_PriceList_BY_ID);
		return dataLoader.load(entity.getPO_PriceList_ID());
	}

	public static Map<String, String> PRIORITYBASE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("S", "b64b1ea9-0b3a-44b9-8eb0-2b2ca0ad5190"); // Same
			put("L", "a64392a9-af89-4e61-99b0-eef75b411da8"); // Lower
			put("H", "de47e146-1de6-4ff7-870d-3faf6a85bea0"); // Higher
		}
	};
	public CompletableFuture<MRefList_BH> PriorityBase(MBPGroup_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPriorityBase())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(PRIORITYBASE_UUIDS_BY_VALUE.get(entity.getPriorityBase()));
	}

}
