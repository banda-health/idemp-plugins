package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ActivityDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartner_LocationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CampaignDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaymentTermDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PhaseDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PriceList_VersionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_WarehouseDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MActivity;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MCampaign;
import org.compiere.model.MPaymentTerm;
import org.compiere.model.MPriceListVersion;
import org.compiere.model.MProject;
import org.compiere.model.MProjectTypePhase;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_Project - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_ProjectResolver extends POResolver<MProject> implements GraphQLResolver<MProject> {



	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(MProject entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getAD_User_ID());
	}


	/**
	 * Get Activity.
	 *
	 * @return Business Activity
	 */
	public CompletableFuture<MActivity> C_Activity(MProject entity, DataFetchingEnvironment environment) {
		if (entity.getC_Activity_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MActivity> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ActivityDataLoader.DATALOADER_C_Activity_BY_ID);
		return dataLoader.load(entity.getC_Activity_ID());
	}


	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(MProject entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Partner Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	public CompletableFuture<MBPartnerLocation> C_BPartner_Location(MProject entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_Location_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBPartnerLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartner_LocationDataLoader.DATALOADER_C_BPartner_Location_BY_ID);
		return dataLoader.load(entity.getC_BPartner_Location_ID());
	}


	/**
	 * Get BPartner (Agent).
	 *
	 * @return Business Partner (Agent or Sales Rep)
	 */
	public CompletableFuture<MBPartner_BH> C_BPartnerSR(MProject entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartnerSR_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartnerSR_ID());
	}


	/**
	 * Get Campaign.
	 *
	 * @return Marketing Campaign
	 */
	public CompletableFuture<MCampaign> C_Campaign(MProject entity, DataFetchingEnvironment environment) {
		if (entity.getC_Campaign_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MCampaign> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CampaignDataLoader.DATALOADER_C_Campaign_BY_ID);
		return dataLoader.load(entity.getC_Campaign_ID());
	}


	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public CompletableFuture<MCurrency_BH> C_Currency(MProject entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MCurrency_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.DATALOADER_C_Currency_BY_ID);
		return dataLoader.load(entity.getC_Currency_ID());
	}


	/**
	 * Get Payment Term.
	 *
	 * @return The terms of Payment (timing, discount)
	 */
	public CompletableFuture<MPaymentTerm> C_PaymentTerm(MProject entity, DataFetchingEnvironment environment) {
		if (entity.getC_PaymentTerm_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MPaymentTerm> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PaymentTermDataLoader.DATALOADER_C_PaymentTerm_BY_ID);
		return dataLoader.load(entity.getC_PaymentTerm_ID());
	}


	/**
	 * Get Standard Phase.
	 *
	 * @return Standard Phase of the Project Type
	 */
	public CompletableFuture<MProjectTypePhase> C_Phase(MProject entity, DataFetchingEnvironment environment) {
		if (entity.getC_Phase_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProjectTypePhase> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PhaseDataLoader.DATALOADER_C_Phase_BY_ID);
		return dataLoader.load(entity.getC_Phase_ID());
	}

	public Boolean IsCommitCeiling(MProject entity, DataFetchingEnvironment environment) {
		return entity.isCommitCeiling();
	}

	public Boolean IsCommitment(MProject entity, DataFetchingEnvironment environment) {
		return entity.isCommitment();
	}

	public Boolean IsSummary(MProject entity, DataFetchingEnvironment environment) {
		return entity.isSummary();
	}


	/**
	 * Get Price List Version.
	 *
	 * @return Identifies a unique instance of a Price List
	 */
	public CompletableFuture<MPriceListVersion> M_PriceList_Version(MProject entity, DataFetchingEnvironment environment) {
		if (entity.getM_PriceList_Version_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MPriceListVersion> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_PriceList_VersionDataLoader.DATALOADER_M_PriceList_Version_BY_ID);
		return dataLoader.load(entity.getM_PriceList_Version_ID());
	}


	/**
	 * Get Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	public CompletableFuture<MWarehouse_BH> M_Warehouse(MProject entity, DataFetchingEnvironment environment) {
		if (entity.getM_Warehouse_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MWarehouse_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_WarehouseDataLoader.DATALOADER_M_Warehouse_BY_ID);
		return dataLoader.load(entity.getM_Warehouse_ID());
	}

	public Boolean Processed(MProject entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(MProject entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

	public static Map<String, String> PROJECTCATEGORY_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("N", "0ee15c1f-fd85-4277-a4ba-5019cfefa415"); // General
			put("A", "8325d87d-5eb8-482e-803d-215889471ef5"); // Asset Project
			put("W", "7e8413bf-2c7a-4ecd-b00e-684ef95ff4eb"); // Work Order (Job)
			put("S", "8a6796ad-4e16-412c-a34b-0e92bf6f5e00"); // Service (Charge) Project
		}
	};
	public CompletableFuture<MRefList_BH> ProjectCategory(MProject entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getProjectCategory())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(PROJECTCATEGORY_UUIDS_BY_VALUE.get(entity.getProjectCategory()));
	}

	public static Map<String, String> PROJECTLINELEVEL_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("P", "8ce67166-ddc3-47ce-b7a4-26d876445eb5"); // Project
			put("A", "e9321764-fa27-4715-9707-8e568c21ebf5"); // Phase
			put("T", "5eab135d-e477-4fb0-8203-38a3c4b8f043"); // Task
		}
	};
	public CompletableFuture<MRefList_BH> ProjectLineLevel(MProject entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getProjectLineLevel())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(PROJECTLINELEVEL_UUIDS_BY_VALUE.get(entity.getProjectLineLevel()));
	}

	public static Map<String, String> PROJINVOICERULE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("-", "b2c13436-dfd4-4b95-a0fe-a0429485d425"); // None
			put("C", "4311a616-dbf6-4e2a-bc9b-a7726e4f075c"); // Committed Amount
			put("c", "e9bbae09-f9ce-4dfd-a9d6-487109574052"); // Time&Material max Committed
			put("T", "f724e224-f0fb-4575-94ae-b4aa8e6c8c54"); // Time&Material
			put("P", "c6d2fa2b-6f89-41b1-9e53-db77217d3ff1"); // Product  Quantity
		}
	};
	public CompletableFuture<MRefList_BH> ProjInvoiceRule(MProject entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getProjInvoiceRule())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(PROJINVOICERULE_UUIDS_BY_VALUE.get(entity.getProjInvoiceRule()));
	}


	/**
	 * Get Sales Representative.
	 *
	 * @return Sales Representative or Company Agent
	 */
	public CompletableFuture<MUser_BH> SalesRep(MProject entity, DataFetchingEnvironment environment) {
		if (entity.getSalesRep_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getSalesRep_ID());
	}

}
