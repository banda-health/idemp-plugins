package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MActivity;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MCampaign;
import org.compiere.model.MCurrency;
import org.compiere.model.MOrg;
import org.compiere.model.MPaymentTerm;
import org.compiere.model.MPriceListVersion;
import org.compiere.model.MProject;
import org.compiere.model.MProjectTypePhase;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for C_Project - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ProjectInput extends MProject implements I_C_ProjectInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput ProjInvoiceRule_RL;
	 private I_AD_Ref_ListInput ProjectCategory_RL;
	 private I_AD_Ref_ListInput ProjectLineLevel_RL;
	 private I_AD_UserInput AD_User;
	 private I_AD_UserInput SalesRep;
	 private I_C_ActivityInput C_Activity;
	 private I_C_BPartnerInput C_BPartner;
	 private I_C_BPartnerInput C_BPartnerSR;
	 private I_C_BPartner_LocationInput C_BPartner_Location;
	 private I_C_CampaignInput C_Campaign;
	 private I_C_CurrencyInput C_Currency;
	 private I_C_PaymentTermInput C_PaymentTerm;
	 private I_C_PhaseInput C_Phase;
	 private I_M_PriceList_VersionInput M_PriceList_Version;
	 private I_M_WarehouseInput M_Warehouse;

	/**
	 * Standard constructor
	 */
	public X_C_ProjectInput(String ID) {
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
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	public void setAD_User(I_AD_UserInput AD_User) {
		this.AD_User = AD_User;
		MUser_BH foreignEntity;
		if (AD_User != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
						.setParameters(AD_User.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_User_ID(foreignEntity.get_ID());
		} else {
			this.setAD_User_ID(0);
		}
	}

	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public I_AD_UserInput getAD_User() {
		return AD_User;
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
	 * Set Partner Location.
	 *
	 * @param C_BPartner_Location Identifies the (ship to) address for this Business Partner
	 */
	public void setC_BPartner_Location(I_C_BPartner_LocationInput C_BPartner_Location) {
		this.C_BPartner_Location = C_BPartner_Location;
		MBPartnerLocation foreignEntity;
		if (C_BPartner_Location != null &&
				(foreignEntity = new Query(getCtx(), MBPartnerLocation.Table_Name, MBPartnerLocation.COLUMNNAME_C_BPartner_Location_UU + "=?", get_TrxName())
						.setParameters(C_BPartner_Location.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_BPartner_Location_ID(foreignEntity.get_ID());
		} else {
			this.setC_BPartner_Location_ID(0);
		}
	}

	/**
	 * Get Partner Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	public I_C_BPartner_LocationInput getC_BPartner_Location() {
		return C_BPartner_Location;
	}

	/**
	 * Set BPartner (Agent).
	 *
	 * @param C_BPartnerSR Business Partner (Agent or Sales Rep)
	 */
	public void setC_BPartnerSR(I_C_BPartnerInput C_BPartnerSR) {
		this.C_BPartnerSR = C_BPartnerSR;
		MBPartner_BH foreignEntity;
		if (C_BPartnerSR != null &&
				(foreignEntity = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", get_TrxName())
						.setParameters(C_BPartnerSR.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_BPartnerSR_ID(foreignEntity.get_ID());
		} else {
			this.setC_BPartnerSR_ID(0);
		}
	}

	/**
	 * Get BPartner (Agent).
	 *
	 * @return Business Partner (Agent or Sales Rep)
	 */
	public I_C_BPartnerInput getC_BPartnerSR() {
		return C_BPartnerSR;
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
	 * Set Payment Term.
	 *
	 * @param C_PaymentTerm The terms of Payment (timing, discount)
	 */
	public void setC_PaymentTerm(I_C_PaymentTermInput C_PaymentTerm) {
		this.C_PaymentTerm = C_PaymentTerm;
		MPaymentTerm foreignEntity;
		if (C_PaymentTerm != null &&
				(foreignEntity = new Query(getCtx(), MPaymentTerm.Table_Name, MPaymentTerm.COLUMNNAME_C_PaymentTerm_UU + "=?", get_TrxName())
						.setParameters(C_PaymentTerm.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_PaymentTerm_ID(foreignEntity.get_ID());
		} else {
			this.setC_PaymentTerm_ID(0);
		}
	}

	/**
	 * Get Payment Term.
	 *
	 * @return The terms of Payment (timing, discount)
	 */
	public I_C_PaymentTermInput getC_PaymentTerm() {
		return C_PaymentTerm;
	}

	/**
	 * Set Standard Phase.
	 *
	 * @param C_Phase Standard Phase of the Project Type
	 */
	public void setC_Phase(I_C_PhaseInput C_Phase) {
		this.C_Phase = C_Phase;
		MProjectTypePhase foreignEntity;
		if (C_Phase != null &&
				(foreignEntity = new Query(getCtx(), MProjectTypePhase.Table_Name, MProjectTypePhase.COLUMNNAME_C_Phase_UU + "=?", get_TrxName())
						.setParameters(C_Phase.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Phase_ID(foreignEntity.get_ID());
		} else {
			this.setC_Phase_ID(0);
		}
	}

	/**
	 * Get Standard Phase.
	 *
	 * @return Standard Phase of the Project Type
	 */
	public I_C_PhaseInput getC_Phase() {
		return C_Phase;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_Project_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_Project_UU();
	}
	/**
	 * Set Invoiced Amount.
	 *
	 * @param InvoicedAmt The amount invoiced
	 */
	public void setInvoicedAmt(BigDecimal InvoicedAmt) {
		if (get_ID() == 0) {
			super.setInvoicedAmt(InvoicedAmt);
		}
	}
	/**
	 * Set Quantity Invoiced .
	 *
	 * @param InvoicedQty The quantity invoiced
	 */
	public void setInvoicedQty(BigDecimal InvoicedQty) {
		if (get_ID() == 0) {
			super.setInvoicedQty(InvoicedQty);
		}
	}

	/**
	 * Set Price List Version.
	 *
	 * @param M_PriceList_Version Identifies a unique instance of a Price List
	 */
	public void setM_PriceList_Version(I_M_PriceList_VersionInput M_PriceList_Version) {
		this.M_PriceList_Version = M_PriceList_Version;
		MPriceListVersion foreignEntity;
		if (M_PriceList_Version != null &&
				(foreignEntity = new Query(getCtx(), MPriceListVersion.Table_Name, MPriceListVersion.COLUMNNAME_M_PriceList_Version_UU + "=?", get_TrxName())
						.setParameters(M_PriceList_Version.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_PriceList_Version_ID(foreignEntity.get_ID());
		} else {
			this.setM_PriceList_Version_ID(0);
		}
	}

	/**
	 * Get Price List Version.
	 *
	 * @return Identifies a unique instance of a Price List
	 */
	public I_M_PriceList_VersionInput getM_PriceList_Version() {
		return M_PriceList_Version;
	}

	/**
	 * Set Warehouse.
	 *
	 * @param M_Warehouse Storage Warehouse and Service Point
	 */
	public void setM_Warehouse(I_M_WarehouseInput M_Warehouse) {
		this.M_Warehouse = M_Warehouse;
		MWarehouse_BH foreignEntity;
		if (M_Warehouse != null &&
				(foreignEntity = new Query(getCtx(), MWarehouse_BH.Table_Name, MWarehouse_BH.COLUMNNAME_M_Warehouse_UU + "=?", get_TrxName())
						.setParameters(M_Warehouse.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_Warehouse_ID(foreignEntity.get_ID());
		} else {
			this.setM_Warehouse_ID(0);
		}
	}

	/**
	 * Get Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	public I_M_WarehouseInput getM_Warehouse() {
		return M_Warehouse;
	}
	/**
	 * Set Project Balance.
	 *
	 * @param ProjectBalanceAmt Total Project Balance
	 */
	public void setProjectBalanceAmt(BigDecimal ProjectBalanceAmt) {
		if (get_ID() == 0) {
			super.setProjectBalanceAmt(ProjectBalanceAmt);
		}
	}

	/**
	 * Set Project Category.
	 *
	 * @param ProjectCategory_RL Project Category
	 */
	public void setProjectCategory_RL(I_AD_Ref_ListInput ProjectCategory_RL) {
		this.ProjectCategory_RL = ProjectCategory_RL;
		MRefList foreignEntity;
		if (ProjectCategory_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ProjectCategory_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setProjectCategory(foreignEntity.getValue());
		} else {
			this.setProjectCategory(null);
		}
	}

	/**
	 * Get Project Category.
	 *
	 * @return Project Category
	 */
	public I_AD_Ref_ListInput getProjectCategory_RL() {
		return ProjectCategory_RL;
	}

	/**
	 * Set Line Level.
	 *
	 * @param ProjectLineLevel_RL Project Line Level
	 */
	public void setProjectLineLevel_RL(I_AD_Ref_ListInput ProjectLineLevel_RL) {
		this.ProjectLineLevel_RL = ProjectLineLevel_RL;
		MRefList foreignEntity;
		if (ProjectLineLevel_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ProjectLineLevel_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setProjectLineLevel(foreignEntity.getValue());
		} else {
			this.setProjectLineLevel(null);
		}
	}

	/**
	 * Get Line Level.
	 *
	 * @return Project Line Level
	 */
	public I_AD_Ref_ListInput getProjectLineLevel_RL() {
		return ProjectLineLevel_RL;
	}

	/**
	 * Set Invoice Rule.
	 *
	 * @param ProjInvoiceRule_RL Invoice Rule for the project
	 */
	public void setProjInvoiceRule_RL(I_AD_Ref_ListInput ProjInvoiceRule_RL) {
		this.ProjInvoiceRule_RL = ProjInvoiceRule_RL;
		MRefList foreignEntity;
		if (ProjInvoiceRule_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ProjInvoiceRule_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setProjInvoiceRule(foreignEntity.getValue());
		} else {
			this.setProjInvoiceRule(null);
		}
	}

	/**
	 * Get Invoice Rule.
	 *
	 * @return Invoice Rule for the project
	 */
	public I_AD_Ref_ListInput getProjInvoiceRule_RL() {
		return ProjInvoiceRule_RL;
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
