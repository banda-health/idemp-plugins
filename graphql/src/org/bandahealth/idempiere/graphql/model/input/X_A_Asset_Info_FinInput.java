package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAsset;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_A_Asset_Info_Fin;
import org.compiere.util.Env;

/**
 * Generated Model for A_Asset_Info_Fin - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_Info_FinInput extends X_A_Asset_Info_Fin implements I_A_Asset_Info_FinInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput A_Due_On_RL;
	 private I_AD_Ref_ListInput A_Finance_Meth_RL;
	 private I_A_AssetInput A_Asset;
	 private I_C_BPartnerInput C_BPartner;

	/**
	 * Standard constructor
	 */
	public X_A_Asset_Info_FinInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	public void setA_Asset(I_A_AssetInput A_Asset) {
		this.A_Asset = A_Asset;
		MAsset foreignEntity;
		if (get_ID() == 0 &&A_Asset != null &&
				(foreignEntity = new Query(getCtx(), MAsset.Table_Name, MAsset.COLUMNNAME_A_Asset_UU + "=?", get_TrxName())
						.setParameters(A_Asset.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Asset_ID(foreignEntity.get_ID());
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setA_Asset_Info_Fin_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getA_Asset_Info_Fin_UU();
	}

	/**
	 * Set Asset Due On.
	 *
	 * @param A_Due_On_RL Asset Due On
	 */
	public void setA_Due_On_RL(I_AD_Ref_ListInput A_Due_On_RL) {
		this.A_Due_On_RL = A_Due_On_RL;
		MRefList foreignEntity;
		if (A_Due_On_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Due_On_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Due_On(foreignEntity.getValue());
		} else {
			this.setA_Due_On(null);
		}
	}

	/**
	 * Get Asset Due On.
	 *
	 * @return Asset Due On
	 */
	public I_AD_Ref_ListInput getA_Due_On_RL() {
		return A_Due_On_RL;
	}

	/**
	 * Set Asset Finance Method.
	 *
	 * @param A_Finance_Meth_RL Asset Finance Method
	 */
	public void setA_Finance_Meth_RL(I_AD_Ref_ListInput A_Finance_Meth_RL) {
		this.A_Finance_Meth_RL = A_Finance_Meth_RL;
		MRefList foreignEntity;
		if (A_Finance_Meth_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Finance_Meth_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Finance_Meth(foreignEntity.getValue());
		} else {
			this.setA_Finance_Meth(null);
		}
	}

	/**
	 * Get Asset Finance Method.
	 *
	 * @return Asset Finance Method
	 */
	public I_AD_Ref_ListInput getA_Finance_Meth_RL() {
		return A_Finance_Meth_RL;
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
	 * Set Processed.
	 *
	 * @param Processed The document has been processed
	 */
	public void setProcessed(boolean Processed) {
		if (get_ID() == 0) {
			super.setProcessed(Processed);
		}
	}
}
