package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAsset;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_A_Asset_Info_Oth;

import java.sql.ResultSet;

/**
 * Generated Model for A_Asset_Info_Oth - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_A_Asset_Info_OthInput extends X_A_Asset_Info_Oth implements I_A_Asset_Info_OthInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mA_Asset;
	private ForeignEntityInput mA_Asset_Info_Oth;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_A_Asset_Info_OthInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_A_Asset_Info_Oth(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set A_Asset_Info_Oth_ID.
	 *
	 * @param A_Asset_Info_Oth A_Asset_Info_Oth_ID
	 */
	@JsonProperty("A_Asset_Info_Oth")
	public void setA_Asset_Info_OthInput(ForeignEntityInput A_Asset_Info_Oth) {
		this.mA_Asset_Info_Oth = A_Asset_Info_Oth;
		X_A_Asset_Info_Oth foreignEntity;
		if (A_Asset_Info_Oth != null &&
				(foreignEntity = new Query(getCtx(), "A_Asset_Info_Oth", "A_Asset_Info_Oth_UU=?", get_TrxName())
						.setParameters(A_Asset_Info_Oth.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Asset_Info_Oth_ID(foreignEntity.get_ID());
		} else {
			super.setA_Asset_Info_Oth_ID(0);
		}
	}

	/**
	 * Get A_Asset_Info_Oth_ID.
	 *
	 * @return A_Asset_Info_Oth_ID
	 */
	@JsonProperty("A_Asset_Info_Oth")
	public ForeignEntityInput A_Asset_Info_Oth() {
		return mA_Asset_Info_Oth;
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
}
