package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MSysConfig_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for AD_SysConfig - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_SysConfigInput extends MSysConfig_BH implements I_AD_SysConfigInput {

	private ForeignEntityInput mAD_EntityType;
	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mConfigurationLevel;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_SysConfigInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MSysConfig_BH(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set System Configurator.
	 *
	 * @param AD_SysConfig_ID System Configurator
	 */

	public void setAD_SysConfig_ID(int AD_SysConfig_ID) {
		if (get_ID() == 0) {
			super.setAD_SysConfig_ID(AD_SysConfig_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_SysConfig_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_SysConfig_UU();
	}

	/**
	 * Set Configuration Level.
	 *
	 * @param ConfigurationLevel Configuration Level for this parameter
	 */
	@JsonProperty("ConfigurationLevel")
	public void setConfigurationLevelInput(I_AD_Ref_ListInput ConfigurationLevel) {
		this.mConfigurationLevel = ConfigurationLevel;
		MRefList_BH foreignEntity;
		if (ConfigurationLevel != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ConfigurationLevel.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setConfigurationLevel(foreignEntity.getValue());
		} else {
			this.setConfigurationLevel(null);
		}
	}

	/**
	 * Get Configuration Level.
	 *
	 * @return Configuration Level for this parameter
	 */
	@JsonProperty("ConfigurationLevel")
	public I_AD_Ref_ListInput ConfigurationLevel() {
		return mConfigurationLevel;
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
