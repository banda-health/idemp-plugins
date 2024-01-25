package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MDistributionList;
import org.compiere.model.MDistributionListLine;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_DistributionListLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_DistributionListLineInput extends MDistributionListLine implements I_M_DistributionListLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_BPartner_Location;
	private ForeignEntityInput mM_DistributionList;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_DistributionListLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_DistributionListLineInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MDistributionListLine(null, (ResultSet) null, null),
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
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		if (C_BPartner != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartner_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(C_BPartner.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UUID " + C_BPartner.getUUID());
			}
		} else {
			this.setC_BPartner_ID(0);
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
	 * Set Partner Location.
	 *
	 * @param C_BPartner_Location Identifies the (ship to) address for this Business Partner
	 */
	@JsonProperty("C_BPartner_Location")
	public void setC_BPartner_LocationInput(ForeignEntityInput C_BPartner_Location) {
		this.mC_BPartner_Location = C_BPartner_Location;
		if (C_BPartner_Location != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartnerLocation foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner_Location", "C_BPartner_Location_UU=?", get_TrxName())
							.setParameters(C_BPartner_Location.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_BPartner_Location_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner_Location with UUID " + C_BPartner_Location.getUUID());
			}
		} else {
			this.setC_BPartner_Location_ID(0);
		}
	}

	/**
	 * Get Partner Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	@JsonProperty("C_BPartner_Location")
	public ForeignEntityInput C_BPartner_Location() {
		return mC_BPartner_Location;
	}

	/**
	 * Set Distribution List.
	 *
	 * @param M_DistributionList Distribution Lists allow to distribute products to a selected list of partners
	 */
	@JsonProperty("M_DistributionList")
	public void setM_DistributionListInput(ForeignEntityInput M_DistributionList) {
		this.mM_DistributionList = M_DistributionList;
		if (get_ID() != 0) {
			return;
		}
		if (M_DistributionList != null) {
			// Since an entity was passed, make sure it's in the DB
			MDistributionList foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_DistributionList", "M_DistributionList_UU=?", get_TrxName())
							.setParameters(M_DistributionList.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_DistributionList_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_DistributionList with UUID " + M_DistributionList.getUUID());
			}
		} else {
			this.setM_DistributionList_ID(0);
		}
	}

	/**
	 * Get Distribution List.
	 *
	 * @return Distribution Lists allow to distribute products to a selected list of partners
	 */
	@JsonProperty("M_DistributionList")
	public ForeignEntityInput M_DistributionList() {
		return mM_DistributionList;
	}
	/**
	 * Set Distribution List Line.
	 *
	 * @param M_DistributionListLine_ID Distribution List Line with Business Partner and Quantity/Percentage
	 */

	public void setM_DistributionListLine_ID(int M_DistributionListLine_ID) {
		if (get_ID() == 0) {
			super.setM_DistributionListLine_ID(M_DistributionListLine_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_DistributionListLine_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getM_DistributionListLine_UU();
	}
}
