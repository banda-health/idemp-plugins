package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MTable_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_RoleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_AssetDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ActivityDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CampaignDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OrderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaymentDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ChangeNoticeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ChangeRequestDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_InOutDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_RMADataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_CategoryDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_GroupDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_MailTextDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_RequestDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_RequestTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_ResolutionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_StandardResponseDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_StatusDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MActivity;
import org.compiere.model.MAsset;
import org.compiere.model.MCampaign;
import org.compiere.model.MChangeNotice;
import org.compiere.model.MChangeRequest;
import org.compiere.model.MGroup;
import org.compiere.model.MMailText;
import org.compiere.model.MProject;
import org.compiere.model.MRMA;
import org.compiere.model.MRequest;
import org.compiere.model.MRequestCategory;
import org.compiere.model.MRequestType;
import org.compiere.model.MResolution;
import org.compiere.model.MStatus;
import org.compiere.model.X_AD_Role;
import org.compiere.model.X_R_StandardResponse;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for R_Request - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_R_RequestResolver extends POResolver<MRequest> implements GraphQLResolver<MRequest> {



	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	public CompletableFuture<MAsset> A_Asset(MRequest entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAsset> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_AssetDataLoader.DATALOADER_A_Asset_BY_ID);
		return dataLoader.load(entity.getA_Asset_ID());
	}


	/**
	 * Get Role.
	 *
	 * @return Responsibility Role
	 */
	public CompletableFuture<X_AD_Role> AD_Role(MRequest entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Role_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_Role> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_RoleDataLoader.DATALOADER_AD_Role_BY_ID);
		return dataLoader.load(entity.getAD_Role_ID());
	}


	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable_BH> AD_Table(MRequest entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTable_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TableDataLoader.DATALOADER_AD_Table_BY_ID);
		return dataLoader.load(entity.getAD_Table_ID());
	}


	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(MRequest entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() <= 0) {
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
	public CompletableFuture<MActivity> C_Activity(MRequest entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MBPartner_BH> C_BPartner(MRequest entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() <= 0) {
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
	public CompletableFuture<MCampaign> C_Campaign(MRequest entity, DataFetchingEnvironment environment) {
		if (entity.getC_Campaign_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCampaign> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CampaignDataLoader.DATALOADER_C_Campaign_BY_ID);
		return dataLoader.load(entity.getC_Campaign_ID());
	}


	/**
	 * Get Invoice.
	 *
	 * @return Invoice Identifier
	 */
	public CompletableFuture<MInvoice_BH> C_Invoice(MRequest entity, DataFetchingEnvironment environment) {
		if (entity.getC_Invoice_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInvoice_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoiceDataLoader.DATALOADER_C_Invoice_BY_ID);
		return dataLoader.load(entity.getC_Invoice_ID());
	}


	/**
	 * Get Request Invoice.
	 *
	 * @return The generated invoice for this request
	 */
	public CompletableFuture<MInvoice_BH> C_InvoiceRequest(MRequest entity, DataFetchingEnvironment environment) {
		if (entity.getC_InvoiceRequest_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInvoice_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoiceDataLoader.DATALOADER_C_Invoice_BY_ID);
		return dataLoader.load(entity.getC_InvoiceRequest_ID());
	}


	/**
	 * Get Order.
	 *
	 * @return Order
	 */
	public CompletableFuture<MOrder_BH> C_Order(MRequest entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MPayment_BH> C_Payment(MRequest entity, DataFetchingEnvironment environment) {
		if (entity.getC_Payment_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPayment_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PaymentDataLoader.DATALOADER_C_Payment_BY_ID);
		return dataLoader.load(entity.getC_Payment_ID());
	}


	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	public CompletableFuture<MProject> C_Project(MRequest entity, DataFetchingEnvironment environment) {
		if (entity.getC_Project_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProject> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ProjectDataLoader.DATALOADER_C_Project_BY_ID);
		return dataLoader.load(entity.getC_Project_ID());
	}

	static Map<String, String> CONFIDENTIALTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "1eb43dd1-53c0-4b5c-aae4-585c7d3fc9c2");
			put("C", "0f1983c1-e543-4a8f-9b8a-4a00d2a111f4");
			put("I", "7c6def43-3d72-4c5b-93ce-dfbefd8545e4");
			put("P", "467c826c-2a44-4f65-8026-8dc6b1d7edec");
		}
	};
	public CompletableFuture<MRefList_BH> ConfidentialType(MRequest entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getConfidentialType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(CONFIDENTIALTYPE_UUIDS_BY_VALUE.get(entity.getConfidentialType()));
	}

	static Map<String, String> CONFIDENTIALTYPEENTRY_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "1eb43dd1-53c0-4b5c-aae4-585c7d3fc9c2");
			put("C", "0f1983c1-e543-4a8f-9b8a-4a00d2a111f4");
			put("I", "7c6def43-3d72-4c5b-93ce-dfbefd8545e4");
			put("P", "467c826c-2a44-4f65-8026-8dc6b1d7edec");
		}
	};
	public CompletableFuture<MRefList_BH> ConfidentialTypeEntry(MRequest entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getConfidentialTypeEntry())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(CONFIDENTIALTYPEENTRY_UUIDS_BY_VALUE.get(entity.getConfidentialTypeEntry()));
	}

	static Map<String, String> DUETYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("3", "27f3676c-5eb5-412e-a79a-74dcf8c540f8");
			put("5", "32055636-c517-4e8d-96df-d36a29c6a464");
			put("7", "50ad3137-583f-4a7c-8274-37557a98d31f");
		}
	};
	public CompletableFuture<MRefList_BH> DueType(MRequest entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDueType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(DUETYPE_UUIDS_BY_VALUE.get(entity.getDueType()));
	}

	public Boolean IsEscalated(MRequest entity, DataFetchingEnvironment environment) {
		return entity.isEscalated();
	}

	public Boolean IsInvoiced(MRequest entity, DataFetchingEnvironment environment) {
		return entity.isInvoiced();
	}

	public Boolean IsSelfService(MRequest entity, DataFetchingEnvironment environment) {
		return entity.isSelfService();
	}


	/**
	 * Get Change Request.
	 *
	 * @return BOM (Engineering) Change Request
	 */
	public CompletableFuture<MChangeRequest> M_ChangeRequest(MRequest entity, DataFetchingEnvironment environment) {
		if (entity.getM_ChangeRequest_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MChangeRequest> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ChangeRequestDataLoader.DATALOADER_M_ChangeRequest_BY_ID);
		return dataLoader.load(entity.getM_ChangeRequest_ID());
	}


	/**
	 * Get Fixed in.
	 *
	 * @return Fixed in Change Notice
	 */
	public CompletableFuture<MChangeNotice> M_FixChangeNotice(MRequest entity, DataFetchingEnvironment environment) {
		if (entity.getM_FixChangeNotice_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MChangeNotice> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ChangeNoticeDataLoader.DATALOADER_M_ChangeNotice_BY_ID);
		return dataLoader.load(entity.getM_FixChangeNotice_ID());
	}


	/**
	 * Get Shipment/Receipt.
	 *
	 * @return Material Shipment Document
	 */
	public CompletableFuture<MInOut_BH> M_InOut(MRequest entity, DataFetchingEnvironment environment) {
		if (entity.getM_InOut_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInOut_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_InOutDataLoader.DATALOADER_M_InOut_BY_ID);
		return dataLoader.load(entity.getM_InOut_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(MRequest entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}


	/**
	 * Get Product Used.
	 *
	 * @return Product/Resource/Service used in Request
	 */
	public CompletableFuture<MProduct_BH> M_ProductSpent(MRequest entity, DataFetchingEnvironment environment) {
		if (entity.getM_ProductSpent_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_ProductSpent_ID());
	}


	/**
	 * Get RMA.
	 *
	 * @return Return Material Authorization
	 */
	public CompletableFuture<MRMA> M_RMA(MRequest entity, DataFetchingEnvironment environment) {
		if (entity.getM_RMA_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRMA> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_RMADataLoader.DATALOADER_M_RMA_BY_ID);
		return dataLoader.load(entity.getM_RMA_ID());
	}

	static Map<String, String> NEXTACTION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("N", "49fcef51-734c-47c4-84c5-72b9d932fde5");
			put("F", "736096e6-7e2d-44e0-a2b0-c8e74c5e2abf");
		}
	};
	public CompletableFuture<MRefList_BH> NextAction(MRequest entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getNextAction())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(NEXTACTION_UUIDS_BY_VALUE.get(entity.getNextAction()));
	}

	static Map<String, String> PRIORITY_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("3", "eb2a15e0-e10d-47df-9ddd-d12d39b32007");
			put("5", "6ca5bed6-2fd6-4afd-b3a8-d9c91452e829");
			put("7", "74703c05-07aa-47d6-8ee3-e884ce2f505e");
			put("1", "6d26a706-aa9f-4111-8b5b-741aa48476d9");
			put("9", "c349e252-ad91-483f-b53f-0e92fabbaca5");
		}
	};
	public CompletableFuture<MRefList_BH> Priority(MRequest entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPriority())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(PRIORITY_UUIDS_BY_VALUE.get(entity.getPriority()));
	}

	static Map<String, String> PRIORITYUSER_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("3", "eb2a15e0-e10d-47df-9ddd-d12d39b32007");
			put("5", "6ca5bed6-2fd6-4afd-b3a8-d9c91452e829");
			put("7", "74703c05-07aa-47d6-8ee3-e884ce2f505e");
			put("1", "6d26a706-aa9f-4111-8b5b-741aa48476d9");
			put("9", "c349e252-ad91-483f-b53f-0e92fabbaca5");
		}
	};
	public CompletableFuture<MRefList_BH> PriorityUser(MRequest entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPriorityUser())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(PRIORITYUSER_UUIDS_BY_VALUE.get(entity.getPriorityUser()));
	}

	public Boolean Processed(MRequest entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}


	/**
	 * Get Category.
	 *
	 * @return Request Category
	 */
	public CompletableFuture<MRequestCategory> R_Category(MRequest entity, DataFetchingEnvironment environment) {
		if (entity.getR_Category_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRequestCategory> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_CategoryDataLoader.DATALOADER_R_Category_BY_ID);
		return dataLoader.load(entity.getR_Category_ID());
	}


	/**
	 * Get Group.
	 *
	 * @return Request Group
	 */
	public CompletableFuture<MGroup> R_Group(MRequest entity, DataFetchingEnvironment environment) {
		if (entity.getR_Group_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MGroup> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_GroupDataLoader.DATALOADER_R_Group_BY_ID);
		return dataLoader.load(entity.getR_Group_ID());
	}


	/**
	 * Get Mail Template.
	 *
	 * @return Text templates for mailings
	 */
	public CompletableFuture<MMailText> R_MailText(MRequest entity, DataFetchingEnvironment environment) {
		if (entity.getR_MailText_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MMailText> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_MailTextDataLoader.DATALOADER_R_MailText_BY_ID);
		return dataLoader.load(entity.getR_MailText_ID());
	}


	/**
	 * Get Related Request.
	 *
	 * @return Related Request (Master Issue, ..)
	 */
	public CompletableFuture<MRequest> R_RequestRelated(MRequest entity, DataFetchingEnvironment environment) {
		if (entity.getR_RequestRelated_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRequest> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_RequestDataLoader.DATALOADER_R_Request_BY_ID);
		return dataLoader.load(entity.getR_RequestRelated_ID());
	}


	/**
	 * Get Request Type.
	 *
	 * @return Type of request (e.g. Inquiry, Complaint, ..)
	 */
	public CompletableFuture<MRequestType> R_RequestType(MRequest entity, DataFetchingEnvironment environment) {
		if (entity.getR_RequestType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRequestType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_RequestTypeDataLoader.DATALOADER_R_RequestType_BY_ID);
		return dataLoader.load(entity.getR_RequestType_ID());
	}


	/**
	 * Get Resolution.
	 *
	 * @return Request Resolution
	 */
	public CompletableFuture<MResolution> R_Resolution(MRequest entity, DataFetchingEnvironment environment) {
		if (entity.getR_Resolution_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MResolution> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_ResolutionDataLoader.DATALOADER_R_Resolution_BY_ID);
		return dataLoader.load(entity.getR_Resolution_ID());
	}


	/**
	 * Get Standard Response.
	 *
	 * @return Request Standard Response 
	 */
	public CompletableFuture<X_R_StandardResponse> R_StandardResponse(MRequest entity, DataFetchingEnvironment environment) {
		if (entity.getR_StandardResponse_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_R_StandardResponse> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_StandardResponseDataLoader.DATALOADER_R_StandardResponse_BY_ID);
		return dataLoader.load(entity.getR_StandardResponse_ID());
	}


	/**
	 * Get Status.
	 *
	 * @return Request Status
	 */
	public CompletableFuture<MStatus> R_Status(MRequest entity, DataFetchingEnvironment environment) {
		if (entity.getR_Status_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MStatus> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_StatusDataLoader.DATALOADER_R_Status_BY_ID);
		return dataLoader.load(entity.getR_Status_ID());
	}


	/**
	 * Get Sales Representative.
	 *
	 * @return Sales Representative or Company Agent
	 */
	public CompletableFuture<MUser_BH> SalesRep(MRequest entity, DataFetchingEnvironment environment) {
		if (entity.getSalesRep_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getSalesRep_ID());
	}

	static Map<String, String> TASKSTATUS_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("0", "8728eddd-a152-49f0-8dc3-e727b50eebfc");
			put("D", "d12b8255-6269-4ceb-9639-120d25403f66");
			put("2", "354c2e39-18b6-4bf0-93f0-cace4a95d32e");
			put("8", "13ece71e-835f-4e05-896b-af58c911ff18");
			put("4", "5563abac-cd40-4e65-a669-7140b01a3d92");
			put("6", "53d07eb1-d958-4fca-bac6-c27bc3f78d1a");
			put("9", "29e46947-417d-4b7f-b60e-3fba408ed0bf");
			put("A", "e3d9120e-4007-46cc-9606-8e7b8539fcf4");
			put("C", "50253188-b105-47b2-ae84-b952a82b07a5");
		}
	};
	public CompletableFuture<MRefList_BH> TaskStatus(MRequest entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getTaskStatus())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(TASKSTATUS_UUIDS_BY_VALUE.get(entity.getTaskStatus()));
	}

}
