package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MInvoiceLine_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MActivity;
import org.compiere.model.MAsset;
import org.compiere.model.MAssetGroup;
import org.compiere.model.MCampaign;
import org.compiere.model.MElementValue;
import org.compiere.model.MInOutLine;
import org.compiere.model.MOrg;
import org.compiere.model.MProject;
import org.compiere.model.MProjectPhase;
import org.compiere.model.MProjectTask;
import org.compiere.model.MRMALine;
import org.compiere.model.MResourceAssignment;
import org.compiere.model.MTax;
import org.compiere.model.MUOM;
import org.compiere.model.Query;
import org.compiere.model.X_C_1099Box;
import org.compiere.util.Env;

/**
 * Generated Model for C_InvoiceLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_InvoiceLineInput extends MInvoiceLine_BH implements I_C_InvoiceLineInput {

	 private I_AD_OrgInput mAD_Org;
	 private I_AD_Ref_ListInput mA_CapvsExp;
	 private I_A_AssetInput mA_Asset;
	 private I_A_Asset_GroupInput mA_Asset_Group;
	 private I_C_1099BoxInput mC_1099Box;
	 private I_C_ActivityInput mC_Activity;
	 private I_C_CampaignInput mC_Campaign;
	 private I_C_ChargeInput mC_Charge;
	 private I_C_ElementValueInput mUser1;
	 private I_C_ElementValueInput mUser2;
	 private I_C_InvoiceInput mC_Invoice;
	 private I_C_OrderLineInput mC_OrderLine;
	 private I_C_ProjectInput mC_Project;
	 private I_C_ProjectPhaseInput mC_ProjectPhase;
	 private I_C_ProjectTaskInput mC_ProjectTask;
	 private I_C_TaxInput mC_Tax;
	 private I_C_UOMInput mC_UOM;
	 private I_M_AttributeSetInstanceInput mM_AttributeSetInstance;
	 private I_M_InOutLineInput mM_InOutLine;
	 private I_M_ProductInput mM_Product;
	 private I_M_RMALineInput mM_RMALine;
	 private I_S_ResourceAssignmentInput mS_ResourceAssignment;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_InvoiceLineInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Asset Group.
	 *
	 * @param A_Asset_Group Group of Assets
	 */
	@JsonProperty("A_Asset_Group")
	public void setA_Asset_GroupInput(I_A_Asset_GroupInput A_Asset_Group) {
		this.mA_Asset_Group = A_Asset_Group;
		MAssetGroup foreignEntity;
		if (A_Asset_Group != null &&
				(foreignEntity = new Query(getCtx(), MAssetGroup.Table_Name, MAssetGroup.COLUMNNAME_A_Asset_Group_UU + "=?", get_TrxName())
						.setParameters(A_Asset_Group.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Asset_Group_ID(foreignEntity.get_ID());
		} else {
			super.setA_Asset_Group_ID(0);
		}
	}

	/**
	 * Get Asset Group.
	 *
	 * @return Group of Assets
	 */
	@JsonProperty("A_Asset_Group")
	public I_A_Asset_GroupInput A_Asset_Group() {
		return mA_Asset_Group;
	}

	/**
	 * Set Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	@JsonProperty("A_Asset")
	public void setA_AssetInput(I_A_AssetInput A_Asset) {
		this.mA_Asset = A_Asset;
		MAsset foreignEntity;
		if (A_Asset != null &&
				(foreignEntity = new Query(getCtx(), MAsset.Table_Name, MAsset.COLUMNNAME_A_Asset_UU + "=?", get_TrxName())
						.setParameters(A_Asset.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Asset_ID(foreignEntity.get_ID());
		} else {
			super.setA_Asset_ID(0);
		}
	}

	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	@JsonProperty("A_Asset")
	public I_A_AssetInput A_Asset() {
		return mA_Asset;
	}

	/**
	 * Set Capital/Expense.
	 *
	 * @param A_CapvsExp Capital/Expense
	 */
	@JsonProperty("A_CapvsExp")
	public void setA_CapvsExpInput(I_AD_Ref_ListInput A_CapvsExp) {
		this.mA_CapvsExp = A_CapvsExp;
		MRefList_BH foreignEntity;
		if (A_CapvsExp != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_CapvsExp.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_CapvsExp(foreignEntity.getValue());
		} else {
			this.setA_CapvsExp(null);
		}
	}

	/**
	 * Get Capital/Expense.
	 *
	 * @return Capital/Expense
	 */
	@JsonProperty("A_CapvsExp")
	public I_AD_Ref_ListInput A_CapvsExp() {
		return mA_CapvsExp;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(I_AD_OrgInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public I_AD_OrgInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set 1099 Box.
	 *
	 * @param C_1099Box 1099 Box
	 */
	@JsonProperty("C_1099Box")
	public void setC_1099BoxInput(I_C_1099BoxInput C_1099Box) {
		this.mC_1099Box = C_1099Box;
		X_C_1099Box foreignEntity;
		if (C_1099Box != null &&
				(foreignEntity = new Query(getCtx(), X_C_1099Box.Table_Name, X_C_1099Box.COLUMNNAME_C_1099Box_UU + "=?", get_TrxName())
						.setParameters(C_1099Box.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_1099Box_ID(foreignEntity.get_ID());
		} else {
			super.setC_1099Box_ID(0);
		}
	}

	/**
	 * Get 1099 Box.
	 *
	 * @return 1099 Box
	 */
	@JsonProperty("C_1099Box")
	public I_C_1099BoxInput C_1099Box() {
		return mC_1099Box;
	}

	/**
	 * Set Activity.
	 *
	 * @param C_Activity Business Activity
	 */
	@JsonProperty("C_Activity")
	public void setC_ActivityInput(I_C_ActivityInput C_Activity) {
		this.mC_Activity = C_Activity;
		MActivity foreignEntity;
		if (C_Activity != null &&
				(foreignEntity = new Query(getCtx(), MActivity.Table_Name, MActivity.COLUMNNAME_C_Activity_UU + "=?", get_TrxName())
						.setParameters(C_Activity.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Activity_ID(foreignEntity.get_ID());
		} else {
			super.setC_Activity_ID(0);
		}
	}

	/**
	 * Get Activity.
	 *
	 * @return Business Activity
	 */
	@JsonProperty("C_Activity")
	public I_C_ActivityInput C_Activity() {
		return mC_Activity;
	}

	/**
	 * Set Campaign.
	 *
	 * @param C_Campaign Marketing Campaign
	 */
	@JsonProperty("C_Campaign")
	public void setC_CampaignInput(I_C_CampaignInput C_Campaign) {
		this.mC_Campaign = C_Campaign;
		MCampaign foreignEntity;
		if (C_Campaign != null &&
				(foreignEntity = new Query(getCtx(), MCampaign.Table_Name, MCampaign.COLUMNNAME_C_Campaign_UU + "=?", get_TrxName())
						.setParameters(C_Campaign.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Campaign_ID(foreignEntity.get_ID());
		} else {
			super.setC_Campaign_ID(0);
		}
	}

	/**
	 * Get Campaign.
	 *
	 * @return Marketing Campaign
	 */
	@JsonProperty("C_Campaign")
	public I_C_CampaignInput C_Campaign() {
		return mC_Campaign;
	}

	/**
	 * Set Charge.
	 *
	 * @param C_Charge Additional document charges
	 */
	@JsonProperty("C_Charge")
	public void setC_ChargeInput(I_C_ChargeInput C_Charge) {
		this.mC_Charge = C_Charge;
		MCharge_BH foreignEntity;
		if (C_Charge != null &&
				(foreignEntity = new Query(getCtx(), MCharge_BH.Table_Name, MCharge_BH.COLUMNNAME_C_Charge_UU + "=?", get_TrxName())
						.setParameters(C_Charge.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Charge_ID(foreignEntity.get_ID());
		} else {
			super.setC_Charge_ID(0);
		}
	}

	/**
	 * Get Charge.
	 *
	 * @return Additional document charges
	 */
	@JsonProperty("C_Charge")
	public I_C_ChargeInput C_Charge() {
		return mC_Charge;
	}

	/**
	 * Set Invoice.
	 *
	 * @param C_Invoice Invoice Identifier
	 */
	@JsonProperty("C_Invoice")
	public void setC_InvoiceInput(I_C_InvoiceInput C_Invoice) {
		this.mC_Invoice = C_Invoice;
		MInvoice_BH foreignEntity;
		if (get_ID() == 0 &&C_Invoice != null &&
				(foreignEntity = new Query(getCtx(), MInvoice_BH.Table_Name, MInvoice_BH.COLUMNNAME_C_Invoice_UU + "=?", get_TrxName())
						.setParameters(C_Invoice.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Invoice_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Invoice.
	 *
	 * @return Invoice Identifier
	 */
	@JsonProperty("C_Invoice")
	public I_C_InvoiceInput C_Invoice() {
		return mC_Invoice;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_InvoiceLine_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_InvoiceLine_UU();
	}

	/**
	 * Set Sales Order Line.
	 *
	 * @param C_OrderLine Sales Order Line
	 */
	@JsonProperty("C_OrderLine")
	public void setC_OrderLineInput(I_C_OrderLineInput C_OrderLine) {
		this.mC_OrderLine = C_OrderLine;
		MOrderLine_BH foreignEntity;
		if (get_ID() == 0 &&C_OrderLine != null &&
				(foreignEntity = new Query(getCtx(), MOrderLine_BH.Table_Name, MOrderLine_BH.COLUMNNAME_C_OrderLine_UU + "=?", get_TrxName())
						.setParameters(C_OrderLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_OrderLine_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Sales Order Line.
	 *
	 * @return Sales Order Line
	 */
	@JsonProperty("C_OrderLine")
	public I_C_OrderLineInput C_OrderLine() {
		return mC_OrderLine;
	}

	/**
	 * Set Project.
	 *
	 * @param C_Project Financial Project
	 */
	@JsonProperty("C_Project")
	public void setC_ProjectInput(I_C_ProjectInput C_Project) {
		this.mC_Project = C_Project;
		MProject foreignEntity;
		if (C_Project != null &&
				(foreignEntity = new Query(getCtx(), MProject.Table_Name, MProject.COLUMNNAME_C_Project_UU + "=?", get_TrxName())
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
	public I_C_ProjectInput C_Project() {
		return mC_Project;
	}

	/**
	 * Set Project Phase.
	 *
	 * @param C_ProjectPhase Phase of a Project
	 */
	@JsonProperty("C_ProjectPhase")
	public void setC_ProjectPhaseInput(I_C_ProjectPhaseInput C_ProjectPhase) {
		this.mC_ProjectPhase = C_ProjectPhase;
		MProjectPhase foreignEntity;
		if (get_ID() == 0 &&C_ProjectPhase != null &&
				(foreignEntity = new Query(getCtx(), MProjectPhase.Table_Name, MProjectPhase.COLUMNNAME_C_ProjectPhase_UU + "=?", get_TrxName())
						.setParameters(C_ProjectPhase.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_ProjectPhase_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Project Phase.
	 *
	 * @return Phase of a Project
	 */
	@JsonProperty("C_ProjectPhase")
	public I_C_ProjectPhaseInput C_ProjectPhase() {
		return mC_ProjectPhase;
	}

	/**
	 * Set Project Task.
	 *
	 * @param C_ProjectTask Actual Project Task in a Phase
	 */
	@JsonProperty("C_ProjectTask")
	public void setC_ProjectTaskInput(I_C_ProjectTaskInput C_ProjectTask) {
		this.mC_ProjectTask = C_ProjectTask;
		MProjectTask foreignEntity;
		if (get_ID() == 0 &&C_ProjectTask != null &&
				(foreignEntity = new Query(getCtx(), MProjectTask.Table_Name, MProjectTask.COLUMNNAME_C_ProjectTask_UU + "=?", get_TrxName())
						.setParameters(C_ProjectTask.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_ProjectTask_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Project Task.
	 *
	 * @return Actual Project Task in a Phase
	 */
	@JsonProperty("C_ProjectTask")
	public I_C_ProjectTaskInput C_ProjectTask() {
		return mC_ProjectTask;
	}

	/**
	 * Set Tax.
	 *
	 * @param C_Tax Tax identifier
	 */
	@JsonProperty("C_Tax")
	public void setC_TaxInput(I_C_TaxInput C_Tax) {
		this.mC_Tax = C_Tax;
		MTax foreignEntity;
		if (C_Tax != null &&
				(foreignEntity = new Query(getCtx(), MTax.Table_Name, MTax.COLUMNNAME_C_Tax_UU + "=?", get_TrxName())
						.setParameters(C_Tax.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Tax_ID(foreignEntity.get_ID());
		} else {
			super.setC_Tax_ID(0);
		}
	}

	/**
	 * Get Tax.
	 *
	 * @return Tax identifier
	 */
	@JsonProperty("C_Tax")
	public I_C_TaxInput C_Tax() {
		return mC_Tax;
	}

	/**
	 * Set UOM.
	 *
	 * @param C_UOM Unit of Measure
	 */
	@JsonProperty("C_UOM")
	public void setC_UOMInput(I_C_UOMInput C_UOM) {
		this.mC_UOM = C_UOM;
		MUOM foreignEntity;
		if (get_ID() == 0 &&C_UOM != null &&
				(foreignEntity = new Query(getCtx(), MUOM.Table_Name, MUOM.COLUMNNAME_C_UOM_UU + "=?", get_TrxName())
						.setParameters(C_UOM.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_UOM_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get UOM.
	 *
	 * @return Unit of Measure
	 */
	@JsonProperty("C_UOM")
	public I_C_UOMInput C_UOM() {
		return mC_UOM;
	}
	/**
	 * Set Line Amount.
	 *
	 * @param LineNetAmt Line Extended Amount (Quantity * Actual Price) without Freight and Charges
	 */

	public void setLineNetAmt(BigDecimal LineNetAmt) {
		if (get_ID() == 0) {
			super.setLineNetAmt(LineNetAmt);
		}
	}

	/**
	 * Set Attribute Set Instance.
	 *
	 * @param M_AttributeSetInstance Product Attribute Set Instance
	 */
	@JsonProperty("M_AttributeSetInstance")
	public void setM_AttributeSetInstanceInput(I_M_AttributeSetInstanceInput M_AttributeSetInstance) {
		this.mM_AttributeSetInstance = M_AttributeSetInstance;
		MAttributeSetInstance_BH foreignEntity;
		if (M_AttributeSetInstance != null &&
				(foreignEntity = new Query(getCtx(), MAttributeSetInstance_BH.Table_Name, MAttributeSetInstance_BH.COLUMNNAME_M_AttributeSetInstance_UU + "=?", get_TrxName())
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
	public I_M_AttributeSetInstanceInput M_AttributeSetInstance() {
		return mM_AttributeSetInstance;
	}

	/**
	 * Set Shipment/Receipt Line.
	 *
	 * @param M_InOutLine Line on Shipment or Receipt document
	 */
	@JsonProperty("M_InOutLine")
	public void setM_InOutLineInput(I_M_InOutLineInput M_InOutLine) {
		this.mM_InOutLine = M_InOutLine;
		MInOutLine foreignEntity;
		if (get_ID() == 0 &&M_InOutLine != null &&
				(foreignEntity = new Query(getCtx(), MInOutLine.Table_Name, MInOutLine.COLUMNNAME_M_InOutLine_UU + "=?", get_TrxName())
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
	public I_M_InOutLineInput M_InOutLine() {
		return mM_InOutLine;
	}

	/**
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public void setM_ProductInput(I_M_ProductInput M_Product) {
		this.mM_Product = M_Product;
		MProduct_BH foreignEntity;
		if (M_Product != null &&
				(foreignEntity = new Query(getCtx(), MProduct_BH.Table_Name, MProduct_BH.COLUMNNAME_M_Product_UU + "=?", get_TrxName())
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
	public I_M_ProductInput M_Product() {
		return mM_Product;
	}

	/**
	 * Set RMA Line.
	 *
	 * @param M_RMALine Return Material Authorization Line
	 */
	@JsonProperty("M_RMALine")
	public void setM_RMALineInput(I_M_RMALineInput M_RMALine) {
		this.mM_RMALine = M_RMALine;
		MRMALine foreignEntity;
		if (M_RMALine != null &&
				(foreignEntity = new Query(getCtx(), MRMALine.Table_Name, MRMALine.COLUMNNAME_M_RMALine_UU + "=?", get_TrxName())
						.setParameters(M_RMALine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_RMALine_ID(foreignEntity.get_ID());
		} else {
			super.setM_RMALine_ID(0);
		}
	}

	/**
	 * Get RMA Line.
	 *
	 * @return Return Material Authorization Line
	 */
	@JsonProperty("M_RMALine")
	public I_M_RMALineInput M_RMALine() {
		return mM_RMALine;
	}
	/**
	 * Set Unit Price.
	 *
	 * @param PriceActual Actual Price 
	 */

	public void setPriceActual(BigDecimal PriceActual) {
		if (get_ID() == 0) {
			super.setPriceActual(PriceActual);
		}
	}

	/**
	 * Set Resource Assignment.
	 *
	 * @param S_ResourceAssignment Resource Assignment
	 */
	@JsonProperty("S_ResourceAssignment")
	public void setS_ResourceAssignmentInput(I_S_ResourceAssignmentInput S_ResourceAssignment) {
		this.mS_ResourceAssignment = S_ResourceAssignment;
		MResourceAssignment foreignEntity;
		if (get_ID() == 0 &&S_ResourceAssignment != null &&
				(foreignEntity = new Query(getCtx(), MResourceAssignment.Table_Name, MResourceAssignment.COLUMNNAME_S_ResourceAssignment_UU + "=?", get_TrxName())
						.setParameters(S_ResourceAssignment.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setS_ResourceAssignment_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Resource Assignment.
	 *
	 * @return Resource Assignment
	 */
	@JsonProperty("S_ResourceAssignment")
	public I_S_ResourceAssignmentInput S_ResourceAssignment() {
		return mS_ResourceAssignment;
	}

	/**
	 * Set User Element List 1.
	 *
	 * @param User1 User defined list element #1
	 */
	@JsonProperty("User1")
	public void setUser1Input(I_C_ElementValueInput User1) {
		this.mUser1 = User1;
		MElementValue foreignEntity;
		if (User1 != null &&
				(foreignEntity = new Query(getCtx(), MElementValue.Table_Name, MElementValue.COLUMNNAME_C_ElementValue_UU + "=?", get_TrxName())
						.setParameters(User1.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setUser1_ID(foreignEntity.get_ID());
		} else {
			super.setUser1_ID(0);
		}
	}

	/**
	 * Get User Element List 1.
	 *
	 * @return User defined list element #1
	 */
	@JsonProperty("User1")
	public I_C_ElementValueInput User1() {
		return mUser1;
	}

	/**
	 * Set User Element List 2.
	 *
	 * @param User2 User defined list element #2
	 */
	@JsonProperty("User2")
	public void setUser2Input(I_C_ElementValueInput User2) {
		this.mUser2 = User2;
		MElementValue foreignEntity;
		if (User2 != null &&
				(foreignEntity = new Query(getCtx(), MElementValue.Table_Name, MElementValue.COLUMNNAME_C_ElementValue_UU + "=?", get_TrxName())
						.setParameters(User2.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setUser2_ID(foreignEntity.get_ID());
		} else {
			super.setUser2_ID(0);
		}
	}

	/**
	 * Get User Element List 2.
	 *
	 * @return User defined list element #2
	 */
	@JsonProperty("User2")
	public I_C_ElementValueInput User2() {
		return mUser2;
	}
}
