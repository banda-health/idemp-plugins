package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_UOMDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_AttributeSetInstanceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ChangeNoticeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_LocatorDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_WarehouseDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_OrderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_Order_BOMDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MChangeNotice;
import org.compiere.model.MLocator;
import org.compiere.model.MRefList;
import org.compiere.model.MUOM;
import org.dataloader.DataLoader;
import org.eevolution.model.X_PP_Order;
import org.eevolution.model.X_PP_Order_BOM;
import org.eevolution.model.X_PP_Order_BOMLine;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for PP_Order_BOMLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_Order_BOMLineResolver extends POResolver<X_PP_Order_BOMLine> implements GraphQLResolver<X_PP_Order_BOMLine> {



	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(X_PP_Order_BOMLine entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.AD_User_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_User_ID());
	}


	/**
	 * Get UOM.
	 *
	 * @return Unit of Measure
	 */
	public CompletableFuture<MUOM> C_UOM(X_PP_Order_BOMLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_UOM_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUOM> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_UOMDataLoader.C_UOM_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_UOM_ID());
	}

	static Map<String, String> COMPONENTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("BY", "b0f4f7d6-5db7-441c-babb-1e64d4155c84");
			put("CO", "9718a56a-7da7-4a09-9438-7cf2f90c288c");
			put("PH", "40cdea02-6475-47f2-960e-f7929e84b4f1");
			put("PK", "296dd50a-f475-4e0e-b67f-a079b45f5d11");
			put("PL", "037a017f-9a89-4bf6-8aef-f6edaac5dcf7");
			put("TL", "05d7657c-dc31-413f-b727-23eb225112e6");
			put("OP", "fb7cbbb9-739d-4a6a-9f59-9c2aa60e8e6e");
			put("VA", "76c427e8-a725-4695-ae9e-365fc969dd8e");
			put("CP", "64d921b3-a4fe-4b04-8519-91f39f844a8a");
		}
	};
	public CompletableFuture<MRefList> ComponentType_RL(X_PP_Order_BOMLine entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getComponentType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(COMPONENTTYPE_UUIDS_BY_VALUE.get(entity.getComponentType()));
	}

	static Map<String, String> ISSUEMETHOD_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("0", "6a547c24-b9e5-4b16-98c7-2d84f9eae02b");
			put("1", "fec1ffc7-d10b-433b-8811-ded8ed39dcad");
			put("2", "211b7c2f-638d-4429-b5d9-e1248a684d3b");
		}
	};
	public CompletableFuture<MRefList> IssueMethod_RL(X_PP_Order_BOMLine entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIssueMethod())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(ISSUEMETHOD_UUIDS_BY_VALUE.get(entity.getIssueMethod()));
	}


	/**
	 * Get Attribute Set Instance.
	 *
	 * @return Product Attribute Set Instance
	 */
	public CompletableFuture<MAttributeSetInstance_BH> M_AttributeSetInstance(X_PP_Order_BOMLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_AttributeSetInstance_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAttributeSetInstance_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_AttributeSetInstanceDataLoader.M_AttributeSetInstance_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_AttributeSetInstance_ID());
	}


	/**
	 * Get Change Notice.
	 *
	 * @return Bill of Materials (Engineering) Change Notice (Version)
	 */
	public CompletableFuture<MChangeNotice> M_ChangeNotice(X_PP_Order_BOMLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_ChangeNotice_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MChangeNotice> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ChangeNoticeDataLoader.M_ChangeNotice_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_ChangeNotice_ID());
	}


	/**
	 * Get Locator.
	 *
	 * @return Warehouse Locator
	 */
	public CompletableFuture<MLocator> M_Locator(X_PP_Order_BOMLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_Locator_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MLocator> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_LocatorDataLoader.M_Locator_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Locator_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(X_PP_Order_BOMLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.M_Product_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Product_ID());
	}


	/**
	 * Get Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	public CompletableFuture<MWarehouse_BH> M_Warehouse(X_PP_Order_BOMLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_Warehouse_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MWarehouse_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_WarehouseDataLoader.M_Warehouse_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Warehouse_ID());
	}


	/**
	 * Get Manufacturing Order BOM.
	 *
	 * @return Manufacturing Order BOM
	 */
	public CompletableFuture<X_PP_Order_BOM> PP_Order_BOM(X_PP_Order_BOMLine entity, DataFetchingEnvironment environment) {
		if (entity.getPP_Order_BOM_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_PP_Order_BOM> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PP_Order_BOMDataLoader.PP_Order_BOM_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getPP_Order_BOM_ID());
	}


	/**
	 * Get Manufacturing Order.
	 *
	 * @return Manufacturing Order
	 */
	public CompletableFuture<X_PP_Order> PP_Order(X_PP_Order_BOMLine entity, DataFetchingEnvironment environment) {
		if (entity.getPP_Order_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_PP_Order> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PP_OrderDataLoader.PP_Order_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getPP_Order_ID());
	}

}
