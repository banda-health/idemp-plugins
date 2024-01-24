package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHEncounterTypeWindow;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for BH_Encounter_Type_Window - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_Encounter_Type_WindowInput extends MBHEncounterTypeWindow implements I_BH_Encounter_Type_WindowInput {

	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mBH_Encounter_Type;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The BH_Encounter_Type_Window_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_BH_Encounter_Type_WindowInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MBHEncounterTypeWindow(null, (ResultSet) null, null),
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
	 * Set Window.
	 *
	 * @param AD_Window_ID Data entry or display window
	 */

	public void setAD_Window_ID(int AD_Window_ID) {
		if (get_ID() == 0) {
			super.setAD_Window_ID(AD_Window_ID);
		}
	}

	/**
	 * Set Encounter Type.
	 *
	 * @param BH_Encounter_Type Encounter Type
	 */
	@JsonProperty("BH_Encounter_Type")
	public void setBH_Encounter_TypeInput(I_AD_Ref_ListInput BH_Encounter_Type) {
		this.mBH_Encounter_Type = BH_Encounter_Type;
		MRefList_BH foreignEntity;
		if (get_ID() == 0 &&BH_Encounter_Type != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_Encounter_Type.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setBH_Encounter_Type(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + BH_Encounter_Type.getUUID());
			}
		}
	}

	/**
	 * Get Encounter Type.
	 *
	 * @return Encounter Type
	 */
	@JsonProperty("BH_Encounter_Type")
	public I_AD_Ref_ListInput BH_Encounter_Type() {
		return mBH_Encounter_Type;
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setBH_Encounter_Type_Window_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getBH_Encounter_Type_Window_UU();
	}
}
