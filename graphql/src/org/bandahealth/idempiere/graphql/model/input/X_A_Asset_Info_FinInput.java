package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAsset;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_A_Asset_Info_Fin;

import java.sql.ResultSet;

/**
 * Generated Model for A_Asset_Info_Fin - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_Info_FinInput extends X_A_Asset_Info_Fin implements I_A_Asset_Info_FinInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mA_Asset;
	private ForeignEntityInput mC_BPartner;
	private I_AD_Ref_ListInput mA_Due_On;
	private I_AD_Ref_ListInput mA_Finance_Meth;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_A_Asset_Info_FinInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_A_Asset_Info_Fin(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	@JsonProperty("A_Asset")
	public void setA_AssetInput(ForeignEntityInput A_Asset) {
		this.mA_Asset = A_Asset;
		MAsset foreignEntity;
		if (get_ID() == 0 && A_Asset != null &&
				(foreignEntity = new Query(getCtx(), "A_Asset", "A_Asset_UU=?", get_TrxName())
						.setParameters(A_Asset.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Asset_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	@JsonProperty("A_Asset")
	public ForeignEntityInput A_Asset() {
		return mA_Asset;
	}
	/**
	 * Set Asset Info Financial ID.
	 *
	 * @param A_Asset_Info_Fin_ID Asset Info Financial ID
	 */

	public void setA_Asset_Info_Fin_ID(int A_Asset_Info_Fin_ID) {
		if (get_ID() == 0) {
			super.setA_Asset_Info_Fin_ID(A_Asset_Info_Fin_ID);
		}
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
	 * @param A_Due_On Asset Due On
	 */
	@JsonProperty("A_Due_On")
	public void setA_Due_OnInput(I_AD_Ref_ListInput A_Due_On) {
		this.mA_Due_On = A_Due_On;
		MRefList_BH foreignEntity;
		if (A_Due_On != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Due_On.getID())
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
	@JsonProperty("A_Due_On")
	public I_AD_Ref_ListInput A_Due_On() {
		return mA_Due_On;
	}

	/**
	 * Set Asset Finance Method.
	 *
	 * @param A_Finance_Meth Asset Finance Method
	 */
	@JsonProperty("A_Finance_Meth")
	public void setA_Finance_MethInput(I_AD_Ref_ListInput A_Finance_Meth) {
		this.mA_Finance_Meth = A_Finance_Meth;
		MRefList_BH foreignEntity;
		if (A_Finance_Meth != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Finance_Meth.getID())
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
	@JsonProperty("A_Finance_Meth")
	public I_AD_Ref_ListInput A_Finance_Meth() {
		return mA_Finance_Meth;
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
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (C_BPartner != null &&
				(foreignEntity = new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
						.setParameters(C_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BPartner_ID(foreignEntity.get_ID());
		} else {
			super.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public ForeignEntityInput C_BPartner() {
		return mC_BPartner;
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
