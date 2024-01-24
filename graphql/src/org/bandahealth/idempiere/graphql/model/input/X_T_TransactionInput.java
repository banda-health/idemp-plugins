package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.bandahealth.idempiere.base.model.MInventoryLine_BH;
import org.bandahealth.idempiere.base.model.MInventory_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MMovementLine_BH;
import org.bandahealth.idempiere.base.model.MMovement_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MInOutLine;
import org.compiere.model.MLocator;
import org.compiere.model.MOrg;
import org.compiere.model.MPInstance;
import org.compiere.model.MProduction;
import org.compiere.model.MProductionLine;
import org.compiere.model.MProject;
import org.compiere.model.MProjectIssue;
import org.compiere.model.MTransaction;
import org.compiere.model.Query;
import org.compiere.model.X_T_Transaction;

import java.sql.ResultSet;

/**
 * Generated Model for T_Transaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_T_TransactionInput extends X_T_Transaction implements I_T_TransactionInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_PInstance;
	private ForeignEntityInput mC_Project;
	private ForeignEntityInput mC_ProjectIssue;
	private ForeignEntityInput mM_AttributeSetInstance;
	private ForeignEntityInput mM_InOut;
	private ForeignEntityInput mM_InOutLine;
	private ForeignEntityInput mM_Inventory;
	private ForeignEntityInput mM_InventoryLine;
	private ForeignEntityInput mM_Locator;
	private ForeignEntityInput mM_Movement;
	private ForeignEntityInput mM_MovementLine;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mM_Production;
	private ForeignEntityInput mM_ProductionLine;
	private ForeignEntityInput mM_Transaction;
	private ForeignEntityInput mSearch_InOut;
	private ForeignEntityInput mSearch_Invoice;
	private ForeignEntityInput mSearch_Order;
	private I_AD_Ref_ListInput mMovementType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_T_TransactionInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_T_Transaction(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Process Instance.
	 *
	 * @param AD_PInstance Instance of the process
	 */
	@JsonProperty("AD_PInstance")
	public void setAD_PInstanceInput(ForeignEntityInput AD_PInstance) {
		this.mAD_PInstance = AD_PInstance;
		MPInstance foreignEntity;
		if (AD_PInstance != null &&
				(foreignEntity = new Query(getCtx(), "AD_PInstance", "AD_PInstance_UU=?", get_TrxName())
						.setParameters(AD_PInstance.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_PInstance_ID(foreignEntity.get_ID());
		} else {
			super.setAD_PInstance_ID(0);
		}
	}

	/**
	 * Get Process Instance.
	 *
	 * @return Instance of the process
	 */
	@JsonProperty("AD_PInstance")
	public ForeignEntityInput AD_PInstance() {
		return mAD_PInstance;
	}

	/**
	 * Set Project.
	 *
	 * @param C_Project Financial Project
	 */
	@JsonProperty("C_Project")
	public void setC_ProjectInput(ForeignEntityInput C_Project) {
		this.mC_Project = C_Project;
		MProject foreignEntity;
		if (C_Project != null &&
				(foreignEntity = new Query(getCtx(), "C_Project", "C_Project_UU=?", get_TrxName())
						.setParameters(C_Project.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Project_ID(foreignEntity.get_ID());
		} else {
			super.setC_Project_ID(0);
		}
	}

	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	@JsonProperty("C_Project")
	public ForeignEntityInput C_Project() {
		return mC_Project;
	}

	/**
	 * Set Project Issue.
	 *
	 * @param C_ProjectIssue Project Issues (Material, Labor)
	 */
	@JsonProperty("C_ProjectIssue")
	public void setC_ProjectIssueInput(ForeignEntityInput C_ProjectIssue) {
		this.mC_ProjectIssue = C_ProjectIssue;
		MProjectIssue foreignEntity;
		if (C_ProjectIssue != null &&
				(foreignEntity = new Query(getCtx(), "C_ProjectIssue", "C_ProjectIssue_UU=?", get_TrxName())
						.setParameters(C_ProjectIssue.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_ProjectIssue_ID(foreignEntity.get_ID());
		} else {
			super.setC_ProjectIssue_ID(0);
		}
	}

	/**
	 * Get Project Issue.
	 *
	 * @return Project Issues (Material, Labor)
	 */
	@JsonProperty("C_ProjectIssue")
	public ForeignEntityInput C_ProjectIssue() {
		return mC_ProjectIssue;
	}

	/**
	 * Set Attribute Set Instance.
	 *
	 * @param M_AttributeSetInstance Product Attribute Set Instance
	 */
	@JsonProperty("M_AttributeSetInstance")
	public void setM_AttributeSetInstanceInput(ForeignEntityInput M_AttributeSetInstance) {
		this.mM_AttributeSetInstance = M_AttributeSetInstance;
		MAttributeSetInstance_BH foreignEntity;
		if (M_AttributeSetInstance != null &&
				(foreignEntity = new Query(getCtx(), "M_AttributeSetInstance", "M_AttributeSetInstance_UU=?", get_TrxName())
						.setParameters(M_AttributeSetInstance.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_AttributeSetInstance_ID(foreignEntity.get_ID());
		} else {
			super.setM_AttributeSetInstance_ID(0);
		}
	}

	/**
	 * Get Attribute Set Instance.
	 *
	 * @return Product Attribute Set Instance
	 */
	@JsonProperty("M_AttributeSetInstance")
	public ForeignEntityInput M_AttributeSetInstance() {
		return mM_AttributeSetInstance;
	}

	/**
	 * Set Shipment/Receipt.
	 *
	 * @param M_InOut Material Shipment Document
	 */
	@JsonProperty("M_InOut")
	public void setM_InOutInput(ForeignEntityInput M_InOut) {
		this.mM_InOut = M_InOut;
		MInOut_BH foreignEntity;
		if (M_InOut != null &&
				(foreignEntity = new Query(getCtx(), "M_InOut", "M_InOut_UU=?", get_TrxName())
						.setParameters(M_InOut.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_InOut_ID(foreignEntity.get_ID());
		} else {
			super.setM_InOut_ID(0);
		}
	}

	/**
	 * Get Shipment/Receipt.
	 *
	 * @return Material Shipment Document
	 */
	@JsonProperty("M_InOut")
	public ForeignEntityInput M_InOut() {
		return mM_InOut;
	}

	/**
	 * Set Shipment/Receipt Line.
	 *
	 * @param M_InOutLine Line on Shipment or Receipt document
	 */
	@JsonProperty("M_InOutLine")
	public void setM_InOutLineInput(ForeignEntityInput M_InOutLine) {
		this.mM_InOutLine = M_InOutLine;
		MInOutLine foreignEntity;
		if (M_InOutLine != null &&
				(foreignEntity = new Query(getCtx(), "M_InOutLine", "M_InOutLine_UU=?", get_TrxName())
						.setParameters(M_InOutLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_InOutLine_ID(foreignEntity.get_ID());
		} else {
			super.setM_InOutLine_ID(0);
		}
	}

	/**
	 * Get Shipment/Receipt Line.
	 *
	 * @return Line on Shipment or Receipt document
	 */
	@JsonProperty("M_InOutLine")
	public ForeignEntityInput M_InOutLine() {
		return mM_InOutLine;
	}

	/**
	 * Set Phys.Inventory.
	 *
	 * @param M_Inventory Parameters for a Physical Inventory
	 */
	@JsonProperty("M_Inventory")
	public void setM_InventoryInput(ForeignEntityInput M_Inventory) {
		this.mM_Inventory = M_Inventory;
		MInventory_BH foreignEntity;
		if (M_Inventory != null &&
				(foreignEntity = new Query(getCtx(), "M_Inventory", "M_Inventory_UU=?", get_TrxName())
						.setParameters(M_Inventory.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Inventory_ID(foreignEntity.get_ID());
		} else {
			super.setM_Inventory_ID(0);
		}
	}

	/**
	 * Get Phys.Inventory.
	 *
	 * @return Parameters for a Physical Inventory
	 */
	@JsonProperty("M_Inventory")
	public ForeignEntityInput M_Inventory() {
		return mM_Inventory;
	}

	/**
	 * Set Phys.Inventory Line.
	 *
	 * @param M_InventoryLine Unique line in an Inventory document
	 */
	@JsonProperty("M_InventoryLine")
	public void setM_InventoryLineInput(ForeignEntityInput M_InventoryLine) {
		this.mM_InventoryLine = M_InventoryLine;
		MInventoryLine_BH foreignEntity;
		if (M_InventoryLine != null &&
				(foreignEntity = new Query(getCtx(), "M_InventoryLine", "M_InventoryLine_UU=?", get_TrxName())
						.setParameters(M_InventoryLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_InventoryLine_ID(foreignEntity.get_ID());
		} else {
			super.setM_InventoryLine_ID(0);
		}
	}

	/**
	 * Get Phys.Inventory Line.
	 *
	 * @return Unique line in an Inventory document
	 */
	@JsonProperty("M_InventoryLine")
	public ForeignEntityInput M_InventoryLine() {
		return mM_InventoryLine;
	}

	/**
	 * Set Locator.
	 *
	 * @param M_Locator Warehouse Locator
	 */
	@JsonProperty("M_Locator")
	public void setM_LocatorInput(ForeignEntityInput M_Locator) {
		this.mM_Locator = M_Locator;
		MLocator foreignEntity;
		if (M_Locator != null &&
				(foreignEntity = new Query(getCtx(), "M_Locator", "M_Locator_UU=?", get_TrxName())
						.setParameters(M_Locator.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Locator_ID(foreignEntity.get_ID());
		} else {
			super.setM_Locator_ID(0);
		}
	}

	/**
	 * Get Locator.
	 *
	 * @return Warehouse Locator
	 */
	@JsonProperty("M_Locator")
	public ForeignEntityInput M_Locator() {
		return mM_Locator;
	}

	/**
	 * Set Inventory Move.
	 *
	 * @param M_Movement Movement of Inventory
	 */
	@JsonProperty("M_Movement")
	public void setM_MovementInput(ForeignEntityInput M_Movement) {
		this.mM_Movement = M_Movement;
		MMovement_BH foreignEntity;
		if (M_Movement != null &&
				(foreignEntity = new Query(getCtx(), "M_Movement", "M_Movement_UU=?", get_TrxName())
						.setParameters(M_Movement.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Movement_ID(foreignEntity.get_ID());
		} else {
			super.setM_Movement_ID(0);
		}
	}

	/**
	 * Get Inventory Move.
	 *
	 * @return Movement of Inventory
	 */
	@JsonProperty("M_Movement")
	public ForeignEntityInput M_Movement() {
		return mM_Movement;
	}

	/**
	 * Set Move Line.
	 *
	 * @param M_MovementLine Inventory Move document Line
	 */
	@JsonProperty("M_MovementLine")
	public void setM_MovementLineInput(ForeignEntityInput M_MovementLine) {
		this.mM_MovementLine = M_MovementLine;
		MMovementLine_BH foreignEntity;
		if (M_MovementLine != null &&
				(foreignEntity = new Query(getCtx(), "M_MovementLine", "M_MovementLine_UU=?", get_TrxName())
						.setParameters(M_MovementLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_MovementLine_ID(foreignEntity.get_ID());
		} else {
			super.setM_MovementLine_ID(0);
		}
	}

	/**
	 * Get Move Line.
	 *
	 * @return Inventory Move document Line
	 */
	@JsonProperty("M_MovementLine")
	public ForeignEntityInput M_MovementLine() {
		return mM_MovementLine;
	}

	/**
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public void setM_ProductInput(ForeignEntityInput M_Product) {
		this.mM_Product = M_Product;
		MProduct_BH foreignEntity;
		if (M_Product != null &&
				(foreignEntity = new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
						.setParameters(M_Product.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Product_ID(foreignEntity.get_ID());
		} else {
			super.setM_Product_ID(0);
		}
	}

	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public ForeignEntityInput M_Product() {
		return mM_Product;
	}

	/**
	 * Set Production.
	 *
	 * @param M_Production Plan for producing a product
	 */
	@JsonProperty("M_Production")
	public void setM_ProductionInput(ForeignEntityInput M_Production) {
		this.mM_Production = M_Production;
		MProduction foreignEntity;
		if (M_Production != null &&
				(foreignEntity = new Query(getCtx(), "M_Production", "M_Production_UU=?", get_TrxName())
						.setParameters(M_Production.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Production_ID(foreignEntity.get_ID());
		} else {
			super.setM_Production_ID(0);
		}
	}

	/**
	 * Get Production.
	 *
	 * @return Plan for producing a product
	 */
	@JsonProperty("M_Production")
	public ForeignEntityInput M_Production() {
		return mM_Production;
	}

	/**
	 * Set Production Line.
	 *
	 * @param M_ProductionLine Document Line representing a production
	 */
	@JsonProperty("M_ProductionLine")
	public void setM_ProductionLineInput(ForeignEntityInput M_ProductionLine) {
		this.mM_ProductionLine = M_ProductionLine;
		MProductionLine foreignEntity;
		if (M_ProductionLine != null &&
				(foreignEntity = new Query(getCtx(), "M_ProductionLine", "M_ProductionLine_UU=?", get_TrxName())
						.setParameters(M_ProductionLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_ProductionLine_ID(foreignEntity.get_ID());
		} else {
			super.setM_ProductionLine_ID(0);
		}
	}

	/**
	 * Get Production Line.
	 *
	 * @return Document Line representing a production
	 */
	@JsonProperty("M_ProductionLine")
	public ForeignEntityInput M_ProductionLine() {
		return mM_ProductionLine;
	}

	/**
	 * Set Inventory Transaction.
	 *
	 * @param M_Transaction Inventory Transaction
	 */
	@JsonProperty("M_Transaction")
	public void setM_TransactionInput(ForeignEntityInput M_Transaction) {
		this.mM_Transaction = M_Transaction;
		MTransaction foreignEntity;
		if (M_Transaction != null &&
				(foreignEntity = new Query(getCtx(), "M_Transaction", "M_Transaction_UU=?", get_TrxName())
						.setParameters(M_Transaction.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Transaction_ID(foreignEntity.get_ID());
		} else {
			super.setM_Transaction_ID(0);
		}
	}

	/**
	 * Get Inventory Transaction.
	 *
	 * @return Inventory Transaction
	 */
	@JsonProperty("M_Transaction")
	public ForeignEntityInput M_Transaction() {
		return mM_Transaction;
	}

	/**
	 * Set Movement Type.
	 *
	 * @param MovementType Method of moving the inventory
	 */
	@JsonProperty("MovementType")
	public void setMovementTypeInput(I_AD_Ref_ListInput MovementType) {
		this.mMovementType = MovementType;
		MRefList_BH foreignEntity;
		if (MovementType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(MovementType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setMovementType(foreignEntity.getValue());
		} else {
			this.setMovementType(null);
		}
	}

	/**
	 * Get Movement Type.
	 *
	 * @return Method of moving the inventory
	 */
	@JsonProperty("MovementType")
	public I_AD_Ref_ListInput MovementType() {
		return mMovementType;
	}

	/**
	 * Set Search Shipment/Receipt.
	 *
	 * @param Search_InOut Material Shipment Document
	 */
	@JsonProperty("Search_InOut")
	public void setSearch_InOutInput(ForeignEntityInput Search_InOut) {
		this.mSearch_InOut = Search_InOut;
		MInOutLine foreignEntity;
		if (Search_InOut != null &&
				(foreignEntity = new Query(getCtx(), "M_InOutLine", "M_InOutLine_UU=?", get_TrxName())
						.setParameters(Search_InOut.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setSearch_InOut_ID(foreignEntity.get_ID());
		} else {
			super.setSearch_InOut_ID(0);
		}
	}

	/**
	 * Get Search Shipment/Receipt.
	 *
	 * @return Material Shipment Document
	 */
	@JsonProperty("Search_InOut")
	public ForeignEntityInput Search_InOut() {
		return mSearch_InOut;
	}

	/**
	 * Set Search Invoice.
	 *
	 * @param Search_Invoice Search Invoice Identifier
	 */
	@JsonProperty("Search_Invoice")
	public void setSearch_InvoiceInput(ForeignEntityInput Search_Invoice) {
		this.mSearch_Invoice = Search_Invoice;
		MInvoice_BH foreignEntity;
		if (Search_Invoice != null &&
				(foreignEntity = new Query(getCtx(), "C_Invoice", "C_Invoice_UU=?", get_TrxName())
						.setParameters(Search_Invoice.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setSearch_Invoice_ID(foreignEntity.get_ID());
		} else {
			super.setSearch_Invoice_ID(0);
		}
	}

	/**
	 * Get Search Invoice.
	 *
	 * @return Search Invoice Identifier
	 */
	@JsonProperty("Search_Invoice")
	public ForeignEntityInput Search_Invoice() {
		return mSearch_Invoice;
	}

	/**
	 * Set Search Order.
	 *
	 * @param Search_Order Order Identifier
	 */
	@JsonProperty("Search_Order")
	public void setSearch_OrderInput(ForeignEntityInput Search_Order) {
		this.mSearch_Order = Search_Order;
		MOrder_BH foreignEntity;
		if (Search_Order != null &&
				(foreignEntity = new Query(getCtx(), "C_Order", "C_Order_UU=?", get_TrxName())
						.setParameters(Search_Order.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setSearch_Order_ID(foreignEntity.get_ID());
		} else {
			super.setSearch_Order_ID(0);
		}
	}

	/**
	 * Get Search Order.
	 *
	 * @return Order Identifier
	 */
	@JsonProperty("Search_Order")
	public ForeignEntityInput Search_Order() {
		return mSearch_Order;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setT_Transaction_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getT_Transaction_UU();
	}
}
