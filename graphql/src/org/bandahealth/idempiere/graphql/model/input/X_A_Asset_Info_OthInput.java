package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAsset;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_A_Asset_Info_Oth;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for A_Asset_Info_Oth - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_Info_OthInput extends X_A_Asset_Info_Oth implements I_A_Asset_Info_OthInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mA_Asset;
	private ForeignEntityInput mA_Asset_Info_Oth;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The A_Asset_Info_Oth_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_A_Asset_Info_OthInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_A_Asset_Info_Oth(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	@JsonProperty("A_Asset")
	public void setA_AssetInput(ForeignEntityInput A_Asset) {
		this.mA_Asset = A_Asset;
		if (get_ID() != 0) {
			return;
		}
		if (A_Asset != null) {
			// Since an entity was passed, make sure it's in the DB
			MAsset foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_Asset", "A_Asset_UU=?", get_TrxName())
							.setParameters(A_Asset.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Asset_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Asset with UUID " + A_Asset.getUUID());
			}
		} else {
			this.setA_Asset_ID(0);
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
		if (A_Asset_Info_Oth != null) {
			// Since an entity was passed, make sure it's in the DB
			X_A_Asset_Info_Oth foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_Asset_Info_Oth", "A_Asset_Info_Oth_UU=?", get_TrxName())
							.setParameters(A_Asset_Info_Oth.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Asset_Info_Oth_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Asset_Info_Oth with UUID " + A_Asset_Info_Oth.getUUID());
			}
		} else {
			this.setA_Asset_Info_Oth_ID(0);
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setA_Asset_Info_Oth_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
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
