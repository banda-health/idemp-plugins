package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BankAccountDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CashBookDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PriceListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_WarehouseDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MCashBook;
import org.compiere.model.MPOSTerminal;
import org.compiere.model.MPriceList;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for U_POSTerminal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_U_POSTerminalResolver extends POResolver<MPOSTerminal> implements GraphQLResolver<MPOSTerminal> {


	public Boolean AutoLock(MPOSTerminal entity, DataFetchingEnvironment environment) {
		return entity.isAutoLock();
	}


	/**
	 * Get Cash Book.
	 *
	 * @return Cash Book for recording petty cash transactions
	 */
	public CompletableFuture<MCashBook> C_CashBook(MPOSTerminal entity, DataFetchingEnvironment environment) {
		if (entity.getC_CashBook_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCashBook> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CashBookDataLoader.C_CashBook_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_CashBook_ID());
	}


	/**
	 * Get Cash BPartner.
	 *
	 * @return BPartner to be used for Cash transactions
	 */
	public CompletableFuture<MBPartner_BH> C_CashBPartner(MPOSTerminal entity, DataFetchingEnvironment environment) {
		if (entity.getC_CashBPartner_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.C_BPartner_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_CashBPartner_ID());
	}


	/**
	 * Get Template BPartner.
	 *
	 * @return BPartner that is to be used as template when new customers are created
	 */
	public CompletableFuture<MBPartner_BH> C_TemplateBPartner(MPOSTerminal entity, DataFetchingEnvironment environment) {
		if (entity.getC_TemplateBPartner_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.C_BPartner_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_TemplateBPartner_ID());
	}


	/**
	 * Get Card Bank Account.
	 *
	 * @return Bank Account on which card transactions will be processed
	 */
	public CompletableFuture<MBankAccount_BH> Card_BankAccount(MPOSTerminal entity, DataFetchingEnvironment environment) {
		if (entity.getCard_BankAccount_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBankAccount_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BankAccountDataLoader.C_BankAccount_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getCard_BankAccount_ID());
	}


	/**
	 * Get Transfer Card trx to.
	 *
	 * @return Bank account on which to transfer Card transactions
	 */
	public CompletableFuture<MBankAccount_BH> CardTransferBankAccount(MPOSTerminal entity, DataFetchingEnvironment environment) {
		if (entity.getCardTransferBankAccount_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBankAccount_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BankAccountDataLoader.C_BankAccount_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getCardTransferBankAccount_ID());
	}


	/**
	 * Get Transfer Card trx to.
	 *
	 * @return Cash Book on which to transfer all Card transactions
	 */
	public CompletableFuture<MCashBook> CardTransferCashBook(MPOSTerminal entity, DataFetchingEnvironment environment) {
		if (entity.getCardTransferCashBook_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCashBook> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CashBookDataLoader.C_CashBook_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getCardTransferCashBook_ID());
	}

	static Map<String, String> CARDTRANSFERTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("B", "2564e1bc-067f-4dbf-af2e-30246bb9d827");
			put("C", "a8bbe89f-3ea0-41d2-bb0d-6c69436a26f1");
		}
	};
	public CompletableFuture<MRefList_BH> CardTransferType(MPOSTerminal entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getCardTransferType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(CARDTRANSFERTYPE_UUIDS_BY_VALUE.get(entity.getCardTransferType()));
	}

	static Map<String, String> CASHBOOKTRANSFERTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("B", "2564e1bc-067f-4dbf-af2e-30246bb9d827");
			put("C", "a8bbe89f-3ea0-41d2-bb0d-6c69436a26f1");
		}
	};
	public CompletableFuture<MRefList_BH> CashBookTransferType(MPOSTerminal entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getCashBookTransferType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(CASHBOOKTRANSFERTYPE_UUIDS_BY_VALUE.get(entity.getCashBookTransferType()));
	}


	/**
	 * Get Transfer Cash trx to.
	 *
	 * @return Bank Account on which to transfer all Cash transactions
	 */
	public CompletableFuture<MBankAccount_BH> CashTransferBankAccount(MPOSTerminal entity, DataFetchingEnvironment environment) {
		if (entity.getCashTransferBankAccount_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBankAccount_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BankAccountDataLoader.C_BankAccount_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getCashTransferBankAccount_ID());
	}


	/**
	 * Get Transfer Cash trx to.
	 *
	 * @return Cash Book on which to transfer all Cash transactions
	 */
	public CompletableFuture<MCashBook> CashTransferCashBook(MPOSTerminal entity, DataFetchingEnvironment environment) {
		if (entity.getCashTransferCashBook_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCashBook> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CashBookDataLoader.C_CashBook_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getCashTransferCashBook_ID());
	}


	/**
	 * Get Check Bank Account.
	 *
	 * @return Bank Account to be used for processing Check transactions
	 */
	public CompletableFuture<MBankAccount_BH> Check_BankAccount(MPOSTerminal entity, DataFetchingEnvironment environment) {
		if (entity.getCheck_BankAccount_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBankAccount_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BankAccountDataLoader.C_BankAccount_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getCheck_BankAccount_ID());
	}


	/**
	 * Get Tranfer Check trx to.
	 *
	 * @return Bank account on which to transfer Check transactions
	 */
	public CompletableFuture<MBankAccount_BH> CheckTransferBankAccount(MPOSTerminal entity, DataFetchingEnvironment environment) {
		if (entity.getCheckTransferBankAccount_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBankAccount_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BankAccountDataLoader.C_BankAccount_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getCheckTransferBankAccount_ID());
	}


	/**
	 * Get Transfer Check trx to.
	 *
	 * @return Cash Book on which to transfer all Check transactions
	 */
	public CompletableFuture<MCashBook> CheckTransferCashBook(MPOSTerminal entity, DataFetchingEnvironment environment) {
		if (entity.getCheckTransferCashBook_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCashBook> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CashBookDataLoader.C_CashBook_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getCheckTransferCashBook_ID());
	}

	static Map<String, String> CHECKTRANSFERTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("B", "2564e1bc-067f-4dbf-af2e-30246bb9d827");
			put("C", "a8bbe89f-3ea0-41d2-bb0d-6c69436a26f1");
		}
	};
	public CompletableFuture<MRefList_BH> CheckTransferType(MPOSTerminal entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getCheckTransferType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(CHECKTRANSFERTYPE_UUIDS_BY_VALUE.get(entity.getCheckTransferType()));
	}

	public Boolean Locked(MPOSTerminal entity, DataFetchingEnvironment environment) {
		return entity.isLocked();
	}


	/**
	 * Get Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	public CompletableFuture<MWarehouse_BH> M_Warehouse(MPOSTerminal entity, DataFetchingEnvironment environment) {
		if (entity.getM_Warehouse_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MWarehouse_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_WarehouseDataLoader.M_Warehouse_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Warehouse_ID());
	}


	/**
	 * Get Purchase Pricelist.
	 *
	 * @return Price List used by this Business Partner
	 */
	public CompletableFuture<MPriceList> PO_PriceList(MPOSTerminal entity, DataFetchingEnvironment environment) {
		if (entity.getPO_PriceList_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPriceList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_PriceListDataLoader.M_PriceList_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getPO_PriceList_ID());
	}


	/**
	 * Get Sales Representative.
	 *
	 * @return Sales Representative or Company Agent
	 */
	public CompletableFuture<MUser_BH> SalesRep(MPOSTerminal entity, DataFetchingEnvironment environment) {
		if (entity.getSalesRep_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.AD_User_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getSalesRep_ID());
	}


	/**
	 * Get Sales Pricelist.
	 *
	 * @return Sales Pricelist
	 */
	public CompletableFuture<MPriceList> SO_PriceList(MPOSTerminal entity, DataFetchingEnvironment environment) {
		if (entity.getSO_PriceList_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPriceList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_PriceListDataLoader.M_PriceList_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getSO_PriceList_ID());
	}

}
