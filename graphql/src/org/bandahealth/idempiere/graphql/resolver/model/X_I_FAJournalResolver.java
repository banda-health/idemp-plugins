package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_AssetDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctSchemaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ActivityDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CampaignDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DocTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ElementValueDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_LocationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PeriodDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_SalesRegionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_SubAcctDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_UOMDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ValidCombinationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_GL_BudgetDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_GL_CategoryDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_GL_JournalBatchDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_GL_JournalDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_GL_JournalLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MActivity;
import org.compiere.model.MAsset;
import org.compiere.model.MCampaign;
import org.compiere.model.MElementValue;
import org.compiere.model.MGLCategory;
import org.compiere.model.MJournal;
import org.compiere.model.MJournalBatch;
import org.compiere.model.MJournalLine;
import org.compiere.model.MLocation;
import org.compiere.model.MPeriod;
import org.compiere.model.MProject;
import org.compiere.model.MSalesRegion;
import org.compiere.model.MUOM;
import org.compiere.model.MXIFAJournal;
import org.compiere.model.X_C_SubAcct;
import org.compiere.model.X_GL_Budget;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for I_FAJournal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_I_FAJournalResolver extends POResolver<MXIFAJournal> implements GraphQLResolver<MXIFAJournal> {



	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	public CompletableFuture<MAsset> A_Asset(MXIFAJournal entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MAsset> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_AssetDataLoader.DATALOADER_A_Asset_BY_ID);
		return dataLoader.load(entity.getA_Asset_ID());
	}


	/**
	 * Get Account.
	 *
	 * @return Account used
	 */
	public CompletableFuture<MElementValue> Account(MXIFAJournal entity, DataFetchingEnvironment environment) {
		if (entity.getAccount_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.DATALOADER_C_ElementValue_BY_ID);
		return dataLoader.load(entity.getAccount_ID());
	}


	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public CompletableFuture<MAcctSchema> C_AcctSchema(MXIFAJournal entity, DataFetchingEnvironment environment) {
		if (entity.getC_AcctSchema_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MAcctSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_AcctSchemaDataLoader.DATALOADER_C_AcctSchema_BY_ID);
		return dataLoader.load(entity.getC_AcctSchema_ID());
	}


	/**
	 * Get Activity.
	 *
	 * @return Business Activity
	 */
	public CompletableFuture<MActivity> C_Activity(MXIFAJournal entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MBPartner_BH> C_BPartner(MXIFAJournal entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Campaign.
	 *
	 * @return Marketing Campaign
	 */
	public CompletableFuture<MCampaign> C_Campaign(MXIFAJournal entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MCurrency_BH> C_Currency(MXIFAJournal entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MCurrency_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.DATALOADER_C_Currency_BY_ID);
		return dataLoader.load(entity.getC_Currency_ID());
	}


	/**
	 * Get Document Type.
	 *
	 * @return Document type or rules
	 */
	public CompletableFuture<MDocType_BH> C_DocType(MXIFAJournal entity, DataFetchingEnvironment environment) {
		if (entity.getC_DocType_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MDocType_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DocTypeDataLoader.DATALOADER_C_DocType_BY_ID);
		return dataLoader.load(entity.getC_DocType_ID());
	}


	/**
	 * Get Location From.
	 *
	 * @return Location that inventory was moved from
	 */
	public CompletableFuture<MLocation> C_LocFrom(MXIFAJournal entity, DataFetchingEnvironment environment) {
		if (entity.getC_LocFrom_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_LocationDataLoader.DATALOADER_C_Location_BY_ID);
		return dataLoader.load(entity.getC_LocFrom_ID());
	}


	/**
	 * Get Location To.
	 *
	 * @return Location that inventory was moved to
	 */
	public CompletableFuture<MLocation> C_LocTo(MXIFAJournal entity, DataFetchingEnvironment environment) {
		if (entity.getC_LocTo_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_LocationDataLoader.DATALOADER_C_Location_BY_ID);
		return dataLoader.load(entity.getC_LocTo_ID());
	}


	/**
	 * Get Period.
	 *
	 * @return Period of the Calendar
	 */
	public CompletableFuture<MPeriod> C_Period(MXIFAJournal entity, DataFetchingEnvironment environment) {
		if (entity.getC_Period_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MPeriod> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PeriodDataLoader.DATALOADER_C_Period_BY_ID);
		return dataLoader.load(entity.getC_Period_ID());
	}


	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	public CompletableFuture<MProject> C_Project(MXIFAJournal entity, DataFetchingEnvironment environment) {
		if (entity.getC_Project_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProject> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ProjectDataLoader.DATALOADER_C_Project_BY_ID);
		return dataLoader.load(entity.getC_Project_ID());
	}


	/**
	 * Get Sales Region.
	 *
	 * @return Sales coverage region
	 */
	public CompletableFuture<MSalesRegion> C_SalesRegion(MXIFAJournal entity, DataFetchingEnvironment environment) {
		if (entity.getC_SalesRegion_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MSalesRegion> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_SalesRegionDataLoader.DATALOADER_C_SalesRegion_BY_ID);
		return dataLoader.load(entity.getC_SalesRegion_ID());
	}


	/**
	 * Get Sub Account.
	 *
	 * @return Sub account for Element Value
	 */
	public CompletableFuture<X_C_SubAcct> C_SubAcct(MXIFAJournal entity, DataFetchingEnvironment environment) {
		if (entity.getC_SubAcct_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_C_SubAcct> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_SubAcctDataLoader.DATALOADER_C_SubAcct_BY_ID);
		return dataLoader.load(entity.getC_SubAcct_ID());
	}


	/**
	 * Get UOM.
	 *
	 * @return Unit of Measure
	 */
	public CompletableFuture<MUOM> C_UOM(MXIFAJournal entity, DataFetchingEnvironment environment) {
		if (entity.getC_UOM_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MUOM> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_UOMDataLoader.DATALOADER_C_UOM_BY_ID);
		return dataLoader.load(entity.getC_UOM_ID());
	}

	public static Map<String, String> CURRENCYRATETYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("S", "7e046d87-539f-4ff9-8de0-cbe0ca981405"); // Spot
			put("P", "5f4d34be-d6d0-43ec-9043-6bbc3f9f3313"); // Period End
			put("N", "cdf719c4-b4a7-4829-a4ef-9a8cd9c7d761"); // None
			put("F", "f0169bf9-24d7-4427-a9ea-c8c902535324"); // Fixed
			put("A", "c13118d6-5fbe-4755-ba9f-20cc356f6d42"); // Average
			put("C", "f22545fa-12dd-4c18-b472-6f8c8a6b4ede"); // Company
			put("U", "cef79b78-a986-4b40-a423-65d8b1c355c1"); // User Type
			put("M", "4387df67-7fc7-4a37-adba-e0a9dbe01c1a"); // Manual Rate
		}
	};
	public CompletableFuture<MRefList_BH> CurrencyRateType(MXIFAJournal entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getCurrencyRateType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(CURRENCYRATETYPE_UUIDS_BY_VALUE.get(entity.getCurrencyRateType()));
	}


	/**
	 * Get Combination.
	 *
	 * @return Valid Account Combination
	 */
	public CompletableFuture<MAccount> C_ValidCombination(MXIFAJournal entity, DataFetchingEnvironment environment) {
		if (entity.getC_ValidCombination_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ValidCombinationDataLoader.DATALOADER_C_ValidCombination_BY_ID);
		return dataLoader.load(entity.getC_ValidCombination_ID());
	}


	/**
	 * Get Budget.
	 *
	 * @return General Ledger Budget
	 */
	public CompletableFuture<X_GL_Budget> GL_Budget(MXIFAJournal entity, DataFetchingEnvironment environment) {
		if (entity.getGL_Budget_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_GL_Budget> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_GL_BudgetDataLoader.DATALOADER_GL_Budget_BY_ID);
		return dataLoader.load(entity.getGL_Budget_ID());
	}


	/**
	 * Get GL Category.
	 *
	 * @return General Ledger Category
	 */
	public CompletableFuture<MGLCategory> GL_Category(MXIFAJournal entity, DataFetchingEnvironment environment) {
		if (entity.getGL_Category_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MGLCategory> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_GL_CategoryDataLoader.DATALOADER_GL_Category_BY_ID);
		return dataLoader.load(entity.getGL_Category_ID());
	}


	/**
	 * Get Journal Batch.
	 *
	 * @return General Ledger Journal Batch
	 */
	public CompletableFuture<MJournalBatch> GL_JournalBatch(MXIFAJournal entity, DataFetchingEnvironment environment) {
		if (entity.getGL_JournalBatch_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MJournalBatch> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_GL_JournalBatchDataLoader.DATALOADER_GL_JournalBatch_BY_ID);
		return dataLoader.load(entity.getGL_JournalBatch_ID());
	}


	/**
	 * Get Journal.
	 *
	 * @return General Ledger Journal
	 */
	public CompletableFuture<MJournal> GL_Journal(MXIFAJournal entity, DataFetchingEnvironment environment) {
		if (entity.getGL_Journal_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MJournal> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_GL_JournalDataLoader.DATALOADER_GL_Journal_BY_ID);
		return dataLoader.load(entity.getGL_Journal_ID());
	}


	/**
	 * Get Journal Line.
	 *
	 * @return General Ledger Journal Line
	 */
	public CompletableFuture<MJournalLine> GL_JournalLine(MXIFAJournal entity, DataFetchingEnvironment environment) {
		if (entity.getGL_JournalLine_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MJournalLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_GL_JournalLineDataLoader.DATALOADER_GL_JournalLine_BY_ID);
		return dataLoader.load(entity.getGL_JournalLine_ID());
	}

	public Boolean I_IsImported(MXIFAJournal entity, DataFetchingEnvironment environment) {
		return entity.isI_IsImported();
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(MXIFAJournal entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}

	public static Map<String, String> POSTINGTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "3c9d051c-7b7b-459d-90c5-0925e26c1bcc"); // Actual
			put("B", "07bbb012-66f2-4860-bd6d-dc511618bf4e"); // Budget
			put("E", "c40ae7b1-be06-4291-ac88-59974f74a46d"); // Commitment
			put("S", "6011c5d4-edcc-48f6-ba32-8d820d42dbfb"); // Statistical
			put("R", "c1e61fc6-ba26-400c-9ae4-716b3c67e1d5"); // Reservation
		}
	};
	public CompletableFuture<MRefList_BH> PostingType(MXIFAJournal entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPostingType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(POSTINGTYPE_UUIDS_BY_VALUE.get(entity.getPostingType()));
	}

	public Boolean Processed(MXIFAJournal entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(MXIFAJournal entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}


	/**
	 * Get User Element List 1.
	 *
	 * @return User defined list element #1
	 */
	public CompletableFuture<MElementValue> User1(MXIFAJournal entity, DataFetchingEnvironment environment) {
		if (entity.getUser1_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.DATALOADER_C_ElementValue_BY_ID);
		return dataLoader.load(entity.getUser1_ID());
	}


	/**
	 * Get User Element List 2.
	 *
	 * @return User defined list element #2
	 */
	public CompletableFuture<MElementValue> User2(MXIFAJournal entity, DataFetchingEnvironment environment) {
		if (entity.getUser2_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.DATALOADER_C_ElementValue_BY_ID);
		return dataLoader.load(entity.getUser2_ID());
	}

}
