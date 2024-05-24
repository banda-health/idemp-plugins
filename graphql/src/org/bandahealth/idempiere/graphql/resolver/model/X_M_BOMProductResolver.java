package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_AttributeSetInstanceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_BOMAlternativeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_BOMDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ChangeNoticeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductOperationDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MBOM;
import org.compiere.model.MBOMProduct;
import org.compiere.model.MChangeNotice;
import org.compiere.model.X_M_BOMAlternative;
import org.compiere.model.X_M_ProductOperation;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_BOMProduct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_BOMProductResolver extends POResolver<MBOMProduct> implements GraphQLResolver<MBOMProduct> {


	public static Map<String, String> BOMPRODUCTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("S", "728307cc-05d2-4b77-8a68-8c1efc553989"); // Standard Product
			put("O", "155c7d45-2d22-4117-8c2b-e0bef703f887"); // Optional Product
			put("A", "035fbac7-27bc-4924-bc0e-1c831ffa171f"); // Alternative
			put("D", "dffcf4b7-4ef8-48a2-b774-72a90d7dc045"); // Alternative (Default)
			put("X", "01be865c-435b-435d-b88c-398401e7f245"); // Outside Processing
		}
	};
	public CompletableFuture<MRefList_BH> BOMProductType(MBOMProduct entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBOMProductType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BOMPRODUCTTYPE_UUIDS_BY_VALUE.get(entity.getBOMProductType()));
	}

	public Boolean IsPhantom(MBOMProduct entity, DataFetchingEnvironment environment) {
		return entity.isPhantom();
	}


	/**
	 * Get Attribute Set Instance.
	 *
	 * @return Product Attribute Set Instance
	 */
	public CompletableFuture<MAttributeSetInstance_BH> M_AttributeSetInstance(MBOMProduct entity, DataFetchingEnvironment environment) {
		if (entity.getM_AttributeSetInstance_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MAttributeSetInstance_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_AttributeSetInstanceDataLoader.DATALOADER_M_AttributeSetInstance_BY_ID);
		return dataLoader.load(entity.getM_AttributeSetInstance_ID());
	}


	/**
	 * Get BOM.
	 *
	 * @return Bill of Material
	 */
	public CompletableFuture<MBOM> M_BOM(MBOMProduct entity, DataFetchingEnvironment environment) {
		if (entity.getM_BOM_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MBOM> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_BOMDataLoader.DATALOADER_M_BOM_BY_ID);
		return dataLoader.load(entity.getM_BOM_ID());
	}


	/**
	 * Get Alternative Group.
	 *
	 * @return Product BOM Alternative Group
	 */
	public CompletableFuture<X_M_BOMAlternative> M_BOMAlternative(MBOMProduct entity, DataFetchingEnvironment environment) {
		if (entity.getM_BOMAlternative_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_M_BOMAlternative> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_BOMAlternativeDataLoader.DATALOADER_M_BOMAlternative_BY_ID);
		return dataLoader.load(entity.getM_BOMAlternative_ID());
	}


	/**
	 * Get Change Notice.
	 *
	 * @return Bill of Materials (Engineering) Change Notice (Version)
	 */
	public CompletableFuture<MChangeNotice> M_ChangeNotice(MBOMProduct entity, DataFetchingEnvironment environment) {
		if (entity.getM_ChangeNotice_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MChangeNotice> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ChangeNoticeDataLoader.DATALOADER_M_ChangeNotice_BY_ID);
		return dataLoader.load(entity.getM_ChangeNotice_ID());
	}


	/**
	 * Get BOM Product.
	 *
	 * @return Bill of Material Component Product
	 */
	public CompletableFuture<MProduct_BH> M_ProductBOM(MBOMProduct entity, DataFetchingEnvironment environment) {
		if (entity.getM_ProductBOM_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_ProductBOM_ID());
	}


	/**
	 * Get Product Operation.
	 *
	 * @return Product Manufacturing Operation
	 */
	public CompletableFuture<X_M_ProductOperation> M_ProductOperation(MBOMProduct entity, DataFetchingEnvironment environment) {
		if (entity.getM_ProductOperation_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_M_ProductOperation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductOperationDataLoader.DATALOADER_M_ProductOperation_BY_ID);
		return dataLoader.load(entity.getM_ProductOperation_ID());
	}

}
