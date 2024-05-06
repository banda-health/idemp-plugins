package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MForm;
import org.compiere.model.MInfoWindow;
import org.compiere.model.MOrg;
import org.compiere.model.MPreference;
import org.compiere.model.MWindow;
import org.compiere.model.Query;
import org.compiere.model.X_AD_AllUsers_V;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Preference - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_PreferenceInput extends MPreference implements I_AD_PreferenceInput {

	private ForeignEntityInput mAD_Form;
	private ForeignEntityInput mAD_InfoWindow;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Process;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mAD_Window;
	private ForeignEntityInput mPreferenceFor;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_Preference_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_PreferenceInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Special Form.
	 *
	 * @param AD_Form Special Form
	 */
	@JsonProperty("AD_Form")
	public void setAD_FormInput(ForeignEntityInput AD_Form) {
		this.mAD_Form = AD_Form;
		if (AD_Form != null) {
			// Since an entity was passed, make sure it's in the DB
			MForm foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Form", "AD_Form_UU=?", get_TrxName())
							.setParameters(AD_Form.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Form_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Form with UU " + AD_Form.getUU());
			}
		} else {
			this.setAD_Form_ID(0);
		}
	}

	/**
	 * Get Special Form.
	 *
	 * @return Special Form
	 */
	@JsonProperty("AD_Form")
	public ForeignEntityInput AD_Form() {
		return mAD_Form;
	}

	/**
	 * Set Info Window.
	 *
	 * @param AD_InfoWindow Info and search/select Window
	 */
	@JsonProperty("AD_InfoWindow")
	public void setAD_InfoWindowInput(ForeignEntityInput AD_InfoWindow) {
		this.mAD_InfoWindow = AD_InfoWindow;
		if (AD_InfoWindow != null) {
			// Since an entity was passed, make sure it's in the DB
			MInfoWindow foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_InfoWindow", "AD_InfoWindow_UU=?", get_TrxName())
							.setParameters(AD_InfoWindow.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_InfoWindow_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_InfoWindow with UU " + AD_InfoWindow.getUU());
			}
		} else {
			this.setAD_InfoWindow_ID(0);
		}
	}

	/**
	 * Get Info Window.
	 *
	 * @return Info and search/select Window
	 */
	@JsonProperty("AD_InfoWindow")
	public ForeignEntityInput AD_InfoWindow() {
		return mAD_InfoWindow;
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
	 * Set Preference.
	 *
	 * @param AD_Preference_ID Personal Value Preference
	 */

	public void setAD_Preference_ID(int AD_Preference_ID) {
		if (get_ID() == 0) {
			super.setAD_Preference_ID(AD_Preference_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_Preference_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_Preference_UU();
	}

	/**
	 * Set Process.
	 *
	 * @param AD_Process Process or Report
	 */
	@JsonProperty("AD_Process")
	public void setAD_ProcessInput(ForeignEntityInput AD_Process) {
		this.mAD_Process = AD_Process;
		if (AD_Process != null) {
			// Since an entity was passed, make sure it's in the DB
			MProcess_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Process", "AD_Process_UU=?", get_TrxName())
							.setParameters(AD_Process.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Process_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Process with UU " + AD_Process.getUU());
			}
		} else {
			this.setAD_Process_ID(0);
		}
	}

	/**
	 * Get Process.
	 *
	 * @return Process or Report
	 */
	@JsonProperty("AD_Process")
	public ForeignEntityInput AD_Process() {
		return mAD_Process;
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
			X_AD_AllUsers_V foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_AllUsers_V", "AD_AllUsers_V_UU=?", get_TrxName())
							.setParameters(AD_User.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_AllUsers_V with UU " + AD_User.getUU());
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
	 * Set Window.
	 *
	 * @param AD_Window Data entry or display window
	 */
	@JsonProperty("AD_Window")
	public void setAD_WindowInput(ForeignEntityInput AD_Window) {
		this.mAD_Window = AD_Window;
		if (AD_Window != null) {
			// Since an entity was passed, make sure it's in the DB
			MWindow foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Window", "AD_Window_UU=?", get_TrxName())
							.setParameters(AD_Window.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Window_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Window with UU " + AD_Window.getUU());
			}
		} else {
			this.setAD_Window_ID(0);
		}
	}

	/**
	 * Get Window.
	 *
	 * @return Data entry or display window
	 */
	@JsonProperty("AD_Window")
	public ForeignEntityInput AD_Window() {
		return mAD_Window;
	}

	/**
	 * Set Preference For.
	 *
	 * @param PreferenceFor Type of preference, it can window, info window or parameter process
	 */
	@JsonProperty("PreferenceFor")
	public void setPreferenceForInput(ForeignEntityInput PreferenceFor) {
		this.mPreferenceFor = PreferenceFor;
		if (PreferenceFor != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PreferenceFor.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setPreferenceFor(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + PreferenceFor.getUU());
			}
		} else {
			this.setPreferenceFor(null);
		}
	}

	/**
	 * Get Preference For.
	 *
	 * @return Type of preference, it can window, info window or parameter process
	 */
	@JsonProperty("PreferenceFor")
	public ForeignEntityInput PreferenceFor() {
		return mPreferenceFor;
	}
}
