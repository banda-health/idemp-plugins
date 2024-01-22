package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MInventoryLine_BH;
import org.bandahealth.idempiere.base.model.MMovementLine_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MInOutLine;
import org.compiere.model.MLocator;
import org.compiere.model.MOrg;
import org.compiere.model.MProductionLine;
import org.compiere.model.MProjectIssue;
import org.compiere.model.MTransaction;
import org.compiere.model.Query;
import org.eevolution.model.X_PP_Cost_Collector;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * Generated Model for M_Transaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_TransactionInput extends MTransaction implements I_M_TransactionInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_ProjectIssue;
	private ForeignEntityInput mM_AttributeSetInstance;
	private ForeignEntityInput mM_InOutLine;
	private ForeignEntityInput mM_InventoryLine;
	private ForeignEntityInput mM_Locator;
	private ForeignEntityInput mM_MovementLine;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mM_ProductionLine;
	private ForeignEntityInput mPP_Cost_Collector;
	private I_AD_Ref_ListInput mMovementType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_TransactionInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MTransaction(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Project Issue.
	 *
	 * @param C_ProjectIssue Project Issues (Material, Labor)
	 */
	@JsonProperty("C_ProjectIssue")
	public void setC_ProjectIssueInput(ForeignEntityInput C_ProjectIssue) {
		this.mC_ProjectIssue = C_ProjectIssue;
		MProjectIssue foreignEntity;
		if (get_ID() == 0 && C_ProjectIssue != null &&
				(foreignEntity = new Query(getCtx(), "C_ProjectIssue", "C_ProjectIssue_UU=?", get_TrxName())
						.setParameters(C_ProjectIssue.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_ProjectIssue_ID(foreignEntity.get_ID());
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
		if (get_ID() == 0 && M_AttributeSetInstance != null &&
				(foreignEntity = new Query(getCtx(), "M_AttributeSetInstance", "M_AttributeSetInstance_UU=?", get_TrxName())
						.setParameters(M_AttributeSetInstance.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_AttributeSetInstance_ID(foreignEntity.get_ID());
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
		if (get_ID() == 0 && M_InOutLine != null &&
				(foreignEntity = new Query(getCtx(), "M_InOutLine", "M_InOutLine_UU=?", get_TrxName())
						.setParameters(M_InOutLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_InOutLine_ID(foreignEntity.get_ID());
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
		if (get_ID() == 0 && M_InventoryLine != null &&
				(foreignEntity = new Query(getCtx(), "M_InventoryLine", "M_InventoryLine_UU=?", get_TrxName())
						.setParameters(M_InventoryLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_InventoryLine_ID(foreignEntity.get_ID());
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
		if (get_ID() == 0 && M_Locator != null &&
				(foreignEntity = new Query(getCtx(), "M_Locator", "M_Locator_UU=?", get_TrxName())
						.setParameters(M_Locator.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Locator_ID(foreignEntity.get_ID());
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
	 * Set Move Line.
	 *
	 * @param M_MovementLine Inventory Move document Line
	 */
	@JsonProperty("M_MovementLine")
	public void setM_MovementLineInput(ForeignEntityInput M_MovementLine) {
		this.mM_MovementLine = M_MovementLine;
		MMovementLine_BH foreignEntity;
		if (get_ID() == 0 && M_MovementLine != null &&
				(foreignEntity = new Query(getCtx(), "M_MovementLine", "M_MovementLine_UU=?", get_TrxName())
						.setParameters(M_MovementLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_MovementLine_ID(foreignEntity.get_ID());
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
		if (get_ID() == 0 && M_Product != null &&
				(foreignEntity = new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
						.setParameters(M_Product.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Product_ID(foreignEntity.get_ID());
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
		if (get_ID() == 0 && M_ProductionLine != null &&
				(foreignEntity = new Query(getCtx(), "M_ProductionLine", "M_ProductionLine_UU=?", get_TrxName())
						.setParameters(M_ProductionLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_ProductionLine_ID(foreignEntity.get_ID());
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
	 * @param M_Transaction_ID Inventory Transaction
	 */

	public void setM_Transaction_ID(int M_Transaction_ID) {
		if (get_ID() == 0) {
			super.setM_Transaction_ID(M_Transaction_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_Transaction_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_Transaction_UU();
	}
	/**
	 * Set Movement Date.
	 *
	 * @param MovementDate Date a product was moved in or out of inventory
	 */

	public void setMovementDate(Timestamp MovementDate) {
		if (get_ID() == 0) {
			super.setMovementDate(MovementDate);
		}
	}
	/**
	 * Set Movement Quantity.
	 *
	 * @param MovementQty Quantity of a product moved.
	 */

	public void setMovementQty(BigDecimal MovementQty) {
		if (get_ID() == 0) {
			super.setMovementQty(MovementQty);
		}
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
		if (get_ID() == 0 &&MovementType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(MovementType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setMovementType(foreignEntity.getValue());
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
	 * Set Manufacturing Cost Collector.
	 *
	 * @param PP_Cost_Collector Manufacturing Cost Collector
	 */
	@JsonProperty("PP_Cost_Collector")
	public void setPP_Cost_CollectorInput(ForeignEntityInput PP_Cost_Collector) {
		this.mPP_Cost_Collector = PP_Cost_Collector;
		X_PP_Cost_Collector foreignEntity;
		if (PP_Cost_Collector != null &&
				(foreignEntity = new Query(getCtx(), "PP_Cost_Collector", "PP_Cost_Collector_UU=?", get_TrxName())
						.setParameters(PP_Cost_Collector.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPP_Cost_Collector_ID(foreignEntity.get_ID());
		} else {
			super.setPP_Cost_Collector_ID(0);
		}
	}

	/**
	 * Get Manufacturing Cost Collector.
	 *
	 * @return Manufacturing Cost Collector
	 */
	@JsonProperty("PP_Cost_Collector")
	public ForeignEntityInput PP_Cost_Collector() {
		return mPP_Cost_Collector;
	}
}
