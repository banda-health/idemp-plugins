package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Package_Imp_Proc;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Package_Imp_Proc - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Package_Imp_ProcInput extends X_AD_Package_Imp_Proc implements I_AD_Package_Imp_ProcInput {

	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mAD_Package_Source_Type;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Package_Imp_Proc_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_Package_Imp_ProcInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
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
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
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
	 * Set Package Imp. Proc..
	 *
	 * @param AD_Package_Imp_Proc_ID Package Imp. Proc.
	 */

	public void setAD_Package_Imp_Proc_ID(int AD_Package_Imp_Proc_ID) {
		if (get_ID() == 0) {
			super.setAD_Package_Imp_Proc_ID(AD_Package_Imp_Proc_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_Package_Imp_Proc_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_Package_Imp_Proc_UU();
	}

	/**
	 * Set Package Source Type.
	 *
	 * @param AD_Package_Source_Type Type of package source - file, ftp, webservice etc
	 */
	@JsonProperty("AD_Package_Source_Type")
	public void setAD_Package_Source_TypeInput(I_AD_Ref_ListInput AD_Package_Source_Type) {
		this.mAD_Package_Source_Type = AD_Package_Source_Type;
		if (AD_Package_Source_Type != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(AD_Package_Source_Type.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Package_Source_Type(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + AD_Package_Source_Type.getUUID());
			}
		} else {
			this.setAD_Package_Source_Type(null);
		}
	}

	/**
	 * Get Package Source Type.
	 *
	 * @return Type of package source - file, ftp, webservice etc
	 */
	@JsonProperty("AD_Package_Source_Type")
	public I_AD_Ref_ListInput AD_Package_Source_Type() {
		return mAD_Package_Source_Type;
	}
}
