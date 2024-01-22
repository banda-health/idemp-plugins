package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBHDefaultDocActionAccess;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for BH_Default_DocAction_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_Default_DocAction_AccessInput extends MBHDefaultDocActionAccess implements I_BH_Default_DocAction_AccessInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Ref_List;
	private ForeignEntityInput mC_DocType;
	private I_AD_Ref_ListInput mDB_UserType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_BH_Default_DocAction_AccessInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MBHDefaultDocActionAccess(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Reference List.
	 *
	 * @param AD_Ref_List Reference List based on Table
	 */
	@JsonProperty("AD_Ref_List")
	public void setAD_Ref_ListInput(ForeignEntityInput AD_Ref_List) {
		this.mAD_Ref_List = AD_Ref_List;
		MRefList_BH foreignEntity;
		if (AD_Ref_List != null &&
				(foreignEntity = new Query(getCtx(), "AD_Ref_List", "AD_Ref_List_UU=?", get_TrxName())
						.setParameters(AD_Ref_List.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Ref_List_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Ref_List_ID(0);
		}
	}

	/**
	 * Get Reference List.
	 *
	 * @return Reference List based on Table
	 */
	@JsonProperty("AD_Ref_List")
	public ForeignEntityInput AD_Ref_List() {
		return mAD_Ref_List;
	}
	/**
	 * Set BH_Default_DocAction_Access_ID.
	 *
	 * @param BH_Default_DocAction_Access_ID BH_Default_DocAction_Access_ID
	 */

	public void setBH_Default_DocAction_Access_ID(int BH_Default_DocAction_Access_ID) {
		if (get_ID() == 0) {
			super.setBH_Default_DocAction_Access_ID(BH_Default_DocAction_Access_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setBH_Default_DocAction_Access_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getBH_Default_DocAction_Access_UU();
	}

	/**
	 * Set Document Type.
	 *
	 * @param C_DocType Document type or rules
	 */
	@JsonProperty("C_DocType")
	public void setC_DocTypeInput(ForeignEntityInput C_DocType) {
		this.mC_DocType = C_DocType;
		MDocType_BH foreignEntity;
		if (C_DocType != null &&
				(foreignEntity = new Query(getCtx(), "C_DocType", "C_DocType_UU=?", get_TrxName())
						.setParameters(C_DocType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_DocType_ID(foreignEntity.get_ID());
		} else {
			super.setC_DocType_ID(0);
		}
	}

	/**
	 * Get Document Type.
	 *
	 * @return Document type or rules
	 */
	@JsonProperty("C_DocType")
	public ForeignEntityInput C_DocType() {
		return mC_DocType;
	}

	/**
	 * Set UserType.
	 *
	 * @param DB_UserType The User Type when a new client is created
	 */
	@JsonProperty("DB_UserType")
	public void setDB_UserTypeInput(I_AD_Ref_ListInput DB_UserType) {
		this.mDB_UserType = DB_UserType;
		MRefList_BH foreignEntity;
		if (get_ID() == 0 &&DB_UserType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DB_UserType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDB_UserType(foreignEntity.getValue());
		}
	}

	/**
	 * Get UserType.
	 *
	 * @return The User Type when a new client is created
	 */
	@JsonProperty("DB_UserType")
	public I_AD_Ref_ListInput DB_UserType() {
		return mDB_UserType;
	}
}
