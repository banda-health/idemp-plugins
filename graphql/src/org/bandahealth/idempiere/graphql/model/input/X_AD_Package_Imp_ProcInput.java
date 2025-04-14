package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_AD_Package_Imp_ProcResolver;
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
 * @version Release 13 - $Id$
 */
public class X_AD_Package_Imp_ProcInput extends X_AD_Package_Imp_Proc implements I_AD_Package_Imp_ProcInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Package_Source_Type;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_Package_Imp_Proc_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_Package_Imp_ProcInput(@JsonProperty("UU") String UU) {
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
		if (get_ID() != 0) {
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
	 * Set Package Imp. Proc..
	 *
	 * @param AD_Package_Imp_Proc_ID Package Imp. Proc.
	 */
	@JsonProperty("AD_Package_Imp_Proc_ID")
	public void setAD_Package_Imp_Proc_IDFromJson(int AD_Package_Imp_Proc_ID) {
		if (get_ID() == 0) {
			super.setAD_Package_Imp_Proc_ID(AD_Package_Imp_Proc_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_Package_Imp_Proc_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_Package_Imp_Proc_UU();
	}

	/**
	 * Set Package Source Type.
	 *
	 * @param AD_Package_Source_Type Type of package source - file, ftp, webservice etc
	 */
	@JsonProperty("AD_Package_Source_Type")
	public void setAD_Package_Source_TypeInput(ForeignEntityInput AD_Package_Source_Type) {
		this.mAD_Package_Source_Type = AD_Package_Source_Type;
		if (AD_Package_Source_Type != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_Package_Imp_ProcResolver.AD_PACKAGE_SOURCE_TYPE_UUIDS_BY_VALUE.containsValue(AD_Package_Source_Type.getUU())) {
				throw new AdempiereException("The reference list UU of " + AD_Package_Source_Type.getUU() +
						" is not in the list defined for the AD_Package_Source_Type column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(AD_Package_Source_Type.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Package_Source_Type(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + AD_Package_Source_Type.getUU());
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
	public ForeignEntityInput AD_Package_Source_Type() {
		return mAD_Package_Source_Type;
	}
}
