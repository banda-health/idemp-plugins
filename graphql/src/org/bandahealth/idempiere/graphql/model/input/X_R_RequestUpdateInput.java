package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRequest;
import org.compiere.model.MRequestUpdate;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for R_RequestUpdate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_RequestUpdateInput extends MRequestUpdate implements I_R_RequestUpdateInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_ProductSpent;
	private ForeignEntityInput mR_Request;
	private I_AD_Ref_ListInput mConfidentialTypeEntry;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The R_RequestUpdate_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_R_RequestUpdateInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MRequestUpdate(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
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

	/**
	 * Set Entry Confidentiality.
	 *
	 * @param ConfidentialTypeEntry Confidentiality of the individual entry
	 */
	@JsonProperty("ConfidentialTypeEntry")
	public void setConfidentialTypeEntryInput(I_AD_Ref_ListInput ConfidentialTypeEntry) {
		this.mConfidentialTypeEntry = ConfidentialTypeEntry;
		if (ConfidentialTypeEntry != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ConfidentialTypeEntry.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setConfidentialTypeEntry(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + ConfidentialTypeEntry.getUUID());
			}
		} else {
			this.setConfidentialTypeEntry(null);
		}
	}

	/**
	 * Get Entry Confidentiality.
	 *
	 * @return Confidentiality of the individual entry
	 */
	@JsonProperty("ConfidentialTypeEntry")
	public I_AD_Ref_ListInput ConfidentialTypeEntry() {
		return mConfidentialTypeEntry;
	}

	/**
	 * Set Product Used.
	 *
	 * @param M_ProductSpent Product/Resource/Service used in Request
	 */
	@JsonProperty("M_ProductSpent")
	public void setM_ProductSpentInput(ForeignEntityInput M_ProductSpent) {
		this.mM_ProductSpent = M_ProductSpent;
		if (M_ProductSpent != null) {
			// Since an entity was passed, make sure it's in the DB
			MProduct_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
							.setParameters(M_ProductSpent.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_ProductSpent_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product with UUID " + M_ProductSpent.getUUID());
			}
		} else {
			this.setM_ProductSpent_ID(0);
		}
	}

	/**
	 * Get Product Used.
	 *
	 * @return Product/Resource/Service used in Request
	 */
	@JsonProperty("M_ProductSpent")
	public ForeignEntityInput M_ProductSpent() {
		return mM_ProductSpent;
	}

	/**
	 * Set Request.
	 *
	 * @param R_Request Request from a Business Partner or Prospect
	 */
	@JsonProperty("R_Request")
	public void setR_RequestInput(ForeignEntityInput R_Request) {
		this.mR_Request = R_Request;
		if (get_ID() != 0) {
			return;
		}
		if (R_Request != null) {
			// Since an entity was passed, make sure it's in the DB
			MRequest foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "R_Request", "R_Request_UU=?", get_TrxName())
							.setParameters(R_Request.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setR_Request_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_Request with UUID " + R_Request.getUUID());
			}
		} else {
			this.setR_Request_ID(0);
		}
	}

	/**
	 * Get Request.
	 *
	 * @return Request from a Business Partner or Prospect
	 */
	@JsonProperty("R_Request")
	public ForeignEntityInput R_Request() {
		return mR_Request;
	}
	/**
	 * Set Request Update.
	 *
	 * @param R_RequestUpdate_ID Request Updates
	 */

	public void setR_RequestUpdate_ID(int R_RequestUpdate_ID) {
		if (get_ID() == 0) {
			super.setR_RequestUpdate_ID(R_RequestUpdate_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setR_RequestUpdate_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getR_RequestUpdate_UU();
	}
	/**
	 * Set Result.
	 *
	 * @param Result Result of the action taken
	 */

	public void setResult(String Result) {
		if (get_ID() == 0) {
			super.setResult(Result);
		}
	}
}
