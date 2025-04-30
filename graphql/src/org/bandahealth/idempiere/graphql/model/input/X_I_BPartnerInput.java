package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MCountry;
import org.compiere.model.MInterestArea;
import org.compiere.model.MOrg;
import org.compiere.model.MRegion;
import org.compiere.model.Query;
import org.compiere.model.X_C_Greeting;
import org.compiere.model.X_I_BPartner;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for I_BPartner - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_I_BPartnerInput extends X_I_BPartner implements I_I_BPartnerInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mC_BP_Group;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_BPartner_Location;
	private ForeignEntityInput mC_Country;
	private ForeignEntityInput mC_Greeting;
	private ForeignEntityInput mC_Region;
	private ForeignEntityInput mR_InterestArea;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The I_BPartner_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_I_BPartnerInput(@JsonProperty("UU") String UU) {
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
		if (!is_new()) {
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
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(ForeignEntityInput AD_User) {
		this.mAD_User = AD_User;
		if (AD_User != null) {
			// Since an entity was passed, make sure it's in the DB
			MUser_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(AD_User.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UU " + AD_User.getUU());
			}
		} else {
			this.setAD_User_ID(0);
		}
	}

	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public ForeignEntityInput AD_User() {
		return mAD_User;
	}

	/**
	 * Set Business Partner Group.
	 *
	 * @param C_BP_Group Business Partner Group
	 */
	@JsonProperty("C_BP_Group")
	public void setC_BP_GroupInput(ForeignEntityInput C_BP_Group) {
		this.mC_BP_Group = C_BP_Group;
		if (C_BP_Group != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPGroup_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BP_Group", "C_BP_Group_UU=?", get_TrxName())
							.setParameters(C_BP_Group.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_BP_Group_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BP_Group with UU " + C_BP_Group.getUU());
			}
		} else {
			this.setC_BP_Group_ID(0);
		}
	}

	/**
	 * Get Business Partner Group.
	 *
	 * @return Business Partner Group
	 */
	@JsonProperty("C_BP_Group")
	public ForeignEntityInput C_BP_Group() {
		return mC_BP_Group;
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
							.setParameters(C_BPartner.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
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
							.setParameters(C_BPartner_Location.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
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
	 * Set Country.
	 *
	 * @param C_Country Country 
	 */
	@JsonProperty("C_Country")
	public void setC_CountryInput(ForeignEntityInput C_Country) {
		this.mC_Country = C_Country;
		if (C_Country != null) {
			// Since an entity was passed, make sure it's in the DB
			MCountry foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Country", "C_Country_UU=?", get_TrxName())
							.setParameters(C_Country.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Country_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Country with UU " + C_Country.getUU());
			}
		} else {
			this.setC_Country_ID(0);
		}
	}

	/**
	 * Get Country.
	 *
	 * @return Country 
	 */
	@JsonProperty("C_Country")
	public ForeignEntityInput C_Country() {
		return mC_Country;
	}

	/**
	 * Set Greeting.
	 *
	 * @param C_Greeting Greeting to print on correspondence
	 */
	@JsonProperty("C_Greeting")
	public void setC_GreetingInput(ForeignEntityInput C_Greeting) {
		this.mC_Greeting = C_Greeting;
		if (C_Greeting != null) {
			// Since an entity was passed, make sure it's in the DB
			X_C_Greeting foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Greeting", "C_Greeting_UU=?", get_TrxName())
							.setParameters(C_Greeting.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Greeting_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Greeting with UU " + C_Greeting.getUU());
			}
		} else {
			this.setC_Greeting_ID(0);
		}
	}

	/**
	 * Get Greeting.
	 *
	 * @return Greeting to print on correspondence
	 */
	@JsonProperty("C_Greeting")
	public ForeignEntityInput C_Greeting() {
		return mC_Greeting;
	}

	/**
	 * Set Region.
	 *
	 * @param C_Region Identifies a geographical Region
	 */
	@JsonProperty("C_Region")
	public void setC_RegionInput(ForeignEntityInput C_Region) {
		this.mC_Region = C_Region;
		if (C_Region != null) {
			// Since an entity was passed, make sure it's in the DB
			MRegion foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Region", "C_Region_UU=?", get_TrxName())
							.setParameters(C_Region.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Region_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Region with UU " + C_Region.getUU());
			}
		} else {
			this.setC_Region_ID(0);
		}
	}

	/**
	 * Get Region.
	 *
	 * @return Identifies a geographical Region
	 */
	@JsonProperty("C_Region")
	public ForeignEntityInput C_Region() {
		return mC_Region;
	}
	/**
	 * Set Import Business Partner.
	 *
	 * @param I_BPartner_ID Import Business Partner
	 */
	@JsonProperty("I_BPartner_ID")
	public void setI_BPartner_IDFromJson(int I_BPartner_ID) {
		if (get_ID() == 0) {
			super.setI_BPartner_ID(I_BPartner_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setI_BPartner_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getI_BPartner_UU();
	}
	/**
	 * Set Processed.
	 *
	 * @param Processed The document has been processed
	 */
	@JsonProperty("Processed")
	public void setProcessedFromJson(boolean Processed) {
		if (get_ID() == 0) {
			super.setProcessed(Processed);
		}
	}

	/**
	 * Set Interest Area.
	 *
	 * @param R_InterestArea Interest Area or Topic
	 */
	@JsonProperty("R_InterestArea")
	public void setR_InterestAreaInput(ForeignEntityInput R_InterestArea) {
		this.mR_InterestArea = R_InterestArea;
		if (R_InterestArea != null) {
			// Since an entity was passed, make sure it's in the DB
			MInterestArea foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "R_InterestArea", "R_InterestArea_UU=?", get_TrxName())
							.setParameters(R_InterestArea.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setR_InterestArea_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_InterestArea with UU " + R_InterestArea.getUU());
			}
		} else {
			this.setR_InterestArea_ID(0);
		}
	}

	/**
	 * Get Interest Area.
	 *
	 * @return Interest Area or Topic
	 */
	@JsonProperty("R_InterestArea")
	public ForeignEntityInput R_InterestArea() {
		return mR_InterestArea;
	}
}
