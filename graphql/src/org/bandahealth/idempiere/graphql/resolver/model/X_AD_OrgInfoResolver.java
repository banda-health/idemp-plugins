package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MOrgInfo_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ImageDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_OrgTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BankDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CalendarDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CashBookDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_LocationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_WarehouseDataLoader;
import org.compiere.model.MBank;
import org.compiere.model.MCalendar;
import org.compiere.model.MCashBook;
import org.compiere.model.MImage;
import org.compiere.model.MLocation;
import org.compiere.model.X_AD_OrgType;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_OrgInfo - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_OrgInfoResolver extends POResolver<MOrgInfo_BH> implements GraphQLResolver<MOrgInfo_BH> {



	/**
	 * Get Organization Type.
	 *
	 * @return Organization Type
	 */
	public CompletableFuture<X_AD_OrgType> AD_OrgType(MOrgInfo_BH entity, DataFetchingEnvironment environment) {
		if (entity.getAD_OrgType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_OrgType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_OrgTypeDataLoader.AD_OrgType_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_OrgType_ID());
	}


	/**
	 * Get Calendar.
	 *
	 * @return Accounting Calendar Name
	 */
	public CompletableFuture<MCalendar> C_Calendar(MOrgInfo_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Calendar_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCalendar> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CalendarDataLoader.C_Calendar_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Calendar_ID());
	}


	/**
	 * Get Address.
	 *
	 * @return Location or Address
	 */
	public CompletableFuture<MLocation> C_Location(MOrgInfo_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Location_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_LocationDataLoader.C_Location_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Location_ID());
	}


	/**
	 * Get Drop Ship Warehouse.
	 *
	 * @return The (logical) warehouse to use for recording drop ship receipts and shipments.
	 */
	public CompletableFuture<MWarehouse_BH> DropShip_Warehouse(MOrgInfo_BH entity, DataFetchingEnvironment environment) {
		if (entity.getDropShip_Warehouse_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MWarehouse_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_WarehouseDataLoader.M_Warehouse_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getDropShip_Warehouse_ID());
	}


	/**
	 * Get Logo.
	 *
	 * @return Logo
	 */
	public CompletableFuture<MImage> Logo(MOrgInfo_BH entity, DataFetchingEnvironment environment) {
		if (entity.getLogo_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MImage> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ImageDataLoader.AD_Image_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getLogo_ID());
	}


	/**
	 * Get Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	public CompletableFuture<MWarehouse_BH> M_Warehouse(MOrgInfo_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_Warehouse_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MWarehouse_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_WarehouseDataLoader.M_Warehouse_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Warehouse_ID());
	}


	/**
	 * Get Supervisor.
	 *
	 * @return Supervisor for this user/organization - used for escalation and approval
	 */
	public CompletableFuture<MUser_BH> Supervisor(MOrgInfo_BH entity, DataFetchingEnvironment environment) {
		if (entity.getSupervisor_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.AD_User_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getSupervisor_ID());
	}


	/**
	 * Get Bank for transfers.
	 *
	 * @return Bank account depending on currency will be used from this bank for doing transfers
	 */
	public CompletableFuture<MBank> TransferBank(MOrgInfo_BH entity, DataFetchingEnvironment environment) {
		if (entity.getTransferBank_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBank> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BankDataLoader.C_Bank_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getTransferBank_ID());
	}


	/**
	 * Get CashBook for transfers.
	 *
	 * @return CashBook for transfers
	 */
	public CompletableFuture<MCashBook> TransferCashBook(MOrgInfo_BH entity, DataFetchingEnvironment environment) {
		if (entity.getTransferCashBook_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCashBook> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CashBookDataLoader.C_CashBook_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getTransferCashBook_ID());
	}

}
