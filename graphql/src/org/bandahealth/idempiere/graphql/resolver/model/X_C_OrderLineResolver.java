package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ActivityDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartner_LocationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CampaignDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ChargeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ElementValueDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OrderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OrderLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectPhaseDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectTaskDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_UOMDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_AttributeSetInstanceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ShipperDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_WarehouseDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_Cost_CollectorDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_S_ResourceAssignmentDataLoader;
import org.compiere.model.MActivity;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MCampaign;
import org.compiere.model.MElementValue;
import org.compiere.model.MProject;
import org.compiere.model.MProjectPhase;
import org.compiere.model.MProjectTask;
import org.compiere.model.MResourceAssignment;
import org.compiere.model.MShipper;
import org.compiere.model.MTax;
import org.compiere.model.MUOM;
import org.dataloader.DataLoader;
import org.eevolution.model.X_PP_Cost_Collector;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_OrderLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_OrderLineResolver extends POResolver<MOrderLine_BH> implements GraphQLResolver<MOrderLine_BH> {



	/**
	 * Get Activity.
	 *
	 * @return Business Activity
	 */
	public CompletableFuture<MActivity> C_Activity(MOrderLine_BH entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MBPartner_BH> C_BPartner(MOrderLine_BH entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MBPartnerLocation> C_BPartner_Location(MOrderLine_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_Location_ID() < 1) {
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
	public CompletableFuture<MCampaign> C_Campaign(MOrderLine_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Campaign_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MCampaign> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CampaignDataLoader.DATALOADER_C_Campaign_BY_ID);
		return dataLoader.load(entity.getC_Campaign_ID());
	}


	/**
	 * Get Charge.
	 *
	 * @return Additional document charges
	 */
	public CompletableFuture<MCharge_BH> C_Charge(MOrderLine_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Charge_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MCharge_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ChargeDataLoader.DATALOADER_C_Charge_BY_ID);
		return dataLoader.load(entity.getC_Charge_ID());
	}


	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public CompletableFuture<MCurrency_BH> C_Currency(MOrderLine_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MCurrency_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.DATALOADER_C_Currency_BY_ID);
		return dataLoader.load(entity.getC_Currency_ID());
	}


	/**
	 * Get Order.
	 *
	 * @return Order
	 */
	public CompletableFuture<MOrder_BH> C_Order(MOrderLine_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Order_ID() < 1) {
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
	public CompletableFuture<MProject> C_Project(MOrderLine_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Project_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProject> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ProjectDataLoader.DATALOADER_C_Project_BY_ID);
		return dataLoader.load(entity.getC_Project_ID());
	}


	/**
	 * Get Project Phase.
	 *
	 * @return Phase of a Project
	 */
	public CompletableFuture<MProjectPhase> C_ProjectPhase(MOrderLine_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_ProjectPhase_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProjectPhase> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ProjectPhaseDataLoader.DATALOADER_C_ProjectPhase_BY_ID);
		return dataLoader.load(entity.getC_ProjectPhase_ID());
	}


	/**
	 * Get Project Task.
	 *
	 * @return Actual Project Task in a Phase
	 */
	public CompletableFuture<MProjectTask> C_ProjectTask(MOrderLine_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_ProjectTask_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProjectTask> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ProjectTaskDataLoader.DATALOADER_C_ProjectTask_BY_ID);
		return dataLoader.load(entity.getC_ProjectTask_ID());
	}


	/**
	 * Get Tax.
	 *
	 * @return Tax identifier
	 */
	public CompletableFuture<MTax> C_Tax(MOrderLine_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Tax_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MTax> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_TaxDataLoader.DATALOADER_C_Tax_BY_ID);
		return dataLoader.load(entity.getC_Tax_ID());
	}


	/**
	 * Get UOM.
	 *
	 * @return Unit of Measure
	 */
	public CompletableFuture<MUOM> C_UOM(MOrderLine_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_UOM_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MUOM> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_UOMDataLoader.DATALOADER_C_UOM_BY_ID);
		return dataLoader.load(entity.getC_UOM_ID());
	}

	public Boolean IsDescription(MOrderLine_BH entity, DataFetchingEnvironment environment) {
		return entity.isDescription();
	}


	/**
	 * Get Linked Order Line.
	 *
	 * @return This field links a sales order line to the purchase order line that is generated from it.
	 */
	public CompletableFuture<MOrderLine_BH> Link_OrderLine(MOrderLine_BH entity, DataFetchingEnvironment environment) {
		if (entity.getLink_OrderLine_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MOrderLine_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_OrderLineDataLoader.DATALOADER_C_OrderLine_BY_ID);
		return dataLoader.load(entity.getLink_OrderLine_ID());
	}


	/**
	 * Get Attribute Set Instance.
	 *
	 * @return Product Attribute Set Instance
	 */
	public CompletableFuture<MAttributeSetInstance_BH> M_AttributeSetInstance(MOrderLine_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_AttributeSetInstance_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MAttributeSetInstance_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_AttributeSetInstanceDataLoader.DATALOADER_M_AttributeSetInstance_BY_ID);
		return dataLoader.load(entity.getM_AttributeSetInstance_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(MOrderLine_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}


	/**
	 * Get Shipper.
	 *
	 * @return Method or manner of product delivery
	 */
	public CompletableFuture<MShipper> M_Shipper(MOrderLine_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_Shipper_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MShipper> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ShipperDataLoader.DATALOADER_M_Shipper_BY_ID);
		return dataLoader.load(entity.getM_Shipper_ID());
	}


	/**
	 * Get Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	public CompletableFuture<MWarehouse_BH> M_Warehouse(MOrderLine_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_Warehouse_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MWarehouse_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_WarehouseDataLoader.DATALOADER_M_Warehouse_BY_ID);
		return dataLoader.load(entity.getM_Warehouse_ID());
	}


	/**
	 * Get Manufacturing Cost Collector.
	 *
	 * @return Manufacturing Cost Collector
	 */
	public CompletableFuture<X_PP_Cost_Collector> PP_Cost_Collector(MOrderLine_BH entity, DataFetchingEnvironment environment) {
		if (entity.getPP_Cost_Collector_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_PP_Cost_Collector> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PP_Cost_CollectorDataLoader.DATALOADER_PP_Cost_Collector_BY_ID);
		return dataLoader.load(entity.getPP_Cost_Collector_ID());
	}

	public Boolean Processed(MOrderLine_BH entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}


	/**
	 * Get Referenced Order Line.
	 *
	 * @return Reference to corresponding Sales/Purchase Order
	 */
	public CompletableFuture<MOrderLine_BH> Ref_OrderLine(MOrderLine_BH entity, DataFetchingEnvironment environment) {
		if (entity.getRef_OrderLine_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MOrderLine_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_OrderLineDataLoader.DATALOADER_C_OrderLine_BY_ID);
		return dataLoader.load(entity.getRef_OrderLine_ID());
	}


	/**
	 * Get Resource Assignment.
	 *
	 * @return Resource Assignment
	 */
	public CompletableFuture<MResourceAssignment> S_ResourceAssignment(MOrderLine_BH entity, DataFetchingEnvironment environment) {
		if (entity.getS_ResourceAssignment_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MResourceAssignment> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_S_ResourceAssignmentDataLoader.DATALOADER_S_ResourceAssignment_BY_ID);
		return dataLoader.load(entity.getS_ResourceAssignment_ID());
	}


	/**
	 * Get User Element List 1.
	 *
	 * @return User defined list element #1
	 */
	public CompletableFuture<MElementValue> User1(MOrderLine_BH entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MElementValue> User2(MOrderLine_BH entity, DataFetchingEnvironment environment) {
		if (entity.getUser2_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.DATALOADER_C_ElementValue_BY_ID);
		return dataLoader.load(entity.getUser2_ID());
	}

}
