package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MDunningLevel;
import org.compiere.model.MDunningRun;
import org.compiere.model.MDunningRunEntry;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_DunningRunEntry - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_DunningRunEntryInput extends MDunningRunEntry implements I_C_DunningRunEntryInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_BPartner_Location;
	private ForeignEntityInput mC_Currency;
	private ForeignEntityInput mC_DunningLevel;
	private ForeignEntityInput mC_DunningRun;
	private ForeignEntityInput mSalesRep;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_DunningRunEntry_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_DunningRunEntryInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MDunningRunEntry(null, (ResultSet) null, null),
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
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
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
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(ForeignEntityInput AD_User) {
		this.mAD_User = AD_User;
		MUser_BH foreignEntity;
		if (AD_User != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(AD_User.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UUID " + AD_User.getUUID());
			}
		} else {
			super.setAD_User_ID(0);
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
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (C_BPartner != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(C_BPartner.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UUID " + C_BPartner.getUUID());
			}
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
		if (C_BPartner_Location != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner_Location", "C_BPartner_Location_UU=?", get_TrxName())
							.setParameters(C_BPartner_Location.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_BPartner_Location_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner_Location with UUID " + C_BPartner_Location.getUUID());
			}
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
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public void setC_CurrencyInput(ForeignEntityInput C_Currency) {
		this.mC_Currency = C_Currency;
		MCurrency_BH foreignEntity;
		if (C_Currency != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Currency", "C_Currency_UU=?", get_TrxName())
							.setParameters(C_Currency.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Currency_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Currency with UUID " + C_Currency.getUUID());
			}
		} else {
			super.setC_Currency_ID(0);
		}
	}

	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public ForeignEntityInput C_Currency() {
		return mC_Currency;
	}

	/**
	 * Set Dunning Level.
	 *
	 * @param C_DunningLevel Dunning Level
	 */
	@JsonProperty("C_DunningLevel")
	public void setC_DunningLevelInput(ForeignEntityInput C_DunningLevel) {
		this.mC_DunningLevel = C_DunningLevel;
		MDunningLevel foreignEntity;
		if (get_ID() == 0 && C_DunningLevel != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_DunningLevel", "C_DunningLevel_UU=?", get_TrxName())
							.setParameters(C_DunningLevel.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_DunningLevel_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_DunningLevel with UUID " + C_DunningLevel.getUUID());
			}
		}
	}

	/**
	 * Get Dunning Level.
	 *
	 * @return Dunning Level
	 */
	@JsonProperty("C_DunningLevel")
	public ForeignEntityInput C_DunningLevel() {
		return mC_DunningLevel;
	}

	/**
	 * Set Dunning Run.
	 *
	 * @param C_DunningRun Dunning Run
	 */
	@JsonProperty("C_DunningRun")
	public void setC_DunningRunInput(ForeignEntityInput C_DunningRun) {
		this.mC_DunningRun = C_DunningRun;
		MDunningRun foreignEntity;
		if (get_ID() == 0 && C_DunningRun != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_DunningRun", "C_DunningRun_UU=?", get_TrxName())
							.setParameters(C_DunningRun.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_DunningRun_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_DunningRun with UUID " + C_DunningRun.getUUID());
			}
		}
	}

	/**
	 * Get Dunning Run.
	 *
	 * @return Dunning Run
	 */
	@JsonProperty("C_DunningRun")
	public ForeignEntityInput C_DunningRun() {
		return mC_DunningRun;
	}
	/**
	 * Set Dunning Run Entry.
	 *
	 * @param C_DunningRunEntry_ID Dunning Run Entry
	 */

	public void setC_DunningRunEntry_ID(int C_DunningRunEntry_ID) {
		if (get_ID() == 0) {
			super.setC_DunningRunEntry_ID(C_DunningRunEntry_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_DunningRunEntry_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_DunningRunEntry_UU();
	}

	/**
	 * Set Sales Representative.
	 *
	 * @param SalesRep Sales Representative or Company Agent
	 */
	@JsonProperty("SalesRep")
	public void setSalesRepInput(ForeignEntityInput SalesRep) {
		this.mSalesRep = SalesRep;
		MUser_BH foreignEntity;
		if (SalesRep != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(SalesRep.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setSalesRep_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UUID " + SalesRep.getUUID());
			}
		} else {
			super.setSalesRep_ID(0);
		}
	}

	/**
	 * Get Sales Representative.
	 *
	 * @return Sales Representative or Company Agent
	 */
	@JsonProperty("SalesRep")
	public ForeignEntityInput SalesRep() {
		return mSalesRep;
	}
}
