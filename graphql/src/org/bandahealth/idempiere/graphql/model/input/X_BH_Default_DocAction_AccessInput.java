package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHDefaultDocActionAccess;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for BH_Default_DocAction_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_Default_DocAction_AccessInput extends MBHDefaultDocActionAccess implements I_BH_Default_DocAction_AccessInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Ref_List;
	private ForeignEntityInput mC_DocType;
	private I_AD_Ref_ListInput mDB_UserType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The BH_Default_DocAction_Access_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_BH_Default_DocAction_AccessInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MBHDefaultDocActionAccess(null, (ResultSet) null, null),
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
	 * Set Reference List.
	 *
	 * @param AD_Ref_List Reference List based on Table
	 */
	@JsonProperty("AD_Ref_List")
	public void setAD_Ref_ListInput(ForeignEntityInput AD_Ref_List) {
		this.mAD_Ref_List = AD_Ref_List;
		MRefList_BH foreignEntity;
		if (AD_Ref_List != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Ref_List", "AD_Ref_List_UU=?", get_TrxName())
							.setParameters(AD_Ref_List.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Ref_List_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Ref_List with UUID " + AD_Ref_List.getUUID());
			}
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setBH_Default_DocAction_Access_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		if (C_DocType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_DocType", "C_DocType_UU=?", get_TrxName())
							.setParameters(C_DocType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_DocType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_DocType with UUID " + C_DocType.getUUID());
			}
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
		if (get_ID() == 0 &&DB_UserType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DB_UserType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setDB_UserType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + DB_UserType.getUUID());
			}
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
