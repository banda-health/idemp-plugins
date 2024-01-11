package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MInventoryLine_BH;
import org.bandahealth.idempiere.base.model.MInvoiceLine_BH;
import org.bandahealth.idempiere.base.model.MMovementLine_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctSchemaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OrderLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectIssueDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_AttributeSetInstanceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_CostElementDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_InOutLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_InventoryLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_MatchInvDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_MovementLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductionLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_Cost_CollectorDataLoader;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MCostDetail;
import org.compiere.model.MCostElement;
import org.compiere.model.MInOutLine;
import org.compiere.model.MMatchInv;
import org.compiere.model.MProductionLine;
import org.compiere.model.MProjectIssue;
import org.dataloader.DataLoader;
import org.eevolution.model.X_PP_Cost_Collector;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_CostDetail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_CostDetailResolver extends POResolver<MCostDetail> implements GraphQLResolver<MCostDetail> {



	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public CompletableFuture<MAcctSchema> C_AcctSchema(MCostDetail entity, DataFetchingEnvironment environment) {
		if (entity.getC_AcctSchema_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAcctSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_AcctSchemaDataLoader.C_AcctSchema_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_AcctSchema_ID());
	}


	/**
	 * Get Invoice Line.
	 *
	 * @return Invoice Detail Line
	 */
	public CompletableFuture<MInvoiceLine_BH> C_InvoiceLine(MCostDetail entity, DataFetchingEnvironment environment) {
		if (entity.getC_InvoiceLine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInvoiceLine_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoiceLineDataLoader.C_InvoiceLine_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_InvoiceLine_ID());
	}


	/**
	 * Get Sales Order Line.
	 *
	 * @return Sales Order Line
	 */
	public CompletableFuture<MOrderLine_BH> C_OrderLine(MCostDetail entity, DataFetchingEnvironment environment) {
		if (entity.getC_OrderLine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MOrderLine_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_OrderLineDataLoader.C_OrderLine_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_OrderLine_ID());
	}


	/**
	 * Get Project Issue.
	 *
	 * @return Project Issues (Material, Labor)
	 */
	public CompletableFuture<MProjectIssue> C_ProjectIssue(MCostDetail entity, DataFetchingEnvironment environment) {
		if (entity.getC_ProjectIssue_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProjectIssue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ProjectIssueDataLoader.C_ProjectIssue_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_ProjectIssue_ID());
	}

	public Boolean IsSOTrx(MCostDetail entity, DataFetchingEnvironment environment) {
		return entity.isSOTrx();
	}


	/**
	 * Get Attribute Set Instance.
	 *
	 * @return Product Attribute Set Instance
	 */
	public CompletableFuture<MAttributeSetInstance_BH> M_AttributeSetInstance(MCostDetail entity, DataFetchingEnvironment environment) {
		if (entity.getM_AttributeSetInstance_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAttributeSetInstance_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_AttributeSetInstanceDataLoader.M_AttributeSetInstance_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_AttributeSetInstance_ID());
	}


	/**
	 * Get Cost Element.
	 *
	 * @return Product Cost Element
	 */
	public CompletableFuture<MCostElement> M_CostElement(MCostDetail entity, DataFetchingEnvironment environment) {
		if (entity.getM_CostElement_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCostElement> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_CostElementDataLoader.M_CostElement_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_CostElement_ID());
	}


	/**
	 * Get Shipment/Receipt Line.
	 *
	 * @return Line on Shipment or Receipt document
	 */
	public CompletableFuture<MInOutLine> M_InOutLine(MCostDetail entity, DataFetchingEnvironment environment) {
		if (entity.getM_InOutLine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInOutLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_InOutLineDataLoader.M_InOutLine_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_InOutLine_ID());
	}


	/**
	 * Get Phys.Inventory Line.
	 *
	 * @return Unique line in an Inventory document
	 */
	public CompletableFuture<MInventoryLine_BH> M_InventoryLine(MCostDetail entity, DataFetchingEnvironment environment) {
		if (entity.getM_InventoryLine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInventoryLine_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_InventoryLineDataLoader.M_InventoryLine_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_InventoryLine_ID());
	}


	/**
	 * Get Match Invoice.
	 *
	 * @return Match Shipment/Receipt to Invoice
	 */
	public CompletableFuture<MMatchInv> M_MatchInv(MCostDetail entity, DataFetchingEnvironment environment) {
		if (entity.getM_MatchInv_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MMatchInv> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_MatchInvDataLoader.M_MatchInv_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_MatchInv_ID());
	}


	/**
	 * Get Move Line.
	 *
	 * @return Inventory Move document Line
	 */
	public CompletableFuture<MMovementLine_BH> M_MovementLine(MCostDetail entity, DataFetchingEnvironment environment) {
		if (entity.getM_MovementLine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MMovementLine_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_MovementLineDataLoader.M_MovementLine_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_MovementLine_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(MCostDetail entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.M_Product_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Product_ID());
	}


	/**
	 * Get Production Line.
	 *
	 * @return Document Line representing a production
	 */
	public CompletableFuture<MProductionLine> M_ProductionLine(MCostDetail entity, DataFetchingEnvironment environment) {
		if (entity.getM_ProductionLine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProductionLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductionLineDataLoader.M_ProductionLine_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_ProductionLine_ID());
	}


	/**
	 * Get Manufacturing Cost Collector.
	 *
	 * @return Manufacturing Cost Collector
	 */
	public CompletableFuture<X_PP_Cost_Collector> PP_Cost_Collector(MCostDetail entity, DataFetchingEnvironment environment) {
		if (entity.getPP_Cost_Collector_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_PP_Cost_Collector> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PP_Cost_CollectorDataLoader.PP_Cost_Collector_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getPP_Cost_Collector_ID());
	}

	public Boolean Processed(MCostDetail entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

}
