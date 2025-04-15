package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BankAccountDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CashBookDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DocTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_POSKeyLayoutDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PriceListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_WarehouseDataLoader;
import org.compiere.model.MCashBook;
import org.compiere.model.MPOS;
import org.compiere.model.MPOSKeyLayout;
import org.compiere.model.MPriceList;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_POS - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_POSResolver extends POResolver<MPOS> implements GraphQLResolver<MPOS> {



	/**
	 * Get Bank Account.
	 *
	 * @return Account at the Bank
	 */
	public CompletableFuture<MBankAccount_BH> C_BankAccount(MPOS entity, DataFetchingEnvironment environment) {
		if (entity.getC_BankAccount_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBankAccount_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BankAccountDataLoader.DATALOADER_C_BankAccount_BY_ID);
		return dataLoader.load(entity.getC_BankAccount_ID());
	}


	/**
	 * Get Template B.Partner.
	 *
	 * @return Business Partner used for creating new Business Partners on the fly
	 */
	public CompletableFuture<MBPartner_BH> C_BPartnerCashTrx(MPOS entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartnerCashTrx_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartnerCashTrx_ID());
	}


	/**
	 * Get Cash Book.
	 *
	 * @return Cash Book for recording petty cash transactions
	 */
	public CompletableFuture<MCashBook> C_CashBook(MPOS entity, DataFetchingEnvironment environment) {
		if (entity.getC_CashBook_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MCashBook> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CashBookDataLoader.DATALOADER_C_CashBook_BY_ID);
		return dataLoader.load(entity.getC_CashBook_ID());
	}


	/**
	 * Get Document Type.
	 *
	 * @return Document type or rules
	 */
	public CompletableFuture<MDocType_BH> C_DocType(MPOS entity, DataFetchingEnvironment environment) {
		if (entity.getC_DocType_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MDocType_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DocTypeDataLoader.DATALOADER_C_DocType_BY_ID);
		return dataLoader.load(entity.getC_DocType_ID());
	}


	/**
	 * Get POS Key Layout.
	 *
	 * @return POS Function Key Layout
	 */
	public CompletableFuture<MPOSKeyLayout> C_POSKeyLayout(MPOS entity, DataFetchingEnvironment environment) {
		if (entity.getC_POSKeyLayout_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MPOSKeyLayout> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_POSKeyLayoutDataLoader.DATALOADER_C_POSKeyLayout_BY_ID);
		return dataLoader.load(entity.getC_POSKeyLayout_ID());
	}

	public Boolean IsModifyPrice(MPOS entity, DataFetchingEnvironment environment) {
		return entity.isModifyPrice();
	}


	/**
	 * Get Price List.
	 *
	 * @return Unique identifier of a Price List
	 */
	public CompletableFuture<MPriceList> M_PriceList(MPOS entity, DataFetchingEnvironment environment) {
		if (entity.getM_PriceList_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MPriceList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_PriceListDataLoader.DATALOADER_M_PriceList_BY_ID);
		return dataLoader.load(entity.getM_PriceList_ID());
	}


	/**
	 * Get Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	public CompletableFuture<MWarehouse_BH> M_Warehouse(MPOS entity, DataFetchingEnvironment environment) {
		if (entity.getM_Warehouse_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MWarehouse_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_WarehouseDataLoader.DATALOADER_M_Warehouse_BY_ID);
		return dataLoader.load(entity.getM_Warehouse_ID());
	}


	/**
	 * Get On Screen Keyboard layout.
	 *
	 * @return The key layout to use for on screen keyboard for text fields.
	 */
	public CompletableFuture<MPOSKeyLayout> OSK_KeyLayout(MPOS entity, DataFetchingEnvironment environment) {
		if (entity.getOSK_KeyLayout_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MPOSKeyLayout> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_POSKeyLayoutDataLoader.DATALOADER_C_POSKeyLayout_BY_ID);
		return dataLoader.load(entity.getOSK_KeyLayout_ID());
	}


	/**
	 * Get On Screen Number Pad layout.
	 *
	 * @return The key layout to use for on screen number pad for numeric fields.
	 */
	public CompletableFuture<MPOSKeyLayout> OSNP_KeyLayout(MPOS entity, DataFetchingEnvironment environment) {
		if (entity.getOSNP_KeyLayout_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MPOSKeyLayout> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_POSKeyLayoutDataLoader.DATALOADER_C_POSKeyLayout_BY_ID);
		return dataLoader.load(entity.getOSNP_KeyLayout_ID());
	}


	/**
	 * Get Sales Representative.
	 *
	 * @return Sales Representative or Company Agent
	 */
	public CompletableFuture<MUser_BH> SalesRep(MPOS entity, DataFetchingEnvironment environment) {
		if (entity.getSalesRep_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getSalesRep_ID());
	}

}
