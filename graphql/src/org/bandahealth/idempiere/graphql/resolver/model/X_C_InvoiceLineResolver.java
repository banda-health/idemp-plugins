package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_AssetDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Asset_GroupDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_1099BoxDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ActivityDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CampaignDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ChargeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ElementValueDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OrderLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectPhaseDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectTaskDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_UOMDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_AttributeSetInstanceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_InOutLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_RMALineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_S_ResourceAssignmentDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MActivity;
import org.compiere.model.MAsset;
import org.compiere.model.MAssetGroup;
import org.compiere.model.MCampaign;
import org.compiere.model.MElementValue;
import org.compiere.model.MInOutLine;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MProject;
import org.compiere.model.MProjectPhase;
import org.compiere.model.MProjectTask;
import org.compiere.model.MRMALine;
import org.compiere.model.MRefList;
import org.compiere.model.MResourceAssignment;
import org.compiere.model.MTax;
import org.compiere.model.MUOM;
import org.compiere.model.X_C_1099Box;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_InvoiceLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_InvoiceLineResolver extends POResolver<MInvoiceLine> implements GraphQLResolver<MInvoiceLine> {



	/**
	 * Get Asset Group.
	 *
	 * @return Group of Assets
	 */
	public CompletableFuture<MAssetGroup> A_Asset_Group(MInvoiceLine entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_Group_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAssetGroup> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_Asset_GroupDataLoader.A_Asset_Group_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getA_Asset_Group_ID());
	}


	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	public CompletableFuture<MAsset> A_Asset(MInvoiceLine entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAsset> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_AssetDataLoader.A_Asset_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getA_Asset_ID());
	}

	static Map<String, String> A_CAPVSEXP_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MInvoiceLine.A_CAPVSEXP_Capital, "f494c22f-2ce5-471d-aabb-887f528c60da");
			put(MInvoiceLine.A_CAPVSEXP_Expense, "4a84ac91-9720-40a2-8529-6a139dabb96a");
		}
	};
	public CompletableFuture<MRefList> A_CapvsExp_RL(MInvoiceLine entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getA_CapvsExp())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(A_CAPVSEXP_UUIDS_BY_VALUE.get(entity.getA_CapvsExp()));
	}


	/**
	 * Get 1099 Box.
	 *
	 * @return 1099 Box
	 */
	public CompletableFuture<X_C_1099Box> C_1099Box(MInvoiceLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_1099Box_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_C_1099Box> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_1099BoxDataLoader.C_1099Box_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_1099Box_ID());
	}


	/**
	 * Get Activity.
	 *
	 * @return Business Activity
	 */
	public CompletableFuture<MActivity> C_Activity(MInvoiceLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_Activity_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MActivity> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ActivityDataLoader.C_Activity_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Activity_ID());
	}


	/**
	 * Get Campaign.
	 *
	 * @return Marketing Campaign
	 */
	public CompletableFuture<MCampaign> C_Campaign(MInvoiceLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_Campaign_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCampaign> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CampaignDataLoader.C_Campaign_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Campaign_ID());
	}


	/**
	 * Get Charge.
	 *
	 * @return Additional document charges
	 */
	public CompletableFuture<MCharge_BH> C_Charge(MInvoiceLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_Charge_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCharge_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ChargeDataLoader.C_Charge_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Charge_ID());
	}


	/**
	 * Get Invoice.
	 *
	 * @return Invoice Identifier
	 */
	public CompletableFuture<MInvoice_BH> C_Invoice(MInvoiceLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_Invoice_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInvoice_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoiceDataLoader.C_Invoice_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Invoice_ID());
	}


	/**
	 * Get Sales Order Line.
	 *
	 * @return Sales Order Line
	 */
	public CompletableFuture<MOrderLine_BH> C_OrderLine(MInvoiceLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_OrderLine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MOrderLine_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_OrderLineDataLoader.C_OrderLine_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_OrderLine_ID());
	}


	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	public CompletableFuture<MProject> C_Project(MInvoiceLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_Project_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProject> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ProjectDataLoader.C_Project_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Project_ID());
	}


	/**
	 * Get Project Phase.
	 *
	 * @return Phase of a Project
	 */
	public CompletableFuture<MProjectPhase> C_ProjectPhase(MInvoiceLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_ProjectPhase_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProjectPhase> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ProjectPhaseDataLoader.C_ProjectPhase_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_ProjectPhase_ID());
	}


	/**
	 * Get Project Task.
	 *
	 * @return Actual Project Task in a Phase
	 */
	public CompletableFuture<MProjectTask> C_ProjectTask(MInvoiceLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_ProjectTask_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProjectTask> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ProjectTaskDataLoader.C_ProjectTask_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_ProjectTask_ID());
	}


	/**
	 * Get Tax.
	 *
	 * @return Tax identifier
	 */
	public CompletableFuture<MTax> C_Tax(MInvoiceLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_Tax_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTax> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_TaxDataLoader.C_Tax_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Tax_ID());
	}


	/**
	 * Get UOM.
	 *
	 * @return Unit of Measure
	 */
	public CompletableFuture<MUOM> C_UOM(MInvoiceLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_UOM_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUOM> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_UOMDataLoader.C_UOM_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_UOM_ID());
	}


	/**
	 * Get Attribute Set Instance.
	 *
	 * @return Product Attribute Set Instance
	 */
	public CompletableFuture<MAttributeSetInstance_BH> M_AttributeSetInstance(MInvoiceLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_AttributeSetInstance_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAttributeSetInstance_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_AttributeSetInstanceDataLoader.M_AttributeSetInstance_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_AttributeSetInstance_ID());
	}


	/**
	 * Get Shipment/Receipt Line.
	 *
	 * @return Line on Shipment or Receipt document
	 */
	public CompletableFuture<MInOutLine> M_InOutLine(MInvoiceLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_InOutLine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInOutLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_InOutLineDataLoader.M_InOutLine_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_InOutLine_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(MInvoiceLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.M_Product_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Product_ID());
	}


	/**
	 * Get RMA Line.
	 *
	 * @return Return Material Authorization Line
	 */
	public CompletableFuture<MRMALine> M_RMALine(MInvoiceLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_RMALine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRMALine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_RMALineDataLoader.M_RMALine_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_RMALine_ID());
	}


	/**
	 * Get Resource Assignment.
	 *
	 * @return Resource Assignment
	 */
	public CompletableFuture<MResourceAssignment> S_ResourceAssignment(MInvoiceLine entity, DataFetchingEnvironment environment) {
		if (entity.getS_ResourceAssignment_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MResourceAssignment> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_S_ResourceAssignmentDataLoader.S_ResourceAssignment_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getS_ResourceAssignment_ID());
	}


	/**
	 * Get User Element List 1.
	 *
	 * @return User defined list element #1
	 */
	public CompletableFuture<MElementValue> User1(MInvoiceLine entity, DataFetchingEnvironment environment) {
		if (entity.getUser1_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.C_ElementValue_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getUser1_ID());
	}


	/**
	 * Get User Element List 2.
	 *
	 * @return User defined list element #2
	 */
	public CompletableFuture<MElementValue> User2(MInvoiceLine entity, DataFetchingEnvironment environment) {
		if (entity.getUser2_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.C_ElementValue_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getUser2_ID());
	}

}
