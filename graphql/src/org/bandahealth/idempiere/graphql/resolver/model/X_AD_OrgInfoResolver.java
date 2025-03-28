package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MOrgInfo_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ImageDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_OrgTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BankDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CalendarDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CashBookDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_LocationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_WarehouseDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MBank;
import org.compiere.model.MCalendar;
import org.compiere.model.MCashBook;
import org.compiere.model.MImage;
import org.compiere.model.MLocation;
import org.compiere.model.X_AD_OrgType;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_OrgInfo - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_OrgInfoResolver extends POResolver<MOrgInfo_BH> implements GraphQLResolver<MOrgInfo_BH> {



	/**
	 * Get Organization Type.
	 *
	 * @return Organization Type
	 */
	public CompletableFuture<X_AD_OrgType> AD_OrgType(MOrgInfo_BH entity, DataFetchingEnvironment environment) {
		if (entity.getAD_OrgType_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_AD_OrgType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_OrgTypeDataLoader.DATALOADER_AD_OrgType_BY_ID);
		return dataLoader.load(entity.getAD_OrgType_ID());
	}

	public static Map<String, String> BH_AFFILIATION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("G", "fc1e774a-e51b-4999-a450-60aeadaddf22"); // GOK
			put("F", "57e24320-0a4d-4af1-a0e3-0f6cc6c06fa2"); // Faith Based
			put("P", "4347cb29-65a9-4cf5-8e93-3bc147ea7b1f"); // Private
			put("N", "b8b2a31d-61d8-4107-9fd1-99a365133614"); // NGO
		}
	};
	public CompletableFuture<MRefList_BH> BH_Affiliation(MOrgInfo_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_Affiliation())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_AFFILIATION_UUIDS_BY_VALUE.get(entity.getBH_Affiliation()));
	}


	/**
	 * Get Calendar.
	 *
	 * @return Accounting Calendar Name
	 */
	public CompletableFuture<MCalendar> C_Calendar(MOrgInfo_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Calendar_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MCalendar> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CalendarDataLoader.DATALOADER_C_Calendar_BY_ID);
		return dataLoader.load(entity.getC_Calendar_ID());
	}


	/**
	 * Get Address.
	 *
	 * @return Location or Address
	 */
	public CompletableFuture<MLocation> C_Location(MOrgInfo_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Location_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_LocationDataLoader.DATALOADER_C_Location_BY_ID);
		return dataLoader.load(entity.getC_Location_ID());
	}


	/**
	 * Get Drop Ship Warehouse.
	 *
	 * @return The (logical) warehouse to use for recording drop ship receipts and shipments.
	 */
	public CompletableFuture<MWarehouse_BH> DropShip_Warehouse(MOrgInfo_BH entity, DataFetchingEnvironment environment) {
		if (entity.getDropShip_Warehouse_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MWarehouse_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_WarehouseDataLoader.DATALOADER_M_Warehouse_BY_ID);
		return dataLoader.load(entity.getDropShip_Warehouse_ID());
	}


	/**
	 * Get Logo.
	 *
	 * @return Logo
	 */
	public CompletableFuture<MImage> Logo(MOrgInfo_BH entity, DataFetchingEnvironment environment) {
		if (entity.getLogo_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MImage> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ImageDataLoader.DATALOADER_AD_Image_BY_ID);
		return dataLoader.load(entity.getLogo_ID());
	}


	/**
	 * Get Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	public CompletableFuture<MWarehouse_BH> M_Warehouse(MOrgInfo_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_Warehouse_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MWarehouse_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_WarehouseDataLoader.DATALOADER_M_Warehouse_BY_ID);
		return dataLoader.load(entity.getM_Warehouse_ID());
	}


	/**
	 * Get Supervisor.
	 *
	 * @return Supervisor for this user/organization - used for escalation and approval
	 */
	public CompletableFuture<MUser_BH> Supervisor(MOrgInfo_BH entity, DataFetchingEnvironment environment) {
		if (entity.getSupervisor_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getSupervisor_ID());
	}


	/**
	 * Get Bank for transfers.
	 *
	 * @return Bank account depending on currency will be used from this bank for doing transfers
	 */
	public CompletableFuture<MBank> TransferBank(MOrgInfo_BH entity, DataFetchingEnvironment environment) {
		if (entity.getTransferBank_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBank> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BankDataLoader.DATALOADER_C_Bank_BY_ID);
		return dataLoader.load(entity.getTransferBank_ID());
	}


	/**
	 * Get CashBook for transfers.
	 *
	 * @return CashBook for transfers
	 */
	public CompletableFuture<MCashBook> TransferCashBook(MOrgInfo_BH entity, DataFetchingEnvironment environment) {
		if (entity.getTransferCashBook_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MCashBook> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CashBookDataLoader.DATALOADER_C_CashBook_BY_ID);
		return dataLoader.load(entity.getTransferCashBook_ID());
	}

}
