package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_AD_ImportTemplateResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MImportTemplate;
import org.compiere.model.MOrg;
import org.compiere.model.MTab;
import org.compiere.model.MWindow;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_ImportTemplate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_ImportTemplateInput extends MImportTemplate implements I_AD_ImportTemplateInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Tab;
	private ForeignEntityInput mAD_Window;
	private ForeignEntityInput mImportTemplateType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_ImportTemplate_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_ImportTemplateInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}
	/**
	 * Set Import Template.
	 *
	 * @param AD_ImportTemplate_ID Import Template
	 */
	@JsonProperty("AD_ImportTemplate_ID")
	public void setAD_ImportTemplate_IDFromJson(int AD_ImportTemplate_ID) {
		if (get_ID() == 0) {
			super.setAD_ImportTemplate_ID(AD_ImportTemplate_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_ImportTemplate_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_ImportTemplate_UU();
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
	 * Set Tab.
	 *
	 * @param AD_Tab Tab within a Window
	 */
	@JsonProperty("AD_Tab")
	public void setAD_TabInput(ForeignEntityInput AD_Tab) {
		this.mAD_Tab = AD_Tab;
		if (AD_Tab != null) {
			// Since an entity was passed, make sure it's in the DB
			MTab foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Tab", "AD_Tab_UU=?", get_TrxName())
							.setParameters(AD_Tab.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Tab_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Tab with UU " + AD_Tab.getUU());
			}
		} else {
			this.setAD_Tab_ID(0);
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
	 * Set Window.
	 *
	 * @param AD_Window Data entry or display window
	 */
	@JsonProperty("AD_Window")
	public void setAD_WindowInput(ForeignEntityInput AD_Window) {
		this.mAD_Window = AD_Window;
		if (AD_Window != null) {
			// Since an entity was passed, make sure it's in the DB
			MWindow foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Window", "AD_Window_UU=?", get_TrxName())
							.setParameters(AD_Window.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Window_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Window with UU " + AD_Window.getUU());
			}
		} else {
			this.setAD_Window_ID(0);
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
	 * Set Import Template Type.
	 *
	 * @param ImportTemplateType Import Template Type
	 */
	@JsonProperty("ImportTemplateType")
	public void setImportTemplateTypeInput(ForeignEntityInput ImportTemplateType) {
		this.mImportTemplateType = ImportTemplateType;
		if (ImportTemplateType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_ImportTemplateResolver.IMPORTTEMPLATETYPE_UUIDS_BY_VALUE.containsValue(ImportTemplateType.getUU())) {
				throw new AdempiereException("The reference list UU of " + ImportTemplateType.getUU() +
						" is not in the list defined for the ImportTemplateType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ImportTemplateType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setImportTemplateType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + ImportTemplateType.getUU());
			}
		} else {
			this.setImportTemplateType(null);
		}
	}

	/**
	 * Get Import Template Type.
	 *
	 * @return Import Template Type
	 */
	@JsonProperty("ImportTemplateType")
	public ForeignEntityInput ImportTemplateType() {
		return mImportTemplateType;
	}
}
