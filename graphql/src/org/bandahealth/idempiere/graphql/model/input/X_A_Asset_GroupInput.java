package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAssetClass;
import org.compiere.model.MAssetGroup;
import org.compiere.model.MAssetType;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for A_Asset_Group - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_GroupInput extends MAssetGroup implements I_A_Asset_GroupInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mA_Asset_Class;
	private ForeignEntityInput mA_Asset_Type;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The A_Asset_Group_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_A_Asset_GroupInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Asset class.
	 *
	 * @param A_Asset_Class Asset class
	 */
	@JsonProperty("A_Asset_Class")
	public void setA_Asset_ClassInput(ForeignEntityInput A_Asset_Class) {
		this.mA_Asset_Class = A_Asset_Class;
		if (A_Asset_Class != null) {
			// Since an entity was passed, make sure it's in the DB
			MAssetClass foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_Asset_Class", "A_Asset_Class_UU=?", get_TrxName())
							.setParameters(A_Asset_Class.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Asset_Class_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Asset_Class with UUID " + A_Asset_Class.getUUID());
			}
		} else {
			this.setA_Asset_Class_ID(0);
		}
	}

	/**
	 * Get Asset class.
	 *
	 * @return Asset class
	 */
	@JsonProperty("A_Asset_Class")
	public ForeignEntityInput A_Asset_Class() {
		return mA_Asset_Class;
	}
	/**
	 * Set Asset Group.
	 *
	 * @param A_Asset_Group_ID Group of Assets
	 */

	public void setA_Asset_Group_ID(int A_Asset_Group_ID) {
		if (get_ID() == 0) {
			super.setA_Asset_Group_ID(A_Asset_Group_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setA_Asset_Group_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getA_Asset_Group_UU();
	}

	/**
	 * Set Asset Type.
	 *
	 * @param A_Asset_Type Asset Type
	 */
	@JsonProperty("A_Asset_Type")
	public void setA_Asset_TypeInput(ForeignEntityInput A_Asset_Type) {
		this.mA_Asset_Type = A_Asset_Type;
		if (A_Asset_Type != null) {
			// Since an entity was passed, make sure it's in the DB
			MAssetType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_Asset_Type", "A_Asset_Type_UU=?", get_TrxName())
							.setParameters(A_Asset_Type.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Asset_Type_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Asset_Type with UUID " + A_Asset_Type.getUUID());
			}
		} else {
			this.setA_Asset_Type_ID(0);
		}
	}

	/**
	 * Get Asset Type.
	 *
	 * @return Asset Type
	 */
	@JsonProperty("A_Asset_Type")
	public ForeignEntityInput A_Asset_Type() {
		return mA_Asset_Type;
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
