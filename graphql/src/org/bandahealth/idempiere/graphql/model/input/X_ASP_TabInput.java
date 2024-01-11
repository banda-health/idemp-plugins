package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MTab;
import org.compiere.model.Query;
import org.compiere.model.X_ASP_Tab;
import org.compiere.model.X_ASP_Window;

import java.sql.ResultSet;

/**
 * Generated Model for ASP_Tab - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_ASP_TabInput extends X_ASP_Tab implements I_ASP_TabInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Tab;
	private ForeignEntityInput mASP_Window;
	private I_AD_Ref_ListInput mASP_Status;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_ASP_TabInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_ASP_Tab(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Tab.
	 *
	 * @param AD_Tab Tab within a Window
	 */
	@JsonProperty("AD_Tab")
	public void setAD_TabInput(ForeignEntityInput AD_Tab) {
		this.mAD_Tab = AD_Tab;
		MTab foreignEntity;
		if (get_ID() == 0 && AD_Tab != null &&
				(foreignEntity = new Query(getCtx(), "AD_Tab", "AD_Tab_UU=?", get_TrxName())
						.setParameters(AD_Tab.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Tab_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Tab.
	 *
	 * @return Tab within a Window
	 */
	@JsonProperty("AD_Tab")
	public ForeignEntityInput AD_Tab() {
		return mAD_Tab;
	}

	/**
	 * Set ASP Status.
	 *
	 * @param ASP_Status ASP Status
	 */
	@JsonProperty("ASP_Status")
	public void setASP_StatusInput(I_AD_Ref_ListInput ASP_Status) {
		this.mASP_Status = ASP_Status;
		MRefList_BH foreignEntity;
		if (ASP_Status != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ASP_Status.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setASP_Status(foreignEntity.getValue());
		} else {
			this.setASP_Status(null);
		}
	}

	/**
	 * Get ASP Status.
	 *
	 * @return ASP Status
	 */
	@JsonProperty("ASP_Status")
	public I_AD_Ref_ListInput ASP_Status() {
		return mASP_Status;
	}
	/**
	 * Set ASP Tab.
	 *
	 * @param ASP_Tab_ID ASP Tab
	 */

	public void setASP_Tab_ID(int ASP_Tab_ID) {
		if (get_ID() == 0) {
			super.setASP_Tab_ID(ASP_Tab_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setASP_Tab_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getASP_Tab_UU();
	}

	/**
	 * Set ASP Window.
	 *
	 * @param ASP_Window ASP Window
	 */
	@JsonProperty("ASP_Window")
	public void setASP_WindowInput(ForeignEntityInput ASP_Window) {
		this.mASP_Window = ASP_Window;
		X_ASP_Window foreignEntity;
		if (get_ID() == 0 && ASP_Window != null &&
				(foreignEntity = new Query(getCtx(), "ASP_Window", "ASP_Window_UU=?", get_TrxName())
						.setParameters(ASP_Window.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setASP_Window_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get ASP Window.
	 *
	 * @return ASP Window
	 */
	@JsonProperty("ASP_Window")
	public ForeignEntityInput ASP_Window() {
		return mASP_Window;
	}
}
