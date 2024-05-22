package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_BP_Relation;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_BP_Relation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_BP_RelationInput extends X_C_BP_Relation implements I_C_BP_RelationInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_BPartnerRelation;
	private ForeignEntityInput mC_BPartnerRelation_Location;
	private ForeignEntityInput mC_BPartner_Location;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_BP_Relation_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_BP_RelationInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
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
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within tenant
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
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_BP_Relation_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getC_BP_Relation_UU();
	}

	/**
	 * Set Business Partner.
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
							.setParameters(C_BPartner.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UU " + C_BPartner.getUU());
			}
		} else {
			this.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner.
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
							.setParameters(C_BPartner_Location.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_BPartner_Location_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner_Location with UU " + C_BPartner_Location.getUU());
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
	 * Set Related Partner.
	 *
	 * @param C_BPartnerRelation Related Business Partner
	 */
	@JsonProperty("C_BPartnerRelation")
	public void setC_BPartnerRelationInput(ForeignEntityInput C_BPartnerRelation) {
		this.mC_BPartnerRelation = C_BPartnerRelation;
		if (C_BPartnerRelation != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartner_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(C_BPartnerRelation.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_BPartnerRelation_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UU " + C_BPartnerRelation.getUU());
			}
		} else {
			this.setC_BPartnerRelation_ID(0);
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
		if (C_BPartnerRelation_Location != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartnerLocation foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner_Location", "C_BPartner_Location_UU=?", get_TrxName())
							.setParameters(C_BPartnerRelation_Location.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_BPartnerRelation_Location_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner_Location with UU " + C_BPartnerRelation_Location.getUU());
			}
		} else {
			this.setC_BPartnerRelation_Location_ID(0);
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
