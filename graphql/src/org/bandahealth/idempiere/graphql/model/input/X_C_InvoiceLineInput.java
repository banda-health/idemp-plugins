package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MActivity;
import org.compiere.model.MAsset;
import org.compiere.model.MAssetGroup;
import org.compiere.model.MCampaign;
import org.compiere.model.MElementValue;
import org.compiere.model.MInOutLine;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MOrg;
import org.compiere.model.MProject;
import org.compiere.model.MProjectPhase;
import org.compiere.model.MProjectTask;
import org.compiere.model.MRMALine;
import org.compiere.model.MRefList;
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
public class X_C_InvoiceLineInput extends MInvoiceLine implements I_C_InvoiceLineInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput A_CapvsExp_RL;
	 private I_A_AssetInput A_Asset;
	 private I_A_Asset_GroupInput A_Asset_Group;
	 private I_C_1099BoxInput C_1099Box;
	 private I_C_ActivityInput C_Activity;
	 private I_C_CampaignInput C_Campaign;
	 private I_C_ChargeInput C_Charge;
	 private I_C_ElementValueInput User1;
	 private I_C_ElementValueInput User2;
	 private I_C_InvoiceInput C_Invoice;
	 private I_C_OrderLineInput C_OrderLine;
	 private I_C_ProjectInput C_Project;
	 private I_C_ProjectPhaseInput C_ProjectPhase;
	 private I_C_ProjectTaskInput C_ProjectTask;
	 private I_C_TaxInput C_Tax;
	 private I_C_UOMInput C_UOM;
	 private I_M_AttributeSetInstanceInput M_AttributeSetInstance;
	 private I_M_InOutLineInput M_InOutLine;
	 private I_M_ProductInput M_Product;
	 private I_M_RMALineInput M_RMALine;
	 private I_S_ResourceAssignmentInput S_ResourceAssignment;

	/**
	 * Standard constructor
	 */
	public X_C_InvoiceLineInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Asset Group.
	 *
	 * @param A_Asset_Group Group of Assets
	 */
	public void setA_Asset_Group(I_A_Asset_GroupInput A_Asset_Group) {
		this.A_Asset_Group = A_Asset_Group;
		MAssetGroup foreignEntity;
		if (A_Asset_Group != null &&
				(foreignEntity = new Query(getCtx(), MAssetGroup.Table_Name, MAssetGroup.COLUMNNAME_A_Asset_Group_UU + "=?", get_TrxName())
						.setParameters(A_Asset_Group.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Asset_Group_ID(foreignEntity.get_ID());
		} else {
			this.setA_Asset_Group_ID(0);
		}
	}

	/**
	 * Get Asset Group.
	 *
	 * @return Group of Assets
	 */
	public I_A_Asset_GroupInput getA_Asset_Group() {
		return A_Asset_Group;
	}

	/**
	 * Set Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	public void setA_Asset(I_A_AssetInput A_Asset) {
		this.A_Asset = A_Asset;
		MAsset foreignEntity;
		if (A_Asset != null &&
				(foreignEntity = new Query(getCtx(), MAsset.Table_Name, MAsset.COLUMNNAME_A_Asset_UU + "=?", get_TrxName())
						.setParameters(A_Asset.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Asset_ID(foreignEntity.get_ID());
		} else {
			this.setA_Asset_ID(0);
		}
	}

	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	public I_A_AssetInput getA_Asset() {
		return A_Asset;
	}

	/**
	 * Set Capital/Expense.
	 *
	 * @param A_CapvsExp_RL Capital/Expense
	 */
	public void setA_CapvsExp_RL(I_AD_Ref_ListInput A_CapvsExp_RL) {
		this.A_CapvsExp_RL = A_CapvsExp_RL;
		MRefList foreignEntity;
		if (A_CapvsExp_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_CapvsExp_RL.getID())
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
	public I_AD_Ref_ListInput getA_CapvsExp_RL() {
		return A_CapvsExp_RL;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}

	/**
	 * Set 1099 Box.
	 *
	 * @param C_1099Box 1099 Box
	 */
	public void setC_1099Box(I_C_1099BoxInput C_1099Box) {
		this.C_1099Box = C_1099Box;
		X_C_1099Box foreignEntity;
		if (C_1099Box != null &&
				(foreignEntity = new Query(getCtx(), X_C_1099Box.Table_Name, X_C_1099Box.COLUMNNAME_C_1099Box_UU + "=?", get_TrxName())
						.setParameters(C_1099Box.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_1099Box_ID(foreignEntity.get_ID());
		} else {
			this.setC_1099Box_ID(0);
		}
	}

	/**
	 * Get 1099 Box.
	 *
	 * @return 1099 Box
	 */
	public I_C_1099BoxInput getC_1099Box() {
		return C_1099Box;
	}

	/**
	 * Set Activity.
	 *
	 * @param C_Activity Business Activity
	 */
	public void setC_Activity(I_C_ActivityInput C_Activity) {
		this.C_Activity = C_Activity;
		MActivity foreignEntity;
		if (C_Activity != null &&
				(foreignEntity = new Query(getCtx(), MActivity.Table_Name, MActivity.COLUMNNAME_C_Activity_UU + "=?", get_TrxName())
						.setParameters(C_Activity.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Activity_ID(foreignEntity.get_ID());
		} else {
			this.setC_Activity_ID(0);
		}
	}

	/**
	 * Get Activity.
	 *
	 * @return Business Activity
	 */
	public I_C_ActivityInput getC_Activity() {
		return C_Activity;
	}

	/**
	 * Set Campaign.
	 *
	 * @param C_Campaign Marketing Campaign
	 */
	public void setC_Campaign(I_C_CampaignInput C_Campaign) {
		this.C_Campaign = C_Campaign;
		MCampaign foreignEntity;
		if (C_Campaign != null &&
				(foreignEntity = new Query(getCtx(), MCampaign.Table_Name, MCampaign.COLUMNNAME_C_Campaign_UU + "=?", get_TrxName())
						.setParameters(C_Campaign.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Campaign_ID(foreignEntity.get_ID());
		} else {
			this.setC_Campaign_ID(0);
		}
	}

	/**
	 * Get Campaign.
	 *
	 * @return Marketing Campaign
	 */
	public I_C_CampaignInput getC_Campaign() {
		return C_Campaign;
	}

	/**
	 * Set Charge.
	 *
	 * @param C_Charge Additional document charges
	 */
	public void setC_Charge(I_C_ChargeInput C_Charge) {
		this.C_Charge = C_Charge;
		MCharge_BH foreignEntity;
		if (C_Charge != null &&
				(foreignEntity = new Query(getCtx(), MCharge_BH.Table_Name, MCharge_BH.COLUMNNAME_C_Charge_UU + "=?", get_TrxName())
						.setParameters(C_Charge.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Charge_ID(foreignEntity.get_ID());
		} else {
			this.setC_Charge_ID(0);
		}
	}

	/**
	 * Get Charge.
	 *
	 * @return Additional document charges
	 */
	public I_C_ChargeInput getC_Charge() {
		return C_Charge;
	}

	/**
	 * Set Invoice.
	 *
	 * @param C_Invoice Invoice Identifier
	 */
	public void setC_Invoice(I_C_InvoiceInput C_Invoice) {
		this.C_Invoice = C_Invoice;
		MInvoice_BH foreignEntity;
		if (get_ID() == 0 &&C_Invoice != null &&
				(foreignEntity = new Query(getCtx(), MInvoice_BH.Table_Name, MInvoice_BH.COLUMNNAME_C_Invoice_UU + "=?", get_TrxName())
						.setParameters(C_Invoice.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Invoice_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Invoice.
	 *
	 * @return Invoice Identifier
	 */
	public I_C_InvoiceInput getC_Invoice() {
		return C_Invoice;
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
	public void setC_OrderLine(I_C_OrderLineInput C_OrderLine) {
		this.C_OrderLine = C_OrderLine;
		MOrderLine_BH foreignEntity;
		if (get_ID() == 0 &&C_OrderLine != null &&
				(foreignEntity = new Query(getCtx(), MOrderLine_BH.Table_Name, MOrderLine_BH.COLUMNNAME_C_OrderLine_UU + "=?", get_TrxName())
						.setParameters(C_OrderLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_OrderLine_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Sales Order Line.
	 *
	 * @return Sales Order Line
	 */
	public I_C_OrderLineInput getC_OrderLine() {
		return C_OrderLine;
	}

	/**
	 * Set Project.
	 *
	 * @param C_Project Financial Project
	 */
	public void setC_Project(I_C_ProjectInput C_Project) {
		this.C_Project = C_Project;
		MProject foreignEntity;
		if (C_Project != null &&
				(foreignEntity = new Query(getCtx(), MProject.Table_Name, MProject.COLUMNNAME_C_Project_UU + "=?", get_TrxName())
						.setParameters(C_Project.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Project_ID(foreignEntity.get_ID());
		} else {
			this.setC_Project_ID(0);
		}
	}

	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	public I_C_ProjectInput getC_Project() {
		return C_Project;
	}

	/**
	 * Set Project Phase.
	 *
	 * @param C_ProjectPhase Phase of a Project
	 */
	public void setC_ProjectPhase(I_C_ProjectPhaseInput C_ProjectPhase) {
		this.C_ProjectPhase = C_ProjectPhase;
		MProjectPhase foreignEntity;
		if (get_ID() == 0 &&C_ProjectPhase != null &&
				(foreignEntity = new Query(getCtx(), MProjectPhase.Table_Name, MProjectPhase.COLUMNNAME_C_ProjectPhase_UU + "=?", get_TrxName())
						.setParameters(C_ProjectPhase.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_ProjectPhase_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Project Phase.
	 *
	 * @return Phase of a Project
	 */
	public I_C_ProjectPhaseInput getC_ProjectPhase() {
		return C_ProjectPhase;
	}

	/**
	 * Set Project Task.
	 *
	 * @param C_ProjectTask Actual Project Task in a Phase
	 */
	public void setC_ProjectTask(I_C_ProjectTaskInput C_ProjectTask) {
		this.C_ProjectTask = C_ProjectTask;
		MProjectTask foreignEntity;
		if (get_ID() == 0 &&C_ProjectTask != null &&
				(foreignEntity = new Query(getCtx(), MProjectTask.Table_Name, MProjectTask.COLUMNNAME_C_ProjectTask_UU + "=?", get_TrxName())
						.setParameters(C_ProjectTask.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_ProjectTask_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Project Task.
	 *
	 * @return Actual Project Task in a Phase
	 */
	public I_C_ProjectTaskInput getC_ProjectTask() {
		return C_ProjectTask;
	}

	/**
	 * Set Tax.
	 *
	 * @param C_Tax Tax identifier
	 */
	public void setC_Tax(I_C_TaxInput C_Tax) {
		this.C_Tax = C_Tax;
		MTax foreignEntity;
		if (C_Tax != null &&
				(foreignEntity = new Query(getCtx(), MTax.Table_Name, MTax.COLUMNNAME_C_Tax_UU + "=?", get_TrxName())
						.setParameters(C_Tax.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Tax_ID(foreignEntity.get_ID());
		} else {
			this.setC_Tax_ID(0);
		}
	}

	/**
	 * Get Tax.
	 *
	 * @return Tax identifier
	 */
	public I_C_TaxInput getC_Tax() {
		return C_Tax;
	}

	/**
	 * Set UOM.
	 *
	 * @param C_UOM Unit of Measure
	 */
	public void setC_UOM(I_C_UOMInput C_UOM) {
		this.C_UOM = C_UOM;
		MUOM foreignEntity;
		if (get_ID() == 0 &&C_UOM != null &&
				(foreignEntity = new Query(getCtx(), MUOM.Table_Name, MUOM.COLUMNNAME_C_UOM_UU + "=?", get_TrxName())
						.setParameters(C_UOM.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_UOM_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get UOM.
	 *
	 * @return Unit of Measure
	 */
	public I_C_UOMInput getC_UOM() {
		return C_UOM;
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
	public void setM_AttributeSetInstance(I_M_AttributeSetInstanceInput M_AttributeSetInstance) {
		this.M_AttributeSetInstance = M_AttributeSetInstance;
		MAttributeSetInstance_BH foreignEntity;
		if (M_AttributeSetInstance != null &&
				(foreignEntity = new Query(getCtx(), MAttributeSetInstance_BH.Table_Name, MAttributeSetInstance_BH.COLUMNNAME_M_AttributeSetInstance_UU + "=?", get_TrxName())
						.setParameters(M_AttributeSetInstance.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_AttributeSetInstance_ID(foreignEntity.get_ID());
		} else {
			this.setM_AttributeSetInstance_ID(0);
		}
	}

	/**
	 * Get Attribute Set Instance.
	 *
	 * @return Product Attribute Set Instance
	 */
	public I_M_AttributeSetInstanceInput getM_AttributeSetInstance() {
		return M_AttributeSetInstance;
	}

	/**
	 * Set Shipment/Receipt Line.
	 *
	 * @param M_InOutLine Line on Shipment or Receipt document
	 */
	public void setM_InOutLine(I_M_InOutLineInput M_InOutLine) {
		this.M_InOutLine = M_InOutLine;
		MInOutLine foreignEntity;
		if (get_ID() == 0 &&M_InOutLine != null &&
				(foreignEntity = new Query(getCtx(), MInOutLine.Table_Name, MInOutLine.COLUMNNAME_M_InOutLine_UU + "=?", get_TrxName())
						.setParameters(M_InOutLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_InOutLine_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Shipment/Receipt Line.
	 *
	 * @return Line on Shipment or Receipt document
	 */
	public I_M_InOutLineInput getM_InOutLine() {
		return M_InOutLine;
	}

	/**
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	public void setM_Product(I_M_ProductInput M_Product) {
		this.M_Product = M_Product;
		MProduct_BH foreignEntity;
		if (M_Product != null &&
				(foreignEntity = new Query(getCtx(), MProduct_BH.Table_Name, MProduct_BH.COLUMNNAME_M_Product_UU + "=?", get_TrxName())
						.setParameters(M_Product.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_Product_ID(foreignEntity.get_ID());
		} else {
			this.setM_Product_ID(0);
		}
	}

	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public I_M_ProductInput getM_Product() {
		return M_Product;
	}

	/**
	 * Set RMA Line.
	 *
	 * @param M_RMALine Return Material Authorization Line
	 */
	public void setM_RMALine(I_M_RMALineInput M_RMALine) {
		this.M_RMALine = M_RMALine;
		MRMALine foreignEntity;
		if (M_RMALine != null &&
				(foreignEntity = new Query(getCtx(), MRMALine.Table_Name, MRMALine.COLUMNNAME_M_RMALine_UU + "=?", get_TrxName())
						.setParameters(M_RMALine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_RMALine_ID(foreignEntity.get_ID());
		} else {
			this.setM_RMALine_ID(0);
		}
	}

	/**
	 * Get RMA Line.
	 *
	 * @return Return Material Authorization Line
	 */
	public I_M_RMALineInput getM_RMALine() {
		return M_RMALine;
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
	public void setS_ResourceAssignment(I_S_ResourceAssignmentInput S_ResourceAssignment) {
		this.S_ResourceAssignment = S_ResourceAssignment;
		MResourceAssignment foreignEntity;
		if (get_ID() == 0 &&S_ResourceAssignment != null &&
				(foreignEntity = new Query(getCtx(), MResourceAssignment.Table_Name, MResourceAssignment.COLUMNNAME_S_ResourceAssignment_UU + "=?", get_TrxName())
						.setParameters(S_ResourceAssignment.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setS_ResourceAssignment_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Resource Assignment.
	 *
	 * @return Resource Assignment
	 */
	public I_S_ResourceAssignmentInput getS_ResourceAssignment() {
		return S_ResourceAssignment;
	}

	/**
	 * Set User Element List 1.
	 *
	 * @param User1 User defined list element #1
	 */
	public void setUser1(I_C_ElementValueInput User1) {
		this.User1 = User1;
		MElementValue foreignEntity;
		if (User1 != null &&
				(foreignEntity = new Query(getCtx(), MElementValue.Table_Name, MElementValue.COLUMNNAME_C_ElementValue_UU + "=?", get_TrxName())
						.setParameters(User1.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setUser1_ID(foreignEntity.get_ID());
		} else {
			this.setUser1_ID(0);
		}
	}

	/**
	 * Get User Element List 1.
	 *
	 * @return User defined list element #1
	 */
	public I_C_ElementValueInput getUser1() {
		return User1;
	}

	/**
	 * Set User Element List 2.
	 *
	 * @param User2 User defined list element #2
	 */
	public void setUser2(I_C_ElementValueInput User2) {
		this.User2 = User2;
		MElementValue foreignEntity;
		if (User2 != null &&
				(foreignEntity = new Query(getCtx(), MElementValue.Table_Name, MElementValue.COLUMNNAME_C_ElementValue_UU + "=?", get_TrxName())
						.setParameters(User2.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setUser2_ID(foreignEntity.get_ID());
		} else {
			this.setUser2_ID(0);
		}
	}

	/**
	 * Get User Element List 2.
	 *
	 * @return User defined list element #2
	 */
	public I_C_ElementValueInput getUser2() {
		return User2;
	}
}
