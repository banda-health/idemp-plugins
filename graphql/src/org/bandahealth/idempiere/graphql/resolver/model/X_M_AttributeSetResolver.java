package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MAttributeSet_BH;
import org.bandahealth.idempiere.base.model.MSerNoCtl_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_LotCtlDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_SerNoCtlDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MLotCtl;
import org.compiere.model.MRefList;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_AttributeSet - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_AttributeSetResolver extends POResolver<MAttributeSet_BH> implements GraphQLResolver<MAttributeSet_BH> {


	static Map<String, String> M_ATTRIBUTESET_TYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MAttributeSet_BH.M_ATTRIBUTESET_TYPE_MaterialManagementSystem, "4455f892-2ea1-499d-a0b9-c01b3226f97d");
		}
	};
	public CompletableFuture<MRefList> M_AttributeSet_Type_RL(MAttributeSet_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getM_AttributeSet_Type())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(M_ATTRIBUTESET_TYPE_UUIDS_BY_VALUE.get(entity.getM_AttributeSet_Type()));
	}


	/**
	 * Get Lot Control.
	 *
	 * @return Product Lot Control
	 */
	public CompletableFuture<MLotCtl> M_LotCtl(MAttributeSet_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_LotCtl_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MLotCtl> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_LotCtlDataLoader.M_LotCtl_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_LotCtl_ID());
	}


	/**
	 * Get Serial No Control.
	 *
	 * @return Product Serial Number Control
	 */
	public CompletableFuture<MSerNoCtl_BH> M_SerNoCtl(MAttributeSet_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_SerNoCtl_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MSerNoCtl_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_SerNoCtlDataLoader.M_SerNoCtl_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_SerNoCtl_ID());
	}

	static Map<String, String> MANDATORYTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MAttributeSet_BH.MANDATORYTYPE_NotMandatory, "4591d5a6-31a3-4b6e-bbf3-41946a2f891e");
			put(MAttributeSet_BH.MANDATORYTYPE_AlwaysMandatory, "8e954367-a681-4bc5-b4f6-8ce3ac3bb746");
			put(MAttributeSet_BH.MANDATORYTYPE_WhenShipping, "7744e8d4-5f72-49bb-a1fb-ded1e5ec5055");
		}
	};
	public CompletableFuture<MRefList> MandatoryType_RL(MAttributeSet_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getMandatoryType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(MANDATORYTYPE_UUIDS_BY_VALUE.get(entity.getMandatoryType()));
	}

}
