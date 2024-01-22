package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MInventoryLine_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MInOutLine;
import org.compiere.model.MOrg;
import org.compiere.model.MProductionLine;
import org.compiere.model.MTransaction;
import org.compiere.model.Query;
import org.compiere.model.X_M_TransactionAllocation;

import java.sql.ResultSet;

/**
 * Generated Model for M_TransactionAllocation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_TransactionAllocationInput extends X_M_TransactionAllocation implements I_M_TransactionAllocationInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_AttributeSetInstance;
	private ForeignEntityInput mM_InOutLine;
	private ForeignEntityInput mM_InventoryLine;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mM_ProductionLine;
	private ForeignEntityInput mM_Transaction;
	private ForeignEntityInput mOut_M_InOutLine;
	private ForeignEntityInput mOut_M_InventoryLine;
	private ForeignEntityInput mOut_M_ProductionLine;
	private ForeignEntityInput mOut_M_Transaction;
	private I_AD_Ref_ListInput mAllocationStrategyType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_TransactionAllocationInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_M_TransactionAllocation(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Allocation Strategy.
	 *
	 * @param AllocationStrategyType Allocation Strategy
	 */
	@JsonProperty("AllocationStrategyType")
	public void setAllocationStrategyTypeInput(I_AD_Ref_ListInput AllocationStrategyType) {
		this.mAllocationStrategyType = AllocationStrategyType;
		MRefList_BH foreignEntity;
		if (AllocationStrategyType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(AllocationStrategyType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAllocationStrategyType(foreignEntity.getValue());
		} else {
			this.setAllocationStrategyType(null);
		}
	}

	/**
	 * Get Allocation Strategy.
	 *
	 * @return Allocation Strategy
	 */
	@JsonProperty("AllocationStrategyType")
	public I_AD_Ref_ListInput AllocationStrategyType() {
		return mAllocationStrategyType;
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
		if (get_ID() == 0 && M_Transaction != null &&
				(foreignEntity = new Query(getCtx(), "M_Transaction", "M_Transaction_UU=?", get_TrxName())
						.setParameters(M_Transaction.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Transaction_ID(foreignEntity.get_ID());
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_TransactionAllocation_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_TransactionAllocation_UU();
	}

	/**
	 * Set Out Shipment Line.
	 *
	 * @param Out_M_InOutLine Outgoing Shipment/Receipt
	 */
	@JsonProperty("Out_M_InOutLine")
	public void setOut_M_InOutLineInput(ForeignEntityInput Out_M_InOutLine) {
		this.mOut_M_InOutLine = Out_M_InOutLine;
		MInOutLine foreignEntity;
		if (Out_M_InOutLine != null &&
				(foreignEntity = new Query(getCtx(), "M_InOutLine", "M_InOutLine_UU=?", get_TrxName())
						.setParameters(Out_M_InOutLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setOut_M_InOutLine_ID(foreignEntity.get_ID());
		} else {
			super.setOut_M_InOutLine_ID(0);
		}
	}

	/**
	 * Get Out Shipment Line.
	 *
	 * @return Outgoing Shipment/Receipt
	 */
	@JsonProperty("Out_M_InOutLine")
	public ForeignEntityInput Out_M_InOutLine() {
		return mOut_M_InOutLine;
	}

	/**
	 * Set Out Inventory Line.
	 *
	 * @param Out_M_InventoryLine Outgoing Inventory Line
	 */
	@JsonProperty("Out_M_InventoryLine")
	public void setOut_M_InventoryLineInput(ForeignEntityInput Out_M_InventoryLine) {
		this.mOut_M_InventoryLine = Out_M_InventoryLine;
		MInventoryLine_BH foreignEntity;
		if (Out_M_InventoryLine != null &&
				(foreignEntity = new Query(getCtx(), "M_InventoryLine", "M_InventoryLine_UU=?", get_TrxName())
						.setParameters(Out_M_InventoryLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setOut_M_InventoryLine_ID(foreignEntity.get_ID());
		} else {
			super.setOut_M_InventoryLine_ID(0);
		}
	}

	/**
	 * Get Out Inventory Line.
	 *
	 * @return Outgoing Inventory Line
	 */
	@JsonProperty("Out_M_InventoryLine")
	public ForeignEntityInput Out_M_InventoryLine() {
		return mOut_M_InventoryLine;
	}

	/**
	 * Set Out Production Line.
	 *
	 * @param Out_M_ProductionLine Outgoing Production Line
	 */
	@JsonProperty("Out_M_ProductionLine")
	public void setOut_M_ProductionLineInput(ForeignEntityInput Out_M_ProductionLine) {
		this.mOut_M_ProductionLine = Out_M_ProductionLine;
		MProductionLine foreignEntity;
		if (Out_M_ProductionLine != null &&
				(foreignEntity = new Query(getCtx(), "M_ProductionLine", "M_ProductionLine_UU=?", get_TrxName())
						.setParameters(Out_M_ProductionLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setOut_M_ProductionLine_ID(foreignEntity.get_ID());
		} else {
			super.setOut_M_ProductionLine_ID(0);
		}
	}

	/**
	 * Get Out Production Line.
	 *
	 * @return Outgoing Production Line
	 */
	@JsonProperty("Out_M_ProductionLine")
	public ForeignEntityInput Out_M_ProductionLine() {
		return mOut_M_ProductionLine;
	}

	/**
	 * Set Out Transaction.
	 *
	 * @param Out_M_Transaction Outgoing Transaction
	 */
	@JsonProperty("Out_M_Transaction")
	public void setOut_M_TransactionInput(ForeignEntityInput Out_M_Transaction) {
		this.mOut_M_Transaction = Out_M_Transaction;
		MTransaction foreignEntity;
		if (Out_M_Transaction != null &&
				(foreignEntity = new Query(getCtx(), "M_Transaction", "M_Transaction_UU=?", get_TrxName())
						.setParameters(Out_M_Transaction.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setOut_M_Transaction_ID(foreignEntity.get_ID());
		} else {
			super.setOut_M_Transaction_ID(0);
		}
	}

	/**
	 * Get Out Transaction.
	 *
	 * @return Outgoing Transaction
	 */
	@JsonProperty("Out_M_Transaction")
	public ForeignEntityInput Out_M_Transaction() {
		return mOut_M_Transaction;
	}
}
