package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_ASP_Level;
import org.compiere.model.X_ASP_Module;

import java.sql.ResultSet;

/**
 * Generated Model for ASP_Level - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_ASP_LevelInput extends X_ASP_Level implements I_ASP_LevelInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mASP_Module;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_ASP_LevelInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_ASP_Level(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set ASP Level.
	 *
	 * @param ASP_Level_ID ASP Level
	 */

	public void setASP_Level_ID(int ASP_Level_ID) {
		if (get_ID() == 0) {
			super.setASP_Level_ID(ASP_Level_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setASP_Level_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getASP_Level_UU();
	}

	/**
	 * Set ASP Module.
	 *
	 * @param ASP_Module ASP Module
	 */
	@JsonProperty("ASP_Module")
	public void setASP_ModuleInput(ForeignEntityInput ASP_Module) {
		this.mASP_Module = ASP_Module;
		X_ASP_Module foreignEntity;
		if (get_ID() == 0 && ASP_Module != null &&
				(foreignEntity = new Query(getCtx(), "ASP_Module", "ASP_Module_UU=?", get_TrxName())
						.setParameters(ASP_Module.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setASP_Module_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get ASP Module.
	 *
	 * @return ASP Module
	 */
	@JsonProperty("ASP_Module")
	public ForeignEntityInput ASP_Module() {
		return mASP_Module;
	}
}
