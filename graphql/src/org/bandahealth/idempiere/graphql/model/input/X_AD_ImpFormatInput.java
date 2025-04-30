package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_AD_ImpFormatResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MTable;
import org.compiere.model.Query;
import org.compiere.model.X_AD_ImpFormat;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_ImpFormat - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_ImpFormatInput extends X_AD_ImpFormat implements I_AD_ImpFormatInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Table;
	private ForeignEntityInput mFormatType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_ImpFormat_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_ImpFormatInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}
	/**
	 * Set Import Format.
	 *
	 * @param AD_ImpFormat_ID Import Format
	 */
	@JsonProperty("AD_ImpFormat_ID")
	public void setAD_ImpFormat_IDFromJson(int AD_ImpFormat_ID) {
		if (get_ID() == 0) {
			super.setAD_ImpFormat_ID(AD_ImpFormat_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_ImpFormat_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_ImpFormat_UU();
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
	 * Set Table.
	 *
	 * @param AD_Table Database Table information
	 */
	@JsonProperty("AD_Table")
	public void setAD_TableInput(ForeignEntityInput AD_Table) {
		this.mAD_Table = AD_Table;
		if (AD_Table != null) {
			// Since an entity was passed, make sure it's in the DB
			MTable foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Table", "AD_Table_UU=?", get_TrxName())
							.setParameters(AD_Table.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Table_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Table with UU " + AD_Table.getUU());
			}
		} else {
			this.setAD_Table_ID(0);
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
	 * Set Format.
	 *
	 * @param FormatType Format of the data
	 */
	@JsonProperty("FormatType")
	public void setFormatTypeInput(ForeignEntityInput FormatType) {
		this.mFormatType = FormatType;
		if (FormatType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_ImpFormatResolver.FORMATTYPE_UUIDS_BY_VALUE.containsValue(FormatType.getUU())) {
				throw new AdempiereException("The reference list UU of " + FormatType.getUU() +
						" is not in the list defined for the FormatType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(FormatType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setFormatType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + FormatType.getUU());
			}
		} else {
			this.setFormatType(null);
		}
	}

	/**
	 * Get Format.
	 *
	 * @return Format of the data
	 */
	@JsonProperty("FormatType")
	public ForeignEntityInput FormatType() {
		return mFormatType;
	}
}
