package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAsset;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_A_Asset_Info_Oth;
import org.compiere.util.Env;

/**
 * Generated Model for A_Asset_Info_Oth - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_Info_OthInput extends X_A_Asset_Info_Oth implements I_A_Asset_Info_OthInput {

	 private I_AD_OrgInput AD_Org;
	 private I_A_AssetInput A_Asset;
	 private I_A_Asset_Info_OthInput A_Asset_Info_Oth;

	/**
	 * Standard constructor
	 */
	public X_A_Asset_Info_OthInput(String ID) {
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
	 * Set A_Asset_Info_Oth_ID.
	 *
	 * @param A_Asset_Info_Oth A_Asset_Info_Oth_ID
	 */
	public void setA_Asset_Info_Oth(I_A_Asset_Info_OthInput A_Asset_Info_Oth) {
		this.A_Asset_Info_Oth = A_Asset_Info_Oth;
		X_A_Asset_Info_Oth foreignEntity;
		if (A_Asset_Info_Oth != null &&
				(foreignEntity = new Query(getCtx(), X_A_Asset_Info_Oth.Table_Name, X_A_Asset_Info_Oth.COLUMNNAME_A_Asset_Info_Oth_UU + "=?", get_TrxName())
						.setParameters(A_Asset_Info_Oth.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Asset_Info_Oth_ID(foreignEntity.get_ID());
		} else {
			this.setA_Asset_Info_Oth_ID(0);
		}
	}

	/**
	 * Get A_Asset_Info_Oth_ID.
	 *
	 * @return A_Asset_Info_Oth_ID
	 */
	public I_A_Asset_Info_OthInput getA_Asset_Info_Oth() {
		return A_Asset_Info_Oth;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setA_Asset_Info_Oth_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getA_Asset_Info_Oth_UU();
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
}
