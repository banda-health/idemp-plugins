package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHDefaultDocActionAccess;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_BH_Default_DocAction_AccessResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for BH_Default_DocAction_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Default_DocAction_AccessInput extends MBHDefaultDocActionAccess implements I_BH_Default_DocAction_AccessInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Ref_List;
	private ForeignEntityInput mC_DocType;
	private ForeignEntityInput mDB_UserType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The BH_Default_DocAction_Access_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_BH_Default_DocAction_AccessInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (!is_new()) {
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
	 * Set Reference List.
	 *
	 * @param AD_Ref_List Reference List based on Table
	 */
	@JsonProperty("AD_Ref_List")
	public void setAD_Ref_ListInput(ForeignEntityInput AD_Ref_List) {
		this.mAD_Ref_List = AD_Ref_List;
		if (AD_Ref_List != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Ref_List", "AD_Ref_List_UU=?", get_TrxName())
							.setParameters(AD_Ref_List.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Ref_List_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Ref_List with UU " + AD_Ref_List.getUU());
			}
		} else {
			this.setAD_Ref_List_ID(0);
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
	@JsonProperty("BH_Default_DocAction_Access_ID")
	public void setBH_Default_DocAction_Access_IDFromJson(int BH_Default_DocAction_Access_ID) {
		if (get_ID() == 0) {
			super.setBH_Default_DocAction_Access_ID(BH_Default_DocAction_Access_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setBH_Default_DocAction_Access_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
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
		if (C_DocType != null) {
			// Since an entity was passed, make sure it's in the DB
			MDocType_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_DocType", "C_DocType_UU=?", get_TrxName())
							.setParameters(C_DocType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_DocType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_DocType with UU " + C_DocType.getUU());
			}
		} else {
			this.setC_DocType_ID(-1);
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
	public void setDB_UserTypeInput(ForeignEntityInput DB_UserType) {
		this.mDB_UserType = DB_UserType;
		if (!is_new()) {
			return;
		}
		if (DB_UserType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_BH_Default_DocAction_AccessResolver.DB_USERTYPE_UUIDS_BY_VALUE.containsValue(DB_UserType.getUU())) {
				throw new AdempiereException("The reference list UU of " + DB_UserType.getUU() +
						" is not in the list defined for the DB_UserType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DB_UserType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setDB_UserType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + DB_UserType.getUU());
			}
		} else {
			this.setDB_UserType(null);
		}
	}

	/**
	 * Get UserType.
	 *
	 * @return The User Type when a new client is created
	 */
	@JsonProperty("DB_UserType")
	public ForeignEntityInput DB_UserType() {
		return mDB_UserType;
	}
}
