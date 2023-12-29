package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MAttributeSet_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_AttributeSetDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_LotDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MLot;
import org.compiere.model.MRefList;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_AttributeSetInstance - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_AttributeSetInstanceResolver extends POResolver<MAttributeSetInstance_BH> implements GraphQLResolver<MAttributeSetInstance_BH> {


	static Map<String, String> BH_UPDATE_REASON_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("p_dmg", "315319b8-c274-414c-bb87-6d2d3e9f2acf");
			put("p_exp", "9070547d-c818-49da-a406-edd3999f9e05");
			put("p_unc", "3dc79710-4a2b-4b58-9c8f-d557cf180c49");
			put("p_los", "044ba1a8-986a-46ec-baf6-4d6efcea1e48");
			put("p_sna", "ab87230f-f137-454c-bba2-cd3a60fab3cb");
			put("p_bqt", "982d9571-dc08-4335-a379-041403048053");
			put("p_wer", "6936f0fa-bf26-4c24-a744-d398e458fd2e");
		}
	};
	public CompletableFuture<MRefList> bh_update_reason_RL(MAttributeSetInstance_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getbh_update_reason())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(BH_UPDATE_REASON_UUIDS_BY_VALUE.get(entity.getbh_update_reason()));
	}


	/**
	 * Get Attribute Set.
	 *
	 * @return Product Attribute Set
	 */
	public CompletableFuture<MAttributeSet_BH> M_AttributeSet(MAttributeSetInstance_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_AttributeSet_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAttributeSet_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_AttributeSetDataLoader.M_AttributeSet_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_AttributeSet_ID());
	}


	/**
	 * Get Lot.
	 *
	 * @return Product Lot Definition
	 */
	public CompletableFuture<MLot> M_Lot(MAttributeSetInstance_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_Lot_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MLot> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_LotDataLoader.M_Lot_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Lot_ID());
	}

}
