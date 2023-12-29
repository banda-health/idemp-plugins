package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCurrency;
import org.compiere.model.MOrg;
import org.compiere.model.MRMA;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_M_RMAType;
import org.compiere.util.Env;

/**
 * Generated Model for M_RMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_RMAInput extends MRMA implements I_M_RMAInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput DocAction_RL;
	 private I_AD_Ref_ListInput DocStatus_RL;
	 private I_AD_UserInput SalesRep;
	 private I_C_BPartnerInput C_BPartner;
	 private I_C_CurrencyInput C_Currency;
	 private I_C_DocTypeInput C_DocType;
	 private I_C_OrderInput C_Order;
	 private I_M_InOutInput InOut;
	 private I_M_RMAInput Ref_RMA;
	 private I_M_RMATypeInput M_RMAType;

	/**
	 * Standard constructor
	 */
	public X_M_RMAInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
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
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	public void setC_BPartner(I_C_BPartnerInput C_BPartner) {
		this.C_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (C_BPartner != null &&
				(foreignEntity = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", get_TrxName())
						.setParameters(C_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_BPartner_ID(foreignEntity.get_ID());
		} else {
			this.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	public I_C_BPartnerInput getC_BPartner() {
		return C_BPartner;
	}

	/**
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	public void setC_Currency(I_C_CurrencyInput C_Currency) {
		this.C_Currency = C_Currency;
		MCurrency foreignEntity;
		if (C_Currency != null &&
				(foreignEntity = new Query(getCtx(), MCurrency.Table_Name, MCurrency.COLUMNNAME_C_Currency_UU + "=?", get_TrxName())
						.setParameters(C_Currency.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Currency_ID(foreignEntity.get_ID());
		} else {
			this.setC_Currency_ID(0);
		}
	}

	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public I_C_CurrencyInput getC_Currency() {
		return C_Currency;
	}

	/**
	 * Set Document Type.
	 *
	 * @param C_DocType Document type or rules
	 */
	public void setC_DocType(I_C_DocTypeInput C_DocType) {
		this.C_DocType = C_DocType;
		MDocType_BH foreignEntity;
		if (C_DocType != null &&
				(foreignEntity = new Query(getCtx(), MDocType_BH.Table_Name, MDocType_BH.COLUMNNAME_C_DocType_UU + "=?", get_TrxName())
						.setParameters(C_DocType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_DocType_ID(foreignEntity.get_ID());
		} else {
			this.setC_DocType_ID(0);
		}
	}

	/**
	 * Get Document Type.
	 *
	 * @return Document type or rules
	 */
	public I_C_DocTypeInput getC_DocType() {
		return C_DocType;
	}

	/**
	 * Set Order.
	 *
	 * @param C_Order Order
	 */
	public void setC_Order(I_C_OrderInput C_Order) {
		this.C_Order = C_Order;
		MOrder_BH foreignEntity;
		if (get_ID() == 0 &&C_Order != null &&
				(foreignEntity = new Query(getCtx(), MOrder_BH.Table_Name, MOrder_BH.COLUMNNAME_C_Order_UU + "=?", get_TrxName())
						.setParameters(C_Order.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Order_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Order.
	 *
	 * @return Order
	 */
	public I_C_OrderInput getC_Order() {
		return C_Order;
	}

	/**
	 * Set Document Action.
	 *
	 * @param DocAction_RL The targeted status of the document
	 */
	public void setDocAction_RL(I_AD_Ref_ListInput DocAction_RL) {
		this.DocAction_RL = DocAction_RL;
		MRefList foreignEntity;
		if (DocAction_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DocAction_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDocAction(foreignEntity.getValue());
		} else {
			this.setDocAction(null);
		}
	}

	/**
	 * Get Document Action.
	 *
	 * @return The targeted status of the document
	 */
	public I_AD_Ref_ListInput getDocAction_RL() {
		return DocAction_RL;
	}

	/**
	 * Set Document Status.
	 *
	 * @param DocStatus_RL The current status of the document
	 */
	public void setDocStatus_RL(I_AD_Ref_ListInput DocStatus_RL) {
		this.DocStatus_RL = DocStatus_RL;
		MRefList foreignEntity;
		if (DocStatus_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DocStatus_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDocStatus(foreignEntity.getValue());
		} else {
			this.setDocStatus(null);
		}
	}

	/**
	 * Get Document Status.
	 *
	 * @return The current status of the document
	 */
	public I_AD_Ref_ListInput getDocStatus_RL() {
		return DocStatus_RL;
	}

	/**
	 * Set Shipment/Receipt.
	 *
	 * @param InOut MaterialShipment Document
	 */
	public void setInOut(I_M_InOutInput InOut) {
		this.InOut = InOut;
		MInOut_BH foreignEntity;
		if (get_ID() == 0 &&InOut != null &&
				(foreignEntity = new Query(getCtx(), MInOut_BH.Table_Name, MInOut_BH.COLUMNNAME_M_InOut_UU + "=?", get_TrxName())
						.setParameters(InOut.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setInOut_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Shipment/Receipt.
	 *
	 * @return MaterialShipment Document
	 */
	public I_M_InOutInput getInOut() {
		return InOut;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_RMA_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_RMA_UU();
	}

	/**
	 * Set RMA Type.
	 *
	 * @param M_RMAType Return Material Authorization Type
	 */
	public void setM_RMAType(I_M_RMATypeInput M_RMAType) {
		this.M_RMAType = M_RMAType;
		X_M_RMAType foreignEntity;
		if (M_RMAType != null &&
				(foreignEntity = new Query(getCtx(), X_M_RMAType.Table_Name, X_M_RMAType.COLUMNNAME_M_RMAType_UU + "=?", get_TrxName())
						.setParameters(M_RMAType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_RMAType_ID(foreignEntity.get_ID());
		} else {
			this.setM_RMAType_ID(0);
		}
	}

	/**
	 * Get RMA Type.
	 *
	 * @return Return Material Authorization Type
	 */
	public I_M_RMATypeInput getM_RMAType() {
		return M_RMAType;
	}

	/**
	 * Set Referenced RMA.
	 *
	 * @param Ref_RMA Referenced RMA
	 */
	public void setRef_RMA(I_M_RMAInput Ref_RMA) {
		this.Ref_RMA = Ref_RMA;
		MRMA foreignEntity;
		if (Ref_RMA != null &&
				(foreignEntity = new Query(getCtx(), MRMA.Table_Name, MRMA.COLUMNNAME_M_RMA_UU + "=?", get_TrxName())
						.setParameters(Ref_RMA.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setRef_RMA_ID(foreignEntity.get_ID());
		} else {
			this.setRef_RMA_ID(0);
		}
	}

	/**
	 * Get Referenced RMA.
	 *
	 * @return Referenced RMA
	 */
	public I_M_RMAInput getRef_RMA() {
		return Ref_RMA;
	}

	/**
	 * Set Sales Representative.
	 *
	 * @param SalesRep Sales Representative or Company Agent
	 */
	public void setSalesRep(I_AD_UserInput SalesRep) {
		this.SalesRep = SalesRep;
		MUser_BH foreignEntity;
		if (SalesRep != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
						.setParameters(SalesRep.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setSalesRep_ID(foreignEntity.get_ID());
		} else {
			this.setSalesRep_ID(0);
		}
	}

	/**
	 * Get Sales Representative.
	 *
	 * @return Sales Representative or Company Agent
	 */
	public I_AD_UserInput getSalesRep() {
		return SalesRep;
	}
}
