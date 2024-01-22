package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.MStyle;
import org.compiere.model.Query;
import org.compiere.model.X_AD_StyleLine;

import java.sql.ResultSet;

/**
 * Generated Model for AD_StyleLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_StyleLineInput extends X_AD_StyleLine implements I_AD_StyleLineInput {

	private ForeignEntityInput mAD_EntityType;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Style;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_StyleLineInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_AD_StyleLine(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Style.
	 *
	 * @param AD_Style CSS style for field and label
	 */
	@JsonProperty("AD_Style")
	public void setAD_StyleInput(ForeignEntityInput AD_Style) {
		this.mAD_Style = AD_Style;
		MStyle foreignEntity;
		if (get_ID() == 0 && AD_Style != null &&
				(foreignEntity = new Query(getCtx(), "AD_Style", "AD_Style_UU=?", get_TrxName())
						.setParameters(AD_Style.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Style_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Style.
	 *
	 * @return CSS style for field and label
	 */
	@JsonProperty("AD_Style")
	public ForeignEntityInput AD_Style() {
		return mAD_Style;
	}
	/**
	 * Set Style Line.
	 *
	 * @param AD_StyleLine_ID CSS Style Line
	 */

	public void setAD_StyleLine_ID(int AD_StyleLine_ID) {
		if (get_ID() == 0) {
			super.setAD_StyleLine_ID(AD_StyleLine_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID CSS Style Line
	 */
	public void setID(String ID) {
		setAD_StyleLine_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return CSS Style Line
	 */
	public String getID() {
		return getAD_StyleLine_UU();
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
