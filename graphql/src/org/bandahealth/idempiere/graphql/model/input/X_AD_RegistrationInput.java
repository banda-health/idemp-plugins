package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MLocation;
import org.compiere.model.MOrg;
import org.compiere.model.MSystem;
import org.compiere.model.M_Registration;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Registration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_RegistrationInput extends M_Registration implements I_AD_RegistrationInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_System;
	private ForeignEntityInput mC_Currency;
	private ForeignEntityInput mC_Location;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Registration_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_RegistrationInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
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
	 * @return Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}
	/**
	 * Set System Registration.
	 *
	 * @param AD_Registration_ID System Registration
	 */

	public void setAD_Registration_ID(int AD_Registration_ID) {
		if (get_ID() == 0) {
			super.setAD_Registration_ID(AD_Registration_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_Registration_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_Registration_UU();
	}

	/**
	 * Set System.
	 *
	 * @param AD_System System Definition
	 */
	@JsonProperty("AD_System")
	public void setAD_SystemInput(ForeignEntityInput AD_System) {
		this.mAD_System = AD_System;
		if (get_ID() != 0) {
			return;
		}
		if (AD_System != null) {
			// Since an entity was passed, make sure it's in the DB
			MSystem foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_System", "AD_System_UU=?", get_TrxName())
							.setParameters(AD_System.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_System_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_System with UUID " + AD_System.getUUID());
			}
		} else {
			this.setAD_System_ID(0);
		}
	}

	/**
	 * Get System.
	 *
	 * @return System Definition
	 */
	@JsonProperty("AD_System")
	public ForeignEntityInput AD_System() {
		return mAD_System;
	}

	/**
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public void setC_CurrencyInput(ForeignEntityInput C_Currency) {
		this.mC_Currency = C_Currency;
		if (C_Currency != null) {
			// Since an entity was passed, make sure it's in the DB
			MCurrency_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Currency", "C_Currency_UU=?", get_TrxName())
							.setParameters(C_Currency.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Currency_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Currency with UUID " + C_Currency.getUUID());
			}
		} else {
			this.setC_Currency_ID(0);
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
	 * Set Address.
	 *
	 * @param C_Location Location or Address
	 */
	@JsonProperty("C_Location")
	public void setC_LocationInput(ForeignEntityInput C_Location) {
		this.mC_Location = C_Location;
		if (C_Location != null) {
			// Since an entity was passed, make sure it's in the DB
			MLocation foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Location", "C_Location_UU=?", get_TrxName())
							.setParameters(C_Location.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Location_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Location with UUID " + C_Location.getUUID());
			}
		} else {
			this.setC_Location_ID(0);
		}
	}

	/**
	 * Get Address.
	 *
	 * @return Location or Address
	 */
	@JsonProperty("C_Location")
	public ForeignEntityInput C_Location() {
		return mC_Location;
	}
	/**
	 * Set Registered.
	 *
	 * @param IsRegistered The application is registered.
	 */

	public void setIsRegistered(boolean IsRegistered) {
		if (get_ID() == 0) {
			super.setIsRegistered(IsRegistered);
		}
	}
	/**
	 * Set Record ID.
	 *
	 * @param Record_ID Direct internal record ID
	 */

	public void setRecord_ID(int Record_ID) {
		if (get_ID() == 0) {
			super.setRecord_ID(Record_ID);
		}
	}
	/**
	 * Set Remote Addr.
	 *
	 * @param Remote_Addr Remote Address
	 */

	public void setRemote_Addr(String Remote_Addr) {
		if (get_ID() == 0) {
			super.setRemote_Addr(Remote_Addr);
		}
	}
	/**
	 * Set Remote Host.
	 *
	 * @param Remote_Host Remote host Info
	 */

	public void setRemote_Host(String Remote_Host) {
		if (get_ID() == 0) {
			super.setRemote_Host(Remote_Host);
		}
	}
}
