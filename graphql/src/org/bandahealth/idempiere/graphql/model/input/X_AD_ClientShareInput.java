package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MClientShare;
import org.compiere.model.MOrg;
import org.compiere.model.MTable;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for AD_ClientShare - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ClientShareInput extends MClientShare implements I_AD_ClientShareInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Table;
	private I_AD_Ref_ListInput mShareType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_ClientShareInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MClientShare(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}
	/**
	 * Set Client Share.
	 *
	 * @param AD_ClientShare_ID Force (not) sharing of client/org entities
	 */

	public void setAD_ClientShare_ID(int AD_ClientShare_ID) {
		if (get_ID() == 0) {
			super.setAD_ClientShare_ID(AD_ClientShare_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_ClientShare_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_ClientShare_UU();
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
	 * Set Share Type.
	 *
	 * @param ShareType Type of sharing
	 */
	@JsonProperty("ShareType")
	public void setShareTypeInput(I_AD_Ref_ListInput ShareType) {
		this.mShareType = ShareType;
		MRefList_BH foreignEntity;
		if (ShareType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ShareType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setShareType(foreignEntity.getValue());
		} else {
			this.setShareType(null);
		}
	}

	/**
	 * Get Share Type.
	 *
	 * @return Type of sharing
	 */
	@JsonProperty("ShareType")
	public I_AD_Ref_ListInput ShareType() {
		return mShareType;
	}
}
