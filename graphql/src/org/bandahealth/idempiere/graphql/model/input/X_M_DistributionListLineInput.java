package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MDistributionList;
import org.compiere.model.MDistributionListLine;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

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
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_DistributionListLineInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MDistributionListLine(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
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
	 * Set Partner Location.
	 *
	 * @param C_BPartner_Location Identifies the (ship to) address for this Business Partner
	 */
	@JsonProperty("C_BPartner_Location")
	public void setC_BPartner_LocationInput(ForeignEntityInput C_BPartner_Location) {
		this.mC_BPartner_Location = C_BPartner_Location;
		MBPartnerLocation foreignEntity;
		if (C_BPartner_Location != null &&
				(foreignEntity = new Query(getCtx(), "C_BPartner_Location", "C_BPartner_Location_UU=?", get_TrxName())
						.setParameters(C_BPartner_Location.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BPartner_Location_ID(foreignEntity.get_ID());
		} else {
			super.setC_BPartner_Location_ID(0);
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
		MDistributionList foreignEntity;
		if (get_ID() == 0 && M_DistributionList != null &&
				(foreignEntity = new Query(getCtx(), "M_DistributionList", "M_DistributionList_UU=?", get_TrxName())
						.setParameters(M_DistributionList.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_DistributionList_ID(foreignEntity.get_ID());
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_DistributionListLine_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_DistributionListLine_UU();
	}
}
