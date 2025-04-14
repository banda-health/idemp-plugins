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
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_RoleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_AssetDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ActivityDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OrderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaymentDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_InOutDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_RMADataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_CategoryDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_GroupDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_RequestDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_RequestTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_ResolutionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_StatusDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MActivity;
import org.compiere.model.MAsset;
import org.compiere.model.MGroup;
import org.compiere.model.MProject;
import org.compiere.model.MRMA;
import org.compiere.model.MRequest;
import org.compiere.model.MRequestAction;
import org.compiere.model.MRequestCategory;
import org.compiere.model.MRequestType;
import org.compiere.model.MResolution;
import org.compiere.model.MStatus;
import org.compiere.model.X_AD_Role;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for R_RequestAction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_R_RequestActionResolver extends POResolver<MRequestAction> implements GraphQLResolver<MRequestAction> {



	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	public CompletableFuture<MAsset> A_Asset(MRequestAction entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_ID() < 1) {
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
	public CompletableFuture<X_AD_Role> AD_Role(MRequestAction entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Role_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_AD_Role> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_RoleDataLoader.DATALOADER_AD_Role_BY_ID);
		return dataLoader.load(entity.getAD_Role_ID());
	}


	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(MRequestAction entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MActivity> C_Activity(MRequestAction entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MBPartner_BH> C_BPartner(MRequestAction entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Invoice.
	 *
	 * @return Invoice Identifier
	 */
	public CompletableFuture<MInvoice_BH> C_Invoice(MRequestAction entity, DataFetchingEnvironment environment) {
		if (entity.getC_Invoice_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MInvoice_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoiceDataLoader.DATALOADER_C_Invoice_BY_ID);
		return dataLoader.load(entity.getC_Invoice_ID());
	}


	/**
	 * Get Order.
	 *
	 * @return Order
	 */
	public CompletableFuture<MOrder_BH> C_Order(MRequestAction entity, DataFetchingEnvironment environment) {
		if (entity.getC_Order_ID() < 1) {
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
	public CompletableFuture<MPayment_BH> C_Payment(MRequestAction entity, DataFetchingEnvironment environment) {
		if (entity.getC_Payment_ID() < 1) {
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
	public CompletableFuture<MProject> C_Project(MRequestAction entity, DataFetchingEnvironment environment) {
		if (entity.getC_Project_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProject> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ProjectDataLoader.DATALOADER_C_Project_BY_ID);
		return dataLoader.load(entity.getC_Project_ID());
	}

	public static Map<String, String> CONFIDENTIALTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "1eb43dd1-53c0-4b5c-aae4-585c7d3fc9c2"); // Public Information
			put("C", "0f1983c1-e543-4a8f-9b8a-4a00d2a111f4"); // Partner Confidential
			put("I", "7c6def43-3d72-4c5b-93ce-dfbefd8545e4"); // Internal
			put("P", "467c826c-2a44-4f65-8026-8dc6b1d7edec"); // Private Information
		}
	};
	public CompletableFuture<MRefList_BH> ConfidentialType(MRequestAction entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getConfidentialType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(CONFIDENTIALTYPE_UUIDS_BY_VALUE.get(entity.getConfidentialType()));
	}

	public static Map<String, String> ISESCALATED_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Y", "44077eb2-6028-4a65-b270-bcc3c15ef1e5"); // Yes
			put("N", "41aaf35b-62b5-4872-b159-89257acb66db"); // No
		}
	};
	public CompletableFuture<MRefList_BH> IsEscalated(MRequestAction entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIsEscalated())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ISESCALATED_UUIDS_BY_VALUE.get(entity.getIsEscalated()));
	}

	public Boolean IsInvoiced(MRequestAction entity, DataFetchingEnvironment environment) {
		return entity.isInvoiced();
	}

	public static Map<String, String> ISSELFSERVICE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Y", "44077eb2-6028-4a65-b270-bcc3c15ef1e5"); // Yes
			put("N", "41aaf35b-62b5-4872-b159-89257acb66db"); // No
		}
	};
	public CompletableFuture<MRefList_BH> IsSelfService(MRequestAction entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIsSelfService())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ISSELFSERVICE_UUIDS_BY_VALUE.get(entity.getIsSelfService()));
	}


	/**
	 * Get Shipment/Receipt.
	 *
	 * @return Material Shipment Document
	 */
	public CompletableFuture<MInOut_BH> M_InOut(MRequestAction entity, DataFetchingEnvironment environment) {
		if (entity.getM_InOut_ID() < 1) {
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
	public CompletableFuture<MProduct_BH> M_Product(MRequestAction entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() < 1) {
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
	public CompletableFuture<MProduct_BH> M_ProductSpent(MRequestAction entity, DataFetchingEnvironment environment) {
		if (entity.getM_ProductSpent_ID() < 1) {
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
	public CompletableFuture<MRMA> M_RMA(MRequestAction entity, DataFetchingEnvironment environment) {
		if (entity.getM_RMA_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MRMA> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_RMADataLoader.DATALOADER_M_RMA_BY_ID);
		return dataLoader.load(entity.getM_RMA_ID());
	}

	public static Map<String, String> PRIORITY_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("3", "eb2a15e0-e10d-47df-9ddd-d12d39b32007"); // High
			put("5", "6ca5bed6-2fd6-4afd-b3a8-d9c91452e829"); // Medium
			put("7", "74703c05-07aa-47d6-8ee3-e884ce2f505e"); // Low
			put("1", "6d26a706-aa9f-4111-8b5b-741aa48476d9"); // Urgent
			put("9", "c349e252-ad91-483f-b53f-0e92fabbaca5"); // Minor
		}
	};
	public CompletableFuture<MRefList_BH> Priority(MRequestAction entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPriority())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(PRIORITY_UUIDS_BY_VALUE.get(entity.getPriority()));
	}

	public static Map<String, String> PRIORITYUSER_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("3", "eb2a15e0-e10d-47df-9ddd-d12d39b32007"); // High
			put("5", "6ca5bed6-2fd6-4afd-b3a8-d9c91452e829"); // Medium
			put("7", "74703c05-07aa-47d6-8ee3-e884ce2f505e"); // Low
			put("1", "6d26a706-aa9f-4111-8b5b-741aa48476d9"); // Urgent
			put("9", "c349e252-ad91-483f-b53f-0e92fabbaca5"); // Minor
		}
	};
	public CompletableFuture<MRefList_BH> PriorityUser(MRequestAction entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPriorityUser())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(PRIORITYUSER_UUIDS_BY_VALUE.get(entity.getPriorityUser()));
	}


	/**
	 * Get Category.
	 *
	 * @return Request Category
	 */
	public CompletableFuture<MRequestCategory> R_Category(MRequestAction entity, DataFetchingEnvironment environment) {
		if (entity.getR_Category_ID() < 1) {
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
	public CompletableFuture<MGroup> R_Group(MRequestAction entity, DataFetchingEnvironment environment) {
		if (entity.getR_Group_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MGroup> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_GroupDataLoader.DATALOADER_R_Group_BY_ID);
		return dataLoader.load(entity.getR_Group_ID());
	}


	/**
	 * Get Request.
	 *
	 * @return Request from a Business Partner or Prospect
	 */
	public CompletableFuture<MRequest> R_Request(MRequestAction entity, DataFetchingEnvironment environment) {
		if (entity.getR_Request_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MRequest> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_RequestDataLoader.DATALOADER_R_Request_BY_ID);
		return dataLoader.load(entity.getR_Request_ID());
	}


	/**
	 * Get Request Type.
	 *
	 * @return Type of request (e.g. Inquiry, Complaint, ..)
	 */
	public CompletableFuture<MRequestType> R_RequestType(MRequestAction entity, DataFetchingEnvironment environment) {
		if (entity.getR_RequestType_ID() < 1) {
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
	public CompletableFuture<MResolution> R_Resolution(MRequestAction entity, DataFetchingEnvironment environment) {
		if (entity.getR_Resolution_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MResolution> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_ResolutionDataLoader.DATALOADER_R_Resolution_BY_ID);
		return dataLoader.load(entity.getR_Resolution_ID());
	}


	/**
	 * Get Status.
	 *
	 * @return Request Status
	 */
	public CompletableFuture<MStatus> R_Status(MRequestAction entity, DataFetchingEnvironment environment) {
		if (entity.getR_Status_ID() < 1) {
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
	public CompletableFuture<MUser_BH> SalesRep(MRequestAction entity, DataFetchingEnvironment environment) {
		if (entity.getSalesRep_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getSalesRep_ID());
	}

	public static Map<String, String> TASKSTATUS_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("0", "8728eddd-a152-49f0-8dc3-e727b50eebfc"); //  0% Not Started
			put("D", "d12b8255-6269-4ceb-9639-120d25403f66"); // 100% Complete
			put("2", "354c2e39-18b6-4bf0-93f0-cace4a95d32e"); //  20% Started
			put("8", "13ece71e-835f-4e05-896b-af58c911ff18"); //  80% Nearly Done
			put("4", "5563abac-cd40-4e65-a669-7140b01a3d92"); //  40% Busy
			put("6", "53d07eb1-d958-4fca-bac6-c27bc3f78d1a"); //  60% Good Progress
			put("9", "29e46947-417d-4b7f-b60e-3fba408ed0bf"); //  90% Finishing
			put("A", "e3d9120e-4007-46cc-9606-8e7b8539fcf4"); //  95% Almost Done
			put("C", "50253188-b105-47b2-ae84-b952a82b07a5"); //  99% Cleaning up
		}
	};
	public CompletableFuture<MRefList_BH> TaskStatus(MRequestAction entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getTaskStatus())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(TASKSTATUS_UUIDS_BY_VALUE.get(entity.getTaskStatus()));
	}

}
