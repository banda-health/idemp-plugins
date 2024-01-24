package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_BP_Relation;

import java.sql.ResultSet;

/**
 * Generated Model for C_BP_Relation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BP_RelationInput extends X_C_BP_Relation implements I_C_BP_RelationInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_BPartnerRelation;
	private ForeignEntityInput mC_BPartnerRelation_Location;
	private ForeignEntityInput mC_BPartner_Location;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_BP_RelationInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_C_BP_Relation(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Partner Relation.
	 *
	 * @param C_BP_Relation_ID Business Partner Relation
	 */

	public void setC_BP_Relation_ID(int C_BP_Relation_ID) {
		if (get_ID() == 0) {
			super.setC_BP_Relation_ID(C_BP_Relation_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_BP_Relation_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_BP_Relation_UU();
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
	 * Set Related Partner.
	 *
	 * @param C_BPartnerRelation Related Business Partner
	 */
	@JsonProperty("C_BPartnerRelation")
	public void setC_BPartnerRelationInput(ForeignEntityInput C_BPartnerRelation) {
		this.mC_BPartnerRelation = C_BPartnerRelation;
		MBPartner_BH foreignEntity;
		if (C_BPartnerRelation != null &&
				(foreignEntity = new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
						.setParameters(C_BPartnerRelation.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BPartnerRelation_ID(foreignEntity.get_ID());
		} else {
			super.setC_BPartnerRelation_ID(0);
		}
	}

	/**
	 * Get Related Partner.
	 *
	 * @return Related Business Partner
	 */
	@JsonProperty("C_BPartnerRelation")
	public ForeignEntityInput C_BPartnerRelation() {
		return mC_BPartnerRelation;
	}

	/**
	 * Set Related Partner Location.
	 *
	 * @param C_BPartnerRelation_Location Location of the related Business Partner
	 */
	@JsonProperty("C_BPartnerRelation_Location")
	public void setC_BPartnerRelation_LocationInput(ForeignEntityInput C_BPartnerRelation_Location) {
		this.mC_BPartnerRelation_Location = C_BPartnerRelation_Location;
		MBPartnerLocation foreignEntity;
		if (C_BPartnerRelation_Location != null &&
				(foreignEntity = new Query(getCtx(), "C_BPartner_Location", "C_BPartner_Location_UU=?", get_TrxName())
						.setParameters(C_BPartnerRelation_Location.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BPartnerRelation_Location_ID(foreignEntity.get_ID());
		} else {
			super.setC_BPartnerRelation_Location_ID(0);
		}
	}

	/**
	 * Get Related Partner Location.
	 *
	 * @return Location of the related Business Partner
	 */
	@JsonProperty("C_BPartnerRelation_Location")
	public ForeignEntityInput C_BPartnerRelation_Location() {
		return mC_BPartnerRelation_Location;
	}
	/**
	 * Set Ship Address.
	 *
	 * @param IsShipTo Business Partner Shipment Address
	 */

	public void setIsShipTo(boolean IsShipTo) {
		if (get_ID() == 0) {
			super.setIsShipTo(IsShipTo);
		}
	}
}
