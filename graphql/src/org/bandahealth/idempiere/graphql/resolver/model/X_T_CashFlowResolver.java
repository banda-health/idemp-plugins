package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PInstanceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctSchemaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ActivityDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CampaignDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CashPlanLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ChargeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ElementValueDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OrderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MActivity;
import org.compiere.model.MCampaign;
import org.compiere.model.MCashPlanLine;
import org.compiere.model.MElementValue;
import org.compiere.model.MPInstance;
import org.compiere.model.MProject;
import org.compiere.model.X_T_CashFlow;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for T_CashFlow - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_T_CashFlowResolver extends POResolver<X_T_CashFlow> implements GraphQLResolver<X_T_CashFlow> {



	/**
	 * Get Process Instance.
	 *
	 * @return Instance of the process
	 */
	public CompletableFuture<MPInstance> AD_PInstance(X_T_CashFlow entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PInstance_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MPInstance> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PInstanceDataLoader.DATALOADER_AD_PInstance_BY_ID);
		return dataLoader.load(entity.getAD_PInstance_ID());
	}


	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public CompletableFuture<MAcctSchema> C_AcctSchema(X_T_CashFlow entity, DataFetchingEnvironment environment) {
		if (entity.getC_AcctSchema_ID() < 0) {
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
	public CompletableFuture<MActivity> C_Activity(X_T_CashFlow entity, DataFetchingEnvironment environment) {
		if (entity.getC_Activity_ID() < 0) {
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
	public CompletableFuture<MBPartner_BH> C_BPartner(X_T_CashFlow entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() < 0) {
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
	public CompletableFuture<MCampaign> C_Campaign(X_T_CashFlow entity, DataFetchingEnvironment environment) {
		if (entity.getC_Campaign_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MCampaign> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CampaignDataLoader.DATALOADER_C_Campaign_BY_ID);
		return dataLoader.load(entity.getC_Campaign_ID());
	}


	/**
	 * Get Cash Plan Line.
	 *
	 * @return Cash Plan Line
	 */
	public CompletableFuture<MCashPlanLine> C_CashPlanLine(X_T_CashFlow entity, DataFetchingEnvironment environment) {
		if (entity.getC_CashPlanLine_ID() < 0) {
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
	public CompletableFuture<MCharge_BH> C_Charge(X_T_CashFlow entity, DataFetchingEnvironment environment) {
		if (entity.getC_Charge_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MCharge_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ChargeDataLoader.DATALOADER_C_Charge_BY_ID);
		return dataLoader.load(entity.getC_Charge_ID());
	}


	/**
	 * Get Account Element.
	 *
	 * @return Account Element
	 */
	public CompletableFuture<MElementValue> C_ElementValue(X_T_CashFlow entity, DataFetchingEnvironment environment) {
		if (entity.getC_ElementValue_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.DATALOADER_C_ElementValue_BY_ID);
		return dataLoader.load(entity.getC_ElementValue_ID());
	}


	/**
	 * Get Invoice.
	 *
	 * @return Invoice Identifier
	 */
	public CompletableFuture<MInvoice_BH> C_Invoice(X_T_CashFlow entity, DataFetchingEnvironment environment) {
		if (entity.getC_Invoice_ID() < 0) {
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
	public CompletableFuture<MOrder_BH> C_Order(X_T_CashFlow entity, DataFetchingEnvironment environment) {
		if (entity.getC_Order_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MOrder_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_OrderDataLoader.DATALOADER_C_Order_BY_ID);
		return dataLoader.load(entity.getC_Order_ID());
	}


	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	public CompletableFuture<MProject> C_Project(X_T_CashFlow entity, DataFetchingEnvironment environment) {
		if (entity.getC_Project_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MProject> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ProjectDataLoader.DATALOADER_C_Project_BY_ID);
		return dataLoader.load(entity.getC_Project_ID());
	}

	public static Map<String, String> CASHFLOWSOURCE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("1", "3044d420-7c6b-45f0-a3ff-8922edb12d95"); // 1_Initial Balance
			put("2", "71d468d0-f632-402a-9c6f-b6e2b13c8321"); // 2_Plan
			put("3", "6141e6da-dd4a-4f1d-b46f-0a950380c2bf"); // 3_Commitments (Orders)
			put("4", "59c5999a-ffe1-4bd5-9659-30e1a08bcde4"); // 4_Actual Debt (Invoices)
		}
	};
	public CompletableFuture<MRefList_BH> CashFlowSource(X_T_CashFlow entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getCashFlowSource())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(CASHFLOWSOURCE_UUIDS_BY_VALUE.get(entity.getCashFlowSource()));
	}

	public static Map<String, String> CASHFLOWTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("F", "ede6e6f1-d894-4cad-88d1-891d8dc2d926"); // Financing
			put("I", "a98fda35-3822-42d3-8e4f-83880822e028"); // Investment
			put("O", "6f8d40cb-e2d8-4a37-9d5d-61c1710e2190"); // Operational
		}
	};
	public CompletableFuture<MRefList_BH> CashFlowType(X_T_CashFlow entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getCashFlowType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(CASHFLOWTYPE_UUIDS_BY_VALUE.get(entity.getCashFlowType()));
	}

	public Boolean IsSOTrx(X_T_CashFlow entity, DataFetchingEnvironment environment) {
		return entity.isSOTrx();
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(X_T_CashFlow entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}

}
