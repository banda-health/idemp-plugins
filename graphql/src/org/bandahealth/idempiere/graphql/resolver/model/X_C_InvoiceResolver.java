package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MBHVoidedReason;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_VisitDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Voided_ReasonDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ActivityDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartner_LocationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CampaignDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CashLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CashPlanLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ChargeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ConversionTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DocTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DunningLevelDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ElementValueDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OrderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaymentDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaymentTermDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PriceListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_RMADataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MActivity;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MCampaign;
import org.compiere.model.MCashLine;
import org.compiere.model.MCashPlanLine;
import org.compiere.model.MConversionType;
import org.compiere.model.MDunningLevel;
import org.compiere.model.MElementValue;
import org.compiere.model.MPaymentTerm;
import org.compiere.model.MPriceList;
import org.compiere.model.MProject;
import org.compiere.model.MRMA;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_Invoice - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_InvoiceResolver extends POResolver<MInvoice_BH> implements GraphQLResolver<MInvoice_BH> {



	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(MInvoice_BH entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getAD_User_ID());
	}


	/**
	 * Get Visit.
	 *
	 * @return Visit
	 */
	public CompletableFuture<MBHVisit> BH_Visit(MInvoice_BH entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Visit_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBHVisit> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_VisitDataLoader.DATALOADER_BH_Visit_BY_ID);
		return dataLoader.load(entity.getBH_Visit_ID());
	}


	/**
	 * Get BH_Voided_Reason_ID.
	 *
	 * @return BH_Voided_Reason_ID
	 */
	public CompletableFuture<MBHVoidedReason> BH_Voided_Reason(MInvoice_BH entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Voided_Reason_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBHVoidedReason> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_Voided_ReasonDataLoader.DATALOADER_BH_Voided_Reason_BY_ID);
		return dataLoader.load(entity.getBH_Voided_Reason_ID());
	}


	/**
	 * Get Activity.
	 *
	 * @return Business Activity
	 */
	public CompletableFuture<MActivity> C_Activity(MInvoice_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Activity_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MActivity> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ActivityDataLoader.DATALOADER_C_Activity_BY_ID);
		return dataLoader.load(entity.getC_Activity_ID());
	}


	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(MInvoice_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() <= 0) {
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
	public CompletableFuture<MBPartnerLocation> C_BPartner_Location(MInvoice_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_Location_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartnerLocation> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartner_LocationDataLoader.DATALOADER_C_BPartner_Location_BY_ID);
		return dataLoader.load(entity.getC_BPartner_Location_ID());
	}


	/**
	 * Get Campaign.
	 *
	 * @return Marketing Campaign
	 */
	public CompletableFuture<MCampaign> C_Campaign(MInvoice_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Campaign_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCampaign> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CampaignDataLoader.DATALOADER_C_Campaign_BY_ID);
		return dataLoader.load(entity.getC_Campaign_ID());
	}


	/**
	 * Get Cash Journal Line.
	 *
	 * @return Cash Journal Line
	 */
	public CompletableFuture<MCashLine> C_CashLine(MInvoice_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_CashLine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCashLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CashLineDataLoader.DATALOADER_C_CashLine_BY_ID);
		return dataLoader.load(entity.getC_CashLine_ID());
	}


	/**
	 * Get Cash Plan Line.
	 *
	 * @return Cash Plan Line
	 */
	public CompletableFuture<MCashPlanLine> C_CashPlanLine(MInvoice_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_CashPlanLine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCashPlanLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CashPlanLineDataLoader.DATALOADER_C_CashPlanLine_BY_ID);
		return dataLoader.load(entity.getC_CashPlanLine_ID());
	}


	/**
	 * Get Charge.
	 *
	 * @return Additional document charges
	 */
	public CompletableFuture<MCharge_BH> C_Charge(MInvoice_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Charge_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCharge_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ChargeDataLoader.DATALOADER_C_Charge_BY_ID);
		return dataLoader.load(entity.getC_Charge_ID());
	}


	/**
	 * Get Currency Type.
	 *
	 * @return Currency Conversion Rate Type
	 */
	public CompletableFuture<MConversionType> C_ConversionType(MInvoice_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_ConversionType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MConversionType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ConversionTypeDataLoader.DATALOADER_C_ConversionType_BY_ID);
		return dataLoader.load(entity.getC_ConversionType_ID());
	}


	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public CompletableFuture<MCurrency_BH> C_Currency(MInvoice_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() <= 0) {
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
	public CompletableFuture<MDocType_BH> C_DocType(MInvoice_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_DocType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MDocType_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DocTypeDataLoader.DATALOADER_C_DocType_BY_ID);
		return dataLoader.load(entity.getC_DocType_ID());
	}


	/**
	 * Get Target Document Type.
	 *
	 * @return Target document type for conversing documents
	 */
	public CompletableFuture<MDocType_BH> C_DocTypeTarget(MInvoice_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_DocTypeTarget_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MDocType_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DocTypeDataLoader.DATALOADER_C_DocType_BY_ID);
		return dataLoader.load(entity.getC_DocTypeTarget_ID());
	}


	/**
	 * Get Dunning Level.
	 *
	 * @return Dunning Level
	 */
	public CompletableFuture<MDunningLevel> C_DunningLevel(MInvoice_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_DunningLevel_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MDunningLevel> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DunningLevelDataLoader.DATALOADER_C_DunningLevel_BY_ID);
		return dataLoader.load(entity.getC_DunningLevel_ID());
	}


	/**
	 * Get Order.
	 *
	 * @return Order
	 */
	public CompletableFuture<MOrder_BH> C_Order(MInvoice_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Order_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MOrder_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_OrderDataLoader.DATALOADER_C_Order_BY_ID);
		return dataLoader.load(entity.getC_Order_ID());
	}


	/**
	 * Get Payment.
	 *
	 * @return Payment identifier
	 */
	public CompletableFuture<MPayment_BH> C_Payment(MInvoice_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Payment_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPayment_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PaymentDataLoader.DATALOADER_C_Payment_BY_ID);
		return dataLoader.load(entity.getC_Payment_ID());
	}


	/**
	 * Get Payment Term.
	 *
	 * @return The terms of Payment (timing, discount)
	 */
	public CompletableFuture<MPaymentTerm> C_PaymentTerm(MInvoice_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_PaymentTerm_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPaymentTerm> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PaymentTermDataLoader.DATALOADER_C_PaymentTerm_BY_ID);
		return dataLoader.load(entity.getC_PaymentTerm_ID());
	}


	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	public CompletableFuture<MProject> C_Project(MInvoice_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Project_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProject> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ProjectDataLoader.DATALOADER_C_Project_BY_ID);
		return dataLoader.load(entity.getC_Project_ID());
	}

	static Map<String, String> DOCACTION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("CO", "74a9fe55-28e4-4d3b-98aa-02ad6d1a12da");
			put("AP", "f80665a4-0db1-4609-be56-5d69b762d169");
			put("RJ", "8fffbfd1-560a-4a78-9181-e5b76bbb3354");
			put("PO", "0fe1c0e9-2ca1-48f2-837b-a4ff16c629d9");
			put("VO", "930f9be7-85bc-4002-83a6-fe4e1b8cfce3");
			put("CL", "d0a6de04-9c59-4d37-998d-f8070db820b0");
			put("RC", "597e3e98-f1cd-4157-885a-1fae6424a3a6");
			put("RA", "1a3904b9-86bc-4831-a4af-0281dcafa8f8");
			put("IN", "69ff146b-fe0e-44a0-98d1-80b2f7958edf");
			put("RE", "c8f55635-67a3-42ae-b626-2064acb2e260");
			put("--", "ea523fb8-e21b-4a77-a657-6f5a7d12a591");
			put("PR", "b6f04b4b-6034-4490-83ed-d0f4f9cb5f76");
			put("XL", "b2d93bde-a7e7-43f0-9b1c-82527992f6d5");
			put("WC", "2143c53d-f6a6-4da6-8fe6-4ce4b6dacac0");
		}
	};
	public CompletableFuture<MRefList_BH> DocAction(MInvoice_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDocAction())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(DOCACTION_UUIDS_BY_VALUE.get(entity.getDocAction()));
	}

	static Map<String, String> DOCSTATUS_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("DR", "d27f8a6b-e8b5-4fea-a6b2-3e7049c473ec");
			put("CO", "50702660-bbfc-422a-8acc-5ed3a2dce204");
			put("AP", "a838dad1-b7fc-4b26-9d80-d45f2d8484c5");
			put("NA", "c8c414ee-3e4e-480b-aa0e-bc6c1d100bd2");
			put("VO", "d35dfd1d-1eb2-46ef-ab2f-23973d68a570");
			put("IN", "c2d506ba-1916-4ca2-abde-da3127c11d77");
			put("RE", "029a78cf-d45c-4fb2-a6c9-fb92c2311af6");
			put("CL", "ab9df095-8aa8-4338-98b6-4b09ab9d459e");
			put("??", "0b6ed143-fad9-4ba2-824c-b3a89b9bb2d2");
			put("IP", "9f864275-6135-452f-a5a7-9377d9ed32bc");
			put("WP", "4a9871d9-ec70-489f-aca5-05adb7e61df9");
			put("WC", "56264c44-b530-4a53-b07b-6fb203ff61a6");
		}
	};
	public CompletableFuture<MRefList_BH> DocStatus(MInvoice_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDocStatus())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(DOCSTATUS_UUIDS_BY_VALUE.get(entity.getDocStatus()));
	}

	static Map<String, String> INVOICECOLLECTIONTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("D", "451767f3-eea6-4809-9d1f-bccd5831913c");
			put("C", "d5422428-9e78-45ec-b83d-30e52302aac9");
			put("L", "18587352-5a00-4c61-9b78-91424935e13d");
			put("U", "60a1b77c-d200-4adc-b845-7ec3760ce5b7");
		}
	};
	public CompletableFuture<MRefList_BH> InvoiceCollectionType(MInvoice_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getInvoiceCollectionType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(INVOICECOLLECTIONTYPE_UUIDS_BY_VALUE.get(entity.getInvoiceCollectionType()));
	}

	public Boolean IsApproved(MInvoice_BH entity, DataFetchingEnvironment environment) {
		return entity.isApproved();
	}

	public Boolean IsDiscountPrinted(MInvoice_BH entity, DataFetchingEnvironment environment) {
		return entity.isDiscountPrinted();
	}

	public Boolean IsFixedAssetInvoice(MInvoice_BH entity, DataFetchingEnvironment environment) {
		return entity.isFixedAssetInvoice();
	}

	public Boolean IsInDispute(MInvoice_BH entity, DataFetchingEnvironment environment) {
		return entity.isInDispute();
	}

	public Boolean IsOverrideCurrencyRate(MInvoice_BH entity, DataFetchingEnvironment environment) {
		return entity.isOverrideCurrencyRate();
	}

	public Boolean IsPaid(MInvoice_BH entity, DataFetchingEnvironment environment) {
		return entity.isPaid();
	}

	public Boolean IsPayScheduleValid(MInvoice_BH entity, DataFetchingEnvironment environment) {
		return entity.isPayScheduleValid();
	}

	public Boolean IsPrinted(MInvoice_BH entity, DataFetchingEnvironment environment) {
		return entity.isPrinted();
	}

	public Boolean IsSelfService(MInvoice_BH entity, DataFetchingEnvironment environment) {
		return entity.isSelfService();
	}

	public Boolean IsSOTrx(MInvoice_BH entity, DataFetchingEnvironment environment) {
		return entity.isSOTrx();
	}

	public Boolean IsTaxIncluded(MInvoice_BH entity, DataFetchingEnvironment environment) {
		return entity.isTaxIncluded();
	}

	public Boolean IsTransferred(MInvoice_BH entity, DataFetchingEnvironment environment) {
		return entity.isTransferred();
	}


	/**
	 * Get Price List.
	 *
	 * @return Unique identifier of a Price List
	 */
	public CompletableFuture<MPriceList> M_PriceList(MInvoice_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_PriceList_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPriceList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_PriceListDataLoader.DATALOADER_M_PriceList_BY_ID);
		return dataLoader.load(entity.getM_PriceList_ID());
	}


	/**
	 * Get RMA.
	 *
	 * @return Return Material Authorization
	 */
	public CompletableFuture<MRMA> M_RMA(MInvoice_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_RMA_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRMA> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_RMADataLoader.DATALOADER_M_RMA_BY_ID);
		return dataLoader.load(entity.getM_RMA_ID());
	}

	public Boolean Posted(MInvoice_BH entity, DataFetchingEnvironment environment) {
		return entity.isPosted();
	}

	public Boolean Processed(MInvoice_BH entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(MInvoice_BH entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}


	/**
	 * Get Related Invoice.
	 *
	 * @return Related Invoice
	 */
	public CompletableFuture<MInvoice_BH> RelatedInvoice(MInvoice_BH entity, DataFetchingEnvironment environment) {
		if (entity.getRelatedInvoice_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInvoice_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoiceDataLoader.DATALOADER_C_Invoice_BY_ID);
		return dataLoader.load(entity.getRelatedInvoice_ID());
	}


	/**
	 * Get Reversal ID.
	 *
	 * @return ID of document reversal
	 */
	public CompletableFuture<MInvoice_BH> Reversal(MInvoice_BH entity, DataFetchingEnvironment environment) {
		if (entity.getReversal_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInvoice_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoiceDataLoader.DATALOADER_C_Invoice_BY_ID);
		return dataLoader.load(entity.getReversal_ID());
	}


	/**
	 * Get Sales Representative.
	 *
	 * @return Sales Representative or Company Agent
	 */
	public CompletableFuture<MUser_BH> SalesRep(MInvoice_BH entity, DataFetchingEnvironment environment) {
		if (entity.getSalesRep_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getSalesRep_ID());
	}

	public Boolean SendEMail(MInvoice_BH entity, DataFetchingEnvironment environment) {
		return entity.isSendEMail();
	}


	/**
	 * Get User Element List 1.
	 *
	 * @return User defined list element #1
	 */
	public CompletableFuture<MElementValue> User1(MInvoice_BH entity, DataFetchingEnvironment environment) {
		if (entity.getUser1_ID() <= 0) {
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
	public CompletableFuture<MElementValue> User2(MInvoice_BH entity, DataFetchingEnvironment environment) {
		if (entity.getUser2_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.DATALOADER_C_ElementValue_BY_ID);
		return dataLoader.load(entity.getUser2_ID());
	}

}
