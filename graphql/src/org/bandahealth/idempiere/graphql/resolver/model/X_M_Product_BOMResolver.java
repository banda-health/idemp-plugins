package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PartTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MProductBOM;
import org.compiere.model.X_M_PartType;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_Product_BOM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_Product_BOMResolver extends POResolver<MProductBOM> implements GraphQLResolver<MProductBOM> {


	static Map<String, String> BOMTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("P", "8ae7333a-fea2-4fbd-8ebd-3e96805422c2");
			put("O", "74ef1521-644d-46b3-9b13-9f1cc7355b52");
			put("1", "e78acf51-c165-4dbe-b6fd-8cac11e83921");
			put("2", "25742cd0-7d0c-42cb-a9c1-5fd9de4a45e6");
			put("3", "20876f36-032a-42a5-a7dc-e19ef865c624");
			put("4", "f3576ae5-994f-4a50-8081-b01ee939d315");
			put("5", "b59c0b62-bdbe-4c03-9cee-9bafc4ddc358");
			put("6", "33e5a2be-c6bd-4bb6-8bf3-0b278b971539");
			put("7", "b26b169a-074a-4be9-a72a-56f867055d65");
			put("8", "8825e9ec-d828-46a1-916b-38e79c7d9024");
			put("9", "e8fa222e-da47-46f7-ad20-f7536bc0dd1a");
		}
	};
	public CompletableFuture<MRefList_BH> BOMType(MProductBOM entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBOMType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BOMTYPE_UUIDS_BY_VALUE.get(entity.getBOMType()));
	}

	public Boolean IsBillOfMaterial(MProductBOM entity, DataFetchingEnvironment environment) {
		return entity.isBillOfMaterial();
	}


	/**
	 * Get Part Type.
	 *
	 * @return Part Type
	 */
	public CompletableFuture<X_M_PartType> M_PartType(MProductBOM entity, DataFetchingEnvironment environment) {
		if (entity.getM_PartType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_M_PartType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_PartTypeDataLoader.DATALOADER_M_PartType_BY_ID);
		return dataLoader.load(entity.getM_PartType_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(MProductBOM entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}


	/**
	 * Get BOM Product.
	 *
	 * @return Bill of Material Component Product
	 */
	public CompletableFuture<MProduct_BH> M_ProductBOM(MProductBOM entity, DataFetchingEnvironment environment) {
		if (entity.getM_ProductBOM_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_ProductBOM_ID());
	}

}
