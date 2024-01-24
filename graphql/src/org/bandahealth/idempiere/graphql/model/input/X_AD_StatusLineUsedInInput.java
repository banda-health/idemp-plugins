package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.MStatusLine;
import org.compiere.model.MStatusLineUsedIn;
import org.compiere.model.MTab;
import org.compiere.model.MTable;
import org.compiere.model.MWindow;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for AD_StatusLineUsedIn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_StatusLineUsedInInput extends MStatusLineUsedIn implements I_AD_StatusLineUsedInInput {

	private ForeignEntityInput mAD_EntityType;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_StatusLine;
	private ForeignEntityInput mAD_Tab;
	private ForeignEntityInput mAD_Table;
	private ForeignEntityInput mAD_Window;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_StatusLineUsedInInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MStatusLineUsedIn(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Status Line.
	 *
	 * @param AD_StatusLine Status Line
	 */
	@JsonProperty("AD_StatusLine")
	public void setAD_StatusLineInput(ForeignEntityInput AD_StatusLine) {
		this.mAD_StatusLine = AD_StatusLine;
		MStatusLine foreignEntity;
		if (get_ID() == 0 && AD_StatusLine != null &&
				(foreignEntity = new Query(getCtx(), "AD_StatusLine", "AD_StatusLine_UU=?", get_TrxName())
						.setParameters(AD_StatusLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_StatusLine_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Status Line.
	 *
	 * @return Status Line
	 */
	@JsonProperty("AD_StatusLine")
	public ForeignEntityInput AD_StatusLine() {
		return mAD_StatusLine;
	}
	/**
	 * Set AD_StatusLineUsedIn.
	 *
	 * @param AD_StatusLineUsedIn_ID AD_StatusLineUsedIn
	 */

	public void setAD_StatusLineUsedIn_ID(int AD_StatusLineUsedIn_ID) {
		if (get_ID() == 0) {
			super.setAD_StatusLineUsedIn_ID(AD_StatusLineUsedIn_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_StatusLineUsedIn_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_StatusLineUsedIn_UU();
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
		if (AD_Tab != null &&
				(foreignEntity = new Query(getCtx(), "AD_Tab", "AD_Tab_UU=?", get_TrxName())
						.setParameters(AD_Tab.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Tab_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Tab_ID(0);
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
	 * Set Table.
	 *
	 * @param AD_Table Database Table information
	 */
	@JsonProperty("AD_Table")
	public void setAD_TableInput(ForeignEntityInput AD_Table) {
		this.mAD_Table = AD_Table;
		MTable foreignEntity;
		if (AD_Table != null &&
				(foreignEntity = new Query(getCtx(), "AD_Table", "AD_Table_UU=?", get_TrxName())
						.setParameters(AD_Table.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Table_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Table_ID(0);
		}
	}

	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	@JsonProperty("AD_Table")
	public ForeignEntityInput AD_Table() {
		return mAD_Table;
	}

	/**
	 * Set Window.
	 *
	 * @param AD_Window Data entry or display window
	 */
	@JsonProperty("AD_Window")
	public void setAD_WindowInput(ForeignEntityInput AD_Window) {
		this.mAD_Window = AD_Window;
		MWindow foreignEntity;
		if (AD_Window != null &&
				(foreignEntity = new Query(getCtx(), "AD_Window", "AD_Window_UU=?", get_TrxName())
						.setParameters(AD_Window.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Window_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Window_ID(0);
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
	 * Set Entity Type.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public void setAD_EntityTypeInput(ForeignEntityInput AD_EntityType) {
		this.mAD_EntityType = AD_EntityType;
		MEntityType foreignEntity;
		if (AD_EntityType != null &&
				(foreignEntity = new Query(getCtx(), "AD_EntityType", "AD_EntityType_UU=?", get_TrxName())
						.setParameters(AD_EntityType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setEntityType(foreignEntity.getEntityType());
		} else {
			super.setEntityType(null);
		}
	}

	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public ForeignEntityInput AD_EntityType() {
		return mAD_EntityType;
	}
}
