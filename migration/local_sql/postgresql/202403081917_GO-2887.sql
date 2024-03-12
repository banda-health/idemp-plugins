-- This is meant to schematically sync the 7.1 PROD DB with the seed DB

ALTER TABLE ad_alertprocessor
	DROP CONSTRAINT IF EXISTS aduser_calertprocessor;
ALTER TABLE ad_alertprocessor
	ADD CONSTRAINT aduser_calertprocessor
		FOREIGN KEY (supervisor_id) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_alertprocessor
	DROP CONSTRAINT IF EXISTS adschedule_adalertprocessor;
ALTER TABLE ad_alertprocessor
	ADD CONSTRAINT adschedule_adalertprocessor
		FOREIGN KEY (ad_schedule_id) REFERENCES ad_schedule
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_alertprocessorlog
	DROP CONSTRAINT IF EXISTS calertprocessor_log;
ALTER TABLE ad_alertprocessorlog
	ADD CONSTRAINT calertprocessor_log
		FOREIGN KEY (ad_alertprocessor_id) REFERENCES ad_alertprocessor
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_client
	DROP CONSTRAINT IF EXISTS adlangu_adclient;
ALTER TABLE ad_client
	ADD CONSTRAINT adlangu_adclient
		FOREIGN KEY (ad_language) REFERENCES ad_language
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_client
	DROP CONSTRAINT IF EXISTS adreplicationstrategy_adclient;
ALTER TABLE ad_client
	ADD CONSTRAINT adreplicationstrategy_adclient
		FOREIGN KEY (ad_replicationstrategy_id) REFERENCES ad_replicationstrategy
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_client
	DROP CONSTRAINT IF EXISTS adpasswordrule_adclient;
ALTER TABLE ad_client
	ADD CONSTRAINT adpasswordrule_adclient
		FOREIGN KEY (ad_passwordrule_id) REFERENCES ad_passwordrule
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_role
	DROP CONSTRAINT IF EXISTS c_currency_ad_role;
ALTER TABLE ad_role
	ADD CONSTRAINT c_currency_ad_role
		FOREIGN KEY (c_currency_id) REFERENCES c_currency
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_role
	DROP CONSTRAINT IF EXISTS adtree_adrole;
ALTER TABLE ad_role
	ADD CONSTRAINT adtree_adrole
		FOREIGN KEY (ad_tree_menu_id) REFERENCES ad_tree
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_role
	DROP CONSTRAINT IF EXISTS adtreeorg_adrole;
ALTER TABLE ad_role
	ADD CONSTRAINT adtreeorg_adrole
		FOREIGN KEY (ad_tree_org_id) REFERENCES ad_tree
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_role
	DROP CONSTRAINT IF EXISTS adusersupervisor_adrole;
ALTER TABLE ad_role
	ADD CONSTRAINT adusersupervisor_adrole
		FOREIGN KEY (supervisor_id) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_role
	DROP CONSTRAINT IF EXISTS ad_roleorg;
ALTER TABLE ad_role
	ADD CONSTRAINT ad_roleorg
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_role
	DROP CONSTRAINT IF EXISTS ad_roleclient;
ALTER TABLE ad_role
	ADD CONSTRAINT ad_roleclient
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_user_roles
	DROP CONSTRAINT IF EXISTS aduser_userroles;
ALTER TABLE ad_user_roles
	ADD CONSTRAINT aduser_userroles
		FOREIGN KEY (ad_user_id) REFERENCES ad_user
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_user_roles
	DROP CONSTRAINT IF EXISTS adrole_aduserroles;
ALTER TABLE ad_user_roles
	ADD CONSTRAINT adrole_aduserroles
		FOREIGN KEY (ad_role_id) REFERENCES ad_role
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_user_roles
	DROP CONSTRAINT IF EXISTS ad_userrolesorg;
ALTER TABLE ad_user_roles
	ADD CONSTRAINT ad_userrolesorg
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_user_roles
	DROP CONSTRAINT IF EXISTS ad_userrolesclient;
ALTER TABLE ad_user_roles
	ADD CONSTRAINT ad_userrolesclient
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_user
	DROP CONSTRAINT IF EXISTS bplocation_aduser;
ALTER TABLE ad_user
	ADD CONSTRAINT bplocation_aduser
		FOREIGN KEY (bp_location_id) REFERENCES c_location
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_user
	DROP CONSTRAINT IF EXISTS clocation_aduser;
ALTER TABLE ad_user
	ADD CONSTRAINT clocation_aduser
		FOREIGN KEY (c_location_id) REFERENCES c_location
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_user
	DROP CONSTRAINT IF EXISTS cbpartner_aduser;
ALTER TABLE ad_user
	ADD CONSTRAINT cbpartner_aduser
		FOREIGN KEY (c_bpartner_id) REFERENCES c_bpartner
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_user
	DROP CONSTRAINT IF EXISTS aduser_supervisor;
ALTER TABLE ad_user
	ADD CONSTRAINT aduser_supervisor
		FOREIGN KEY (supervisor_id) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_user
	DROP CONSTRAINT IF EXISTS salesrep_aduser;
ALTER TABLE ad_user
	ADD CONSTRAINT salesrep_aduser
		FOREIGN KEY (salesrep_id) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_user
	DROP CONSTRAINT IF EXISTS cbplocation_aduser;
ALTER TABLE ad_user
	ADD CONSTRAINT cbplocation_aduser
		FOREIGN KEY (c_bpartner_location_id) REFERENCES c_bpartner_location
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_user
	DROP CONSTRAINT IF EXISTS adimage_aduser;
ALTER TABLE ad_user
	ADD CONSTRAINT adimage_aduser
		FOREIGN KEY (ad_image_id) REFERENCES ad_image
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_user
	DROP CONSTRAINT IF EXISTS rdefaultmailtext_aduser;
ALTER TABLE ad_user
	ADD CONSTRAINT rdefaultmailtext_aduser
		FOREIGN KEY (r_defaultmailtext_id) REFERENCES r_mailtext
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_user
	DROP CONSTRAINT IF EXISTS ad_user_org;
ALTER TABLE ad_user
	ADD CONSTRAINT ad_user_org
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_user
	DROP CONSTRAINT IF EXISTS adorgtrx_aduser;
ALTER TABLE ad_user
	ADD CONSTRAINT adorgtrx_aduser
		FOREIGN KEY (ad_orgtrx_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_user
	DROP CONSTRAINT IF EXISTS cjob_aduser;
ALTER TABLE ad_user
	ADD CONSTRAINT cjob_aduser
		FOREIGN KEY (c_job_id) REFERENCES c_job
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_user
	DROP CONSTRAINT IF EXISTS ad_user_client;
ALTER TABLE ad_user
	ADD CONSTRAINT ad_user_client
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_user
	DROP CONSTRAINT IF EXISTS ccampaign_aduser;
ALTER TABLE ad_user
	ADD CONSTRAINT ccampaign_aduser
		FOREIGN KEY (c_campaign_id) REFERENCES c_campaign
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_user
	DROP CONSTRAINT IF EXISTS cgreeting_aduser;
ALTER TABLE ad_user
	ADD CONSTRAINT cgreeting_aduser
		FOREIGN KEY (c_greeting_id) REFERENCES c_greeting
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_attachment
	DROP CONSTRAINT IF EXISTS adtable_adattachment;
ALTER TABLE ad_attachment
	ADD CONSTRAINT adtable_adattachment
		FOREIGN KEY (ad_table_id) REFERENCES ad_table
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_changelog
	DROP CONSTRAINT IF EXISTS adcolumn_adchangelog;
ALTER TABLE ad_changelog
	ADD CONSTRAINT adcolumn_adchangelog
		FOREIGN KEY (ad_column_id) REFERENCES ad_column
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_changelog
	DROP CONSTRAINT IF EXISTS adtable_adchangelog;
ALTER TABLE ad_changelog
	ADD CONSTRAINT adtable_adchangelog
		FOREIGN KEY (ad_table_id) REFERENCES ad_table
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_changelog
	DROP CONSTRAINT IF EXISTS adsession_adchangelog;
ALTER TABLE ad_changelog
	ADD CONSTRAINT adsession_adchangelog
		FOREIGN KEY (ad_session_id) REFERENCES ad_session
			DEFERRABLE INITIALLY DEFERRED;

UPDATE ad_column
SET
	fkconstraintname = 'ADClient_BHRoleWarehouseAccess'
WHERE
	ad_column_uu = 'e5f74d71-b7da-4e7b-ab50-f391ab20b3c2';
UPDATE ad_column
SET
	fkconstraintname = 'ADOrg_BHRoleWarehouseAccess'
WHERE
	ad_column_uu = 'f409c5cb-1192-4431-bc39-195e8886d15b';

CREATE UNIQUE INDEX IF NOT EXISTS ad_column_fkconstraintname
	ON ad_column (UPPER(fkconstraintname::text));

ALTER TABLE ad_column
	DROP CONSTRAINT IF EXISTS ad_element_ad_column;
ALTER TABLE ad_column
	ADD CONSTRAINT ad_element_ad_column
		FOREIGN KEY (ad_element_id) REFERENCES ad_element
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_column
	DROP CONSTRAINT IF EXISTS ad_table_column;
ALTER TABLE ad_column
	ADD CONSTRAINT ad_table_column
		FOREIGN KEY (ad_table_id) REFERENCES ad_table
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_column
	DROP CONSTRAINT IF EXISTS adprocess_adcolumn;
ALTER TABLE ad_column
	ADD CONSTRAINT adprocess_adcolumn
		FOREIGN KEY (ad_process_id) REFERENCES ad_process
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_column
	DROP CONSTRAINT IF EXISTS ad_valrule_column;
ALTER TABLE ad_column
	ADD CONSTRAINT ad_valrule_column
		FOREIGN KEY (ad_val_rule_id) REFERENCES ad_val_rule
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_column
	DROP CONSTRAINT IF EXISTS ad_reference_columndatatype;
ALTER TABLE ad_column
	ADD CONSTRAINT ad_reference_columndatatype
		FOREIGN KEY (ad_reference_id) REFERENCES ad_reference
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_column
	DROP CONSTRAINT IF EXISTS ad_reference_columnvalue;
ALTER TABLE ad_column
	ADD CONSTRAINT ad_reference_columnvalue
		FOREIGN KEY (ad_reference_value_id) REFERENCES ad_reference
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_column
	DROP CONSTRAINT IF EXISTS entityt_adcolumn;
ALTER TABLE ad_column
	ADD CONSTRAINT entityt_adcolumn
		FOREIGN KEY (entitytype) REFERENCES ad_entitytype
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_column
	DROP CONSTRAINT IF EXISTS padashboardcontent_adcolumn;
ALTER TABLE ad_column
	ADD CONSTRAINT padashboardcontent_adcolumn
		FOREIGN KEY (pa_dashboardcontent_id) REFERENCES pa_dashboardcontent
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_column
	DROP CONSTRAINT IF EXISTS columnorg;
ALTER TABLE ad_column
	ADD CONSTRAINT columnorg
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_column
	DROP CONSTRAINT IF EXISTS adchart_adcolumn;
ALTER TABLE ad_column
	ADD CONSTRAINT adchart_adcolumn
		FOREIGN KEY (ad_chart_id) REFERENCES ad_chart
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_column
	DROP CONSTRAINT IF EXISTS columnclient;
ALTER TABLE ad_column
	ADD CONSTRAINT columnclient
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS mproductfreight_adclientinfo;
ALTER TABLE ad_clientinfo
	ADD CONSTRAINT mproductfreight_adclientinfo
		FOREIGN KEY (m_productfreight_id) REFERENCES m_product
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS cbpartnercashtrx_adclientinfo;
ALTER TABLE ad_clientinfo
	ADD CONSTRAINT cbpartnercashtrx_adclientinfo
		FOREIGN KEY (c_bpartnercashtrx_id) REFERENCES c_bpartner
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS adtreeactivity_adclientinfo;
ALTER TABLE ad_clientinfo
	ADD CONSTRAINT adtreeactivity_adclientinfo
		FOREIGN KEY (ad_tree_activity_id) REFERENCES ad_tree
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS adtreebpartner_adclientinfo;
ALTER TABLE ad_clientinfo
	ADD CONSTRAINT adtreebpartner_adclientinfo
		FOREIGN KEY (ad_tree_bpartner_id) REFERENCES ad_tree
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS adtreecampaign_adclientinfo;
ALTER TABLE ad_clientinfo
	ADD CONSTRAINT adtreecampaign_adclientinfo
		FOREIGN KEY (ad_tree_campaign_id) REFERENCES ad_tree
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS adtreemenu_adclientinfo;
ALTER TABLE ad_clientinfo
	ADD CONSTRAINT adtreemenu_adclientinfo
		FOREIGN KEY (ad_tree_menu_id) REFERENCES ad_tree
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS adtreeorg_adclientinfo;
ALTER TABLE ad_clientinfo
	ADD CONSTRAINT adtreeorg_adclientinfo
		FOREIGN KEY (ad_tree_org_id) REFERENCES ad_tree
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS adtreeproduct_adclientinfo;
ALTER TABLE ad_clientinfo
	ADD CONSTRAINT adtreeproduct_adclientinfo
		FOREIGN KEY (ad_tree_product_id) REFERENCES ad_tree
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS adtreeproject_adclientinfo;
ALTER TABLE ad_clientinfo
	ADD CONSTRAINT adtreeproject_adclientinfo
		FOREIGN KEY (ad_tree_project_id) REFERENCES ad_tree
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS adtreesalesreg_adclientinfo;
ALTER TABLE ad_clientinfo
	ADD CONSTRAINT adtreesalesreg_adclientinfo
		FOREIGN KEY (ad_tree_salesregion_id) REFERENCES ad_tree
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS c_uom_length_ad_clientinfo;
ALTER TABLE ad_clientinfo
	ADD CONSTRAINT c_uom_length_ad_clientinfo
		FOREIGN KEY (c_uom_length_id) REFERENCES c_uom
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS c_uom_time_ad_clientinfo;
ALTER TABLE ad_clientinfo
	ADD CONSTRAINT c_uom_time_ad_clientinfo
		FOREIGN KEY (c_uom_time_id) REFERENCES c_uom
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS c_uom_volume_ad_clientinfo;
ALTER TABLE ad_clientinfo
	ADD CONSTRAINT c_uom_volume_ad_clientinfo
		FOREIGN KEY (c_uom_volume_id) REFERENCES c_uom
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS c_uom_weight_ad_clientinfo;
ALTER TABLE ad_clientinfo
	ADD CONSTRAINT c_uom_weight_ad_clientinfo
		FOREIGN KEY (c_uom_weight_id) REFERENCES c_uom
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS logo_adclientinfo;
ALTER TABLE ad_clientinfo
	ADD CONSTRAINT logo_adclientinfo
		FOREIGN KEY (logo_id) REFERENCES ad_image
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS logoreport_adclientinfo;
ALTER TABLE ad_clientinfo
	ADD CONSTRAINT logoreport_adclientinfo
		FOREIGN KEY (logoreport_id) REFERENCES ad_image
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS logoweb_adclientinfo;
ALTER TABLE ad_clientinfo
	ADD CONSTRAINT logoweb_adclientinfo
		FOREIGN KEY (logoweb_id) REFERENCES ad_image
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS adclient_adclientinfo;
ALTER TABLE ad_clientinfo
	ADD CONSTRAINT adclient_adclientinfo
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS cchargefreight_adclientinfo;
ALTER TABLE ad_clientinfo
	ADD CONSTRAINT cchargefreight_adclientinfo
		FOREIGN KEY (c_chargefreight_id) REFERENCES c_charge
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS cacctschema1_adclientinfo;
ALTER TABLE ad_clientinfo
	ADD CONSTRAINT cacctschema1_adclientinfo
		FOREIGN KEY (c_acctschema1_id) REFERENCES c_acctschema
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS ccalendar_adclientinfo;
ALTER TABLE ad_clientinfo
	ADD CONSTRAINT ccalendar_adclientinfo
		FOREIGN KEY (c_calendar_id) REFERENCES c_calendar
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS adstorageprovider_adclientinfo;
ALTER TABLE ad_clientinfo
	ADD CONSTRAINT adstorageprovider_adclientinfo
		FOREIGN KEY (ad_storageprovider_id) REFERENCES ad_storageprovider
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS storagearchive_adclientinfo;
ALTER TABLE ad_clientinfo
	ADD CONSTRAINT storagearchive_adclientinfo
		FOREIGN KEY (storagearchive_id) REFERENCES ad_storageprovider
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS storageimage_adclientinfo;
ALTER TABLE ad_clientinfo
	ADD CONSTRAINT storageimage_adclientinfo
		FOREIGN KEY (storageimage_id) REFERENCES ad_storageprovider
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_column_trl
	DROP CONSTRAINT IF EXISTS adcolumn_adcolumntrl;
ALTER TABLE ad_column_trl
	ADD CONSTRAINT adcolumn_adcolumntrl
		FOREIGN KEY (ad_column_id) REFERENCES ad_column
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_column_trl
	DROP CONSTRAINT IF EXISTS adlanguage_adcolumntrl;
ALTER TABLE ad_column_trl
	ADD CONSTRAINT adlanguage_adcolumntrl
		FOREIGN KEY (ad_language) REFERENCES ad_language
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_document_action_access
	DROP CONSTRAINT IF EXISTS adreflist_addocumentactionacce;
ALTER TABLE ad_document_action_access
	ADD CONSTRAINT adreflist_addocumentactionacce
		FOREIGN KEY (ad_ref_list_id) REFERENCES ad_ref_list
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_document_action_access
	DROP CONSTRAINT IF EXISTS cdoctype_addocumentactionacces;
ALTER TABLE ad_document_action_access
	ADD CONSTRAINT cdoctype_addocumentactionacces
		FOREIGN KEY (c_doctype_id) REFERENCES c_doctype
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_document_action_access
	DROP CONSTRAINT IF EXISTS adrole_addocumentactionaccess;
ALTER TABLE ad_document_action_access
	ADD CONSTRAINT adrole_addocumentactionaccess
		FOREIGN KEY (ad_role_id) REFERENCES ad_role
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_element
	DROP CONSTRAINT IF EXISTS entityt_adelement;
ALTER TABLE ad_element
	ADD CONSTRAINT entityt_adelement
		FOREIGN KEY (entitytype) REFERENCES ad_entitytype
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_element_trl
	DROP CONSTRAINT IF EXISTS adelement_adelementtrl;
ALTER TABLE ad_element_trl
	ADD CONSTRAINT adelement_adelementtrl
		FOREIGN KEY (ad_element_id) REFERENCES ad_element
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_element_trl
	DROP CONSTRAINT IF EXISTS ad_language_ad_element_trl;
ALTER TABLE ad_element_trl
	ADD CONSTRAINT ad_language_ad_element_trl
		FOREIGN KEY (ad_language) REFERENCES ad_language
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_field
	DROP CONSTRAINT IF EXISTS ad_tab_field;
ALTER TABLE ad_field
	ADD CONSTRAINT ad_tab_field
		FOREIGN KEY (ad_tab_id) REFERENCES ad_tab
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_field
	DROP CONSTRAINT IF EXISTS includedtab_adfield;
ALTER TABLE ad_field
	ADD CONSTRAINT includedtab_adfield
		FOREIGN KEY (included_tab_id) REFERENCES ad_tab
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_field
	DROP CONSTRAINT IF EXISTS advalrule_adfield;
ALTER TABLE ad_field
	ADD CONSTRAINT advalrule_adfield
		FOREIGN KEY (ad_val_rule_id) REFERENCES ad_val_rule
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_field
	DROP CONSTRAINT IF EXISTS adreference_adfield;
ALTER TABLE ad_field
	ADD CONSTRAINT adreference_adfield
		FOREIGN KEY (ad_reference_id) REFERENCES ad_reference
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_field
	DROP CONSTRAINT IF EXISTS adreferencevalue_adfield;
ALTER TABLE ad_field
	ADD CONSTRAINT adreferencevalue_adfield
		FOREIGN KEY (ad_reference_value_id) REFERENCES ad_reference
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_field
	DROP CONSTRAINT IF EXISTS ad_column_field;
ALTER TABLE ad_field
	ADD CONSTRAINT ad_column_field
		FOREIGN KEY (ad_column_id) REFERENCES ad_column
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_field
	DROP CONSTRAINT IF EXISTS adfieldgroup_adfield;
ALTER TABLE ad_field
	ADD CONSTRAINT adfieldgroup_adfield
		FOREIGN KEY (ad_fieldgroup_id) REFERENCES ad_fieldgroup
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_field
	DROP CONSTRAINT IF EXISTS entityt_adfield;
ALTER TABLE ad_field
	ADD CONSTRAINT entityt_adfield
		FOREIGN KEY (entitytype) REFERENCES ad_entitytype
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_field
	DROP CONSTRAINT IF EXISTS fieldorg;
ALTER TABLE ad_field
	ADD CONSTRAINT fieldorg
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_field
	DROP CONSTRAINT IF EXISTS fieldclient;
ALTER TABLE ad_field
	ADD CONSTRAINT fieldclient
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_field
	DROP CONSTRAINT IF EXISTS adfieldstyle_adfield;
ALTER TABLE ad_field
	ADD CONSTRAINT adfieldstyle_adfield
		FOREIGN KEY (ad_fieldstyle_id) REFERENCES ad_style
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_field
	DROP CONSTRAINT IF EXISTS adlabelstyle_adfield;
ALTER TABLE ad_field
	ADD CONSTRAINT adlabelstyle_adfield
		FOREIGN KEY (ad_labelstyle_id) REFERENCES ad_style
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_field_trl
	DROP CONSTRAINT IF EXISTS ad_fieldtrl;
ALTER TABLE ad_field_trl
	ADD CONSTRAINT ad_fieldtrl
		FOREIGN KEY (ad_field_id) REFERENCES ad_field
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_field_trl
	DROP CONSTRAINT IF EXISTS ad_language_fieldtrl;
ALTER TABLE ad_field_trl
	ADD CONSTRAINT ad_language_fieldtrl
		FOREIGN KEY (ad_language) REFERENCES ad_language
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_form_access
	DROP CONSTRAINT IF EXISTS adform_adformaccess;
ALTER TABLE ad_form_access
	ADD CONSTRAINT adform_adformaccess
		FOREIGN KEY (ad_form_id) REFERENCES ad_form
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_form_access
	DROP CONSTRAINT IF EXISTS adrole_adformaccess;
ALTER TABLE ad_form_access
	ADD CONSTRAINT adrole_adformaccess
		FOREIGN KEY (ad_role_id) REFERENCES ad_role
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_housekeeping
	DROP CONSTRAINT IF EXISTS adtable_adhousekeeping;
ALTER TABLE ad_housekeeping
	ADD CONSTRAINT adtable_adhousekeeping
		FOREIGN KEY (ad_table_id) REFERENCES ad_table
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_infocolumn
	DROP CONSTRAINT IF EXISTS adelement_adinfocolumn;
ALTER TABLE ad_infocolumn
	ADD CONSTRAINT adelement_adinfocolumn
		FOREIGN KEY (ad_element_id) REFERENCES ad_element
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_infocolumn
	DROP CONSTRAINT IF EXISTS adreference_adinfocolumn;
ALTER TABLE ad_infocolumn
	ADD CONSTRAINT adreference_adinfocolumn
		FOREIGN KEY (ad_reference_id) REFERENCES ad_reference
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_infocolumn
	DROP CONSTRAINT IF EXISTS adreferencevalue_adinfocolumn;
ALTER TABLE ad_infocolumn
	ADD CONSTRAINT adreferencevalue_adinfocolumn
		FOREIGN KEY (ad_reference_value_id) REFERENCES ad_reference
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_infocolumn
	DROP CONSTRAINT IF EXISTS advalrule_adinfocolumn;
ALTER TABLE ad_infocolumn
	ADD CONSTRAINT advalrule_adinfocolumn
		FOREIGN KEY (ad_val_rule_id) REFERENCES ad_val_rule
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_infocolumn
	DROP CONSTRAINT IF EXISTS adinfowindow_adinfocolumn;
ALTER TABLE ad_infocolumn
	ADD CONSTRAINT adinfowindow_adinfocolumn
		FOREIGN KEY (ad_infowindow_id) REFERENCES ad_infowindow
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_infocolumn
	DROP CONSTRAINT IF EXISTS entityt_adinfocolumn;
ALTER TABLE ad_infocolumn
	ADD CONSTRAINT entityt_adinfocolumn
		FOREIGN KEY (entitytype) REFERENCES ad_entitytype
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_infocolumn
	DROP CONSTRAINT IF EXISTS adfieldstyle_adinfocolumn;
ALTER TABLE ad_infocolumn
	ADD CONSTRAINT adfieldstyle_adinfocolumn
		FOREIGN KEY (ad_fieldstyle_id) REFERENCES ad_style
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_infowindow_access
	DROP CONSTRAINT IF EXISTS adinfowindow_adinfowindowacces;
ALTER TABLE ad_infowindow_access
	ADD CONSTRAINT adinfowindow_adinfowindowacces
		FOREIGN KEY (ad_infowindow_id) REFERENCES ad_infowindow
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_infowindow_access
	DROP CONSTRAINT IF EXISTS adrole_adinfowindowaccess;
ALTER TABLE ad_infowindow_access
	ADD CONSTRAINT adrole_adinfowindowaccess
		FOREIGN KEY (ad_role_id) REFERENCES ad_role
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_issue
	DROP CONSTRAINT IF EXISTS adprocess_adissue;
ALTER TABLE ad_issue
	ADD CONSTRAINT adprocess_adissue
		FOREIGN KEY (ad_process_id) REFERENCES ad_process
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_issue
	DROP CONSTRAINT IF EXISTS adwindow_adissue;
ALTER TABLE ad_issue
	ADD CONSTRAINT adwindow_adissue
		FOREIGN KEY (ad_window_id) REFERENCES ad_window
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_issue
	DROP CONSTRAINT IF EXISTS adform_adissue;
ALTER TABLE ad_issue
	ADD CONSTRAINT adform_adissue
		FOREIGN KEY (ad_form_id) REFERENCES ad_form
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_issue
	DROP CONSTRAINT IF EXISTS rrequest_adissue;
ALTER TABLE ad_issue
	ADD CONSTRAINT rrequest_adissue
		FOREIGN KEY (r_request_id) REFERENCES r_request
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_issue
	DROP CONSTRAINT IF EXISTS aasset_adissue;
ALTER TABLE ad_issue
	ADD CONSTRAINT aasset_adissue
		FOREIGN KEY (a_asset_id) REFERENCES a_asset
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_issue
	DROP CONSTRAINT IF EXISTS rknownissue_adissue;
ALTER TABLE ad_issue
	ADD CONSTRAINT rknownissue_adissue
		FOREIGN KEY (r_issueknown_id) REFERENCES r_issueknown
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_issue
	DROP CONSTRAINT IF EXISTS rissueproject_adissue;
ALTER TABLE ad_issue
	ADD CONSTRAINT rissueproject_adissue
		FOREIGN KEY (r_issueproject_id) REFERENCES r_issueproject
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_issue
	DROP CONSTRAINT IF EXISTS rissuesystem_ad_issue;
ALTER TABLE ad_issue
	ADD CONSTRAINT rissuesystem_ad_issue
		FOREIGN KEY (r_issuesystem_id) REFERENCES r_issuesystem
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_issue
	DROP CONSTRAINT IF EXISTS rissueuser_adissue;
ALTER TABLE ad_issue
	ADD CONSTRAINT rissueuser_adissue
		FOREIGN KEY (r_issueuser_id) REFERENCES r_issueuser
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_menu
	DROP CONSTRAINT IF EXISTS adprocess_admenu;
ALTER TABLE ad_menu
	ADD CONSTRAINT adprocess_admenu
		FOREIGN KEY (ad_process_id) REFERENCES ad_process
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_menu
	DROP CONSTRAINT IF EXISTS adwindow_admenu;
ALTER TABLE ad_menu
	ADD CONSTRAINT adwindow_admenu
		FOREIGN KEY (ad_window_id) REFERENCES ad_window
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_menu
	DROP CONSTRAINT IF EXISTS adworkflow_admenu;
ALTER TABLE ad_menu
	ADD CONSTRAINT adworkflow_admenu
		FOREIGN KEY (ad_workflow_id) REFERENCES ad_workflow
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_menu
	DROP CONSTRAINT IF EXISTS adform_admenu;
ALTER TABLE ad_menu
	ADD CONSTRAINT adform_admenu
		FOREIGN KEY (ad_form_id) REFERENCES ad_form
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_menu
	DROP CONSTRAINT IF EXISTS entityt_admenu;
ALTER TABLE ad_menu
	ADD CONSTRAINT entityt_admenu
		FOREIGN KEY (entitytype) REFERENCES ad_entitytype
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_menu
	DROP CONSTRAINT IF EXISTS adinfowindow_admenu;
ALTER TABLE ad_menu
	ADD CONSTRAINT adinfowindow_admenu
		FOREIGN KEY (ad_infowindow_id) REFERENCES ad_infowindow
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_menu
	DROP CONSTRAINT IF EXISTS ad_menu_org;
ALTER TABLE ad_menu
	ADD CONSTRAINT ad_menu_org
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_menu
	DROP CONSTRAINT IF EXISTS adtask_admenu;
ALTER TABLE ad_menu
	ADD CONSTRAINT adtask_admenu
		FOREIGN KEY (ad_task_id) REFERENCES ad_task
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_menu
	DROP CONSTRAINT IF EXISTS adclient_admenu;
ALTER TABLE ad_menu
	ADD CONSTRAINT adclient_admenu
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_menu
	DROP CONSTRAINT IF EXISTS admenu_adworkbench;
ALTER TABLE ad_menu
	ADD CONSTRAINT admenu_adworkbench
		FOREIGN KEY (ad_workbench_id) REFERENCES ad_workbench
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_menu_trl
	DROP CONSTRAINT IF EXISTS ad_menutrl;
ALTER TABLE ad_menu_trl
	ADD CONSTRAINT ad_menutrl
		FOREIGN KEY (ad_menu_id) REFERENCES ad_menu
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_menu_trl
	DROP CONSTRAINT IF EXISTS ad_language_menutrl;
ALTER TABLE ad_menu_trl
	ADD CONSTRAINT ad_language_menutrl
		FOREIGN KEY (ad_language) REFERENCES ad_language
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_note
	DROP CONSTRAINT IF EXISTS admessage_adnote;
ALTER TABLE ad_note
	ADD CONSTRAINT admessage_adnote
		FOREIGN KEY (ad_message_id) REFERENCES ad_message
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_note
	DROP CONSTRAINT IF EXISTS adtable_adnote;
ALTER TABLE ad_note
	ADD CONSTRAINT adtable_adnote
		FOREIGN KEY (ad_table_id) REFERENCES ad_table
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_note
	DROP CONSTRAINT IF EXISTS aduser_adnote;
ALTER TABLE ad_note
	ADD CONSTRAINT aduser_adnote
		FOREIGN KEY (ad_user_id) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_note
	DROP CONSTRAINT IF EXISTS adwfactivity_adnote;
ALTER TABLE ad_note
	ADD CONSTRAINT adwfactivity_adnote
		FOREIGN KEY (ad_wf_activity_id) REFERENCES ad_wf_activity
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_note
	DROP CONSTRAINT IF EXISTS adbroadcastmessage_adnote;
ALTER TABLE ad_note
	ADD CONSTRAINT adbroadcastmessage_adnote
		FOREIGN KEY (ad_broadcastmessage_id) REFERENCES ad_broadcastmessage
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_org
	DROP CONSTRAINT IF EXISTS ad_org__ad_repli_ad_replica;
ALTER TABLE ad_org
	ADD CONSTRAINT ad_org__ad_repli_ad_replica
		FOREIGN KEY (ad_replicationstrategy_id) REFERENCES ad_replicationstrategy
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_org
	DROP CONSTRAINT IF EXISTS adclient_adorg;
ALTER TABLE ad_org
	ADD CONSTRAINT adclient_adorg
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_orginfo
	DROP CONSTRAINT IF EXISTS c_location_ad_orginfo;
ALTER TABLE ad_orginfo
	ADD CONSTRAINT c_location_ad_orginfo
		FOREIGN KEY (c_location_id) REFERENCES c_location
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_orginfo
	DROP CONSTRAINT IF EXISTS dropshipwarehouse_adorginfo;
ALTER TABLE ad_orginfo
	ADD CONSTRAINT dropshipwarehouse_adorginfo
		FOREIGN KEY (dropship_warehouse_id) REFERENCES m_warehouse
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_orginfo
	DROP CONSTRAINT IF EXISTS mwarehouse_adorginfo;
ALTER TABLE ad_orginfo
	ADD CONSTRAINT mwarehouse_adorginfo
		FOREIGN KEY (m_warehouse_id) REFERENCES m_warehouse
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_orginfo
	DROP CONSTRAINT IF EXISTS aduser_adorginfo;
ALTER TABLE ad_orginfo
	ADD CONSTRAINT aduser_adorginfo
		FOREIGN KEY (supervisor_id) REFERENCES ad_user
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_orginfo
	DROP CONSTRAINT IF EXISTS adorg_adorginfo;
ALTER TABLE ad_orginfo
	ADD CONSTRAINT adorg_adorginfo
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_orginfo
	DROP CONSTRAINT IF EXISTS adorgparent_adorginfo;
ALTER TABLE ad_orginfo
	ADD CONSTRAINT adorgparent_adorginfo
		FOREIGN KEY (parent_org_id) REFERENCES ad_org
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_orginfo
	DROP CONSTRAINT IF EXISTS adorgtype_adorginfo;
ALTER TABLE ad_orginfo
	ADD CONSTRAINT adorgtype_adorginfo
		FOREIGN KEY (ad_orgtype_id) REFERENCES ad_orgtype
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_orginfo
	DROP CONSTRAINT IF EXISTS cbank_adorginfo;
ALTER TABLE ad_orginfo
	ADD CONSTRAINT cbank_adorginfo
		FOREIGN KEY (transferbank_id) REFERENCES c_bank
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_orginfo
	DROP CONSTRAINT IF EXISTS ccashbook_adorginfo;
ALTER TABLE ad_orginfo
	ADD CONSTRAINT ccashbook_adorginfo
		FOREIGN KEY (transfercashbook_id) REFERENCES c_cashbook
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_orginfo
	DROP CONSTRAINT IF EXISTS ccalendar_adorginfo;
ALTER TABLE ad_orginfo
	ADD CONSTRAINT ccalendar_adorginfo
		FOREIGN KEY (c_calendar_id) REFERENCES c_calendar
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS ad_language_c_buspartner;
ALTER TABLE c_bpartner
	ADD CONSTRAINT ad_language_c_buspartner
		FOREIGN KEY (ad_language) REFERENCES ad_language
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS adprintformatinv_cbpartner;
ALTER TABLE c_bpartner
	ADD CONSTRAINT adprintformatinv_cbpartner
		FOREIGN KEY (invoice_printformat_id) REFERENCES ad_printformat
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS cbpartner_cpbartnerparent;
ALTER TABLE c_bpartner
	ADD CONSTRAINT cbpartner_cpbartnerparent
		FOREIGN KEY (bpartner_parent_id) REFERENCES c_bpartner
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS adusersalesrep_cbpartner;
ALTER TABLE c_bpartner
	ADD CONSTRAINT adusersalesrep_cbpartner
		FOREIGN KEY (salesrep_id) REFERENCES ad_user
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS logo_cbpartner;
ALTER TABLE c_bpartner
	ADD CONSTRAINT logo_cbpartner
		FOREIGN KEY (logo_id) REFERENCES ad_image
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS adorg_cbpartner;
ALTER TABLE c_bpartner
	ADD CONSTRAINT adorg_cbpartner
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS adorg_cbpartnerorg;
ALTER TABLE c_bpartner
	ADD CONSTRAINT adorg_cbpartnerorg
		FOREIGN KEY (ad_orgbp_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS cpaymentterm_cbpartner;
ALTER TABLE c_bpartner
	ADD CONSTRAINT cpaymentterm_cbpartner
		FOREIGN KEY (c_paymentterm_id) REFERENCES c_paymentterm
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS cpopaymentterm_cbpartner;
ALTER TABLE c_bpartner
	ADD CONSTRAINT cpopaymentterm_cbpartner
		FOREIGN KEY (po_paymentterm_id) REFERENCES c_paymentterm
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS mpricelist_cbpartner;
ALTER TABLE c_bpartner
	ADD CONSTRAINT mpricelist_cbpartner
		FOREIGN KEY (m_pricelist_id) REFERENCES m_pricelist
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS mpricelistpo_cbuspartner;
ALTER TABLE c_bpartner
	ADD CONSTRAINT mpricelistpo_cbuspartner
		FOREIGN KEY (po_pricelist_id) REFERENCES m_pricelist
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS mdiscounts_cbpartner;
ALTER TABLE c_bpartner
	ADD CONSTRAINT mdiscounts_cbpartner
		FOREIGN KEY (m_discountschema_id) REFERENCES m_discountschema
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS mdiscountspo_cbpartner;
ALTER TABLE c_bpartner
	ADD CONSTRAINT mdiscountspo_cbpartner
		FOREIGN KEY (po_discountschema_id) REFERENCES m_discountschema
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS cbpgroup_cbpartner;
ALTER TABLE c_bpartner
	ADD CONSTRAINT cbpgroup_cbpartner
		FOREIGN KEY (c_bp_group_id) REFERENCES c_bp_group
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS adclient_cbpartner;
ALTER TABLE c_bpartner
	ADD CONSTRAINT adclient_cbpartner
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS cdunning_cbpartner;
ALTER TABLE c_bpartner
	ADD CONSTRAINT cdunning_cbpartner
		FOREIGN KEY (c_dunning_id) REFERENCES c_dunning
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS cinvoiceschedule_cbpartner;
ALTER TABLE c_bpartner
	ADD CONSTRAINT cinvoiceschedule_cbpartner
		FOREIGN KEY (c_invoiceschedule_id) REFERENCES c_invoiceschedule
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS cgreeting_cbpartner;
ALTER TABLE c_bpartner
	ADD CONSTRAINT cgreeting_cbpartner
		FOREIGN KEY (c_greeting_id) REFERENCES c_greeting
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS default1099box_cbpartner;
ALTER TABLE c_bpartner
	ADD CONSTRAINT default1099box_cbpartner
		FOREIGN KEY (default1099box_id) REFERENCES c_1099box
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS ctaxgroup_cbpartner;
ALTER TABLE c_bpartner
	ADD CONSTRAINT ctaxgroup_cbpartner
		FOREIGN KEY (c_taxgroup_id) REFERENCES c_taxgroup
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_package_imp
	DROP CONSTRAINT IF EXISTS adpackageimpproc_adpackageimp;
ALTER TABLE ad_package_imp
	ADD CONSTRAINT adpackageimpproc_adpackageimp
		FOREIGN KEY (ad_package_imp_proc_id) REFERENCES ad_package_imp_proc
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_package_imp_backup
	DROP CONSTRAINT IF EXISTS adcolumn_adpackageimpbackup;
ALTER TABLE ad_package_imp_backup
	ADD CONSTRAINT adcolumn_adpackageimpbackup
		FOREIGN KEY (ad_column_id) REFERENCES ad_column
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_package_imp_backup
	DROP CONSTRAINT IF EXISTS adreference_adpackageimpbackup;
ALTER TABLE ad_package_imp_backup
	ADD CONSTRAINT adreference_adpackageimpbackup
		FOREIGN KEY (ad_reference_id) REFERENCES ad_reference
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_package_imp_detail
	DROP CONSTRAINT IF EXISTS adtable_adpackageimpdetail;
ALTER TABLE ad_package_imp_detail
	ADD CONSTRAINT adtable_adpackageimpdetail
		FOREIGN KEY (ad_table_id) REFERENCES ad_table
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_package_imp_detail
	DROP CONSTRAINT IF EXISTS adpackageimp_adpackageimpdetai;
ALTER TABLE ad_package_imp_detail
	ADD CONSTRAINT adpackageimp_adpackageimpdetai
		FOREIGN KEY (ad_package_imp_id) REFERENCES ad_package_imp
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_pinstance
	DROP CONSTRAINT IF EXISTS adprocess_adpinstance;
ALTER TABLE ad_pinstance
	ADD CONSTRAINT adprocess_adpinstance
		FOREIGN KEY (ad_process_id) REFERENCES ad_process
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_pinstance
	DROP CONSTRAINT IF EXISTS adlanguage_adpinstance;
ALTER TABLE ad_pinstance
	ADD CONSTRAINT adlanguage_adpinstance
		FOREIGN KEY (ad_language_id) REFERENCES ad_language (ad_language_id)
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_pinstance
	DROP CONSTRAINT IF EXISTS adprintformat_adpinstance;
ALTER TABLE ad_pinstance
	ADD CONSTRAINT adprintformat_adpinstance
		FOREIGN KEY (ad_printformat_id) REFERENCES ad_printformat
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_pinstance
	DROP CONSTRAINT IF EXISTS aduser_pinstance;
ALTER TABLE ad_pinstance
	ADD CONSTRAINT aduser_pinstance
		FOREIGN KEY (ad_user_id) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_pinstance_log
	DROP CONSTRAINT IF EXISTS adtable_adpinstancelog;
ALTER TABLE ad_pinstance_log
	ADD CONSTRAINT adtable_adpinstancelog
		FOREIGN KEY (ad_table_id) REFERENCES ad_table
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_pinstance_log
	DROP CONSTRAINT IF EXISTS adpinstance_pilog;
ALTER TABLE ad_pinstance_log
	ADD CONSTRAINT adpinstance_pilog
		FOREIGN KEY (ad_pinstance_id) REFERENCES ad_pinstance
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_pinstance_para
	DROP CONSTRAINT IF EXISTS adpinstance_adpinstancepara;
ALTER TABLE ad_pinstance_para
	ADD CONSTRAINT adpinstance_adpinstancepara
		FOREIGN KEY (ad_pinstance_id) REFERENCES ad_pinstance
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_preference
	DROP CONSTRAINT IF EXISTS ad_process_preference;
ALTER TABLE ad_preference
	ADD CONSTRAINT ad_process_preference
		FOREIGN KEY (ad_process_id) REFERENCES ad_process
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_preference
	DROP CONSTRAINT IF EXISTS ad_window_preference;
ALTER TABLE ad_preference
	ADD CONSTRAINT ad_window_preference
		FOREIGN KEY (ad_window_id) REFERENCES ad_window
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_preference
	DROP CONSTRAINT IF EXISTS ad_infowindow_preference;
ALTER TABLE ad_preference
	ADD CONSTRAINT ad_infowindow_preference
		FOREIGN KEY (ad_infowindow_id) REFERENCES ad_infowindow
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_preference
	DROP CONSTRAINT IF EXISTS ad_user_preference;
ALTER TABLE ad_preference
	ADD CONSTRAINT ad_user_preference
		FOREIGN KEY (ad_user_id) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_preference
	DROP CONSTRAINT IF EXISTS ad_preference_org;
ALTER TABLE ad_preference
	ADD CONSTRAINT ad_preference_org
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_preference
	DROP CONSTRAINT IF EXISTS ad_preference_client;
ALTER TABLE ad_preference
	ADD CONSTRAINT ad_preference_client
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_printform
	DROP CONSTRAINT IF EXISTS adprintformat_forminvoice;
ALTER TABLE ad_printform
	ADD CONSTRAINT adprintformat_forminvoice
		FOREIGN KEY (invoice_printformat_id) REFERENCES ad_printformat
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_printform
	DROP CONSTRAINT IF EXISTS adprintformat_formorder;
ALTER TABLE ad_printform
	ADD CONSTRAINT adprintformat_formorder
		FOREIGN KEY (order_printformat_id) REFERENCES ad_printformat
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_printform
	DROP CONSTRAINT IF EXISTS adprintformat_formproject;
ALTER TABLE ad_printform
	ADD CONSTRAINT adprintformat_formproject
		FOREIGN KEY (project_printformat_id) REFERENCES ad_printformat
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_printform
	DROP CONSTRAINT IF EXISTS adprintformat_formremittance;
ALTER TABLE ad_printform
	ADD CONSTRAINT adprintformat_formremittance
		FOREIGN KEY (remittance_printformat_id) REFERENCES ad_printformat
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_printform
	DROP CONSTRAINT IF EXISTS adprintformat_formshipment;
ALTER TABLE ad_printform
	ADD CONSTRAINT adprintformat_formshipment
		FOREIGN KEY (shipment_printformat_id) REFERENCES ad_printformat
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_printform
	DROP CONSTRAINT IF EXISTS distriborderprintformat_adprin;
ALTER TABLE ad_printform
	ADD CONSTRAINT distriborderprintformat_adprin
		FOREIGN KEY (distrib_order_printformat_id) REFERENCES ad_printformat
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_printform
	DROP CONSTRAINT IF EXISTS manuforderprintformat_adprintf;
ALTER TABLE ad_printform
	ADD CONSTRAINT manuforderprintformat_adprintf
		FOREIGN KEY (manuf_order_printformat_id) REFERENCES ad_printformat
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_printform
	DROP CONSTRAINT IF EXISTS distribordermailtext_adprintfo;
ALTER TABLE ad_printform
	ADD CONSTRAINT distribordermailtext_adprintfo
		FOREIGN KEY (distrib_order_mailtext_id) REFERENCES r_mailtext
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_printform
	DROP CONSTRAINT IF EXISTS manufordermailtext_adprintform;
ALTER TABLE ad_printform
	ADD CONSTRAINT manufordermailtext_adprintform
		FOREIGN KEY (manuf_order_mailtext_id) REFERENCES r_mailtext
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_printform
	DROP CONSTRAINT IF EXISTS rmailtext_invoiceadprintform;
ALTER TABLE ad_printform
	ADD CONSTRAINT rmailtext_invoiceadprintform
		FOREIGN KEY (invoice_mailtext_id) REFERENCES r_mailtext
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_printform
	DROP CONSTRAINT IF EXISTS rmailtext_orderadprintform;
ALTER TABLE ad_printform
	ADD CONSTRAINT rmailtext_orderadprintform
		FOREIGN KEY (order_mailtext_id) REFERENCES r_mailtext
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_printform
	DROP CONSTRAINT IF EXISTS rmailtext_projectadprintform;
ALTER TABLE ad_printform
	ADD CONSTRAINT rmailtext_projectadprintform
		FOREIGN KEY (project_mailtext_id) REFERENCES r_mailtext
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_printform
	DROP CONSTRAINT IF EXISTS rmailtext_remitadprintform;
ALTER TABLE ad_printform
	ADD CONSTRAINT rmailtext_remitadprintform
		FOREIGN KEY (remittance_mailtext_id) REFERENCES r_mailtext
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_printform
	DROP CONSTRAINT IF EXISTS rmailtext_shipadprintform;
ALTER TABLE ad_printform
	ADD CONSTRAINT rmailtext_shipadprintform
		FOREIGN KEY (shipment_mailtext_id) REFERENCES r_mailtext
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_printform
	DROP CONSTRAINT IF EXISTS adclient_adprintform;
ALTER TABLE ad_printform
	ADD CONSTRAINT adclient_adprintform
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_printformat
	DROP CONSTRAINT IF EXISTS adtable_adprintformat;
ALTER TABLE ad_printformat
	ADD CONSTRAINT adtable_adprintformat
		FOREIGN KEY (ad_table_id) REFERENCES ad_table
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_printformat
	DROP CONSTRAINT IF EXISTS jasperprocess_adprintformat;
ALTER TABLE ad_printformat
	ADD CONSTRAINT jasperprocess_adprintformat
		FOREIGN KEY (jasperprocess_id) REFERENCES ad_process
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_printformat
	DROP CONSTRAINT IF EXISTS adwindow_adprintformat;
ALTER TABLE ad_printformat
	ADD CONSTRAINT adwindow_adprintformat
		FOREIGN KEY (ad_window_id) REFERENCES ad_window
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_printformat
	DROP CONSTRAINT IF EXISTS adprintview_adprintformat;
ALTER TABLE ad_printformat
	ADD CONSTRAINT adprintview_adprintformat
		FOREIGN KEY (ad_reportview_id) REFERENCES ad_reportview
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_printformat
	DROP CONSTRAINT IF EXISTS ad_printfont_adprintformat;
ALTER TABLE ad_printformat
	ADD CONSTRAINT ad_printfont_adprintformat
		FOREIGN KEY (ad_printfont_id) REFERENCES ad_printfont
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_printformat
	DROP CONSTRAINT IF EXISTS adprintcolor_adprintformat;
ALTER TABLE ad_printformat
	ADD CONSTRAINT adprintcolor_adprintformat
		FOREIGN KEY (ad_printcolor_id) REFERENCES ad_printcolor
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_printformat
	DROP CONSTRAINT IF EXISTS adprintpaper_adprintformat;
ALTER TABLE ad_printformat
	ADD CONSTRAINT adprintpaper_adprintformat
		FOREIGN KEY (ad_printpaper_id) REFERENCES ad_printpaper
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_printformat
	DROP CONSTRAINT IF EXISTS adprintformattable_format;
ALTER TABLE ad_printformat
	ADD CONSTRAINT adprintformattable_format
		FOREIGN KEY (ad_printtableformat_id) REFERENCES ad_printtableformat
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_printformat_trl
	DROP CONSTRAINT IF EXISTS ad_printformat_trl_uu_idx;
ALTER TABLE ad_printformat_trl
	ADD CONSTRAINT ad_printformat_trl_uu_idx
		UNIQUE (ad_printformat_trl_uu);

ALTER TABLE ad_printformat_trl
	DROP CONSTRAINT IF EXISTS adlanguage_adprintformtrl;
ALTER TABLE ad_printformat_trl
	ADD CONSTRAINT adlanguage_adprintformtrl
		FOREIGN KEY (ad_language) REFERENCES ad_language
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_printformat_trl
	DROP CONSTRAINT IF EXISTS adprintformat_trl;
ALTER TABLE ad_printformat_trl
	ADD CONSTRAINT adprintformat_trl
		FOREIGN KEY (ad_printformat_id) REFERENCES ad_printformat
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_printformatitem
	DROP CONSTRAINT IF EXISTS adcolumn_adprintformatitem;
ALTER TABLE ad_printformatitem
	ADD CONSTRAINT adcolumn_adprintformatitem
		FOREIGN KEY (ad_column_id) REFERENCES ad_column
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_printformatitem
	DROP CONSTRAINT IF EXISTS adprintformat_printformatchild;
ALTER TABLE ad_printformatitem
	ADD CONSTRAINT adprintformat_printformatchild
		FOREIGN KEY (ad_printformatchild_id) REFERENCES ad_printformat
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_printformatitem
	DROP CONSTRAINT IF EXISTS adprintformat_printformatitem;
ALTER TABLE ad_printformatitem
	ADD CONSTRAINT adprintformat_printformatitem
		FOREIGN KEY (ad_printformat_id) REFERENCES ad_printformat
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_printformatitem
	DROP CONSTRAINT IF EXISTS adprintfont_adprintformatitem;
ALTER TABLE ad_printformatitem
	ADD CONSTRAINT adprintfont_adprintformatitem
		FOREIGN KEY (ad_printfont_id) REFERENCES ad_printfont
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_printformatitem
	DROP CONSTRAINT IF EXISTS adprintcolor_adprintformatitem;
ALTER TABLE ad_printformatitem
	ADD CONSTRAINT adprintcolor_adprintformatitem
		FOREIGN KEY (ad_printcolor_id) REFERENCES ad_printcolor
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_printformatitem
	DROP CONSTRAINT IF EXISTS adprintgraph_printformatitem;
ALTER TABLE ad_printformatitem
	ADD CONSTRAINT adprintgraph_printformatitem
		FOREIGN KEY (ad_printgraph_id) REFERENCES ad_printgraph
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_printformatitem_trl
	DROP CONSTRAINT IF EXISTS adprintformatitem_trl;
ALTER TABLE ad_printformatitem_trl
	ADD CONSTRAINT adprintformatitem_trl
		FOREIGN KEY (ad_printformatitem_id) REFERENCES ad_printformatitem
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_printformatitem_trl
	DROP CONSTRAINT IF EXISTS adlanguage_adprintformitemtrl;
ALTER TABLE ad_printformatitem_trl
	ADD CONSTRAINT adlanguage_adprintformitemtrl
		FOREIGN KEY (ad_language) REFERENCES ad_language
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_process
	DROP CONSTRAINT IF EXISTS adform_adprocess;
ALTER TABLE ad_process
	ADD CONSTRAINT adform_adprocess
		FOREIGN KEY (ad_form_id) REFERENCES ad_form
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_process
	DROP CONSTRAINT IF EXISTS adworkflow_adprocess;
ALTER TABLE ad_process
	ADD CONSTRAINT adworkflow_adprocess
		FOREIGN KEY (ad_workflow_id) REFERENCES ad_workflow
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_process
	DROP CONSTRAINT IF EXISTS adreportview_adprocess;
ALTER TABLE ad_process
	ADD CONSTRAINT adreportview_adprocess
		FOREIGN KEY (ad_reportview_id) REFERENCES ad_reportview
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_process
	DROP CONSTRAINT IF EXISTS adprintformat_adprocess;
ALTER TABLE ad_process
	ADD CONSTRAINT adprintformat_adprocess
		FOREIGN KEY (ad_printformat_id) REFERENCES ad_printformat
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_process
	DROP CONSTRAINT IF EXISTS entityt_adprocess;
ALTER TABLE ad_process
	ADD CONSTRAINT entityt_adprocess
		FOREIGN KEY (entitytype) REFERENCES ad_entitytype
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_process
	DROP CONSTRAINT IF EXISTS adctxhelp_adprocess;
ALTER TABLE ad_process
	ADD CONSTRAINT adctxhelp_adprocess
		FOREIGN KEY (ad_ctxhelp_id) REFERENCES ad_ctxhelp
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_process_access
	DROP CONSTRAINT IF EXISTS adprocess_adprocessaccess;
ALTER TABLE ad_process_access
	ADD CONSTRAINT adprocess_adprocessaccess
		FOREIGN KEY (ad_process_id) REFERENCES ad_process
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_process_access
	DROP CONSTRAINT IF EXISTS ad_processtaccess_org;
ALTER TABLE ad_process_access
	ADD CONSTRAINT ad_processtaccess_org
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_process_access
	DROP CONSTRAINT IF EXISTS adrole_adprocessaccess;
ALTER TABLE ad_process_access
	ADD CONSTRAINT adrole_adprocessaccess
		FOREIGN KEY (ad_role_id) REFERENCES ad_role
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_process_access
	DROP CONSTRAINT IF EXISTS ad_processaccess_client;
ALTER TABLE ad_process_access
	ADD CONSTRAINT ad_processaccess_client
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_process_para
	DROP CONSTRAINT IF EXISTS adelement_adprocesspara;
ALTER TABLE ad_process_para
	ADD CONSTRAINT adelement_adprocesspara
		FOREIGN KEY (ad_element_id) REFERENCES ad_element
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_process_para
	DROP CONSTRAINT IF EXISTS adprocess_adprocesspara;
ALTER TABLE ad_process_para
	ADD CONSTRAINT adprocess_adprocesspara
		FOREIGN KEY (ad_process_id) REFERENCES ad_process
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_process_para
	DROP CONSTRAINT IF EXISTS advalrule_ad_processpara;
ALTER TABLE ad_process_para
	ADD CONSTRAINT advalrule_ad_processpara
		FOREIGN KEY (ad_val_rule_id) REFERENCES ad_val_rule
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_process_para
	DROP CONSTRAINT IF EXISTS adreference_adprocesspara;
ALTER TABLE ad_process_para
	ADD CONSTRAINT adreference_adprocesspara
		FOREIGN KEY (ad_reference_id) REFERENCES ad_reference
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_process_para
	DROP CONSTRAINT IF EXISTS adreferencevalue_adprocpara;
ALTER TABLE ad_process_para
	ADD CONSTRAINT adreferencevalue_adprocpara
		FOREIGN KEY (ad_reference_value_id) REFERENCES ad_reference
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_process_para
	DROP CONSTRAINT IF EXISTS entityt_adprocesspara;
ALTER TABLE ad_process_para
	ADD CONSTRAINT entityt_adprocesspara
		FOREIGN KEY (entitytype) REFERENCES ad_entitytype
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_process_para_trl
	DROP CONSTRAINT IF EXISTS adprocpara_adprocparatrl;
ALTER TABLE ad_process_para_trl
	ADD CONSTRAINT adprocpara_adprocparatrl
		FOREIGN KEY (ad_process_para_id) REFERENCES ad_process_para
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_process_para_trl
	DROP CONSTRAINT IF EXISTS adlanguage_adprocessparatrl;
ALTER TABLE ad_process_para_trl
	ADD CONSTRAINT adlanguage_adprocessparatrl
		FOREIGN KEY (ad_language) REFERENCES ad_language
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_process_trl
	DROP CONSTRAINT IF EXISTS ad_process_ad_process_trl;
ALTER TABLE ad_process_trl
	ADD CONSTRAINT ad_process_ad_process_trl
		FOREIGN KEY (ad_process_id) REFERENCES ad_process
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_process_trl
	DROP CONSTRAINT IF EXISTS ad_language_ad_process_trl;
ALTER TABLE ad_process_trl
	ADD CONSTRAINT ad_language_ad_process_trl
		FOREIGN KEY (ad_language) REFERENCES ad_language
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_recentitem
	DROP CONSTRAINT IF EXISTS adtab_adrecentitem;
ALTER TABLE ad_recentitem
	ADD CONSTRAINT adtab_adrecentitem
		FOREIGN KEY (ad_tab_id) REFERENCES ad_tab
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_recentitem
	DROP CONSTRAINT IF EXISTS adtable_adrecentitem;
ALTER TABLE ad_recentitem
	ADD CONSTRAINT adtable_adrecentitem
		FOREIGN KEY (ad_table_id) REFERENCES ad_table
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_recentitem
	DROP CONSTRAINT IF EXISTS adwindow_adrecentitem;
ALTER TABLE ad_recentitem
	ADD CONSTRAINT adwindow_adrecentitem
		FOREIGN KEY (ad_window_id) REFERENCES ad_window
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_recentitem
	DROP CONSTRAINT IF EXISTS aduser_adrecentitem;
ALTER TABLE ad_recentitem
	ADD CONSTRAINT aduser_adrecentitem
		FOREIGN KEY (ad_user_id) REFERENCES ad_user
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_recentitem
	DROP CONSTRAINT IF EXISTS adrole_adrecentitem;
ALTER TABLE ad_recentitem
	ADD CONSTRAINT adrole_adrecentitem
		FOREIGN KEY (ad_role_id) REFERENCES ad_role
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_role_included
	DROP CONSTRAINT IF EXISTS ad_role_included_parent;
ALTER TABLE ad_role_included
	ADD CONSTRAINT ad_role_included_parent
		FOREIGN KEY (ad_role_id) REFERENCES ad_role
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_role_included
	DROP CONSTRAINT IF EXISTS ad_role_included_role;
ALTER TABLE ad_role_included
	ADD CONSTRAINT ad_role_included_role
		FOREIGN KEY (included_role_id) REFERENCES ad_role
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_role_orgaccess
	DROP CONSTRAINT IF EXISTS adrole_adroleorgaccess;
ALTER TABLE ad_role_orgaccess
	ADD CONSTRAINT adrole_adroleorgaccess
		FOREIGN KEY (ad_role_id) REFERENCES ad_role
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_role_orgaccess
	DROP CONSTRAINT IF EXISTS adorg_adroleorgaccess;
ALTER TABLE ad_role_orgaccess
	ADD CONSTRAINT adorg_adroleorgaccess
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_scheduler
	DROP CONSTRAINT IF EXISTS adtable_adscheduler;
ALTER TABLE ad_scheduler
	ADD CONSTRAINT adtable_adscheduler
		FOREIGN KEY (ad_table_id) REFERENCES ad_table
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_scheduler
	DROP CONSTRAINT IF EXISTS adprocess_adscheduler;
ALTER TABLE ad_scheduler
	ADD CONSTRAINT adprocess_adscheduler
		FOREIGN KEY (ad_process_id) REFERENCES ad_process
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_scheduler
	DROP CONSTRAINT IF EXISTS adprintformat_adscheduler;
ALTER TABLE ad_scheduler
	ADD CONSTRAINT adprintformat_adscheduler
		FOREIGN KEY (ad_printformat_id) REFERENCES ad_printformat
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_scheduler
	DROP CONSTRAINT IF EXISTS aduser_adscheduler;
ALTER TABLE ad_scheduler
	ADD CONSTRAINT aduser_adscheduler
		FOREIGN KEY (supervisor_id) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_scheduler
	DROP CONSTRAINT IF EXISTS rmailtext_adscheduler;
ALTER TABLE ad_scheduler
	ADD CONSTRAINT rmailtext_adscheduler
		FOREIGN KEY (r_mailtext_id) REFERENCES r_mailtext
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_scheduler
	DROP CONSTRAINT IF EXISTS adschedule_adscheduler;
ALTER TABLE ad_scheduler
	ADD CONSTRAINT adschedule_adscheduler
		FOREIGN KEY (ad_schedule_id) REFERENCES ad_schedule
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_scheduler_para
	DROP CONSTRAINT IF EXISTS adprocesspara_adschedulerpara;
ALTER TABLE ad_scheduler_para
	ADD CONSTRAINT adprocesspara_adschedulerpara
		FOREIGN KEY (ad_process_para_id) REFERENCES ad_process_para
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_scheduler_para
	DROP CONSTRAINT IF EXISTS adscheduler_adschedulerpara;
ALTER TABLE ad_scheduler_para
	ADD CONSTRAINT adscheduler_adschedulerpara
		FOREIGN KEY (ad_scheduler_id) REFERENCES ad_scheduler
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_schedulerlog
	DROP CONSTRAINT IF EXISTS adscheduler_log;
ALTER TABLE ad_schedulerlog
	ADD CONSTRAINT adscheduler_log
		FOREIGN KEY (ad_scheduler_id) REFERENCES ad_scheduler
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_schedulerrecipient
	DROP CONSTRAINT IF EXISTS aduser_adschedulerrecipient;
ALTER TABLE ad_schedulerrecipient
	ADD CONSTRAINT aduser_adschedulerrecipient
		FOREIGN KEY (ad_user_id) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_schedulerrecipient
	DROP CONSTRAINT IF EXISTS adscheduler_recipient;
ALTER TABLE ad_schedulerrecipient
	ADD CONSTRAINT adscheduler_recipient
		FOREIGN KEY (ad_scheduler_id) REFERENCES ad_scheduler
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_schedulerrecipient
	DROP CONSTRAINT IF EXISTS adrole_adschedulerrecipient;
ALTER TABLE ad_schedulerrecipient
	ADD CONSTRAINT adrole_adschedulerrecipient
		FOREIGN KEY (ad_role_id) REFERENCES ad_role
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_sequence
	DROP CONSTRAINT IF EXISTS sequenceorg;
ALTER TABLE ad_sequence
	ADD CONSTRAINT sequenceorg
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_sequence
	DROP CONSTRAINT IF EXISTS sequenceclient;
ALTER TABLE ad_sequence
	ADD CONSTRAINT sequenceclient
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_session
	DROP CONSTRAINT IF EXISTS adrole_adsession;
ALTER TABLE ad_session
	ADD CONSTRAINT adrole_adsession
		FOREIGN KEY (ad_role_id) REFERENCES ad_role
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_tree
	DROP CONSTRAINT IF EXISTS parentcolumn_adtree;
ALTER TABLE ad_tree
	ADD CONSTRAINT parentcolumn_adtree
		FOREIGN KEY (parent_column_id) REFERENCES ad_column
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_tree
	DROP CONSTRAINT IF EXISTS adtable_adtree;
ALTER TABLE ad_tree
	ADD CONSTRAINT adtable_adtree
		FOREIGN KEY (ad_table_id) REFERENCES ad_table
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_treenode
	DROP CONSTRAINT IF EXISTS adtree_adtreenode;
ALTER TABLE ad_treenode
	ADD CONSTRAINT adtree_adtreenode
		FOREIGN KEY (ad_tree_id) REFERENCES ad_tree
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_treenodebp
	DROP CONSTRAINT IF EXISTS adtree_adtreenodebp;
ALTER TABLE ad_treenodebp
	ADD CONSTRAINT adtree_adtreenodebp
		FOREIGN KEY (ad_tree_id) REFERENCES ad_tree
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_treenodepr
	DROP CONSTRAINT IF EXISTS adtree_adtreenodepr;
ALTER TABLE ad_treenodepr
	ADD CONSTRAINT adtree_adtreenodepr
		FOREIGN KEY (ad_tree_id) REFERENCES ad_tree
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_userdef_tab
	ADD IF NOT EXISTS whereclause varchar(2000) DEFAULT NULL::character varying;

ALTER TABLE ad_userdef_tab
	ADD IF NOT EXISTS orderbyclause varchar(2000) DEFAULT NULL::character varying;

ALTER TABLE ad_userdef_tab
	ADD IF NOT EXISTS seqno numeric(10) DEFAULT NULL::numeric;

ALTER TABLE ad_userdef_tab
	ADD IF NOT EXISTS ad_process_id numeric(10) DEFAULT NULL::numeric;

ALTER TABLE ad_userdef_tab
	ADD IF NOT EXISTS displaylogic varchar(2000) DEFAULT NULL::character varying;

ALTER TABLE ad_userdef_tab
	DROP CONSTRAINT IF EXISTS adprocess_aduserdeftab;
ALTER TABLE ad_userdef_tab
	ADD CONSTRAINT adprocess_aduserdeftab
		FOREIGN KEY (ad_process_id) REFERENCES ad_process
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_usermail
	DROP CONSTRAINT IF EXISTS aduser_adusermail;
ALTER TABLE ad_usermail
	ADD CONSTRAINT aduser_adusermail
		FOREIGN KEY (ad_user_id) REFERENCES ad_user
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_usermail
	DROP CONSTRAINT IF EXISTS rmailtext_adusermail;
ALTER TABLE ad_usermail
	ADD CONSTRAINT rmailtext_adusermail
		FOREIGN KEY (r_mailtext_id) REFERENCES r_mailtext
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_usermail
	DROP CONSTRAINT IF EXISTS wmailmsg_adusermail;
ALTER TABLE ad_usermail
	ADD CONSTRAINT wmailmsg_adusermail
		FOREIGN KEY (w_mailmsg_id) REFERENCES w_mailmsg
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_userpreference
	DROP CONSTRAINT IF EXISTS ad_userpreference_uu_idx;
ALTER TABLE ad_userpreference
	ADD CONSTRAINT ad_userpreference_uu_idx
		UNIQUE (ad_userpreference_uu);

ALTER TABLE ad_userpreference
	DROP CONSTRAINT IF EXISTS aduser_aduserpreference;
ALTER TABLE ad_userpreference
	ADD CONSTRAINT aduser_aduserpreference
		FOREIGN KEY (ad_user_id) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_userpreference
	DROP CONSTRAINT IF EXISTS createdby_aduserpreference;
ALTER TABLE ad_userpreference
	ADD CONSTRAINT createdby_aduserpreference
		FOREIGN KEY (createdby) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_userpreference
	DROP CONSTRAINT IF EXISTS updatedby_aduserpreference;
ALTER TABLE ad_userpreference
	ADD CONSTRAINT updatedby_aduserpreference
		FOREIGN KEY (updatedby) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_userpreference
	DROP CONSTRAINT IF EXISTS adorg_aduserpreference;
ALTER TABLE ad_userpreference
	ADD CONSTRAINT adorg_aduserpreference
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_userpreference
	DROP CONSTRAINT IF EXISTS adclient_aduserpreference;
ALTER TABLE ad_userpreference
	ADD CONSTRAINT adclient_aduserpreference
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_wf_activity
	DROP CONSTRAINT IF EXISTS admessage_adwfactivity;
ALTER TABLE ad_wf_activity
	ADD CONSTRAINT admessage_adwfactivity
		FOREIGN KEY (ad_message_id) REFERENCES ad_message
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_wf_activity
	DROP CONSTRAINT IF EXISTS adwfnode_adwfactivity;
ALTER TABLE ad_wf_activity
	ADD CONSTRAINT adwfnode_adwfactivity
		FOREIGN KEY (ad_wf_node_id) REFERENCES ad_wf_node
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_wf_activity
	DROP CONSTRAINT IF EXISTS adtable_adwfactivity;
ALTER TABLE ad_wf_activity
	ADD CONSTRAINT adtable_adwfactivity
		FOREIGN KEY (ad_table_id) REFERENCES ad_table
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_wf_activity
	DROP CONSTRAINT IF EXISTS adworkflow_adwfactivity;
ALTER TABLE ad_wf_activity
	ADD CONSTRAINT adworkflow_adwfactivity
		FOREIGN KEY (ad_workflow_id) REFERENCES ad_workflow
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_wf_activity
	DROP CONSTRAINT IF EXISTS aduser_adwfactivity;
ALTER TABLE ad_wf_activity
	ADD CONSTRAINT aduser_adwfactivity
		FOREIGN KEY (ad_user_id) REFERENCES ad_user
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_wf_activity
	DROP CONSTRAINT IF EXISTS adwfprocess_adwfactivity;
ALTER TABLE ad_wf_activity
	ADD CONSTRAINT adwfprocess_adwfactivity
		FOREIGN KEY (ad_wf_process_id) REFERENCES ad_wf_process
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_wf_activity
	DROP CONSTRAINT IF EXISTS adwfresponsible_adwfactivity;
ALTER TABLE ad_wf_activity
	ADD CONSTRAINT adwfresponsible_adwfactivity
		FOREIGN KEY (ad_wf_responsible_id) REFERENCES ad_wf_responsible
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_wf_eventaudit
	DROP CONSTRAINT IF EXISTS adtable_adwfeventaudit;
ALTER TABLE ad_wf_eventaudit
	ADD CONSTRAINT adtable_adwfeventaudit
		FOREIGN KEY (ad_table_id) REFERENCES ad_table
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_wf_eventaudit
	DROP CONSTRAINT IF EXISTS aduser_adwfeventaudit;
ALTER TABLE ad_wf_eventaudit
	ADD CONSTRAINT aduser_adwfeventaudit
		FOREIGN KEY (ad_user_id) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_wf_eventaudit
	DROP CONSTRAINT IF EXISTS adwfnode_adwfeventaudit;
ALTER TABLE ad_wf_eventaudit
	ADD CONSTRAINT adwfnode_adwfeventaudit
		FOREIGN KEY (ad_wf_node_id) REFERENCES ad_wf_node
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_wf_eventaudit
	DROP CONSTRAINT IF EXISTS adwfprocess_adwfeventaudit;
ALTER TABLE ad_wf_eventaudit
	ADD CONSTRAINT adwfprocess_adwfeventaudit
		FOREIGN KEY (ad_wf_process_id) REFERENCES ad_wf_process
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_wf_eventaudit
	DROP CONSTRAINT IF EXISTS adwfresponsib_adwfeventaudit;
ALTER TABLE ad_wf_eventaudit
	ADD CONSTRAINT adwfresponsib_adwfeventaudit
		FOREIGN KEY (ad_wf_responsible_id) REFERENCES ad_wf_responsible
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_wf_process
	DROP CONSTRAINT IF EXISTS admessage_adwfprocess;
ALTER TABLE ad_wf_process
	ADD CONSTRAINT admessage_adwfprocess
		FOREIGN KEY (ad_message_id) REFERENCES ad_message
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_wf_process
	DROP CONSTRAINT IF EXISTS adtable_adwfprocess;
ALTER TABLE ad_wf_process
	ADD CONSTRAINT adtable_adwfprocess
		FOREIGN KEY (ad_table_id) REFERENCES ad_table
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_wf_process
	DROP CONSTRAINT IF EXISTS adworkflow_adwfprocess;
ALTER TABLE ad_wf_process
	ADD CONSTRAINT adworkflow_adwfprocess
		FOREIGN KEY (ad_workflow_id) REFERENCES ad_workflow
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_wf_process
	DROP CONSTRAINT IF EXISTS aduser_adwfprocess;
ALTER TABLE ad_wf_process
	ADD CONSTRAINT aduser_adwfprocess
		FOREIGN KEY (ad_user_id) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_wf_process
	DROP CONSTRAINT IF EXISTS adwfprocess_adwfprocess;
ALTER TABLE ad_wf_process
	ADD CONSTRAINT adwfprocess_adwfprocess
		FOREIGN KEY (ad_wf_process_id) REFERENCES ad_wf_process
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_wf_process
	DROP CONSTRAINT IF EXISTS wf_instanceorg;
ALTER TABLE ad_wf_process
	ADD CONSTRAINT wf_instanceorg
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_wf_process
	DROP CONSTRAINT IF EXISTS adwfresponsible_adwfprocess;
ALTER TABLE ad_wf_process
	ADD CONSTRAINT adwfresponsible_adwfprocess
		FOREIGN KEY (ad_wf_responsible_id) REFERENCES ad_wf_responsible
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_wf_process
	DROP CONSTRAINT IF EXISTS wf_instanceclient;
ALTER TABLE ad_wf_process
	ADD CONSTRAINT wf_instanceclient
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_window_access
	DROP CONSTRAINT IF EXISTS adwindow_adwindowaccess;
ALTER TABLE ad_window_access
	ADD CONSTRAINT adwindow_adwindowaccess
		FOREIGN KEY (ad_window_id) REFERENCES ad_window
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_window_access
	DROP CONSTRAINT IF EXISTS adrole_adwindowaccess;
ALTER TABLE ad_window_access
	ADD CONSTRAINT adrole_adwindowaccess
		FOREIGN KEY (ad_role_id) REFERENCES ad_role
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_window_access
	DROP CONSTRAINT IF EXISTS ad_functaccessorg;
ALTER TABLE ad_window_access
	ADD CONSTRAINT ad_functaccessorg
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_window_access
	DROP CONSTRAINT IF EXISTS ad_functaccess_client;
ALTER TABLE ad_window_access
	ADD CONSTRAINT ad_functaccess_client
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_workflow_access
	DROP CONSTRAINT IF EXISTS adworkfow_workflowaccess;
ALTER TABLE ad_workflow_access
	ADD CONSTRAINT adworkfow_workflowaccess
		FOREIGN KEY (ad_workflow_id) REFERENCES ad_workflow
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_workflow_access
	DROP CONSTRAINT IF EXISTS adrole_adworkflowaccess;
ALTER TABLE ad_workflow_access
	ADD CONSTRAINT adrole_adworkflowaccess
		FOREIGN KEY (ad_role_id) REFERENCES ad_role
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_workflow_access
	DROP CONSTRAINT IF EXISTS ad_workflowaccess_org;
ALTER TABLE ad_workflow_access
	ADD CONSTRAINT ad_workflowaccess_org
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_workflow_access
	DROP CONSTRAINT IF EXISTS ad_workflowaccess_client;
ALTER TABLE ad_workflow_access
	ADD CONSTRAINT ad_workflowaccess_client
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_workflowprocessor
	DROP CONSTRAINT IF EXISTS aduser_adworkflowprocessor;
ALTER TABLE ad_workflowprocessor
	ADD CONSTRAINT aduser_adworkflowprocessor
		FOREIGN KEY (supervisor_id) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_workflowprocessor
	DROP CONSTRAINT IF EXISTS adschedule_adworkflowprocessor;
ALTER TABLE ad_workflowprocessor
	ADD CONSTRAINT adschedule_adworkflowprocessor
		FOREIGN KEY (ad_schedule_id) REFERENCES ad_schedule
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_workflowprocessorlog
	DROP CONSTRAINT IF EXISTS adworkflowprocessor_log;
ALTER TABLE ad_workflowprocessorlog
	ADD CONSTRAINT adworkflowprocessor_log
		FOREIGN KEY (ad_workflowprocessor_id) REFERENCES ad_workflowprocessor
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctprocessor
	DROP CONSTRAINT IF EXISTS adtable_cacctprocessor;
ALTER TABLE c_acctprocessor
	ADD CONSTRAINT adtable_cacctprocessor
		FOREIGN KEY (ad_table_id) REFERENCES ad_table
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctprocessor
	DROP CONSTRAINT IF EXISTS aduser_cacctprocessor;
ALTER TABLE c_acctprocessor
	ADD CONSTRAINT aduser_cacctprocessor
		FOREIGN KEY (supervisor_id) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctprocessor
	DROP CONSTRAINT IF EXISTS adschedule_cacctprocessor;
ALTER TABLE c_acctprocessor
	ADD CONSTRAINT adschedule_cacctprocessor
		FOREIGN KEY (ad_schedule_id) REFERENCES ad_schedule
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctprocessor
	DROP CONSTRAINT IF EXISTS cacctschema_cacctprocessor;
ALTER TABLE c_acctprocessor
	ADD CONSTRAINT cacctschema_cacctprocessor
		FOREIGN KEY (c_acctschema_id) REFERENCES c_acctschema
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctprocessorlog
	DROP CONSTRAINT IF EXISTS cacctprocessor_log;
ALTER TABLE c_acctprocessorlog
	ADD CONSTRAINT cacctprocessor_log
		FOREIGN KEY (c_acctprocessor_id) REFERENCES c_acctprocessor
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema
	DROP CONSTRAINT IF EXISTS cperiod_cacctschema;
ALTER TABLE c_acctschema
	ADD CONSTRAINT cperiod_cacctschema
		FOREIGN KEY (c_period_id) REFERENCES c_period
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema
	DROP CONSTRAINT IF EXISTS c_currency_c_acctschema;
ALTER TABLE c_acctschema
	ADD CONSTRAINT c_currency_c_acctschema
		FOREIGN KEY (c_currency_id) REFERENCES c_currency
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema
	DROP CONSTRAINT IF EXISTS ad_org_c_acctschema;
ALTER TABLE c_acctschema
	ADD CONSTRAINT ad_org_c_acctschema
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema
	DROP CONSTRAINT IF EXISTS adorgonly_cacctschema;
ALTER TABLE c_acctschema
	ADD CONSTRAINT adorgonly_cacctschema
		FOREIGN KEY (ad_orgonly_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema
	DROP CONSTRAINT IF EXISTS ad_client_c_acctschema;
ALTER TABLE c_acctschema
	ADD CONSTRAINT ad_client_c_acctschema
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema
	DROP CONSTRAINT IF EXISTS mcosttype_cacctschema;
ALTER TABLE c_acctschema
	ADD CONSTRAINT mcosttype_cacctschema
		FOREIGN KEY (m_costtype_id) REFERENCES m_costtype
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS chrevenue_cacctschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT chrevenue_cacctschemadefault
		FOREIGN KEY (ch_revenue_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS creceivableservices_cacctschem;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT creceivableservices_cacctschem
		FOREIGN KEY (c_receivable_services_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS paveragecostvariance_cacctsche;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT paveragecostvariance_cacctsche
		FOREIGN KEY (p_averagecostvariance_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS pburden_cacctschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT pburden_cacctschemadefault
		FOREIGN KEY (p_burden_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS pcostadjustment_cacctschemadef;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT pcostadjustment_cacctschemadef
		FOREIGN KEY (p_costadjustment_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS pcostofproduction_cacctschemad;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT pcostofproduction_cacctschemad
		FOREIGN KEY (p_costofproduction_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS pfloorstock_cacctschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT pfloorstock_cacctschemadefault
		FOREIGN KEY (p_floorstock_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS pinventoryclearing_cacctschema;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT pinventoryclearing_cacctschema
		FOREIGN KEY (p_inventoryclearing_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS plabor_cacctschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT plabor_cacctschemadefault
		FOREIGN KEY (p_labor_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS plandedcostclearingvc_cacctsch;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT plandedcostclearingvc_cacctsch
		FOREIGN KEY (p_landedcostclearing_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS pmethodchangevariance_cacctsch;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT pmethodchangevariance_cacctsch
		FOREIGN KEY (p_methodchangevariance_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS pmixvariance_cacctschemadefaul;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT pmixvariance_cacctschemadefaul
		FOREIGN KEY (p_mixvariance_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS poutsideprocessing_cacctschema;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT poutsideprocessing_cacctschema
		FOREIGN KEY (p_outsideprocessing_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS poverhead_cacctschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT poverhead_cacctschemadefault
		FOREIGN KEY (p_overhead_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS pratevariance_cacctschemadefau;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT pratevariance_cacctschemadefau
		FOREIGN KEY (p_ratevariance_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS pscrap_cacctschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT pscrap_cacctschemadefault
		FOREIGN KEY (p_scrap_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS pusagevariance_cacctschemadefa;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT pusagevariance_cacctschemadefa
		FOREIGN KEY (p_usagevariance_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS pwip_cacctschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT pwip_cacctschemadefault
		FOREIGN KEY (p_wip_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_basset_cschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_basset_cschemadefault
		FOREIGN KEY (b_asset_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_bexpense_cschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_bexpense_cschemadefault
		FOREIGN KEY (b_expense_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_binterestexp_cschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_binterestexp_cschemadefault
		FOREIGN KEY (b_interestexp_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_binterestrev_cschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_binterestrev_cschemadefault
		FOREIGN KEY (b_interestrev_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_bintransit_cschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_bintransit_cschemadefault
		FOREIGN KEY (b_intransit_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_bpaymentselect_cschemadefau;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_bpaymentselect_cschemadefau
		FOREIGN KEY (b_paymentselect_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_brevaluationgain_cschemadef;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_brevaluationgain_cschemadef
		FOREIGN KEY (b_revaluationgain_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_brevaluationloss_cschemadef;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_brevaluationloss_cschemadef
		FOREIGN KEY (b_revaluationloss_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_bsettlementgain_cschemadefa;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_bsettlementgain_cschemadefa
		FOREIGN KEY (b_settlementgain_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_bsettlementloss_cschemadefa;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_bsettlementloss_cschemadefa
		FOREIGN KEY (b_settlementloss_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_bunallocatedcash_cschemadef;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_bunallocatedcash_cschemadef
		FOREIGN KEY (b_unallocatedcash_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_bunidentified_cschemadefaul;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_bunidentified_cschemadefaul
		FOREIGN KEY (b_unidentified_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_cbasset_cschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_cbasset_cschemadefault
		FOREIGN KEY (cb_asset_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_cbcashtransfer_cschemadefau;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_cbcashtransfer_cschemadefau
		FOREIGN KEY (cb_cashtransfer_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_cbdifferences_cschemadefaul;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_cbdifferences_cschemadefaul
		FOREIGN KEY (cb_differences_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_cbexpense_cschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_cbexpense_cschemadefault
		FOREIGN KEY (cb_expense_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_cbreceipt_cschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_cbreceipt_cschemadefault
		FOREIGN KEY (cb_receipt_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_chexpense_cschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_chexpense_cschemadefault
		FOREIGN KEY (ch_expense_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_cprepayment_cschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_cprepayment_cschemadefault
		FOREIGN KEY (c_prepayment_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_creceivable_cschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_creceivable_cschemadefault
		FOREIGN KEY (c_receivable_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_eexpense_cschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_eexpense_cschemadefault
		FOREIGN KEY (e_expense_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_eprepayment_cschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_eprepayment_cschemadefault
		FOREIGN KEY (e_prepayment_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_notinvoicedrec_cschemadefau;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_notinvoicedrec_cschemadefau
		FOREIGN KEY (notinvoicedreceivables_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_notinvoicedreceipts_cschema;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_notinvoicedreceipts_cschema
		FOREIGN KEY (notinvoicedreceipts_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_notinvoicedrevenue_cschemad;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_notinvoicedrevenue_cschemad
		FOREIGN KEY (notinvoicedrevenue_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_passet_cschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_passet_cschemadefault
		FOREIGN KEY (p_asset_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_paydiscountexp_cschemadefau;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_paydiscountexp_cschemadefau
		FOREIGN KEY (paydiscount_exp_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_paydiscountrev_cschemadefau;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_paydiscountrev_cschemadefau
		FOREIGN KEY (paydiscount_rev_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_pcogs_cschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_pcogs_cschemadefault
		FOREIGN KEY (p_cogs_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_pexpense_cschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_pexpense_cschemadefault
		FOREIGN KEY (p_expense_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_pinvoicepv_cschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_pinvoicepv_cschemadefault
		FOREIGN KEY (p_invoicepricevariance_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_pjasset_cschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_pjasset_cschemadefault
		FOREIGN KEY (pj_asset_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_pjwip_cschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_pjwip_cschemadefault
		FOREIGN KEY (pj_wip_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_ppurchasepv_cschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_ppurchasepv_cschemadefault
		FOREIGN KEY (p_purchasepricevariance_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_prevenue_cschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_prevenue_cschemadefault
		FOREIGN KEY (p_revenue_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_ptdiscountgrant_cschemadefa;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_ptdiscountgrant_cschemadefa
		FOREIGN KEY (p_tradediscountgrant_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_ptdiscountrec_cschemadefaul;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_ptdiscountrec_cschemadefaul
		FOREIGN KEY (p_tradediscountrec_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_realizedgain_cschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_realizedgain_cschemadefault
		FOREIGN KEY (realizedgain_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_realizedloss_cschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_realizedloss_cschemadefault
		FOREIGN KEY (realizedloss_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_tcredit_cschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_tcredit_cschemadefault
		FOREIGN KEY (t_credit_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_tdue_cschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_tdue_cschemadefault
		FOREIGN KEY (t_due_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_texpense_cschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_texpense_cschemadefault
		FOREIGN KEY (t_expense_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_tliability_cschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_tliability_cschemadefault
		FOREIGN KEY (t_liability_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_trec_cschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_trec_cschemadefault
		FOREIGN KEY (t_receivables_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_unearnedrevenue_cschemadefa;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_unearnedrevenue_cschemadefa
		FOREIGN KEY (unearnedrevenue_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_unrealizedgain_cschemadefau;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_unrealizedgain_cschemadefau
		FOREIGN KEY (unrealizedgain_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_unrealizedloss_cschemadefau;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_unrealizedloss_cschemadefau
		FOREIGN KEY (unrealizedloss_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_vliability_cschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_vliability_cschemadefault
		FOREIGN KEY (v_liability_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_vliabilityservices_cschemad;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_vliabilityservices_cschemad
		FOREIGN KEY (v_liability_services_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_vprepayment_cschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_vprepayment_cschemadefault
		FOREIGN KEY (v_prepayment_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_wdifferences_cschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_wdifferences_cschemadefault
		FOREIGN KEY (w_differences_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_winvactualadjust_cschemadef;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_winvactualadjust_cschemadef
		FOREIGN KEY (w_invactualadjust_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_winventory_cschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_winventory_cschemadefault
		FOREIGN KEY (w_inventory_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_withholding_cschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_withholding_cschemadefault
		FOREIGN KEY (withholding_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_wrevaluation_cschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_wrevaluation_cschemadefault
		FOREIGN KEY (w_revaluation_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS vc_writeoff_cschemadefault;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT vc_writeoff_cschemadefault
		FOREIGN KEY (writeoff_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS cacctschema_default;
ALTER TABLE c_acctschema_default
	ADD CONSTRAINT cacctschema_default
		FOREIGN KEY (c_acctschema_id) REFERENCES c_acctschema
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_gl
	DROP CONSTRAINT IF EXISTS commitmentoffset_cacctschemagl;
ALTER TABLE c_acctschema_gl
	ADD CONSTRAINT commitmentoffset_cacctschemagl
		FOREIGN KEY (commitmentoffset_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_gl
	DROP CONSTRAINT IF EXISTS commitmentoffsetsales_cacctsch;
ALTER TABLE c_acctschema_gl
	ADD CONSTRAINT commitmentoffsetsales_cacctsch
		FOREIGN KEY (commitmentoffsetsales_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_gl
	DROP CONSTRAINT IF EXISTS vc_currencybalancing_cschemagl;
ALTER TABLE c_acctschema_gl
	ADD CONSTRAINT vc_currencybalancing_cschemagl
		FOREIGN KEY (currencybalancing_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_gl
	DROP CONSTRAINT IF EXISTS vc_incomesummary_cschemagl;
ALTER TABLE c_acctschema_gl
	ADD CONSTRAINT vc_incomesummary_cschemagl
		FOREIGN KEY (incomesummary_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_gl
	DROP CONSTRAINT IF EXISTS vc_intercompanyduefrom_cschema;
ALTER TABLE c_acctschema_gl
	ADD CONSTRAINT vc_intercompanyduefrom_cschema
		FOREIGN KEY (intercompanyduefrom_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_gl
	DROP CONSTRAINT IF EXISTS vc_intercompanydueto_cschemagl;
ALTER TABLE c_acctschema_gl
	ADD CONSTRAINT vc_intercompanydueto_cschemagl
		FOREIGN KEY (intercompanydueto_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_gl
	DROP CONSTRAINT IF EXISTS vc_ppvoffset_cschemagl;
ALTER TABLE c_acctschema_gl
	ADD CONSTRAINT vc_ppvoffset_cschemagl
		FOREIGN KEY (ppvoffset_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_gl
	DROP CONSTRAINT IF EXISTS vc_retainedearning_cschemagl;
ALTER TABLE c_acctschema_gl
	ADD CONSTRAINT vc_retainedearning_cschemagl
		FOREIGN KEY (retainedearning_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_gl
	DROP CONSTRAINT IF EXISTS vc_suspensebalancing_cschemagl;
ALTER TABLE c_acctschema_gl
	ADD CONSTRAINT vc_suspensebalancing_cschemagl
		FOREIGN KEY (suspensebalancing_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_gl
	DROP CONSTRAINT IF EXISTS vc_suspenseerror_cschemagl;
ALTER TABLE c_acctschema_gl
	ADD CONSTRAINT vc_suspenseerror_cschemagl
		FOREIGN KEY (suspenseerror_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_acctschema_gl
	DROP CONSTRAINT IF EXISTS cacctschema_cacctschemagl;
ALTER TABLE c_acctschema_gl
	ADD CONSTRAINT cacctschema_cacctschemagl
		FOREIGN KEY (c_acctschema_id) REFERENCES c_acctschema
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_activity_trl
	DROP CONSTRAINT IF EXISTS c_activity_trl_uu_idx;
ALTER TABLE c_activity_trl
	ADD CONSTRAINT c_activity_trl_uu_idx
		UNIQUE (c_activity_trl_uu);

ALTER TABLE c_activity_trl
	DROP CONSTRAINT IF EXISTS adlanguage_cactivitytrl;
ALTER TABLE c_activity_trl
	ADD CONSTRAINT adlanguage_cactivitytrl
		FOREIGN KEY (ad_language) REFERENCES ad_language
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_activity_trl
	DROP CONSTRAINT IF EXISTS adorg_cactivitytrl;
ALTER TABLE c_activity_trl
	ADD CONSTRAINT adorg_cactivitytrl
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_activity_trl
	DROP CONSTRAINT IF EXISTS createdby_cactivitytrl;
ALTER TABLE c_activity_trl
	ADD CONSTRAINT createdby_cactivitytrl
		FOREIGN KEY (createdby) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_activity_trl
	DROP CONSTRAINT IF EXISTS updatedby_cactivitytrl;
ALTER TABLE c_activity_trl
	ADD CONSTRAINT updatedby_cactivitytrl
		FOREIGN KEY (updatedby) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_activity_trl
	DROP CONSTRAINT IF EXISTS adclient_cactivitytrl;
ALTER TABLE c_activity_trl
	ADD CONSTRAINT adclient_cactivitytrl
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_activity_trl
	DROP CONSTRAINT IF EXISTS cactivity_cactivitytrl;
ALTER TABLE c_activity_trl
	ADD CONSTRAINT cactivity_cactivitytrl
		FOREIGN KEY (c_activity_id) REFERENCES c_activity
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_allocationhdr
	DROP CONSTRAINT IF EXISTS ccurrency_callocation;
ALTER TABLE c_allocationhdr
	ADD CONSTRAINT ccurrency_callocation
		FOREIGN KEY (c_currency_id) REFERENCES c_currency
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_allocationhdr
	DROP CONSTRAINT IF EXISTS cdoctype_callocationhdr;
ALTER TABLE c_allocationhdr
	ADD CONSTRAINT cdoctype_callocationhdr
		FOREIGN KEY (c_doctype_id) REFERENCES c_doctype
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_allocationhdr
	DROP CONSTRAINT IF EXISTS reversal_callocationhdr;
ALTER TABLE c_allocationhdr
	ADD CONSTRAINT reversal_callocationhdr
		FOREIGN KEY (reversal_id) REFERENCES c_allocationhdr
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_allocationline
	DROP CONSTRAINT IF EXISTS cbpartner_callocationline;
ALTER TABLE c_allocationline
	ADD CONSTRAINT cbpartner_callocationline
		FOREIGN KEY (c_bpartner_id) REFERENCES c_bpartner
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_allocationline
	DROP CONSTRAINT IF EXISTS corder_callocation;
ALTER TABLE c_allocationline
	ADD CONSTRAINT corder_callocation
		FOREIGN KEY (c_order_id) REFERENCES c_order
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_allocationline
	DROP CONSTRAINT IF EXISTS cinvoice_callocationline;
ALTER TABLE c_allocationline
	ADD CONSTRAINT cinvoice_callocationline
		FOREIGN KEY (c_invoice_id) REFERENCES c_invoice
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_allocationline
	DROP CONSTRAINT IF EXISTS ccashline_callocationline;
ALTER TABLE c_allocationline
	ADD CONSTRAINT ccashline_callocationline
		FOREIGN KEY (c_cashline_id) REFERENCES c_cashline
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_allocationline
	DROP CONSTRAINT IF EXISTS cpayment_callocationline;
ALTER TABLE c_allocationline
	ADD CONSTRAINT cpayment_callocationline
		FOREIGN KEY (c_payment_id) REFERENCES c_payment
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_allocationline
	DROP CONSTRAINT IF EXISTS callocation_callocationline;
ALTER TABLE c_allocationline
	ADD CONSTRAINT callocation_callocationline
		FOREIGN KEY (c_allocationhdr_id) REFERENCES c_allocationhdr
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_allocationline
	DROP CONSTRAINT IF EXISTS ccharge_callocationline;
ALTER TABLE c_allocationline
	ADD CONSTRAINT ccharge_callocationline
		FOREIGN KEY (c_charge_id) REFERENCES c_charge
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bank
	DROP CONSTRAINT IF EXISTS clocation_cbank;
ALTER TABLE c_bank
	ADD CONSTRAINT clocation_cbank
		FOREIGN KEY (c_location_id) REFERENCES c_location
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bankaccount
	DROP CONSTRAINT IF EXISTS ccurrency_cbankaccount;
ALTER TABLE c_bankaccount
	ADD CONSTRAINT ccurrency_cbankaccount
		FOREIGN KEY (c_currency_id) REFERENCES c_currency
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bankaccount
	DROP CONSTRAINT IF EXISTS cbank_cbankaccount;
ALTER TABLE c_bankaccount
	ADD CONSTRAINT cbank_cbankaccount
		FOREIGN KEY (c_bank_id) REFERENCES c_bank
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bankaccount_acct
	DROP CONSTRAINT IF EXISTS cbankaccount_cbankacctacct;
ALTER TABLE c_bankaccount_acct
	ADD CONSTRAINT cbankaccount_cbankacctacct
		FOREIGN KEY (c_bankaccount_id) REFERENCES c_bankaccount
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bankaccount_acct
	DROP CONSTRAINT IF EXISTS vc_basset_cbankaccount;
ALTER TABLE c_bankaccount_acct
	ADD CONSTRAINT vc_basset_cbankaccount
		FOREIGN KEY (b_asset_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bankaccount_acct
	DROP CONSTRAINT IF EXISTS vc_bexpense_cbankaccount;
ALTER TABLE c_bankaccount_acct
	ADD CONSTRAINT vc_bexpense_cbankaccount
		FOREIGN KEY (b_expense_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bankaccount_acct
	DROP CONSTRAINT IF EXISTS vc_binterestexp_cbankaccount;
ALTER TABLE c_bankaccount_acct
	ADD CONSTRAINT vc_binterestexp_cbankaccount
		FOREIGN KEY (b_interestexp_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bankaccount_acct
	DROP CONSTRAINT IF EXISTS vc_binterestrev_cbankaccount;
ALTER TABLE c_bankaccount_acct
	ADD CONSTRAINT vc_binterestrev_cbankaccount
		FOREIGN KEY (b_interestrev_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bankaccount_acct
	DROP CONSTRAINT IF EXISTS vc_bintransit_cbankaccount;
ALTER TABLE c_bankaccount_acct
	ADD CONSTRAINT vc_bintransit_cbankaccount
		FOREIGN KEY (b_intransit_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bankaccount_acct
	DROP CONSTRAINT IF EXISTS vc_bpaymentselect_cbankaccount;
ALTER TABLE c_bankaccount_acct
	ADD CONSTRAINT vc_bpaymentselect_cbankaccount
		FOREIGN KEY (b_paymentselect_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bankaccount_acct
	DROP CONSTRAINT IF EXISTS vc_brevaluationgain_cbankaccou;
ALTER TABLE c_bankaccount_acct
	ADD CONSTRAINT vc_brevaluationgain_cbankaccou
		FOREIGN KEY (b_revaluationgain_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bankaccount_acct
	DROP CONSTRAINT IF EXISTS vc_brevaluationloss_cbankaccou;
ALTER TABLE c_bankaccount_acct
	ADD CONSTRAINT vc_brevaluationloss_cbankaccou
		FOREIGN KEY (b_revaluationloss_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bankaccount_acct
	DROP CONSTRAINT IF EXISTS vc_bsettlementgain_cbankaccoun;
ALTER TABLE c_bankaccount_acct
	ADD CONSTRAINT vc_bsettlementgain_cbankaccoun
		FOREIGN KEY (b_settlementgain_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bankaccount_acct
	DROP CONSTRAINT IF EXISTS vc_bsettlementloss_cbankaccoun;
ALTER TABLE c_bankaccount_acct
	ADD CONSTRAINT vc_bsettlementloss_cbankaccoun
		FOREIGN KEY (b_settlementloss_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bankaccount_acct
	DROP CONSTRAINT IF EXISTS vc_bunallocatedcash_cbankaccou;
ALTER TABLE c_bankaccount_acct
	ADD CONSTRAINT vc_bunallocatedcash_cbankaccou
		FOREIGN KEY (b_unallocatedcash_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bankaccount_acct
	DROP CONSTRAINT IF EXISTS vc_bunidentified_cbankaccount;
ALTER TABLE c_bankaccount_acct
	ADD CONSTRAINT vc_bunidentified_cbankaccount
		FOREIGN KEY (b_unidentified_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bankaccount_acct
	DROP CONSTRAINT IF EXISTS cacctschema_cbankaccountacct;
ALTER TABLE c_bankaccount_acct
	ADD CONSTRAINT cacctschema_cbankaccountacct
		FOREIGN KEY (c_acctschema_id) REFERENCES c_acctschema
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bp_customer_acct
	DROP CONSTRAINT IF EXISTS creceivableservices_cbpcustome;
ALTER TABLE c_bp_customer_acct
	ADD CONSTRAINT creceivableservices_cbpcustome
		FOREIGN KEY (c_receivable_services_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bp_customer_acct
	DROP CONSTRAINT IF EXISTS vc_cprepayment_cbpcustomer;
ALTER TABLE c_bp_customer_acct
	ADD CONSTRAINT vc_cprepayment_cbpcustomer
		FOREIGN KEY (c_prepayment_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bp_customer_acct
	DROP CONSTRAINT IF EXISTS vc_creceivable_cbpcustomer;
ALTER TABLE c_bp_customer_acct
	ADD CONSTRAINT vc_creceivable_cbpcustomer
		FOREIGN KEY (c_receivable_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bp_customer_acct
	DROP CONSTRAINT IF EXISTS cbuspartner_cbpcustomer_acct;
ALTER TABLE c_bp_customer_acct
	ADD CONSTRAINT cbuspartner_cbpcustomer_acct
		FOREIGN KEY (c_bpartner_id) REFERENCES c_bpartner
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bp_customer_acct
	DROP CONSTRAINT IF EXISTS cacctschema_cbpcustomeracct;
ALTER TABLE c_bp_customer_acct
	ADD CONSTRAINT cacctschema_cbpcustomeracct
		FOREIGN KEY (c_acctschema_id) REFERENCES c_acctschema
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bp_group
	DROP CONSTRAINT IF EXISTS adprintcolor_cbpgroup;
ALTER TABLE c_bp_group
	ADD CONSTRAINT adprintcolor_cbpgroup
		FOREIGN KEY (ad_printcolor_id) REFERENCES ad_printcolor
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bp_group
	DROP CONSTRAINT IF EXISTS mpricelist_cbpgroup;
ALTER TABLE c_bp_group
	ADD CONSTRAINT mpricelist_cbpgroup
		FOREIGN KEY (m_pricelist_id) REFERENCES m_pricelist
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bp_group
	DROP CONSTRAINT IF EXISTS mpricelistpo_cbpgroup;
ALTER TABLE c_bp_group
	ADD CONSTRAINT mpricelistpo_cbpgroup
		FOREIGN KEY (po_pricelist_id) REFERENCES m_pricelist
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bp_group
	DROP CONSTRAINT IF EXISTS mdiscountschema_cbpgroup;
ALTER TABLE c_bp_group
	ADD CONSTRAINT mdiscountschema_cbpgroup
		FOREIGN KEY (m_discountschema_id) REFERENCES m_discountschema
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bp_group
	DROP CONSTRAINT IF EXISTS mdiscountschemapo_cbpgroup;
ALTER TABLE c_bp_group
	ADD CONSTRAINT mdiscountschemapo_cbpgroup
		FOREIGN KEY (po_discountschema_id) REFERENCES m_discountschema
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bp_group
	DROP CONSTRAINT IF EXISTS cdunning_cbpgroup;
ALTER TABLE c_bp_group
	ADD CONSTRAINT cdunning_cbpgroup
		FOREIGN KEY (c_dunning_id) REFERENCES c_dunning
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bp_group_acct
	DROP CONSTRAINT IF EXISTS cbpgroup_cbpgroupacct;
ALTER TABLE c_bp_group_acct
	ADD CONSTRAINT cbpgroup_cbpgroupacct
		FOREIGN KEY (c_bp_group_id) REFERENCES c_bp_group
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bp_group_acct
	DROP CONSTRAINT IF EXISTS creceivableservices_cbpgroupac;
ALTER TABLE c_bp_group_acct
	ADD CONSTRAINT creceivableservices_cbpgroupac
		FOREIGN KEY (c_receivable_services_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bp_group_acct
	DROP CONSTRAINT IF EXISTS vc_cprepayment_cbpgroup;
ALTER TABLE c_bp_group_acct
	ADD CONSTRAINT vc_cprepayment_cbpgroup
		FOREIGN KEY (c_prepayment_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bp_group_acct
	DROP CONSTRAINT IF EXISTS vc_creceivable_cbpgroup;
ALTER TABLE c_bp_group_acct
	ADD CONSTRAINT vc_creceivable_cbpgroup
		FOREIGN KEY (c_receivable_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bp_group_acct
	DROP CONSTRAINT IF EXISTS vc_notinvoicedrec_cbpgroup;
ALTER TABLE c_bp_group_acct
	ADD CONSTRAINT vc_notinvoicedrec_cbpgroup
		FOREIGN KEY (notinvoicedreceivables_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bp_group_acct
	DROP CONSTRAINT IF EXISTS vc_notinvoicedreceipts_cbpgrou;
ALTER TABLE c_bp_group_acct
	ADD CONSTRAINT vc_notinvoicedreceipts_cbpgrou
		FOREIGN KEY (notinvoicedreceipts_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bp_group_acct
	DROP CONSTRAINT IF EXISTS vc_notinvoicedrevenue_cbpgroup;
ALTER TABLE c_bp_group_acct
	ADD CONSTRAINT vc_notinvoicedrevenue_cbpgroup
		FOREIGN KEY (notinvoicedrevenue_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bp_group_acct
	DROP CONSTRAINT IF EXISTS vc_paydiscountexp_cbpgroup;
ALTER TABLE c_bp_group_acct
	ADD CONSTRAINT vc_paydiscountexp_cbpgroup
		FOREIGN KEY (paydiscount_exp_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bp_group_acct
	DROP CONSTRAINT IF EXISTS vc_paydiscountrev_cbpgroup;
ALTER TABLE c_bp_group_acct
	ADD CONSTRAINT vc_paydiscountrev_cbpgroup
		FOREIGN KEY (paydiscount_rev_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bp_group_acct
	DROP CONSTRAINT IF EXISTS vc_unearnedrevenue_cbpgroup;
ALTER TABLE c_bp_group_acct
	ADD CONSTRAINT vc_unearnedrevenue_cbpgroup
		FOREIGN KEY (unearnedrevenue_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bp_group_acct
	DROP CONSTRAINT IF EXISTS vc_vliability_cbpgroup;
ALTER TABLE c_bp_group_acct
	ADD CONSTRAINT vc_vliability_cbpgroup
		FOREIGN KEY (v_liability_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bp_group_acct
	DROP CONSTRAINT IF EXISTS vc_vliabilityservices_cbpgroup;
ALTER TABLE c_bp_group_acct
	ADD CONSTRAINT vc_vliabilityservices_cbpgroup
		FOREIGN KEY (v_liability_services_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bp_group_acct
	DROP CONSTRAINT IF EXISTS vc_vprepayment_cbpgroup;
ALTER TABLE c_bp_group_acct
	ADD CONSTRAINT vc_vprepayment_cbpgroup
		FOREIGN KEY (v_prepayment_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bp_group_acct
	DROP CONSTRAINT IF EXISTS vc_writeoff_cbpgroup;
ALTER TABLE c_bp_group_acct
	ADD CONSTRAINT vc_writeoff_cbpgroup
		FOREIGN KEY (writeoff_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bp_group_acct
	DROP CONSTRAINT IF EXISTS cacctschema_cbpgroupacct;
ALTER TABLE c_bp_group_acct
	ADD CONSTRAINT cacctschema_cbpgroupacct
		FOREIGN KEY (c_acctschema_id) REFERENCES c_acctschema
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bp_vendor_acct
	DROP CONSTRAINT IF EXISTS vc_vliability_cbpvendor;
ALTER TABLE c_bp_vendor_acct
	ADD CONSTRAINT vc_vliability_cbpvendor
		FOREIGN KEY (v_liability_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bp_vendor_acct
	DROP CONSTRAINT IF EXISTS vc_vliabilityservices_cbpvendo;
ALTER TABLE c_bp_vendor_acct
	ADD CONSTRAINT vc_vliabilityservices_cbpvendo
		FOREIGN KEY (v_liability_services_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bp_vendor_acct
	DROP CONSTRAINT IF EXISTS vc_vprepayment_cbpvendor;
ALTER TABLE c_bp_vendor_acct
	ADD CONSTRAINT vc_vprepayment_cbpvendor
		FOREIGN KEY (v_prepayment_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bp_vendor_acct
	DROP CONSTRAINT IF EXISTS c_buspartner_c_bp_vendor_acct;
ALTER TABLE c_bp_vendor_acct
	ADD CONSTRAINT c_buspartner_c_bp_vendor_acct
		FOREIGN KEY (c_bpartner_id) REFERENCES c_bpartner
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bp_vendor_acct
	DROP CONSTRAINT IF EXISTS cacctschema_cbpvendoracct;
ALTER TABLE c_bp_vendor_acct
	ADD CONSTRAINT cacctschema_cbpvendoracct
		FOREIGN KEY (c_acctschema_id) REFERENCES c_acctschema
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bpartner_location
	DROP CONSTRAINT IF EXISTS clocation_cbplocation;
ALTER TABLE c_bpartner_location
	ADD CONSTRAINT clocation_cbplocation
		FOREIGN KEY (c_location_id) REFERENCES c_location
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bpartner_location
	DROP CONSTRAINT IF EXISTS cbpartner_cbplocation;
ALTER TABLE c_bpartner_location
	ADD CONSTRAINT cbpartner_cbplocation
		FOREIGN KEY (c_bpartner_id) REFERENCES c_bpartner
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bpartner_location
	DROP CONSTRAINT IF EXISTS c_buspartner_locationorg;
ALTER TABLE c_bpartner_location
	ADD CONSTRAINT c_buspartner_locationorg
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bpartner_location
	DROP CONSTRAINT IF EXISTS c_buspartner_locationclient;
ALTER TABLE c_bpartner_location
	ADD CONSTRAINT c_buspartner_locationclient
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bpartner_location
	DROP CONSTRAINT IF EXISTS csalesregion_bpartnerlocation;
ALTER TABLE c_bpartner_location
	ADD CONSTRAINT csalesregion_bpartnerlocation
		FOREIGN KEY (c_salesregion_id) REFERENCES c_salesregion
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_bpartner_location
	DROP CONSTRAINT IF EXISTS c_bpartner_location_ispreservecustomname_check;
ALTER TABLE c_bpartner_location
	ADD CONSTRAINT c_bpartner_location_ispreservecustomname_check
		CHECK (ispreservecustomname = ANY (ARRAY ['Y'::bpchar, 'N'::bpchar]));

ALTER TABLE c_calendar
	DROP CONSTRAINT IF EXISTS c_calendarorg;
ALTER TABLE c_calendar
	ADD CONSTRAINT c_calendarorg
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_calendar
	DROP CONSTRAINT IF EXISTS c_calendarclient;
ALTER TABLE c_calendar
	ADD CONSTRAINT c_calendarclient
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_campaign
	DROP CONSTRAINT IF EXISTS cchannel_ccampaign;
ALTER TABLE c_campaign
	ADD CONSTRAINT cchannel_ccampaign
		FOREIGN KEY (c_channel_id) REFERENCES c_channel
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_campaign_trl
	DROP CONSTRAINT IF EXISTS c_campaign_trl_uu_idx;
ALTER TABLE c_campaign_trl
	ADD CONSTRAINT c_campaign_trl_uu_idx
		UNIQUE (c_campaign_trl_uu);

ALTER TABLE c_campaign_trl
	DROP CONSTRAINT IF EXISTS adlanguage_ccampaigntrl;
ALTER TABLE c_campaign_trl
	ADD CONSTRAINT adlanguage_ccampaigntrl
		FOREIGN KEY (ad_language) REFERENCES ad_language
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_campaign_trl
	DROP CONSTRAINT IF EXISTS createdby_ccampaigntrl;
ALTER TABLE c_campaign_trl
	ADD CONSTRAINT createdby_ccampaigntrl
		FOREIGN KEY (createdby) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_campaign_trl
	DROP CONSTRAINT IF EXISTS updatedby_ccampaigntrl;
ALTER TABLE c_campaign_trl
	ADD CONSTRAINT updatedby_ccampaigntrl
		FOREIGN KEY (updatedby) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_campaign_trl
	DROP CONSTRAINT IF EXISTS adorg_ccampaigntrl;
ALTER TABLE c_campaign_trl
	ADD CONSTRAINT adorg_ccampaigntrl
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_campaign_trl
	DROP CONSTRAINT IF EXISTS adclient_ccampaigntrl;
ALTER TABLE c_campaign_trl
	ADD CONSTRAINT adclient_ccampaigntrl
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_campaign_trl
	DROP CONSTRAINT IF EXISTS ccampaign_ccampaigntrl;
ALTER TABLE c_campaign_trl
	ADD CONSTRAINT ccampaign_ccampaigntrl
		FOREIGN KEY (c_campaign_id) REFERENCES c_campaign
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_cashbook
	DROP CONSTRAINT IF EXISTS ccurrency_ccashbook;
ALTER TABLE c_cashbook
	ADD CONSTRAINT ccurrency_ccashbook
		FOREIGN KEY (c_currency_id) REFERENCES c_currency
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_cashbook_acct
	DROP CONSTRAINT IF EXISTS vc_cbasset_ccashbook;
ALTER TABLE c_cashbook_acct
	ADD CONSTRAINT vc_cbasset_ccashbook
		FOREIGN KEY (cb_asset_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_cashbook_acct
	DROP CONSTRAINT IF EXISTS vc_cbcashtransfer_ccashbook;
ALTER TABLE c_cashbook_acct
	ADD CONSTRAINT vc_cbcashtransfer_ccashbook
		FOREIGN KEY (cb_cashtransfer_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_cashbook_acct
	DROP CONSTRAINT IF EXISTS vc_cbdifferences_ccashbook;
ALTER TABLE c_cashbook_acct
	ADD CONSTRAINT vc_cbdifferences_ccashbook
		FOREIGN KEY (cb_differences_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_cashbook_acct
	DROP CONSTRAINT IF EXISTS vc_cbexpense_ccashbook;
ALTER TABLE c_cashbook_acct
	ADD CONSTRAINT vc_cbexpense_ccashbook
		FOREIGN KEY (cb_expense_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_cashbook_acct
	DROP CONSTRAINT IF EXISTS vc_cbreceipt_ccashbook;
ALTER TABLE c_cashbook_acct
	ADD CONSTRAINT vc_cbreceipt_ccashbook
		FOREIGN KEY (cb_receipt_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_cashbook_acct
	DROP CONSTRAINT IF EXISTS ccashbook_ccashbookacct;
ALTER TABLE c_cashbook_acct
	ADD CONSTRAINT ccashbook_ccashbookacct
		FOREIGN KEY (c_cashbook_id) REFERENCES c_cashbook
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_cashbook_acct
	DROP CONSTRAINT IF EXISTS cacctschema_ccashbookacct;
ALTER TABLE c_cashbook_acct
	ADD CONSTRAINT cacctschema_ccashbookacct
		FOREIGN KEY (c_acctschema_id) REFERENCES c_acctschema
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_channel
	DROP CONSTRAINT IF EXISTS adprintcolor_cchannel;
ALTER TABLE c_channel
	ADD CONSTRAINT adprintcolor_cchannel
		FOREIGN KEY (ad_printcolor_id) REFERENCES ad_printcolor
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_charge
	DROP CONSTRAINT IF EXISTS cbpartner_ccharge;
ALTER TABLE c_charge
	ADD CONSTRAINT cbpartner_ccharge
		FOREIGN KEY (c_bpartner_id) REFERENCES c_bpartner
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_charge
	DROP CONSTRAINT IF EXISTS ctaxcategory_ccharge;
ALTER TABLE c_charge
	ADD CONSTRAINT ctaxcategory_ccharge
		FOREIGN KEY (c_taxcategory_id) REFERENCES c_taxcategory
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_charge
	DROP CONSTRAINT IF EXISTS cchargetype_ccharge;
ALTER TABLE c_charge
	ADD CONSTRAINT cchargetype_ccharge
		FOREIGN KEY (c_chargetype_id) REFERENCES c_chargetype
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_charge_acct
	DROP CONSTRAINT IF EXISTS chrevenue_cchargeacct;
ALTER TABLE c_charge_acct
	ADD CONSTRAINT chrevenue_cchargeacct
		FOREIGN KEY (ch_revenue_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_charge_acct
	DROP CONSTRAINT IF EXISTS vc_chexpense_ccharge;
ALTER TABLE c_charge_acct
	ADD CONSTRAINT vc_chexpense_ccharge
		FOREIGN KEY (ch_expense_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_charge_acct
	DROP CONSTRAINT IF EXISTS cchrage_cchargeacct;
ALTER TABLE c_charge_acct
	ADD CONSTRAINT cchrage_cchargeacct
		FOREIGN KEY (c_charge_id) REFERENCES c_charge
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_charge_acct
	DROP CONSTRAINT IF EXISTS cacctschema_cchargeacct;
ALTER TABLE c_charge_acct
	ADD CONSTRAINT cacctschema_cchargeacct
		FOREIGN KEY (c_acctschema_id) REFERENCES c_acctschema
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_charge_trl
	DROP CONSTRAINT IF EXISTS adlangu_cchargetrl;
ALTER TABLE c_charge_trl
	ADD CONSTRAINT adlangu_cchargetrl
		FOREIGN KEY (ad_language) REFERENCES ad_language
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_charge_trl
	DROP CONSTRAINT IF EXISTS ccharge_cchargetrl;
ALTER TABLE c_charge_trl
	ADD CONSTRAINT ccharge_cchargetrl
		FOREIGN KEY (c_charge_id) REFERENCES c_charge
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_cycle
	DROP CONSTRAINT IF EXISTS ccurrency_ccycle;
ALTER TABLE c_cycle
	ADD CONSTRAINT ccurrency_ccycle
		FOREIGN KEY (c_currency_id) REFERENCES c_currency
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_doctype
	DROP CONSTRAINT IF EXISTS ad_sequence_doctypedoc;
ALTER TABLE c_doctype
	ADD CONSTRAINT ad_sequence_doctypedoc
		FOREIGN KEY (docnosequence_id) REFERENCES ad_sequence
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_doctype
	DROP CONSTRAINT IF EXISTS definitesequence_cdoctype;
ALTER TABLE c_doctype
	ADD CONSTRAINT definitesequence_cdoctype
		FOREIGN KEY (definitesequence_id) REFERENCES ad_sequence
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_doctype
	DROP CONSTRAINT IF EXISTS adprintformat_cdoctype;
ALTER TABLE c_doctype
	ADD CONSTRAINT adprintformat_cdoctype
		FOREIGN KEY (ad_printformat_id) REFERENCES ad_printformat
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_doctype
	DROP CONSTRAINT IF EXISTS cdoctype_invoice;
ALTER TABLE c_doctype
	ADD CONSTRAINT cdoctype_invoice
		FOREIGN KEY (c_doctypeinvoice_id) REFERENCES c_doctype
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_doctype
	DROP CONSTRAINT IF EXISTS cdoctype_proforma;
ALTER TABLE c_doctype
	ADD CONSTRAINT cdoctype_proforma
		FOREIGN KEY (c_doctypeproforma_id) REFERENCES c_doctype
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_doctype
	DROP CONSTRAINT IF EXISTS cdoctype_shipment;
ALTER TABLE c_doctype
	ADD CONSTRAINT cdoctype_shipment
		FOREIGN KEY (c_doctypeshipment_id) REFERENCES c_doctype
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_doctype
	DROP CONSTRAINT IF EXISTS cdoctypedifference_cdoctype;
ALTER TABLE c_doctype
	ADD CONSTRAINT cdoctypedifference_cdoctype
		FOREIGN KEY (c_doctypedifference_id) REFERENCES c_doctype
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_doctype
	DROP CONSTRAINT IF EXISTS glcategory_cdoctype;
ALTER TABLE c_doctype
	ADD CONSTRAINT glcategory_cdoctype
		FOREIGN KEY (gl_category_id) REFERENCES gl_category
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_doctype_trl
	DROP CONSTRAINT IF EXISTS adlanguage_cdoctypetrl;
ALTER TABLE c_doctype_trl
	ADD CONSTRAINT adlanguage_cdoctypetrl
		FOREIGN KEY (ad_language) REFERENCES ad_language
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_doctype_trl
	DROP CONSTRAINT IF EXISTS cdoctype_cdoctypetrl;
ALTER TABLE c_doctype_trl
	ADD CONSTRAINT cdoctype_cdoctypetrl
		FOREIGN KEY (c_doctype_id) REFERENCES c_doctype
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_location
	DROP CONSTRAINT IF EXISTS c_region_location;
ALTER TABLE c_location
	ADD CONSTRAINT c_region_location
		FOREIGN KEY (c_region_id) REFERENCES c_region
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_location
	DROP CONSTRAINT IF EXISTS c_country_location;
ALTER TABLE c_location
	ADD CONSTRAINT c_country_location
		FOREIGN KEY (c_country_id) REFERENCES c_country
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_location
	DROP CONSTRAINT IF EXISTS adorg_clocation;
ALTER TABLE c_location
	ADD CONSTRAINT adorg_clocation
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_location
	DROP CONSTRAINT IF EXISTS adclient_clocation;
ALTER TABLE c_location
	ADD CONSTRAINT adclient_clocation
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_location
	DROP CONSTRAINT IF EXISTS ccity_clocation;
ALTER TABLE c_location
	ADD CONSTRAINT ccity_clocation
		FOREIGN KEY (c_city_id) REFERENCES c_city
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_location
	DROP CONSTRAINT IF EXISTS caddressvalidation_clocation;
ALTER TABLE c_location
	ADD CONSTRAINT caddressvalidation_clocation
		FOREIGN KEY (c_addressvalidation_id) REFERENCES c_addressvalidation
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoice
	ADD IF NOT EXISTS isoverridecurrencyrate char DEFAULT 'N'::bpchar NOT NULL;

ALTER TABLE c_invoice
	ADD IF NOT EXISTS currencyrate numeric;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS celementvalueuser1_cinvoice;
ALTER TABLE c_invoice
	ADD CONSTRAINT celementvalueuser1_cinvoice
		FOREIGN KEY (user1_id) REFERENCES c_elementvalue
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS celementvalueuser2_cinvoice;
ALTER TABLE c_invoice
	ADD CONSTRAINT celementvalueuser2_cinvoice
		FOREIGN KEY (user2_id) REFERENCES c_elementvalue
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS ccurrency_cinvoice;
ALTER TABLE c_invoice
	ADD CONSTRAINT ccurrency_cinvoice
		FOREIGN KEY (c_currency_id) REFERENCES c_currency
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS cdoctype_cinvoice;
ALTER TABLE c_invoice
	ADD CONSTRAINT cdoctype_cinvoice
		FOREIGN KEY (c_doctype_id) REFERENCES c_doctype
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS cdoctypetarget_cinvoice;
ALTER TABLE c_invoice
	ADD CONSTRAINT cdoctypetarget_cinvoice
		FOREIGN KEY (c_doctypetarget_id) REFERENCES c_doctype
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS cbpartner_cinvoice;
ALTER TABLE c_invoice
	ADD CONSTRAINT cbpartner_cinvoice
		FOREIGN KEY (c_bpartner_id) REFERENCES c_bpartner
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS corder_cinvoice;
ALTER TABLE c_invoice
	ADD CONSTRAINT corder_cinvoice
		FOREIGN KEY (c_order_id) REFERENCES c_order
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS cinvoice_ref;
ALTER TABLE c_invoice
	ADD CONSTRAINT cinvoice_ref
		FOREIGN KEY (ref_invoice_id) REFERENCES c_invoice
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS relatedinvoice_cinvoice;
ALTER TABLE c_invoice
	ADD CONSTRAINT relatedinvoice_cinvoice
		FOREIGN KEY (relatedinvoice_id) REFERENCES c_invoice
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS reversal_cinvoice;
ALTER TABLE c_invoice
	ADD CONSTRAINT reversal_cinvoice
		FOREIGN KEY (reversal_id) REFERENCES c_invoice
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS c_bplocation_cinvoice;
ALTER TABLE c_invoice
	ADD CONSTRAINT c_bplocation_cinvoice
		FOREIGN KEY (c_bpartner_location_id) REFERENCES c_bpartner_location
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS aduser_cinvoice;
ALTER TABLE c_invoice
	ADD CONSTRAINT aduser_cinvoice
		FOREIGN KEY (ad_user_id) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS aduser_sr_cinvoice;
ALTER TABLE c_invoice
	ADD CONSTRAINT aduser_sr_cinvoice
		FOREIGN KEY (salesrep_id) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS adorg_cinvoice;
ALTER TABLE c_invoice
	ADD CONSTRAINT adorg_cinvoice
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS adorgtrx_cinvoice;
ALTER TABLE c_invoice
	ADD CONSTRAINT adorgtrx_cinvoice
		FOREIGN KEY (ad_orgtrx_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS cpaymentterm_cinvoice;
ALTER TABLE c_invoice
	ADD CONSTRAINT cpaymentterm_cinvoice
		FOREIGN KEY (c_paymentterm_id) REFERENCES c_paymentterm
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS mpricelist_cinvoice;
ALTER TABLE c_invoice
	ADD CONSTRAINT mpricelist_cinvoice
		FOREIGN KEY (m_pricelist_id) REFERENCES m_pricelist
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS ccashline_cinvoice;
ALTER TABLE c_invoice
	ADD CONSTRAINT ccashline_cinvoice
		FOREIGN KEY (c_cashline_id) REFERENCES c_cashline
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS cdunninglevel_cinvoice;
ALTER TABLE c_invoice
	ADD CONSTRAINT cdunninglevel_cinvoice
		FOREIGN KEY (c_dunninglevel_id) REFERENCES c_dunninglevel
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS cproject_cinvoice;
ALTER TABLE c_invoice
	ADD CONSTRAINT cproject_cinvoice
		FOREIGN KEY (c_project_id) REFERENCES c_project
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS cconversiontype_cinvoice;
ALTER TABLE c_invoice
	ADD CONSTRAINT cconversiontype_cinvoice
		FOREIGN KEY (c_conversiontype_id) REFERENCES c_conversiontype
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS cpayment_cinvoice;
ALTER TABLE c_invoice
	ADD CONSTRAINT cpayment_cinvoice
		FOREIGN KEY (c_payment_id) REFERENCES c_payment
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS ccampaign_cinvoice;
ALTER TABLE c_invoice
	ADD CONSTRAINT ccampaign_cinvoice
		FOREIGN KEY (c_campaign_id) REFERENCES c_campaign
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS ccharge_cinvoice;
ALTER TABLE c_invoice
	ADD CONSTRAINT ccharge_cinvoice
		FOREIGN KEY (c_charge_id) REFERENCES c_charge
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS mrma_cinvoice;
ALTER TABLE c_invoice
	ADD CONSTRAINT mrma_cinvoice
		FOREIGN KEY (m_rma_id) REFERENCES m_rma
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS cactivity_cinvoice;
ALTER TABLE c_invoice
	ADD CONSTRAINT cactivity_cinvoice
		FOREIGN KEY (c_activity_id) REFERENCES c_activity
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS ccashplanline_cinvoice;
ALTER TABLE c_invoice
	ADD CONSTRAINT ccashplanline_cinvoice
		FOREIGN KEY (c_cashplanline_id) REFERENCES c_cashplanline
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS c_invoice_isoverridecurrencyrate_check;
ALTER TABLE c_invoice
	ADD CONSTRAINT c_invoice_isoverridecurrencyrate_check
		CHECK (isoverridecurrencyrate = ANY (ARRAY ['Y'::bpchar, 'N'::bpchar]));

ALTER TABLE c_payment
	ADD IF NOT EXISTS isoverridecurrencyrate char DEFAULT 'N'::bpchar NOT NULL;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS celementvalueuser1_cpayment;
ALTER TABLE c_payment
	ADD CONSTRAINT celementvalueuser1_cpayment
		FOREIGN KEY (user1_id) REFERENCES c_elementvalue
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS celementvalueuser2_cpayment;
ALTER TABLE c_payment
	ADD CONSTRAINT celementvalueuser2_cpayment
		FOREIGN KEY (user2_id) REFERENCES c_elementvalue
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS ccurrency_cpayment;
ALTER TABLE c_payment
	ADD CONSTRAINT ccurrency_cpayment
		FOREIGN KEY (c_currency_id) REFERENCES c_currency
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS cdoctype_cpayment;
ALTER TABLE c_payment
	ADD CONSTRAINT cdoctype_cpayment
		FOREIGN KEY (c_doctype_id) REFERENCES c_doctype
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS cbpartner_cpayment;
ALTER TABLE c_payment
	ADD CONSTRAINT cbpartner_cpayment
		FOREIGN KEY (c_bpartner_id) REFERENCES c_bpartner
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS cinvoice_cpayment;
ALTER TABLE c_payment
	ADD CONSTRAINT cinvoice_cpayment
		FOREIGN KEY (c_invoice_id) REFERENCES c_invoice
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS corder_cpayment;
ALTER TABLE c_payment
	ADD CONSTRAINT corder_cpayment
		FOREIGN KEY (c_order_id) REFERENCES c_order
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS adorg_cpayment;
ALTER TABLE c_payment
	ADD CONSTRAINT adorg_cpayment
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS adorgtrx_cpayment;
ALTER TABLE c_payment
	ADD CONSTRAINT adorgtrx_cpayment
		FOREIGN KEY (ad_orgtrx_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS cpaymentprocessor_cpayment;
ALTER TABLE c_payment
	ADD CONSTRAINT cpaymentprocessor_cpayment
		FOREIGN KEY (c_paymentprocessor_id) REFERENCES c_paymentprocessor
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS cbankaccount_cpayment;
ALTER TABLE c_payment
	ADD CONSTRAINT cbankaccount_cpayment
		FOREIGN KEY (c_bankaccount_id) REFERENCES c_bankaccount
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS cproject_cpayment;
ALTER TABLE c_payment
	ADD CONSTRAINT cproject_cpayment
		FOREIGN KEY (c_project_id) REFERENCES c_project
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS cconversiontype_cpayment;
ALTER TABLE c_payment
	ADD CONSTRAINT cconversiontype_cpayment
		FOREIGN KEY (c_conversiontype_id) REFERENCES c_conversiontype
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS refpayment_cpayment;
ALTER TABLE c_payment
	ADD CONSTRAINT refpayment_cpayment
		FOREIGN KEY (ref_payment_id) REFERENCES c_payment
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS reversal_cpayment;
ALTER TABLE c_payment
	ADD CONSTRAINT reversal_cpayment
		FOREIGN KEY (reversal_id) REFERENCES c_payment
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS ccampaign_cpayment;
ALTER TABLE c_payment
	ADD CONSTRAINT ccampaign_cpayment
		FOREIGN KEY (c_campaign_id) REFERENCES c_campaign
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS ccharge_cpayment;
ALTER TABLE c_payment
	ADD CONSTRAINT ccharge_cpayment
		FOREIGN KEY (c_charge_id) REFERENCES c_charge
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS c_payment__c_cashbo_c_cashbook;
ALTER TABLE c_payment
	ADD CONSTRAINT c_payment__c_cashbo_c_cashbook
		FOREIGN KEY (c_cashbook_id) REFERENCES c_cashbook
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS cbpbankacct_cpayment;
ALTER TABLE c_payment
	ADD CONSTRAINT cbpbankacct_cpayment
		FOREIGN KEY (c_bp_bankaccount_id) REFERENCES c_bp_bankaccount
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS cactivity_cpayment;
ALTER TABLE c_payment
	ADD CONSTRAINT cactivity_cpayment
		FOREIGN KEY (c_activity_id) REFERENCES c_activity
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS cdepositbatch_cpayment;
ALTER TABLE c_payment
	ADD CONSTRAINT cdepositbatch_cpayment
		FOREIGN KEY (c_depositbatch_id) REFERENCES c_depositbatch
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS cpaymentbatch_cpayment;
ALTER TABLE c_payment
	ADD CONSTRAINT cpaymentbatch_cpayment
		FOREIGN KEY (c_paymentbatch_id) REFERENCES c_paymentbatch
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS cpostendertype_cpayment;
ALTER TABLE c_payment
	ADD CONSTRAINT cpostendertype_cpayment
		FOREIGN KEY (c_postendertype_id) REFERENCES c_postendertype
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS c_payment_isoverridecurrencyrate_check;
ALTER TABLE c_payment
	ADD CONSTRAINT c_payment_isoverridecurrencyrate_check
		CHECK (isoverridecurrencyrate = ANY (ARRAY ['Y'::bpchar, 'N'::bpchar]));

ALTER TABLE c_paymentterm_trl
	DROP CONSTRAINT IF EXISTS adlanguage_cpaymenttermtrl;
ALTER TABLE c_paymentterm_trl
	ADD CONSTRAINT adlanguage_cpaymenttermtrl
		FOREIGN KEY (ad_language) REFERENCES ad_language
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_paymentterm_trl
	DROP CONSTRAINT IF EXISTS cpaymentterm_cpaytermtrl;
ALTER TABLE c_paymentterm_trl
	ADD CONSTRAINT cpaymentterm_cpaytermtrl
		FOREIGN KEY (c_paymentterm_id) REFERENCES c_paymentterm
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_element
	DROP CONSTRAINT IF EXISTS adtree_celement;
ALTER TABLE c_element
	ADD CONSTRAINT adtree_celement
		FOREIGN KEY (ad_tree_id) REFERENCES ad_tree
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_element
	DROP CONSTRAINT IF EXISTS c_elementorg;
ALTER TABLE c_element
	ADD CONSTRAINT c_elementorg
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_element
	DROP CONSTRAINT IF EXISTS adclient_celement;
ALTER TABLE c_element
	ADD CONSTRAINT adclient_celement
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_elementvalue
	DROP CONSTRAINT IF EXISTS ccurrency_celementvalue;
ALTER TABLE c_elementvalue
	ADD CONSTRAINT ccurrency_celementvalue
		FOREIGN KEY (c_currency_id) REFERENCES c_currency
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_elementvalue
	DROP CONSTRAINT IF EXISTS adorg_celementvalue;
ALTER TABLE c_elementvalue
	ADD CONSTRAINT adorg_celementvalue
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_elementvalue
	DROP CONSTRAINT IF EXISTS cbankaccount_celementvalue;
ALTER TABLE c_elementvalue
	ADD CONSTRAINT cbankaccount_celementvalue
		FOREIGN KEY (c_bankaccount_id) REFERENCES c_bankaccount
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_elementvalue
	DROP CONSTRAINT IF EXISTS adclient_celementvalue;
ALTER TABLE c_elementvalue
	ADD CONSTRAINT adclient_celementvalue
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_elementvalue
	DROP CONSTRAINT IF EXISTS celement_celementvalue;
ALTER TABLE c_elementvalue
	ADD CONSTRAINT celement_celementvalue
		FOREIGN KEY (c_element_id) REFERENCES c_element
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_elementvalue_trl
	DROP CONSTRAINT IF EXISTS celementvalue_cevaluetrl;
ALTER TABLE c_elementvalue_trl
	ADD CONSTRAINT celementvalue_cevaluetrl
		FOREIGN KEY (c_elementvalue_id) REFERENCES c_elementvalue
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_elementvalue_trl
	DROP CONSTRAINT IF EXISTS adlanguage_celementvaluetrl;
ALTER TABLE c_elementvalue_trl
	ADD CONSTRAINT adlanguage_celementvaluetrl
		FOREIGN KEY (ad_language) REFERENCES ad_language
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS celemenrvalueuser2_corder;
ALTER TABLE c_order
	ADD CONSTRAINT celemenrvalueuser2_corder
		FOREIGN KEY (user2_id) REFERENCES c_elementvalue
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS celementvalueuser1_corder;
ALTER TABLE c_order
	ADD CONSTRAINT celementvalueuser1_corder
		FOREIGN KEY (user1_id) REFERENCES c_elementvalue
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS ccurrency_corder;
ALTER TABLE c_order
	ADD CONSTRAINT ccurrency_corder
		FOREIGN KEY (c_currency_id) REFERENCES c_currency
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_doctype_corder;
ALTER TABLE c_order
	ADD CONSTRAINT c_doctype_corder
		FOREIGN KEY (c_doctype_id) REFERENCES c_doctype
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS cdoctypetarget_corder;
ALTER TABLE c_order
	ADD CONSTRAINT cdoctypetarget_corder
		FOREIGN KEY (c_doctypetarget_id) REFERENCES c_doctype
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS cbpartner_corder;
ALTER TABLE c_order
	ADD CONSTRAINT cbpartner_corder
		FOREIGN KEY (c_bpartner_id) REFERENCES c_bpartner
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS cbpartnerbill_corder;
ALTER TABLE c_order
	ADD CONSTRAINT cbpartnerbill_corder
		FOREIGN KEY (bill_bpartner_id) REFERENCES c_bpartner
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS cbpartnerpay_corder;
ALTER TABLE c_order
	ADD CONSTRAINT cbpartnerpay_corder
		FOREIGN KEY (pay_bpartner_id) REFERENCES c_bpartner
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS dropshipbpartner_corder;
ALTER TABLE c_order
	ADD CONSTRAINT dropshipbpartner_corder
		FOREIGN KEY (dropship_bpartner_id) REFERENCES c_bpartner
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS corder_ref;
ALTER TABLE c_order
	ADD CONSTRAINT corder_ref
		FOREIGN KEY (ref_order_id) REFERENCES c_order
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS linkorder_corder;
ALTER TABLE c_order
	ADD CONSTRAINT linkorder_corder
		FOREIGN KEY (link_order_id) REFERENCES c_order
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS quotationorder_corder;
ALTER TABLE c_order
	ADD CONSTRAINT quotationorder_corder
		FOREIGN KEY (quotationorder_id) REFERENCES c_order
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS cbpartnerlocation_corder;
ALTER TABLE c_order
	ADD CONSTRAINT cbpartnerlocation_corder
		FOREIGN KEY (c_bpartner_location_id) REFERENCES c_bpartner_location
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS aduser_corder;
ALTER TABLE c_order
	ADD CONSTRAINT aduser_corder
		FOREIGN KEY (ad_user_id) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS aduser_sr_corder;
ALTER TABLE c_order
	ADD CONSTRAINT aduser_sr_corder
		FOREIGN KEY (salesrep_id) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS aduserbill_corder;
ALTER TABLE c_order
	ADD CONSTRAINT aduserbill_corder
		FOREIGN KEY (bill_user_id) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS dropshipuser_corder;
ALTER TABLE c_order
	ADD CONSTRAINT dropshipuser_corder
		FOREIGN KEY (dropship_user_id) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS cbplocationbill_corder;
ALTER TABLE c_order
	ADD CONSTRAINT cbplocationbill_corder
		FOREIGN KEY (bill_location_id) REFERENCES c_bpartner_location
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS cbplocationpay_corder;
ALTER TABLE c_order
	ADD CONSTRAINT cbplocationpay_corder
		FOREIGN KEY (pay_location_id) REFERENCES c_bpartner_location
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS dropshiplocation_corder;
ALTER TABLE c_order
	ADD CONSTRAINT dropshiplocation_corder
		FOREIGN KEY (dropship_location_id) REFERENCES c_bpartner_location
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS mwarehouse_corder;
ALTER TABLE c_order
	ADD CONSTRAINT mwarehouse_corder
		FOREIGN KEY (m_warehouse_id) REFERENCES m_warehouse
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS adorg_corder;
ALTER TABLE c_order
	ADD CONSTRAINT adorg_corder
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS adorgtrx_corder;
ALTER TABLE c_order
	ADD CONSTRAINT adorgtrx_corder
		FOREIGN KEY (ad_orgtrx_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS cpaymentterm_soheader;
ALTER TABLE c_order
	ADD CONSTRAINT cpaymentterm_soheader
		FOREIGN KEY (c_paymentterm_id) REFERENCES c_paymentterm
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS mpricelist_soheader;
ALTER TABLE c_order
	ADD CONSTRAINT mpricelist_soheader
		FOREIGN KEY (m_pricelist_id) REFERENCES m_pricelist
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS ccashline_corder;
ALTER TABLE c_order
	ADD CONSTRAINT ccashline_corder
		FOREIGN KEY (c_cashline_id) REFERENCES c_cashline
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS cproject_corder;
ALTER TABLE c_order
	ADD CONSTRAINT cproject_corder
		FOREIGN KEY (c_project_id) REFERENCES c_project
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS cconversiontype_corder;
ALTER TABLE c_order
	ADD CONSTRAINT cconversiontype_corder
		FOREIGN KEY (c_conversiontype_id) REFERENCES c_conversiontype
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS cpayment_corder;
ALTER TABLE c_order
	ADD CONSTRAINT cpayment_corder
		FOREIGN KEY (c_payment_id) REFERENCES c_payment
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS mshipper_corder;
ALTER TABLE c_order
	ADD CONSTRAINT mshipper_corder
		FOREIGN KEY (m_shipper_id) REFERENCES m_shipper
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS ccampaign_corder;
ALTER TABLE c_order
	ADD CONSTRAINT ccampaign_corder
		FOREIGN KEY (c_campaign_id) REFERENCES c_campaign
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS ccharge_corder;
ALTER TABLE c_order
	ADD CONSTRAINT ccharge_corder
		FOREIGN KEY (c_charge_id) REFERENCES c_charge
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS mfreightcategory_order;
ALTER TABLE c_order
	ADD CONSTRAINT mfreightcategory_order
		FOREIGN KEY (m_freightcategory_id) REFERENCES m_freightcategory
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS cpos_corder;
ALTER TABLE c_order
	ADD CONSTRAINT cpos_corder
		FOREIGN KEY (c_pos_id) REFERENCES c_pos
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS cactivity_corder;
ALTER TABLE c_order
	ADD CONSTRAINT cactivity_corder
		FOREIGN KEY (c_activity_id) REFERENCES c_activity
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS ccashplanline_corder;
ALTER TABLE c_order
	ADD CONSTRAINT ccashplanline_corder
		FOREIGN KEY (c_cashplanline_id) REFERENCES c_cashplanline
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS copportunity_corder;
ALTER TABLE c_order
	ADD CONSTRAINT copportunity_corder
		FOREIGN KEY (c_opportunity_id) REFERENCES c_opportunity
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order__c_orders_c_ordersou;
ALTER TABLE c_order
	ADD CONSTRAINT c_order__c_orders_c_ordersou
		FOREIGN KEY (c_ordersource_id) REFERENCES c_ordersource
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS celemenrvalueuser1_corderline;
ALTER TABLE c_orderline
	ADD CONSTRAINT celemenrvalueuser1_corderline
		FOREIGN KEY (user1_id) REFERENCES c_elementvalue
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS celemenrvalueuser2_corderline;
ALTER TABLE c_orderline
	ADD CONSTRAINT celemenrvalueuser2_corderline
		FOREIGN KEY (user2_id) REFERENCES c_elementvalue
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS ccurrency_corderline;
ALTER TABLE c_orderline
	ADD CONSTRAINT ccurrency_corderline
		FOREIGN KEY (c_currency_id) REFERENCES c_currency
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS mproduct_corderline;
ALTER TABLE c_orderline
	ADD CONSTRAINT mproduct_corderline
		FOREIGN KEY (m_product_id) REFERENCES m_product
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS corderline_ref;
ALTER TABLE c_orderline
	ADD CONSTRAINT corderline_ref
		FOREIGN KEY (ref_orderline_id) REFERENCES c_orderline
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS linkorderline_corderline;
ALTER TABLE c_orderline
	ADD CONSTRAINT linkorderline_corderline
		FOREIGN KEY (link_orderline_id) REFERENCES c_orderline
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS cbpartner_soline;
ALTER TABLE c_orderline
	ADD CONSTRAINT cbpartner_soline
		FOREIGN KEY (c_bpartner_id) REFERENCES c_bpartner
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS corder_corderline;
ALTER TABLE c_orderline
	ADD CONSTRAINT corder_corderline
		FOREIGN KEY (c_order_id) REFERENCES c_order
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS cuom_corderline;
ALTER TABLE c_orderline
	ADD CONSTRAINT cuom_corderline
		FOREIGN KEY (c_uom_id) REFERENCES c_uom
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS cbpartnerlocation_soline;
ALTER TABLE c_orderline
	ADD CONSTRAINT cbpartnerlocation_soline
		FOREIGN KEY (c_bpartner_location_id) REFERENCES c_bpartner_location
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS mwarehouse_corderline;
ALTER TABLE c_orderline
	ADD CONSTRAINT mwarehouse_corderline
		FOREIGN KEY (m_warehouse_id) REFERENCES m_warehouse
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS ctax_corderline;
ALTER TABLE c_orderline
	ADD CONSTRAINT ctax_corderline
		FOREIGN KEY (c_tax_id) REFERENCES c_tax
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS adorg_corderline;
ALTER TABLE c_orderline
	ADD CONSTRAINT adorg_corderline
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS adorgtrx_corderline;
ALTER TABLE c_orderline
	ADD CONSTRAINT adorgtrx_corderline
		FOREIGN KEY (ad_orgtrx_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS mattrsetinst_corderline;
ALTER TABLE c_orderline
	ADD CONSTRAINT mattrsetinst_corderline
		FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS cproject_corderline;
ALTER TABLE c_orderline
	ADD CONSTRAINT cproject_corderline
		FOREIGN KEY (c_project_id) REFERENCES c_project
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS mshipper_corderline;
ALTER TABLE c_orderline
	ADD CONSTRAINT mshipper_corderline
		FOREIGN KEY (m_shipper_id) REFERENCES m_shipper
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS ccampaign_corderline;
ALTER TABLE c_orderline
	ADD CONSTRAINT ccampaign_corderline
		FOREIGN KEY (c_campaign_id) REFERENCES c_campaign
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS sresourceassign_corderline;
ALTER TABLE c_orderline
	ADD CONSTRAINT sresourceassign_corderline
		FOREIGN KEY (s_resourceassignment_id) REFERENCES s_resourceassignment
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS ccharge_corderline;
ALTER TABLE c_orderline
	ADD CONSTRAINT ccharge_corderline
		FOREIGN KEY (c_charge_id) REFERENCES c_charge
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS cactivity_corderline;
ALTER TABLE c_orderline
	ADD CONSTRAINT cactivity_corderline
		FOREIGN KEY (c_activity_id) REFERENCES c_activity
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS cprojecttask_corderline;
ALTER TABLE c_orderline
	ADD CONSTRAINT cprojecttask_corderline
		FOREIGN KEY (c_projecttask_id) REFERENCES c_projecttask
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS cprojectphase_corderline;
ALTER TABLE c_orderline
	ADD CONSTRAINT cprojectphase_corderline
		FOREIGN KEY (c_projectphase_id) REFERENCES c_projectphase
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS mpromotion_corderline;
ALTER TABLE c_orderline
	ADD CONSTRAINT mpromotion_corderline
		FOREIGN KEY (m_promotion_id) REFERENCES m_promotion
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS ppcostcollector_corderline;
ALTER TABLE c_orderline
	ADD CONSTRAINT ppcostcollector_corderline
		FOREIGN KEY (pp_cost_collector_id) REFERENCES pp_cost_collector
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS celemenrvalueuser1_cinvline;
ALTER TABLE c_invoiceline
	ADD CONSTRAINT celemenrvalueuser1_cinvline
		FOREIGN KEY (user1_id) REFERENCES c_elementvalue
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS celemenrvalueuser2_cinvline;
ALTER TABLE c_invoiceline
	ADD CONSTRAINT celemenrvalueuser2_cinvline
		FOREIGN KEY (user2_id) REFERENCES c_elementvalue
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS corderline_cinvoiceline;
ALTER TABLE c_invoiceline
	ADD CONSTRAINT corderline_cinvoiceline
		FOREIGN KEY (c_orderline_id) REFERENCES c_orderline
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS mproduct_cinvoiceline;
ALTER TABLE c_invoiceline
	ADD CONSTRAINT mproduct_cinvoiceline
		FOREIGN KEY (m_product_id) REFERENCES m_product
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS convoiceline_ref;
ALTER TABLE c_invoiceline
	ADD CONSTRAINT convoiceline_ref
		FOREIGN KEY (ref_invoiceline_id) REFERENCES c_invoiceline
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS minoutline_cinvoiceline;
ALTER TABLE c_invoiceline
	ADD CONSTRAINT minoutline_cinvoiceline
		FOREIGN KEY (m_inoutline_id) REFERENCES m_inoutline
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS cinvoice_cinvoiceline;
ALTER TABLE c_invoiceline
	ADD CONSTRAINT cinvoice_cinvoiceline
		FOREIGN KEY (c_invoice_id) REFERENCES c_invoice
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS cuom_cinvoiceline;
ALTER TABLE c_invoiceline
	ADD CONSTRAINT cuom_cinvoiceline
		FOREIGN KEY (c_uom_id) REFERENCES c_uom
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS aassetgroup_cinvoiceline;
ALTER TABLE c_invoiceline
	ADD CONSTRAINT aassetgroup_cinvoiceline
		FOREIGN KEY (a_asset_group_id) REFERENCES a_asset_group
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS ctax_cinvoiceline;
ALTER TABLE c_invoiceline
	ADD CONSTRAINT ctax_cinvoiceline
		FOREIGN KEY (c_tax_id) REFERENCES c_tax
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS adorg_cinvoiceline;
ALTER TABLE c_invoiceline
	ADD CONSTRAINT adorg_cinvoiceline
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS adorgtrx_cinvoiceline;
ALTER TABLE c_invoiceline
	ADD CONSTRAINT adorgtrx_cinvoiceline
		FOREIGN KEY (ad_orgtrx_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS mattrsetinst_cinvoiceline;
ALTER TABLE c_invoiceline
	ADD CONSTRAINT mattrsetinst_cinvoiceline
		FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS cproject_cinvoiceline;
ALTER TABLE c_invoiceline
	ADD CONSTRAINT cproject_cinvoiceline
		FOREIGN KEY (c_project_id) REFERENCES c_project
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS ccampaign_cinvoiceline;
ALTER TABLE c_invoiceline
	ADD CONSTRAINT ccampaign_cinvoiceline
		FOREIGN KEY (c_campaign_id) REFERENCES c_campaign
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS sresourceassign_cinvoiceline;
ALTER TABLE c_invoiceline
	ADD CONSTRAINT sresourceassign_cinvoiceline
		FOREIGN KEY (s_resourceassignment_id) REFERENCES s_resourceassignment
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS ccharge_cinvoiceline;
ALTER TABLE c_invoiceline
	ADD CONSTRAINT ccharge_cinvoiceline
		FOREIGN KEY (c_charge_id) REFERENCES c_charge
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS mrmaline_cinvoiceline;
ALTER TABLE c_invoiceline
	ADD CONSTRAINT mrmaline_cinvoiceline
		FOREIGN KEY (m_rmaline_id) REFERENCES m_rmaline
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS aasset_cinvoiceline;
ALTER TABLE c_invoiceline
	ADD CONSTRAINT aasset_cinvoiceline
		FOREIGN KEY (a_asset_id) REFERENCES a_asset
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS c1099box_cinvoiceline;
ALTER TABLE c_invoiceline
	ADD CONSTRAINT c1099box_cinvoiceline
		FOREIGN KEY (c_1099box_id) REFERENCES c_1099box
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS cactivity_cinvoiceline;
ALTER TABLE c_invoiceline
	ADD CONSTRAINT cactivity_cinvoiceline
		FOREIGN KEY (c_activity_id) REFERENCES c_activity
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS cprojectphase_cinvoiceline;
ALTER TABLE c_invoiceline
	ADD CONSTRAINT cprojectphase_cinvoiceline
		FOREIGN KEY (c_projectphase_id) REFERENCES c_projectphase
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS cprojecttask_cinvoiceline;
ALTER TABLE c_invoiceline
	ADD CONSTRAINT cprojecttask_cinvoiceline
		FOREIGN KEY (c_projecttask_id) REFERENCES c_projecttask
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoicetax
	DROP CONSTRAINT IF EXISTS cinvoice_cinvoicetax;
ALTER TABLE c_invoicetax
	ADD CONSTRAINT cinvoice_cinvoicetax
		FOREIGN KEY (c_invoice_id) REFERENCES c_invoice
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoicetax
	DROP CONSTRAINT IF EXISTS ctax_cinvoicetax;
ALTER TABLE c_invoicetax
	ADD CONSTRAINT ctax_cinvoicetax
		FOREIGN KEY (c_tax_id) REFERENCES c_tax
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_invoicetax
	DROP CONSTRAINT IF EXISTS ctaxprovider_cinvoicetax;
ALTER TABLE c_invoicetax
	ADD CONSTRAINT ctaxprovider_cinvoicetax
		FOREIGN KEY (c_taxprovider_id) REFERENCES c_taxprovider
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_tax
	DROP CONSTRAINT IF EXISTS c_region_c_tax;
ALTER TABLE c_tax
	ADD CONSTRAINT c_region_c_tax
		FOREIGN KEY (c_region_id) REFERENCES c_region
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_tax
	DROP CONSTRAINT IF EXISTS c_regionto_c_tax;
ALTER TABLE c_tax
	ADD CONSTRAINT c_regionto_c_tax
		FOREIGN KEY (to_region_id) REFERENCES c_region
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_tax
	DROP CONSTRAINT IF EXISTS c_country_c_tax;
ALTER TABLE c_tax
	ADD CONSTRAINT c_country_c_tax
		FOREIGN KEY (c_country_id) REFERENCES c_country
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_tax
	DROP CONSTRAINT IF EXISTS c_countryto_c_tax;
ALTER TABLE c_tax
	ADD CONSTRAINT c_countryto_c_tax
		FOREIGN KEY (to_country_id) REFERENCES c_country
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_tax
	DROP CONSTRAINT IF EXISTS adrule_ctax;
ALTER TABLE c_tax
	ADD CONSTRAINT adrule_ctax
		FOREIGN KEY (ad_rule_id) REFERENCES ad_rule
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_tax
	DROP CONSTRAINT IF EXISTS ctax_parent;
ALTER TABLE c_tax
	ADD CONSTRAINT ctax_parent
		FOREIGN KEY (parent_tax_id) REFERENCES c_tax
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_tax
	DROP CONSTRAINT IF EXISTS ctaxcategory_ctax;
ALTER TABLE c_tax
	ADD CONSTRAINT ctaxcategory_ctax
		FOREIGN KEY (c_taxcategory_id) REFERENCES c_taxcategory
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_tax
	DROP CONSTRAINT IF EXISTS ccountrygroupfrom_ctax;
ALTER TABLE c_tax
	ADD CONSTRAINT ccountrygroupfrom_ctax
		FOREIGN KEY (c_countrygroupfrom_id) REFERENCES c_countrygroup
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_tax
	DROP CONSTRAINT IF EXISTS ccountrygroupto_ctax;
ALTER TABLE c_tax
	ADD CONSTRAINT ccountrygroupto_ctax
		FOREIGN KEY (c_countrygroupto_id) REFERENCES c_countrygroup
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_tax
	DROP CONSTRAINT IF EXISTS ctaxprovider_ctax;
ALTER TABLE c_tax
	ADD CONSTRAINT ctaxprovider_ctax
		FOREIGN KEY (c_taxprovider_id) REFERENCES c_taxprovider
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_attributesetinstance
	DROP CONSTRAINT IF EXISTS mattributeset_mattribsetinst;
ALTER TABLE m_attributesetinstance
	ADD CONSTRAINT mattributeset_mattribsetinst
		FOREIGN KEY (m_attributeset_id) REFERENCES m_attributeset
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_attributesetinstance
	DROP CONSTRAINT IF EXISTS mlot_mattributesetinstance;
ALTER TABLE m_attributesetinstance
	ADD CONSTRAINT mlot_mattributesetinstance
		FOREIGN KEY (m_lot_id) REFERENCES m_lot
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product
	DROP CONSTRAINT IF EXISTS mproduct_mproductcategory;
ALTER TABLE m_product
	ADD CONSTRAINT mproduct_mproductcategory
		FOREIGN KEY (m_product_category_id) REFERENCES m_product_category
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product
	DROP CONSTRAINT IF EXISTS cuom_mproduct;
ALTER TABLE m_product
	ADD CONSTRAINT cuom_mproduct
		FOREIGN KEY (c_uom_id) REFERENCES c_uom
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product
	DROP CONSTRAINT IF EXISTS salesrep_mproduct;
ALTER TABLE m_product
	ADD CONSTRAINT salesrep_mproduct
		FOREIGN KEY (salesrep_id) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product
	DROP CONSTRAINT IF EXISTS sresource_mproduct;
ALTER TABLE m_product
	ADD CONSTRAINT sresource_mproduct
		FOREIGN KEY (s_resource_id) REFERENCES s_resource
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product
	DROP CONSTRAINT IF EXISTS mlocator_mproduct;
ALTER TABLE m_product
	ADD CONSTRAINT mlocator_mproduct
		FOREIGN KEY (m_locator_id) REFERENCES m_locator
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product
	DROP CONSTRAINT IF EXISTS rmailtext_mproduct;
ALTER TABLE m_product
	ADD CONSTRAINT rmailtext_mproduct
		FOREIGN KEY (r_mailtext_id) REFERENCES r_mailtext
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product
	DROP CONSTRAINT IF EXISTS ad_org_mproduct;
ALTER TABLE m_product
	ADD CONSTRAINT ad_org_mproduct
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product
	DROP CONSTRAINT IF EXISTS mattributeset_mproduct;
ALTER TABLE m_product
	ADD CONSTRAINT mattributeset_mproduct
		FOREIGN KEY (m_attributeset_id) REFERENCES m_attributeset
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product
	DROP CONSTRAINT IF EXISTS mattrsetinst_mproduct;
ALTER TABLE m_product
	ADD CONSTRAINT mattrsetinst_mproduct
		FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product
	DROP CONSTRAINT IF EXISTS adclient_mproduct;
ALTER TABLE m_product
	ADD CONSTRAINT adclient_mproduct
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product
	DROP CONSTRAINT IF EXISTS crevrecognition_mproduct;
ALTER TABLE m_product
	ADD CONSTRAINT crevrecognition_mproduct
		FOREIGN KEY (c_revenuerecognition_id) REFERENCES c_revenuerecognition
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product
	DROP CONSTRAINT IF EXISTS mfreightcategory_mproduct;
ALTER TABLE m_product
	ADD CONSTRAINT mfreightcategory_mproduct
		FOREIGN KEY (m_freightcategory_id) REFERENCES m_freightcategory
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product
	DROP CONSTRAINT IF EXISTS sexpensetype_mproduct;
ALTER TABLE m_product
	ADD CONSTRAINT sexpensetype_mproduct
		FOREIGN KEY (s_expensetype_id) REFERENCES s_expensetype
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product
	DROP CONSTRAINT IF EXISTS ctaxcategory_mproduct;
ALTER TABLE m_product
	ADD CONSTRAINT ctaxcategory_mproduct
		FOREIGN KEY (c_taxcategory_id) REFERENCES c_taxcategory
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product
	DROP CONSTRAINT IF EXISTS csubscriptiontype_mproduct;
ALTER TABLE m_product
	ADD CONSTRAINT csubscriptiontype_mproduct
		FOREIGN KEY (c_subscriptiontype_id) REFERENCES c_subscriptiontype
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product
	DROP CONSTRAINT IF EXISTS mparttype_mproduct;
ALTER TABLE m_product
	ADD CONSTRAINT mparttype_mproduct
		FOREIGN KEY (m_parttype_id) REFERENCES m_parttype
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_tax_trl
	DROP CONSTRAINT IF EXISTS adlanguage_ctaxtrl;
ALTER TABLE c_tax_trl
	ADD CONSTRAINT adlanguage_ctaxtrl
		FOREIGN KEY (ad_language) REFERENCES ad_language
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_tax_trl
	DROP CONSTRAINT IF EXISTS ctax_ctaxtrl;
ALTER TABLE c_tax_trl
	ADD CONSTRAINT ctax_ctaxtrl
		FOREIGN KEY (c_tax_id) REFERENCES c_tax
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_trl
	DROP CONSTRAINT IF EXISTS adlanguage_mproducttrl;
ALTER TABLE m_product_trl
	ADD CONSTRAINT adlanguage_mproducttrl
		FOREIGN KEY (ad_language) REFERENCES ad_language
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_trl
	DROP CONSTRAINT IF EXISTS mproduct_mproducttrl;
ALTER TABLE m_product_trl
	ADD CONSTRAINT mproduct_mproducttrl
		FOREIGN KEY (m_product_id) REFERENCES m_product
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_warehouse
	DROP CONSTRAINT IF EXISTS c_location_warehouse;
ALTER TABLE m_warehouse
	ADD CONSTRAINT c_location_warehouse
		FOREIGN KEY (c_location_id) REFERENCES c_location
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_warehouse
	DROP CONSTRAINT IF EXISTS mwarehousesource_mwarehouse;
ALTER TABLE m_warehouse
	ADD CONSTRAINT mwarehousesource_mwarehouse
		FOREIGN KEY (m_warehousesource_id) REFERENCES m_warehouse
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_warehouse
	DROP CONSTRAINT IF EXISTS mreservelocator_mwarehouse;
ALTER TABLE m_warehouse
	ADD CONSTRAINT mreservelocator_mwarehouse
		FOREIGN KEY (m_reservelocator_id) REFERENCES m_locator
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_warehouse
	DROP CONSTRAINT IF EXISTS m_warehouse_org;
ALTER TABLE m_warehouse
	ADD CONSTRAINT m_warehouse_org
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_warehouse
	DROP CONSTRAINT IF EXISTS m_warehouse_client;
ALTER TABLE m_warehouse
	ADD CONSTRAINT m_warehouse_client
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_ordertax
	DROP CONSTRAINT IF EXISTS corder_cordertax;
ALTER TABLE c_ordertax
	ADD CONSTRAINT corder_cordertax
		FOREIGN KEY (c_order_id) REFERENCES c_order
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_ordertax
	DROP CONSTRAINT IF EXISTS ctax_cordertax;
ALTER TABLE c_ordertax
	ADD CONSTRAINT ctax_cordertax
		FOREIGN KEY (c_tax_id) REFERENCES c_tax
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_ordertax
	DROP CONSTRAINT IF EXISTS ctaxprovider_cordertax;
ALTER TABLE c_ordertax
	ADD CONSTRAINT ctaxprovider_cordertax
		FOREIGN KEY (c_taxprovider_id) REFERENCES c_taxprovider
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_period
	DROP CONSTRAINT IF EXISTS c_year_period;
ALTER TABLE c_period
	ADD CONSTRAINT c_year_period
		FOREIGN KEY (c_year_id) REFERENCES c_year
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_period
	DROP CONSTRAINT IF EXISTS c_periodorg;
ALTER TABLE c_period
	ADD CONSTRAINT c_periodorg
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_period
	DROP CONSTRAINT IF EXISTS c_periodclient;
ALTER TABLE c_period
	ADD CONSTRAINT c_periodclient
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_periodcontrol
	DROP CONSTRAINT IF EXISTS c_period_periodcontrol;
ALTER TABLE c_periodcontrol
	ADD CONSTRAINT c_period_periodcontrol
		FOREIGN KEY (c_period_id) REFERENCES c_period
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_project
	DROP CONSTRAINT IF EXISTS ccurrency_cproject;
ALTER TABLE c_project
	ADD CONSTRAINT ccurrency_cproject
		FOREIGN KEY (c_currency_id) REFERENCES c_currency
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_project
	DROP CONSTRAINT IF EXISTS cbpartner_cproject;
ALTER TABLE c_project
	ADD CONSTRAINT cbpartner_cproject
		FOREIGN KEY (c_bpartner_id) REFERENCES c_bpartner
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_project
	DROP CONSTRAINT IF EXISTS cbpartnersr_cproject;
ALTER TABLE c_project
	ADD CONSTRAINT cbpartnersr_cproject
		FOREIGN KEY (c_bpartnersr_id) REFERENCES c_bpartner
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_project
	DROP CONSTRAINT IF EXISTS cphase_cproject;
ALTER TABLE c_project
	ADD CONSTRAINT cphase_cproject
		FOREIGN KEY (c_phase_id) REFERENCES c_phase
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_project
	DROP CONSTRAINT IF EXISTS aduser_cproject;
ALTER TABLE c_project
	ADD CONSTRAINT aduser_cproject
		FOREIGN KEY (ad_user_id) REFERENCES ad_user
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_project
	DROP CONSTRAINT IF EXISTS aduser_sr_cproject;
ALTER TABLE c_project
	ADD CONSTRAINT aduser_sr_cproject
		FOREIGN KEY (salesrep_id) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_project
	DROP CONSTRAINT IF EXISTS cbplocation_cproject;
ALTER TABLE c_project
	ADD CONSTRAINT cbplocation_cproject
		FOREIGN KEY (c_bpartner_location_id) REFERENCES c_bpartner_location
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_project
	DROP CONSTRAINT IF EXISTS mwarehouse_cproject;
ALTER TABLE c_project
	ADD CONSTRAINT mwarehouse_cproject
		FOREIGN KEY (m_warehouse_id) REFERENCES m_warehouse
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_project
	DROP CONSTRAINT IF EXISTS adorg_cproject;
ALTER TABLE c_project
	ADD CONSTRAINT adorg_cproject
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_project
	DROP CONSTRAINT IF EXISTS adorgtrx_cproject;
ALTER TABLE c_project
	ADD CONSTRAINT adorgtrx_cproject
		FOREIGN KEY (ad_orgtrx_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_project
	DROP CONSTRAINT IF EXISTS mpricelistversion_cproject;
ALTER TABLE c_project
	ADD CONSTRAINT mpricelistversion_cproject
		FOREIGN KEY (m_pricelist_version_id) REFERENCES m_pricelist_version
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_project
	DROP CONSTRAINT IF EXISTS cpaymentterm_cproject;
ALTER TABLE c_project
	ADD CONSTRAINT cpaymentterm_cproject
		FOREIGN KEY (c_paymentterm_id) REFERENCES c_paymentterm
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_project
	DROP CONSTRAINT IF EXISTS cprojecttype_cproject;
ALTER TABLE c_project
	ADD CONSTRAINT cprojecttype_cproject
		FOREIGN KEY (c_projecttype_id) REFERENCES c_projecttype
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_project
	DROP CONSTRAINT IF EXISTS adclient_cproject;
ALTER TABLE c_project
	ADD CONSTRAINT adclient_cproject
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_project
	DROP CONSTRAINT IF EXISTS ccampaign_cproject;
ALTER TABLE c_project
	ADD CONSTRAINT ccampaign_cproject
		FOREIGN KEY (c_campaign_id) REFERENCES c_campaign
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_project
	DROP CONSTRAINT IF EXISTS cactivity_cproject;
ALTER TABLE c_project
	ADD CONSTRAINT cactivity_cproject
		FOREIGN KEY (c_activity_id) REFERENCES c_activity
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_salesregion
	DROP CONSTRAINT IF EXISTS salesrep_csalesregion;
ALTER TABLE c_salesregion
	ADD CONSTRAINT salesrep_csalesregion
		FOREIGN KEY (salesrep_id) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_salesregion_trl
	DROP CONSTRAINT IF EXISTS c_salesregion_trl_uu_idx;
ALTER TABLE c_salesregion_trl
	ADD CONSTRAINT c_salesregion_trl_uu_idx
		UNIQUE (c_salesregion_trl_uu);

ALTER TABLE c_salesregion_trl
	DROP CONSTRAINT IF EXISTS adlanguage_csalesregiontrl;
ALTER TABLE c_salesregion_trl
	ADD CONSTRAINT adlanguage_csalesregiontrl
		FOREIGN KEY (ad_language) REFERENCES ad_language
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_salesregion_trl
	DROP CONSTRAINT IF EXISTS createdby_csalesregiontrl;
ALTER TABLE c_salesregion_trl
	ADD CONSTRAINT createdby_csalesregiontrl
		FOREIGN KEY (createdby) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_salesregion_trl
	DROP CONSTRAINT IF EXISTS updatedby_csalesregiontrl;
ALTER TABLE c_salesregion_trl
	ADD CONSTRAINT updatedby_csalesregiontrl
		FOREIGN KEY (updatedby) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_salesregion_trl
	DROP CONSTRAINT IF EXISTS adorg_csalesregiontrl;
ALTER TABLE c_salesregion_trl
	ADD CONSTRAINT adorg_csalesregiontrl
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_salesregion_trl
	DROP CONSTRAINT IF EXISTS adclient_csalesregiontrl;
ALTER TABLE c_salesregion_trl
	ADD CONSTRAINT adclient_csalesregiontrl
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_salesregion_trl
	DROP CONSTRAINT IF EXISTS csalesregion_csalesregiontrl;
ALTER TABLE c_salesregion_trl
	ADD CONSTRAINT csalesregion_csalesregiontrl
		FOREIGN KEY (c_salesregion_id) REFERENCES c_salesregion
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_tax_acct
	DROP CONSTRAINT IF EXISTS vc_tcredit_ctax;
ALTER TABLE c_tax_acct
	ADD CONSTRAINT vc_tcredit_ctax
		FOREIGN KEY (t_credit_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_tax_acct
	DROP CONSTRAINT IF EXISTS vc_tdue_ctax;
ALTER TABLE c_tax_acct
	ADD CONSTRAINT vc_tdue_ctax
		FOREIGN KEY (t_due_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_tax_acct
	DROP CONSTRAINT IF EXISTS vc_texpense_ctax;
ALTER TABLE c_tax_acct
	ADD CONSTRAINT vc_texpense_ctax
		FOREIGN KEY (t_expense_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_tax_acct
	DROP CONSTRAINT IF EXISTS vc_tliability_ctax;
ALTER TABLE c_tax_acct
	ADD CONSTRAINT vc_tliability_ctax
		FOREIGN KEY (t_liability_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_tax_acct
	DROP CONSTRAINT IF EXISTS vc_trec_ctax;
ALTER TABLE c_tax_acct
	ADD CONSTRAINT vc_trec_ctax
		FOREIGN KEY (t_receivables_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_tax_acct
	DROP CONSTRAINT IF EXISTS ctax_ctaxacct;
ALTER TABLE c_tax_acct
	ADD CONSTRAINT ctax_ctaxacct
		FOREIGN KEY (c_tax_id) REFERENCES c_tax
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_tax_acct
	DROP CONSTRAINT IF EXISTS cacctschema_ctaxacct;
ALTER TABLE c_tax_acct
	ADD CONSTRAINT cacctschema_ctaxacct
		FOREIGN KEY (c_acctschema_id) REFERENCES c_acctschema
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_taxcategory_trl
	DROP CONSTRAINT IF EXISTS adlanguage_ctaxcategorytrl;
ALTER TABLE c_taxcategory_trl
	ADD CONSTRAINT adlanguage_ctaxcategorytrl
		FOREIGN KEY (ad_language) REFERENCES ad_language
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_taxcategory_trl
	DROP CONSTRAINT IF EXISTS ctaxcategory_trl;
ALTER TABLE c_taxcategory_trl
	ADD CONSTRAINT ctaxcategory_trl
		FOREIGN KEY (c_taxcategory_id) REFERENCES c_taxcategory
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_validcombination
	DROP CONSTRAINT IF EXISTS celementvalueaccount_vc;
ALTER TABLE c_validcombination
	ADD CONSTRAINT celementvalueaccount_vc
		FOREIGN KEY (account_id) REFERENCES c_elementvalue
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_validcombination
	DROP CONSTRAINT IF EXISTS celementvalueuser1_vc;
ALTER TABLE c_validcombination
	ADD CONSTRAINT celementvalueuser1_vc
		FOREIGN KEY (user1_id) REFERENCES c_elementvalue
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_validcombination
	DROP CONSTRAINT IF EXISTS celementvalueuser2_vc;
ALTER TABLE c_validcombination
	ADD CONSTRAINT celementvalueuser2_vc
		FOREIGN KEY (user2_id) REFERENCES c_elementvalue
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_validcombination
	DROP CONSTRAINT IF EXISTS mproduct_vc;
ALTER TABLE c_validcombination
	ADD CONSTRAINT mproduct_vc
		FOREIGN KEY (m_product_id) REFERENCES m_product
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_validcombination
	DROP CONSTRAINT IF EXISTS mlocationfrom_vc;
ALTER TABLE c_validcombination
	ADD CONSTRAINT mlocationfrom_vc
		FOREIGN KEY (c_locfrom_id) REFERENCES c_location
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_validcombination
	DROP CONSTRAINT IF EXISTS mlocationto_vc;
ALTER TABLE c_validcombination
	ADD CONSTRAINT mlocationto_vc
		FOREIGN KEY (c_locto_id) REFERENCES c_location
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_validcombination
	DROP CONSTRAINT IF EXISTS cbpartner_vc;
ALTER TABLE c_validcombination
	ADD CONSTRAINT cbpartner_vc
		FOREIGN KEY (c_bpartner_id) REFERENCES c_bpartner
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_validcombination
	DROP CONSTRAINT IF EXISTS adorg_vc;
ALTER TABLE c_validcombination
	ADD CONSTRAINT adorg_vc
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_validcombination
	DROP CONSTRAINT IF EXISTS adorgtrx_vc;
ALTER TABLE c_validcombination
	ADD CONSTRAINT adorgtrx_vc
		FOREIGN KEY (ad_orgtrx_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_validcombination
	DROP CONSTRAINT IF EXISTS cproject_vc;
ALTER TABLE c_validcombination
	ADD CONSTRAINT cproject_vc
		FOREIGN KEY (c_project_id) REFERENCES c_project
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_validcombination
	DROP CONSTRAINT IF EXISTS adclient_vc;
ALTER TABLE c_validcombination
	ADD CONSTRAINT adclient_vc
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_validcombination
	DROP CONSTRAINT IF EXISTS socampaign_vc;
ALTER TABLE c_validcombination
	ADD CONSTRAINT socampaign_vc
		FOREIGN KEY (c_campaign_id) REFERENCES c_campaign
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_validcombination
	DROP CONSTRAINT IF EXISTS cacctschema_cvalidcombination;
ALTER TABLE c_validcombination
	ADD CONSTRAINT cacctschema_cvalidcombination
		FOREIGN KEY (c_acctschema_id) REFERENCES c_acctschema
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_validcombination
	DROP CONSTRAINT IF EXISTS csalesregion_vc;
ALTER TABLE c_validcombination
	ADD CONSTRAINT csalesregion_vc
		FOREIGN KEY (c_salesregion_id) REFERENCES c_salesregion
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_validcombination
	DROP CONSTRAINT IF EXISTS cactivity_cvalidcombination;
ALTER TABLE c_validcombination
	ADD CONSTRAINT cactivity_cvalidcombination
		FOREIGN KEY (c_activity_id) REFERENCES c_activity
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_validcombination
	DROP CONSTRAINT IF EXISTS csubacct_cvalidcombination;
ALTER TABLE c_validcombination
	ADD CONSTRAINT csubacct_cvalidcombination
		FOREIGN KEY (c_subacct_id) REFERENCES c_subacct
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_year
	DROP CONSTRAINT IF EXISTS c_yearorg;
ALTER TABLE c_year
	ADD CONSTRAINT c_yearorg
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_year
	DROP CONSTRAINT IF EXISTS c_yearclient;
ALTER TABLE c_year
	ADD CONSTRAINT c_yearclient
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE c_year
	DROP CONSTRAINT IF EXISTS c_calendar_year;
ALTER TABLE c_year
	ADD CONSTRAINT c_calendar_year
		FOREIGN KEY (c_calendar_id) REFERENCES c_calendar
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS adtable_factacct;
ALTER TABLE fact_acct
	ADD CONSTRAINT adtable_factacct
		FOREIGN KEY (ad_table_id) REFERENCES ad_table
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS c_currency_fact_acct;
ALTER TABLE fact_acct
	ADD CONSTRAINT c_currency_fact_acct
		FOREIGN KEY (c_currency_id) REFERENCES c_currency
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS cperiod_factacct;
ALTER TABLE fact_acct
	ADD CONSTRAINT cperiod_factacct
		FOREIGN KEY (c_period_id) REFERENCES c_period
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS m_product_fact_acct;
ALTER TABLE fact_acct
	ADD CONSTRAINT m_product_fact_acct
		FOREIGN KEY (m_product_id) REFERENCES m_product
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS c_locationfrom_fact_acct;
ALTER TABLE fact_acct
	ADD CONSTRAINT c_locationfrom_fact_acct
		FOREIGN KEY (c_locfrom_id) REFERENCES c_location
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS celementvalue_factacct;
ALTER TABLE fact_acct
	ADD CONSTRAINT celementvalue_factacct
		FOREIGN KEY (account_id) REFERENCES c_elementvalue
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS celementvalueuser1_factacct;
ALTER TABLE fact_acct
	ADD CONSTRAINT celementvalueuser1_factacct
		FOREIGN KEY (user1_id) REFERENCES c_elementvalue
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS celementvalueuser2_factacct;
ALTER TABLE fact_acct
	ADD CONSTRAINT celementvalueuser2_factacct
		FOREIGN KEY (user2_id) REFERENCES c_elementvalue
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS c_locationto_fact_acct;
ALTER TABLE fact_acct
	ADD CONSTRAINT c_locationto_fact_acct
		FOREIGN KEY (c_locto_id) REFERENCES c_location
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS c_buspartner_fact_acct;
ALTER TABLE fact_acct
	ADD CONSTRAINT c_buspartner_fact_acct
		FOREIGN KEY (c_bpartner_id) REFERENCES c_bpartner
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS c_uom_fact_acct;
ALTER TABLE fact_acct
	ADD CONSTRAINT c_uom_fact_acct
		FOREIGN KEY (c_uom_id) REFERENCES c_uom
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS mlocator_factacct;
ALTER TABLE fact_acct
	ADD CONSTRAINT mlocator_factacct
		FOREIGN KEY (m_locator_id) REFERENCES m_locator
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS ad_org_fact_acct;
ALTER TABLE fact_acct
	ADD CONSTRAINT ad_org_fact_acct
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS ad_orgtrx_fact_acct;
ALTER TABLE fact_acct
	ADD CONSTRAINT ad_orgtrx_fact_acct
		FOREIGN KEY (ad_orgtrx_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS ctax_factacct;
ALTER TABLE fact_acct
	ADD CONSTRAINT ctax_factacct
		FOREIGN KEY (c_tax_id) REFERENCES c_tax
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS glcategory_factacct;
ALTER TABLE fact_acct
	ADD CONSTRAINT glcategory_factacct
		FOREIGN KEY (gl_category_id) REFERENCES gl_category
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS c_project_fact_acct;
ALTER TABLE fact_acct
	ADD CONSTRAINT c_project_fact_acct
		FOREIGN KEY (c_project_id) REFERENCES c_project
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS ac_client_fact_acct;
ALTER TABLE fact_acct
	ADD CONSTRAINT ac_client_fact_acct
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS so_campaign_fact_acct;
ALTER TABLE fact_acct
	ADD CONSTRAINT so_campaign_fact_acct
		FOREIGN KEY (c_campaign_id) REFERENCES c_campaign
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS cacctschema_factacct;
ALTER TABLE fact_acct
	ADD CONSTRAINT cacctschema_factacct
		FOREIGN KEY (c_acctschema_id) REFERENCES c_acctschema
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS c_salesregion_factacct;
ALTER TABLE fact_acct
	ADD CONSTRAINT c_salesregion_factacct
		FOREIGN KEY (c_salesregion_id) REFERENCES c_salesregion
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS glbudget_factacct;
ALTER TABLE fact_acct
	ADD CONSTRAINT glbudget_factacct
		FOREIGN KEY (gl_budget_id) REFERENCES gl_budget
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS aasset_factacct;
ALTER TABLE fact_acct
	ADD CONSTRAINT aasset_factacct
		FOREIGN KEY (a_asset_id) REFERENCES a_asset
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS cactivity_factacct;
ALTER TABLE fact_acct
	ADD CONSTRAINT cactivity_factacct
		FOREIGN KEY (c_activity_id) REFERENCES c_activity
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS cprojectphase_factacct;
ALTER TABLE fact_acct
	ADD CONSTRAINT cprojectphase_factacct
		FOREIGN KEY (c_projectphase_id) REFERENCES c_projectphase
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS cprojecttask_factacct;
ALTER TABLE fact_acct
	ADD CONSTRAINT cprojecttask_factacct
		FOREIGN KEY (c_projecttask_id) REFERENCES c_projecttask
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS csubacct_factacct;
ALTER TABLE fact_acct
	ADD CONSTRAINT csubacct_factacct
		FOREIGN KEY (c_subacct_id) REFERENCES c_subacct
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE gl_category_trl
	DROP CONSTRAINT IF EXISTS gl_category_trl_uu_idx;
ALTER TABLE gl_category_trl
	ADD CONSTRAINT gl_category_trl_uu_idx
		UNIQUE (gl_category_trl_uu);

ALTER TABLE gl_category_trl
	DROP CONSTRAINT IF EXISTS adlanguage_glcategorytrl;
ALTER TABLE gl_category_trl
	ADD CONSTRAINT adlanguage_glcategorytrl
		FOREIGN KEY (ad_language) REFERENCES ad_language
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE gl_category_trl
	DROP CONSTRAINT IF EXISTS createdby_glcategorytrl;
ALTER TABLE gl_category_trl
	ADD CONSTRAINT createdby_glcategorytrl
		FOREIGN KEY (createdby) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE gl_category_trl
	DROP CONSTRAINT IF EXISTS updatedby_glcategorytrl;
ALTER TABLE gl_category_trl
	ADD CONSTRAINT updatedby_glcategorytrl
		FOREIGN KEY (updatedby) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE gl_category_trl
	DROP CONSTRAINT IF EXISTS glcategory_glcategorytrl;
ALTER TABLE gl_category_trl
	ADD CONSTRAINT glcategory_glcategorytrl
		FOREIGN KEY (gl_category_id) REFERENCES gl_category
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE gl_category_trl
	DROP CONSTRAINT IF EXISTS adorg_glcategorytrl;
ALTER TABLE gl_category_trl
	ADD CONSTRAINT adorg_glcategorytrl
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE gl_category_trl
	DROP CONSTRAINT IF EXISTS adclient_glcategorytrl;
ALTER TABLE gl_category_trl
	ADD CONSTRAINT adclient_glcategorytrl
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE i_elementvalue
	DROP CONSTRAINT IF EXISTS adcolumn_ielementvalue;
ALTER TABLE i_elementvalue
	ADD CONSTRAINT adcolumn_ielementvalue
		FOREIGN KEY (ad_column_id) REFERENCES ad_column
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE i_elementvalue
	DROP CONSTRAINT IF EXISTS celementvalue_ielementvalue;
ALTER TABLE i_elementvalue
	ADD CONSTRAINT celementvalue_ielementvalue
		FOREIGN KEY (c_elementvalue_id) REFERENCES c_elementvalue
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE i_elementvalue
	DROP CONSTRAINT IF EXISTS cevalueparent_ielementvalue;
ALTER TABLE i_elementvalue
	ADD CONSTRAINT cevalueparent_ielementvalue
		FOREIGN KEY (parentelementvalue_id) REFERENCES c_elementvalue
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE i_elementvalue
	DROP CONSTRAINT IF EXISTS celement_ielementvalue;
ALTER TABLE i_elementvalue
	ADD CONSTRAINT celement_ielementvalue
		FOREIGN KEY (c_element_id) REFERENCES c_element
			ON DELETE SET NULL
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_attribute
	ADD IF NOT EXISTS ad_reference_id numeric(10) DEFAULT NULL::numeric;

ALTER TABLE m_attribute
	ADD IF NOT EXISTS ad_reference_value_id numeric(10) DEFAULT NULL::numeric;

ALTER TABLE m_attribute
	ADD IF NOT EXISTS ad_val_rule_id numeric(10) DEFAULT NULL::numeric;

ALTER TABLE m_attribute
	DROP CONSTRAINT IF EXISTS adreference_mattribute;
ALTER TABLE m_attribute
	ADD CONSTRAINT adreference_mattribute
		FOREIGN KEY (ad_reference_id) REFERENCES ad_reference
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_attribute
	DROP CONSTRAINT IF EXISTS adreferencevalue_mattribute;
ALTER TABLE m_attribute
	ADD CONSTRAINT adreferencevalue_mattribute
		FOREIGN KEY (ad_reference_value_id) REFERENCES ad_reference
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_attribute
	DROP CONSTRAINT IF EXISTS advalrule_mattribute;
ALTER TABLE m_attribute
	ADD CONSTRAINT advalrule_mattribute
		FOREIGN KEY (ad_val_rule_id) REFERENCES ad_val_rule
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_attributeset
	ADD IF NOT EXISTS m_attributeset_type varchar(3) DEFAULT 'MMS'::character varying;

ALTER TABLE m_attributeset
	DROP CONSTRAINT IF EXISTS msernoctl_attributeset;
ALTER TABLE m_attributeset
	ADD CONSTRAINT msernoctl_attributeset
		FOREIGN KEY (m_sernoctl_id) REFERENCES m_sernoctl
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_attributeset
	DROP CONSTRAINT IF EXISTS mlotctl_mattributeset;
ALTER TABLE m_attributeset
	ADD CONSTRAINT mlotctl_mattributeset
		FOREIGN KEY (m_lotctl_id) REFERENCES m_lotctl
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_cost
	DROP CONSTRAINT IF EXISTS mproduct_mcost;
ALTER TABLE m_cost
	ADD CONSTRAINT mproduct_mcost
		FOREIGN KEY (m_product_id) REFERENCES m_product
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_cost
	DROP CONSTRAINT IF EXISTS mcostelement_mcost;
ALTER TABLE m_cost
	ADD CONSTRAINT mcostelement_mcost
		FOREIGN KEY (m_costelement_id) REFERENCES m_costelement
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_cost
	DROP CONSTRAINT IF EXISTS adorg_m_cost;
ALTER TABLE m_cost
	ADD CONSTRAINT adorg_m_cost
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_cost
	DROP CONSTRAINT IF EXISTS masi_mcost;
ALTER TABLE m_cost
	ADD CONSTRAINT masi_mcost
		FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_cost
	DROP CONSTRAINT IF EXISTS adclient_mcost;
ALTER TABLE m_cost
	ADD CONSTRAINT adclient_mcost
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_cost
	DROP CONSTRAINT IF EXISTS mcosttype_mcost;
ALTER TABLE m_cost
	ADD CONSTRAINT mcosttype_mcost
		FOREIGN KEY (m_costtype_id) REFERENCES m_costtype
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_cost
	DROP CONSTRAINT IF EXISTS cacctschema_mcost;
ALTER TABLE m_cost
	ADD CONSTRAINT cacctschema_mcost
		FOREIGN KEY (c_acctschema_id) REFERENCES c_acctschema
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_costdetail
	DROP CONSTRAINT IF EXISTS corderline_mcostdetail;
ALTER TABLE m_costdetail
	ADD CONSTRAINT corderline_mcostdetail
		FOREIGN KEY (c_orderline_id) REFERENCES c_orderline
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_costdetail
	DROP CONSTRAINT IF EXISTS minvoiceline_mcostdetail;
ALTER TABLE m_costdetail
	ADD CONSTRAINT minvoiceline_mcostdetail
		FOREIGN KEY (c_invoiceline_id) REFERENCES c_invoiceline
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_costdetail
	DROP CONSTRAINT IF EXISTS minoutline_mcostdetail;
ALTER TABLE m_costdetail
	ADD CONSTRAINT minoutline_mcostdetail
		FOREIGN KEY (m_inoutline_id) REFERENCES m_inoutline
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_costdetail
	DROP CONSTRAINT IF EXISTS mproduct_mcostdetail;
ALTER TABLE m_costdetail
	ADD CONSTRAINT mproduct_mcostdetail
		FOREIGN KEY (m_product_id) REFERENCES m_product
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_costdetail
	DROP CONSTRAINT IF EXISTS mcostdetail_matchinv;
ALTER TABLE m_costdetail
	ADD CONSTRAINT mcostdetail_matchinv
		FOREIGN KEY (m_matchinv_id) REFERENCES m_matchinv
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_costdetail
	DROP CONSTRAINT IF EXISTS mcostelement_mcostdetail;
ALTER TABLE m_costdetail
	ADD CONSTRAINT mcostelement_mcostdetail
		FOREIGN KEY (m_costelement_id) REFERENCES m_costelement
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_costdetail
	DROP CONSTRAINT IF EXISTS adorg_mcostdetail;
ALTER TABLE m_costdetail
	ADD CONSTRAINT adorg_mcostdetail
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_costdetail
	DROP CONSTRAINT IF EXISTS masi_mcostdetail;
ALTER TABLE m_costdetail
	ADD CONSTRAINT masi_mcostdetail
		FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_costdetail
	DROP CONSTRAINT IF EXISTS adclient_mcostdetail;
ALTER TABLE m_costdetail
	ADD CONSTRAINT adclient_mcostdetail
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_costdetail
	DROP CONSTRAINT IF EXISTS cacctschema_mcostdetail;
ALTER TABLE m_costdetail
	ADD CONSTRAINT cacctschema_mcostdetail
		FOREIGN KEY (c_acctschema_id) REFERENCES c_acctschema
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_costdetail
	DROP CONSTRAINT IF EXISTS mmovementline_mcostdetail;
ALTER TABLE m_costdetail
	ADD CONSTRAINT mmovementline_mcostdetail
		FOREIGN KEY (m_movementline_id) REFERENCES m_movementline
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_costdetail
	DROP CONSTRAINT IF EXISTS minventoryline_mcostdetail;
ALTER TABLE m_costdetail
	ADD CONSTRAINT minventoryline_mcostdetail
		FOREIGN KEY (m_inventoryline_id) REFERENCES m_inventoryline
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_costdetail
	DROP CONSTRAINT IF EXISTS cprojectissue_mcostdetail;
ALTER TABLE m_costdetail
	ADD CONSTRAINT cprojectissue_mcostdetail
		FOREIGN KEY (c_projectissue_id) REFERENCES c_projectissue
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_costdetail
	DROP CONSTRAINT IF EXISTS mproductionline_mcostdetail;
ALTER TABLE m_costdetail
	ADD CONSTRAINT mproductionline_mcostdetail
		FOREIGN KEY (m_productionline_id) REFERENCES m_productionline
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_costdetail
	DROP CONSTRAINT IF EXISTS ppcostcollector_mcostdetail;
ALTER TABLE m_costdetail
	ADD CONSTRAINT ppcostcollector_mcostdetail
		FOREIGN KEY (pp_cost_collector_id) REFERENCES pp_cost_collector
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_costhistory
	DROP CONSTRAINT IF EXISTS mcostelement_mcosthistory;
ALTER TABLE m_costhistory
	ADD CONSTRAINT mcostelement_mcosthistory
		FOREIGN KEY (m_costelement_id) REFERENCES m_costelement
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_costhistory
	DROP CONSTRAINT IF EXISTS mattributesetinstance_mcosthis;
ALTER TABLE m_costhistory
	ADD CONSTRAINT mattributesetinstance_mcosthis
		FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_costhistory
	DROP CONSTRAINT IF EXISTS mcosttype_mcosthistory;
ALTER TABLE m_costhistory
	ADD CONSTRAINT mcosttype_mcosthistory
		FOREIGN KEY (m_costtype_id) REFERENCES m_costtype
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_costhistory
	DROP CONSTRAINT IF EXISTS mcostdetail_mcosthistory;
ALTER TABLE m_costhistory
	ADD CONSTRAINT mcostdetail_mcosthistory
		FOREIGN KEY (m_costdetail_id) REFERENCES m_costdetail
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS celementvalueuser1_minout;
ALTER TABLE m_inout
	ADD CONSTRAINT celementvalueuser1_minout
		FOREIGN KEY (user1_id) REFERENCES c_elementvalue
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS celementvalueuser2_minout;
ALTER TABLE m_inout
	ADD CONSTRAINT celementvalueuser2_minout
		FOREIGN KEY (user2_id) REFERENCES c_elementvalue
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS cdoctype_minout;
ALTER TABLE m_inout
	ADD CONSTRAINT cdoctype_minout
		FOREIGN KEY (c_doctype_id) REFERENCES c_doctype
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS cbpartner_minout;
ALTER TABLE m_inout
	ADD CONSTRAINT cbpartner_minout
		FOREIGN KEY (c_bpartner_id) REFERENCES c_bpartner
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS dropshipbpartner_minout;
ALTER TABLE m_inout
	ADD CONSTRAINT dropshipbpartner_minout
		FOREIGN KEY (dropship_bpartner_id) REFERENCES c_bpartner
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS returnbpartner_minout;
ALTER TABLE m_inout
	ADD CONSTRAINT returnbpartner_minout
		FOREIGN KEY (returnbpartner_id) REFERENCES c_bpartner
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS corder_minout;
ALTER TABLE m_inout
	ADD CONSTRAINT corder_minout
		FOREIGN KEY (c_order_id) REFERENCES c_order
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS cinvoice_minout;
ALTER TABLE m_inout
	ADD CONSTRAINT cinvoice_minout
		FOREIGN KEY (c_invoice_id) REFERENCES c_invoice
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS minout_ref;
ALTER TABLE m_inout
	ADD CONSTRAINT minout_ref
		FOREIGN KEY (ref_inout_id) REFERENCES m_inout
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS reversal_minout;
ALTER TABLE m_inout
	ADD CONSTRAINT reversal_minout
		FOREIGN KEY (reversal_id) REFERENCES m_inout
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS dropshiplocation_minout;
ALTER TABLE m_inout
	ADD CONSTRAINT dropshiplocation_minout
		FOREIGN KEY (dropship_location_id) REFERENCES c_bpartner_location
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS returnlocation_minout;
ALTER TABLE m_inout
	ADD CONSTRAINT returnlocation_minout
		FOREIGN KEY (returnlocation_id) REFERENCES c_bpartner_location
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS vbplocation_minout;
ALTER TABLE m_inout
	ADD CONSTRAINT vbplocation_minout
		FOREIGN KEY (c_bpartner_location_id) REFERENCES c_bpartner_location
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS aduser_minout;
ALTER TABLE m_inout
	ADD CONSTRAINT aduser_minout
		FOREIGN KEY (ad_user_id) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS aduser_sr_minout;
ALTER TABLE m_inout
	ADD CONSTRAINT aduser_sr_minout
		FOREIGN KEY (salesrep_id) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS dropshipuser_minout;
ALTER TABLE m_inout
	ADD CONSTRAINT dropshipuser_minout
		FOREIGN KEY (dropship_user_id) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS returnuser_minout;
ALTER TABLE m_inout
	ADD CONSTRAINT returnuser_minout
		FOREIGN KEY (returnuser_id) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS mwarehouse_minout;
ALTER TABLE m_inout
	ADD CONSTRAINT mwarehouse_minout
		FOREIGN KEY (m_warehouse_id) REFERENCES m_warehouse
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS adorg_minout;
ALTER TABLE m_inout
	ADD CONSTRAINT adorg_minout
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS adorgtrx_minout;
ALTER TABLE m_inout
	ADD CONSTRAINT adorgtrx_minout
		FOREIGN KEY (ad_orgtrx_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS cproject_minout;
ALTER TABLE m_inout
	ADD CONSTRAINT cproject_minout
		FOREIGN KEY (c_project_id) REFERENCES c_project
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS mshipper_minout;
ALTER TABLE m_inout
	ADD CONSTRAINT mshipper_minout
		FOREIGN KEY (m_shipper_id) REFERENCES m_shipper
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS ccampaign_minout;
ALTER TABLE m_inout
	ADD CONSTRAINT ccampaign_minout
		FOREIGN KEY (c_campaign_id) REFERENCES c_campaign
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS ccharge_minout;
ALTER TABLE m_inout
	ADD CONSTRAINT ccharge_minout
		FOREIGN KEY (c_charge_id) REFERENCES c_charge
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS mrma_minout;
ALTER TABLE m_inout
	ADD CONSTRAINT mrma_minout
		FOREIGN KEY (m_rma_id) REFERENCES m_rma
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS cactivity_minout;
ALTER TABLE m_inout
	ADD CONSTRAINT cactivity_minout
		FOREIGN KEY (c_activity_id) REFERENCES c_activity
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inoutline
	DROP CONSTRAINT IF EXISTS mproduct_minoutline;
ALTER TABLE m_inoutline
	ADD CONSTRAINT mproduct_minoutline
		FOREIGN KEY (m_product_id) REFERENCES m_product
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inoutline
	DROP CONSTRAINT IF EXISTS celemenrvalueuser1_minoutline;
ALTER TABLE m_inoutline
	ADD CONSTRAINT celemenrvalueuser1_minoutline
		FOREIGN KEY (user1_id) REFERENCES c_elementvalue
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inoutline
	DROP CONSTRAINT IF EXISTS celemenrvalueuser2_minoutline;
ALTER TABLE m_inoutline
	ADD CONSTRAINT celemenrvalueuser2_minoutline
		FOREIGN KEY (user2_id) REFERENCES c_elementvalue
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inoutline
	DROP CONSTRAINT IF EXISTS corderline_minout;
ALTER TABLE m_inoutline
	ADD CONSTRAINT corderline_minout
		FOREIGN KEY (c_orderline_id) REFERENCES c_orderline
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inoutline
	DROP CONSTRAINT IF EXISTS minoutline_ref;
ALTER TABLE m_inoutline
	ADD CONSTRAINT minoutline_ref
		FOREIGN KEY (ref_inoutline_id) REFERENCES m_inoutline
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inoutline
	DROP CONSTRAINT IF EXISTS reversalline_minoutline;
ALTER TABLE m_inoutline
	ADD CONSTRAINT reversalline_minoutline
		FOREIGN KEY (reversalline_id) REFERENCES m_inoutline
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inoutline
	DROP CONSTRAINT IF EXISTS cuom_minoutline;
ALTER TABLE m_inoutline
	ADD CONSTRAINT cuom_minoutline
		FOREIGN KEY (c_uom_id) REFERENCES c_uom
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inoutline
	DROP CONSTRAINT IF EXISTS minout_minoutline;
ALTER TABLE m_inoutline
	ADD CONSTRAINT minout_minoutline
		FOREIGN KEY (m_inout_id) REFERENCES m_inout
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inoutline
	DROP CONSTRAINT IF EXISTS mlocator_minoutline;
ALTER TABLE m_inoutline
	ADD CONSTRAINT mlocator_minoutline
		FOREIGN KEY (m_locator_id) REFERENCES m_locator
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inoutline
	DROP CONSTRAINT IF EXISTS adorg_minoutline;
ALTER TABLE m_inoutline
	ADD CONSTRAINT adorg_minoutline
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inoutline
	DROP CONSTRAINT IF EXISTS adorgtrx_minoutline;
ALTER TABLE m_inoutline
	ADD CONSTRAINT adorgtrx_minoutline
		FOREIGN KEY (ad_orgtrx_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inoutline
	DROP CONSTRAINT IF EXISTS mattrsetinst_minoutline;
ALTER TABLE m_inoutline
	ADD CONSTRAINT mattrsetinst_minoutline
		FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inoutline
	DROP CONSTRAINT IF EXISTS cproject_minoutline;
ALTER TABLE m_inoutline
	ADD CONSTRAINT cproject_minoutline
		FOREIGN KEY (c_project_id) REFERENCES c_project
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inoutline
	DROP CONSTRAINT IF EXISTS ccampaign_minoutline;
ALTER TABLE m_inoutline
	ADD CONSTRAINT ccampaign_minoutline
		FOREIGN KEY (c_campaign_id) REFERENCES c_campaign
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inoutline
	DROP CONSTRAINT IF EXISTS ccharge_minoutline;
ALTER TABLE m_inoutline
	ADD CONSTRAINT ccharge_minoutline
		FOREIGN KEY (c_charge_id) REFERENCES c_charge
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inoutline
	DROP CONSTRAINT IF EXISTS mrmaline_minoutline;
ALTER TABLE m_inoutline
	ADD CONSTRAINT mrmaline_minoutline
		FOREIGN KEY (m_rmaline_id) REFERENCES m_rmaline
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inoutline
	DROP CONSTRAINT IF EXISTS cactivity_minoutline;
ALTER TABLE m_inoutline
	ADD CONSTRAINT cactivity_minoutline
		FOREIGN KEY (c_activity_id) REFERENCES c_activity
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inoutline
	DROP CONSTRAINT IF EXISTS cprojecttask_minoutline;
ALTER TABLE m_inoutline
	ADD CONSTRAINT cprojecttask_minoutline
		FOREIGN KEY (c_projecttask_id) REFERENCES c_projecttask
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inoutline
	DROP CONSTRAINT IF EXISTS c_projectphase_minoutline;
ALTER TABLE m_inoutline
	ADD CONSTRAINT c_projectphase_minoutline
		FOREIGN KEY (c_projectphase_id) REFERENCES c_projectphase
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_locator
	DROP CONSTRAINT IF EXISTS m_warehouse_locator;
ALTER TABLE m_locator
	ADD CONSTRAINT m_warehouse_locator
		FOREIGN KEY (m_warehouse_id) REFERENCES m_warehouse
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_locator
	DROP CONSTRAINT IF EXISTS m_wh_locator_org;
ALTER TABLE m_locator
	ADD CONSTRAINT m_wh_locator_org
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_locator
	DROP CONSTRAINT IF EXISTS m_wh_locator_client;
ALTER TABLE m_locator
	ADD CONSTRAINT m_wh_locator_client
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_locator
	DROP CONSTRAINT IF EXISTS mlocatortype_mlocator;
ALTER TABLE m_locator
	ADD CONSTRAINT mlocatortype_mlocator
		FOREIGN KEY (m_locatortype_id) REFERENCES m_locatortype
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inoutlinema
	DROP CONSTRAINT IF EXISTS minoutline_minoutlinema;
ALTER TABLE m_inoutlinema
	ADD CONSTRAINT minoutline_minoutlinema
		FOREIGN KEY (m_inoutline_id) REFERENCES m_inoutline
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_inoutlinema
	DROP CONSTRAINT IF EXISTS masi_minourlinema;
ALTER TABLE m_inoutlinema
	ADD CONSTRAINT masi_minourlinema
		FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_matchpo
	DROP CONSTRAINT IF EXISTS mproduct_mmatchpo;
ALTER TABLE m_matchpo
	ADD CONSTRAINT mproduct_mmatchpo
		FOREIGN KEY (m_product_id) REFERENCES m_product
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_matchpo
	DROP CONSTRAINT IF EXISTS refmatchpo_mmatchpo;
ALTER TABLE m_matchpo
	ADD CONSTRAINT refmatchpo_mmatchpo
		FOREIGN KEY (ref_matchpo_id) REFERENCES m_matchpo
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_matchpo
	DROP CONSTRAINT IF EXISTS reversal_mmatchpo;
ALTER TABLE m_matchpo
	ADD CONSTRAINT reversal_mmatchpo
		FOREIGN KEY (reversal_id) REFERENCES m_matchpo
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_matchpo
	DROP CONSTRAINT IF EXISTS corderline_mmatchpo;
ALTER TABLE m_matchpo
	ADD CONSTRAINT corderline_mmatchpo
		FOREIGN KEY (c_orderline_id) REFERENCES c_orderline
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_matchpo
	DROP CONSTRAINT IF EXISTS minoutline_mmatchpo;
ALTER TABLE m_matchpo
	ADD CONSTRAINT minoutline_mmatchpo
		FOREIGN KEY (m_inoutline_id) REFERENCES m_inoutline
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_matchpo
	DROP CONSTRAINT IF EXISTS cinvoiceline_mmatchpo;
ALTER TABLE m_matchpo
	ADD CONSTRAINT cinvoiceline_mmatchpo
		FOREIGN KEY (c_invoiceline_id) REFERENCES c_invoiceline
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_matchpo
	DROP CONSTRAINT IF EXISTS mattributesetinstance_mmatchpo;
ALTER TABLE m_matchpo
	ADD CONSTRAINT mattributesetinstance_mmatchpo
		FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_pricelist
	DROP CONSTRAINT IF EXISTS ccurrency_mpricelist;
ALTER TABLE m_pricelist
	ADD CONSTRAINT ccurrency_mpricelist
		FOREIGN KEY (c_currency_id) REFERENCES c_currency
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_pricelist
	DROP CONSTRAINT IF EXISTS basepricelist;
ALTER TABLE m_pricelist
	ADD CONSTRAINT basepricelist
		FOREIGN KEY (basepricelist_id) REFERENCES m_pricelist
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_pricelist_trl
	DROP CONSTRAINT IF EXISTS m_pricelist_trl_uu_idx;
ALTER TABLE m_pricelist_trl
	ADD CONSTRAINT m_pricelist_trl_uu_idx
		UNIQUE (m_pricelist_trl_uu);

ALTER TABLE m_pricelist_trl
	DROP CONSTRAINT IF EXISTS adlanguage_mpricelisttrl;
ALTER TABLE m_pricelist_trl
	ADD CONSTRAINT adlanguage_mpricelisttrl
		FOREIGN KEY (ad_language) REFERENCES ad_language
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_pricelist_trl
	DROP CONSTRAINT IF EXISTS createdby_mpricelisttrl;
ALTER TABLE m_pricelist_trl
	ADD CONSTRAINT createdby_mpricelisttrl
		FOREIGN KEY (createdby) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_pricelist_trl
	DROP CONSTRAINT IF EXISTS updatedby_mpricelisttrl;
ALTER TABLE m_pricelist_trl
	ADD CONSTRAINT updatedby_mpricelisttrl
		FOREIGN KEY (updatedby) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_pricelist_trl
	DROP CONSTRAINT IF EXISTS adorg_mpricelisttrl;
ALTER TABLE m_pricelist_trl
	ADD CONSTRAINT adorg_mpricelisttrl
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_pricelist_trl
	DROP CONSTRAINT IF EXISTS mpricelist_mpricelisttrl;
ALTER TABLE m_pricelist_trl
	ADD CONSTRAINT mpricelist_mpricelisttrl
		FOREIGN KEY (m_pricelist_id) REFERENCES m_pricelist
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_pricelist_trl
	DROP CONSTRAINT IF EXISTS adclient_mpricelisttrl;
ALTER TABLE m_pricelist_trl
	ADD CONSTRAINT adclient_mpricelisttrl
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_pricelist_version
	DROP CONSTRAINT IF EXISTS mpricelistversionbase_mpriceli;
ALTER TABLE m_pricelist_version
	ADD CONSTRAINT mpricelistversionbase_mpriceli
		FOREIGN KEY (m_pricelist_version_base_id) REFERENCES m_pricelist_version
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_pricelist_version
	DROP CONSTRAINT IF EXISTS mpricelist_mpricelistversion;
ALTER TABLE m_pricelist_version
	ADD CONSTRAINT mpricelist_mpricelistversion
		FOREIGN KEY (m_pricelist_id) REFERENCES m_pricelist
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_pricelist_version
	DROP CONSTRAINT IF EXISTS mdiscounts_mplversion;
ALTER TABLE m_pricelist_version
	ADD CONSTRAINT mdiscounts_mplversion
		FOREIGN KEY (m_discountschema_id) REFERENCES m_discountschema
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_pricelist_version_trl
	DROP CONSTRAINT IF EXISTS m_pricelist_version_trl_uu_idx;
ALTER TABLE m_pricelist_version_trl
	ADD CONSTRAINT m_pricelist_version_trl_uu_idx
		UNIQUE (m_pricelist_version_trl_uu);

ALTER TABLE m_pricelist_version_trl
	DROP CONSTRAINT IF EXISTS adlanguage_mpricelistversiontr;
ALTER TABLE m_pricelist_version_trl
	ADD CONSTRAINT adlanguage_mpricelistversiontr
		FOREIGN KEY (ad_language) REFERENCES ad_language
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_pricelist_version_trl
	DROP CONSTRAINT IF EXISTS createdby_mpricelistversiontrl;
ALTER TABLE m_pricelist_version_trl
	ADD CONSTRAINT createdby_mpricelistversiontrl
		FOREIGN KEY (createdby) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_pricelist_version_trl
	DROP CONSTRAINT IF EXISTS updatedby_mpricelistversiontrl;
ALTER TABLE m_pricelist_version_trl
	ADD CONSTRAINT updatedby_mpricelistversiontrl
		FOREIGN KEY (updatedby) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_pricelist_version_trl
	DROP CONSTRAINT IF EXISTS mpricelistversion_mpricelistve;
ALTER TABLE m_pricelist_version_trl
	ADD CONSTRAINT mpricelistversion_mpricelistve
		FOREIGN KEY (m_pricelist_version_id) REFERENCES m_pricelist_version
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_pricelist_version_trl
	DROP CONSTRAINT IF EXISTS adorg_mpricelistversiontrl;
ALTER TABLE m_pricelist_version_trl
	ADD CONSTRAINT adorg_mpricelistversiontrl
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_pricelist_version_trl
	DROP CONSTRAINT IF EXISTS adclient_mpricelistversiontrl;
ALTER TABLE m_pricelist_version_trl
	ADD CONSTRAINT adclient_mpricelistversiontrl
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS paveragecostvariance_mproducta;
ALTER TABLE m_product_acct
	ADD CONSTRAINT paveragecostvariance_mproducta
		FOREIGN KEY (p_averagecostvariance_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS pburden_mproductacct;
ALTER TABLE m_product_acct
	ADD CONSTRAINT pburden_mproductacct
		FOREIGN KEY (p_burden_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS pcostadjustment_mproductacct;
ALTER TABLE m_product_acct
	ADD CONSTRAINT pcostadjustment_mproductacct
		FOREIGN KEY (p_costadjustment_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS pcostofproduction_mproductacct;
ALTER TABLE m_product_acct
	ADD CONSTRAINT pcostofproduction_mproductacct
		FOREIGN KEY (p_costofproduction_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS pfloorstock_mproductacct;
ALTER TABLE m_product_acct
	ADD CONSTRAINT pfloorstock_mproductacct
		FOREIGN KEY (p_floorstock_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS pinventoryclearing_mproductacc;
ALTER TABLE m_product_acct
	ADD CONSTRAINT pinventoryclearing_mproductacc
		FOREIGN KEY (p_inventoryclearing_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS plabor_mproductacct;
ALTER TABLE m_product_acct
	ADD CONSTRAINT plabor_mproductacct
		FOREIGN KEY (p_labor_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS plandedcostclearingvc_mprodacc;
ALTER TABLE m_product_acct
	ADD CONSTRAINT plandedcostclearingvc_mprodacc
		FOREIGN KEY (p_landedcostclearing_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS pmethodchangevariance_mproduct;
ALTER TABLE m_product_acct
	ADD CONSTRAINT pmethodchangevariance_mproduct
		FOREIGN KEY (p_methodchangevariance_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS pmixvariance_mproductacct;
ALTER TABLE m_product_acct
	ADD CONSTRAINT pmixvariance_mproductacct
		FOREIGN KEY (p_mixvariance_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS poutsideprocessing_mproductacc;
ALTER TABLE m_product_acct
	ADD CONSTRAINT poutsideprocessing_mproductacc
		FOREIGN KEY (p_outsideprocessing_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS poverhead_mproductacct;
ALTER TABLE m_product_acct
	ADD CONSTRAINT poverhead_mproductacct
		FOREIGN KEY (p_overhead_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS pratevariance_mproductacct;
ALTER TABLE m_product_acct
	ADD CONSTRAINT pratevariance_mproductacct
		FOREIGN KEY (p_ratevariance_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS pscrap_mproductacct;
ALTER TABLE m_product_acct
	ADD CONSTRAINT pscrap_mproductacct
		FOREIGN KEY (p_scrap_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS pusagevariance_mproductacct;
ALTER TABLE m_product_acct
	ADD CONSTRAINT pusagevariance_mproductacct
		FOREIGN KEY (p_usagevariance_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS pwip_mproductacct;
ALTER TABLE m_product_acct
	ADD CONSTRAINT pwip_mproductacct
		FOREIGN KEY (p_wip_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS vc_passet_mproduct;
ALTER TABLE m_product_acct
	ADD CONSTRAINT vc_passet_mproduct
		FOREIGN KEY (p_asset_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS vc_pcogs_mproduct;
ALTER TABLE m_product_acct
	ADD CONSTRAINT vc_pcogs_mproduct
		FOREIGN KEY (p_cogs_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS vc_pexpense_mproduct;
ALTER TABLE m_product_acct
	ADD CONSTRAINT vc_pexpense_mproduct
		FOREIGN KEY (p_expense_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS vc_pinvoicepv_mproduct;
ALTER TABLE m_product_acct
	ADD CONSTRAINT vc_pinvoicepv_mproduct
		FOREIGN KEY (p_invoicepricevariance_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS vc_ppurchasepv_mproduct;
ALTER TABLE m_product_acct
	ADD CONSTRAINT vc_ppurchasepv_mproduct
		FOREIGN KEY (p_purchasepricevariance_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS vc_prevenue_mproduct;
ALTER TABLE m_product_acct
	ADD CONSTRAINT vc_prevenue_mproduct
		FOREIGN KEY (p_revenue_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS vc_ptdiscountgrant_mproduct;
ALTER TABLE m_product_acct
	ADD CONSTRAINT vc_ptdiscountgrant_mproduct
		FOREIGN KEY (p_tradediscountgrant_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS vc_ptdiscountrec_mproduct;
ALTER TABLE m_product_acct
	ADD CONSTRAINT vc_ptdiscountrec_mproduct
		FOREIGN KEY (p_tradediscountrec_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS m_product_m_product_acct;
ALTER TABLE m_product_acct
	ADD CONSTRAINT m_product_m_product_acct
		FOREIGN KEY (m_product_id) REFERENCES m_product
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS cacctschema_mproductacct;
ALTER TABLE m_product_acct
	ADD CONSTRAINT cacctschema_mproductacct
		FOREIGN KEY (c_acctschema_id) REFERENCES c_acctschema
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_category
	DROP CONSTRAINT IF EXISTS mproductcat_parentcat;
ALTER TABLE m_product_category
	ADD CONSTRAINT mproductcat_parentcat
		FOREIGN KEY (m_product_category_parent_id) REFERENCES m_product_category
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_category
	DROP CONSTRAINT IF EXISTS adprintcolor_mproductcategory;
ALTER TABLE m_product_category
	ADD CONSTRAINT adprintcolor_mproductcategory
		FOREIGN KEY (ad_printcolor_id) REFERENCES ad_printcolor
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_category
	DROP CONSTRAINT IF EXISTS aassetgroup_mproductcategory;
ALTER TABLE m_product_category
	ADD CONSTRAINT aassetgroup_mproductcategory
		FOREIGN KEY (a_asset_group_id) REFERENCES a_asset_group
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS paveragecostvariance_mproductc;
ALTER TABLE m_product_category_acct
	ADD CONSTRAINT paveragecostvariance_mproductc
		FOREIGN KEY (p_averagecostvariance_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS pburden_mproductcategoryacct;
ALTER TABLE m_product_category_acct
	ADD CONSTRAINT pburden_mproductcategoryacct
		FOREIGN KEY (p_burden_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS pcostadjustment_mproductcatego;
ALTER TABLE m_product_category_acct
	ADD CONSTRAINT pcostadjustment_mproductcatego
		FOREIGN KEY (p_costadjustment_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS pcostofproduction_mproductcate;
ALTER TABLE m_product_category_acct
	ADD CONSTRAINT pcostofproduction_mproductcate
		FOREIGN KEY (p_costofproduction_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS pfloorstock_mproductcategoryac;
ALTER TABLE m_product_category_acct
	ADD CONSTRAINT pfloorstock_mproductcategoryac
		FOREIGN KEY (p_floorstock_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS pinventoryclearing_mproductcat;
ALTER TABLE m_product_category_acct
	ADD CONSTRAINT pinventoryclearing_mproductcat
		FOREIGN KEY (p_inventoryclearing_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS plabor_mproductcategoryacct;
ALTER TABLE m_product_category_acct
	ADD CONSTRAINT plabor_mproductcategoryacct
		FOREIGN KEY (p_labor_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS plandedcostclearingvc_mprcatac;
ALTER TABLE m_product_category_acct
	ADD CONSTRAINT plandedcostclearingvc_mprcatac
		FOREIGN KEY (p_landedcostclearing_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS pmethodchangevariance_mprodcat;
ALTER TABLE m_product_category_acct
	ADD CONSTRAINT pmethodchangevariance_mprodcat
		FOREIGN KEY (p_methodchangevariance_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS pmixvariance_mproductcategorya;
ALTER TABLE m_product_category_acct
	ADD CONSTRAINT pmixvariance_mproductcategorya
		FOREIGN KEY (p_mixvariance_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS poutsideprocessing_mproductcat;
ALTER TABLE m_product_category_acct
	ADD CONSTRAINT poutsideprocessing_mproductcat
		FOREIGN KEY (p_outsideprocessing_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS poverhead_mproductcategoryacct;
ALTER TABLE m_product_category_acct
	ADD CONSTRAINT poverhead_mproductcategoryacct
		FOREIGN KEY (p_overhead_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS pratevariance_mproductcategory;
ALTER TABLE m_product_category_acct
	ADD CONSTRAINT pratevariance_mproductcategory
		FOREIGN KEY (p_ratevariance_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS pscrap_mproductcategoryacct;
ALTER TABLE m_product_category_acct
	ADD CONSTRAINT pscrap_mproductcategoryacct
		FOREIGN KEY (p_scrap_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS pusagevariance_mproductcategor;
ALTER TABLE m_product_category_acct
	ADD CONSTRAINT pusagevariance_mproductcategor
		FOREIGN KEY (p_usagevariance_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS pwip_mproductcategoryacct;
ALTER TABLE m_product_category_acct
	ADD CONSTRAINT pwip_mproductcategoryacct
		FOREIGN KEY (p_wip_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS vc_passet_mproductcategory;
ALTER TABLE m_product_category_acct
	ADD CONSTRAINT vc_passet_mproductcategory
		FOREIGN KEY (p_asset_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS vc_pcogs_mproductcategory;
ALTER TABLE m_product_category_acct
	ADD CONSTRAINT vc_pcogs_mproductcategory
		FOREIGN KEY (p_cogs_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS vc_pexpense_mproductcategory;
ALTER TABLE m_product_category_acct
	ADD CONSTRAINT vc_pexpense_mproductcategory
		FOREIGN KEY (p_expense_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS vc_pinvoicepv_mproductcategory;
ALTER TABLE m_product_category_acct
	ADD CONSTRAINT vc_pinvoicepv_mproductcategory
		FOREIGN KEY (p_invoicepricevariance_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS vc_ppurchasepv_mproductcategor;
ALTER TABLE m_product_category_acct
	ADD CONSTRAINT vc_ppurchasepv_mproductcategor
		FOREIGN KEY (p_purchasepricevariance_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS vc_prevenue_mproductcategory;
ALTER TABLE m_product_category_acct
	ADD CONSTRAINT vc_prevenue_mproductcategory
		FOREIGN KEY (p_revenue_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS vc_ptdiscountgrant_mproductcat;
ALTER TABLE m_product_category_acct
	ADD CONSTRAINT vc_ptdiscountgrant_mproductcat
		FOREIGN KEY (p_tradediscountgrant_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS vc_ptdiscountrec_mproductcateg;
ALTER TABLE m_product_category_acct
	ADD CONSTRAINT vc_ptdiscountrec_mproductcateg
		FOREIGN KEY (p_tradediscountrec_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS mprodcat_mprodcatacct;
ALTER TABLE m_product_category_acct
	ADD CONSTRAINT mprodcat_mprodcatacct
		FOREIGN KEY (m_product_category_id) REFERENCES m_product_category
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS cacctschema_mprodcatacct;
ALTER TABLE m_product_category_acct
	ADD CONSTRAINT cacctschema_mprodcatacct
		FOREIGN KEY (c_acctschema_id) REFERENCES c_acctschema
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_category_trl
	DROP CONSTRAINT IF EXISTS m_product_category_trl_uu_idx;
ALTER TABLE m_product_category_trl
	ADD CONSTRAINT m_product_category_trl_uu_idx
		UNIQUE (m_product_category_trl_uu);

ALTER TABLE m_product_category_trl
	DROP CONSTRAINT IF EXISTS adlanguage_mproductcategorytrl;
ALTER TABLE m_product_category_trl
	ADD CONSTRAINT adlanguage_mproductcategorytrl
		FOREIGN KEY (ad_language) REFERENCES ad_language
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_category_trl
	DROP CONSTRAINT IF EXISTS mproductcategory_mproductcateg;
ALTER TABLE m_product_category_trl
	ADD CONSTRAINT mproductcategory_mproductcateg
		FOREIGN KEY (m_product_category_id) REFERENCES m_product_category
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_category_trl
	DROP CONSTRAINT IF EXISTS createdby_mproductcategorytrl;
ALTER TABLE m_product_category_trl
	ADD CONSTRAINT createdby_mproductcategorytrl
		FOREIGN KEY (createdby) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_category_trl
	DROP CONSTRAINT IF EXISTS updatedby_mproductcategorytrl;
ALTER TABLE m_product_category_trl
	ADD CONSTRAINT updatedby_mproductcategorytrl
		FOREIGN KEY (updatedby) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_category_trl
	DROP CONSTRAINT IF EXISTS adorg_mproductcategorytrl;
ALTER TABLE m_product_category_trl
	ADD CONSTRAINT adorg_mproductcategorytrl
		FOREIGN KEY (ad_org_id) REFERENCES ad_org
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_product_category_trl
	DROP CONSTRAINT IF EXISTS adclient_mproductcategorytrl;
ALTER TABLE m_product_category_trl
	ADD CONSTRAINT adclient_mproductcategorytrl
		FOREIGN KEY (ad_client_id) REFERENCES ad_client
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_storageonhand
	DROP CONSTRAINT IF EXISTS mproduct_mstorageonhand;
ALTER TABLE m_storageonhand
	ADD CONSTRAINT mproduct_mstorageonhand
		FOREIGN KEY (m_product_id) REFERENCES m_product
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_storageonhand
	DROP CONSTRAINT IF EXISTS mlocator_mstorageonhand;
ALTER TABLE m_storageonhand
	ADD CONSTRAINT mlocator_mstorageonhand
		FOREIGN KEY (m_locator_id) REFERENCES m_locator
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_storageonhand
	DROP CONSTRAINT IF EXISTS mattributesetinstance_mstoraoh;
ALTER TABLE m_storageonhand
	ADD CONSTRAINT mattributesetinstance_mstoraoh
		FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_storagereservation
	DROP CONSTRAINT IF EXISTS mproduct_mstoragereservation;
ALTER TABLE m_storagereservation
	ADD CONSTRAINT mproduct_mstoragereservation
		FOREIGN KEY (m_product_id) REFERENCES m_product
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_storagereservation
	DROP CONSTRAINT IF EXISTS mwarehouse_mstoragereservation;
ALTER TABLE m_storagereservation
	ADD CONSTRAINT mwarehouse_mstoragereservation
		FOREIGN KEY (m_warehouse_id) REFERENCES m_warehouse
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_storagereservation
	DROP CONSTRAINT IF EXISTS mattributesetinstance_mstorare;
ALTER TABLE m_storagereservation
	ADD CONSTRAINT mattributesetinstance_mstorare
		FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_productprice
	DROP CONSTRAINT IF EXISTS m_productprice_unique_idx;
ALTER TABLE m_productprice
	ADD CONSTRAINT m_productprice_unique_idx
		UNIQUE (m_pricelist_version_id, m_product_id);

ALTER TABLE m_productprice
	DROP CONSTRAINT IF EXISTS mproduct_mproductprice;
ALTER TABLE m_productprice
	ADD CONSTRAINT mproduct_mproductprice
		FOREIGN KEY (m_product_id) REFERENCES m_product
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_productprice
	DROP CONSTRAINT IF EXISTS mpricelistver_mproductprice;
ALTER TABLE m_productprice
	ADD CONSTRAINT mpricelistver_mproductprice
		FOREIGN KEY (m_pricelist_version_id) REFERENCES m_pricelist_version
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_transaction
	DROP CONSTRAINT IF EXISTS mproduct_minventorycount;
ALTER TABLE m_transaction
	ADD CONSTRAINT mproduct_minventorycount
		FOREIGN KEY (m_product_id) REFERENCES m_product
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_transaction
	DROP CONSTRAINT IF EXISTS minoutline_mtransaction;
ALTER TABLE m_transaction
	ADD CONSTRAINT minoutline_mtransaction
		FOREIGN KEY (m_inoutline_id) REFERENCES m_inoutline
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_transaction
	DROP CONSTRAINT IF EXISTS mlocator_minventorycount;
ALTER TABLE m_transaction
	ADD CONSTRAINT mlocator_minventorycount
		FOREIGN KEY (m_locator_id) REFERENCES m_locator
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_transaction
	DROP CONSTRAINT IF EXISTS mattrsetinst_mtransaction;
ALTER TABLE m_transaction
	ADD CONSTRAINT mattrsetinst_mtransaction
		FOREIGN KEY (m_attributesetinstance_id) REFERENCES m_attributesetinstance
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_transaction
	DROP CONSTRAINT IF EXISTS mmovementline_mtransaction;
ALTER TABLE m_transaction
	ADD CONSTRAINT mmovementline_mtransaction
		FOREIGN KEY (m_movementline_id) REFERENCES m_movementline
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_transaction
	DROP CONSTRAINT IF EXISTS minventoryline_mtransaction;
ALTER TABLE m_transaction
	ADD CONSTRAINT minventoryline_mtransaction
		FOREIGN KEY (m_inventoryline_id) REFERENCES m_inventoryline
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_transaction
	DROP CONSTRAINT IF EXISTS cprojectissue_mtransaction;
ALTER TABLE m_transaction
	ADD CONSTRAINT cprojectissue_mtransaction
		FOREIGN KEY (c_projectissue_id) REFERENCES c_projectissue
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_transaction
	DROP CONSTRAINT IF EXISTS mproductionline_mtransaction;
ALTER TABLE m_transaction
	ADD CONSTRAINT mproductionline_mtransaction
		FOREIGN KEY (m_productionline_id) REFERENCES m_productionline
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_transaction
	DROP CONSTRAINT IF EXISTS ppcostcollector_mtransaction;
ALTER TABLE m_transaction
	ADD CONSTRAINT ppcostcollector_mtransaction
		FOREIGN KEY (pp_cost_collector_id) REFERENCES pp_cost_collector
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_warehouse_acct
	DROP CONSTRAINT IF EXISTS vc_wdifferences_mwarehouse;
ALTER TABLE m_warehouse_acct
	ADD CONSTRAINT vc_wdifferences_mwarehouse
		FOREIGN KEY (w_differences_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_warehouse_acct
	DROP CONSTRAINT IF EXISTS vc_winvactualadjust_mwarehouse;
ALTER TABLE m_warehouse_acct
	ADD CONSTRAINT vc_winvactualadjust_mwarehouse
		FOREIGN KEY (w_invactualadjust_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_warehouse_acct
	DROP CONSTRAINT IF EXISTS vc_winventory_mwarehouse;
ALTER TABLE m_warehouse_acct
	ADD CONSTRAINT vc_winventory_mwarehouse
		FOREIGN KEY (w_inventory_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_warehouse_acct
	DROP CONSTRAINT IF EXISTS vc_wrevaluation_mwarehouse;
ALTER TABLE m_warehouse_acct
	ADD CONSTRAINT vc_wrevaluation_mwarehouse
		FOREIGN KEY (w_revaluation_acct) REFERENCES c_validcombination
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_warehouse_acct
	DROP CONSTRAINT IF EXISTS m_warehouse_warehouse_acct;
ALTER TABLE m_warehouse_acct
	ADD CONSTRAINT m_warehouse_warehouse_acct
		FOREIGN KEY (m_warehouse_id) REFERENCES m_warehouse
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE m_warehouse_acct
	DROP CONSTRAINT IF EXISTS cacctschema_mwarehouseacct;
ALTER TABLE m_warehouse_acct
	ADD CONSTRAINT cacctschema_mwarehouseacct
		FOREIGN KEY (c_acctschema_id) REFERENCES c_acctschema
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE pa_dashboardpreference
	DROP CONSTRAINT IF EXISTS aduser_padashboardpreference;
ALTER TABLE pa_dashboardpreference
	ADD CONSTRAINT aduser_padashboardpreference
		FOREIGN KEY (ad_user_id) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE pa_dashboardpreference
	DROP CONSTRAINT IF EXISTS padashboardcontent_padashpref;
ALTER TABLE pa_dashboardpreference
	ADD CONSTRAINT padashboardcontent_padashpref
		FOREIGN KEY (pa_dashboardcontent_id) REFERENCES pa_dashboardcontent
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE pa_dashboardpreference
	DROP CONSTRAINT IF EXISTS adrole_padashboardpreference;
ALTER TABLE pa_dashboardpreference
	ADD CONSTRAINT adrole_padashboardpreference
		FOREIGN KEY (ad_role_id) REFERENCES ad_role
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE pa_reportcolumn
	ADD IF NOT EXISTS relativeperiodto numeric;

ALTER TABLE pa_reportline
	ADD IF NOT EXISTS overlinestroketype varchar(3) DEFAULT NULL::character varying;

ALTER TABLE pa_reportline
	ADD IF NOT EXISTS underlinestroketype varchar(3) DEFAULT NULL::character varying;

ALTER TABLE r_requestprocessor
	DROP CONSTRAINT IF EXISTS aduser_rrequestprocessor;
ALTER TABLE r_requestprocessor
	ADD CONSTRAINT aduser_rrequestprocessor
		FOREIGN KEY (supervisor_id) REFERENCES ad_user
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE r_requestprocessor
	DROP CONSTRAINT IF EXISTS adschedule_rrequestprocessor;
ALTER TABLE r_requestprocessor
	ADD CONSTRAINT adschedule_rrequestprocessor
		FOREIGN KEY (ad_schedule_id) REFERENCES ad_schedule
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE r_requestprocessor
	DROP CONSTRAINT IF EXISTS rrequesttype_rrequestprocessor;
ALTER TABLE r_requestprocessor
	ADD CONSTRAINT rrequesttype_rrequestprocessor
		FOREIGN KEY (r_requesttype_id) REFERENCES r_requesttype
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE r_requestprocessorlog
	DROP CONSTRAINT IF EXISTS rrequestprocessor_log;
ALTER TABLE r_requestprocessorlog
	ADD CONSTRAINT rrequestprocessor_log
		FOREIGN KEY (r_requestprocessor_id) REFERENCES r_requestprocessor
			ON DELETE CASCADE
			DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ad_alertprocessor
	DROP CONSTRAINT IF EXISTS ad_alertprocessor_supervisor_id_fkey;

ALTER TABLE ad_alertprocessor
	DROP CONSTRAINT IF EXISTS ad_alertprocessor_ad_schedule_id_fkey;

ALTER TABLE ad_alertprocessorlog
	DROP CONSTRAINT IF EXISTS ad_alertprocessorlog_ad_alertprocessor_id_fkey;

ALTER TABLE ad_client
	DROP CONSTRAINT IF EXISTS ad_client_ad_language_fkey;

ALTER TABLE ad_client
	DROP CONSTRAINT IF EXISTS ad_client_ad_replicationstrategy_id_fkey;

ALTER TABLE ad_client
	DROP CONSTRAINT IF EXISTS ad_client_ad_passwordrule_id_fkey;

ALTER TABLE ad_role
	DROP CONSTRAINT IF EXISTS ad_role_supervisor_id_fkey;

ALTER TABLE ad_role
	DROP CONSTRAINT IF EXISTS ad_role_ad_tree_menu_id_fkey;

ALTER TABLE ad_role
	DROP CONSTRAINT IF EXISTS ad_role_ad_tree_org_id_fkey;

ALTER TABLE ad_role
	DROP CONSTRAINT IF EXISTS ad_role_ad_client_id_fkey;

ALTER TABLE ad_role
	DROP CONSTRAINT IF EXISTS ad_role_c_currency_id_fkey;

ALTER TABLE ad_role
	DROP CONSTRAINT IF EXISTS ad_role_ad_org_id_fkey;

ALTER TABLE ad_user_roles
	DROP CONSTRAINT IF EXISTS ad_user_roles_ad_user_id_fkey;

ALTER TABLE ad_user_roles
	DROP CONSTRAINT IF EXISTS ad_user_roles_ad_role_id_fkey;

ALTER TABLE ad_user_roles
	DROP CONSTRAINT IF EXISTS ad_user_roles_ad_client_id_fkey;

ALTER TABLE ad_user_roles
	DROP CONSTRAINT IF EXISTS ad_user_roles_ad_org_id_fkey;

ALTER TABLE ad_user
	DROP COLUMN eve_bpartners;

ALTER TABLE ad_user
	DROP COLUMN bandahealth_bpartners;

ALTER TABLE ad_user
	DROP CONSTRAINT IF EXISTS ad_user_c_bpartner_id_fkey;

ALTER TABLE ad_user
	DROP CONSTRAINT IF EXISTS ad_user_bp_location_id_fkey;

ALTER TABLE ad_user
	DROP CONSTRAINT IF EXISTS ad_user_c_bpartner_location_id_fkey;

ALTER TABLE ad_user
	DROP CONSTRAINT IF EXISTS ad_user_c_location_id_fkey;

ALTER TABLE ad_user
	DROP CONSTRAINT IF EXISTS ad_user_salesrep_id_fkey;

ALTER TABLE ad_user
	DROP CONSTRAINT IF EXISTS ad_user_supervisor_id_fkey;

ALTER TABLE ad_user
	DROP CONSTRAINT IF EXISTS ad_user_ad_image_id_fkey;

ALTER TABLE ad_user
	DROP CONSTRAINT IF EXISTS ad_user_ad_client_id_fkey;

ALTER TABLE ad_user
	DROP CONSTRAINT IF EXISTS ad_user_c_campaign_id_fkey;

ALTER TABLE ad_user
	DROP CONSTRAINT IF EXISTS ad_user_r_defaultmailtext_id_fkey;

ALTER TABLE ad_user
	DROP CONSTRAINT IF EXISTS ad_user_c_job_id_fkey;

ALTER TABLE ad_user
	DROP CONSTRAINT IF EXISTS ad_user_c_greeting_id_fkey;

ALTER TABLE ad_user
	DROP CONSTRAINT IF EXISTS ad_user_ad_org_id_fkey;

ALTER TABLE ad_user
	DROP CONSTRAINT IF EXISTS ad_user_ad_orgtrx_id_fkey;

ALTER TABLE ad_attachment
	DROP CONSTRAINT IF EXISTS ad_attachment_ad_table_id_fkey;

ALTER TABLE ad_changelog
	DROP CONSTRAINT IF EXISTS ad_changelog_ad_session_id_fkey;

ALTER TABLE ad_changelog
	DROP CONSTRAINT IF EXISTS ad_changelog_ad_column_id_fkey;

ALTER TABLE ad_changelog
	DROP CONSTRAINT IF EXISTS ad_changelog_ad_table_id_fkey;

ALTER TABLE ad_column
	DROP CONSTRAINT IF EXISTS ad_column_ad_element_id_fkey;

ALTER TABLE ad_column
	DROP CONSTRAINT IF EXISTS ad_column_ad_process_id_fkey;

ALTER TABLE ad_column
	DROP CONSTRAINT IF EXISTS ad_column_ad_reference_id_fkey;

ALTER TABLE ad_column
	DROP CONSTRAINT IF EXISTS ad_column_ad_reference_value_id_fkey;

ALTER TABLE ad_column
	DROP CONSTRAINT IF EXISTS ad_column_ad_val_rule_id_fkey;

ALTER TABLE ad_column
	DROP CONSTRAINT IF EXISTS ad_column_ad_table_id_fkey;

ALTER TABLE ad_column
	DROP CONSTRAINT IF EXISTS ad_column_ad_client_id_fkey;

ALTER TABLE ad_column
	DROP CONSTRAINT IF EXISTS ad_column_entitytype_fkey;

ALTER TABLE ad_column
	DROP CONSTRAINT IF EXISTS ad_column_pa_dashboardcontent_id_fkey;

ALTER TABLE ad_column
	DROP CONSTRAINT IF EXISTS ad_column_ad_chart_id_fkey;

ALTER TABLE ad_column
	DROP CONSTRAINT IF EXISTS ad_column_ad_org_id_fkey;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS ad_clientinfo_c_bpartnercashtrx_id_fkey;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS ad_clientinfo_m_productfreight_id_fkey;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS ad_clientinfo_logo_id_fkey;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS ad_clientinfo_logoreport_id_fkey;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS ad_clientinfo_logoweb_id_fkey;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS ad_clientinfo_ad_tree_activity_id_fkey;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS ad_clientinfo_ad_tree_bpartner_id_fkey;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS ad_clientinfo_ad_tree_campaign_id_fkey;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS ad_clientinfo_ad_tree_menu_id_fkey;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS ad_clientinfo_ad_tree_org_id_fkey;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS ad_clientinfo_ad_tree_product_id_fkey;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS ad_clientinfo_ad_tree_project_id_fkey;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS ad_clientinfo_ad_tree_salesregion_id_fkey;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS ad_clientinfo_c_chargefreight_id_fkey;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS ad_clientinfo_c_acctschema1_id_fkey;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS ad_clientinfo_c_calendar_id_fkey;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS ad_clientinfo_ad_client_id_fkey;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS ad_clientinfo_c_uom_length_id_fkey;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS ad_clientinfo_c_uom_time_id_fkey;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS ad_clientinfo_c_uom_volume_id_fkey;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS ad_clientinfo_c_uom_weight_id_fkey;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS ad_clientinfo_ad_storageprovider_id_fkey;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS ad_clientinfo_storagearchive_id_fkey;

ALTER TABLE ad_clientinfo
	DROP CONSTRAINT IF EXISTS ad_clientinfo_storageimage_id_fkey;

ALTER TABLE ad_column_trl
	DROP CONSTRAINT IF EXISTS ad_column_trl_ad_column_id_fkey;

ALTER TABLE ad_column_trl
	DROP CONSTRAINT IF EXISTS ad_column_trl_ad_language_fkey;

ALTER TABLE ad_document_action_access
	DROP CONSTRAINT IF EXISTS ad_document_action_access_ad_role_id_fkey;

ALTER TABLE ad_document_action_access
	DROP CONSTRAINT IF EXISTS ad_document_action_access_ad_ref_list_id_fkey;

ALTER TABLE ad_document_action_access
	DROP CONSTRAINT IF EXISTS ad_document_action_access_c_doctype_id_fkey;

ALTER TABLE ad_element
	DROP CONSTRAINT IF EXISTS ad_element_entitytype_fkey;

ALTER TABLE ad_element_trl
	DROP CONSTRAINT IF EXISTS ad_element_trl_ad_element_id_fkey;

ALTER TABLE ad_element_trl
	DROP CONSTRAINT IF EXISTS ad_element_trl_ad_language_fkey;

ALTER TABLE ad_field
	DROP CONSTRAINT IF EXISTS ad_field_ad_column_id_fkey;

ALTER TABLE ad_field
	DROP CONSTRAINT IF EXISTS ad_field_ad_tab_id_fkey;

ALTER TABLE ad_field
	DROP CONSTRAINT IF EXISTS ad_field_included_tab_id_fkey;

ALTER TABLE ad_field
	DROP CONSTRAINT IF EXISTS ad_field_ad_reference_id_fkey;

ALTER TABLE ad_field
	DROP CONSTRAINT IF EXISTS ad_field_ad_reference_value_id_fkey;

ALTER TABLE ad_field
	DROP CONSTRAINT IF EXISTS ad_field_ad_val_rule_id_fkey;

ALTER TABLE ad_field
	DROP CONSTRAINT IF EXISTS ad_field_ad_client_id_fkey;

ALTER TABLE ad_field
	DROP CONSTRAINT IF EXISTS ad_field_ad_fieldgroup_id_fkey;

ALTER TABLE ad_field
	DROP CONSTRAINT IF EXISTS ad_field_entitytype_fkey;

ALTER TABLE ad_field
	DROP CONSTRAINT IF EXISTS ad_field_ad_fieldstyle_id_fkey;

ALTER TABLE ad_field
	DROP CONSTRAINT IF EXISTS ad_field_ad_labelstyle_id_fkey;

ALTER TABLE ad_field
	DROP CONSTRAINT IF EXISTS ad_field_ad_org_id_fkey;

ALTER TABLE ad_field_trl
	DROP CONSTRAINT IF EXISTS ad_field_trl_ad_field_id_fkey;

ALTER TABLE ad_field_trl
	DROP CONSTRAINT IF EXISTS ad_field_trl_ad_language_fkey;

ALTER TABLE ad_form_access
	DROP CONSTRAINT IF EXISTS ad_form_access_ad_role_id_fkey;

ALTER TABLE ad_form_access
	DROP CONSTRAINT IF EXISTS ad_form_access_ad_form_id_fkey;

ALTER TABLE ad_housekeeping
	DROP CONSTRAINT IF EXISTS ad_housekeeping_pkey;

ALTER TABLE ad_housekeeping
	DROP CONSTRAINT IF EXISTS ad_housekeeping_key;
ALTER TABLE ad_housekeeping
	ADD CONSTRAINT ad_housekeeping_key
		PRIMARY KEY (ad_housekeeping_id);

ALTER TABLE ad_housekeeping
	DROP CONSTRAINT IF EXISTS ad_housekeeping_ad_table_id_fkey;

ALTER TABLE ad_infocolumn
	DROP CONSTRAINT IF EXISTS ad_infocolumn_ad_element_id_fkey;

ALTER TABLE ad_infocolumn
	DROP CONSTRAINT IF EXISTS ad_infocolumn_ad_reference_id_fkey;

ALTER TABLE ad_infocolumn
	DROP CONSTRAINT IF EXISTS ad_infocolumn_ad_reference_value_id_fkey;

ALTER TABLE ad_infocolumn
	DROP CONSTRAINT IF EXISTS ad_infocolumn_ad_val_rule_id_fkey;

ALTER TABLE ad_infocolumn
	DROP CONSTRAINT IF EXISTS ad_infocolumn_entitytype_fkey;

ALTER TABLE ad_infocolumn
	DROP CONSTRAINT IF EXISTS ad_infocolumn_ad_infowindow_id_fkey;

ALTER TABLE ad_infocolumn
	DROP CONSTRAINT IF EXISTS ad_infocolumn_ad_fieldstyle_id_fkey;

ALTER TABLE ad_infowindow_access
	DROP CONSTRAINT IF EXISTS ad_infowindow_access_ad_role_id_fkey;

ALTER TABLE ad_infowindow_access
	DROP CONSTRAINT IF EXISTS ad_infowindow_access_ad_infowindow_id_fkey;

ALTER TABLE ad_issue
	DROP CONSTRAINT IF EXISTS ad_issue_ad_process_id_fkey;

ALTER TABLE ad_issue
	DROP CONSTRAINT IF EXISTS ad_issue_ad_window_id_fkey;

ALTER TABLE ad_issue
	DROP CONSTRAINT IF EXISTS ad_issue_ad_form_id_fkey;

ALTER TABLE ad_issue
	DROP CONSTRAINT IF EXISTS ad_issue_r_request_id_fkey;

ALTER TABLE ad_issue
	DROP CONSTRAINT IF EXISTS ad_issue_a_asset_id_fkey;

ALTER TABLE ad_issue
	DROP CONSTRAINT IF EXISTS ad_issue_r_issueknown_id_fkey;

ALTER TABLE ad_issue
	DROP CONSTRAINT IF EXISTS ad_issue_r_issueproject_id_fkey;

ALTER TABLE ad_issue
	DROP CONSTRAINT IF EXISTS ad_issue_r_issuesystem_id_fkey;

ALTER TABLE ad_issue
	DROP CONSTRAINT IF EXISTS ad_issue_r_issueuser_id_fkey;

ALTER TABLE ad_menu
	DROP CONSTRAINT IF EXISTS ad_menu_ad_window_id_fkey;

ALTER TABLE ad_menu
	DROP CONSTRAINT IF EXISTS ad_menu_ad_process_id_fkey;

ALTER TABLE ad_menu
	DROP CONSTRAINT IF EXISTS ad_menu_ad_client_id_fkey;

ALTER TABLE ad_menu
	DROP CONSTRAINT IF EXISTS ad_menu_ad_workflow_id_fkey;

ALTER TABLE ad_menu
	DROP CONSTRAINT IF EXISTS ad_menu_entitytype_fkey;

ALTER TABLE ad_menu
	DROP CONSTRAINT IF EXISTS ad_menu_ad_infowindow_id_fkey;

ALTER TABLE ad_menu
	DROP CONSTRAINT IF EXISTS ad_menu_ad_form_id_fkey;

ALTER TABLE ad_menu
	DROP CONSTRAINT IF EXISTS ad_menu_ad_task_id_fkey;

ALTER TABLE ad_menu
	DROP CONSTRAINT IF EXISTS ad_menu_ad_workbench_id_fkey;

ALTER TABLE ad_menu
	DROP CONSTRAINT IF EXISTS ad_menu_ad_org_id_fkey;

ALTER TABLE ad_menu_trl
	DROP CONSTRAINT IF EXISTS ad_menu_trl_ad_menu_id_fkey;

ALTER TABLE ad_menu_trl
	DROP CONSTRAINT IF EXISTS ad_menu_trl_ad_language_fkey;

ALTER TABLE ad_note
	DROP CONSTRAINT IF EXISTS ad_note_ad_wf_activity_id_fkey;

ALTER TABLE ad_note
	DROP CONSTRAINT IF EXISTS ad_note_ad_user_id_fkey;

ALTER TABLE ad_note
	DROP CONSTRAINT IF EXISTS ad_note_ad_message_id_fkey;

ALTER TABLE ad_note
	DROP CONSTRAINT IF EXISTS ad_note_ad_table_id_fkey;

ALTER TABLE ad_note
	DROP CONSTRAINT IF EXISTS ad_note_ad_broadcastmessage_id_fkey;

ALTER TABLE ad_org
	DROP CONSTRAINT IF EXISTS ad_org_ad_client_id_fkey;

ALTER TABLE ad_org
	DROP CONSTRAINT IF EXISTS ad_org_ad_replicationstrategy_id_fkey;

ALTER TABLE ad_orginfo
	DROP CONSTRAINT IF EXISTS ad_orginfo_supervisor_id_fkey;

ALTER TABLE ad_orginfo
	DROP CONSTRAINT IF EXISTS ad_orginfo_c_location_id_fkey;

ALTER TABLE ad_orginfo
	DROP CONSTRAINT IF EXISTS ad_orginfo_dropship_warehouse_id_fkey;

ALTER TABLE ad_orginfo
	DROP CONSTRAINT IF EXISTS ad_orginfo_m_warehouse_id_fkey;

ALTER TABLE ad_orginfo
	DROP CONSTRAINT IF EXISTS ad_orginfo_transferbank_id_fkey;

ALTER TABLE ad_orginfo
	DROP CONSTRAINT IF EXISTS ad_orginfo_c_calendar_id_fkey;

ALTER TABLE ad_orginfo
	DROP CONSTRAINT IF EXISTS ad_orginfo_transfercashbook_id_fkey;

ALTER TABLE ad_orginfo
	DROP CONSTRAINT IF EXISTS ad_orginfo_ad_orgtype_id_fkey;

ALTER TABLE ad_orginfo
	DROP CONSTRAINT IF EXISTS ad_orginfo_ad_org_id_fkey;

ALTER TABLE ad_orginfo
	DROP CONSTRAINT IF EXISTS ad_orginfo_parent_org_id_fkey;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS c_bpartner_bpartner_parent_id_fkey;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS c_bpartner_salesrep_id_fkey;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS c_bpartner_logo_id_fkey;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS c_bpartner_invoice_printformat_id_fkey;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS c_bpartner_c_bp_group_id_fkey;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS c_bpartner_m_pricelist_id_fkey;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS c_bpartner_po_pricelist_id_fkey;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS c_bpartner_ad_client_id_fkey;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS c_bpartner_m_discountschema_id_fkey;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS c_bpartner_po_discountschema_id_fkey;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS c_bpartner_c_paymentterm_id_fkey;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS c_bpartner_po_paymentterm_id_fkey;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS c_bpartner_ad_language_fkey;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS c_bpartner_c_dunning_id_fkey;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS c_bpartner_c_invoiceschedule_id_fkey;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS c_bpartner_c_greeting_id_fkey;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS c_bpartner_default1099box_id_fkey;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS c_bpartner_ad_org_id_fkey;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS c_bpartner_ad_orgbp_id_fkey;

ALTER TABLE c_bpartner
	DROP CONSTRAINT IF EXISTS c_bpartner_c_taxgroup_id_fkey;

ALTER TABLE ad_package_imp
	DROP CONSTRAINT IF EXISTS ad_package_imp_ad_package_imp_proc_id_fkey;

ALTER TABLE ad_package_imp_backup
	DROP CONSTRAINT IF EXISTS ad_package_imp_backup_ad_column_id_fkey;

ALTER TABLE ad_package_imp_backup
	DROP CONSTRAINT IF EXISTS ad_package_imp_backup_ad_reference_id_fkey;

ALTER TABLE ad_package_imp_detail
	DROP CONSTRAINT IF EXISTS ad_package_imp_detail_ad_package_imp_id_fkey;

ALTER TABLE ad_package_imp_detail
	DROP CONSTRAINT IF EXISTS ad_package_imp_detail_ad_table_id_fkey;

ALTER TABLE ad_pinstance
	DROP CONSTRAINT IF EXISTS ad_pinstance_ad_user_id_fkey;

ALTER TABLE ad_pinstance
	DROP CONSTRAINT IF EXISTS ad_pinstance_ad_printformat_id_fkey;

ALTER TABLE ad_pinstance
	DROP CONSTRAINT IF EXISTS ad_pinstance_ad_process_id_fkey;

ALTER TABLE ad_pinstance
	DROP CONSTRAINT IF EXISTS ad_pinstance_ad_language_id_fkey;

ALTER TABLE ad_pinstance_log
	DROP CONSTRAINT IF EXISTS ad_pinstance_log_ad_pinstance_id_fkey;

ALTER TABLE ad_pinstance_log
	DROP CONSTRAINT IF EXISTS ad_pinstance_log_ad_table_id_fkey;

ALTER TABLE ad_pinstance_para
	DROP CONSTRAINT IF EXISTS ad_pinstance_para_ad_pinstance_id_fkey;

ALTER TABLE ad_preference
	DROP CONSTRAINT IF EXISTS ad_preference_ad_user_id_fkey;

ALTER TABLE ad_preference
	DROP CONSTRAINT IF EXISTS ad_preference_ad_window_id_fkey;

ALTER TABLE ad_preference
	DROP CONSTRAINT IF EXISTS ad_preference_ad_process_id_fkey;

ALTER TABLE ad_preference
	DROP CONSTRAINT IF EXISTS ad_preference_ad_client_id_fkey;

ALTER TABLE ad_preference
	DROP CONSTRAINT IF EXISTS ad_preference_ad_infowindow_id_fkey;

ALTER TABLE ad_preference
	DROP CONSTRAINT IF EXISTS ad_preference_ad_org_id_fkey;

ALTER TABLE ad_printform
	DROP CONSTRAINT IF EXISTS ad_printform_distrib_order_printformat_id_fkey;

ALTER TABLE ad_printform
	DROP CONSTRAINT IF EXISTS ad_printform_invoice_printformat_id_fkey;

ALTER TABLE ad_printform
	DROP CONSTRAINT IF EXISTS ad_printform_manuf_order_printformat_id_fkey;

ALTER TABLE ad_printform
	DROP CONSTRAINT IF EXISTS ad_printform_order_printformat_id_fkey;

ALTER TABLE ad_printform
	DROP CONSTRAINT IF EXISTS ad_printform_project_printformat_id_fkey;

ALTER TABLE ad_printform
	DROP CONSTRAINT IF EXISTS ad_printform_remittance_printformat_id_fkey;

ALTER TABLE ad_printform
	DROP CONSTRAINT IF EXISTS ad_printform_shipment_printformat_id_fkey;

ALTER TABLE ad_printform
	DROP CONSTRAINT IF EXISTS ad_printform_ad_client_id_fkey;

ALTER TABLE ad_printform
	DROP CONSTRAINT IF EXISTS ad_printform_distrib_order_mailtext_id_fkey;

ALTER TABLE ad_printform
	DROP CONSTRAINT IF EXISTS ad_printform_invoice_mailtext_id_fkey;

ALTER TABLE ad_printform
	DROP CONSTRAINT IF EXISTS ad_printform_manuf_order_mailtext_id_fkey;

ALTER TABLE ad_printform
	DROP CONSTRAINT IF EXISTS ad_printform_order_mailtext_id_fkey;

ALTER TABLE ad_printform
	DROP CONSTRAINT IF EXISTS ad_printform_project_mailtext_id_fkey;

ALTER TABLE ad_printform
	DROP CONSTRAINT IF EXISTS ad_printform_remittance_mailtext_id_fkey;

ALTER TABLE ad_printform
	DROP CONSTRAINT IF EXISTS ad_printform_shipment_mailtext_id_fkey;

ALTER TABLE ad_printformat
	DROP CONSTRAINT IF EXISTS ad_printformat_ad_window_id_fkey;

ALTER TABLE ad_printformat
	DROP CONSTRAINT IF EXISTS ad_printformat_jasperprocess_id_fkey;

ALTER TABLE ad_printformat
	DROP CONSTRAINT IF EXISTS ad_printformat_ad_table_id_fkey;

ALTER TABLE ad_printformat
	DROP CONSTRAINT IF EXISTS ad_printformat_ad_reportview_id_fkey;

ALTER TABLE ad_printformat
	DROP CONSTRAINT IF EXISTS ad_printformat_ad_printfont_id_fkey;

ALTER TABLE ad_printformat
	DROP CONSTRAINT IF EXISTS ad_printformat_ad_printcolor_id_fkey;

ALTER TABLE ad_printformat
	DROP CONSTRAINT IF EXISTS ad_printformat_ad_printpaper_id_fkey;

ALTER TABLE ad_printformat
	DROP CONSTRAINT IF EXISTS ad_printformat_ad_printtableformat_id_fkey;

ALTER TABLE ad_printformat_trl
	DROP CONSTRAINT IF EXISTS ad_printformat_trl_ad_printformat_trl_uu_key;

ALTER TABLE ad_printformat_trl
	DROP CONSTRAINT IF EXISTS ad_printformat_trl_ad_printformat_id_fkey;

ALTER TABLE ad_printformat_trl
	DROP CONSTRAINT IF EXISTS ad_printformat_trl_ad_language_fkey;

ALTER TABLE ad_printformatitem
	DROP CONSTRAINT IF EXISTS ad_printformatitem_ad_column_id_fkey;

ALTER TABLE ad_printformatitem
	DROP CONSTRAINT IF EXISTS ad_printformatitem_ad_printformat_id_fkey;

ALTER TABLE ad_printformatitem
	DROP CONSTRAINT IF EXISTS ad_printformatitem_ad_printformatchild_id_fkey;

ALTER TABLE ad_printformatitem
	DROP CONSTRAINT IF EXISTS ad_printformatitem_ad_printfont_id_fkey;

ALTER TABLE ad_printformatitem
	DROP CONSTRAINT IF EXISTS ad_printformatitem_ad_printcolor_id_fkey;

ALTER TABLE ad_printformatitem
	DROP CONSTRAINT IF EXISTS ad_printformatitem_ad_printgraph_id_fkey;

ALTER TABLE ad_printformatitem_trl
	DROP CONSTRAINT IF EXISTS ad_printformatitem_trl_ad_printformatitem_id_fkey;

ALTER TABLE ad_printformatitem_trl
	DROP CONSTRAINT IF EXISTS ad_printformatitem_trl_ad_language_fkey;

ALTER TABLE ad_process
	DROP CONSTRAINT IF EXISTS ad_process_ad_printformat_id_fkey;

ALTER TABLE ad_process
	DROP CONSTRAINT IF EXISTS ad_process_ad_workflow_id_fkey;

ALTER TABLE ad_process
	DROP CONSTRAINT IF EXISTS ad_process_ad_reportview_id_fkey;

ALTER TABLE ad_process
	DROP CONSTRAINT IF EXISTS ad_process_entitytype_fkey;

ALTER TABLE ad_process
	DROP CONSTRAINT IF EXISTS ad_process_ad_form_id_fkey;

ALTER TABLE ad_process
	DROP CONSTRAINT IF EXISTS ad_process_ad_ctxhelp_id_fkey;

ALTER TABLE ad_process_access
	DROP CONSTRAINT IF EXISTS ad_process_access_ad_role_id_fkey;

ALTER TABLE ad_process_access
	DROP CONSTRAINT IF EXISTS ad_process_access_ad_process_id_fkey;

ALTER TABLE ad_process_access
	DROP CONSTRAINT IF EXISTS ad_process_access_ad_client_id_fkey;

ALTER TABLE ad_process_access
	DROP CONSTRAINT IF EXISTS ad_process_access_ad_org_id_fkey;

ALTER TABLE ad_process_para
	DROP CONSTRAINT IF EXISTS ad_process_para_ad_element_id_fkey;

ALTER TABLE ad_process_para
	DROP CONSTRAINT IF EXISTS ad_process_para_ad_process_id_fkey;

ALTER TABLE ad_process_para
	DROP CONSTRAINT IF EXISTS ad_process_para_ad_reference_id_fkey;

ALTER TABLE ad_process_para
	DROP CONSTRAINT IF EXISTS ad_process_para_ad_reference_value_id_fkey;

ALTER TABLE ad_process_para
	DROP CONSTRAINT IF EXISTS ad_process_para_ad_val_rule_id_fkey;

ALTER TABLE ad_process_para
	DROP CONSTRAINT IF EXISTS ad_process_para_entitytype_fkey;

ALTER TABLE ad_process_para_trl
	DROP CONSTRAINT IF EXISTS ad_process_para_trl_ad_process_para_id_fkey;

ALTER TABLE ad_process_para_trl
	DROP CONSTRAINT IF EXISTS ad_process_para_trl_ad_language_fkey;

ALTER TABLE ad_process_trl
	DROP CONSTRAINT IF EXISTS ad_process_trl_ad_process_id_fkey;

ALTER TABLE ad_process_trl
	DROP CONSTRAINT IF EXISTS ad_process_trl_ad_language_fkey;

ALTER TABLE ad_recentitem
	DROP CONSTRAINT IF EXISTS ad_recentitem_pkey;

ALTER TABLE ad_recentitem
	DROP CONSTRAINT IF EXISTS ad_recentitem_key;
ALTER TABLE ad_recentitem
	ADD CONSTRAINT ad_recentitem_key
		PRIMARY KEY (ad_recentitem_id);

ALTER TABLE ad_recentitem
	DROP CONSTRAINT IF EXISTS ad_recentitem_ad_user_id_fkey;

ALTER TABLE ad_recentitem
	DROP CONSTRAINT IF EXISTS ad_recentitem_ad_tab_id_fkey;

ALTER TABLE ad_recentitem
	DROP CONSTRAINT IF EXISTS ad_recentitem_ad_role_id_fkey;

ALTER TABLE ad_recentitem
	DROP CONSTRAINT IF EXISTS ad_recentitem_ad_window_id_fkey;

ALTER TABLE ad_recentitem
	DROP CONSTRAINT IF EXISTS ad_recentitem_ad_table_id_fkey;

ALTER TABLE ad_role_included
	DROP CONSTRAINT IF EXISTS ad_role_included_ad_role_id_fkey;

ALTER TABLE ad_role_included
	DROP CONSTRAINT IF EXISTS ad_role_included_included_role_id_fkey;

ALTER TABLE ad_role_orgaccess
	DROP CONSTRAINT IF EXISTS ad_role_orgaccess_ad_role_id_fkey;

ALTER TABLE ad_role_orgaccess
	DROP CONSTRAINT IF EXISTS ad_role_orgaccess_ad_org_id_fkey;

ALTER TABLE ad_scheduler
	DROP CONSTRAINT IF EXISTS ad_scheduler_supervisor_id_fkey;

ALTER TABLE ad_scheduler
	DROP CONSTRAINT IF EXISTS ad_scheduler_ad_printformat_id_fkey;

ALTER TABLE ad_scheduler
	DROP CONSTRAINT IF EXISTS ad_scheduler_ad_table_id_fkey;

ALTER TABLE ad_scheduler
	DROP CONSTRAINT IF EXISTS ad_scheduler_ad_process_id_fkey;

ALTER TABLE ad_scheduler
	DROP CONSTRAINT IF EXISTS ad_scheduler_r_mailtext_id_fkey;

ALTER TABLE ad_scheduler
	DROP CONSTRAINT IF EXISTS ad_scheduler_ad_schedule_id_fkey;

ALTER TABLE ad_scheduler_para
	DROP CONSTRAINT IF EXISTS ad_scheduler_para_ad_process_para_id_fkey;

ALTER TABLE ad_scheduler_para
	DROP CONSTRAINT IF EXISTS ad_scheduler_para_ad_scheduler_id_fkey;

ALTER TABLE ad_schedulerlog
	DROP CONSTRAINT IF EXISTS ad_schedulerlog_ad_scheduler_id_fkey;

ALTER TABLE ad_schedulerrecipient
	DROP CONSTRAINT IF EXISTS ad_schedulerrecipient_ad_user_id_fkey;

ALTER TABLE ad_schedulerrecipient
	DROP CONSTRAINT IF EXISTS ad_schedulerrecipient_ad_role_id_fkey;

ALTER TABLE ad_schedulerrecipient
	DROP CONSTRAINT IF EXISTS ad_schedulerrecipient_ad_scheduler_id_fkey;

ALTER TABLE ad_sequence
	DROP CONSTRAINT IF EXISTS ad_sequence_ad_client_id_fkey;

ALTER TABLE ad_sequence
	DROP CONSTRAINT IF EXISTS ad_sequence_ad_org_id_fkey;

ALTER TABLE ad_session
	DROP CONSTRAINT IF EXISTS ad_session_ad_role_id_fkey;

ALTER TABLE ad_tree
	DROP CONSTRAINT IF EXISTS ad_tree_parent_column_id_fkey;

ALTER TABLE ad_tree
	DROP CONSTRAINT IF EXISTS ad_tree_ad_table_id_fkey;

ALTER TABLE ad_treenode
	DROP CONSTRAINT IF EXISTS ad_treenode_ad_tree_id_fkey;

ALTER TABLE ad_treenodebp
	DROP CONSTRAINT IF EXISTS ad_treenodebp_ad_tree_id_fkey;

ALTER TABLE ad_treenodepr
	DROP CONSTRAINT IF EXISTS ad_treenodepr_ad_tree_id_fkey;

ALTER TABLE ad_usermail
	DROP CONSTRAINT IF EXISTS ad_usermail_ad_user_id_fkey;

ALTER TABLE ad_usermail
	DROP CONSTRAINT IF EXISTS ad_usermail_r_mailtext_id_fkey;

ALTER TABLE ad_usermail
	DROP CONSTRAINT IF EXISTS ad_usermail_w_mailmsg_id_fkey;

ALTER TABLE ad_userpreference
	DROP CONSTRAINT IF EXISTS ad_userpreference_ad_userpreference_uu_key;

ALTER TABLE ad_userpreference
	DROP CONSTRAINT IF EXISTS ad_userpreference_ad_user_id_fkey;

ALTER TABLE ad_userpreference
	DROP CONSTRAINT IF EXISTS ad_userpreference_createdby_fkey;

ALTER TABLE ad_userpreference
	DROP CONSTRAINT IF EXISTS ad_userpreference_updatedby_fkey;

ALTER TABLE ad_userpreference
	DROP CONSTRAINT IF EXISTS ad_userpreference_ad_client_id_fkey;

ALTER TABLE ad_userpreference
	DROP CONSTRAINT IF EXISTS ad_userpreference_ad_org_id_fkey;

ALTER TABLE ad_wf_activity
	DROP CONSTRAINT IF EXISTS ad_wf_activity_ad_user_id_fkey;

ALTER TABLE ad_wf_activity
	DROP CONSTRAINT IF EXISTS ad_wf_activity_ad_wf_process_id_fkey;

ALTER TABLE ad_wf_activity
	DROP CONSTRAINT IF EXISTS ad_wf_activity_ad_message_id_fkey;

ALTER TABLE ad_wf_activity
	DROP CONSTRAINT IF EXISTS ad_wf_activity_ad_table_id_fkey;

ALTER TABLE ad_wf_activity
	DROP CONSTRAINT IF EXISTS ad_wf_activity_ad_wf_node_id_fkey;

ALTER TABLE ad_wf_activity
	DROP CONSTRAINT IF EXISTS ad_wf_activity_ad_workflow_id_fkey;

ALTER TABLE ad_wf_activity
	DROP CONSTRAINT IF EXISTS ad_wf_activity_ad_wf_responsible_id_fkey;

ALTER TABLE ad_wf_eventaudit
	DROP CONSTRAINT IF EXISTS ad_wf_eventaudit_ad_user_id_fkey;

ALTER TABLE ad_wf_eventaudit
	DROP CONSTRAINT IF EXISTS ad_wf_eventaudit_ad_wf_process_id_fkey;

ALTER TABLE ad_wf_eventaudit
	DROP CONSTRAINT IF EXISTS ad_wf_eventaudit_ad_table_id_fkey;

ALTER TABLE ad_wf_eventaudit
	DROP CONSTRAINT IF EXISTS ad_wf_eventaudit_ad_wf_node_id_fkey;

ALTER TABLE ad_wf_eventaudit
	DROP CONSTRAINT IF EXISTS ad_wf_eventaudit_ad_wf_responsible_id_fkey;

ALTER TABLE ad_wf_process
	DROP CONSTRAINT IF EXISTS ad_wf_process_ad_wf_process_id_fkey;

ALTER TABLE ad_wf_process
	DROP CONSTRAINT IF EXISTS ad_wf_process_ad_user_id_fkey;

ALTER TABLE ad_wf_process
	DROP CONSTRAINT IF EXISTS ad_wf_process_ad_message_id_fkey;

ALTER TABLE ad_wf_process
	DROP CONSTRAINT IF EXISTS ad_wf_process_ad_table_id_fkey;

ALTER TABLE ad_wf_process
	DROP CONSTRAINT IF EXISTS ad_wf_process_ad_client_id_fkey;

ALTER TABLE ad_wf_process
	DROP CONSTRAINT IF EXISTS ad_wf_process_ad_workflow_id_fkey;

ALTER TABLE ad_wf_process
	DROP CONSTRAINT IF EXISTS ad_wf_process_ad_wf_responsible_id_fkey;

ALTER TABLE ad_wf_process
	DROP CONSTRAINT IF EXISTS ad_wf_process_ad_org_id_fkey;

ALTER TABLE ad_window_access
	DROP CONSTRAINT IF EXISTS ad_window_access_ad_role_id_fkey;

ALTER TABLE ad_window_access
	DROP CONSTRAINT IF EXISTS ad_window_access_ad_window_id_fkey;

ALTER TABLE ad_window_access
	DROP CONSTRAINT IF EXISTS ad_window_access_ad_client_id_fkey;

ALTER TABLE ad_window_access
	DROP CONSTRAINT IF EXISTS ad_window_access_ad_org_id_fkey;

ALTER TABLE ad_workflow_access
	DROP CONSTRAINT IF EXISTS ad_workflow_access_ad_role_id_fkey;

ALTER TABLE ad_workflow_access
	DROP CONSTRAINT IF EXISTS ad_workflow_access_ad_client_id_fkey;

ALTER TABLE ad_workflow_access
	DROP CONSTRAINT IF EXISTS ad_workflow_access_ad_workflow_id_fkey;

ALTER TABLE ad_workflow_access
	DROP CONSTRAINT IF EXISTS ad_workflow_access_ad_org_id_fkey;

ALTER TABLE ad_workflowprocessor
	DROP CONSTRAINT IF EXISTS ad_workflowprocessor_supervisor_id_fkey;

ALTER TABLE ad_workflowprocessor
	DROP CONSTRAINT IF EXISTS ad_workflowprocessor_ad_schedule_id_fkey;

ALTER TABLE ad_workflowprocessorlog
	DROP CONSTRAINT IF EXISTS ad_workflowprocessorlog_ad_workflowprocessor_id_fkey;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS c_invoice_ref_invoice_id_fkey;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS c_invoice_relatedinvoice_id_fkey;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS c_invoice_reversal_id_fkey;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS c_invoice_c_order_id_fkey;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS c_invoice_c_payment_id_fkey;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS c_invoice_c_bpartner_id_fkey;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS c_invoice_ad_user_id_fkey;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS c_invoice_salesrep_id_fkey;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS c_invoice_c_bpartner_location_id_fkey;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS c_invoice_c_doctype_id_fkey;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS c_invoice_c_doctypetarget_id_fkey;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS c_invoice_m_pricelist_id_fkey;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS c_invoice_c_charge_id_fkey;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS c_invoice_user1_id_fkey;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS c_invoice_user2_id_fkey;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS c_invoice_c_campaign_id_fkey;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS c_invoice_c_paymentterm_id_fkey;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS c_invoice_c_currency_id_fkey;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS c_invoice_c_activity_id_fkey;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS c_invoice_c_project_id_fkey;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS c_invoice_ad_org_id_fkey;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS c_invoice_ad_orgtrx_id_fkey;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS c_invoice_c_cashline_id_fkey;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS c_invoice_c_dunninglevel_id_fkey;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS c_invoice_c_conversiontype_id_fkey;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS c_invoice_m_rma_id_fkey;

ALTER TABLE c_invoice
	DROP CONSTRAINT IF EXISTS c_invoice_c_cashplanline_id_fkey;

DROP INDEX IF EXISTS c_order_dateordered_index;

DROP INDEX IF EXISTS c_order_docstatus_index;

DROP INDEX IF EXISTS c_order_visit;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order_link_order_id_fkey;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order_quotationorder_id_fkey;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order_ref_order_id_fkey;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order_c_payment_id_fkey;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order_bill_bpartner_id_fkey;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order_c_bpartner_id_fkey;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order_dropship_bpartner_id_fkey;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order_pay_bpartner_id_fkey;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order_ad_user_id_fkey;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order_bill_user_id_fkey;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order_dropship_user_id_fkey;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order_salesrep_id_fkey;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order_bill_location_id_fkey;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order_c_bpartner_location_id_fkey;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order_dropship_location_id_fkey;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order_pay_location_id_fkey;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order_c_doctype_id_fkey;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order_c_doctypetarget_id_fkey;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order_c_charge_id_fkey;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order_m_pricelist_id_fkey;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order_m_warehouse_id_fkey;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order_c_campaign_id_fkey;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order_user1_id_fkey;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order_user2_id_fkey;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order_c_paymentterm_id_fkey;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order_c_currency_id_fkey;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order_c_activity_id_fkey;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order_c_project_id_fkey;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order_ad_org_id_fkey;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order_c_cashline_id_fkey;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order_c_conversiontype_id_fkey;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order_m_shipper_id_fkey;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order_m_freightcategory_id_fkey;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order_c_pos_id_fkey;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order_ad_orgtrx_id_fkey;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order_c_opportunity_id_fkey;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order_c_cashplanline_id_fkey;

ALTER TABLE c_order
	DROP CONSTRAINT IF EXISTS c_order_c_ordersource_id_fkey;

DROP INDEX c_payment_bh_visit_id_index;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS c_payment_c_invoice_id_fkey;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS c_payment_c_order_id_fkey;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS c_payment_ref_payment_id_fkey;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS c_payment_reversal_id_fkey;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS c_payment_c_bpartner_id_fkey;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS c_payment_c_doctype_id_fkey;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS c_payment_c_bankaccount_id_fkey;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS c_payment_c_charge_id_fkey;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS c_payment_user1_id_fkey;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS c_payment_c_campaign_id_fkey;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS c_payment_c_cashbook_id_fkey;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS c_payment_user2_id_fkey;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS c_payment_c_currency_id_fkey;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS c_payment_c_project_id_fkey;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS c_payment_ad_org_id_fkey;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS c_payment_c_activity_id_fkey;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS c_payment_c_paymentprocessor_id_fkey;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS c_payment_c_bp_bankaccount_id_fkey;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS c_payment_c_conversiontype_id_fkey;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS c_payment_ad_orgtrx_id_fkey;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS c_payment_c_depositbatch_id_fkey;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS c_payment_c_paymentbatch_id_fkey;

ALTER TABLE c_payment
	DROP CONSTRAINT IF EXISTS c_payment_c_postendertype_id_fkey;

ALTER TABLE m_locator
	DROP CONSTRAINT IF EXISTS m_locator_m_warehouse_id_fkey;

ALTER TABLE m_locator
	DROP CONSTRAINT IF EXISTS m_locator_ad_client_id_fkey;

ALTER TABLE m_locator
	DROP CONSTRAINT IF EXISTS m_locator_m_locatortype_id_fkey;

ALTER TABLE m_locator
	DROP CONSTRAINT IF EXISTS m_locator_ad_org_id_fkey;

ALTER TABLE m_product
	DROP CONSTRAINT IF EXISTS m_product_salesrep_id_fkey;

ALTER TABLE m_product
	DROP CONSTRAINT IF EXISTS m_product_m_attributesetinstance_id_fkey;

ALTER TABLE m_product
	DROP CONSTRAINT IF EXISTS m_product_m_product_category_id_fkey;

ALTER TABLE m_product
	DROP CONSTRAINT IF EXISTS m_product_m_attributeset_id_fkey;

ALTER TABLE m_product
	DROP CONSTRAINT IF EXISTS m_product_m_locator_id_fkey;

ALTER TABLE m_product
	DROP CONSTRAINT IF EXISTS m_product_ad_client_id_fkey;

ALTER TABLE m_product
	DROP CONSTRAINT IF EXISTS m_product_c_taxcategory_id_fkey;

ALTER TABLE m_product
	DROP CONSTRAINT IF EXISTS m_product_s_resource_id_fkey;

ALTER TABLE m_product
	DROP CONSTRAINT IF EXISTS m_product_r_mailtext_id_fkey;

ALTER TABLE m_product
	DROP CONSTRAINT IF EXISTS m_product_c_uom_id_fkey;

ALTER TABLE m_product
	DROP CONSTRAINT IF EXISTS m_product_c_revenuerecognition_id_fkey;

ALTER TABLE m_product
	DROP CONSTRAINT IF EXISTS m_product_s_expensetype_id_fkey;

ALTER TABLE m_product
	DROP CONSTRAINT IF EXISTS m_product_m_freightcategory_id_fkey;

ALTER TABLE m_product
	DROP CONSTRAINT IF EXISTS m_product_c_subscriptiontype_id_fkey;

ALTER TABLE m_product
	DROP CONSTRAINT IF EXISTS m_product_m_parttype_id_fkey;

ALTER TABLE m_product
	DROP CONSTRAINT IF EXISTS m_product_ad_org_id_fkey;

ALTER TABLE m_storageonhand
	DROP CONSTRAINT IF EXISTS m_storageonhand_m_attributesetinstance_id_fkey;

ALTER TABLE m_storageonhand
	DROP CONSTRAINT IF EXISTS m_storageonhand_m_product_id_fkey;

ALTER TABLE m_storageonhand
	DROP CONSTRAINT IF EXISTS m_storageonhand_m_locator_id_fkey;

ALTER TABLE m_storagereservation
	DROP CONSTRAINT IF EXISTS m_storagereservation_m_attributesetinstance_id_fkey;

ALTER TABLE m_storagereservation
	DROP CONSTRAINT IF EXISTS m_storagereservation_m_product_id_fkey;

ALTER TABLE m_storagereservation
	DROP CONSTRAINT IF EXISTS m_storagereservation_m_warehouse_id_fkey;

ALTER TABLE m_warehouse
	DROP CONSTRAINT IF EXISTS m_warehouse_c_location_id_fkey;

ALTER TABLE m_warehouse
	DROP CONSTRAINT IF EXISTS m_warehouse_m_reservelocator_id_fkey;

ALTER TABLE m_warehouse
	DROP CONSTRAINT IF EXISTS m_warehouse_m_warehousesource_id_fkey;

ALTER TABLE m_warehouse
	DROP CONSTRAINT IF EXISTS m_warehouse_ad_client_id_fkey;

ALTER TABLE m_warehouse
	DROP CONSTRAINT IF EXISTS m_warehouse_ad_org_id_fkey;

ALTER TABLE m_transaction
	DROP CONSTRAINT IF EXISTS m_transaction_m_inoutline_id_fkey;

ALTER TABLE m_transaction
	DROP CONSTRAINT IF EXISTS m_transaction_m_inventoryline_id_fkey;

ALTER TABLE m_transaction
	DROP CONSTRAINT IF EXISTS m_transaction_m_attributesetinstance_id_fkey;

ALTER TABLE m_transaction
	DROP CONSTRAINT IF EXISTS m_transaction_m_product_id_fkey;

ALTER TABLE m_transaction
	DROP CONSTRAINT IF EXISTS m_transaction_m_locator_id_fkey;

ALTER TABLE m_transaction
	DROP CONSTRAINT IF EXISTS m_transaction_m_movementline_id_fkey;

ALTER TABLE m_transaction
	DROP CONSTRAINT IF EXISTS m_transaction_c_projectissue_id_fkey;

ALTER TABLE m_transaction
	DROP CONSTRAINT IF EXISTS m_transaction_m_productionline_id_fkey;

ALTER TABLE m_transaction
	DROP CONSTRAINT IF EXISTS m_transaction_pp_cost_collector_id_fkey;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS c_orderline_link_orderline_id_fkey;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS c_orderline_c_order_id_fkey;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS c_orderline_ref_orderline_id_fkey;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS c_orderline_c_bpartner_id_fkey;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS c_orderline_c_bpartner_location_id_fkey;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS c_orderline_m_attributesetinstance_id_fkey;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS c_orderline_m_product_id_fkey;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS c_orderline_user1_id_fkey;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS c_orderline_user2_id_fkey;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS c_orderline_c_charge_id_fkey;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS c_orderline_m_warehouse_id_fkey;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS c_orderline_ad_org_id_fkey;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS c_orderline_ad_orgtrx_id_fkey;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS c_orderline_c_campaign_id_fkey;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS c_orderline_c_project_id_fkey;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS c_orderline_c_tax_id_fkey;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS c_orderline_c_currency_id_fkey;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS c_orderline_c_activity_id_fkey;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS c_orderline_c_uom_id_fkey;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS c_orderline_m_shipper_id_fkey;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS c_orderline_s_resourceassignment_id_fkey;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS c_orderline_c_projectphase_id_fkey;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS c_orderline_c_projecttask_id_fkey;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS c_orderline_m_promotion_id_fkey;

ALTER TABLE c_orderline
	DROP CONSTRAINT IF EXISTS c_orderline_pp_cost_collector_id_fkey;

ALTER TABLE c_bpartner_location
	DROP CONSTRAINT IF EXISTS c_bpartner_location_c_bpartner_id_fkey;

ALTER TABLE c_bpartner_location
	DROP CONSTRAINT IF EXISTS c_bpartner_location_c_location_id_fkey;

ALTER TABLE c_bpartner_location
	DROP CONSTRAINT IF EXISTS c_bpartner_location_ad_client_id_fkey;

ALTER TABLE c_bpartner_location
	DROP CONSTRAINT IF EXISTS c_bpartner_location_c_salesregion_id_fkey;

ALTER TABLE c_bpartner_location
	DROP CONSTRAINT IF EXISTS c_bpartner_location_ad_org_id_fkey;

ALTER TABLE c_location
	DROP CONSTRAINT IF EXISTS c_location_c_region_id_fkey;

ALTER TABLE c_location
	DROP CONSTRAINT IF EXISTS c_location_c_country_id_fkey;

ALTER TABLE c_location
	DROP CONSTRAINT IF EXISTS c_location_ad_client_id_fkey;

ALTER TABLE c_location
	DROP CONSTRAINT IF EXISTS c_location_c_city_id_fkey;

ALTER TABLE c_location
	DROP CONSTRAINT IF EXISTS c_location_c_addressvalidation_id_fkey;

ALTER TABLE c_location
	DROP CONSTRAINT IF EXISTS c_location_ad_org_id_fkey;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS c_invoiceline_c_invoice_id_fkey;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS c_invoiceline_m_inoutline_id_fkey;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS c_invoiceline_ref_invoiceline_id_fkey;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS c_invoiceline_c_orderline_id_fkey;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS c_invoiceline_m_attributesetinstance_id_fkey;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS c_invoiceline_m_product_id_fkey;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS c_invoiceline_c_charge_id_fkey;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS c_invoiceline_user1_id_fkey;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS c_invoiceline_user2_id_fkey;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS c_invoiceline_c_tax_id_fkey;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS c_invoiceline_ad_org_id_fkey;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS c_invoiceline_ad_orgtrx_id_fkey;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS c_invoiceline_c_activity_id_fkey;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS c_invoiceline_c_campaign_id_fkey;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS c_invoiceline_a_asset_group_id_fkey;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS c_invoiceline_c_project_id_fkey;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS c_invoiceline_s_resourceassignment_id_fkey;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS c_invoiceline_c_uom_id_fkey;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS c_invoiceline_a_asset_id_fkey;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS c_invoiceline_c_1099box_id_fkey;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS c_invoiceline_c_projectphase_id_fkey;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS c_invoiceline_c_projecttask_id_fkey;

ALTER TABLE c_invoiceline
	DROP CONSTRAINT IF EXISTS c_invoiceline_m_rmaline_id_fkey;

ALTER TABLE m_attributeset
	DROP CONSTRAINT IF EXISTS m_attributeset_m_sernoctl_id_fkey;

ALTER TABLE m_attributeset
	DROP CONSTRAINT IF EXISTS m_attributeset_m_lotctl_id_fkey;

ALTER TABLE m_attributesetinstance
	DROP CONSTRAINT IF EXISTS m_attributesetinstance_m_attributeset_id_fkey;

ALTER TABLE m_attributesetinstance
	DROP CONSTRAINT IF EXISTS m_attributesetinstance_m_lot_id_fkey;

ALTER TABLE c_acctprocessor
	DROP CONSTRAINT IF EXISTS c_acctprocessor_supervisor_id_fkey;

ALTER TABLE c_acctprocessor
	DROP CONSTRAINT IF EXISTS c_acctprocessor_ad_table_id_fkey;

ALTER TABLE c_acctprocessor
	DROP CONSTRAINT IF EXISTS c_acctprocessor_c_acctschema_id_fkey;

ALTER TABLE c_acctprocessor
	DROP CONSTRAINT IF EXISTS c_acctprocessor_ad_schedule_id_fkey;

DROP INDEX IF EXISTS c_acctprocessorlogid_index;

ALTER TABLE c_acctprocessorlog
	DROP CONSTRAINT IF EXISTS c_acctprocessorlog_c_acctprocessor_id_fkey;

ALTER TABLE c_acctschema
	DROP CONSTRAINT IF EXISTS c_acctschema_c_period_id_fkey;

ALTER TABLE c_acctschema
	DROP CONSTRAINT IF EXISTS c_acctschema_m_costtype_id_fkey;

ALTER TABLE c_acctschema
	DROP CONSTRAINT IF EXISTS c_acctschema_ad_client_id_fkey;

ALTER TABLE c_acctschema
	DROP CONSTRAINT IF EXISTS c_acctschema_c_currency_id_fkey;

ALTER TABLE c_acctschema
	DROP CONSTRAINT IF EXISTS c_acctschema_ad_org_id_fkey;

ALTER TABLE c_acctschema
	DROP CONSTRAINT IF EXISTS c_acctschema_ad_orgonly_id_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_b_asset_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_b_expense_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_b_interestexp_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_b_interestrev_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_b_intransit_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_b_paymentselect_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_b_revaluationgain_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_b_revaluationloss_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_b_settlementgain_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_b_settlementloss_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_b_unallocatedcash_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_b_unidentified_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_c_prepayment_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_c_receivable_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_c_receivable_services_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_cb_asset_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_cb_cashtransfer_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_cb_differences_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_cb_expense_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_cb_receipt_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_ch_expense_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_ch_revenue_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_e_expense_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_e_prepayment_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_notinvoicedreceipts_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_notinvoicedreceivables_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_notinvoicedrevenue_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_p_asset_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_p_averagecostvariance_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_p_burden_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_p_cogs_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_p_costadjustment_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_p_costofproduction_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_p_expense_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_p_floorstock_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_p_inventoryclearing_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_p_invoicepricevariance_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_p_labor_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_p_landedcostclearing_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_p_methodchangevariance_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_p_mixvariance_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_p_outsideprocessing_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_p_overhead_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_p_purchasepricevariance_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_p_ratevariance_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_p_revenue_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_p_scrap_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_p_tradediscountgrant_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_p_tradediscountrec_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_p_usagevariance_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_p_wip_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_paydiscount_exp_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_paydiscount_rev_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_pj_asset_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_pj_wip_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_realizedgain_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_realizedloss_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_t_credit_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_t_due_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_t_expense_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_t_liability_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_t_receivables_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_unearnedrevenue_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_unrealizedgain_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_unrealizedloss_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_v_liability_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_v_liability_services_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_v_prepayment_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_w_differences_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_w_invactualadjust_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_w_inventory_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_w_revaluation_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_withholding_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_writeoff_acct_fkey;

ALTER TABLE c_acctschema_default
	DROP CONSTRAINT IF EXISTS c_acctschema_default_c_acctschema_id_fkey;

ALTER TABLE c_acctschema_gl
	DROP CONSTRAINT IF EXISTS c_acctschema_gl_commitmentoffset_acct_fkey;

ALTER TABLE c_acctschema_gl
	DROP CONSTRAINT IF EXISTS c_acctschema_gl_commitmentoffsetsales_acct_fkey;

ALTER TABLE c_acctschema_gl
	DROP CONSTRAINT IF EXISTS c_acctschema_gl_currencybalancing_acct_fkey;

ALTER TABLE c_acctschema_gl
	DROP CONSTRAINT IF EXISTS c_acctschema_gl_incomesummary_acct_fkey;

ALTER TABLE c_acctschema_gl
	DROP CONSTRAINT IF EXISTS c_acctschema_gl_intercompanyduefrom_acct_fkey;

ALTER TABLE c_acctschema_gl
	DROP CONSTRAINT IF EXISTS c_acctschema_gl_intercompanydueto_acct_fkey;

ALTER TABLE c_acctschema_gl
	DROP CONSTRAINT IF EXISTS c_acctschema_gl_ppvoffset_acct_fkey;

ALTER TABLE c_acctschema_gl
	DROP CONSTRAINT IF EXISTS c_acctschema_gl_retainedearning_acct_fkey;

ALTER TABLE c_acctschema_gl
	DROP CONSTRAINT IF EXISTS c_acctschema_gl_suspensebalancing_acct_fkey;

ALTER TABLE c_acctschema_gl
	DROP CONSTRAINT IF EXISTS c_acctschema_gl_suspenseerror_acct_fkey;

ALTER TABLE c_acctschema_gl
	DROP CONSTRAINT IF EXISTS c_acctschema_gl_c_acctschema_id_fkey;

ALTER TABLE c_activity_trl
	DROP CONSTRAINT IF EXISTS c_activity_trl_c_activity_trl_uu_key;

ALTER TABLE c_activity_trl
	DROP CONSTRAINT IF EXISTS c_activity_trl_createdby_fkey;

ALTER TABLE c_activity_trl
	DROP CONSTRAINT IF EXISTS c_activity_trl_updatedby_fkey;

ALTER TABLE c_activity_trl
	DROP CONSTRAINT IF EXISTS c_activity_trl_ad_client_id_fkey;

ALTER TABLE c_activity_trl
	DROP CONSTRAINT IF EXISTS c_activity_trl_ad_language_fkey;

ALTER TABLE c_activity_trl
	DROP CONSTRAINT IF EXISTS c_activity_trl_c_activity_id_fkey;

ALTER TABLE c_activity_trl
	DROP CONSTRAINT IF EXISTS c_activity_trl_ad_org_id_fkey;

DROP INDEX IF EXISTS c_allocationhdr_processing_index;

ALTER TABLE c_allocationhdr
	DROP CONSTRAINT IF EXISTS c_allocationhdr_reversal_id_fkey;

ALTER TABLE c_allocationhdr
	DROP CONSTRAINT IF EXISTS c_allocationhdr_c_doctype_id_fkey;

ALTER TABLE c_allocationhdr
	DROP CONSTRAINT IF EXISTS c_allocationhdr_c_currency_id_fkey;

DROP INDEX IF EXISTS c_allocationhdr_id_index;

ALTER TABLE c_allocationline
	DROP CONSTRAINT IF EXISTS c_allocationline_c_invoice_id_fkey;

ALTER TABLE c_allocationline
	DROP CONSTRAINT IF EXISTS c_allocationline_c_order_id_fkey;

ALTER TABLE c_allocationline
	DROP CONSTRAINT IF EXISTS c_allocationline_c_payment_id_fkey;

ALTER TABLE c_allocationline
	DROP CONSTRAINT IF EXISTS c_allocationline_c_allocationhdr_id_fkey;

ALTER TABLE c_allocationline
	DROP CONSTRAINT IF EXISTS c_allocationline_c_bpartner_id_fkey;

ALTER TABLE c_allocationline
	DROP CONSTRAINT IF EXISTS c_allocationline_c_charge_id_fkey;

ALTER TABLE c_allocationline
	DROP CONSTRAINT IF EXISTS c_allocationline_c_cashline_id_fkey;

ALTER TABLE c_bank
	DROP CONSTRAINT IF EXISTS c_bank_c_location_id_fkey;

ALTER TABLE c_bankaccount
	DROP CONSTRAINT IF EXISTS c_bankaccount_c_bank_id_fkey;

ALTER TABLE c_bankaccount
	DROP CONSTRAINT IF EXISTS c_bankaccount_c_currency_id_fkey;

ALTER TABLE c_bankaccount_acct
	DROP CONSTRAINT IF EXISTS c_bankaccount_acct_b_asset_acct_fkey;

ALTER TABLE c_bankaccount_acct
	DROP CONSTRAINT IF EXISTS c_bankaccount_acct_b_expense_acct_fkey;

ALTER TABLE c_bankaccount_acct
	DROP CONSTRAINT IF EXISTS c_bankaccount_acct_b_interestexp_acct_fkey;

ALTER TABLE c_bankaccount_acct
	DROP CONSTRAINT IF EXISTS c_bankaccount_acct_b_interestrev_acct_fkey;

ALTER TABLE c_bankaccount_acct
	DROP CONSTRAINT IF EXISTS c_bankaccount_acct_b_intransit_acct_fkey;

ALTER TABLE c_bankaccount_acct
	DROP CONSTRAINT IF EXISTS c_bankaccount_acct_b_paymentselect_acct_fkey;

ALTER TABLE c_bankaccount_acct
	DROP CONSTRAINT IF EXISTS c_bankaccount_acct_b_revaluationgain_acct_fkey;

ALTER TABLE c_bankaccount_acct
	DROP CONSTRAINT IF EXISTS c_bankaccount_acct_b_revaluationloss_acct_fkey;

ALTER TABLE c_bankaccount_acct
	DROP CONSTRAINT IF EXISTS c_bankaccount_acct_b_settlementgain_acct_fkey;

ALTER TABLE c_bankaccount_acct
	DROP CONSTRAINT IF EXISTS c_bankaccount_acct_b_settlementloss_acct_fkey;

ALTER TABLE c_bankaccount_acct
	DROP CONSTRAINT IF EXISTS c_bankaccount_acct_b_unallocatedcash_acct_fkey;

ALTER TABLE c_bankaccount_acct
	DROP CONSTRAINT IF EXISTS c_bankaccount_acct_b_unidentified_acct_fkey;

ALTER TABLE c_bankaccount_acct
	DROP CONSTRAINT IF EXISTS c_bankaccount_acct_c_bankaccount_id_fkey;

ALTER TABLE c_bankaccount_acct
	DROP CONSTRAINT IF EXISTS c_bankaccount_acct_c_acctschema_id_fkey;

ALTER TABLE c_bp_customer_acct
	DROP CONSTRAINT IF EXISTS c_bp_customer_acct_c_bpartner_id_fkey;

ALTER TABLE c_bp_customer_acct
	DROP CONSTRAINT IF EXISTS c_bp_customer_acct_c_prepayment_acct_fkey;

ALTER TABLE c_bp_customer_acct
	DROP CONSTRAINT IF EXISTS c_bp_customer_acct_c_receivable_acct_fkey;

ALTER TABLE c_bp_customer_acct
	DROP CONSTRAINT IF EXISTS c_bp_customer_acct_c_receivable_services_acct_fkey;

ALTER TABLE c_bp_customer_acct
	DROP CONSTRAINT IF EXISTS c_bp_customer_acct_c_acctschema_id_fkey;

ALTER TABLE c_bp_group
	DROP CONSTRAINT IF EXISTS c_bp_group_m_pricelist_id_fkey;

ALTER TABLE c_bp_group
	DROP CONSTRAINT IF EXISTS c_bp_group_po_pricelist_id_fkey;

ALTER TABLE c_bp_group
	DROP CONSTRAINT IF EXISTS c_bp_group_m_discountschema_id_fkey;

ALTER TABLE c_bp_group
	DROP CONSTRAINT IF EXISTS c_bp_group_po_discountschema_id_fkey;

ALTER TABLE c_bp_group
	DROP CONSTRAINT IF EXISTS c_bp_group_ad_printcolor_id_fkey;

ALTER TABLE c_bp_group
	DROP CONSTRAINT IF EXISTS c_bp_group_c_dunning_id_fkey;

ALTER TABLE c_bp_group_acct
	DROP CONSTRAINT IF EXISTS c_bp_group_acct_c_prepayment_acct_fkey;

ALTER TABLE c_bp_group_acct
	DROP CONSTRAINT IF EXISTS c_bp_group_acct_c_receivable_acct_fkey;

ALTER TABLE c_bp_group_acct
	DROP CONSTRAINT IF EXISTS c_bp_group_acct_c_receivable_services_acct_fkey;

ALTER TABLE c_bp_group_acct
	DROP CONSTRAINT IF EXISTS c_bp_group_acct_notinvoicedreceipts_acct_fkey;

ALTER TABLE c_bp_group_acct
	DROP CONSTRAINT IF EXISTS c_bp_group_acct_notinvoicedreceivables_acct_fkey;

ALTER TABLE c_bp_group_acct
	DROP CONSTRAINT IF EXISTS c_bp_group_acct_notinvoicedrevenue_acct_fkey;

ALTER TABLE c_bp_group_acct
	DROP CONSTRAINT IF EXISTS c_bp_group_acct_paydiscount_exp_acct_fkey;

ALTER TABLE c_bp_group_acct
	DROP CONSTRAINT IF EXISTS c_bp_group_acct_paydiscount_rev_acct_fkey;

ALTER TABLE c_bp_group_acct
	DROP CONSTRAINT IF EXISTS c_bp_group_acct_unearnedrevenue_acct_fkey;

ALTER TABLE c_bp_group_acct
	DROP CONSTRAINT IF EXISTS c_bp_group_acct_v_liability_acct_fkey;

ALTER TABLE c_bp_group_acct
	DROP CONSTRAINT IF EXISTS c_bp_group_acct_v_liability_services_acct_fkey;

ALTER TABLE c_bp_group_acct
	DROP CONSTRAINT IF EXISTS c_bp_group_acct_v_prepayment_acct_fkey;

ALTER TABLE c_bp_group_acct
	DROP CONSTRAINT IF EXISTS c_bp_group_acct_writeoff_acct_fkey;

ALTER TABLE c_bp_group_acct
	DROP CONSTRAINT IF EXISTS c_bp_group_acct_c_bp_group_id_fkey;

ALTER TABLE c_bp_group_acct
	DROP CONSTRAINT IF EXISTS c_bp_group_acct_c_acctschema_id_fkey;

ALTER TABLE c_bp_vendor_acct
	DROP CONSTRAINT IF EXISTS c_bp_vendor_acct_c_bpartner_id_fkey;

ALTER TABLE c_bp_vendor_acct
	DROP CONSTRAINT IF EXISTS c_bp_vendor_acct_v_liability_acct_fkey;

ALTER TABLE c_bp_vendor_acct
	DROP CONSTRAINT IF EXISTS c_bp_vendor_acct_v_liability_services_acct_fkey;

ALTER TABLE c_bp_vendor_acct
	DROP CONSTRAINT IF EXISTS c_bp_vendor_acct_v_prepayment_acct_fkey;

ALTER TABLE c_bp_vendor_acct
	DROP CONSTRAINT IF EXISTS c_bp_vendor_acct_c_acctschema_id_fkey;

ALTER TABLE c_calendar
	DROP CONSTRAINT IF EXISTS c_calendar_ad_client_id_fkey;

ALTER TABLE c_calendar
	DROP CONSTRAINT IF EXISTS c_calendar_ad_org_id_fkey;

ALTER TABLE c_campaign
	DROP CONSTRAINT IF EXISTS c_campaign_c_channel_id_fkey;

ALTER TABLE c_campaign_trl
	DROP CONSTRAINT IF EXISTS c_campaign_trl_c_campaign_trl_uu_key;

ALTER TABLE c_campaign_trl
	DROP CONSTRAINT IF EXISTS c_campaign_trl_createdby_fkey;

ALTER TABLE c_campaign_trl
	DROP CONSTRAINT IF EXISTS c_campaign_trl_updatedby_fkey;

ALTER TABLE c_campaign_trl
	DROP CONSTRAINT IF EXISTS c_campaign_trl_ad_client_id_fkey;

ALTER TABLE c_campaign_trl
	DROP CONSTRAINT IF EXISTS c_campaign_trl_ad_language_fkey;

ALTER TABLE c_campaign_trl
	DROP CONSTRAINT IF EXISTS c_campaign_trl_c_campaign_id_fkey;

ALTER TABLE c_campaign_trl
	DROP CONSTRAINT IF EXISTS c_campaign_trl_ad_org_id_fkey;

ALTER TABLE c_cashbook
	DROP CONSTRAINT IF EXISTS c_cashbook_c_currency_id_fkey;

ALTER TABLE c_cashbook_acct
	DROP CONSTRAINT IF EXISTS c_cashbook_acct_cb_asset_acct_fkey;

ALTER TABLE c_cashbook_acct
	DROP CONSTRAINT IF EXISTS c_cashbook_acct_cb_cashtransfer_acct_fkey;

ALTER TABLE c_cashbook_acct
	DROP CONSTRAINT IF EXISTS c_cashbook_acct_cb_differences_acct_fkey;

ALTER TABLE c_cashbook_acct
	DROP CONSTRAINT IF EXISTS c_cashbook_acct_cb_expense_acct_fkey;

ALTER TABLE c_cashbook_acct
	DROP CONSTRAINT IF EXISTS c_cashbook_acct_cb_receipt_acct_fkey;

ALTER TABLE c_cashbook_acct
	DROP CONSTRAINT IF EXISTS c_cashbook_acct_c_acctschema_id_fkey;

ALTER TABLE c_cashbook_acct
	DROP CONSTRAINT IF EXISTS c_cashbook_acct_c_cashbook_id_fkey;

ALTER TABLE c_channel
	DROP CONSTRAINT IF EXISTS c_channel_ad_printcolor_id_fkey;

ALTER TABLE c_charge
	DROP CONSTRAINT IF EXISTS c_charge_c_bpartner_id_fkey;

ALTER TABLE c_charge
	DROP CONSTRAINT IF EXISTS c_charge_c_chargetype_id_fkey;

ALTER TABLE c_charge
	DROP CONSTRAINT IF EXISTS c_charge_c_taxcategory_id_fkey;

ALTER TABLE c_charge_acct
	DROP CONSTRAINT IF EXISTS c_charge_acct_ch_expense_acct_fkey;

ALTER TABLE c_charge_acct
	DROP CONSTRAINT IF EXISTS c_charge_acct_ch_revenue_acct_fkey;

ALTER TABLE c_charge_acct
	DROP CONSTRAINT IF EXISTS c_charge_acct_c_charge_id_fkey;

ALTER TABLE c_charge_acct
	DROP CONSTRAINT IF EXISTS c_charge_acct_c_acctschema_id_fkey;

ALTER TABLE c_charge_trl
	DROP CONSTRAINT IF EXISTS c_charge_trl_pkey;

ALTER TABLE c_charge_trl
	DROP CONSTRAINT IF EXISTS c_charge_trl_key;
ALTER TABLE c_charge_trl
	ADD CONSTRAINT c_charge_trl_key
		PRIMARY KEY (ad_language, c_charge_id);

ALTER TABLE c_charge_trl
	DROP CONSTRAINT IF EXISTS c_charge_trl_c_charge_id_fkey;

ALTER TABLE c_charge_trl
	DROP CONSTRAINT IF EXISTS c_charge_trl_ad_language_fkey;

ALTER TABLE c_cycle
	DROP CONSTRAINT IF EXISTS c_cycle_c_currency_id_fkey;

ALTER TABLE c_doctype
	DROP CONSTRAINT IF EXISTS c_doctype_definitesequence_id_fkey;

ALTER TABLE c_doctype
	DROP CONSTRAINT IF EXISTS c_doctype_docnosequence_id_fkey;

ALTER TABLE c_doctype
	DROP CONSTRAINT IF EXISTS c_doctype_ad_printformat_id_fkey;

ALTER TABLE c_doctype
	DROP CONSTRAINT IF EXISTS c_doctype_c_doctypedifference_id_fkey;

ALTER TABLE c_doctype
	DROP CONSTRAINT IF EXISTS c_doctype_c_doctypeinvoice_id_fkey;

ALTER TABLE c_doctype
	DROP CONSTRAINT IF EXISTS c_doctype_c_doctypeproforma_id_fkey;

ALTER TABLE c_doctype
	DROP CONSTRAINT IF EXISTS c_doctype_c_doctypeshipment_id_fkey;

ALTER TABLE c_doctype
	DROP CONSTRAINT IF EXISTS c_doctype_gl_category_id_fkey;

ALTER TABLE c_doctype_trl
	DROP CONSTRAINT IF EXISTS c_doctype_trl_c_doctype_id_fkey;

ALTER TABLE c_doctype_trl
	DROP CONSTRAINT IF EXISTS c_doctype_trl_ad_language_fkey;

ALTER TABLE c_paymentterm_trl
	DROP CONSTRAINT IF EXISTS c_paymentterm_trl_c_paymentterm_id_fkey;

ALTER TABLE c_paymentterm_trl
	DROP CONSTRAINT IF EXISTS c_paymentterm_trl_ad_language_fkey;

ALTER TABLE c_element
	DROP CONSTRAINT IF EXISTS c_element_ad_tree_id_fkey;

ALTER TABLE c_element
	DROP CONSTRAINT IF EXISTS c_element_ad_client_id_fkey;

ALTER TABLE c_element
	DROP CONSTRAINT IF EXISTS c_element_ad_org_id_fkey;

ALTER TABLE c_elementvalue
	DROP CONSTRAINT IF EXISTS c_elementvalue_ad_client_id_fkey;

ALTER TABLE c_elementvalue
	DROP CONSTRAINT IF EXISTS c_elementvalue_c_bankaccount_id_fkey;

ALTER TABLE c_elementvalue
	DROP CONSTRAINT IF EXISTS c_elementvalue_c_element_id_fkey;

ALTER TABLE c_elementvalue
	DROP CONSTRAINT IF EXISTS c_elementvalue_c_currency_id_fkey;

ALTER TABLE c_elementvalue
	DROP CONSTRAINT IF EXISTS c_elementvalue_ad_org_id_fkey;

ALTER TABLE c_elementvalue_trl
	DROP CONSTRAINT IF EXISTS c_elementvalue_trl_c_elementvalue_id_fkey;

ALTER TABLE c_elementvalue_trl
	DROP CONSTRAINT IF EXISTS c_elementvalue_trl_ad_language_fkey;

ALTER TABLE c_invoicetax
	DROP CONSTRAINT IF EXISTS c_invoicetax_c_invoice_id_fkey;

ALTER TABLE c_invoicetax
	DROP CONSTRAINT IF EXISTS c_invoicetax_c_tax_id_fkey;

ALTER TABLE c_invoicetax
	DROP CONSTRAINT IF EXISTS c_invoicetax_c_taxprovider_id_fkey;

ALTER TABLE c_tax
	DROP CONSTRAINT IF EXISTS c_tax_c_region_id_fkey;

ALTER TABLE c_tax
	DROP CONSTRAINT IF EXISTS c_tax_to_region_id_fkey;

ALTER TABLE c_tax
	DROP CONSTRAINT IF EXISTS c_tax_c_country_id_fkey;

ALTER TABLE c_tax
	DROP CONSTRAINT IF EXISTS c_tax_to_country_id_fkey;

ALTER TABLE c_tax
	DROP CONSTRAINT IF EXISTS c_tax_parent_tax_id_fkey;

ALTER TABLE c_tax
	DROP CONSTRAINT IF EXISTS c_tax_c_taxcategory_id_fkey;

ALTER TABLE c_tax
	DROP CONSTRAINT IF EXISTS c_tax_ad_rule_id_fkey;

ALTER TABLE c_tax
	DROP CONSTRAINT IF EXISTS c_tax_c_countrygroupfrom_id_fkey;

ALTER TABLE c_tax
	DROP CONSTRAINT IF EXISTS c_tax_c_countrygroupto_id_fkey;

ALTER TABLE c_tax
	DROP CONSTRAINT IF EXISTS c_tax_c_taxprovider_id_fkey;

ALTER TABLE c_tax_trl
	DROP CONSTRAINT IF EXISTS c_tax_trl_c_tax_id_fkey;

ALTER TABLE c_tax_trl
	DROP CONSTRAINT IF EXISTS c_tax_trl_ad_language_fkey;

ALTER TABLE m_product_trl
	DROP CONSTRAINT IF EXISTS m_product_trl_m_product_id_fkey;

ALTER TABLE m_product_trl
	DROP CONSTRAINT IF EXISTS m_product_trl_ad_language_fkey;

DROP INDEX IF EXISTS c_ordertax__corder_id_index;

ALTER TABLE c_ordertax
	DROP CONSTRAINT IF EXISTS c_ordertax_c_order_id_fkey;

ALTER TABLE c_ordertax
	DROP CONSTRAINT IF EXISTS c_ordertax_c_tax_id_fkey;

ALTER TABLE c_ordertax
	DROP CONSTRAINT IF EXISTS c_ordertax_c_taxprovider_id_fkey;

ALTER TABLE c_period
	DROP CONSTRAINT IF EXISTS c_period_c_year_id_fkey;

ALTER TABLE c_period
	DROP CONSTRAINT IF EXISTS c_period_ad_client_id_fkey;

ALTER TABLE c_period
	DROP CONSTRAINT IF EXISTS c_period_ad_org_id_fkey;

ALTER TABLE c_periodcontrol
	DROP CONSTRAINT IF EXISTS c_periodcontrol_c_period_id_fkey;

ALTER TABLE c_project
	DROP CONSTRAINT IF EXISTS c_project_c_bpartner_id_fkey;

ALTER TABLE c_project
	DROP CONSTRAINT IF EXISTS c_project_c_bpartnersr_id_fkey;

ALTER TABLE c_project
	DROP CONSTRAINT IF EXISTS c_project_ad_user_id_fkey;

ALTER TABLE c_project
	DROP CONSTRAINT IF EXISTS c_project_salesrep_id_fkey;

ALTER TABLE c_project
	DROP CONSTRAINT IF EXISTS c_project_c_bpartner_location_id_fkey;

ALTER TABLE c_project
	DROP CONSTRAINT IF EXISTS c_project_m_warehouse_id_fkey;

ALTER TABLE c_project
	DROP CONSTRAINT IF EXISTS c_project_m_pricelist_version_id_fkey;

ALTER TABLE c_project
	DROP CONSTRAINT IF EXISTS c_project_ad_client_id_fkey;

ALTER TABLE c_project
	DROP CONSTRAINT IF EXISTS c_project_c_campaign_id_fkey;

ALTER TABLE c_project
	DROP CONSTRAINT IF EXISTS c_project_c_currency_id_fkey;

ALTER TABLE c_project
	DROP CONSTRAINT IF EXISTS c_project_c_paymentterm_id_fkey;

ALTER TABLE c_project
	DROP CONSTRAINT IF EXISTS c_project_c_phase_id_fkey;

ALTER TABLE c_project
	DROP CONSTRAINT IF EXISTS c_project_c_activity_id_fkey;

ALTER TABLE c_project
	DROP CONSTRAINT IF EXISTS c_project_c_projecttype_id_fkey;

ALTER TABLE c_project
	DROP CONSTRAINT IF EXISTS c_project_ad_org_id_fkey;

ALTER TABLE c_project
	DROP CONSTRAINT IF EXISTS c_project_ad_orgtrx_id_fkey;

ALTER TABLE c_salesregion
	DROP CONSTRAINT IF EXISTS c_salesregion_salesrep_id_fkey;

ALTER TABLE c_salesregion_trl
	DROP CONSTRAINT IF EXISTS c_salesregion_trl_c_salesregion_trl_uu_key;

ALTER TABLE c_salesregion_trl
	DROP CONSTRAINT IF EXISTS c_salesregion_trl_createdby_fkey;

ALTER TABLE c_salesregion_trl
	DROP CONSTRAINT IF EXISTS c_salesregion_trl_updatedby_fkey;

ALTER TABLE c_salesregion_trl
	DROP CONSTRAINT IF EXISTS c_salesregion_trl_ad_client_id_fkey;

ALTER TABLE c_salesregion_trl
	DROP CONSTRAINT IF EXISTS c_salesregion_trl_c_salesregion_id_fkey;

ALTER TABLE c_salesregion_trl
	DROP CONSTRAINT IF EXISTS c_salesregion_trl_ad_language_fkey;

ALTER TABLE c_salesregion_trl
	DROP CONSTRAINT IF EXISTS c_salesregion_trl_ad_org_id_fkey;

ALTER TABLE c_tax_acct
	DROP CONSTRAINT IF EXISTS c_tax_acct_t_credit_acct_fkey;

ALTER TABLE c_tax_acct
	DROP CONSTRAINT IF EXISTS c_tax_acct_t_due_acct_fkey;

ALTER TABLE c_tax_acct
	DROP CONSTRAINT IF EXISTS c_tax_acct_t_expense_acct_fkey;

ALTER TABLE c_tax_acct
	DROP CONSTRAINT IF EXISTS c_tax_acct_t_liability_acct_fkey;

ALTER TABLE c_tax_acct
	DROP CONSTRAINT IF EXISTS c_tax_acct_t_receivables_acct_fkey;

ALTER TABLE c_tax_acct
	DROP CONSTRAINT IF EXISTS c_tax_acct_c_acctschema_id_fkey;

ALTER TABLE c_tax_acct
	DROP CONSTRAINT IF EXISTS c_tax_acct_c_tax_id_fkey;

ALTER TABLE c_taxcategory_trl
	DROP CONSTRAINT IF EXISTS c_taxcategory_trl_c_taxcategory_id_fkey;

ALTER TABLE c_taxcategory_trl
	DROP CONSTRAINT IF EXISTS c_taxcategory_trl_ad_language_fkey;

ALTER TABLE c_validcombination
	DROP CONSTRAINT IF EXISTS c_validcombination_c_bpartner_id_fkey;

ALTER TABLE c_validcombination
	DROP CONSTRAINT IF EXISTS c_validcombination_c_locfrom_id_fkey;

ALTER TABLE c_validcombination
	DROP CONSTRAINT IF EXISTS c_validcombination_c_locto_id_fkey;

ALTER TABLE c_validcombination
	DROP CONSTRAINT IF EXISTS c_validcombination_m_product_id_fkey;

ALTER TABLE c_validcombination
	DROP CONSTRAINT IF EXISTS c_validcombination_c_acctschema_id_fkey;

ALTER TABLE c_validcombination
	DROP CONSTRAINT IF EXISTS c_validcombination_ad_client_id_fkey;

ALTER TABLE c_validcombination
	DROP CONSTRAINT IF EXISTS c_validcombination_c_salesregion_id_fkey;

ALTER TABLE c_validcombination
	DROP CONSTRAINT IF EXISTS c_validcombination_c_project_id_fkey;

ALTER TABLE c_validcombination
	DROP CONSTRAINT IF EXISTS c_validcombination_account_id_fkey;

ALTER TABLE c_validcombination
	DROP CONSTRAINT IF EXISTS c_validcombination_user1_id_fkey;

ALTER TABLE c_validcombination
	DROP CONSTRAINT IF EXISTS c_validcombination_user2_id_fkey;

ALTER TABLE c_validcombination
	DROP CONSTRAINT IF EXISTS c_validcombination_c_campaign_id_fkey;

ALTER TABLE c_validcombination
	DROP CONSTRAINT IF EXISTS c_validcombination_c_activity_id_fkey;

ALTER TABLE c_validcombination
	DROP CONSTRAINT IF EXISTS c_validcombination_c_subacct_id_fkey;

ALTER TABLE c_validcombination
	DROP CONSTRAINT IF EXISTS c_validcombination_ad_org_id_fkey;

ALTER TABLE c_validcombination
	DROP CONSTRAINT IF EXISTS c_validcombination_ad_orgtrx_id_fkey;

ALTER TABLE c_year
	DROP CONSTRAINT IF EXISTS c_year_c_calendar_id_fkey;

ALTER TABLE c_year
	DROP CONSTRAINT IF EXISTS c_year_ad_client_id_fkey;

ALTER TABLE c_year
	DROP CONSTRAINT IF EXISTS c_year_ad_org_id_fkey;

DROP INDEX IF EXISTS fact_acct_index;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS fact_acct_a_asset_id_fkey;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS fact_acct_account_id_fkey;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS fact_acct_ad_client_id_fkey;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS fact_acct_ad_org_id_fkey;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS fact_acct_ad_orgtrx_id_fkey;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS fact_acct_ad_table_id_fkey;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS fact_acct_c_acctschema_id_fkey;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS fact_acct_c_activity_id_fkey;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS fact_acct_c_bpartner_id_fkey;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS fact_acct_c_campaign_id_fkey;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS fact_acct_c_currency_id_fkey;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS fact_acct_c_locfrom_id_fkey;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS fact_acct_c_locto_id_fkey;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS fact_acct_c_period_id_fkey;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS fact_acct_c_project_id_fkey;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS fact_acct_c_projectphase_id_fkey;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS fact_acct_c_projecttask_id_fkey;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS fact_acct_c_salesregion_id_fkey;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS fact_acct_c_subacct_id_fkey;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS fact_acct_c_tax_id_fkey;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS fact_acct_c_uom_id_fkey;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS fact_acct_gl_budget_id_fkey;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS fact_acct_gl_category_id_fkey;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS fact_acct_m_locator_id_fkey;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS fact_acct_m_product_id_fkey;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS fact_acct_user1_id_fkey;

ALTER TABLE fact_acct
	DROP CONSTRAINT IF EXISTS fact_acct_user2_id_fkey;

ALTER TABLE gl_category_trl
	DROP CONSTRAINT IF EXISTS gl_category_trl_gl_category_trl_uu_key;

ALTER TABLE gl_category_trl
	DROP CONSTRAINT IF EXISTS gl_category_trl_createdby_fkey;

ALTER TABLE gl_category_trl
	DROP CONSTRAINT IF EXISTS gl_category_trl_updatedby_fkey;

ALTER TABLE gl_category_trl
	DROP CONSTRAINT IF EXISTS gl_category_trl_gl_category_id_fkey;

ALTER TABLE gl_category_trl
	DROP CONSTRAINT IF EXISTS gl_category_trl_ad_client_id_fkey;

ALTER TABLE gl_category_trl
	DROP CONSTRAINT IF EXISTS gl_category_trl_ad_language_fkey;

ALTER TABLE gl_category_trl
	DROP CONSTRAINT IF EXISTS gl_category_trl_ad_org_id_fkey;

ALTER TABLE i_elementvalue
	DROP CONSTRAINT IF EXISTS i_elementvalue_ad_column_id_fkey;

ALTER TABLE i_elementvalue
	DROP CONSTRAINT IF EXISTS i_elementvalue_c_element_id_fkey;

ALTER TABLE i_elementvalue
	DROP CONSTRAINT IF EXISTS i_elementvalue_c_elementvalue_id_fkey;

ALTER TABLE i_elementvalue
	DROP CONSTRAINT IF EXISTS i_elementvalue_parentelementvalue_id_fkey;

ALTER TABLE m_cost
	DROP CONSTRAINT IF EXISTS m_cost_m_attributesetinstance_id_fkey;

ALTER TABLE m_cost
	DROP CONSTRAINT IF EXISTS m_cost_m_product_id_fkey;

ALTER TABLE m_cost
	DROP CONSTRAINT IF EXISTS m_cost_c_acctschema_id_fkey;

ALTER TABLE m_cost
	DROP CONSTRAINT IF EXISTS m_cost_m_costelement_id_fkey;

ALTER TABLE m_cost
	DROP CONSTRAINT IF EXISTS m_cost_m_costtype_id_fkey;

ALTER TABLE m_cost
	DROP CONSTRAINT IF EXISTS m_cost_ad_client_id_fkey;

ALTER TABLE m_cost
	DROP CONSTRAINT IF EXISTS m_cost_ad_org_id_fkey;

ALTER TABLE m_costdetail
	DROP CONSTRAINT IF EXISTS m_costdetail_m_inoutline_id_fkey;

ALTER TABLE m_costdetail
	DROP CONSTRAINT IF EXISTS m_costdetail_c_invoiceline_id_fkey;

ALTER TABLE m_costdetail
	DROP CONSTRAINT IF EXISTS m_costdetail_c_orderline_id_fkey;

ALTER TABLE m_costdetail
	DROP CONSTRAINT IF EXISTS m_costdetail_m_inventoryline_id_fkey;

ALTER TABLE m_costdetail
	DROP CONSTRAINT IF EXISTS m_costdetail_m_attributesetinstance_id_fkey;

ALTER TABLE m_costdetail
	DROP CONSTRAINT IF EXISTS m_costdetail_m_product_id_fkey;

ALTER TABLE m_costdetail
	DROP CONSTRAINT IF EXISTS m_costdetail_c_acctschema_id_fkey;

ALTER TABLE m_costdetail
	DROP CONSTRAINT IF EXISTS m_costdetail_ad_client_id_fkey;

ALTER TABLE m_costdetail
	DROP CONSTRAINT IF EXISTS m_costdetail_m_costelement_id_fkey;

ALTER TABLE m_costdetail
	DROP CONSTRAINT IF EXISTS m_costdetail_ad_org_id_fkey;

ALTER TABLE m_costdetail
	DROP CONSTRAINT IF EXISTS m_costdetail_m_movementline_id_fkey;

ALTER TABLE m_costdetail
	DROP CONSTRAINT IF EXISTS m_costdetail_m_matchinv_id_fkey;

ALTER TABLE m_costdetail
	DROP CONSTRAINT IF EXISTS m_costdetail_c_projectissue_id_fkey;

ALTER TABLE m_costdetail
	DROP CONSTRAINT IF EXISTS m_costdetail_pp_cost_collector_id_fkey;

ALTER TABLE m_costdetail
	DROP CONSTRAINT IF EXISTS m_costdetail_m_productionline_id_fkey;

ALTER TABLE m_costhistory
	DROP CONSTRAINT IF EXISTS m_costhistory_pkey;

ALTER TABLE m_costhistory
	DROP CONSTRAINT IF EXISTS m_costhistory_key;
ALTER TABLE m_costhistory
	ADD CONSTRAINT m_costhistory_key
		PRIMARY KEY (m_costhistory_id);

ALTER TABLE m_costhistory
	DROP CONSTRAINT IF EXISTS m_costhistory_m_costdetail_id_fkey;

ALTER TABLE m_costhistory
	DROP CONSTRAINT IF EXISTS m_costhistory_m_attributesetinstance_id_fkey;

ALTER TABLE m_costhistory
	DROP CONSTRAINT IF EXISTS m_costhistory_m_costelement_id_fkey;

ALTER TABLE m_costhistory
	DROP CONSTRAINT IF EXISTS m_costhistory_m_costtype_id_fkey;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS m_inout_c_order_id_fkey;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS m_inout_c_invoice_id_fkey;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS m_inout_ref_inout_id_fkey;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS m_inout_reversal_id_fkey;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS m_inout_c_bpartner_id_fkey;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS m_inout_dropship_bpartner_id_fkey;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS m_inout_returnbpartner_id_fkey;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS m_inout_c_bpartner_location_id_fkey;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS m_inout_dropship_location_id_fkey;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS m_inout_returnlocation_id_fkey;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS m_inout_ad_user_id_fkey;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS m_inout_dropship_user_id_fkey;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS m_inout_returnuser_id_fkey;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS m_inout_salesrep_id_fkey;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS m_inout_c_doctype_id_fkey;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS m_inout_c_charge_id_fkey;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS m_inout_m_warehouse_id_fkey;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS m_inout_user1_id_fkey;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS m_inout_c_project_id_fkey;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS m_inout_user2_id_fkey;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS m_inout_c_campaign_id_fkey;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS m_inout_c_activity_id_fkey;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS m_inout_m_shipper_id_fkey;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS m_inout_m_rma_id_fkey;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS m_inout_ad_org_id_fkey;

ALTER TABLE m_inout
	DROP CONSTRAINT IF EXISTS m_inout_ad_orgtrx_id_fkey;

ALTER TABLE m_inoutline
	DROP CONSTRAINT IF EXISTS m_inoutline_ref_inoutline_id_fkey;

ALTER TABLE m_inoutline
	DROP CONSTRAINT IF EXISTS m_inoutline_reversalline_id_fkey;

ALTER TABLE m_inoutline
	DROP CONSTRAINT IF EXISTS m_inoutline_c_orderline_id_fkey;

ALTER TABLE m_inoutline
	DROP CONSTRAINT IF EXISTS m_inoutline_m_inout_id_fkey;

ALTER TABLE m_inoutline
	DROP CONSTRAINT IF EXISTS m_inoutline_m_attributesetinstance_id_fkey;

ALTER TABLE m_inoutline
	DROP CONSTRAINT IF EXISTS m_inoutline_m_product_id_fkey;

ALTER TABLE m_inoutline
	DROP CONSTRAINT IF EXISTS m_inoutline_user1_id_fkey;

ALTER TABLE m_inoutline
	DROP CONSTRAINT IF EXISTS m_inoutline_c_charge_id_fkey;

ALTER TABLE m_inoutline
	DROP CONSTRAINT IF EXISTS m_inoutline_user2_id_fkey;

ALTER TABLE m_inoutline
	DROP CONSTRAINT IF EXISTS m_inoutline_m_locator_id_fkey;

ALTER TABLE m_inoutline
	DROP CONSTRAINT IF EXISTS m_inoutline_c_project_id_fkey;

ALTER TABLE m_inoutline
	DROP CONSTRAINT IF EXISTS m_inoutline_c_activity_id_fkey;

ALTER TABLE m_inoutline
	DROP CONSTRAINT IF EXISTS m_inoutline_c_campaign_id_fkey;

ALTER TABLE m_inoutline
	DROP CONSTRAINT IF EXISTS m_inoutline_c_uom_id_fkey;

ALTER TABLE m_inoutline
	DROP CONSTRAINT IF EXISTS m_inoutline_ad_org_id_fkey;

ALTER TABLE m_inoutline
	DROP CONSTRAINT IF EXISTS m_inoutline_ad_orgtrx_id_fkey;

ALTER TABLE m_inoutline
	DROP CONSTRAINT IF EXISTS m_inoutline_m_rmaline_id_fkey;

ALTER TABLE m_inoutline
	DROP CONSTRAINT IF EXISTS m_inoutline_c_projectphase_id_fkey;

ALTER TABLE m_inoutline
	DROP CONSTRAINT IF EXISTS m_inoutline_c_projecttask_id_fkey;

ALTER TABLE m_inoutlinema
	DROP CONSTRAINT IF EXISTS m_inoutlinema_m_inoutline_id_fkey;

ALTER TABLE m_inoutlinema
	DROP CONSTRAINT IF EXISTS m_inoutlinema_m_attributesetinstance_id_fkey;

ALTER TABLE m_matchpo
	DROP CONSTRAINT IF EXISTS m_matchpo_c_orderline_id_fkey;

ALTER TABLE m_matchpo
	DROP CONSTRAINT IF EXISTS m_matchpo_c_invoiceline_id_fkey;

ALTER TABLE m_matchpo
	DROP CONSTRAINT IF EXISTS m_matchpo_m_inoutline_id_fkey;

ALTER TABLE m_matchpo
	DROP CONSTRAINT IF EXISTS m_matchpo_ref_matchpo_id_fkey;

ALTER TABLE m_matchpo
	DROP CONSTRAINT IF EXISTS m_matchpo_reversal_id_fkey;

ALTER TABLE m_matchpo
	DROP CONSTRAINT IF EXISTS m_matchpo_m_attributesetinstance_id_fkey;

ALTER TABLE m_matchpo
	DROP CONSTRAINT IF EXISTS m_matchpo_m_product_id_fkey;

ALTER TABLE m_pricelist
	DROP CONSTRAINT IF EXISTS m_pricelist_basepricelist_id_fkey;

ALTER TABLE m_pricelist
	DROP CONSTRAINT IF EXISTS m_pricelist_c_currency_id_fkey;

ALTER TABLE m_pricelist_trl
	DROP CONSTRAINT IF EXISTS m_pricelist_trl_m_pricelist_trl_uu_key;

ALTER TABLE m_pricelist_trl
	DROP CONSTRAINT IF EXISTS m_pricelist_trl_createdby_fkey;

ALTER TABLE m_pricelist_trl
	DROP CONSTRAINT IF EXISTS m_pricelist_trl_updatedby_fkey;

ALTER TABLE m_pricelist_trl
	DROP CONSTRAINT IF EXISTS m_pricelist_trl_m_pricelist_id_fkey;

ALTER TABLE m_pricelist_trl
	DROP CONSTRAINT IF EXISTS m_pricelist_trl_ad_client_id_fkey;

ALTER TABLE m_pricelist_trl
	DROP CONSTRAINT IF EXISTS m_pricelist_trl_ad_language_fkey;

ALTER TABLE m_pricelist_trl
	DROP CONSTRAINT IF EXISTS m_pricelist_trl_ad_org_id_fkey;

ALTER TABLE m_pricelist_version
	DROP CONSTRAINT IF EXISTS m_pricelist_version_m_pricelist_version_base_id_fkey;

ALTER TABLE m_pricelist_version
	DROP CONSTRAINT IF EXISTS m_pricelist_version_m_pricelist_id_fkey;

ALTER TABLE m_pricelist_version
	DROP CONSTRAINT IF EXISTS m_pricelist_version_m_discountschema_id_fkey;

ALTER TABLE m_pricelist_version_trl
	DROP CONSTRAINT IF EXISTS m_pricelist_version_trl_m_pricelist_version_trl_uu_key;

ALTER TABLE m_pricelist_version_trl
	DROP CONSTRAINT IF EXISTS m_pricelist_version_trl_createdby_fkey;

ALTER TABLE m_pricelist_version_trl
	DROP CONSTRAINT IF EXISTS m_pricelist_version_trl_updatedby_fkey;

ALTER TABLE m_pricelist_version_trl
	DROP CONSTRAINT IF EXISTS m_pricelist_version_trl_m_pricelist_version_id_fkey;

ALTER TABLE m_pricelist_version_trl
	DROP CONSTRAINT IF EXISTS m_pricelist_version_trl_ad_client_id_fkey;

ALTER TABLE m_pricelist_version_trl
	DROP CONSTRAINT IF EXISTS m_pricelist_version_trl_ad_language_fkey;

ALTER TABLE m_pricelist_version_trl
	DROP CONSTRAINT IF EXISTS m_pricelist_version_trl_ad_org_id_fkey;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS m_product_acct_p_asset_acct_fkey;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS m_product_acct_p_averagecostvariance_acct_fkey;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS m_product_acct_p_burden_acct_fkey;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS m_product_acct_p_cogs_acct_fkey;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS m_product_acct_p_costadjustment_acct_fkey;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS m_product_acct_p_costofproduction_acct_fkey;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS m_product_acct_p_expense_acct_fkey;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS m_product_acct_p_floorstock_acct_fkey;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS m_product_acct_p_inventoryclearing_acct_fkey;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS m_product_acct_p_invoicepricevariance_acct_fkey;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS m_product_acct_p_labor_acct_fkey;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS m_product_acct_p_landedcostclearing_acct_fkey;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS m_product_acct_p_methodchangevariance_acct_fkey;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS m_product_acct_p_mixvariance_acct_fkey;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS m_product_acct_p_outsideprocessing_acct_fkey;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS m_product_acct_p_overhead_acct_fkey;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS m_product_acct_p_purchasepricevariance_acct_fkey;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS m_product_acct_p_ratevariance_acct_fkey;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS m_product_acct_p_revenue_acct_fkey;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS m_product_acct_p_scrap_acct_fkey;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS m_product_acct_p_tradediscountgrant_acct_fkey;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS m_product_acct_p_tradediscountrec_acct_fkey;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS m_product_acct_p_usagevariance_acct_fkey;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS m_product_acct_p_wip_acct_fkey;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS m_product_acct_m_product_id_fkey;

ALTER TABLE m_product_acct
	DROP CONSTRAINT IF EXISTS m_product_acct_c_acctschema_id_fkey;

ALTER TABLE m_product_category
	DROP CONSTRAINT IF EXISTS m_product_category_m_product_category_parent_id_fkey;

ALTER TABLE m_product_category
	DROP CONSTRAINT IF EXISTS m_product_category_ad_printcolor_id_fkey;

ALTER TABLE m_product_category
	DROP CONSTRAINT IF EXISTS m_product_category_a_asset_group_id_fkey;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS m_product_category_acct_p_asset_acct_fkey;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS m_product_category_acct_p_averagecostvariance_acct_fkey;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS m_product_category_acct_p_burden_acct_fkey;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS m_product_category_acct_p_cogs_acct_fkey;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS m_product_category_acct_p_costadjustment_acct_fkey;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS m_product_category_acct_p_costofproduction_acct_fkey;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS m_product_category_acct_p_expense_acct_fkey;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS m_product_category_acct_p_floorstock_acct_fkey;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS m_product_category_acct_p_inventoryclearing_acct_fkey;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS m_product_category_acct_p_invoicepricevariance_acct_fkey;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS m_product_category_acct_p_labor_acct_fkey;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS m_product_category_acct_p_landedcostclearing_acct_fkey;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS m_product_category_acct_p_methodchangevariance_acct_fkey;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS m_product_category_acct_p_mixvariance_acct_fkey;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS m_product_category_acct_p_outsideprocessing_acct_fkey;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS m_product_category_acct_p_overhead_acct_fkey;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS m_product_category_acct_p_purchasepricevariance_acct_fkey;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS m_product_category_acct_p_ratevariance_acct_fkey;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS m_product_category_acct_p_revenue_acct_fkey;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS m_product_category_acct_p_scrap_acct_fkey;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS m_product_category_acct_p_tradediscountgrant_acct_fkey;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS m_product_category_acct_p_tradediscountrec_acct_fkey;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS m_product_category_acct_p_usagevariance_acct_fkey;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS m_product_category_acct_p_wip_acct_fkey;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS m_product_category_acct_m_product_category_id_fkey;

ALTER TABLE m_product_category_acct
	DROP CONSTRAINT IF EXISTS m_product_category_acct_c_acctschema_id_fkey;

ALTER TABLE m_product_category_trl
	DROP CONSTRAINT IF EXISTS m_product_category_trl_m_product_category_trl_uu_key;

ALTER TABLE m_product_category_trl
	DROP CONSTRAINT IF EXISTS m_product_category_trl_createdby_fkey;

ALTER TABLE m_product_category_trl
	DROP CONSTRAINT IF EXISTS m_product_category_trl_updatedby_fkey;

ALTER TABLE m_product_category_trl
	DROP CONSTRAINT IF EXISTS m_product_category_trl_m_product_category_id_fkey;

ALTER TABLE m_product_category_trl
	DROP CONSTRAINT IF EXISTS m_product_category_trl_ad_client_id_fkey;

ALTER TABLE m_product_category_trl
	DROP CONSTRAINT IF EXISTS m_product_category_trl_ad_language_fkey;

ALTER TABLE m_product_category_trl
	DROP CONSTRAINT IF EXISTS m_product_category_trl_ad_org_id_fkey;

ALTER TABLE m_productprice
	DROP CONSTRAINT IF EXISTS m_productprice_pkey;

ALTER TABLE m_productprice
	DROP CONSTRAINT IF EXISTS m_productprice_key;
ALTER TABLE m_productprice
	ADD CONSTRAINT m_productprice_key
		PRIMARY KEY (m_productprice_id);

ALTER TABLE m_productprice
	DROP CONSTRAINT IF EXISTS m_productprice_m_pricelist_version_id_m_product_id_key;

ALTER TABLE m_productprice
	DROP CONSTRAINT IF EXISTS m_productprice_m_product_id_fkey;

ALTER TABLE m_productprice
	DROP CONSTRAINT IF EXISTS m_productprice_m_pricelist_version_id_fkey;

ALTER TABLE m_warehouse_acct
	DROP CONSTRAINT IF EXISTS m_warehouse_acct_w_differences_acct_fkey;

ALTER TABLE m_warehouse_acct
	DROP CONSTRAINT IF EXISTS m_warehouse_acct_w_invactualadjust_acct_fkey;

ALTER TABLE m_warehouse_acct
	DROP CONSTRAINT IF EXISTS m_warehouse_acct_w_inventory_acct_fkey;

ALTER TABLE m_warehouse_acct
	DROP CONSTRAINT IF EXISTS m_warehouse_acct_w_revaluation_acct_fkey;

ALTER TABLE m_warehouse_acct
	DROP CONSTRAINT IF EXISTS m_warehouse_acct_m_warehouse_id_fkey;

ALTER TABLE m_warehouse_acct
	DROP CONSTRAINT IF EXISTS m_warehouse_acct_c_acctschema_id_fkey;

ALTER TABLE pa_dashboardpreference
	DROP CONSTRAINT IF EXISTS pa_dashboardpreference_ad_user_id_fkey;

ALTER TABLE pa_dashboardpreference
	DROP CONSTRAINT IF EXISTS pa_dashboardpreference_ad_role_id_fkey;

ALTER TABLE pa_dashboardpreference
	DROP CONSTRAINT IF EXISTS pa_dashboardpreference_pa_dashboardcontent_id_fkey;

DROP INDEX IF EXISTS r_request_clientid_index;

DROP INDEX IF EXISTS r_request_salesrepid_index;

ALTER TABLE r_requestprocessor
	DROP CONSTRAINT IF EXISTS r_requestprocessor_supervisor_id_fkey;

ALTER TABLE r_requestprocessor
	DROP CONSTRAINT IF EXISTS r_requestprocessor_ad_schedule_id_fkey;

ALTER TABLE r_requestprocessor
	DROP CONSTRAINT IF EXISTS r_requestprocessor_r_requesttype_id_fkey;

DROP INDEX IF EXISTS r_requestprocessorlog_index;

ALTER TABLE r_requestprocessorlog
	DROP CONSTRAINT IF EXISTS r_requestprocessorlog_r_requestprocessor_id_fkey;

DROP TABLE tmp_bh_encounter_diagnosis;

DROP TABLE tmp_c_bpartner;

DROP TABLE tmp_c_bpartner_location;

DROP TABLE tmp_c_elementvalue;

DROP TABLE tmp_c_location;

DROP TABLE tmp_m_inventory;

DROP FUNCTION IF EXISTS currencyconvertinvoice(numeric, numeric, numeric, timestamp WITH TIME ZONE);
CREATE FUNCTION currencyconvertinvoice(p_c_invoice_id numeric, p_currency_to_id numeric,
                                       p_amt numeric DEFAULT NULL::numeric,
                                       p_conversiondate timestamp WITH TIME ZONE DEFAULT NULL::timestamp WITH TIME ZONE) RETURNS numeric
	LANGUAGE plpgsql
AS
$$

DECLARE
	v_GrandTotal             NUMERIC;
	v_ConversionType_ID      NUMERIC;
	v_Client_ID              NUMERIC;
	v_Org_ID                 NUMERIC;
	v_Currency_ID            NUMERIC;
	v_CurrencyRate           NUMERIC;
	v_DateAcct               timestamp WITH TIME ZONE;
	v_BaseCurrency_ID        NUMERIC;
	v_IsOverrideCurrencyRate character(1);
BEGIN
	SELECT
		AD_Client_ID,
		AD_Org_ID,
		DateAcct,
		C_Currency_ID,
		C_ConversionType_ID,
		CurrencyRate,
		GrandTotal,
		IsOverrideCurrencyRate
	INTO v_Client_ID, v_Org_ID, v_DateAcct, v_Currency_ID, v_ConversionType_ID, v_CurrencyRate, v_GrandTotal, v_IsOverrideCurrencyRate
	FROM
		C_Invoice
	WHERE
		C_Invoice_ID = p_C_Invoice_ID;

	SELECT
		sc.C_Currency_ID
	INTO v_BaseCurrency_ID
	FROM
		AD_ClientInfo ci
			JOIN C_AcctSchema sc
			ON ci.C_AcctSchema1_ID = sc.C_AcctSchema_ID
	WHERE
		ci.AD_Client_ID = v_Client_ID;

	IF v_BaseCurrency_ID = p_Currency_To_id AND COALESCE(v_CurrencyRate, 0) > 0 AND v_Currency_ID != p_Currency_To_id AND
	   v_IsOverrideCurrencyRate = 'Y' THEN
		RETURN currencyRound(COALESCE(p_Amt, v_GrandTotal) * v_CurrencyRate, p_Currency_To_id, NULL);
	END IF;

	RETURN currencyConvert(COALESCE(p_Amt, v_GrandTotal), v_Currency_ID, p_Currency_To_id,
	                       COALESCE(p_conversionDate, v_DateAcct), v_ConversionType_ID, v_Client_ID, v_Org_ID);
END;

$$;

DROP FUNCTION IF EXISTS currencyconvertpayment(numeric, numeric, numeric, timestamptz);
CREATE FUNCTION currencyconvertpayment(p_c_payment_id numeric, p_currency_to_id numeric,
                                       p_amt numeric DEFAULT NULL::numeric,
                                       p_conversiondate timestamp WITH TIME ZONE DEFAULT NULL::timestamp WITH TIME ZONE) RETURNS numeric
	LANGUAGE plpgsql
AS
$$
DECLARE
	v_PayAmt                 NUMERIC;
	v_ConversionType_ID      NUMERIC;
	v_Client_ID              NUMERIC;
	v_Org_ID                 NUMERIC;
	v_Currency_ID            NUMERIC;
	v_CurrencyRate           NUMERIC;
	v_ConvertedAmt           NUMERIC;
	v_DateAcct               timestamp WITH TIME ZONE;
	v_BaseCurrency_ID        NUMERIC;
	v_IsOverrideCurrencyRate character(1);
BEGIN
	SELECT
		AD_Client_ID,
		AD_Org_ID,
		DateAcct,
		C_Currency_ID,
		C_ConversionType_ID,
		CurrencyRate,
		ConvertedAmt,
		PayAmt,
		IsOverrideCurrencyRate
	INTO v_Client_ID, v_Org_ID, v_DateAcct, v_Currency_ID, v_ConversionType_ID, v_CurrencyRate, v_ConvertedAmt, v_PayAmt, v_IsOverrideCurrencyRate
	FROM
		C_Payment
	WHERE
		C_Payment_ID = p_C_Payment_ID;

	SELECT
		sc.C_Currency_ID
	INTO v_BaseCurrency_ID
	FROM
		AD_ClientInfo ci
			JOIN C_AcctSchema sc
			ON ci.C_AcctSchema1_ID = sc.C_AcctSchema_ID
	WHERE
		ci.AD_Client_ID = v_Client_ID;

	IF v_BaseCurrency_ID = p_Currency_To_id AND COALESCE(v_CurrencyRate, 0) > 0 AND COALESCE(v_ConvertedAmt, 0) != 0 AND
	   v_Currency_ID != p_Currency_To_id AND v_IsOverrideCurrencyRate = 'Y' THEN
		IF p_Amt IS NULL THEN
			RETURN v_ConvertedAmt;
		ELSE
			RETURN currencyRound(p_Amt * v_CurrencyRate, p_Currency_To_id, NULL);
		END IF;
	END IF;

	RETURN currencyConvert(COALESCE(p_Amt, v_PayAmt), v_Currency_ID, p_Currency_To_id,
	                       COALESCE(p_conversionDate, v_DateAcct), v_ConversionType_ID, v_Client_ID, v_Org_ID);
END;
$$;

CREATE OR REPLACE FUNCTION acctbalance(p_account_id numeric, p_amtdr numeric, p_amtcr numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
DECLARE
	v_balance     NUMERIC;
	v_AccountType C_ElementValue.AccountType%TYPE;
	v_AccountSign C_ElementValue.AccountSign%TYPE;

BEGIN
	v_balance := p_AmtDr - p_AmtCr;
	--
	IF (p_Account_ID > 0) THEN
		SELECT
			AccountType,
			AccountSign
		INTO v_AccountType, v_AccountSign
		FROM
			C_ElementValue
		WHERE
			C_ElementValue_ID = p_Account_ID;
		--   DBMS_OUTPUT.PUT_LINE('Type=' || v_AccountType || ' - Sign=' || v_AccountSign);
		--  Natural Account Sign
		IF (v_AccountSign = 'N') THEN
			IF (v_AccountType IN ('A', 'E')) THEN
				v_AccountSign := 'D';
			ELSE
				v_AccountSign := 'C';
			END IF;
			--  DBMS_OUTPUT.PUT_LINE('Type=' || v_AccountType || ' - Sign=' || v_AccountSign);
		END IF;
		--  Debit Balance
		IF (v_AccountSign = 'C') THEN
			v_balance := p_AmtCr - p_AmtDr;
		END IF;
	END IF;
	--
	RETURN v_balance;
EXCEPTION
	WHEN OTHERS THEN
		-- In case Acct not found
		RETURN p_AmtDr - p_AmtCr;

END;

$$;

CREATE OR REPLACE FUNCTION add_months(datetime timestamp WITH TIME ZONE, months numeric) RETURNS date
	IMMUTABLE
	LANGUAGE plpgsql
AS
$$
DECLARE
	duration varchar;
BEGIN
	IF datetime IS NULL OR months IS NULL THEN
		RETURN NULL;
	END IF;
	duration = months || ' month';
	RETURN CAST(datetime + CAST(duration AS interval) AS date);
END;
$$;

CREATE OR REPLACE FUNCTION adddays(inter interval, days numeric) RETURNS integer
	LANGUAGE plpgsql
AS
$$
BEGIN
	RETURN (EXTRACT(EPOCH FROM (inter)) / 86400) + days;
END;
$$;

CREATE OR REPLACE FUNCTION adddays(datetime timestamp WITH TIME ZONE, days numeric) RETURNS date
	IMMUTABLE
	LANGUAGE plpgsql
AS
$$
DECLARE
	duration varchar;
BEGIN
	IF datetime IS NULL OR days IS NULL THEN
		RETURN NULL;
	END IF;
	duration = days || ' day';
	RETURN CAST(DATE_TRUNC('day', datetime) + CAST(duration AS interval) AS date);
END;
$$;

CREATE OR REPLACE FUNCTION altercolumn(tablename name, columnname name, datatype name, nullclause character varying,
                                       defaultclause character varying) RETURNS void
	LANGUAGE plpgsql
AS
$$
DECLARE
	command       text;
	viewtext      text[];
	viewname      name[];
	dropviews     name[];
	i             int;
	j             int;
	v             record;
	sqltype       text;
	sqltype_short text;
	typename      name;
BEGIN
	IF datatype IS NOT NULL THEN
		SELECT
			pg_type.typname,
			FORMAT_TYPE(pg_type.oid, pg_attribute.atttypmod)
		INTO typename, sqltype
		FROM
			pg_class,
			pg_attribute,
			pg_type
		WHERE
			relname = LOWER(tablename)
			AND relkind = 'r'
			AND pg_class.oid = pg_attribute.attrelid
			AND attname = LOWER(columnname)
			AND atttypid = pg_type.oid;
		sqltype_short := sqltype;
		IF typename = 'numeric' THEN
			sqltype_short := REPLACE(sqltype, ',0', '');
		ELSIF STRPOS(sqltype, 'character varying') = 1 THEN
			sqltype_short := REPLACE(sqltype, 'character varying', 'varchar');
		ELSIF sqltype = 'timestamp without time zone' THEN
			sqltype_short := 'timestamp';
		END IF;
		IF LOWER(datatype) <> sqltype AND LOWER(datatype) <> sqltype_short THEN
			i := 0;
			FOR v IN
				WITH RECURSIVE depv(relname, viewoid, depth) AS (
					SELECT DISTINCT
						a.relname,
						a.oid,
						1
					FROM
						pg_class a,
						pg_depend b,
						pg_depend c,
						pg_class d,
						pg_attribute e
					WHERE
						a.oid = b.refobjid
						AND b.objid = c.objid
						AND b.refobjid <> c.refobjid
						AND b.deptype = 'n'
						AND c.refobjid = d.oid
						AND d.relname = LOWER(tablename)
						AND d.relkind = 'r'
						AND d.oid = e.attrelid
						AND e.attname = LOWER(columnname)
						AND c.refobjsubid = e.attnum
						AND a.relkind = 'v'
					UNION ALL
					SELECT DISTINCT
						dependee.relname,
						dependee.oid,
						depv.depth + 1
					FROM
						pg_depend
							JOIN pg_rewrite
							ON pg_depend.objid = pg_rewrite.oid
							JOIN pg_class AS dependee
							ON pg_rewrite.ev_class = dependee.oid
							JOIN pg_class AS dependent
							ON pg_depend.refobjid = dependent.oid
							JOIN pg_attribute
							ON pg_depend.refobjid = pg_attribute.attrelid AND pg_depend.refobjsubid = pg_attribute.attnum AND
							   pg_attribute.attnum > 0
							JOIN depv
							ON dependent.relname = depv.relname
				)
				SELECT
					relname,
					viewoid,
					MAX(depth)
				FROM
					depv
				GROUP BY relname, viewoid
				ORDER BY 3 DESC
				LOOP
					i := i + 1;
					viewtext[i] := PG_GET_VIEWDEF(v.viewoid);
					viewname[i] := v.relname;
				END LOOP;
			IF i > 0 THEN
				BEGIN
					FOR j IN 1 .. i
						LOOP
							command := 'drop view ' || viewname[j];
							RAISE NOTICE 'executing -> %', command;
							EXECUTE command;
							dropviews[j] := viewname[j];
						END LOOP;
				EXCEPTION
					WHEN OTHERS THEN
						i := ARRAY_UPPER(dropviews, 1);
						IF i > 0 THEN
							FOR j IN REVERSE i .. 1
								LOOP
									command := 'create or replace view ' || dropviews[j] || ' as ' || viewtext[j];
									RAISE NOTICE 'executing -> %', 'create view ' || dropviews[j];
									EXECUTE command;
								END LOOP;
						END IF;
						RAISE EXCEPTION 'Failed to recreate dependent view. SQLERRM=%', SQLERRM;
				END;
			END IF;
			command :=
				'alter table ' || LOWER(tablename) || ' alter column ' || LOWER(columnname) || ' type ' || LOWER(datatype);
			RAISE NOTICE 'executing -> %', command;
			EXECUTE command;
			i := ARRAY_UPPER(dropviews, 1);
			IF i > 0 THEN
				FOR j IN REVERSE i .. 1
					LOOP
						command := 'create or replace view ' || dropviews[j] || ' as ' || viewtext[j];
						RAISE NOTICE 'executing -> %', 'create view ' || dropviews[j];
						EXECUTE command;
					END LOOP;
			END IF;
		END IF;
	END IF;

	IF defaultclause IS NOT NULL THEN
		IF LOWER(defaultclause) = 'null' THEN
			command := 'alter table ' || LOWER(tablename) || ' alter column ' || LOWER(columnname) || ' drop default ';
		ELSE
			IF defaultclause ~ '.*[(].*[)].*' OR LOWER(defaultclause) = 'current_timestamp' THEN
				command := 'alter table ' || LOWER(tablename) || ' alter column ' || LOWER(columnname) || ' set default ' ||
				           defaultclause;
			ELSE
				command := 'alter table ' || LOWER(tablename) || ' alter column ' || LOWER(columnname) || ' set default ''' ||
				           defaultclause || '''';
			END IF;
		END IF;
		RAISE NOTICE 'executing -> %', command;
		EXECUTE command;
	END IF;

	IF nullclause IS NOT NULL THEN
		IF LOWER(nullclause) = 'not null' THEN
			command := 'alter table ' || LOWER(tablename) || ' alter column ' || LOWER(columnname) || ' set not null';
			RAISE NOTICE 'executing -> %', command;
			EXECUTE command;
		ELSIF LOWER(nullclause) = 'null' THEN
			command := 'alter table ' || LOWER(tablename) || ' alter column ' || LOWER(columnname) || ' drop not null';
			RAISE NOTICE 'executing -> %', command;
			EXECUTE command;
		END IF;
	END IF;
END;
$$;

CREATE OR REPLACE FUNCTION altercolumn(tablename name, columnname name, datatype name, nullclause character varying,
                                       defaultclause character varying, namespace name) RETURNS void
	LANGUAGE plpgsql
AS
$$
DECLARE
	command       text;
	viewtext      text[];
	viewname      name[];
	dropviews     name[];
	perms         text[];
	privs         text;
	i             int;
	j             int;
	v             record;
	sqltype       text;
	sqltype_short text;
	typename      name;
BEGIN
	IF datatype IS NOT NULL THEN
		SELECT
			pg_type.typname,
			FORMAT_TYPE(pg_type.oid, pg_attribute.atttypmod)
		INTO typename, sqltype
		FROM
			pg_class,
			pg_attribute,
			pg_type,
			pg_namespace
		WHERE
			relname = LOWER(tablename)
			AND relkind = 'r'
			AND pg_class.oid = pg_attribute.attrelid
			AND attname = LOWER(columnname)
			AND atttypid = pg_type.oid
			AND pg_class.relnamespace = pg_namespace.oid
			AND pg_namespace.nspname = LOWER(namespace);
		sqltype_short := sqltype;
		IF typename = 'numeric' THEN
			sqltype_short := REPLACE(sqltype, ',0', '');
		ELSIF STRPOS(sqltype, 'character varying') = 1 THEN
			sqltype_short := REPLACE(sqltype, 'character varying', 'varchar');
		ELSIF sqltype = 'timestamp without time zone' THEN
			sqltype_short := 'timestamp';
		END IF;
		IF LOWER(datatype) <> sqltype AND LOWER(datatype) <> sqltype_short THEN
			i := 0;
			FOR v IN
				WITH RECURSIVE depv(relname, viewoid, depth) AS (
					SELECT DISTINCT
						a.relname,
						a.oid,
						1
					FROM
						pg_class a,
						pg_depend b,
						pg_depend c,
						pg_class d,
						pg_attribute e,
						pg_namespace
					WHERE
						a.oid = b.refobjid
						AND b.objid = c.objid
						AND b.refobjid <> c.refobjid
						AND b.deptype = 'n'
						AND c.refobjid = d.oid
						AND d.relname = LOWER(tablename)
						AND d.relkind = 'r'
						AND d.oid = e.attrelid
						AND e.attname = LOWER(columnname)
						AND c.refobjsubid = e.attnum
						AND a.relkind = 'v'
						AND a.relnamespace = pg_namespace.oid
						AND pg_namespace.nspname = LOWER(namespace)
					UNION ALL
					SELECT DISTINCT
						dependee.relname,
						dependee.oid,
						depv.depth + 1
					FROM
						pg_depend
							JOIN pg_rewrite
							ON pg_depend.objid = pg_rewrite.oid
							JOIN pg_class AS dependee
							ON pg_rewrite.ev_class = dependee.oid
							JOIN pg_class AS dependent
							ON pg_depend.refobjid = dependent.oid
							JOIN pg_attribute
							ON pg_depend.refobjid = pg_attribute.attrelid AND pg_depend.refobjsubid = pg_attribute.attnum AND
							   pg_attribute.attnum > 0
							JOIN depv
							ON dependent.relname = depv.relname
							JOIN pg_namespace
							ON dependee.relnamespace = pg_namespace.oid
					WHERE
						pg_namespace.nspname = LOWER(namespace)
				)
				SELECT
					relname,
					viewoid,
					MAX(depth)
				FROM
					depv
				GROUP BY relname, viewoid
				ORDER BY 3 DESC
				LOOP
					RAISE NOTICE 'view -> % %', v.relname, v.viewoid;
					i := i + 1;
					viewtext[i] := PG_GET_VIEWDEF(v.viewoid);
					viewname[i] := v.relname;
				END LOOP;
			IF i > 0 THEN
				BEGIN
					FOR j IN 1 .. i
						LOOP
							SELECT
								STRING_AGG('grant ' || privilege_type || ' on ' || viewname[j] || ' to ' || grantee, '; ')
							INTO privs
							FROM
								information_schema.role_table_grants
							WHERE
								table_name = viewname[j];
							perms[j] := privs;
							command := 'drop view ' || viewname[j];
							RAISE NOTICE 'executing -> %', command;
							EXECUTE command;
							dropviews[j] := viewname[j];
						END LOOP;
				EXCEPTION
					WHEN OTHERS THEN
						i := ARRAY_UPPER(dropviews, 1);
						IF i > 0 THEN
							FOR j IN REVERSE i .. 1
								LOOP
									command := 'create or replace view ' || dropviews[j] || ' as ' || viewtext[j];
									RAISE NOTICE 'executing -> %', 'create view ' || dropviews[j];
									EXECUTE command;
								END LOOP;
						END IF;
						RAISE EXCEPTION 'Failed to recreate dependent view. SQLERRM=%', SQLERRM;
				END;
			END IF;
			command :=
				'alter table ' || LOWER(tablename) || ' alter column ' || LOWER(columnname) || ' type ' || LOWER(datatype);
			RAISE NOTICE 'executing -> %', command;
			EXECUTE command;
			i := ARRAY_UPPER(dropviews, 1);
			IF i > 0 THEN
				FOR j IN REVERSE i .. 1
					LOOP
						command := 'create or replace view ' || dropviews[j] || ' as ' || viewtext[j];
						RAISE NOTICE 'executing -> %', 'create view ' || dropviews[j];
						EXECUTE command;
						command := perms[j];
						RAISE NOTICE 'executing -> %', 'grant ' || perms[j];
						EXECUTE command;
					END LOOP;
			END IF;
		END IF;
	END IF;

	IF defaultclause IS NOT NULL THEN
		IF LOWER(defaultclause) = 'null' THEN
			command := 'alter table ' || LOWER(tablename) || ' alter column ' || LOWER(columnname) || ' drop default ';
		ELSE
			IF defaultclause ~ '.*[(].*[)].*' OR LOWER(defaultclause) = 'current_timestamp' THEN
				command := 'alter table ' || LOWER(tablename) || ' alter column ' || LOWER(columnname) || ' set default ' ||
				           defaultclause;
			ELSE
				command := 'alter table ' || LOWER(tablename) || ' alter column ' || LOWER(columnname) || ' set default ''' ||
				           defaultclause || '''';
			END IF;
		END IF;
		RAISE NOTICE 'executing -> %', command;
		EXECUTE command;
	END IF;

	IF nullclause IS NOT NULL THEN
		IF LOWER(nullclause) = 'not null' THEN
			command := 'alter table ' || LOWER(tablename) || ' alter column ' || LOWER(columnname) || ' set not null';
			RAISE NOTICE 'executing -> %', command;
			EXECUTE command;
		ELSIF LOWER(nullclause) = 'null' THEN
			command := 'alter table ' || LOWER(tablename) || ' alter column ' || LOWER(columnname) || ' drop not null';
			RAISE NOTICE 'executing -> %', command;
			EXECUTE command;
		END IF;
	END IF;
END;
$$;

CREATE OR REPLACE FUNCTION bompricelimit(product_id numeric, pricelist_version_id numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
DECLARE
	v_Price        NUMERIC;
	v_ProductPrice NUMERIC;
	bom            RECORD;

BEGIN
	--	Try to get price from PriceList directly
	SELECT
		COALESCE(SUM(PriceLimit), 0)
	INTO v_Price
	FROM
		M_ProductPrice
	WHERE
		M_PriceList_Version_ID = PriceList_Version_ID
		AND M_Product_ID = Product_ID;

	--	No Price - Check if BOM
	IF (v_Price = 0) THEN
		FOR bom IN
			SELECT
				b.M_ProductBOM_ID,
				b.BOMQty,
				p.IsBOM
			FROM
				M_Product_BOM b,
				M_Product p
			WHERE
				b.M_ProductBOM_ID = p.M_Product_ID
				AND b.M_Product_ID = Product_ID
				AND b.M_ProductBOM_ID != Product_ID
				AND b.IsActive = 'Y'
			LOOP
				v_ProductPrice := bomPriceLimit(bom.M_ProductBOM_ID, PriceList_Version_ID);
				v_Price := v_Price + (bom.BOMQty * v_ProductPrice);
			END LOOP;
	END IF;
	--
	RETURN v_Price;

END;

$$;

CREATE OR REPLACE FUNCTION bompricelist(product_id numeric, pricelist_version_id numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
DECLARE
	v_Price        NUMERIC;
	v_ProductPrice NUMERIC;
	bom            RECORD;

BEGIN
	--	Try to get price from pricelist directly
	SELECT
		COALESCE(SUM(PriceList), 0)
	INTO v_Price
	FROM
		M_ProductPrice
	WHERE
		M_PriceList_Version_ID = PriceList_Version_ID
		AND M_Product_ID = Product_ID;

	--	No Price - Check if BOM
	IF (v_Price = 0) THEN
		FOR bom IN
			SELECT
				b.M_ProductBOM_ID,
				b.BOMQty,
				p.IsBOM
			FROM
				M_Product_BOM b,
				M_Product p
			WHERE
				b.M_ProductBOM_ID = p.M_Product_ID
				AND b.M_Product_ID = Product_ID
				AND b.M_ProductBOM_ID != Product_ID
				AND b.IsActive = 'Y'
			LOOP
				v_ProductPrice := bomPriceList(bom.M_ProductBOM_ID, PriceList_Version_ID);
				v_Price := v_Price + (bom.BOMQty * v_ProductPrice);
			END LOOP;
	END IF;
	--
	RETURN v_Price;

END;

$$;

CREATE OR REPLACE FUNCTION bompricestd(product_id numeric, pricelist_version_id numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
DECLARE
	v_Price        NUMERIC;
	v_ProductPrice NUMERIC;
	bom            RECORD;

BEGIN
	--	Try to get price from PriceList directly
	SELECT
		COALESCE(SUM(PriceStd), 0)
	INTO v_Price
	FROM
		M_ProductPrice
	WHERE
		M_PriceList_Version_ID = PriceList_Version_ID
		AND M_Product_ID = Product_ID;

	--	No Price - Check if BOM
	IF (v_Price = 0) THEN
		FOR bom IN
			SELECT
				b.M_ProductBOM_ID,
				b.BOMQty,
				p.IsBOM
			FROM
				M_Product_BOM b,
				M_Product p
			WHERE
				b.M_ProductBOM_ID = p.M_Product_ID
				AND b.M_Product_ID = Product_ID
				AND b.M_ProductBOM_ID != Product_ID
				AND b.IsActive = 'Y'
			LOOP
				v_ProductPrice := bomPriceStd(bom.M_ProductBOM_ID, PriceList_Version_ID);
				v_Price := v_Price + (bom.BOMQty * v_ProductPrice);
			END LOOP;
	END IF;
	--
	RETURN v_Price;

END;

$$;

CREATE OR REPLACE FUNCTION bomqtyavailable(product_id numeric, warehouse_id numeric, locator_id numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
BEGIN
	RETURN bomQtyOnHandForReservation(Product_ID, Warehouse_ID, Locator_ID) -
	       bomQtyReserved(Product_ID, Warehouse_ID, Locator_ID);
END;
$$;

CREATE OR REPLACE FUNCTION bomqtyonhand(product_id numeric, warehouse_id numeric, locator_id numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
DECLARE
	myWarehouse_ID numeric;
	v_Quantity     numeric := 99999; --	unlimited
	v_IsBOM        CHAR(1);
	v_IsStocked    CHAR(1);
	v_ProductType  CHAR(1);
	v_ProductQty   numeric;
	v_StdPrecision int;
	bom            record;

BEGIN
	--	Check Parameters
	myWarehouse_ID := Warehouse_ID;
	IF (myWarehouse_ID IS NULL) THEN
		IF (Locator_ID IS NULL) THEN
			RETURN 0;
		ELSE
			SELECT
				SUM(M_Warehouse_ID)
			INTO myWarehouse_ID
			FROM
				M_LOCATOR
			WHERE
				M_Locator_ID = Locator_ID;
		END IF;
	END IF;
	IF (myWarehouse_ID IS NULL) THEN
		RETURN 0;
	END IF;

	--	Check, if product exists and if it is stocked
	BEGIN
		SELECT
			IsBOM,
			ProductType,
			IsStocked
		INTO v_IsBOM, v_ProductType, v_IsStocked
		FROM
			M_PRODUCT
		WHERE
			M_Product_ID = Product_ID;
		--
	EXCEPTION --	not found
		WHEN OTHERS THEN
			RETURN 0;
	END;
	--	Unlimited capacity if no item
	IF (v_IsBOM = 'N' AND (v_ProductType <> 'I' OR v_IsStocked = 'N')) THEN
		RETURN v_Quantity;
		--	Stocked item
	ELSIF (v_IsStocked = 'Y') THEN
		--	Get ProductQty
		SELECT
			COALESCE(SUM(QtyOnHand), 0)
		INTO v_ProductQty
		FROM
			M_Storageonhand s
				JOIN M_Locator l
				ON (s.M_Locator_ID = l.M_Locator_ID)
		WHERE
			s.M_Product_ID = Product_ID
			AND l.M_Warehouse_ID = myWarehouse_ID;
		--
		RETURN v_ProductQty;
	END IF;

	--	Go through BOM
	FOR bom IN --	Get BOM Product info
		SELECT
			b.M_ProductBOM_ID,
			b.BOMQty,
			p.IsBOM,
			p.IsStocked,
			p.ProductType
		FROM
			M_PRODUCT_BOM b,
			M_PRODUCT p
		WHERE
			b.M_ProductBOM_ID = p.M_Product_ID
			AND b.M_Product_ID = product_ID
			AND b.M_ProductBOM_ID != Product_ID
			AND p.IsBOM = 'Y'
			AND p.IsVerified = 'Y'
			AND b.IsActive = 'Y'
		LOOP
			--	Stocked Items "leaf node"
			IF (bom.ProductType = 'I' AND bom.IsStocked = 'Y') THEN
				--	Get v_ProductQty
				SELECT
					COALESCE(SUM(QtyOnHand), 0)
				INTO v_ProductQty
				FROM
					M_Storageonhand s
						JOIN M_Locator l
						ON (s.M_Locator_ID = l.M_Locator_ID)
				WHERE
					s.M_Product_ID = bom.M_ProductBOM_ID
					AND l.M_Warehouse_ID = myWarehouse_ID;
				--	Get Rounding Precision
				SELECT
					COALESCE(MAX(u.StdPrecision), 0)
				INTO v_StdPrecision
				FROM
					C_UOM u,
					M_PRODUCT p
				WHERE
					u.C_UOM_ID = p.C_UOM_ID
					AND p.M_Product_ID = bom.M_ProductBOM_ID;
				--	How much can we make with this product
				v_ProductQty := ROUND(v_ProductQty / bom.BOMQty, v_StdPrecision);
				--	How much can we make overall
				IF (v_ProductQty < v_Quantity) THEN
					v_Quantity := v_ProductQty;
				END IF;
				--	Another BOM
			ELSIF (bom.IsBOM = 'Y') THEN
				v_ProductQty := Bomqtyonhand(bom.M_ProductBOM_ID, myWarehouse_ID, Locator_ID);
				--	How much can we make overall
				IF (v_ProductQty < v_Quantity) THEN
					v_Quantity := v_ProductQty;
				END IF;
			END IF;
		END LOOP; --	BOM

	IF (v_Quantity > 0) THEN
		--	Get Rounding Precision for Product
		SELECT
			COALESCE(MAX(u.StdPrecision), 0)
		INTO v_StdPrecision
		FROM
			C_UOM u,
			M_PRODUCT p
		WHERE
			u.C_UOM_ID = p.C_UOM_ID
			AND p.M_Product_ID = Product_ID;
		--
		RETURN ROUND(v_Quantity, v_StdPrecision);
	END IF;
	RETURN 0;
END;
$$;

CREATE OR REPLACE FUNCTION bomqtyonhandforreservation(product_id numeric, warehouse_id numeric, locator_id numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
DECLARE
	myWarehouse_ID numeric;
	v_Quantity     numeric := 99999; --	unlimited
	v_IsBOM        CHAR(1);
	v_IsStocked    CHAR(1);
	v_ProductType  CHAR(1);
	v_ProductQty   numeric;
	v_StdPrecision int;
	bom            record;

BEGIN
	--	Check Parameters
	myWarehouse_ID := Warehouse_ID;
	IF (myWarehouse_ID IS NULL) THEN
		IF (Locator_ID IS NULL) THEN
			RETURN 0;
		ELSE
			SELECT
				SUM(M_Warehouse_ID)
			INTO myWarehouse_ID
			FROM
				M_LOCATOR
			WHERE
				M_Locator_ID = Locator_ID;
		END IF;
	END IF;
	IF (myWarehouse_ID IS NULL) THEN
		RETURN 0;
	END IF;

	--	Check, if product exists and if it is stocked
	BEGIN
		SELECT
			IsBOM,
			ProductType,
			IsStocked
		INTO v_IsBOM, v_ProductType, v_IsStocked
		FROM
			M_PRODUCT
		WHERE
			M_Product_ID = Product_ID;
		--
	EXCEPTION --	not found
		WHEN OTHERS THEN
			RETURN 0;
	END;
	--	Unlimited capacity if no item
	IF (v_IsBOM = 'N' AND (v_ProductType <> 'I' OR v_IsStocked = 'N')) THEN
		RETURN v_Quantity;
		--	Stocked item
	ELSIF (v_IsStocked = 'Y') THEN
		--	Get ProductQty
		SELECT
			COALESCE(SUM(QtyOnHand), 0)
		INTO v_ProductQty
		FROM
			M_Storageonhand s
				JOIN M_Locator l
				ON (s.M_Locator_ID = l.M_Locator_ID)
				LEFT JOIN M_LocatorType lt
				ON (l.M_LocatorType_ID = lt.M_LocatorType_ID)
		WHERE
			s.M_Product_ID = Product_ID
			AND l.M_Warehouse_ID = myWarehouse_ID
			AND COALESCE(lt.IsAvailableForReservation, 'Y') = 'Y';
		--
		RETURN v_ProductQty;
	END IF;

	--	Go through BOM
	FOR bom IN --	Get BOM Product info
		SELECT
			b.M_ProductBOM_ID,
			b.BOMQty,
			p.IsBOM,
			p.IsStocked,
			p.ProductType
		FROM
			M_PRODUCT_BOM b,
			M_PRODUCT p
		WHERE
			b.M_ProductBOM_ID = p.M_Product_ID
			AND b.M_Product_ID = product_ID
			AND b.M_ProductBOM_ID != Product_ID
			AND p.IsBOM = 'Y'
			AND p.IsVerified = 'Y'
			AND b.IsActive = 'Y'
		LOOP
			--	Stocked Items "leaf node"
			IF (bom.ProductType = 'I' AND bom.IsStocked = 'Y') THEN
				--	Get v_ProductQty
				SELECT
					COALESCE(SUM(QtyOnHand), 0)
				INTO v_ProductQty
				FROM
					M_Storageonhand s
						JOIN M_Locator l
						ON (s.M_Locator_ID = l.M_Locator_ID)
						LEFT JOIN M_LocatorType lt
						ON (l.M_LocatorType_ID = lt.M_LocatorType_ID)
				WHERE
					s.M_Product_ID = bom.M_ProductBOM_ID
					AND l.M_Warehouse_ID = myWarehouse_ID
					AND COALESCE(lt.IsAvailableForReservation, 'Y') = 'Y';
				--	Get Rounding Precision
				SELECT
					COALESCE(MAX(u.StdPrecision), 0)
				INTO v_StdPrecision
				FROM
					C_UOM u,
					M_PRODUCT p
				WHERE
					u.C_UOM_ID = p.C_UOM_ID
					AND p.M_Product_ID = bom.M_ProductBOM_ID;
				--	How much can we make with this product
				v_ProductQty := ROUND(v_ProductQty / bom.BOMQty, v_StdPrecision);
				--	How much can we make overall
				IF (v_ProductQty < v_Quantity) THEN
					v_Quantity := v_ProductQty;
				END IF;
				--	Another BOM
			ELSIF (bom.IsBOM = 'Y') THEN
				v_ProductQty := BOMQtyOnHandForReservation(bom.M_ProductBOM_ID, myWarehouse_ID, Locator_ID);
				--	How much can we make overall
				IF (v_ProductQty < v_Quantity) THEN
					v_Quantity := v_ProductQty;
				END IF;
			END IF;
		END LOOP; --	BOM

	IF (v_Quantity > 0) THEN
		--	Get Rounding Precision for Product
		SELECT
			COALESCE(MAX(u.StdPrecision), 0)
		INTO v_StdPrecision
		FROM
			C_UOM u,
			M_PRODUCT p
		WHERE
			u.C_UOM_ID = p.C_UOM_ID
			AND p.M_Product_ID = Product_ID;
		--
		RETURN ROUND(v_Quantity, v_StdPrecision);
	END IF;
	RETURN 0;
END;
$$;

CREATE OR REPLACE FUNCTION bomqtyordered(p_product_id numeric, p_warehouse_id numeric, p_locator_id numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
DECLARE
	v_Warehouse_ID numeric;
	v_Quantity     numeric := 99999; --	unlimited
	v_IsBOM        CHAR(1);
	v_IsStocked    CHAR(1);
	v_ProductType  CHAR(1);
	v_ProductQty   numeric;
	v_StdPrecision int;
	bom            record;
BEGIN
	--	Check Parameters
	v_Warehouse_ID := p_Warehouse_ID;
	IF (v_Warehouse_ID IS NULL) THEN
		IF (p_Locator_ID IS NULL) THEN
			RETURN 0;
		ELSE
			SELECT
				MAX(M_Warehouse_ID)
			INTO v_Warehouse_ID
			FROM
				M_LOCATOR
			WHERE
				M_Locator_ID = p_Locator_ID;
		END IF;
	END IF;
	IF (v_Warehouse_ID IS NULL) THEN
		RETURN 0;
	END IF;

	--	Check, if product exists and if it is stocked
	BEGIN
		SELECT
			IsBOM,
			ProductType,
			IsStocked
		INTO v_IsBOM, v_ProductType, v_IsStocked
		FROM
			M_PRODUCT
		WHERE
			M_Product_ID = p_Product_ID;
		--
	EXCEPTION --	not found
		WHEN OTHERS THEN
			RETURN 0;
	END;

	--	No reservation for non-stocked
	IF (v_IsBOM = 'N' AND (v_ProductType <> 'I' OR v_IsStocked = 'N')) THEN
		RETURN 0;
		--	Stocked item
	ELSIF (v_IsStocked = 'Y') THEN
		--	Get ProductQty
		SELECT
			COALESCE(SUM(Qty), 0)
		INTO v_ProductQty
		FROM
			M_StorageReservation
		WHERE
			M_Product_ID = p_Product_ID
			AND M_Warehouse_ID = v_Warehouse_ID
			AND IsSOTrx = 'N'
			AND IsActive = 'Y';
		--
		RETURN v_ProductQty;
	END IF;

	--	Go though BOM
	FOR bom IN
		--	Get BOM Product info
		SELECT
			b.M_ProductBOM_ID,
			b.BOMQty,
			p.IsBOM,
			p.IsStocked,
			p.ProductType
		FROM
			M_PRODUCT_BOM b,
			M_PRODUCT p
		WHERE
			b.M_ProductBOM_ID = p.M_Product_ID
			AND b.M_Product_ID = p_Product_ID
			AND b.M_ProductBOM_ID != p_Product_ID
			AND p.IsBOM = 'Y'
			AND p.IsVerified = 'Y'
			AND b.IsActive = 'Y'
		LOOP
			--	Stocked Items "leaf node"
			IF (bom.ProductType = 'I' AND bom.IsStocked = 'Y') THEN
				--	Get ProductQty
				SELECT
					COALESCE(SUM(Qty), 0)
				INTO v_ProductQty
				FROM
					M_StorageReservation
				WHERE
					M_Product_ID = p_Product_ID
					AND M_Warehouse_ID = v_Warehouse_ID
					AND IsSOTrx = 'N'
					AND IsActive = 'Y';
				--	Get Rounding Precision
				SELECT
					COALESCE(MAX(u.StdPrecision), 0)
				INTO v_StdPrecision
				FROM
					C_UOM u,
					M_PRODUCT p
				WHERE
					u.C_UOM_ID = p.C_UOM_ID
					AND p.M_Product_ID = bom.M_ProductBOM_ID;
				--	How much can we make with this product
				v_ProductQty := ROUND(v_ProductQty / bom.BOMQty, v_StdPrecision);

				--	How much can we make overall
				IF (v_ProductQty < v_Quantity) THEN
					v_Quantity := v_ProductQty;
				END IF;
				--	Another BOM
			ELSIF (bom.IsBOM = 'Y') THEN
				v_ProductQty := Bomqtyordered(bom.M_ProductBOM_ID, v_Warehouse_ID, p_Locator_ID);
				--	How much can we make overall
				IF (v_ProductQty < v_Quantity) THEN
					v_Quantity := v_ProductQty;
				END IF;
			END IF;
		END LOOP;
	--	BOM

	--	Unlimited (e.g. only services)
	IF (v_Quantity = 99999) THEN
		RETURN 0;
	END IF;

	IF (v_Quantity > 0) THEN
		--	Get Rounding Precision for Product
		SELECT
			COALESCE(MAX(u.StdPrecision), 0)
		INTO v_StdPrecision
		FROM
			C_UOM u,
			M_PRODUCT p
		WHERE
			u.C_UOM_ID = p.C_UOM_ID
			AND p.M_Product_ID = p_Product_ID;
		--
		RETURN ROUND(v_Quantity, v_StdPrecision);
	END IF;
	--
	RETURN 0;
END;
$$;

CREATE OR REPLACE FUNCTION bomqtyreserved(p_product_id numeric, p_warehouse_id numeric, p_locator_id numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
DECLARE
	v_Warehouse_ID numeric;
	v_Quantity     numeric := 99999; --	unlimited
	v_IsBOM        CHAR(1);
	v_IsStocked    CHAR(1);
	v_ProductType  CHAR(1);
	v_ProductQty   numeric;
	v_StdPrecision int;
	bom            record;
BEGIN
	--	Check Parameters
	v_Warehouse_ID := p_Warehouse_ID;
	IF (v_Warehouse_ID IS NULL) THEN
		IF (p_Locator_ID IS NULL) THEN
			RETURN 0;
		ELSE
			SELECT
				MAX(M_Warehouse_ID)
			INTO v_Warehouse_ID
			FROM
				M_LOCATOR
			WHERE
				M_Locator_ID = p_Locator_ID;
		END IF;
	END IF;
	IF (v_Warehouse_ID IS NULL) THEN
		RETURN 0;
	END IF;

	--	Check, if product exists and if it is stocked
	BEGIN
		SELECT
			IsBOM,
			ProductType,
			IsStocked
		INTO v_IsBOM, v_ProductType, v_IsStocked
		FROM
			M_PRODUCT
		WHERE
			M_Product_ID = p_Product_ID;
		--
	EXCEPTION --	not found
		WHEN OTHERS THEN
			RETURN 0;
	END;

	--	No reservation for non-stocked
	IF (v_IsBOM = 'N' AND (v_ProductType <> 'I' OR v_IsStocked = 'N')) THEN
		RETURN 0;
		--	Stocked item
	ELSIF (v_IsStocked = 'Y') THEN
		--	Get ProductQty
		SELECT
			COALESCE(SUM(Qty), 0)
		INTO v_ProductQty
		FROM
			M_StorageReservation
		WHERE
			M_Product_ID = p_Product_ID
			AND M_Warehouse_ID = v_Warehouse_ID
			AND IsSOTrx = 'Y'
			AND IsActive = 'Y';
		--
		RETURN v_ProductQty;
	END IF;

	--	Go though BOM
	FOR bom IN
		--	Get BOM Product info
		SELECT
			b.M_ProductBOM_ID,
			b.BOMQty,
			p.IsBOM,
			p.IsStocked,
			p.ProductType
		FROM
			M_PRODUCT_BOM b,
			M_PRODUCT p
		WHERE
			b.M_ProductBOM_ID = p.M_Product_ID
			AND b.M_Product_ID = p_Product_ID
			AND b.M_ProductBOM_ID != p_Product_ID
			AND p.IsBOM = 'Y'
			AND p.IsVerified = 'Y'
			AND b.IsActive = 'Y'
		LOOP
			--	Stocked Items "leaf node"
			IF (bom.ProductType = 'I' AND bom.IsStocked = 'Y') THEN
				--	Get ProductQty
				SELECT
					COALESCE(SUM(Qty), 0)
				INTO v_ProductQty
				FROM
					M_StorageReservation
				WHERE
					M_Product_ID = bom.M_ProductBOM_ID
					AND M_Warehouse_ID = v_Warehouse_ID
					AND IsSOTrx = 'Y'
					AND IsActive = 'Y';
				--	Get Rounding Precision
				SELECT
					COALESCE(MAX(u.StdPrecision), 0)
				INTO v_StdPrecision
				FROM
					C_UOM u,
					M_PRODUCT p
				WHERE
					u.C_UOM_ID = p.C_UOM_ID
					AND p.M_Product_ID = bom.M_ProductBOM_ID;
				--	How much can we make with this product
				v_ProductQty := ROUND(v_ProductQty / bom.BOMQty, v_StdPrecision);
				--	How much can we make overall
				IF (v_ProductQty < v_Quantity) THEN
					v_Quantity := v_ProductQty;
				END IF;
				--	Another BOM
			ELSIF (bom.IsBOM = 'Y') THEN
				v_ProductQty := Bomqtyreserved(bom.M_ProductBOM_ID, v_Warehouse_ID, p_Locator_ID);
				--	How much can we make overall
				IF (v_ProductQty < v_Quantity) THEN
					v_Quantity := v_ProductQty;
				END IF;
			END IF;
		END LOOP;
	--	BOM

	--	Unlimited (e.g. only services)
	IF (v_Quantity = 99999) THEN
		RETURN 0;
	END IF;

	IF (v_Quantity > 0) THEN
		--	Get Rounding Precision for Product
		SELECT
			COALESCE(MAX(u.StdPrecision), 0)
		INTO v_StdPrecision
		FROM
			C_UOM u,
			M_PRODUCT p
		WHERE
			u.C_UOM_ID = p.C_UOM_ID
			AND p.M_Product_ID = p_Product_ID;
		--
		RETURN ROUND(v_Quantity, v_StdPrecision);
	END IF;
	RETURN 0;
END;
$$;

CREATE OR REPLACE FUNCTION bpartnerremitlocation(p_c_bpartner_id numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$

DECLARE
	v_C_Location_ID NUMERIC := NULL;
	l               RECORD;

BEGIN
	FOR l IN
		SELECT
			IsRemitTo,
			C_Location_ID
		FROM
			C_BPartner_Location
		WHERE
			C_BPartner_ID = p_C_BPartner_ID
			AND IsActive = 'Y'
		ORDER BY IsRemitTo DESC
		LOOP
			IF (v_C_Location_ID IS NULL) THEN
				v_C_Location_ID := l.C_Location_ID;
			END IF;
		END LOOP;
	RETURN v_C_Location_ID;

END;

$$;

CREATE OR REPLACE FUNCTION charat(character varying, integer) RETURNS character varying
	IMMUTABLE
	LANGUAGE plpgsql
AS
$$
BEGIN
	RETURN SUBSTR($1, $2, 1);
END;
$$;

CREATE OR REPLACE FUNCTION currencybase(p_amount numeric, p_curfrom_id numeric, p_convdate timestamp WITH TIME ZONE,
                                        p_client_id numeric, p_org_id numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
/*************************************************************************
 * The contents of this file are subject to the Compiere License.  You may
 * obtain a copy of the License at    http://www.compiere.org/license.html
 * Software is on an  "AS IS" basis,  WITHOUT WARRANTY OF ANY KIND, either
 * express or implied. See the License for details. Code: Compiere ERP+CRM
 * Copyright (C) 1999-2001 Jorg Janke, ComPiere, Inc. All Rights Reserved.
 *
 * converted to postgreSQL by Karsten Thiemann (Schaeffer AG),
 * kthiemann@adempiere.org
 *************************************************************************
 *
 ***
 * Title:	Convert Amount to Base Currency of Client
 * Description:
 *		Get CurrencyTo from Client
 *		Returns NULL, if conversion not found
 *		Standard Rounding
 * Test:
 *		SELECT currencyBase(100,116,null,11,null) FROM AD_System; => 64.72
 ************************************************************************/
DECLARE
	v_CurTo_ID NUMERIC;
BEGIN
	--	Get Currency
	SELECT
		MAX(ac.C_Currency_ID)
	INTO v_CurTo_ID
	FROM
		AD_ClientInfo ci,
		C_AcctSchema ac
	WHERE
		ci.C_AcctSchema1_ID = ac.C_AcctSchema_ID
		AND ci.AD_Client_ID = p_Client_ID;
	--	Same as Currency_Conversion - if currency/rate not found - return 0
	IF (v_CurTo_ID IS NULL) THEN
		RETURN NULL;
	END IF;
	--	Same currency
	IF (p_CurFrom_ID = v_CurTo_ID) THEN
		RETURN p_Amount;
	END IF;

	RETURN currencyConvert(p_Amount, p_CurFrom_ID, v_CurTo_ID, p_ConvDate, NULL, p_Client_ID, p_Org_ID);
END;

$$;

CREATE OR REPLACE FUNCTION currencyconvert(p_amount numeric, p_curfrom_id numeric, p_curto_id numeric,
                                           p_convdate timestamp WITH TIME ZONE, p_conversiontype_id numeric,
                                           p_client_id numeric, p_org_id numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$

/*************************************************************************
 * The contents of this file are subject to the Compiere License.  You may
 * obtain a copy of the License at    http://www.compiere.org/license.html
 * Software is on an  "AS IS" basis,  WITHOUT WARRANTY OF ANY KIND, either
 * express or implied. See the License for details. Code: Compiere ERP+CRM
 * Copyright (C) 1999-2001 Jorg Janke, ComPiere, Inc. All Rights Reserved.
 *
 * converted to postgreSQL by Karsten Thiemann (Schaeffer AG),
 * kthiemann@adempiere.org
 *************************************************************************
 ***
 * Title:	Convert Amount (using IDs)
 * Description:
 *		from CurrencyFrom_ID to CurrencyTo_ID
 *		Returns NULL, if conversion not found
 *		Standard Rounding
 * Test:
 *	SELECT currencyConvert(100,116,100,null,null,null,null) FROM AD_System;  => 64.72
 ************************************************************************/


DECLARE
	v_Rate NUMERIC;

BEGIN
	--	Return Amount
	IF (p_Amount = 0 OR p_CurFrom_ID = p_CurTo_ID) THEN
		RETURN p_Amount;
	END IF;
	--	Return NULL
	IF (p_Amount IS NULL OR p_CurFrom_ID IS NULL OR p_CurTo_ID IS NULL) THEN
		RETURN NULL;
	END IF;

	--	Get Rate
	v_Rate := currencyRate(p_CurFrom_ID, p_CurTo_ID, p_ConvDate, p_ConversionType_ID, p_Client_ID, p_Org_ID);
	IF (v_Rate IS NULL) THEN
		RETURN NULL;
	END IF;

	--	Standard Precision
	RETURN currencyRound(p_Amount * v_Rate, p_CurTo_ID, NULL);

END;

$$;

CREATE OR REPLACE FUNCTION currencyrate(p_curfrom_id numeric, p_curto_id numeric, p_convdate timestamp WITH TIME ZONE,
                                        p_conversiontype_id numeric, p_client_id numeric,
                                        p_org_id numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$

/*************************************************************************
 * The contents of this file are subject to the Compiere License.  You may
 * obtain a copy of the License at    http://www.compiere.org/license.html
 * Software is on an  "AS IS" basis,  WITHOUT WARRANTY OF ANY KIND, either
 * express or implied. See the License for details. Code: Compiere ERP+CRM
 * Copyright (C) 1999-2001 Jorg Janke, ComPiere, Inc. All Rights Reserved.
 *
 * converted to postgreSQL by Karsten Thiemann (Schaeffer AG),
 * kthiemann@adempiere.org
 *************************************************************************
 ***
 * Title:	Return Conversion Rate
 * Description:
 *		from CurrencyFrom_ID to CurrencyTo_ID
 *		Returns NULL, if rate not found
 * Test
 *		SELECT currencyrate(116, 100, null, null, null, null) FROM AD_System;  => .647169
 ************************************************************************/


DECLARE
	--	Currency From variables
	cf_IsEuro           CHAR(1);
	cf_IsEMUMember      CHAR(1);
	cf_EMUEntryDate     timestamp WITH TIME ZONE;
	cf_EMURate          NUMERIC;
	--	Currency To variables
	ct_IsEuro           CHAR(1);
	ct_IsEMUMember      CHAR(1);
	ct_EMUEntryDate     DATE;
	ct_EMURate          NUMERIC;
	--	Triangle
	v_CurrencyFrom      NUMERIC;
	v_CurrencyTo        NUMERIC;
	v_CurrencyEuro      NUMERIC;
	--
	v_ConvDate          timestamp WITH TIME ZONE := NOW();
	v_ConversionType_ID NUMERIC                  := 0;
	v_Rate              NUMERIC;
	c                   RECORD;

BEGIN
	--	No Conversion
	IF (p_CurFrom_ID = p_CurTo_ID) THEN
		RETURN 1;
	END IF;
	--	Default Date Parameter
	IF (p_ConvDate IS NOT NULL) THEN
		v_ConvDate := p_ConvDate; --  SysDate
	END IF;
	--  Default Conversion Type
	IF (p_ConversionType_ID IS NULL OR p_ConversionType_ID = 0) THEN
		BEGIN
			SELECT
				C_ConversionType_ID
			INTO v_ConversionType_ID
			FROM
				C_ConversionType
			WHERE
				IsActive = 'Y'
				AND IsDefault = 'Y'
				AND AD_Client_ID IN (0, p_Client_ID)
			ORDER BY AD_Client_ID DESC
			LIMIT 1;
		EXCEPTION
			WHEN OTHERS THEN
				RAISE NOTICE 'Conversion Type Not Found';
		END;
	ELSE
		v_ConversionType_ID := p_ConversionType_ID;
	END IF;

	--	Get Currency Info
	SELECT
		MAX(IsEuro),
		MAX(IsEMUMember),
		MAX(EMUEntryDate),
		MAX(EMURate)
	INTO cf_IsEuro, cf_IsEMUMember, cf_EMUEntryDate, cf_EMURate
	FROM
		C_Currency
	WHERE
		C_Currency_ID = p_CurFrom_ID;
	-- Not Found
	IF (cf_IsEuro IS NULL) THEN
		RAISE NOTICE 'From Currency Not Found';
		RETURN NULL;
	END IF;
	SELECT
		MAX(IsEuro),
		MAX(IsEMUMember),
		MAX(EMUEntryDate),
		MAX(EMURate)
	INTO ct_IsEuro, ct_IsEMUMember, ct_EMUEntryDate, ct_EMURate
	FROM
		C_Currency
	WHERE
		C_Currency_ID = p_CurTo_ID;
	-- Not Found
	IF (ct_IsEuro IS NULL) THEN
		RAISE NOTICE 'To Currency Not Found';
		RETURN NULL;
	END IF;

	--	Fixed - From Euro to EMU
	IF (cf_IsEuro = 'Y' AND ct_IsEMUMember = 'Y' AND v_ConvDate >= ct_EMUEntryDate) THEN
		RETURN ct_EMURate;
	END IF;

	--	Fixed - From EMU to Euro
	IF (ct_IsEuro = 'Y' AND cf_IsEMUMember = 'Y' AND v_ConvDate >= cf_EMUEntryDate) THEN
		RETURN 1 / cf_EMURate;
	END IF;

	--	Fixed - From EMU to EMU
	IF (cf_IsEMUMember = 'Y' AND cf_IsEMUMember = 'Y'
		AND v_ConvDate >= cf_EMUEntryDate AND v_ConvDate >= ct_EMUEntryDate) THEN
		RETURN ct_EMURate / cf_EMURate;
	END IF;

	--	Flexible Rates
	v_CurrencyFrom := p_CurFrom_ID;
	v_CurrencyTo := p_CurTo_ID;

	-- if EMU Member involved, replace From/To Currency
	IF ((cf_isEMUMember = 'Y' AND v_ConvDate >= cf_EMUEntryDate)
		OR (ct_isEMUMember = 'Y' AND v_ConvDate >= ct_EMUEntryDate)) THEN
		SELECT
			MAX(C_Currency_ID)
		INTO v_CurrencyEuro
		FROM
			C_Currency
		WHERE
			IsEuro = 'Y';
		-- Conversion Rate not Found
		IF (v_CurrencyEuro IS NULL) THEN
			RAISE NOTICE 'Euro Not Found';
			RETURN NULL;
		END IF;
		IF (cf_isEMUMember = 'Y' AND v_ConvDate >= cf_EMUEntryDate) THEN
			v_CurrencyFrom := v_CurrencyEuro;
		ELSE
			v_CurrencyTo := v_CurrencyEuro;
		END IF;
	END IF;

	--	Get Rate

	BEGIN
		FOR c IN SELECT
			         MultiplyRate
		         FROM
			         C_Conversion_Rate
		         WHERE
			         IsActive = 'Y'
			         AND C_Currency_ID = v_CurrencyFrom
			         AND C_Currency_ID_To = v_CurrencyTo
			         AND C_ConversionType_ID = v_ConversionType_ID
			         AND v_ConvDate BETWEEN ValidFrom AND ValidTo
			         AND AD_Client_ID IN (0, p_Client_ID)
			         AND AD_Org_ID IN (0, p_Org_ID)
		         ORDER BY AD_Client_ID DESC, AD_Org_ID DESC, ValidFrom DESC
			LOOP
				v_Rate := c.MultiplyRate;
				EXIT; --	only first
			END LOOP;
	END;
	--	Not found
	IF (v_Rate IS NULL) THEN
		RAISE NOTICE 'Conversion Rate Not Found';
		RETURN NULL;
	END IF;

	--	Currency From was EMU
	IF (cf_isEMUMember = 'Y' AND v_ConvDate >= cf_EMUEntryDate) THEN
		RETURN v_Rate / cf_EMURate;
	END IF;

	--	Currency To was EMU
	IF (ct_isEMUMember = 'Y' AND v_ConvDate >= ct_EMUEntryDate) THEN
		RETURN v_Rate * ct_EMURate;
	END IF;

	RETURN v_Rate;

EXCEPTION
	WHEN OTHERS THEN
		RAISE NOTICE '%', SQLERRM;
		RETURN NULL;


END;

$$;

CREATE OR REPLACE FUNCTION currencyround(p_amount numeric, p_curto_id numeric, p_costing character varying) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$

/*************************************************************************
 * The contents of this file are subject to the Compiere License.  You may
 * obtain a copy of the License at    http://www.compiere.org/license.html
 * Software is on an  "AS IS" basis,  WITHOUT WARRANTY OF ANY KIND, either
 * express or implied. See the License for details. Code: Compiere ERP+CRM
 * Copyright (C) 1999-2001 Jorg Janke, ComPiere, Inc. All Rights Reserved.
 *
 * converted to postgreSQL by Karsten Thiemann (Schaeffer AG),
 * kthiemann@adempiere.org
 *************************************************************************
 ***
 * Title:	Round amount for Traget Currency
 * Description:
 *		Round Amount using Costing or Standard Precision
 *		Returns unmodified amount if currency not found
 * Test:
 *		SELECT currencyRound(currencyConvert(100,116,100,null,null),100,null) FROM AD_System => 64.72
 ************************************************************************/


DECLARE
	v_StdPrecision  int;
	v_CostPrecision int;

BEGIN
	--	Nothing to convert
	IF (p_Amount IS NULL OR p_CurTo_ID IS NULL) THEN
		RETURN p_Amount;
	END IF;

	--	Ger Precision
	SELECT
		MAX(StdPrecision),
		MAX(CostingPrecision)
	INTO v_StdPrecision, v_CostPrecision
	FROM
		C_Currency
	WHERE
		C_Currency_ID = p_CurTo_ID;
	--	Currency Not Found
	IF (v_StdPrecision IS NULL) THEN
		RETURN p_Amount;
	END IF;

	IF (p_Costing = 'Y') THEN
		RETURN ROUND(p_Amount, v_CostPrecision);
	END IF;

	RETURN ROUND(p_Amount, v_StdPrecision);

END;

$$;

CREATE OR REPLACE FUNCTION daysbetween(p_date1 timestamp WITH TIME ZONE, p_date2 timestamp WITH TIME ZONE) RETURNS integer
	IMMUTABLE
	LANGUAGE plpgsql
AS
$$
BEGIN
	RETURN CAST(p_date1 AS DATE) - CAST(p_date2 AS DATE);
END;
$$;

CREATE OR REPLACE FUNCTION documentno(p_pp_mrp_id numeric) RETURNS character varying
	STABLE
	LANGUAGE plpgsql
AS
$$
DECLARE
	v_DocumentNo PP_MRP.Value%TYPE := '';
BEGIN
	-- If NO id return empty string
	IF p_PP_MRP_ID <= 0 THEN
		RETURN '';
	END IF;
	SELECT --ordertype, m_forecast_id, c_order_id, dd_order_id, pp_order_id, m_requisition_id,
		CASE
			WHEN TRIM(mrp.ordertype) = 'FTC' THEN (
				SELECT f.Name FROM M_Forecast f WHERE f.M_Forecast_ID = mrp.M_Forecast_ID
			)
			WHEN TRIM(mrp.ordertype) = 'POO' THEN (
				SELECT co.DocumentNo FROM C_Order co WHERE co.C_Order_ID = mrp.C_Order_ID
			)
			WHEN TRIM(mrp.ordertype) = 'DOO' THEN (
				SELECT dd.DocumentNo FROM DD_Order dd WHERE dd.DD_Order_ID = mrp.DD_Order_ID
			)
			WHEN TRIM(mrp.ordertype) = 'SOO' THEN (
				SELECT co.DocumentNo FROM C_Order co WHERE co.C_Order_ID = mrp.C_Order_ID
			)
			WHEN TRIM(mrp.ordertype) = 'MOP' THEN (
				SELECT po.DocumentNo FROM PP_Order po WHERE po.PP_Order_ID = mrp.PP_Order_ID
			)
			WHEN TRIM(mrp.ordertype) = 'POR' THEN (
				SELECT r.DocumentNo FROM M_Requisition r WHERE r.M_Requisition_ID = mrp.M_Requisition_ID
			)
			END
	INTO v_DocumentNo
	FROM
		pp_mrp mrp
	WHERE
		mrp.pp_mrp_id = p_PP_MRP_ID;
	RETURN v_DocumentNo;
END;
$$;

CREATE OR REPLACE FUNCTION firstof(timestamp WITH TIME ZONE, character varying) RETURNS date
	IMMUTABLE
	LANGUAGE plpgsql
AS
$$
DECLARE
	datepart   VARCHAR;
	datetime   TIMESTAMP WITH TIME ZONE;
	offsetdays INTEGER;
BEGIN
	datepart = $2;
	offsetdays = 0;
	IF $2 IN ('') THEN
		datepart = 'millennium';
	ELSEIF $2 IN ('') THEN
		datepart = 'century';
	ELSEIF $2 IN ('') THEN
		datepart = 'decade';
	ELSEIF $2 IN ('IYYY', 'IY', 'I') THEN
		datepart = 'year';
	ELSEIF $2 IN ('SYYYY', 'YYYY', 'YEAR', 'SYEAR', 'YYY', 'YY', 'Y') THEN
		datepart = 'year';
	ELSEIF $2 IN ('Q') THEN
		datepart = 'quarter';
	ELSEIF $2 IN ('MONTH', 'MON', 'MM', 'RM') THEN
		datepart = 'month';
	ELSEIF $2 IN ('IW') THEN
		datepart = 'week';
	ELSEIF $2 IN ('W') THEN
		datepart = 'week';
	ELSEIF $2 IN ('DDD', 'DD', 'J') THEN
		datepart = 'day';
	ELSEIF $2 IN ('DAY', 'DY', 'D') THEN
		datepart = 'week';
		-- move to sunday to make it compatible with oracle and SQLJ
		offsetdays = -1;
	ELSEIF $2 IN ('HH', 'HH12', 'HH24') THEN
		datepart = 'hour';
	ELSEIF $2 IN ('MI') THEN
		datepart = 'minute';
	ELSEIF $2 IN ('') THEN
		datepart = 'second';
	ELSEIF $2 IN ('') THEN
		datepart = 'milliseconds';
	ELSEIF $2 IN ('') THEN
		datepart = 'microseconds';
	END IF;
	datetime = DATE_TRUNC(datepart, $1);
	RETURN CAST(datetime AS date) + offsetdays;
END;
$$;

CREATE OR REPLACE FUNCTION generate_uuid() RETURNS character
	LANGUAGE plpgsql
AS
$$
BEGIN
	RETURN uuid_generate_v4()::char(36);
END;
$$;

CREATE OR REPLACE FUNCTION get1099bucket(p_cbpartner_id numeric, p_cut_date timestamp WITH TIME ZONE,
                                         p_bucket numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
DECLARE
	tmpvar numeric;
/******************************************************************************
   NAME:       get1099bucket
   PURPOSE:

   REVISIONS:
   Ver        Date        Author           Description
   ---------  ----------  ---------------  ------------------------------------
   1.0        04/01/2008  Carlos Ruiz      1. Created this function.

******************************************************************************/
BEGIN
	SELECT
		SUM((COALESCE(linenetamt, 0) + COALESCE(taxamt, 0))
			* (CASE
				   WHEN docbasetype = 'API' THEN 1
				   WHEN docbasetype = 'APC' THEN -1
				   ELSE 0
				END)
		) -- +API->AP Invoice / -APC->AP Credit Memo
	INTO tmpvar
	FROM
		C_INVOICE i,
		C_INVOICELINE il,
		C_1099BOX b,
		C_DOCTYPE dt
	WHERE
		i.c_invoice_id = il.c_invoice_id
		AND i.issotrx = 'N'
		AND il.c_1099box_id = b.c_1099box_id
		AND i.dateacct BETWEEN TRUNC(p_cut_date, 'YEAR') AND p_cut_date
		AND c_bpartner_id = p_cbpartner_id
		AND b.bucket = p_bucket
		AND i.c_doctype_id = dt.c_doctype_id
		AND i.docstatus IN ('CO', 'CL');

	RETURN tmpvar;
END;
$$;

CREATE OR REPLACE FUNCTION get_sysconfig(sysconfig_name character varying, defaultvalue character varying,
                                         client_id numeric, org_id numeric) RETURNS character varying
	STABLE
	LANGUAGE plpgsql
AS
$$
DECLARE
	v_value ad_sysconfig.value%TYPE;
BEGIN
	BEGIN
		SELECT
			Value
		INTO STRICT v_value
		FROM
			AD_SysConfig
		WHERE
			Name = sysconfig_name
			AND AD_Client_ID IN (0, client_id)
			AND AD_Org_ID IN (0, org_id)
			AND IsActive = 'Y'
		ORDER BY AD_Client_ID DESC, AD_Org_ID DESC
		LIMIT 1;
	EXCEPTION
		WHEN NO_DATA_FOUND THEN
			v_value := defaultvalue;
	END;
	RETURN v_value;
END;
$$;

CREATE OR REPLACE FUNCTION getdate() RETURNS timestamp WITH TIME ZONE
	STABLE
	LANGUAGE plpgsql
AS
$$
BEGIN
	RETURN STATEMENT_TIMESTAMP();
END;
$$;

CREATE OR REPLACE FUNCTION instr(character varying, character varying) RETURNS integer
	IMMUTABLE
	STRICT
	LANGUAGE plpgsql
AS
$$
DECLARE
	pos integer;
BEGIN
	pos := instr($1, $2, 1);
	RETURN pos;
END;
$$;

CREATE OR REPLACE FUNCTION instr(string character varying, string_to_search character varying,
                                 beg_index integer) RETURNS integer
	IMMUTABLE
	STRICT
	LANGUAGE plpgsql
AS
$$
DECLARE
	pos       integer NOT NULL DEFAULT 0;
	temp_str  varchar;
	beg       integer;
	length    integer;
	ss_length integer;
BEGIN
	IF beg_index > 0 THEN
		temp_str := SUBSTRING(string FROM beg_index);
		pos := POSITION(string_to_search IN temp_str);

		IF pos = 0 THEN
			RETURN 0;
		ELSE
			RETURN pos + beg_index - 1;
		END IF;
	ELSE
		ss_length := CHAR_LENGTH(string_to_search);
		length := CHAR_LENGTH(string);
		beg := length + beg_index - ss_length + 2;

		WHILE beg > 0
			LOOP
				temp_str := SUBSTRING(string FROM beg FOR ss_length);
				pos := POSITION(string_to_search IN temp_str);

				IF pos > 0 THEN
					RETURN beg;
				END IF;

				beg := beg - 1;
			END LOOP;

		RETURN 0;
	END IF;
END;
$$;

CREATE OR REPLACE FUNCTION instr(string character varying, string_to_search character varying, beg_index integer,
                                 occur_index integer) RETURNS integer
	IMMUTABLE
	STRICT
	LANGUAGE plpgsql
AS
$$
DECLARE
	pos          integer NOT NULL DEFAULT 0;
	occur_number integer NOT NULL DEFAULT 0;
	temp_str     varchar;
	beg          integer;
	i            integer;
	length       integer;
	ss_length    integer;
BEGIN
	IF beg_index > 0 THEN
		beg := beg_index;
		temp_str := SUBSTRING(string FROM beg_index);

		FOR i IN 1..occur_index
			LOOP
				pos := POSITION(string_to_search IN temp_str);

				IF i = 1 THEN
					beg := beg + pos - 1;
				ELSE
					beg := beg + pos;
				END IF;

				temp_str := SUBSTRING(string FROM beg + 1);
			END LOOP;

		IF pos = 0 THEN
			RETURN 0;
		ELSE
			RETURN beg;
		END IF;
	ELSE
		ss_length := CHAR_LENGTH(string_to_search);
		length := CHAR_LENGTH(string);
		beg := length + beg_index - ss_length + 2;

		WHILE beg > 0
			LOOP
				temp_str := SUBSTRING(string FROM beg FOR ss_length);
				pos := POSITION(string_to_search IN temp_str);

				IF pos > 0 THEN
					occur_number := occur_number + 1;

					IF occur_number = occur_index THEN
						RETURN beg;
					END IF;
				END IF;

				beg := beg - 1;
			END LOOP;

		RETURN 0;
	END IF;
END;
$$;

CREATE OR REPLACE FUNCTION invoicediscount(p_c_invoice_id numeric, p_paydate timestamp WITH TIME ZONE,
                                           p_c_invoicepayschedule_id numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
/*************************************************************************
 * The contents of this file are subject to the Compiere License.  You may
 * obtain a copy of the License at    http://www.compiere.org/license.html
 * Software is on an  "AS IS" basis,  WITHOUT WARRANTY OF ANY KIND, either
 * express or implied. See the License for details. Code: Compiere ERP+CRM
 * Copyright (C) 1999-2001 Jorg Janke, ComPiere, Inc. All Rights Reserved.
 *
 * converted to postgreSQL by Karsten Thiemann (Schaeffer AG),
 * kthiemann@adempiere.org
 *************************************************************************
 ***
 * Title:	Calculate Payment Discount Amount
 * Description:
 *			- Calculate discountable amount (i.e. with or without tax)
 *			- Calculate and return payment discount
 * Test:
 * 		select invoiceDiscount(109, now(), 103) from ad_system; => 0
 ************************************************************************/
DECLARE
	v_Amount             NUMERIC;
	v_IsDiscountLineAmt  CHAR(1);
	v_GrandTotal         NUMERIC;
	v_TotalLines         NUMERIC;
	v_C_PaymentTerm_ID   NUMERIC(10);
	v_C_Currency_ID      NUMERIC(10);
	v_DocDate            timestamp WITH TIME ZONE;
	v_PayDate            timestamp WITH TIME ZONE := NOW();
	v_IsPayScheduleValid CHAR(1);

BEGIN
	SELECT
		ci.IsDiscountLineAmt,
		i.GrandTotal,
		i.TotalLines,
		i.C_PaymentTerm_ID,
		i.DateInvoiced,
		i.IsPayScheduleValid,
		C_Currency_ID
	INTO v_IsDiscountLineAmt, v_GrandTotal, v_TotalLines,
		v_C_PaymentTerm_ID, v_DocDate, v_IsPayScheduleValid, v_C_Currency_ID
	FROM
		AD_ClientInfo ci,
		C_Invoice i
	WHERE
		ci.AD_Client_ID = i.AD_Client_ID
		AND i.C_Invoice_ID = p_C_Invoice_ID;

	--	What Amount is the Discount Base?
	IF (v_IsDiscountLineAmt = 'Y') THEN
		v_Amount := v_TotalLines;
	ELSE
		v_Amount := v_GrandTotal;
	END IF;

	--	Anything to discount?
	IF (v_Amount = 0) THEN
		RETURN 0;
	END IF;
	IF (p_PayDate IS NOT NULL) THEN
		v_PayDate := p_PayDate;
	END IF;

	--  Valid Payment Schedule
	IF (v_IsPayScheduleValid = 'Y' AND p_C_InvoicePaySchedule_ID > 0) THEN
		SELECT
			COALESCE(MAX(DiscountAmt), 0)
		INTO v_Amount
		FROM
			C_InvoicePaySchedule
		WHERE
			C_InvoicePaySchedule_ID = p_C_InvoicePaySchedule_ID
			AND DiscountDate >= v_PayDate;
		--
		RETURN v_Amount;
	END IF;

	--	return discount amount
	RETURN paymentTermDiscount(v_Amount, v_C_Currency_ID, v_C_PaymentTerm_ID, v_DocDate, p_PayDate);

--	Most likely if invoice not found
EXCEPTION
	WHEN OTHERS THEN
		RETURN NULL;
END;

$$;

CREATE OR REPLACE FUNCTION invoiceopen(p_c_invoice_id numeric, p_c_invoicepayschedule_id numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
/*************************************************************************
 * The contents of this file are subject to the Compiere License.  You may
 * obtain a copy of the License at    http://www.compiere.org/license.html
 * Software is on an  "AS IS" basis,  WITHOUT WARRANTY OF ANY KIND, either
 * express or implied. See the License for details. Code: Compiere ERP+CRM
 * Copyright (C) 1999-2001 Jorg Janke, ComPiere, Inc. All Rights Reserved.
 *
 * converted to postgreSQL by Karsten Thiemann (Schaeffer AG),
 * kthiemann@adempiere.org
 *************************************************************************
 ***
 * Title:	Calculate Open Item Amount in Invoice Currency
 * Description:
 *	Add up total amount open for C_Invoice_ID if no split payment.
 *  Grand Total minus Sum of Allocations in Invoice Currency
 *
 *  For Split Payments:
 *  Allocate Payments starting from first schedule.
 *  Cannot be used for IsPaid as mutating
 *
 * Test:
 * 	SELECT C_InvoicePaySchedule_ID, DueAmt FROM C_InvoicePaySchedule WHERE C_Invoice_ID=109 ORDER BY DueDate;
 * 	SELECT invoiceOpen (109, null) FROM AD_System; - converted to default client currency
 * 	SELECT invoiceOpen (109, 11) FROM AD_System; - converted to default client currency
 * 	SELECT invoiceOpen (109, 102) FROM AD_System;
 * 	SELECT invoiceOpen (109, 103) FROM AD_System;
 ************************************************************************/
DECLARE
	v_Currency_ID  NUMERIC(10);
	v_TotalOpenAmt NUMERIC := 0;
	v_PaidAmt      NUMERIC := 0;
	v_Remaining    NUMERIC := 0;
	v_MultiplierAP NUMERIC := 0;
	v_MultiplierCM NUMERIC := 0;
	v_Temp         NUMERIC := 0;
	v_Precision    NUMERIC := 0;
	v_Min          NUMERIC := 0;
	ar             RECORD;
	s              RECORD;

BEGIN
	--	Get Currency
	BEGIN
		SELECT
			MAX(C_Currency_ID),
			SUM(GrandTotal),
			MAX(MultiplierAP),
			MAX(Multiplier)
		INTO v_Currency_ID, v_TotalOpenAmt, v_MultiplierAP, v_MultiplierCM
		FROM
			C_Invoice_v --	corrected for CM / Split Payment
		WHERE
			C_Invoice_ID = p_C_Invoice_ID;
	EXCEPTION --	Invoice in draft form
		WHEN OTHERS THEN
			RAISE NOTICE 'InvoiceOpen - %', SQLERRM;
			RETURN NULL;
	END;

	SELECT
		StdPrecision
	INTO v_Precision
	FROM
		C_Currency
	WHERE
		C_Currency_ID = v_Currency_ID;

	SELECT 1 / 10 ^ v_Precision INTO v_Min;

	--	Calculate Allocated Amount
	FOR ar IN
		SELECT
			a.AD_Client_ID,
			a.AD_Org_ID,
			al.Amount,
			al.DiscountAmt,
			al.WriteOffAmt,
			a.C_Currency_ID,
			a.DateTrx
		FROM
			C_AllocationLine al
				INNER JOIN C_AllocationHdr a
				ON (al.C_AllocationHdr_ID = a.C_AllocationHdr_ID)
		WHERE
			al.C_Invoice_ID = p_C_Invoice_ID
			AND a.IsActive = 'Y'
		LOOP
			v_Temp := ar.Amount + ar.DisCountAmt + ar.WriteOffAmt;
			v_PaidAmt := v_PaidAmt
				-- Allocation
				+ currencyConvert(v_Temp * v_MultiplierAP,
				                  ar.C_Currency_ID, v_Currency_ID, ar.DateTrx, NULL, ar.AD_Client_ID, ar.AD_Org_ID);
			RAISE NOTICE '   PaidAmt=% , Allocation= % * %', v_PaidAmt, v_Temp, v_MultiplierAP;
		END LOOP;

	--  Do we have a Payment Schedule ?
	IF (p_C_InvoicePaySchedule_ID > 0) THEN --   if not valid = lists invoice amount
		v_Remaining := v_PaidAmt;
		FOR s IN
			SELECT
				C_InvoicePaySchedule_ID,
				DueAmt
			FROM
				C_InvoicePaySchedule
			WHERE
				C_Invoice_ID = p_C_Invoice_ID
				AND IsValid = 'Y'
			ORDER BY DueDate
			LOOP
				IF (s.C_InvoicePaySchedule_ID = p_C_InvoicePaySchedule_ID) THEN
					v_TotalOpenAmt := (s.DueAmt * v_MultiplierCM) - v_Remaining;
					IF (s.DueAmt - v_Remaining < 0) THEN
						v_TotalOpenAmt := 0;
					END IF;
				ELSE -- calculate amount, which can be allocated to next schedule
					v_Remaining := v_Remaining - s.DueAmt;
					IF (v_Remaining < 0) THEN
						v_Remaining := 0;
					END IF;
				END IF;
			END LOOP;
	ELSE
		v_TotalOpenAmt := v_TotalOpenAmt - v_PaidAmt;
	END IF;
	--  RAISE NOTICE ''== Total='' || v_TotalOpenAmt;

	--	Ignore Rounding
	IF (v_TotalOpenAmt > -v_Min AND v_TotalOpenAmt < v_Min) THEN
		v_TotalOpenAmt := 0;
	END IF;

	--	Round to currency precision
	v_TotalOpenAmt := ROUND(COALESCE(v_TotalOpenAmt, 0), v_Precision);
	RETURN v_TotalOpenAmt;
END;

$$;

CREATE OR REPLACE FUNCTION invoiceopentodate(p_c_invoice_id numeric, p_c_invoicepayschedule_id numeric,
                                             p_dateacct date) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
DECLARE
	v_Currency_ID   numeric(10);
	v_Precision     NUMERIC := 0;
	v_Min           NUMERIC := 0;
	v_TotalOpenAmt  numeric := 0;
	v_PaidAmt       numeric := 0;
	v_Remaining     numeric := 0;
	v_MultiplierAP  numeric := 0;
	v_MultiplierCM  numeric := 0;
	v_Temp          numeric := 0;
	allocationline  record;
	invoiceschedule record;
BEGIN
	-- Get Currency
	BEGIN
		SELECT
			MAX(C_Currency_ID),
			SUM(GrandTotal),
			MAX(MultiplierAP),
			MAX(Multiplier)
		INTO v_Currency_ID, v_TotalOpenAmt, v_MultiplierAP, v_MultiplierCM
		FROM
			C_Invoice_v -- corrected for CM / Split Payment
		WHERE
			C_Invoice_ID = p_C_Invoice_ID
			AND DateAcct <= p_DateAcct;
	EXCEPTION -- Invoice in draft form
		WHEN OTHERS THEN
			--DBMS_OUTPUT.PUT_LINE('InvoiceOpen - ' || SQLERRM);
			RETURN NULL;
	END;
--  DBMS_OUTPUT.PUT_LINE('== C_Invoice_ID=' || p_C_Invoice_ID || ', Total=' || v_TotalOpenAmt || ', AP=' || v_MultiplierAP || ', CM=' || v_MultiplierCM);

	SELECT
		StdPrecision
	INTO v_Precision
	FROM
		C_Currency
	WHERE
		C_Currency_ID = v_Currency_ID;

	SELECT 1 / 10 ^ v_Precision INTO v_Min;

	-- Calculate Allocated Amount
	FOR allocationline IN
		SELECT
			a.AD_Client_ID,
			a.AD_Org_ID,
			al.Amount,
			al.DiscountAmt,
			al.WriteOffAmt,
			a.C_Currency_ID,
			a.DateTrx
		FROM
			C_ALLOCATIONLINE al
				INNER JOIN C_ALLOCATIONHDR a
				ON (al.C_AllocationHdr_ID = a.C_AllocationHdr_ID)
		WHERE
			al.C_Invoice_ID = p_C_Invoice_ID
			AND a.DateAcct <= p_DateAcct
			AND a.IsActive = 'Y'
		LOOP
			v_Temp := allocationline.Amount + allocationline.DisCountAmt + allocationline.WriteOffAmt;
			v_PaidAmt := v_PaidAmt
				-- Allocation
				+ Currencyconvert(v_Temp * v_MultiplierAP,
				                  allocationline.C_Currency_ID, v_Currency_ID, allocationline.DateTrx, NULL,
				                  allocationline.AD_Client_ID, allocationline.AD_Org_ID);
			--DBMS_OUTPUT.PUT_LINE('   PaidAmt=' || v_PaidAmt || ', Allocation=' || v_Temp || ' * ' || v_MultiplierAP);
		END LOOP;

	--  Do we have a Payment Schedule ?
	IF (p_C_InvoicePaySchedule_ID > 0) THEN --   if not valid = lists invoice amount
		v_Remaining := v_PaidAmt;
		FOR invoiceschedule IN
			SELECT
				C_InvoicePaySchedule_ID,
				DueAmt
			FROM
				C_INVOICEPAYSCHEDULE
			WHERE
				C_Invoice_ID = p_C_Invoice_ID
				AND IsValid = 'Y'
			ORDER BY DueDate
			LOOP
				IF (invoiceschedule.C_InvoicePaySchedule_ID = p_C_InvoicePaySchedule_ID) THEN
					v_TotalOpenAmt := (invoiceschedule.DueAmt * v_MultiplierCM) - v_Remaining;
					IF (invoiceschedule.DueAmt - v_Remaining < 0) THEN
						v_TotalOpenAmt := 0;
					END IF;
					--  DBMS_OUTPUT.PUT_LINE('Sched Total=' || v_TotalOpenAmt || ', Due=' || s.DueAmt || ',Remaining=' || v_Remaining || ',CM=' || v_MultiplierCM);
				ELSE -- calculate amount, which can be allocated to next schedule
					v_Remaining := v_Remaining - invoiceschedule.DueAmt;
					IF (v_Remaining < 0) THEN
						v_Remaining := 0;
					END IF;
					--  DBMS_OUTPUT.PUT_LINE('Remaining=' || v_Remaining);
				END IF;
			END LOOP;
	ELSE
		v_TotalOpenAmt := v_TotalOpenAmt - v_PaidAmt;
	END IF;
	--  DBMS_OUTPUT.PUT_LINE('== Total=' || v_TotalOpenAmt);

	--	Ignore Rounding
	IF (v_TotalOpenAmt > -v_Min AND v_TotalOpenAmt < v_Min) THEN
		v_TotalOpenAmt := 0;
	END IF;

	--	Round to currency precision
	v_TotalOpenAmt := ROUND(COALESCE(v_TotalOpenAmt, 0), v_Precision);

	RETURN v_TotalOpenAmt;
END;
$$;

CREATE OR REPLACE FUNCTION invoiceopentodate(p_c_invoice_id numeric, p_c_invoicepayschedule_id numeric,
                                             p_dateacct timestamp WITH TIME ZONE) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
DECLARE
	v_Currency_ID   numeric(10);
	v_Precision     NUMERIC := 0;
	v_Min           NUMERIC := 0;
	v_TotalOpenAmt  numeric := 0;
	v_PaidAmt       numeric := 0;
	v_Remaining     numeric := 0;
	v_MultiplierAP  numeric := 0;
	v_MultiplierCM  numeric := 0;
	v_Temp          numeric := 0;
	allocationline  record;
	invoiceschedule record;
BEGIN
	-- Get Currency
	BEGIN
		SELECT
			MAX(C_Currency_ID),
			SUM(GrandTotal),
			MAX(MultiplierAP),
			MAX(Multiplier)
		INTO v_Currency_ID, v_TotalOpenAmt, v_MultiplierAP, v_MultiplierCM
		FROM
			C_Invoice_v -- corrected for CM / Split Payment
		WHERE
			C_Invoice_ID = p_C_Invoice_ID
			AND DateAcct <= p_DateAcct;
	EXCEPTION -- Invoice in draft form
		WHEN OTHERS THEN
			--DBMS_OUTPUT.PUT_LINE('InvoiceOpen - ' || SQLERRM);
			RETURN NULL;
	END;
--  DBMS_OUTPUT.PUT_LINE('== C_Invoice_ID=' || p_C_Invoice_ID || ', Total=' || v_TotalOpenAmt || ', AP=' || v_MultiplierAP || ', CM=' || v_MultiplierCM);

	SELECT
		StdPrecision
	INTO v_Precision
	FROM
		C_Currency
	WHERE
		C_Currency_ID = v_Currency_ID;

	SELECT 1 / 10 ^ v_Precision INTO v_Min;

	-- Calculate Allocated Amount
	FOR allocationline IN
		SELECT
			a.AD_Client_ID,
			a.AD_Org_ID,
			al.Amount,
			al.DiscountAmt,
			al.WriteOffAmt,
			a.C_Currency_ID,
			a.DateTrx
		FROM
			C_ALLOCATIONLINE al
				INNER JOIN C_ALLOCATIONHDR a
				ON (al.C_AllocationHdr_ID = a.C_AllocationHdr_ID)
		WHERE
			al.C_Invoice_ID = p_C_Invoice_ID
			AND a.DateAcct <= p_DateAcct
			AND a.IsActive = 'Y'
		LOOP
			v_Temp := allocationline.Amount + allocationline.DisCountAmt + allocationline.WriteOffAmt;
			v_PaidAmt := v_PaidAmt
				-- Allocation
				+ Currencyconvert(v_Temp * v_MultiplierAP,
				                  allocationline.C_Currency_ID, v_Currency_ID, allocationline.DateTrx, NULL,
				                  allocationline.AD_Client_ID, allocationline.AD_Org_ID);
			--DBMS_OUTPUT.PUT_LINE('   PaidAmt=' || v_PaidAmt || ', Allocation=' || v_Temp || ' * ' || v_MultiplierAP);
		END LOOP;

	--  Do we have a Payment Schedule ?
	IF (p_C_InvoicePaySchedule_ID > 0) THEN --   if not valid = lists invoice amount
		v_Remaining := v_PaidAmt;
		FOR invoiceschedule IN
			SELECT
				C_InvoicePaySchedule_ID,
				DueAmt
			FROM
				C_INVOICEPAYSCHEDULE
			WHERE
				C_Invoice_ID = p_C_Invoice_ID
				AND IsValid = 'Y'
			ORDER BY DueDate
			LOOP
				IF (invoiceschedule.C_InvoicePaySchedule_ID = p_C_InvoicePaySchedule_ID) THEN
					v_TotalOpenAmt := (invoiceschedule.DueAmt * v_MultiplierCM) - v_Remaining;
					IF (invoiceschedule.DueAmt - v_Remaining < 0) THEN
						v_TotalOpenAmt := 0;
					END IF;
					--  DBMS_OUTPUT.PUT_LINE('Sched Total=' || v_TotalOpenAmt || ', Due=' || s.DueAmt || ',Remaining=' || v_Remaining || ',CM=' || v_MultiplierCM);
				ELSE -- calculate amount, which can be allocated to next schedule
					v_Remaining := v_Remaining - invoiceschedule.DueAmt;
					IF (v_Remaining < 0) THEN
						v_Remaining := 0;
					END IF;
					--  DBMS_OUTPUT.PUT_LINE('Remaining=' || v_Remaining);
				END IF;
			END LOOP;
	ELSE
		v_TotalOpenAmt := v_TotalOpenAmt - v_PaidAmt;
	END IF;
	--  DBMS_OUTPUT.PUT_LINE('== Total=' || v_TotalOpenAmt);

	--	Ignore Rounding
	IF (v_TotalOpenAmt > -v_Min AND v_TotalOpenAmt < v_Min) THEN
		v_TotalOpenAmt := 0;
	END IF;

	--	Round to currency precision
	v_TotalOpenAmt := ROUND(COALESCE(v_TotalOpenAmt, 0), v_Precision);

	RETURN v_TotalOpenAmt;
END;
$$;

CREATE OR REPLACE FUNCTION invoicepaid(p_c_invoice_id numeric, p_c_currency_id numeric,
                                       p_multiplierap numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
/*************************************************************************
 * The contents of this file are subject to the Compiere License.  You may
 * obtain a copy of the License at    http://www.compiere.org/license.html
 * Software is on an  "AS IS" basis,  WITHOUT WARRANTY OF ANY KIND, either
 * express or implied. See the License for details. Code: Compiere ERP+CRM
 * Copyright (C) 1999-2001 Jorg Janke, ComPiere, Inc. All Rights Reserved.
 *
 * converted to postgreSQL by Karsten Thiemann (Schaeffer AG),
 * kthiemann@adempiere.org
 *************************************************************************
 ***
 * Title:	Calculate Paid/Allocated amount in Currency
 * Description:
 *	Add up total amount paid for for C_Invoice_ID.
 *  Split Payments are ignored.
 *  all allocation amounts  converted to invoice C_Currency_ID
 *	round it to the nearest cent
 *	and adjust for CreditMemos by using C_Invoice_v
 *  and for Payments with the multiplierAP (-1, 1)
 *
 *
 * Test:
    SELECT C_Invoice_ID, IsPaid, IsSOTrx, GrandTotal,
    invoicePaid (C_Invoice_ID, C_Currency_ID, MultiplierAP)
    FROM C_Invoice_v;
 *
 ************************************************************************/
DECLARE
	v_Precision    NUMERIC := 0;
	v_Min          NUMERIC := 0;
	v_MultiplierAP NUMERIC := 1;
	v_PaymentAmt   NUMERIC := 0;
	ar             RECORD;

BEGIN
	SELECT
		StdPrecision
	INTO v_Precision
	FROM
		C_Currency
	WHERE
		C_Currency_ID = p_C_Currency_ID;

	SELECT 1 / 10 ^ v_Precision INTO v_Min;

	--	Default
	IF (p_MultiplierAP IS NOT NULL) THEN
		v_MultiplierAP := p_MultiplierAP;
	END IF;
	--	Calculate Allocated Amount
	FOR ar IN
		SELECT
			a.AD_Client_ID,
			a.AD_Org_ID,
			al.Amount,
			al.DiscountAmt,
			al.WriteOffAmt,
			a.C_Currency_ID,
			a.DateTrx
		FROM
			C_AllocationLine al
				INNER JOIN C_AllocationHdr a
				ON (al.C_AllocationHdr_ID = a.C_AllocationHdr_ID)
		WHERE
			al.C_Invoice_ID = p_C_Invoice_ID
			AND a.IsActive = 'Y'
		LOOP
			v_PaymentAmt := v_PaymentAmt
				+ currencyConvert(ar.Amount + ar.DisCountAmt + ar.WriteOffAmt,
				                  ar.C_Currency_ID, p_C_Currency_ID, ar.DateTrx, NULL, ar.AD_Client_ID, ar.AD_Org_ID);
		END LOOP;

	--	Ignore Rounding
	IF (v_PaymentAmt > -v_Min AND v_PaymentAmt < v_Min) THEN
		v_PaymentAmt := 0;
	END IF;

	--	Round to currency precision
	v_PaymentAmt := ROUND(COALESCE(v_PaymentAmt, 0), v_Precision);

	RETURN v_PaymentAmt * v_MultiplierAP;
END;

$$;

CREATE OR REPLACE FUNCTION invoicepaidtodate(p_c_invoice_id numeric, p_c_currency_id numeric, p_multiplierap numeric,
                                             p_dateacct timestamp WITH TIME ZONE) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
DECLARE
	v_Precision    NUMERIC := 0;
	v_Min          NUMERIC := 0;
	v_MultiplierAP numeric := 1;
	v_PaymentAmt   numeric := 0;
	allocation     record;
BEGIN
	SELECT
		StdPrecision
	INTO v_Precision
	FROM
		C_Currency
	WHERE
		C_Currency_ID = p_C_Currency_ID;

	SELECT 1 / 10 ^ v_Precision INTO v_Min;

	--	Default
	IF (p_MultiplierAP IS NOT NULL) THEN
		v_MultiplierAP := p_MultiplierAP;
	END IF;
	--	Calculate Allocated Amount
	FOR allocation IN
		SELECT
			al.AD_Client_ID,
			al.AD_Org_ID,
			al.Amount,
			al.DiscountAmt,
			al.WriteOffAmt,
			a.C_Currency_ID,
			a.DateTrx
		FROM
			C_ALLOCATIONLINE al
				INNER JOIN C_ALLOCATIONHDR a
				ON (al.C_AllocationHdr_ID = a.C_AllocationHdr_ID)
		WHERE
			al.C_Invoice_ID = p_C_Invoice_ID
			AND a.IsActive = 'Y'
			AND a.DateAcct <= p_DateAcct
		LOOP
			v_PaymentAmt := v_PaymentAmt
				+ Currencyconvert(allocation.Amount + allocation.DisCountAmt + allocation.WriteOffAmt,
				                  allocation.C_Currency_ID, p_C_Currency_ID, allocation.DateTrx, NULL, allocation.AD_Client_ID,
				                  allocation.AD_Org_ID);
		END LOOP;

	--	Ignore Rounding
	IF (v_PaymentAmt > -v_Min AND v_PaymentAmt < v_Min) THEN
		v_PaymentAmt := 0;
	END IF;

	--	Round to currency precision
	v_PaymentAmt := ROUND(COALESCE(v_PaymentAmt, 0), v_Precision);

	RETURN v_PaymentAmt * v_MultiplierAP;
END;
$$;

CREATE OR REPLACE FUNCTION invoicewriteoff(p_c_invoice_id numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
DECLARE
	v_Amount        NUMERIC;
	v_ClientId      C_Invoice.AD_Client_ID%TYPE;
	custom_function AD_SysConfig.Value%TYPE;
	command         VARCHAR(1000);
BEGIN
	SELECT AD_Client_ID INTO v_ClientId FROM C_Invoice WHERE C_Invoice_ID = p_C_Invoice_ID;
	custom_function := get_Sysconfig('PAYSELECTION_CUSTOM_INVOICEWRITEOFF_FUNCTION', '', v_ClientId, 0);
	IF LENGTH(custom_function) > 0
	THEN
		command := 'SELECT ' || custom_function || '(' || p_C_Invoice_ID || ')';
		EXECUTE command INTO v_Amount;
	ELSE
		v_Amount := 0;
	END IF;
	RETURN v_Amount;
END;
$$;

CREATE OR REPLACE FUNCTION ismemberofacctschema(p_ad_client_id numeric, p_ad_org_id numeric,
                                                p_c_acctschema_id numeric) RETURNS boolean
	LANGUAGE plpgsql
AS
$$
DECLARE
	v_ad_org_id numeric;
	v_count     numeric;
BEGIN
	v_ad_org_id = -1;
	v_count = 0;

	SELECT
		COUNT(*)
	INTO v_count
	FROM
		C_AcctSchema c
	WHERE
		C_AcctSchema_ID <> p_C_AcctSchema_ID
		AND AD_OrgOnly_ID = p_AD_Org_ID;


	IF (v_count = 0) THEN
		WITH RECURSIVE tr(ad_org_id) AS (
			SELECT
				tn.node_id
			FROM
				ad_tree t
					JOIN ad_treenode tn
					ON t.ad_tree_id = tn.ad_tree_id
					JOIN ad_org
					ON tn.node_id = ad_org.ad_org_id
					JOIN c_acctschema ca
					ON ad_org.ad_org_id = ca.AD_OrgOnly_ID AND ca.C_AcctSchema_ID = p_C_AcctSchema_ID
			WHERE
				t.treetype = 'OO'
				AND t.ad_client_id = p_AD_Client_ID
				AND ((tn.parent_id = 0 AND ad_org.issummary = 'Y') OR (ad_org.ad_org_id = p_AD_Org_ID))
			UNION
			SELECT
				tn.node_id
			FROM
				ad_tree t
					JOIN ad_treenode tn
					ON t.ad_tree_id = tn.ad_tree_id
					JOIN ad_org
					ON tn.node_id = ad_org.ad_org_id
					JOIN tr
					ON tr.ad_org_id = tn.parent_id
			WHERE
				tn.node_id = p_AD_Org_ID
		)
		SELECT
			ad_org_id
		INTO v_ad_org_id
		FROM
			tr
		WHERE
			ad_org_id = p_ad_org_id;
	END IF;
	RETURN v_ad_org_id = p_ad_org_id;
END;
$$;

CREATE OR REPLACE FUNCTION migr_fix_payment_cashline() RETURNS void
	LANGUAGE plpgsql
AS
$$
DECLARE
	rc RECORD;
	rp RECORD;
BEGIN
	FOR rc IN (
		SELECT
			cl.C_CashLine_ID,
			c.NAME,
			cl.amount,
			cl.C_BankAccount_ID,
			cl.AD_Client_ID
		FROM
			C_CASHLINE cl
				INNER JOIN C_CASH c
				ON (c.C_Cash_ID = cl.C_Cash_ID)
		WHERE
			cl.CashType = 'T'
			AND cl.C_Payment_ID IS NULL
	)
		LOOP
			FOR rp IN (
				SELECT
					c_payment_id
				FROM
					C_PAYMENT p
				WHERE
					p.DocumentNo = rc.NAME
					AND R_PnRef = rc.NAME
					AND PayAmt = -rc.amount
					AND C_BankAccount_ID = rc.C_BankAccount_ID
					AND AD_Client_ID = rc.AD_Client_ID
					AND TrxType = 'X'
					AND TenderType = 'X'
			)
				LOOP
					UPDATE C_CASHLINE
					SET
						C_Payment_ID = rp.C_Payment_ID
					WHERE
						C_CASHLINE_ID = rc.C_CashLine_ID;
				END LOOP;
		END LOOP;
END;
$$;

CREATE OR REPLACE FUNCTION nextbusinessday(p_date timestamp WITH TIME ZONE, p_ad_client_id numeric) RETURNS timestamp WITH TIME ZONE
	STABLE
	LANGUAGE plpgsql
AS
$$
/**
*This file is part of Adempiere ERP Bazaar
*http://www.adempiere.org
*
*Copyright (C) 2007 Teo Sarca
*
*This program is free software; you can redistribute it and/or
*modify it under the terms of the GNU General Public License
*as published by the Free Software Foundation; either version 2
*of the License, or (at your option) any later version.
*
*This program is distributed in the hope that it will be useful,
*but WITHOUT ANY WARRANTY; without even the implied warranty of
*MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
*GNU General Public License for more details.
*
*You should have received a copy of the GNU General Public License
*along with this program; if not, write to the Free Software
*Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.of
*
* Converted to PostgreSQL by Tony Snook,
* tspc@dodo.com.au
*/
DECLARE
	v_nextDate  date    := TRUNC(p_Date);
	v_offset    numeric := 0;
	v_Saturday  numeric := TO_CHAR(TO_DATE('2000-01-01', 'YYYY-MM-DD'), 'D');
	v_Sunday    numeric := (CASE WHEN v_Saturday = 7 THEN 1 ELSE v_Saturday + 1 END);
	v_isHoliday boolean := TRUE;
	v_country   c_country.c_country_id%type;
	nbd         C_NonBusinessDay%ROWTYPE;
BEGIN
	v_isHoliday := TRUE;
	LOOP
		SELECT
			CASE TO_CHAR(v_nextDate, 'D')::numeric
				WHEN v_Saturday THEN 2
				WHEN v_Sunday THEN 1
				ELSE 0
				END
		INTO v_offset;
		v_nextDate := v_nextDate + v_offset::integer;
		v_isHoliday := FALSE;
		SELECT
			COALESCE(MAX(co.c_country_id), 100)
		INTO v_country
		FROM
			ad_client cl
				JOIN ad_language l
				ON cl.ad_language = l.ad_language
				JOIN c_country co
				ON l.countrycode = co.countrycode
		WHERE
			cl.ad_client_id = p_ad_client_id;
		FOR nbd IN SELECT *
		           FROM
			           C_NonBusinessDay
		           WHERE
			           AD_Client_ID = p_AD_Client_ID
			           AND IsActive = 'Y'
			           AND Date1 >= v_nextDate
			           AND COALESCE(C_Country_ID, 0) IN (0, v_country)
		           ORDER BY Date1
			LOOP
				EXIT WHEN v_nextDate <> TRUNC(nbd.Date1);
				v_nextDate := v_nextDate + 1;
				v_isHoliday := TRUE;
			END LOOP;
		EXIT WHEN v_isHoliday = FALSE;
	END LOOP;
	--
	RETURN v_nextDate::timestamp WITH TIME ZONE;
END;
$$;

CREATE OR REPLACE FUNCTION nextid(p_ad_sequence_id integer, p_system character varying,
                                  OUT o_nextid integer) RETURNS integer
	LANGUAGE plpgsql
AS
$$
/*************************************************************************
 * The contents of this file are subject to the Compiere License.  You may
 * obtain a copy of the License at    http://www.compiere.org/license.html
 * Software is on an  "AS IS" basis,  WITHOUT WARRANTY OF ANY KIND, either
 * express or implied. See the License for details. Code: Compiere ERP+CRM
 * Copyright (C) 1999-2005 Jorg Janke, ComPiere, Inc. All Rights Reserved.
 *
 * converted to postgreSQL by Karsten Thiemann (Schaeffer AG),
 * kthiemann@adempiere.org
 *************************************************************************
 ***
 * Title:	Get Next ID - no Commit
 * Description: Returns the next id of the sequence.
 * Test:
 *	select * from nextid((select ad_sequence_id from ad_sequence where name = 'Test')::Integer, 'Y'::Varchar);
 *
 ************************************************************************/
DECLARE
	Isnativeseqon VARCHAR(1);
	tablename     VARCHAR(60);
BEGIN
	IF (p_System = 'Y') THEN
		RAISE NOTICE 'system';
		SELECT
			CurrentNextSys
		INTO o_NextID
		FROM
			AD_Sequence
		WHERE
			AD_Sequence_ID = p_AD_Sequence_ID;
		--
		UPDATE AD_Sequence
		SET
			CurrentNextSys = CurrentNextSys + IncrementNo
		WHERE
			AD_Sequence_ID = p_AD_Sequence_ID;
	ELSE

		Isnativeseqon := get_Sysconfig('SYSTEM_NATIVE_SEQUENCE', 'N', 0, 0);
		IF Isnativeseqon = 'Y' THEN
			SELECT
				Name
			INTO tablename
			FROM
				Ad_Sequence
			WHERE
				Ad_Sequence_Id = P_Ad_Sequence_Id;
			--
			EXECUTE 'SELECT nextval(''' || tablename || '_sq''' || ')' INTO o_NextID;
			--
		ELSE
			SELECT
				CurrentNext
			INTO o_NextID
			FROM
				AD_Sequence
			WHERE
				AD_Sequence_ID = p_AD_Sequence_ID;
			--
			UPDATE AD_Sequence
			SET
				CurrentNext = CurrentNext + IncrementNo
			WHERE
				AD_Sequence_ID = p_AD_Sequence_ID;
		END IF;
	END IF;
	--
EXCEPTION
	WHEN OTHERS THEN
		RAISE NOTICE '%',SQLERRM;
END;

$$;

CREATE OR REPLACE FUNCTION nextidfunc(p_ad_sequence_id integer, p_system character varying) RETURNS integer
	LANGUAGE plpgsql
AS
$$
DECLARE
	o_NextIDFunc INTEGER;
	dummy        INTEGER;
BEGIN
	o_NextIDFunc := nextid(p_AD_Sequence_ID, p_System);
	RETURN o_NextIDFunc;
END;
$$;

CREATE OR REPLACE FUNCTION nvl(anyelement, anyelement) RETURNS anyelement
	IMMUTABLE
	LANGUAGE plpgsql
AS
$$
BEGIN
	RETURN COALESCE($1, $2);
END;
$$;

CREATE OR REPLACE FUNCTION nvl(integer, numeric) RETURNS numeric
	IMMUTABLE
	LANGUAGE plpgsql
AS
$$
BEGIN
	RETURN nvl($1::numeric, $2);
END;
$$;

CREATE OR REPLACE FUNCTION nvl(numeric, integer) RETURNS numeric
	IMMUTABLE
	LANGUAGE plpgsql
AS
$$
BEGIN
	RETURN nvl($1, $2::numeric);
END;
$$;

CREATE OR REPLACE FUNCTION paymentallocated(p_c_payment_id numeric, p_c_currency_id numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
/*************************************************************************
 * The contents of this file are subject to the Compiere License.  You may
 * obtain a copy of the License at    http://www.compiere.org/license.html
 * Software is on an  "AS IS" basis,  WITHOUT WARRANTY OF ANY KIND, either
 * express or implied. See the License for details. Code: Compiere ERP+CRM
 * Copyright (C) 1999-2001 Jorg Janke, ComPiere, Inc. All Rights Reserved.
 *
 * converted to postgreSQL by Karsten Thiemann (Schaeffer AG),
 * kthiemann@adempiere.org
 *************************************************************************
 * Title:	Calculate Allocated Payment Amount in Payment Currency
 * Description:
    --
    SELECT paymentAllocated(C_Payment_ID,C_Currency_ID), PayAmt, IsAllocated
    FROM C_Payment_v
    WHERE C_Payment_ID<1000000;
    --
    UPDATE C_Payment_v
    SET IsAllocated=CASE WHEN paymentAllocated(C_Payment_ID, C_Currency_ID)=PayAmt THEN 'Y' ELSE 'N' END
    WHERE C_Payment_ID>=1000000;

 ************************************************************************/
DECLARE
	v_Precision    NUMERIC := 0;
	v_Min          NUMERIC := 0;
	v_AllocatedAmt NUMERIC := 0;
	v_PayAmt       NUMERIC;
	r              RECORD;
BEGIN
	SELECT
		StdPrecision
	INTO v_Precision
	FROM
		C_Currency
	WHERE
		C_Currency_ID = p_C_Currency_ID;

	SELECT 1 / 10 ^ v_Precision INTO v_Min;

	--  Charge - nothing available
	SELECT INTO v_PayAmt
		MAX(PayAmt)
	FROM
		C_Payment
	WHERE
		C_Payment_ID = p_C_Payment_ID
		AND C_Charge_ID > 0;

	IF (v_PayAmt IS NOT NULL) THEN
		RETURN v_PayAmt;
	END IF;

	--	Calculate Allocated Amount
	FOR r IN
		SELECT
			a.AD_Client_ID,
			a.AD_Org_ID,
			al.Amount,
			a.C_Currency_ID,
			a.DateTrx
		FROM
			C_AllocationLine al
				INNER JOIN C_AllocationHdr a
				ON (al.C_AllocationHdr_ID = a.C_AllocationHdr_ID)
		WHERE
			al.C_Payment_ID = p_C_Payment_ID
			AND a.IsActive = 'Y'
		LOOP
			v_AllocatedAmt := v_AllocatedAmt
				+ currencyConvert(r.Amount, r.C_Currency_ID, p_C_Currency_ID, r.DateTrx, NULL, r.AD_Client_ID, r.AD_Org_ID);
		END LOOP;

	--	Ignore Rounding
	IF (v_AllocatedAmt > -v_Min AND v_AllocatedAmt < v_Min) THEN
		v_AllocatedAmt := 0;
	END IF;

	--	Round to currency precision
	v_AllocatedAmt := ROUND(COALESCE(v_AllocatedAmt, 0), v_Precision);

	RETURN v_AllocatedAmt;
END;

$$;

CREATE OR REPLACE FUNCTION paymentavailable(p_c_payment_id numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
/*************************************************************************
 * The contents of this file are subject to the Compiere License.  You may
 * obtain a copy of the License at    http://www.compiere.org/license.html
 * Software is on an  "AS IS" basis,  WITHOUT WARRANTY OF ANY KIND, either
 * express or implied. See the License for details. Code: Compiere ERP+CRM
 * Copyright (C) 1999-2001 Jorg Janke, ComPiere, Inc. All Rights Reserved.
 *
 * converted to postgreSQL by Karsten Thiemann (Schaeffer AG),
 * kthiemann@adempiere.org
 *************************************************************************
 * Title:	Calculate Available Payment Amount in Payment Currency
 * Description:
 *		similar to C_Invoice_Open
 ************************************************************************/
DECLARE
	v_Currency_ID  NUMERIC(10);
	v_Precision    NUMERIC := 0;
	v_Min          NUMERIC := 0;
	v_AvailableAmt NUMERIC := 0;
	v_IsReceipt    C_Payment.IsReceipt%TYPE;
	v_Amt          NUMERIC := 0;
	r              RECORD;

BEGIN
	--  Charge - fully allocated
	SELECT
		MAX(PayAmt)
	INTO v_Amt
	FROM
		C_Payment
	WHERE
		C_Payment_ID = p_C_Payment_ID
		AND C_Charge_ID > 0;
	IF (v_Amt IS NOT NULL) THEN
		RETURN 0;
	END IF;

	--	Get Currency
	SELECT
		C_Currency_ID,
		PayAmt,
		IsReceipt
	INTO v_Currency_ID, v_AvailableAmt, v_IsReceipt
	FROM
		C_Payment_v -- corrected for AP/AR
	WHERE
		C_Payment_ID = p_C_Payment_ID;
--  DBMS_OUTPUT.PUT_LINE('== C_Payment_ID=' || p_C_Payment_ID || ', PayAmt=' || v_AvailableAmt || ', Receipt=' || v_IsReceipt);

	SELECT
		StdPrecision
	INTO v_Precision
	FROM
		C_Currency
	WHERE
		C_Currency_ID = v_Currency_ID;

	SELECT 1 / 10 ^ v_Precision INTO v_Min;

	--	Calculate Allocated Amount
	FOR r IN
		SELECT
			a.AD_Client_ID,
			a.AD_Org_ID,
			al.Amount,
			a.C_Currency_ID,
			a.DateTrx
		FROM
			C_AllocationLine al
				INNER JOIN C_AllocationHdr a
				ON (al.C_AllocationHdr_ID = a.C_AllocationHdr_ID)
		WHERE
			al.C_Payment_ID = p_C_Payment_ID
			AND a.IsActive = 'Y'
		LOOP
			v_Amt := currencyConvert(r.Amount, r.C_Currency_ID, v_Currency_ID, r.DateTrx, NULL, r.AD_Client_ID, r.AD_Org_ID);
			v_AvailableAmt := v_AvailableAmt - v_Amt;
--      DBMS_OUTPUT.PUT_LINE('  Allocation=' || a.Amount || ' - Available=' || v_AvailableAmt);
		END LOOP;

	--	Ignore Rounding
	IF (v_AvailableAmt > -v_Min AND v_AvailableAmt < v_Min) THEN
		v_AvailableAmt := 0;
	END IF;

	--	Round to currency precision
	v_AvailableAmt := ROUND(COALESCE(v_AvailableAmt, 0), v_Precision);

	RETURN v_AvailableAmt;
END;

$$;

CREATE OR REPLACE FUNCTION paymenttermdiscount(amount numeric, currency_id numeric, paymentterm_id numeric,
                                               docdate timestamp WITH TIME ZONE,
                                               paydate timestamp WITH TIME ZONE) RETURNS numeric
	LANGUAGE plpgsql
AS
$$
/*************************************************************************
 * The contents of this file are subject to the Compiere License.  You may
 * obtain a copy of the License at    http://www.compiere.org/license.html
 * Software is on an  "AS IS" basis,  WITHOUT WARRANTY OF ANY KIND, either
 * express or implied. See the License for details. Code: Compiere ERP+CRM
 * Copyright (C) 1999-2001 Jorg Janke, ComPiere, Inc. All Rights Reserved.
 *
 * converted to postgreSQL by Karsten Thiemann (Schaeffer AG),
 * kthiemann@adempiere.org
 *************************************************************************
 * Title:	Calculate Discount
 * Description:
 *	Calculate the allowable Discount Amount of the Payment Term
 *
 *	Test:	SELECT paymenttermDiscount(110, 103, 106, now(), now()) FROM TEST; => 2.20
 ************************************************************************/

DECLARE
	v_Precision   NUMERIC := 0;
	v_Currency    NUMERIC := 0;
	v_Min         NUMERIC := 0;
	Discount      NUMERIC := 0;
	Discount1Date timestamp WITH TIME ZONE;
	Discount2Date timestamp WITH TIME ZONE;
	Add1Date      NUMERIC := 0;
	Add2Date      NUMERIC := 0;
	p             RECORD;
BEGIN
	v_Currency := Currency_ID;
	IF (v_Currency = 0) THEN
		SELECT
			COALESCE(MAX(C_Currency_ID), 0)
		INTO v_Currency
		FROM
			AD_ClientInfo ci,
			C_AcctSchema s,
			C_PaymentTerm pt
		WHERE
			ci.AD_Client_ID = s.AD_Client_ID
			AND ci.AD_Client_ID = pt.AD_Client_ID
			AND pt.C_PaymentTerm_ID = PaymentTerm_ID;
	END IF;

	SELECT
		StdPrecision
	INTO v_Precision
	FROM
		C_Currency
	WHERE
		C_Currency_ID = v_Currency;

	SELECT 1 / 10 ^ v_Precision INTO v_Min;

	--	No Data - No Discount
	IF (Amount IS NULL OR PaymentTerm_ID IS NULL OR DocDate IS NULL) THEN
		RETURN 0;
	END IF;

	FOR p IN
		SELECT *
		FROM
			C_PaymentTerm
		WHERE
			C_PaymentTerm_ID = PaymentTerm_ID
		LOOP
			--	for convineance only
			Discount1Date := TRUNC(DocDate + p.DiscountDays + p.GraceDays);
			Discount2Date := TRUNC(DocDate + p.DiscountDays2 + p.GraceDays);

			--	Next Business Day
			IF (p.IsNextBusinessDay = 'Y') THEN
				Discount1Date := nextBusinessDay(Discount1Date, p.AD_Client_ID);
				Discount2Date := nextBusinessDay(Discount2Date, p.AD_Client_ID);
			END IF;

			--	Discount 1
			IF (Discount1Date >= TRUNC(PayDate)) THEN
				Discount := Amount * p.Discount / 100;
				--	Discount 2
			ELSIF (Discount2Date >= TRUNC(PayDate)) THEN
				Discount := Amount * p.Discount2 / 100;
			END IF;
		END LOOP;

	--	Ignore Rounding
	IF (Discount > -v_Min AND Discount < v_Min) THEN
		Discount := 0;
	END IF;

	--	Round to currency precision
	Discount := ROUND(COALESCE(Discount, 0), v_Precision);

	RETURN Discount;
END;

$$;

CREATE OR REPLACE FUNCTION paymenttermduedate(paymentterm_id numeric, docdate timestamp WITH TIME ZONE) RETURNS timestamp WITH TIME ZONE
	STABLE
	LANGUAGE plpgsql
AS
$$
/*************************************************************************
 * The contents of this file are subject to the Compiere License.  You may
 * obtain a copy of the License at    http://www.compiere.org/license.html
 * Software is on an  "AS IS" basis,  WITHOUT WARRANTY OF ANY KIND, either
 * express or implied. See the License for details. Code: Compiere ERP+CRM
 * Copyright (C) 1999-2001 Jorg Janke, ComPiere, Inc. All Rights Reserved.
 *
 * converted to postgreSQL by Karsten Thiemann (Schaeffer AG),
 * kthiemann@adempiere.org
 *************************************************************************
 * Title:	Get Due timestamp with time zone
 * Description:
 *	Returns the due timestamp with time zone
 * Test:
 *	select paymenttermDueDate(106, now()) from Test; => now()+30 days
 ************************************************************************/
DECLARE
	Days     NUMERIC                  := 0;
	DueDate  timestamp WITH TIME ZONE := TRUNC(DocDate);
	--
	FirstDay timestamp WITH TIME ZONE;
	NoDays   NUMERIC;
	p        RECORD;
BEGIN
	FOR p IN
		SELECT *
		FROM
			C_PaymentTerm
		WHERE
			C_PaymentTerm_ID = PaymentTerm_ID
		LOOP --	for convineance only
	--	Due 15th of following month
			IF (p.IsDueFixed = 'Y') THEN
				FirstDay := TRUNC(DocDate, 'MM');
				NoDays := EXTRACT(DAY FROM TRUNC(DocDate) - FirstDay);
				DueDate := FirstDay + (p.FixMonthDay - 1); --	starting on 1st
				DueDate := ADD_MONTHS(DueDate, p.FixMonthOffset);
				IF (NoDays > p.FixMonthCutoff) THEN
					DueDate := ADD_MONTHS(DueDate, 1);
				END IF;
			ELSE
				DueDate := TRUNC(DocDate) + p.NetDays;
			END IF;
		END LOOP;
	RETURN DueDate;
END;
$$;

CREATE OR REPLACE FUNCTION paymenttermduedays(paymentterm_id numeric, docdate timestamp WITH TIME ZONE,
                                              paydate timestamp WITH TIME ZONE) RETURNS integer
	STABLE
	LANGUAGE plpgsql
AS
$$
/*************************************************************************
 * The contents of this file are subject to the Compiere License.  You may
 * obtain a copy of the License at    http://www.compiere.org/license.html
 * Software is on an  "AS IS" basis,  WITHOUT WARRANTY OF ANY KIND, either
 * express or implied. See the License for details. Code: Compiere ERP+CRM
 * Copyright (C) 1999-2001 Jorg Janke, ComPiere, Inc. All Rights Reserved.
 *
 * converted to postgreSQL by Karsten Thiemann (Schaeffer AG),
 * kthiemann@adempiere.org
 *************************************************************************
 * Title:	Get Due Days
 * Description:
 *	Returns the days due (positive) or the days till due (negative)
 *	Grace days are not considered!
 *	If record is not found it assumes due immediately
 *
 *	Test:	SELECT paymenttermDueDays(103, now(), now());
 *
 * Contributor(s): Carlos Ruiz - globalqss - match with SQLJ version
 ************************************************************************/
DECLARE
	Days           NUMERIC                  := 0;
	DueDate        timestamp WITH TIME ZONE := NULL;
	calDueDate     timestamp WITH TIME ZONE;
	FixMonthOffset C_PaymentTerm.FixMonthOffset%TYPE;
	MaxDayCut      NUMERIC;
	MaxDay         NUMERIC;
	v_PayDate      timestamp WITH TIME ZONE;
	p              RECORD;
	--
	FirstDay       timestamp WITH TIME ZONE;
	NoDays         NUMERIC;
BEGIN

	IF PaymentTerm_ID = 0 OR DocDate IS NULL THEN
		RETURN 0;
	END IF;

	v_PayDate := PayDate;
	IF v_PayDate IS NULL THEN
		v_PayDate := TRUNC(NOW());
	END IF;

	FOR p IN
		SELECT *
		FROM
			C_PaymentTerm
		WHERE
			C_PaymentTerm_ID = PaymentTerm_ID
		LOOP --	for convineance only

	--	Due 15th of following month
			IF (p.IsDueFixed = 'Y') THEN
				FirstDay := TRUNC(DocDate, 'MM');
				NoDays := EXTRACT(DAY FROM (TRUNC(DocDate) - FirstDay));
				DueDate := FirstDay + (p.FixMonthDay - 1); --	starting on 1st
				DueDate := DueDate + (p.FixMonthOffset || ' month')::interval;

				IF (NoDays > p.FixMonthCutoff) THEN
					DueDate := DueDate + '1 month'::interval;
				END IF;
				-- raise notice 'FirstDay: %, NoDays: %, DueDate: %', FirstDay, NoDays, DueDate;

				calDueDate := TRUNC(DocDate);
				MaxDayCut := EXTRACT(DAY FROM (CAST(DATE_TRUNC('month', calDueDate) + '1 month'::interval AS date) - 1));
				-- raise notice 'last day(MaxDayCut): %' , MaxDayCut;

				IF p.FixMonthCutoff > MaxDayCut THEN
					-- raise notice 'p.FixMonthCutoff > MaxDayCut';
					calDueDate := CAST(DATE_TRUNC('month', TRUNC(calDueDate)) + '1 month'::interval AS date) - 1;
					-- raise notice 'last day(calDueDate): %' , calDueDate;
				ELSE
					-- set day fixmonthcutoff on duedate
					calDueDate := TRUNC(calDueDate, 'MM') + (((p.FixMonthCutoff - 1) || ' days')::interval);
					-- raise notice 'calDueDate: %' , calDueDate;

				END IF;
				FixMonthOffset := p.FixMonthOffset;
				IF DocDate > calDueDate THEN
					FixMonthOffset := FixMonthOffset + 1;
					RAISE NOTICE 'FixMonthOffset: %' , FixMonthOffset;
				END IF;

				calDueDate := calDueDate + (FixMonthOffset || ' month')::interval;
				-- raise notice 'calDueDate: %' , calDueDate;

				MaxDay := EXTRACT(DAY FROM (CAST(DATE_TRUNC('month', calDueDate) + '1 month'::interval AS date) - 1));


				IF (p.FixMonthDay > MaxDay) --	32 -> 28
					OR (p.FixMonthDay >= 30 AND MaxDay > p.FixMonthDay) THEN --	30 -> 31
					calDueDate := TRUNC(calDueDate, 'MM') + (((MaxDay - 1) || ' days')::interval);
					-- raise notice 'calDueDate: %' , calDueDate;
				ELSE
					calDueDate := TRUNC(calDueDate, 'MM') + (((p.FixMonthDay - 1) || ' days')::interval);
					-- raise notice 'calDueDate: %' , calDueDate;
				END IF;
				DueDate := calDueDate;

			ELSE
				DueDate := TRUNC(DocDate) + p.NetDays;
			END IF;
		END LOOP;

	IF DueDate IS NULL THEN
		RETURN 0;
	END IF;


	Days := EXTRACT(DAY FROM (TRUNC(v_PayDate) - DueDate));
	RETURN Days;
END;

$$;

CREATE OR REPLACE FUNCTION prodqtyordered(p_product_id numeric, p_warehouse_id numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
DECLARE
	v_Warehouse_ID numeric;
	v_Quantity     numeric := 99999; --	unlimited
	v_IsBOM        CHAR(1);
	v_IsStocked    CHAR(1);
	v_ProductType  CHAR(1);
	v_ProductQty   numeric;
	v_StdPrecision int;
BEGIN
	--	Check Parameters
	v_Warehouse_ID := p_Warehouse_ID;
	IF (v_Warehouse_ID IS NULL) THEN
		RETURN 0;
	END IF;
	--	DBMS_OUTPUT.PUT_LINE('Warehouse=' || v_Warehouse_ID);

	--	Check, if product exists and if it is stocked
	BEGIN
		SELECT
			IsBOM,
			ProductType,
			IsStocked
		INTO v_IsBOM, v_ProductType, v_IsStocked
		FROM
			M_PRODUCT
		WHERE
			M_Product_ID = p_Product_ID;
		--
	EXCEPTION --	not found
		WHEN OTHERS THEN
			RETURN 0;
	END;

	--	No reservation for non-stocked
	IF (v_IsStocked = 'Y') THEN
		--	Get ProductQty
		SELECT
			COALESCE(SUM(MovementQty), 0)
		INTO v_ProductQty
		FROM
			M_ProductionLine p
		WHERE
			M_Product_ID = p_Product_ID
			AND MovementQty > 0
			AND p.Processed = 'N'
			AND EXISTS (
				SELECT *
				FROM
					M_LOCATOR l
				WHERE
					p.M_Locator_ID = l.M_Locator_ID
					AND l.M_Warehouse_ID = v_Warehouse_ID
			);
		--
		RETURN v_ProductQty;
	END IF;

	--	Unlimited (e.g. only services)
	IF (v_Quantity = 99999) THEN
		RETURN 0;
	END IF;

	IF (v_Quantity > 0) THEN
		--	Get Rounding Precision for Product
		SELECT
			COALESCE(MAX(u.StdPrecision), 0)
		INTO v_StdPrecision
		FROM
			C_UOM u,
			M_PRODUCT p
		WHERE
			u.C_UOM_ID = p.C_UOM_ID
			AND p.M_Product_ID = p_Product_ID;
		--
		RETURN ROUND(v_Quantity, v_StdPrecision);
	END IF;
	RETURN 0;
END;
$$;

CREATE OR REPLACE FUNCTION prodqtyreserved(p_product_id numeric, p_warehouse_id numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
DECLARE
	v_Warehouse_ID numeric;
	v_Quantity     numeric := 99999; --	unlimited
	v_IsBOM        CHAR(1);
	v_IsStocked    CHAR(1);
	v_ProductType  CHAR(1);
	v_ProductQty   numeric;
	v_StdPrecision int;
BEGIN
	--	Check Parameters
	v_Warehouse_ID := p_Warehouse_ID;
	IF (v_Warehouse_ID IS NULL) THEN
		RETURN 0;
	END IF;
	--	DBMS_OUTPUT.PUT_LINE('Warehouse=' || v_Warehouse_ID);

	--	Check, if product exists and if it is stocked
	BEGIN
		SELECT
			IsBOM,
			ProductType,
			IsStocked
		INTO v_IsBOM, v_ProductType, v_IsStocked
		FROM
			M_PRODUCT
		WHERE
			M_Product_ID = p_Product_ID;
		--
	EXCEPTION --	not found
		WHEN OTHERS THEN
			RETURN 0;
	END;

	--	No reservation for non-stocked
	IF (v_IsStocked = 'Y') THEN
		--	Get ProductQty
		SELECT
			-1 * COALESCE(SUM(MovementQty), 0)
		INTO v_ProductQty
		FROM
			M_ProductionLine p
		WHERE
			M_Product_ID = p_Product_ID
			AND MovementQty < 0
			AND p.Processed = 'N'
			AND EXISTS (
				SELECT *
				FROM
					M_LOCATOR l
				WHERE
					p.M_Locator_ID = l.M_Locator_ID
					AND l.M_Warehouse_ID = v_Warehouse_ID
			);
		--
		RETURN v_ProductQty;
	END IF;

	--	Unlimited (e.g. only services)
	IF (v_Quantity = 99999) THEN
		RETURN 0;
	END IF;

	IF (v_Quantity > 0) THEN
		--	Get Rounding Precision for Product
		SELECT
			COALESCE(MAX(u.StdPrecision), 0)
		INTO v_StdPrecision
		FROM
			C_UOM u,
			M_PRODUCT p
		WHERE
			u.C_UOM_ID = p.C_UOM_ID
			AND p.M_Product_ID = p_Product_ID;
		--
		RETURN ROUND(v_Quantity, v_StdPrecision);
	END IF;
	RETURN 0;
END;
$$;

CREATE OR REPLACE FUNCTION productattribute(p_m_attributesetinstance_id numeric) RETURNS character varying
	STABLE
	LANGUAGE plpgsql
AS
$$

/*************************************************************************
 * The contents of this file are subject to the Compiere License.  You may
 * obtain a copy of the License at    http://www.compiere.org/license.html
 * Software is on an  "AS IS" basis,  WITHOUT WARRANTY OF ANY KIND, either
 * express or implied. See the License for details. Code: Compiere ERP+CRM
 * Copyright (C) 1999-2001 Jorg Janke, ComPiere, Inc. All Rights Reserved.
 *
 * converted to postgreSQL by Karsten Thiemann (Schaeffer AG),
 * kthiemann@adempiere.org
 *************************************************************************
 * Title: Return Instance Attribute Info
 * Description:
 *
 * Test:
    SELECT ProductAttribute (M_AttributeSetInstance_ID)
    FROM M_InOutLine WHERE M_AttributeSetInstance_ID > 0
    --
    SELECT p.Name
    FROM C_InvoiceLine il LEFT OUTER JOIN M_Product p ON (il.M_Product_ID=p.M_Product_ID);
    SELECT p.Name || ProductAttribute (il.M_AttributeSetInstance_ID)
    FROM C_InvoiceLine il LEFT OUTER JOIN M_Product p ON (il.M_Product_ID=p.M_Product_ID);

 ************************************************************************/


DECLARE

	v_Name          VARCHAR(2000) := '';
	v_NameAdd       VARCHAR(2000) := '';
	--
	v_Lot           M_AttributeSetInstance.Lot%TYPE;
	v_LotStart      M_AttributeSet.LotCharSOverwrite%TYPE;
	v_LotEnd        M_AttributeSet.LotCharEOverwrite%TYPE;
	v_SerNo         M_AttributeSetInstance.SerNo%TYPE;
	v_SerNoStart    M_AttributeSet.SerNoCharSOverwrite%TYPE;
	v_SerNoEnd      M_AttributeSet.SerNoCharEOverwrite%TYPE;
	v_GuaranteeDate M_AttributeSetInstance.GuaranteeDate%TYPE;
	r               RECORD;
	--

BEGIN
	--  Get Product Attribute Set Instance
	IF (p_M_AttributeSetInstance_ID > 0) THEN
		SELECT
			asi.Lot,
			asi.SerNo,
			asi.GuaranteeDate,
			COALESCE(a.SerNoCharSOverwrite, '#'::CHAR(1)),
			COALESCE(a.SerNoCharEOverwrite, ''::CHAR(1)),
			COALESCE(a.LotCharSOverwrite, CHR(171)),
			COALESCE(a.LotCharEOverwrite, CHR(187))
		INTO v_Lot, v_SerNo, v_GuaranteeDate,
			v_SerNoStart, v_SerNoEnd, v_LotStart, v_LotEnd
		FROM
			M_AttributeSetInstance asi
				INNER JOIN M_AttributeSet a
				ON (asi.M_AttributeSet_ID = a.M_AttributeSet_ID)
		WHERE
			asi.M_AttributeSetInstance_ID = p_M_AttributeSetInstance_ID;
		--
		IF (v_SerNo IS NOT NULL) THEN
			v_NameAdd := v_NameAdd || v_SerNoStart || v_SerNo || v_SerNoEnd || ' ';
		END IF;
		IF (v_Lot IS NOT NULL) THEN
			v_NameAdd := v_NameAdd || v_LotStart || v_Lot || v_LotEnd || ' ';
		END IF;
		IF (v_GuaranteeDate IS NOT NULL) THEN
			v_NameAdd := v_NameAdd || v_GuaranteeDate || ' ';
		END IF;
		--

		FOR r IN
			SELECT
				ai.Value,
				a.Name
			FROM
				M_AttributeInstance ai
					INNER JOIN M_Attribute a
					ON (ai.M_Attribute_ID = a.M_Attribute_ID AND a.IsInstanceAttribute = 'Y')
			WHERE
				ai.M_AttributeSetInstance_ID = p_M_AttributeSetInstance_ID
			LOOP
				v_NameAdd := v_NameAdd || r.Name || ':' || r.Value || ' ';
			END LOOP;
		--
		IF (LENGTH(v_NameAdd) > 0) THEN
			v_Name := v_Name || ' (' || TRIM(v_NameAdd) || ')';
		ELSE
			v_Name := NULL;
		END IF;
	END IF;
	RETURN v_Name;
END;

$$;

CREATE OR REPLACE FUNCTION register_migration_script(p_script character varying) RETURNS character varying
	LANGUAGE plpgsql
AS
$$
DECLARE
	v_return   CHARACTER VARYING;
	v_scriptid INTEGER;
BEGIN
	v_return := p_script || ' successfully registered';
	UPDATE AD_System
	SET
		LastMigrationScriptApplied=p_script
	WHERE
		LastMigrationScriptApplied < p_script
		OR LastMigrationScriptApplied IS NULL;
	SELECT
		MAX(AD_MigrationScript_ID)
	INTO v_scriptid
	FROM
		AD_MigrationScript
	WHERE
		Name = p_script;
	IF (v_scriptid IS NULL)
	THEN
		INSERT INTO
			ad_migrationscript
		(isapply, scriptroll, ad_migrationscript_uu,
		 status, projectname, releaseno,
		 name, filename, ad_client_id,
		 ad_org_id, created, createdby,
		 updated, updatedby, isactive,
		 ad_migrationscript_id)
		VALUES
			('Y', 'N', generate_uuid(),
			 'CO', 'iDempiere', (
				 SELECT releaseno
				 FROM ad_system
			 ),
			 p_script, 'postgresql/' || p_script, 0,
			 0, NOW(), 100,
			 NOW(), 100, 'Y',
			 nextidfunc(53081, 'N'));
	ELSE
		v_return := p_script || ' was already applied';
		RAISE NOTICE '%', v_return;
		UPDATE ad_migrationscript
		SET
			updated=NOW(),
			description = COALESCE(description, ' ') || ' reapplied'
		WHERE
			ad_migrationscript_id = v_scriptid;
	END IF;
	RETURN v_return;
END;
$$;

CREATE OR REPLACE FUNCTION round(numeric, numeric) RETURNS numeric
	IMMUTABLE
	LANGUAGE plpgsql
AS
$$
BEGIN
	RETURN ROUND($1, CAST($2 AS integer));
END;
$$;

CREATE OR REPLACE FUNCTION subtractdays(inter interval, days numeric) RETURNS integer
	LANGUAGE plpgsql
AS
$$
BEGIN
	RETURN (EXTRACT(EPOCH FROM (inter)) / 86400) - days;
END;
$$;

CREATE OR REPLACE FUNCTION subtractdays(day timestamp WITH TIME ZONE, days numeric) RETURNS date
	IMMUTABLE
	LANGUAGE plpgsql
AS
$$
BEGIN
	RETURN addDays(day, (days * -1));
END;
$$;

CREATE OR REPLACE FUNCTION trunc(i interval) RETURNS integer
	IMMUTABLE
	LANGUAGE plpgsql
AS
$$
BEGIN
	RETURN EXTRACT(DAY FROM i);
END;
$$;

CREATE OR REPLACE FUNCTION trunc(datetime timestamp WITHOUT TIME ZONE) RETURNS timestamp WITHOUT TIME ZONE
	IMMUTABLE
	LANGUAGE plpgsql
AS
$$
BEGIN
	RETURN CAST(datetime AS DATE);
END;
$$;

CREATE OR REPLACE FUNCTION trunc(datetime timestamp WITH TIME ZONE) RETURNS timestamp WITH TIME ZONE
	IMMUTABLE
	LANGUAGE plpgsql
AS
$$
BEGIN
	RETURN CAST(datetime AS DATE);
END;
$$;

CREATE OR REPLACE FUNCTION trunc(datetime timestamp WITH TIME ZONE, format character varying) RETURNS date
	IMMUTABLE
	LANGUAGE plpgsql
AS
$$
BEGIN
	IF format = 'Q' THEN
		RETURN CAST(DATE_TRUNC('quarter', datetime) AS DATE);
	ELSIF format = 'Y' OR format = 'YEAR' THEN
		RETURN CAST(DATE_TRUNC('year', datetime) AS DATE);
	ELSIF format = 'MM' OR format = 'MONTH' THEN
		RETURN CAST(DATE_TRUNC('month', datetime) AS DATE);
	ELSIF format = 'DD' THEN
		RETURN CAST(DATE_TRUNC('day', datetime) AS DATE);
	ELSIF format = 'DY' THEN
		RETURN CAST(DATE_TRUNC('day', datetime) AS DATE);
	ELSE
		RETURN CAST(datetime AS DATE);
	END IF;
END;
$$;
CREATE OR REPLACE FUNCTION adddays(inter interval, days numeric) RETURNS integer
	LANGUAGE plpgsql
AS
$$
BEGIN
RETURN ( EXTRACT( EPOCH FROM ( inter ) ) / 86400 ) + days;
END;
$$;

CREATE OR REPLACE FUNCTION adddays(datetime timestamp with time zone, days numeric) RETURNS date
	IMMUTABLE
	LANGUAGE plpgsql
AS
$$
declare duration varchar;
BEGIN
	if datetime is null or days is null then
		return null;
	end if;
	duration = days || ' day';
	return cast(date_trunc('day',datetime) + cast(duration as interval) as date);
END;
$$;

CREATE OR REPLACE FUNCTION altercolumn(tablename name, columnname name, datatype name, nullclause character varying, defaultclause character varying) RETURNS void
	LANGUAGE plpgsql
AS
$$
declare
   command text;
   viewtext text[];
   viewname name[];
   dropviews name[];
   i int;
   j int;
   v record;
   sqltype       text;
   sqltype_short text;
   typename name;
begin
   if datatype is not null then
	select pg_type.typname, format_type(pg_type.oid, pg_attribute.atttypmod)
            into typename, sqltype
            from pg_class, pg_attribute, pg_type
            where relname = lower(tablename)
                and relkind = 'r'
                and pg_class.oid = pg_attribute.attrelid
                and attname = lower(columnname)
                and atttypid = pg_type.oid;
        sqltype_short := sqltype;
        if typename = 'numeric' then
	   sqltype_short := replace(sqltype, ',0', '');
        elsif strpos(sqltype,'character varying') = 1 then
	   sqltype_short := replace(sqltype, 'character varying', 'varchar');
        elsif sqltype = 'timestamp without time zone' then
           sqltype_short := 'timestamp';
        end if;
        if lower(datatype) <> sqltype and lower(datatype) <> sqltype_short then
		i := 0;
		for v in
	        with recursive depv(relname, viewoid, depth) as (
		    select distinct a.relname, a.oid, 1
		        from pg_class a, pg_depend b, pg_depend c, pg_class d, pg_attribute e
		        where a.oid = b.refobjid
			    and b.objid = c.objid
			    and b.refobjid <> c.refobjid
			    and b.deptype = 'n'
			    and c.refobjid = d.oid
			    and d.relname = lower(tablename)
			    and d.relkind = 'r'
			    and d.oid = e.attrelid
			    and e.attname = lower(columnname)
			    and c.refobjsubid = e.attnum
			    and a.relkind = 'v'
	          union all
		    select distinct dependee.relname, dependee.oid, depv.depth+1
		        from pg_depend
			    join pg_rewrite on pg_depend.objid = pg_rewrite.oid
			    join pg_class as dependee on pg_rewrite.ev_class = dependee.oid
			    join pg_class as dependent on pg_depend.refobjid = dependent.oid
			    join pg_attribute ON pg_depend.refobjid = pg_attribute.attrelid and pg_depend.refobjsubid = pg_attribute.attnum and pg_attribute.attnum > 0
			    join depv on dependent.relname = depv.relname
	        )
	        select relname, viewoid, max(depth) from depv group by relname, viewoid order by 3 desc
		loop
		    i := i + 1;
		    viewtext[i] := pg_get_viewdef(v.viewoid);
		    viewname[i] := v.relname;
		end loop;
		if i > 0 then
		   begin
		     for j in 1 .. i loop
		        command := 'drop view ' || viewname[j];
			raise notice 'executing -> %', command;
		        execute command;
		        dropviews[j] := viewname[j];
		     end loop;
                     exception
                        when others then
                          i := array_upper(dropviews, 1);
                          if i > 0 then
                             for j in reverse i .. 1 loop
                                command := 'create or replace view ' || dropviews[j] || ' as ' || viewtext[j];
			        raise notice 'executing -> %', 'create view ' || dropviews[j];
		                execute command;
                             end loop;
                          end if;
                          raise exception 'Failed to recreate dependent view. SQLERRM=%', SQLERRM;
                   end;
		end if;
		command := 'alter table ' || lower(tablename) || ' alter column ' || lower(columnname) || ' type ' || lower(datatype);
		raise notice 'executing -> %', command;
		execute command;
                i := array_upper(dropviews, 1);
		if i > 0 then
		   for j in reverse i .. 1 loop
		     command := 'create or replace view ' || dropviews[j] || ' as ' || viewtext[j];
		     raise notice 'executing -> %', 'create view ' || dropviews[j];
		     execute command;
		   end loop;
		end if;
        end if;
   end if;

   if defaultclause is not null then
       if lower(defaultclause) = 'null' then
          command := 'alter table ' || lower(tablename) || ' alter column ' || lower(columnname) || ' drop default ';
       else
          if defaultclause  ~ '.*[(].*[)].*' or lower(defaultclause) = 'current_timestamp' then
          	command := 'alter table ' || lower(tablename) || ' alter column ' || lower(columnname) || ' set default ' || defaultclause;
          else
	  	  	command := 'alter table ' || lower(tablename) || ' alter column ' || lower(columnname) || ' set default ''' || defaultclause || '''';
	  	  end if;
       end if;
       raise notice 'executing -> %', command;
       execute command;
   end if;

   if nullclause is not null then
      if lower(nullclause) = 'not null' then
          command := 'alter table ' || lower(tablename) || ' alter column ' || lower(columnname) || ' set not null';
          raise notice 'executing -> %', command;
          execute command;
      elsif lower(nullclause) = 'null' then
          command := 'alter table ' || lower(tablename) || ' alter column ' || lower(columnname) || ' drop not null';
          raise notice 'executing -> %', command;
          execute command;
      end if;
   end if;
end;
$$;

CREATE OR REPLACE FUNCTION altercolumn(tablename name, columnname name, datatype name, nullclause character varying, defaultclause character varying, namespace name) RETURNS void
	LANGUAGE plpgsql
AS
$$
declare
   command text;
   viewtext text[];
   viewname name[];
   dropviews name[];
   perms   text[];
   privs text;
   i int;
   j int;
   v record;
   sqltype       text;
   sqltype_short text;
   typename name;
begin
   if datatype is not null then
	select pg_type.typname, format_type(pg_type.oid, pg_attribute.atttypmod)
            into typename, sqltype
            from pg_class, pg_attribute, pg_type, pg_namespace
            where relname = lower(tablename)
                and relkind = 'r'
                and pg_class.oid = pg_attribute.attrelid
                and attname = lower(columnname)
                and atttypid = pg_type.oid
                and pg_class.relnamespace = pg_namespace.oid
                and pg_namespace.nspname = lower(namespace);
        sqltype_short := sqltype;
        if typename = 'numeric' then
	   sqltype_short := replace(sqltype, ',0', '');
        elsif strpos(sqltype,'character varying') = 1 then
	   sqltype_short := replace(sqltype, 'character varying', 'varchar');
        elsif sqltype = 'timestamp without time zone' then
           sqltype_short := 'timestamp';
        end if;
        if lower(datatype) <> sqltype and lower(datatype) <> sqltype_short then
		i := 0;
		for v in
	        with recursive depv(relname, viewoid, depth) as (
		    select distinct a.relname, a.oid, 1
		        from pg_class a, pg_depend b, pg_depend c, pg_class d, pg_attribute e, pg_namespace
		        where a.oid = b.refobjid
			    and b.objid = c.objid
			    and b.refobjid <> c.refobjid
			    and b.deptype = 'n'
			    and c.refobjid = d.oid
			    and d.relname = lower(tablename)
			    and d.relkind = 'r'
			    and d.oid = e.attrelid
			    and e.attname = lower(columnname)
			    and c.refobjsubid = e.attnum
			    and a.relkind = 'v'
			    and a.relnamespace = pg_namespace.oid
			    and pg_namespace.nspname = lower(namespace)
	          union all
		    select distinct dependee.relname, dependee.oid, depv.depth+1
		        from pg_depend
			    join pg_rewrite on pg_depend.objid = pg_rewrite.oid
			    join pg_class as dependee on pg_rewrite.ev_class = dependee.oid
			    join pg_class as dependent on pg_depend.refobjid = dependent.oid
			    join pg_attribute ON pg_depend.refobjid = pg_attribute.attrelid and pg_depend.refobjsubid = pg_attribute.attnum and pg_attribute.attnum > 0
			    join depv on dependent.relname = depv.relname
			    join pg_namespace on dependee.relnamespace = pg_namespace.oid
			where pg_namespace.nspname = lower(namespace)
	        )
	        select relname, viewoid, max(depth) from depv group by relname, viewoid order by 3 desc
		loop
		    raise notice 'view -> % %', v.relname, v.viewoid;
		    i := i + 1;
		    viewtext[i] := pg_get_viewdef(v.viewoid);
		    viewname[i] := v.relname;
		end loop;
		if i > 0 then
		   begin
		     for j in 1 .. i loop
			    SELECT String_agg('grant ' || privilege_type || ' on ' || viewname[j] || ' to ' || grantee, '; ')
				into privs
				FROM information_schema.role_table_grants
				WHERE table_name=viewname[j];
				perms[j] := privs;
		        command := 'drop view ' || viewname[j];
			raise notice 'executing -> %', command;
		        execute command;
		        dropviews[j] := viewname[j];
		     end loop;
                     exception
                        when others then
                          i := array_upper(dropviews, 1);
                          if i > 0 then
                             for j in reverse i .. 1 loop
                                command := 'create or replace view ' || dropviews[j] || ' as ' || viewtext[j];
			        raise notice 'executing -> %', 'create view ' || dropviews[j];
		                execute command;
                             end loop;
                          end if;
                          raise exception 'Failed to recreate dependent view. SQLERRM=%', SQLERRM;
                   end;
		end if;
		command := 'alter table ' || lower(tablename) || ' alter column ' || lower(columnname) || ' type ' || lower(datatype);
		raise notice 'executing -> %', command;
		execute command;
                i := array_upper(dropviews, 1);
		if i > 0 then
		   for j in reverse i .. 1 loop
		     command := 'create or replace view ' || dropviews[j] || ' as ' || viewtext[j];
		     raise notice 'executing -> %', 'create view ' || dropviews[j];
		     execute command;
			 command := perms[j];
		     raise notice 'executing -> %', 'grant ' || perms[j];
		     execute command;
		   end loop;
		end if;
        end if;
   end if;

   if defaultclause is not null then
       if lower(defaultclause) = 'null' then
          command := 'alter table ' || lower(tablename) || ' alter column ' || lower(columnname) || ' drop default ';
       else
          if defaultclause  ~ '.*[(].*[)].*' or lower(defaultclause) = 'current_timestamp' then
          	command := 'alter table ' || lower(tablename) || ' alter column ' || lower(columnname) || ' set default ' || defaultclause;
          else
	  	  	command := 'alter table ' || lower(tablename) || ' alter column ' || lower(columnname) || ' set default ''' || defaultclause || '''';
	  	  end if;
       end if;
       raise notice 'executing -> %', command;
       execute command;
   end if;

   if nullclause is not null then
      if lower(nullclause) = 'not null' then
          command := 'alter table ' || lower(tablename) || ' alter column ' || lower(columnname) || ' set not null';
          raise notice 'executing -> %', command;
          execute command;
      elsif lower(nullclause) = 'null' then
          command := 'alter table ' || lower(tablename) || ' alter column ' || lower(columnname) || ' drop not null';
          raise notice 'executing -> %', command;
          execute command;
      end if;
   end if;
end;
$$;

CREATE OR REPLACE FUNCTION bompricelimit(product_id numeric, pricelist_version_id numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
DECLARE
	v_Price	NUMERIC;
	v_ProductPrice	NUMERIC;
	bom RECORD;

BEGIN
	--	Try to get price from PriceList directly
	SELECT	COALESCE (SUM(PriceLimit), 0)
      	INTO	v_Price
   	FROM	M_ProductPrice
	WHERE M_PriceList_Version_ID=PriceList_Version_ID AND M_Product_ID=Product_ID;

	--	No Price - Check if BOM
	IF (v_Price = 0) THEN
		FOR bom IN
			SELECT b.M_ProductBOM_ID, b.BOMQty, p.IsBOM
			FROM M_Product_BOM b, M_Product p
			WHERE b.M_ProductBOM_ID=p.M_Product_ID
			AND b.M_Product_ID=Product_ID
			AND b.M_ProductBOM_ID != Product_ID
			AND b.IsActive='Y'
		LOOP
			v_ProductPrice := bomPriceLimit (bom.M_ProductBOM_ID, PriceList_Version_ID);
			v_Price := v_Price + (bom.BOMQty * v_ProductPrice);
		END LOOP;
	END IF;
	--
	RETURN v_Price;

END;

$$;

CREATE OR REPLACE FUNCTION bompricelist(product_id numeric, pricelist_version_id numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
DECLARE
	v_Price	NUMERIC;
	v_ProductPrice	NUMERIC;
	bom RECORD;

BEGIN
	--	Try to get price from pricelist directly
	SELECT	COALESCE (SUM(PriceList), 0)
	INTO	v_Price
	FROM	M_ProductPrice
	WHERE M_PriceList_Version_ID=PriceList_Version_ID AND M_Product_ID=Product_ID;

	--	No Price - Check if BOM
	IF (v_Price = 0) THEN
		FOR bom IN
			SELECT b.M_ProductBOM_ID, b.BOMQty, p.IsBOM
			FROM M_Product_BOM b, M_Product p
			WHERE b.M_ProductBOM_ID=p.M_Product_ID
			AND b.M_Product_ID=Product_ID
			AND b.M_ProductBOM_ID != Product_ID
			AND b.IsActive='Y'
		LOOP
			v_ProductPrice := bomPriceList (bom.M_ProductBOM_ID, PriceList_Version_ID);
			v_Price := v_Price + (bom.BOMQty * v_ProductPrice);
		END LOOP;
	END IF;
	--
	RETURN v_Price;

END;

$$;

CREATE OR REPLACE FUNCTION bompricestd(product_id numeric, pricelist_version_id numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
DECLARE
	v_Price	NUMERIC;
	v_ProductPrice	NUMERIC;
	bom RECORD;

BEGIN
	--	Try to get price from PriceList directly
	SELECT	COALESCE(SUM(PriceStd), 0)
	INTO	v_Price
	FROM	M_ProductPrice
	WHERE M_PriceList_Version_ID=PriceList_Version_ID AND M_Product_ID=Product_ID;

	--	No Price - Check if BOM
	IF (v_Price = 0) THEN
		FOR bom IN
			SELECT b.M_ProductBOM_ID, b.BOMQty, p.IsBOM
			FROM M_Product_BOM b, M_Product p
			WHERE b.M_ProductBOM_ID=p.M_Product_ID
			AND b.M_Product_ID=Product_ID
			AND b.M_ProductBOM_ID != Product_ID
			AND b.IsActive='Y'
		LOOP
			v_ProductPrice := bomPriceStd (bom.M_ProductBOM_ID, PriceList_Version_ID);
			v_Price := v_Price + (bom.BOMQty * v_ProductPrice);
		END LOOP;
	END IF;
	--
	RETURN v_Price;

END;

$$;

CREATE OR REPLACE FUNCTION bomqtyavailable(product_id numeric, warehouse_id numeric, locator_id numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
BEGIN
	RETURN bomQtyOnHandForReservation(Product_ID, Warehouse_ID, Locator_ID) - bomQtyReserved(Product_ID, Warehouse_ID, Locator_ID);
END;
$$;

CREATE OR REPLACE FUNCTION bomqtyonhand(product_id numeric, warehouse_id numeric, locator_id numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
DECLARE
	myWarehouse_ID		numeric;
 	v_Quantity		numeric := 99999;	--	unlimited
	v_IsBOM			CHAR(1);
	v_IsStocked		CHAR(1);
	v_ProductType		CHAR(1);
 	v_ProductQty		numeric;
	v_StdPrecision		int;
	bom			record;

BEGIN
	--	Check Parameters
	myWarehouse_ID := Warehouse_ID;
	IF (myWarehouse_ID IS NULL) THEN
		IF (Locator_ID IS NULL) THEN
			RETURN 0;
		ELSE
			SELECT 	SUM(M_Warehouse_ID) INTO myWarehouse_ID
			FROM	M_LOCATOR
			WHERE	M_Locator_ID=Locator_ID;
		END IF;
	END IF;
	IF (myWarehouse_ID IS NULL) THEN
		RETURN 0;
	END IF;

	--	Check, if product exists and if it is stocked
	BEGIN
		SELECT	IsBOM, ProductType, IsStocked
	 	  INTO	v_IsBOM, v_ProductType, v_IsStocked
		FROM M_PRODUCT
		WHERE M_Product_ID=Product_ID;
		--
	EXCEPTION	--	not found
		WHEN OTHERS THEN
			RETURN 0;
	END;
	--	Unlimited capacity if no item
	IF (v_IsBOM='N' AND (v_ProductType<>'I' OR v_IsStocked='N')) THEN
		RETURN v_Quantity;
	--	Stocked item
	ELSIF (v_IsStocked='Y') THEN
		--	Get ProductQty
		SELECT 	COALESCE(SUM(QtyOnHand), 0)
		  INTO	v_ProductQty
		FROM 	M_Storageonhand s
		  JOIN M_Locator l ON (s.M_Locator_ID=l.M_Locator_ID)
		WHERE s.M_Product_ID=Product_ID AND l.M_Warehouse_ID=myWarehouse_ID;
		--
		RETURN v_ProductQty;
	END IF;

	--	Go through BOM
	FOR bom IN 	--	Get BOM Product info
		SELECT b.M_ProductBOM_ID, b.BOMQty, p.IsBOM, p.IsStocked, p.ProductType
		FROM M_PRODUCT_BOM b, M_PRODUCT p
		WHERE b.M_ProductBOM_ID=p.M_Product_ID
		  AND b.M_Product_ID=product_ID
		  AND b.M_ProductBOM_ID != Product_ID
		  AND p.IsBOM='Y'
		  AND p.IsVerified='Y'
		  AND b.IsActive='Y'
	LOOP
		--	Stocked Items "leaf node"
		IF (bom.ProductType = 'I' AND bom.IsStocked = 'Y') THEN
			--	Get v_ProductQty
			SELECT 	COALESCE(SUM(QtyOnHand), 0)
			  INTO	v_ProductQty
			FROM 	M_Storageonhand s
			  JOIN M_Locator l ON (s.M_Locator_ID=l.M_Locator_ID)
			WHERE s.M_Product_ID=bom.M_ProductBOM_ID AND l.M_Warehouse_ID=myWarehouse_ID;
			--	Get Rounding Precision
			SELECT 	COALESCE(MAX(u.StdPrecision), 0)
			  INTO	v_StdPrecision
			FROM 	C_UOM u, M_PRODUCT p
			WHERE u.C_UOM_ID=p.C_UOM_ID AND p.M_Product_ID=bom.M_ProductBOM_ID;
			--	How much can we make with this product
			v_ProductQty := ROUND (v_ProductQty/bom.BOMQty, v_StdPrecision);
			--	How much can we make overall
			IF (v_ProductQty < v_Quantity) THEN
				v_Quantity := v_ProductQty;
			END IF;
		--	Another BOM
		ELSIF (bom.IsBOM = 'Y') THEN
			v_ProductQty := Bomqtyonhand (bom.M_ProductBOM_ID, myWarehouse_ID, Locator_ID);
			--	How much can we make overall
			IF (v_ProductQty < v_Quantity) THEN
				v_Quantity := v_ProductQty;
			END IF;
		END IF;
	END LOOP;	--	BOM

	IF (v_Quantity > 0) THEN
		--	Get Rounding Precision for Product
		SELECT 	COALESCE(MAX(u.StdPrecision), 0)
		  INTO	v_StdPrecision
		FROM 	C_UOM u, M_PRODUCT p
		WHERE u.C_UOM_ID=p.C_UOM_ID AND p.M_Product_ID=Product_ID;
		--
		RETURN ROUND (v_Quantity, v_StdPrecision);
	END IF;
	RETURN 0;
END;
$$;

CREATE OR REPLACE FUNCTION bomqtyonhandforreservation(product_id numeric, warehouse_id numeric, locator_id numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
DECLARE
	myWarehouse_ID		numeric;
 	v_Quantity		numeric := 99999;	--	unlimited
	v_IsBOM			CHAR(1);
	v_IsStocked		CHAR(1);
	v_ProductType		CHAR(1);
 	v_ProductQty		numeric;
	v_StdPrecision		int;
	bom			record;

BEGIN
	--	Check Parameters
	myWarehouse_ID := Warehouse_ID;
	IF (myWarehouse_ID IS NULL) THEN
		IF (Locator_ID IS NULL) THEN
			RETURN 0;
		ELSE
			SELECT 	SUM(M_Warehouse_ID) INTO myWarehouse_ID
			FROM	M_LOCATOR
			WHERE	M_Locator_ID=Locator_ID;
		END IF;
	END IF;
	IF (myWarehouse_ID IS NULL) THEN
		RETURN 0;
	END IF;

	--	Check, if product exists and if it is stocked
	BEGIN
		SELECT	IsBOM, ProductType, IsStocked
	 	  INTO	v_IsBOM, v_ProductType, v_IsStocked
		FROM M_PRODUCT
		WHERE M_Product_ID=Product_ID;
		--
	EXCEPTION	--	not found
		WHEN OTHERS THEN
			RETURN 0;
	END;
	--	Unlimited capacity if no item
	IF (v_IsBOM='N' AND (v_ProductType<>'I' OR v_IsStocked='N')) THEN
		RETURN v_Quantity;
	--	Stocked item
	ELSIF (v_IsStocked='Y') THEN
		--	Get ProductQty
		SELECT 	COALESCE(SUM(QtyOnHand), 0)
		  INTO	v_ProductQty
		FROM 	M_Storageonhand s
		  JOIN M_Locator l ON (s.M_Locator_ID=l.M_Locator_ID)
		  LEFT JOIN M_LocatorType lt ON (l.M_LocatorType_ID=lt.M_LocatorType_ID)
		WHERE s.M_Product_ID=Product_ID AND l.M_Warehouse_ID=myWarehouse_ID
		  AND COALESCE(lt.IsAvailableForReservation,'Y')='Y';
		--
		RETURN v_ProductQty;
	END IF;

	--	Go through BOM
	FOR bom IN 	--	Get BOM Product info
		SELECT b.M_ProductBOM_ID, b.BOMQty, p.IsBOM, p.IsStocked, p.ProductType
		FROM M_PRODUCT_BOM b, M_PRODUCT p
		WHERE b.M_ProductBOM_ID=p.M_Product_ID
		  AND b.M_Product_ID=product_ID
		  AND b.M_ProductBOM_ID != Product_ID
		  AND p.IsBOM='Y'
		  AND p.IsVerified='Y'
		  AND b.IsActive='Y'
	LOOP
		--	Stocked Items "leaf node"
		IF (bom.ProductType = 'I' AND bom.IsStocked = 'Y') THEN
			--	Get v_ProductQty
			SELECT 	COALESCE(SUM(QtyOnHand), 0)
			  INTO	v_ProductQty
			FROM 	M_Storageonhand s
			  JOIN M_Locator l ON (s.M_Locator_ID=l.M_Locator_ID)
		  	  LEFT JOIN M_LocatorType lt ON (l.M_LocatorType_ID=lt.M_LocatorType_ID)
			WHERE s.M_Product_ID=bom.M_ProductBOM_ID AND l.M_Warehouse_ID=myWarehouse_ID
		  	  AND COALESCE(lt.IsAvailableForReservation,'Y')='Y';
			--	Get Rounding Precision
			SELECT 	COALESCE(MAX(u.StdPrecision), 0)
			  INTO	v_StdPrecision
			FROM 	C_UOM u, M_PRODUCT p
			WHERE u.C_UOM_ID=p.C_UOM_ID AND p.M_Product_ID=bom.M_ProductBOM_ID;
			--	How much can we make with this product
			v_ProductQty := ROUND (v_ProductQty/bom.BOMQty, v_StdPrecision);
			--	How much can we make overall
			IF (v_ProductQty < v_Quantity) THEN
				v_Quantity := v_ProductQty;
			END IF;
		--	Another BOM
		ELSIF (bom.IsBOM = 'Y') THEN
			v_ProductQty := BOMQtyOnHandForReservation (bom.M_ProductBOM_ID, myWarehouse_ID, Locator_ID);
			--	How much can we make overall
			IF (v_ProductQty < v_Quantity) THEN
				v_Quantity := v_ProductQty;
			END IF;
		END IF;
	END LOOP;	--	BOM

	IF (v_Quantity > 0) THEN
		--	Get Rounding Precision for Product
		SELECT 	COALESCE(MAX(u.StdPrecision), 0)
		  INTO	v_StdPrecision
		FROM 	C_UOM u, M_PRODUCT p
		WHERE u.C_UOM_ID=p.C_UOM_ID AND p.M_Product_ID=Product_ID;
		--
		RETURN ROUND (v_Quantity, v_StdPrecision);
	END IF;
	RETURN 0;
END;
$$;

CREATE OR REPLACE FUNCTION bomqtyordered(p_product_id numeric, p_warehouse_id numeric, p_locator_id numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
DECLARE
	v_Warehouse_ID		numeric;
 	v_Quantity		numeric := 99999;	--	unlimited
	v_IsBOM			CHAR(1);
	v_IsStocked		CHAR(1);
	v_ProductType		CHAR(1);
 	v_ProductQty		numeric;
	v_StdPrecision		int;
	bom 			record;
BEGIN
	--	Check Parameters
	v_Warehouse_ID := p_Warehouse_ID;
	IF (v_Warehouse_ID IS NULL) THEN
		IF (p_Locator_ID IS NULL) THEN
			RETURN 0;
		ELSE
			SELECT 	MAX(M_Warehouse_ID) INTO v_Warehouse_ID
			FROM	M_LOCATOR
			WHERE	M_Locator_ID=p_Locator_ID;
		END IF;
	END IF;
	IF (v_Warehouse_ID IS NULL) THEN
		RETURN 0;
	END IF;

	--	Check, if product exists and if it is stocked
	BEGIN
		SELECT	IsBOM, ProductType, IsStocked
		  INTO	v_IsBOM, v_ProductType, v_IsStocked
		FROM 	M_PRODUCT
		WHERE 	M_Product_ID=p_Product_ID;
		--
	EXCEPTION	--	not found
		WHEN OTHERS THEN
			RETURN 0;
	END;

	--	No reservation for non-stocked
	IF (v_IsBOM='N' AND (v_ProductType<>'I' OR v_IsStocked='N')) THEN
		RETURN 0;
	--	Stocked item
	ELSIF (v_IsStocked='Y') THEN
		--	Get ProductQty
		SELECT 	COALESCE(SUM(Qty), 0)
		  INTO	v_ProductQty
		FROM 	M_StorageReservation
		WHERE M_Product_ID=p_Product_ID
		  AND M_Warehouse_ID=v_Warehouse_ID
		  AND IsSOTrx='N'
		  AND IsActive='Y';
		--
		RETURN v_ProductQty;
	END IF;

	--	Go though BOM
	FOR bom IN
	--	Get BOM Product info
		SELECT b.M_ProductBOM_ID, b.BOMQty, p.IsBOM, p.IsStocked, p.ProductType
		FROM M_PRODUCT_BOM b, M_PRODUCT p
		WHERE b.M_ProductBOM_ID=p.M_Product_ID
		  AND b.M_Product_ID=p_Product_ID
		  AND b.M_ProductBOM_ID != p_Product_ID
		  AND p.IsBOM='Y'
		  AND p.IsVerified='Y'
		  AND b.IsActive='Y'
	LOOP
		--	Stocked Items "leaf node"
		IF (bom.ProductType = 'I' AND bom.IsStocked = 'Y') THEN
			--	Get ProductQty
			SELECT 	COALESCE(SUM(Qty), 0)
			  INTO	v_ProductQty
			FROM 	M_StorageReservation
			WHERE M_Product_ID=p_Product_ID
			  AND M_Warehouse_ID=v_Warehouse_ID
			  AND IsSOTrx='N'
			  AND IsActive='Y';
			--	Get Rounding Precision
			SELECT 	COALESCE(MAX(u.StdPrecision), 0)
			  INTO	v_StdPrecision
			FROM 	C_UOM u, M_PRODUCT p
			WHERE 	u.C_UOM_ID=p.C_UOM_ID AND p.M_Product_ID=bom.M_ProductBOM_ID;
			--	How much can we make with this product
			v_ProductQty := ROUND (v_ProductQty/bom.BOMQty, v_StdPrecision );

			--	How much can we make overall
			IF (v_ProductQty < v_Quantity) THEN
				v_Quantity := v_ProductQty;
			END IF;
		--	Another BOM
		ELSIF (bom.IsBOM = 'Y') THEN
			v_ProductQty := Bomqtyordered (bom.M_ProductBOM_ID, v_Warehouse_ID, p_Locator_ID);
			--	How much can we make overall
			IF (v_ProductQty < v_Quantity) THEN
				v_Quantity := v_ProductQty;
			END IF;
		END IF;
	END LOOP;	--	BOM

	--	Unlimited (e.g. only services)
	IF (v_Quantity = 99999) THEN
		RETURN 0;
	END IF;

	IF (v_Quantity > 0) THEN
		--	Get Rounding Precision for Product
		SELECT 	COALESCE(MAX(u.StdPrecision), 0)
		  INTO	v_StdPrecision
		FROM 	C_UOM u, M_PRODUCT p
		WHERE 	u.C_UOM_ID=p.C_UOM_ID AND p.M_Product_ID=p_Product_ID;
		--
		RETURN ROUND (v_Quantity, v_StdPrecision );
	END IF;
	--
	RETURN 0;
END;
$$;

CREATE OR REPLACE FUNCTION bomqtyreserved(p_product_id numeric, p_warehouse_id numeric, p_locator_id numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
DECLARE
	v_Warehouse_ID			numeric;
 	v_Quantity			numeric := 99999;	--	unlimited
	v_IsBOM				CHAR(1);
	v_IsStocked			CHAR(1);
	v_ProductType			CHAR(1);
 	v_ProductQty			numeric;
	v_StdPrecision			int;
	bom				record;
BEGIN
	--	Check Parameters
	v_Warehouse_ID := p_Warehouse_ID;
	IF (v_Warehouse_ID IS NULL) THEN
		IF (p_Locator_ID IS NULL) THEN
			RETURN 0;
		ELSE
			SELECT 	MAX(M_Warehouse_ID) INTO v_Warehouse_ID
			FROM	M_LOCATOR
			WHERE	M_Locator_ID=p_Locator_ID;
		END IF;
	END IF;
	IF (v_Warehouse_ID IS NULL) THEN
		RETURN 0;
	END IF;

	--	Check, if product exists and if it is stocked
	BEGIN
		SELECT	IsBOM, ProductType, IsStocked
		  INTO	v_IsBOM, v_ProductType, v_IsStocked
		FROM M_PRODUCT
		WHERE M_Product_ID=p_Product_ID;
		--
	EXCEPTION	--	not found
		WHEN OTHERS THEN
			RETURN 0;
	END;

	--	No reservation for non-stocked
	IF (v_IsBOM='N' AND (v_ProductType<>'I' OR v_IsStocked='N')) THEN
		RETURN 0;
	--	Stocked item
	ELSIF (v_IsStocked='Y') THEN
		--	Get ProductQty
		SELECT 	COALESCE(SUM(Qty), 0)
		  INTO	v_ProductQty
		FROM 	M_StorageReservation
		WHERE M_Product_ID=p_Product_ID
		  AND M_Warehouse_ID=v_Warehouse_ID
		  AND IsSOTrx='Y'
		  AND IsActive='Y';
		--
		RETURN v_ProductQty;
	END IF;

	--	Go though BOM
	FOR bom IN
	--	Get BOM Product info
		SELECT b.M_ProductBOM_ID, b.BOMQty, p.IsBOM, p.IsStocked, p.ProductType
		FROM M_PRODUCT_BOM b, M_PRODUCT p
		WHERE b.M_ProductBOM_ID=p.M_Product_ID
		  AND b.M_Product_ID=p_Product_ID
		  AND b.M_ProductBOM_ID != p_Product_ID
		  AND p.IsBOM='Y'
		  AND p.IsVerified='Y'
		  AND b.IsActive='Y'
	LOOP
		--	Stocked Items "leaf node"
		IF (bom.ProductType = 'I' AND bom.IsStocked = 'Y') THEN
			--	Get ProductQty
			SELECT 	COALESCE(SUM(Qty), 0)
			  INTO	v_ProductQty
			FROM 	M_StorageReservation
			WHERE 	M_Product_ID=bom.M_ProductBOM_ID
			  AND   M_Warehouse_ID =v_Warehouse_ID
			  AND	IsSOTrx='Y'
			  AND	IsActive='Y';
			--	Get Rounding Precision
			SELECT 	COALESCE(MAX(u.StdPrecision), 0)
			  INTO	v_StdPrecision
			FROM 	C_UOM u, M_PRODUCT p
			WHERE 	u.C_UOM_ID=p.C_UOM_ID AND p.M_Product_ID=bom.M_ProductBOM_ID;
			--	How much can we make with this product
			v_ProductQty := ROUND (v_ProductQty/bom.BOMQty, v_StdPrecision);
			--	How much can we make overall
			IF (v_ProductQty < v_Quantity) THEN
				v_Quantity := v_ProductQty;
			END IF;
		--	Another BOM
		ELSIF (bom.IsBOM = 'Y') THEN
			v_ProductQty := Bomqtyreserved (bom.M_ProductBOM_ID, v_Warehouse_ID, p_Locator_ID);
			--	How much can we make overall
			IF (v_ProductQty < v_Quantity) THEN
				v_Quantity := v_ProductQty;
			END IF;
		END IF;
	END LOOP;	--	BOM

	--	Unlimited (e.g. only services)
	IF (v_Quantity = 99999) THEN
		RETURN 0;
	END IF;

	IF (v_Quantity > 0) THEN
		--	Get Rounding Precision for Product
		SELECT 	COALESCE(MAX(u.StdPrecision), 0)
		  INTO	v_StdPrecision
		FROM 	C_UOM u, M_PRODUCT p
		WHERE 	u.C_UOM_ID=p.C_UOM_ID AND p.M_Product_ID=p_Product_ID;
		--
		RETURN ROUND (v_Quantity, v_StdPrecision);
	END IF;
	RETURN 0;
END;
$$;

CREATE OR REPLACE FUNCTION bpartnerremitlocation(p_c_bpartner_id numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$

DECLARE
	v_C_Location_ID	NUMERIC := NULL;
	l RECORD;

BEGIN
	FOR l IN
		SELECT	IsRemitTo, C_Location_ID
		FROM	C_BPartner_Location
		WHERE	C_BPartner_ID=p_C_BPartner_ID AND IsActive='Y'
		ORDER BY IsRemitTo DESC
	LOOP
		IF (v_C_Location_ID IS NULL) THEN
			v_C_Location_ID := l.C_Location_ID;
		END IF;
	END LOOP;
	RETURN v_C_Location_ID;

END;

$$;

CREATE OR REPLACE FUNCTION charat(character varying, integer) RETURNS character varying
	IMMUTABLE
	LANGUAGE plpgsql
AS
$$
 BEGIN
 RETURN SUBSTR($1, $2, 1);
 END;
$$;

CREATE OR REPLACE FUNCTION currencybase(p_amount numeric, p_curfrom_id numeric, p_convdate timestamp with time zone, p_client_id numeric, p_org_id numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
/*************************************************************************
 * The contents of this file are subject to the Compiere License.  You may
 * obtain a copy of the License at    http://www.compiere.org/license.html
 * Software is on an  "AS IS" basis,  WITHOUT WARRANTY OF ANY KIND, either
 * express or implied. See the License for details. Code: Compiere ERP+CRM
 * Copyright (C) 1999-2001 Jorg Janke, ComPiere, Inc. All Rights Reserved.
 *
 * converted to postgreSQL by Karsten Thiemann (Schaeffer AG),
 * kthiemann@adempiere.org
 *************************************************************************
 *
 ***
 * Title:	Convert Amount to Base Currency of Client
 * Description:
 *		Get CurrencyTo from Client
 *		Returns NULL, if conversion not found
 *		Standard Rounding
 * Test:
 *		SELECT currencyBase(100,116,null,11,null) FROM AD_System; => 64.72
 ************************************************************************/
DECLARE
	v_CurTo_ID	NUMERIC;
BEGIN
	--	Get Currency
	SELECT	MAX(ac.C_Currency_ID)
	  INTO	v_CurTo_ID
	FROM	AD_ClientInfo ci, C_AcctSchema ac
	WHERE	ci.C_AcctSchema1_ID=ac.C_AcctSchema_ID
	  AND	ci.AD_Client_ID=p_Client_ID;
	--	Same as Currency_Conversion - if currency/rate not found - return 0
	IF (v_CurTo_ID IS NULL) THEN
		RETURN NULL;
	END IF;
	--	Same currency
	IF (p_CurFrom_ID = v_CurTo_ID) THEN
		RETURN p_Amount;
	END IF;

	RETURN currencyConvert (p_Amount, p_CurFrom_ID, v_CurTo_ID, p_ConvDate, null, p_Client_ID, p_Org_ID);
END;

$$;

CREATE OR REPLACE FUNCTION currencyconvert(p_amount numeric, p_curfrom_id numeric, p_curto_id numeric, p_convdate timestamp with time zone, p_conversiontype_id numeric, p_client_id numeric, p_org_id numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$

/*************************************************************************
 * The contents of this file are subject to the Compiere License.  You may
 * obtain a copy of the License at    http://www.compiere.org/license.html
 * Software is on an  "AS IS" basis,  WITHOUT WARRANTY OF ANY KIND, either
 * express or implied. See the License for details. Code: Compiere ERP+CRM
 * Copyright (C) 1999-2001 Jorg Janke, ComPiere, Inc. All Rights Reserved.
 *
 * converted to postgreSQL by Karsten Thiemann (Schaeffer AG),
 * kthiemann@adempiere.org
 *************************************************************************
 ***
 * Title:	Convert Amount (using IDs)
 * Description:
 *		from CurrencyFrom_ID to CurrencyTo_ID
 *		Returns NULL, if conversion not found
 *		Standard Rounding
 * Test:
 *	SELECT currencyConvert(100,116,100,null,null,null,null) FROM AD_System;  => 64.72
 ************************************************************************/


DECLARE
	v_Rate				NUMERIC;

BEGIN
	--	Return Amount
		IF (p_Amount = 0 OR p_CurFrom_ID = p_CurTo_ID) THEN
			RETURN p_Amount;
		END IF;
		--	Return NULL
		IF (p_Amount IS NULL OR p_CurFrom_ID IS NULL OR p_CurTo_ID IS NULL) THEN
			RETURN NULL;
		END IF;

		--	Get Rate
		v_Rate := currencyRate (p_CurFrom_ID, p_CurTo_ID, p_ConvDate, p_ConversionType_ID, p_Client_ID, p_Org_ID);
		IF (v_Rate IS NULL) THEN
			RETURN NULL;
		END IF;

		--	Standard Precision
	RETURN currencyRound(p_Amount * v_Rate, p_CurTo_ID, null);

END;

$$;

CREATE OR REPLACE FUNCTION currencyrate(p_curfrom_id numeric, p_curto_id numeric, p_convdate timestamp with time zone, p_conversiontype_id numeric, p_client_id numeric, p_org_id numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$

/*************************************************************************
 * The contents of this file are subject to the Compiere License.  You may
 * obtain a copy of the License at    http://www.compiere.org/license.html
 * Software is on an  "AS IS" basis,  WITHOUT WARRANTY OF ANY KIND, either
 * express or implied. See the License for details. Code: Compiere ERP+CRM
 * Copyright (C) 1999-2001 Jorg Janke, ComPiere, Inc. All Rights Reserved.
 *
 * converted to postgreSQL by Karsten Thiemann (Schaeffer AG),
 * kthiemann@adempiere.org
 *************************************************************************
 ***
 * Title:	Return Conversion Rate
 * Description:
 *		from CurrencyFrom_ID to CurrencyTo_ID
 *		Returns NULL, if rate not found
 * Test
 *		SELECT currencyrate(116, 100, null, null, null, null) FROM AD_System;  => .647169
 ************************************************************************/


DECLARE
	--	Currency From variables
	cf_IsEuro		CHAR(1);
	cf_IsEMUMember		CHAR(1);
	cf_EMUEntryDate		timestamp with time zone;
	cf_EMURate		NUMERIC;
	--	Currency To variables
	ct_IsEuro		CHAR(1);
	ct_IsEMUMember		CHAR(1);
	ct_EMUEntryDate	DATE;
	ct_EMURate		NUMERIC;
	--	Triangle
	v_CurrencyFrom		NUMERIC;
	v_CurrencyTo		NUMERIC;
	v_CurrencyEuro		NUMERIC;
	--
	v_ConvDate		timestamp with time zone := now();
	v_ConversionType_ID	NUMERIC := 0;
	v_Rate			NUMERIC;
	c			RECORD;

BEGIN
--	No Conversion
	IF (p_CurFrom_ID = p_CurTo_ID) THEN
		RETURN 1;
	END IF;
	--	Default Date Parameter
	IF (p_ConvDate IS NOT NULL) THEN
		v_ConvDate := p_ConvDate;   --  SysDate
	END IF;
    --  Default Conversion Type
	IF (p_ConversionType_ID IS NULL OR p_ConversionType_ID = 0) THEN
		BEGIN
		    SELECT C_ConversionType_ID
		      INTO v_ConversionType_ID
		    FROM C_ConversionType
		    WHERE IsActive='Y' AND IsDefault='Y'
		      AND AD_Client_ID IN (0,p_Client_ID)
		    ORDER BY AD_Client_ID DESC
		    LIMIT 1;
		EXCEPTION WHEN OTHERS THEN
		    RAISE NOTICE 'Conversion Type Not Found';
		END;
    	ELSE
        	v_ConversionType_ID := p_ConversionType_ID;
	END IF;

	--	Get Currency Info
	SELECT	MAX(IsEuro), MAX(IsEMUMember), MAX(EMUEntryDate), MAX(EMURate)
	  INTO	cf_IsEuro, cf_IsEMUMember, cf_EMUEntryDate, cf_EMURate
	FROM		C_Currency
	  WHERE	C_Currency_ID = p_CurFrom_ID;
	-- Not Found
	IF (cf_IsEuro IS NULL) THEN
		RAISE NOTICE 'From Currency Not Found';
		RETURN NULL;
	END IF;
	SELECT	MAX(IsEuro), MAX(IsEMUMember), MAX(EMUEntryDate), MAX(EMURate)
	  INTO	ct_IsEuro, ct_IsEMUMember, ct_EMUEntryDate, ct_EMURate
	FROM		C_Currency
	  WHERE	C_Currency_ID = p_CurTo_ID;
	-- Not Found
	IF (ct_IsEuro IS NULL) THEN
		RAISE NOTICE 'To Currency Not Found';
		RETURN NULL;
	END IF;

	--	Fixed - From Euro to EMU
	IF (cf_IsEuro = 'Y' AND ct_IsEMUMember ='Y' AND v_ConvDate >= ct_EMUEntryDate) THEN
		RETURN ct_EMURate;
	END IF;

	--	Fixed - From EMU to Euro
	IF (ct_IsEuro = 'Y' AND cf_IsEMUMember ='Y' AND v_ConvDate >= cf_EMUEntryDate) THEN
		RETURN 1 / cf_EMURate;
	END IF;

	--	Fixed - From EMU to EMU
	IF (cf_IsEMUMember = 'Y' AND cf_IsEMUMember ='Y'
			AND v_ConvDate >= cf_EMUEntryDate AND v_ConvDate >= ct_EMUEntryDate) THEN
		RETURN ct_EMURate / cf_EMURate;
	END IF;

	--	Flexible Rates
	v_CurrencyFrom := p_CurFrom_ID;
	v_CurrencyTo := p_CurTo_ID;

	-- if EMU Member involved, replace From/To Currency
	IF ((cf_isEMUMember = 'Y' AND v_ConvDate >= cf_EMUEntryDate)
	  OR (ct_isEMUMember = 'Y' AND v_ConvDate >= ct_EMUEntryDate)) THEN
		SELECT	MAX(C_Currency_ID)
		  INTO	v_CurrencyEuro
		FROM		C_Currency
		WHERE	IsEuro = 'Y';
		-- Conversion Rate not Found
		IF (v_CurrencyEuro IS NULL) THEN
			RAISE NOTICE 'Euro Not Found';
			RETURN NULL;
		END IF;
		IF (cf_isEMUMember = 'Y' AND v_ConvDate >= cf_EMUEntryDate) THEN
			v_CurrencyFrom := v_CurrencyEuro;
		ELSE
			v_CurrencyTo := v_CurrencyEuro;
		END IF;
	END IF;

	--	Get Rate

	BEGIN
		FOR c IN SELECT	MultiplyRate
			FROM	C_Conversion_Rate
			WHERE	IsActive='Y' AND C_Currency_ID=v_CurrencyFrom AND C_Currency_ID_To=v_CurrencyTo
			  AND	C_ConversionType_ID=v_ConversionType_ID
			  AND	v_ConvDate BETWEEN ValidFrom AND ValidTo
			  AND	AD_Client_ID IN (0,p_Client_ID) AND AD_Org_ID IN (0,p_Org_ID)
			ORDER BY AD_Client_ID DESC, AD_Org_ID DESC, ValidFrom DESC
		LOOP
			v_Rate := c.MultiplyRate;
			EXIT;	--	only first
		END LOOP;
	END;
	--	Not found
	IF (v_Rate IS NULL) THEN
		RAISE NOTICE 'Conversion Rate Not Found';
		RETURN NULL;
	END IF;

	--	Currency From was EMU
	IF (cf_isEMUMember = 'Y' AND v_ConvDate >= cf_EMUEntryDate) THEN
		RETURN v_Rate / cf_EMURate;
	END IF;

	--	Currency To was EMU
	IF (ct_isEMUMember = 'Y' AND v_ConvDate >= ct_EMUEntryDate) THEN
		RETURN v_Rate * ct_EMURate;
	END IF;

	RETURN v_Rate;

EXCEPTION WHEN OTHERS THEN
	RAISE NOTICE '%', SQLERRM;
	RETURN NULL;


END;

$$;

CREATE OR REPLACE FUNCTION currencyround(p_amount numeric, p_curto_id numeric, p_costing character varying) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$

/*************************************************************************
 * The contents of this file are subject to the Compiere License.  You may
 * obtain a copy of the License at    http://www.compiere.org/license.html
 * Software is on an  "AS IS" basis,  WITHOUT WARRANTY OF ANY KIND, either
 * express or implied. See the License for details. Code: Compiere ERP+CRM
 * Copyright (C) 1999-2001 Jorg Janke, ComPiere, Inc. All Rights Reserved.
 *
 * converted to postgreSQL by Karsten Thiemann (Schaeffer AG),
 * kthiemann@adempiere.org
 *************************************************************************
 ***
 * Title:	Round amount for Traget Currency
 * Description:
 *		Round Amount using Costing or Standard Precision
 *		Returns unmodified amount if currency not found
 * Test:
 *		SELECT currencyRound(currencyConvert(100,116,100,null,null),100,null) FROM AD_System => 64.72
 ************************************************************************/


DECLARE
	v_StdPrecision		int;
	v_CostPrecision		int;

BEGIN
	--	Nothing to convert
	IF (p_Amount IS NULL OR p_CurTo_ID IS NULL) THEN
		RETURN p_Amount;
	END IF;

	--	Ger Precision
	SELECT	MAX(StdPrecision), MAX(CostingPrecision)
	  INTO	v_StdPrecision, v_CostPrecision
	FROM	C_Currency
	  WHERE	C_Currency_ID = p_CurTo_ID;
	--	Currency Not Found
	IF (v_StdPrecision IS NULL) THEN
		RETURN p_Amount;
	END IF;

	IF (p_Costing = 'Y') THEN
		RETURN ROUND (p_Amount, v_CostPrecision);
	END IF;

	RETURN ROUND (p_Amount, v_StdPrecision);

END;

$$;

CREATE OR REPLACE FUNCTION daysbetween(p_date1 timestamp with time zone, p_date2 timestamp with time zone) RETURNS integer
	IMMUTABLE
	LANGUAGE plpgsql
AS
$$
BEGIN
	RETURN CAST(p_date1 AS DATE) - CAST(p_date2 as DATE);
END;
$$;

CREATE OR REPLACE FUNCTION documentno(p_pp_mrp_id numeric) RETURNS character varying
	STABLE
	LANGUAGE plpgsql
AS
$$
DECLARE
	v_DocumentNo PP_MRP.Value%TYPE := '';
BEGIN
	-- If NO id return empty string
	IF p_PP_MRP_ID <= 0 THEN
		RETURN '';
	END IF;
	SELECT --ordertype, m_forecast_id, c_order_id, dd_order_id, pp_order_id, m_requisition_id,
	CASE
			WHEN trim(mrp.ordertype) = 'FTC' THEN (SELECT f.Name FROM M_Forecast f WHERE f.M_Forecast_ID=mrp.M_Forecast_ID)
			WHEN trim(mrp.ordertype) = 'POO' THEN (SELECT co.DocumentNo  FROM C_Order co WHERE co.C_Order_ID=mrp.C_Order_ID)
			WHEN trim(mrp.ordertype) = 'DOO' THEN (SELECT dd.DocumentNo  FROM DD_Order dd WHERE dd.DD_Order_ID=mrp.DD_Order_ID)
			WHEN trim(mrp.ordertype) = 'SOO' THEN (SELECT co.DocumentNo  FROM C_Order co WHERE co.C_Order_ID=mrp.C_Order_ID)
			WHEN trim(mrp.ordertype) = 'MOP' THEN (SELECT po.DocumentNo FROM PP_Order po WHERE po.PP_Order_ID=mrp.PP_Order_ID)
			WHEN trim(mrp.ordertype) = 'POR' THEN (SELECT r.DocumentNo  FROM M_Requisition r WHERE r.M_Requisition_ID=mrp.M_Requisition_ID)

	END INTO v_DocumentNo
	FROM pp_mrp mrp
	WHERE mrp.pp_mrp_id = p_PP_MRP_ID;
	RETURN v_DocumentNo;
END;
$$;

CREATE OR REPLACE FUNCTION firstof(timestamp with time zone, character varying) RETURNS date
	IMMUTABLE
	LANGUAGE plpgsql
AS
$$
DECLARE
datepart VARCHAR;
datetime TIMESTAMP WITH TIME ZONE;
offsetdays INTEGER;
BEGIN
	datepart = $2;
	offsetdays = 0;
	IF $2 IN ('') THEN
		datepart = 'millennium';
	ELSEIF $2 IN ('') THEN
		datepart = 'century';
	ELSEIF $2 IN ('') THEN
		datepart = 'decade';
	ELSEIF $2 IN ('IYYY','IY','I') THEN
		datepart = 'year';
	ELSEIF $2 IN ('SYYYY','YYYY','YEAR','SYEAR','YYY','YY','Y') THEN
		datepart = 'year';
	ELSEIF $2 IN ('Q') THEN
		datepart = 'quarter';
	ELSEIF $2 IN ('MONTH','MON','MM','RM') THEN
		datepart = 'month';
	ELSEIF $2 IN ('IW') THEN
		datepart = 'week';
	ELSEIF $2 IN ('W') THEN
		datepart = 'week';
	ELSEIF $2 IN ('DDD','DD','J') THEN
		datepart = 'day';
	ELSEIF $2 IN ('DAY','DY','D') THEN
		datepart = 'week';
		-- move to sunday to make it compatible with oracle and SQLJ
		offsetdays = -1;
	ELSEIF $2 IN ('HH','HH12','HH24') THEN
		datepart = 'hour';
	ELSEIF $2 IN ('MI') THEN
		datepart = 'minute';
	ELSEIF $2 IN ('') THEN
		datepart = 'second';
	ELSEIF $2 IN ('') THEN
		datepart = 'milliseconds';
	ELSEIF $2 IN ('') THEN
		datepart = 'microseconds';
	END IF;
	datetime = date_trunc(datepart, $1);
RETURN cast(datetime as date) + offsetdays;
END;
$$;

CREATE OR REPLACE FUNCTION generate_uuid() RETURNS character
	LANGUAGE plpgsql
AS
$$
BEGIN
	return uuid_generate_v4()::char(36);
END;
$$;

CREATE OR REPLACE FUNCTION get1099bucket(p_cbpartner_id numeric, p_cut_date timestamp with time zone, p_bucket numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
DECLARE
   tmpvar   numeric;
/******************************************************************************
   NAME:       get1099bucket
   PURPOSE:

   REVISIONS:
   Ver        Date        Author           Description
   ---------  ----------  ---------------  ------------------------------------
   1.0        04/01/2008  Carlos Ruiz      1. Created this function.

******************************************************************************/
BEGIN
   SELECT SUM (  (COALESCE (linenetamt, 0) + COALESCE (taxamt, 0))
               * (CASE WHEN docbasetype = 'API' THEN 1
		       WHEN docbasetype = 'APC' THEN -1
		       ELSE 0
		  END)
              )            -- +API->AP Invoice / -APC->AP Credit Memo
     INTO tmpvar
     FROM C_INVOICE i, C_INVOICELINE il, C_1099BOX b, C_DOCTYPE dt
    WHERE i.c_invoice_id = il.c_invoice_id
      AND i.issotrx = 'N'
      AND il.c_1099box_id = b.c_1099box_id
      AND i.dateacct BETWEEN TRUNC (p_cut_date, 'YEAR') AND p_cut_date
      AND c_bpartner_id = p_cbpartner_id
      AND b.bucket = p_bucket
      AND i.c_doctype_id = dt.c_doctype_id
      AND i.docstatus IN ('CO', 'CL');

   RETURN tmpvar;
END;
$$;

CREATE OR REPLACE FUNCTION get_sysconfig(sysconfig_name character varying, defaultvalue character varying, client_id numeric, org_id numeric) RETURNS character varying
	STABLE
	LANGUAGE plpgsql
AS
$$
DECLARE
 	v_value ad_sysconfig.value%TYPE;
BEGIN
    BEGIN
	    SELECT Value
	      INTO STRICT v_value
	      FROM AD_SysConfig WHERE Name=sysconfig_name AND AD_Client_ID IN (0, client_id) AND AD_Org_ID IN (0, org_id) AND IsActive='Y'
	     ORDER BY AD_Client_ID DESC, AD_Org_ID DESC
	     LIMIT 1;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            v_value := defaultvalue;
    END;
	RETURN v_value;
END;
$$;

CREATE OR REPLACE FUNCTION getdate() RETURNS timestamp with time zone
	STABLE
	LANGUAGE plpgsql
AS
$$
BEGIN
    RETURN statement_timestamp();
END;
$$;

CREATE OR REPLACE FUNCTION instr(character varying, character varying) RETURNS integer
	IMMUTABLE
	STRICT
	LANGUAGE plpgsql
AS
$$
DECLARE
    pos integer;
BEGIN
    pos:= instr($1, $2, 1);
    RETURN pos;
END;
$$;

CREATE OR REPLACE FUNCTION instr(string character varying, string_to_search character varying, beg_index integer) RETURNS integer
	IMMUTABLE
	STRICT
	LANGUAGE plpgsql
AS
$$
DECLARE
    pos integer NOT NULL DEFAULT 0;
    temp_str varchar;
    beg integer;
    length integer;
    ss_length integer;
BEGIN
    IF beg_index > 0 THEN
        temp_str := substring(string FROM beg_index);
        pos := position(string_to_search IN temp_str);

        IF pos = 0 THEN
            RETURN 0;
        ELSE
            RETURN pos + beg_index - 1;
        END IF;
    ELSE
        ss_length := char_length(string_to_search);
        length := char_length(string);
        beg := length + beg_index - ss_length + 2;

        WHILE beg > 0 LOOP
            temp_str := substring(string FROM beg FOR ss_length);
            pos := position(string_to_search IN temp_str);

            IF pos > 0 THEN
                RETURN beg;
            END IF;

            beg := beg - 1;
        END LOOP;

        RETURN 0;
    END IF;
END;
$$;

CREATE OR REPLACE FUNCTION instr(string character varying, string_to_search character varying, beg_index integer, occur_index integer) RETURNS integer
	IMMUTABLE
	STRICT
	LANGUAGE plpgsql
AS
$$
DECLARE
    pos integer NOT NULL DEFAULT 0;
    occur_number integer NOT NULL DEFAULT 0;
    temp_str varchar;
    beg integer;
    i integer;
    length integer;
    ss_length integer;
BEGIN
    IF beg_index > 0 THEN
        beg := beg_index;
        temp_str := substring(string FROM beg_index);

        FOR i IN 1..occur_index LOOP
            pos := position(string_to_search IN temp_str);

            IF i = 1 THEN
                beg := beg + pos - 1;
            ELSE
                beg := beg + pos;
            END IF;

            temp_str := substring(string FROM beg + 1);
        END LOOP;

        IF pos = 0 THEN
            RETURN 0;
        ELSE
            RETURN beg;
        END IF;
    ELSE
        ss_length := char_length(string_to_search);
        length := char_length(string);
        beg := length + beg_index - ss_length + 2;

        WHILE beg > 0 LOOP
            temp_str := substring(string FROM beg FOR ss_length);
            pos := position(string_to_search IN temp_str);

            IF pos > 0 THEN
                occur_number := occur_number + 1;

                IF occur_number = occur_index THEN
                    RETURN beg;
                END IF;
            END IF;

            beg := beg - 1;
        END LOOP;

        RETURN 0;
    END IF;
END;
$$;

CREATE OR REPLACE FUNCTION invoicediscount(p_c_invoice_id numeric, p_paydate timestamp with time zone, p_c_invoicepayschedule_id numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
/*************************************************************************
 * The contents of this file are subject to the Compiere License.  You may
 * obtain a copy of the License at    http://www.compiere.org/license.html
 * Software is on an  "AS IS" basis,  WITHOUT WARRANTY OF ANY KIND, either
 * express or implied. See the License for details. Code: Compiere ERP+CRM
 * Copyright (C) 1999-2001 Jorg Janke, ComPiere, Inc. All Rights Reserved.
 *
 * converted to postgreSQL by Karsten Thiemann (Schaeffer AG),
 * kthiemann@adempiere.org
 *************************************************************************
 ***
 * Title:	Calculate Payment Discount Amount
 * Description:
 *			- Calculate discountable amount (i.e. with or without tax)
 *			- Calculate and return payment discount
 * Test:
 * 		select invoiceDiscount(109, now(), 103) from ad_system; => 0
 ************************************************************************/
DECLARE
	v_Amount		NUMERIC;
	v_IsDiscountLineAmt	CHAR(1);
	v_GrandTotal		NUMERIC;
	v_TotalLines		NUMERIC;
	v_C_PaymentTerm_ID	NUMERIC(10);
	v_C_Currency_ID		NUMERIC(10);
	v_DocDate		timestamp with time zone;
	v_PayDate		timestamp with time zone := now();
    	v_IsPayScheduleValid    CHAR(1);

BEGIN
	SELECT 	ci.IsDiscountLineAmt, i.GrandTotal, i.TotalLines,
		i.C_PaymentTerm_ID, i.DateInvoiced, i.IsPayScheduleValid, C_Currency_ID
	INTO 	v_IsDiscountLineAmt, v_GrandTotal, v_TotalLines,
		v_C_PaymentTerm_ID, v_DocDate, v_IsPayScheduleValid, v_C_Currency_ID
	FROM 	AD_ClientInfo ci, C_Invoice i
	WHERE 	ci.AD_Client_ID=i.AD_Client_ID
	  AND 	i.C_Invoice_ID=p_C_Invoice_ID;

	--	What Amount is the Discount Base?
 	IF (v_IsDiscountLineAmt = 'Y') THEN
		v_Amount := v_TotalLines;
	ELSE
		v_Amount := v_GrandTotal;
	END IF;

	--	Anything to discount?
	IF (v_Amount = 0) THEN
		RETURN 0;
   	END IF;
	IF (p_PayDate IS NOT NULL) THEN
		v_PayDate := p_PayDate;
  	END IF;

    --  Valid Payment Schedule
    IF (v_IsPayScheduleValid='Y' AND p_C_InvoicePaySchedule_ID > 0) THEN
        SELECT COALESCE(MAX(DiscountAmt),0)
          INTO v_Amount
        FROM C_InvoicePaySchedule
        WHERE C_InvoicePaySchedule_ID=p_C_InvoicePaySchedule_ID
          AND DiscountDate >= v_PayDate;
        --
        RETURN v_Amount;
    END IF;

	--	return discount amount
	RETURN paymentTermDiscount (v_Amount, v_C_Currency_ID, v_C_PaymentTerm_ID, v_DocDate, p_PayDate);

--	Most likely if invoice not found
EXCEPTION
	WHEN OTHERS THEN
		RETURN NULL;
END;

$$;

CREATE OR REPLACE FUNCTION invoiceopen(p_c_invoice_id numeric, p_c_invoicepayschedule_id numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
/*************************************************************************
 * The contents of this file are subject to the Compiere License.  You may
 * obtain a copy of the License at    http://www.compiere.org/license.html
 * Software is on an  "AS IS" basis,  WITHOUT WARRANTY OF ANY KIND, either
 * express or implied. See the License for details. Code: Compiere ERP+CRM
 * Copyright (C) 1999-2001 Jorg Janke, ComPiere, Inc. All Rights Reserved.
 *
 * converted to postgreSQL by Karsten Thiemann (Schaeffer AG),
 * kthiemann@adempiere.org
 *************************************************************************
 ***
 * Title:	Calculate Open Item Amount in Invoice Currency
 * Description:
 *	Add up total amount open for C_Invoice_ID if no split payment.
 *  Grand Total minus Sum of Allocations in Invoice Currency
 *
 *  For Split Payments:
 *  Allocate Payments starting from first schedule.
 *  Cannot be used for IsPaid as mutating
 *
 * Test:
 * 	SELECT C_InvoicePaySchedule_ID, DueAmt FROM C_InvoicePaySchedule WHERE C_Invoice_ID=109 ORDER BY DueDate;
 * 	SELECT invoiceOpen (109, null) FROM AD_System; - converted to default client currency
 * 	SELECT invoiceOpen (109, 11) FROM AD_System; - converted to default client currency
 * 	SELECT invoiceOpen (109, 102) FROM AD_System;
 * 	SELECT invoiceOpen (109, 103) FROM AD_System;
 ************************************************************************/
DECLARE
	v_Currency_ID		NUMERIC(10);
	v_TotalOpenAmt  	NUMERIC := 0;
	v_PaidAmt  	        NUMERIC := 0;
	v_Remaining	        NUMERIC := 0;
    	v_MultiplierAP      	NUMERIC := 0;
    	v_MultiplierCM      	NUMERIC := 0;
    	v_Temp              	NUMERIC := 0;
    	v_Precision            	NUMERIC := 0;
    	v_Min            	NUMERIC := 0;
    	ar			RECORD;
    	s			RECORD;

BEGIN
	--	Get Currency
	BEGIN
		SELECT	MAX(C_Currency_ID), SUM(GrandTotal), MAX(MultiplierAP), MAX(Multiplier)
		INTO	v_Currency_ID, v_TotalOpenAmt, v_MultiplierAP, v_MultiplierCM
		FROM	C_Invoice_v		--	corrected for CM / Split Payment
		WHERE	C_Invoice_ID = p_C_Invoice_ID;
	EXCEPTION	--	Invoice in draft form
		WHEN OTHERS THEN
            	RAISE NOTICE 'InvoiceOpen - %', SQLERRM;
			RETURN NULL;
	END;

	SELECT StdPrecision
	    INTO v_Precision
	    FROM C_Currency
	    WHERE C_Currency_ID = v_Currency_ID;

	SELECT 1/10^v_Precision INTO v_Min;

	--	Calculate Allocated Amount
	FOR ar IN
		SELECT	a.AD_Client_ID, a.AD_Org_ID,
		al.Amount, al.DiscountAmt, al.WriteOffAmt,
		a.C_Currency_ID, a.DateTrx
		FROM	C_AllocationLine al
		INNER JOIN C_AllocationHdr a ON (al.C_AllocationHdr_ID=a.C_AllocationHdr_ID)
		WHERE	al.C_Invoice_ID = p_C_Invoice_ID
          	AND   a.IsActive='Y'
	LOOP
        v_Temp := ar.Amount + ar.DisCountAmt + ar.WriteOffAmt;
		v_PaidAmt := v_PaidAmt
        -- Allocation
			+ currencyConvert(v_Temp * v_MultiplierAP,
				ar.C_Currency_ID, v_Currency_ID, ar.DateTrx, null, ar.AD_Client_ID, ar.AD_Org_ID);
      	RAISE NOTICE '   PaidAmt=% , Allocation= % * %', v_PaidAmt, v_Temp, v_MultiplierAP;
	END LOOP;

    --  Do we have a Payment Schedule ?
    IF (p_C_InvoicePaySchedule_ID > 0) THEN --   if not valid = lists invoice amount
        v_Remaining := v_PaidAmt;
        FOR s IN
        	SELECT  C_InvoicePaySchedule_ID, DueAmt
	        FROM    C_InvoicePaySchedule
		WHERE	C_Invoice_ID = p_C_Invoice_ID
	        AND   IsValid='Y'
        	ORDER BY DueDate
        LOOP
            IF (s.C_InvoicePaySchedule_ID = p_C_InvoicePaySchedule_ID) THEN
                v_TotalOpenAmt := (s.DueAmt*v_MultiplierCM) - v_Remaining;
                IF (s.DueAmt - v_Remaining < 0) THEN
                    v_TotalOpenAmt := 0;
                END IF;
            ELSE -- calculate amount, which can be allocated to next schedule
                v_Remaining := v_Remaining - s.DueAmt;
                IF (v_Remaining < 0) THEN
                    v_Remaining := 0;
                END IF;
            END IF;
        END LOOP;
    ELSE
        v_TotalOpenAmt := v_TotalOpenAmt - v_PaidAmt;
    END IF;
--  RAISE NOTICE ''== Total='' || v_TotalOpenAmt;

	--	Ignore Rounding
	IF (v_TotalOpenAmt > -v_Min AND v_TotalOpenAmt < v_Min) THEN
		v_TotalOpenAmt := 0;
	END IF;

	--	Round to currency precision
	v_TotalOpenAmt := ROUND(COALESCE(v_TotalOpenAmt,0), v_Precision);
	RETURN	v_TotalOpenAmt;
END;

$$;

CREATE OR REPLACE FUNCTION invoiceopentodate(p_c_invoice_id numeric, p_c_invoicepayschedule_id numeric, p_dateacct date) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
DECLARE
	v_Currency_ID  numeric(10);
	v_Precision         NUMERIC := 0;
    v_Min            	NUMERIC := 0;
	v_TotalOpenAmt   numeric := 0;
	v_PaidAmt           numeric := 0;
	v_Remaining         numeric := 0;
	v_MultiplierAP      numeric := 0;
	v_MultiplierCM      numeric := 0;
	v_Temp              numeric := 0;
	allocationline	    record;
	invoiceschedule	    record;
BEGIN
 -- Get Currency
 BEGIN
  SELECT MAX(C_Currency_ID), SUM(GrandTotal), MAX(MultiplierAP), MAX(Multiplier)
    INTO v_Currency_ID, v_TotalOpenAmt, v_MultiplierAP, v_MultiplierCM
  FROM C_Invoice_v  -- corrected for CM / Split Payment
  WHERE C_Invoice_ID = p_C_Invoice_ID
    AND DateAcct <= p_DateAcct;
 EXCEPTION -- Invoice in draft form
  WHEN OTHERS THEN
            --DBMS_OUTPUT.PUT_LINE('InvoiceOpen - ' || SQLERRM);
   RETURN NULL;
 END;
--  DBMS_OUTPUT.PUT_LINE('== C_Invoice_ID=' || p_C_Invoice_ID || ', Total=' || v_TotalOpenAmt || ', AP=' || v_MultiplierAP || ', CM=' || v_MultiplierCM);

	SELECT StdPrecision
	    INTO v_Precision
	    FROM C_Currency
	    WHERE C_Currency_ID = v_Currency_ID;

	SELECT 1/10^v_Precision INTO v_Min;

 -- Calculate Allocated Amount
 FOR allocationline IN
  SELECT a.AD_Client_ID, a.AD_Org_ID,
            al.Amount, al.DiscountAmt, al.WriteOffAmt,
            a.C_Currency_ID, a.DateTrx
  FROM C_ALLOCATIONLINE al
          INNER JOIN C_ALLOCATIONHDR a ON (al.C_AllocationHdr_ID=a.C_AllocationHdr_ID)
  WHERE al.C_Invoice_ID = p_C_Invoice_ID
    AND a.DateAcct <= p_DateAcct
    AND   a.IsActive='Y'
 LOOP
        v_Temp := allocationline.Amount + allocationline.DisCountAmt + allocationline.WriteOffAmt;
  v_PaidAmt := v_PaidAmt
        -- Allocation
   + Currencyconvert(v_Temp * v_MultiplierAP,
    allocationline.C_Currency_ID, v_Currency_ID, allocationline.DateTrx, NULL, allocationline.AD_Client_ID, allocationline.AD_Org_ID);
      --DBMS_OUTPUT.PUT_LINE('   PaidAmt=' || v_PaidAmt || ', Allocation=' || v_Temp || ' * ' || v_MultiplierAP);
 END LOOP;

    --  Do we have a Payment Schedule ?
    IF (p_C_InvoicePaySchedule_ID > 0) THEN --   if not valid = lists invoice amount
        v_Remaining := v_PaidAmt;
        FOR invoiceschedule IN
        SELECT  C_InvoicePaySchedule_ID, DueAmt FROM    C_INVOICEPAYSCHEDULE WHERE C_Invoice_ID = p_C_Invoice_ID AND IsValid='Y'
        ORDER BY DueDate
        LOOP
            IF (invoiceschedule.C_InvoicePaySchedule_ID = p_C_InvoicePaySchedule_ID) THEN
                v_TotalOpenAmt := (invoiceschedule.DueAmt*v_MultiplierCM) - v_Remaining;
                IF (invoiceschedule.DueAmt - v_Remaining < 0) THEN
                    v_TotalOpenAmt := 0;
                END IF;
            --  DBMS_OUTPUT.PUT_LINE('Sched Total=' || v_TotalOpenAmt || ', Due=' || s.DueAmt || ',Remaining=' || v_Remaining || ',CM=' || v_MultiplierCM);
            ELSE -- calculate amount, which can be allocated to next schedule
                v_Remaining := v_Remaining - invoiceschedule.DueAmt;
                IF (v_Remaining < 0) THEN
                    v_Remaining := 0;
                END IF;
            --  DBMS_OUTPUT.PUT_LINE('Remaining=' || v_Remaining);
            END IF;
        END LOOP;
    ELSE
        v_TotalOpenAmt := v_TotalOpenAmt - v_PaidAmt;
    END IF;
--  DBMS_OUTPUT.PUT_LINE('== Total=' || v_TotalOpenAmt);

	--	Ignore Rounding
	IF (v_TotalOpenAmt > -v_Min AND v_TotalOpenAmt < v_Min) THEN
		v_TotalOpenAmt := 0;
	END IF;

	--	Round to currency precision
	v_TotalOpenAmt := ROUND(COALESCE(v_TotalOpenAmt,0), v_Precision);

	RETURN v_TotalOpenAmt;
END;
$$;

CREATE OR REPLACE FUNCTION invoiceopentodate(p_c_invoice_id numeric, p_c_invoicepayschedule_id numeric, p_dateacct timestamp with time zone) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
DECLARE
	v_Currency_ID  numeric(10);
	v_Precision         NUMERIC := 0;
    v_Min            	NUMERIC := 0;
	v_TotalOpenAmt   numeric := 0;
	v_PaidAmt           numeric := 0;
	v_Remaining         numeric := 0;
	v_MultiplierAP      numeric := 0;
	v_MultiplierCM      numeric := 0;
	v_Temp              numeric := 0;
	allocationline	    record;
	invoiceschedule	    record;
BEGIN
 -- Get Currency
 BEGIN
  SELECT MAX(C_Currency_ID), SUM(GrandTotal), MAX(MultiplierAP), MAX(Multiplier)
    INTO v_Currency_ID, v_TotalOpenAmt, v_MultiplierAP, v_MultiplierCM
  FROM C_Invoice_v  -- corrected for CM / Split Payment
  WHERE C_Invoice_ID = p_C_Invoice_ID
    AND DateAcct <= p_DateAcct;
 EXCEPTION -- Invoice in draft form
  WHEN OTHERS THEN
            --DBMS_OUTPUT.PUT_LINE('InvoiceOpen - ' || SQLERRM);
   RETURN NULL;
 END;
--  DBMS_OUTPUT.PUT_LINE('== C_Invoice_ID=' || p_C_Invoice_ID || ', Total=' || v_TotalOpenAmt || ', AP=' || v_MultiplierAP || ', CM=' || v_MultiplierCM);

	SELECT StdPrecision
	    INTO v_Precision
	    FROM C_Currency
	    WHERE C_Currency_ID = v_Currency_ID;

	SELECT 1/10^v_Precision INTO v_Min;

 -- Calculate Allocated Amount
 FOR allocationline IN
  SELECT a.AD_Client_ID, a.AD_Org_ID,
            al.Amount, al.DiscountAmt, al.WriteOffAmt,
            a.C_Currency_ID, a.DateTrx
  FROM C_ALLOCATIONLINE al
          INNER JOIN C_ALLOCATIONHDR a ON (al.C_AllocationHdr_ID=a.C_AllocationHdr_ID)
  WHERE al.C_Invoice_ID = p_C_Invoice_ID
    AND a.DateAcct <= p_DateAcct
    AND   a.IsActive='Y'
 LOOP
        v_Temp := allocationline.Amount + allocationline.DisCountAmt + allocationline.WriteOffAmt;
  v_PaidAmt := v_PaidAmt
        -- Allocation
   + Currencyconvert(v_Temp * v_MultiplierAP,
    allocationline.C_Currency_ID, v_Currency_ID, allocationline.DateTrx, NULL, allocationline.AD_Client_ID, allocationline.AD_Org_ID);
      --DBMS_OUTPUT.PUT_LINE('   PaidAmt=' || v_PaidAmt || ', Allocation=' || v_Temp || ' * ' || v_MultiplierAP);
 END LOOP;

    --  Do we have a Payment Schedule ?
    IF (p_C_InvoicePaySchedule_ID > 0) THEN --   if not valid = lists invoice amount
        v_Remaining := v_PaidAmt;
        FOR invoiceschedule IN
        SELECT  C_InvoicePaySchedule_ID, DueAmt FROM    C_INVOICEPAYSCHEDULE WHERE C_Invoice_ID = p_C_Invoice_ID AND IsValid='Y'
        ORDER BY DueDate
        LOOP
            IF (invoiceschedule.C_InvoicePaySchedule_ID = p_C_InvoicePaySchedule_ID) THEN
                v_TotalOpenAmt := (invoiceschedule.DueAmt*v_MultiplierCM) - v_Remaining;
                IF (invoiceschedule.DueAmt - v_Remaining < 0) THEN
                    v_TotalOpenAmt := 0;
                END IF;
            --  DBMS_OUTPUT.PUT_LINE('Sched Total=' || v_TotalOpenAmt || ', Due=' || s.DueAmt || ',Remaining=' || v_Remaining || ',CM=' || v_MultiplierCM);
            ELSE -- calculate amount, which can be allocated to next schedule
                v_Remaining := v_Remaining - invoiceschedule.DueAmt;
                IF (v_Remaining < 0) THEN
                    v_Remaining := 0;
                END IF;
            --  DBMS_OUTPUT.PUT_LINE('Remaining=' || v_Remaining);
            END IF;
        END LOOP;
    ELSE
        v_TotalOpenAmt := v_TotalOpenAmt - v_PaidAmt;
    END IF;
--  DBMS_OUTPUT.PUT_LINE('== Total=' || v_TotalOpenAmt);

	--	Ignore Rounding
	IF (v_TotalOpenAmt > -v_Min AND v_TotalOpenAmt < v_Min) THEN
		v_TotalOpenAmt := 0;
	END IF;

	--	Round to currency precision
	v_TotalOpenAmt := ROUND(COALESCE(v_TotalOpenAmt,0), v_Precision);

	RETURN v_TotalOpenAmt;
END;
$$;

CREATE OR REPLACE FUNCTION invoicepaid(p_c_invoice_id numeric, p_c_currency_id numeric, p_multiplierap numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
/*************************************************************************
 * The contents of this file are subject to the Compiere License.  You may
 * obtain a copy of the License at    http://www.compiere.org/license.html
 * Software is on an  "AS IS" basis,  WITHOUT WARRANTY OF ANY KIND, either
 * express or implied. See the License for details. Code: Compiere ERP+CRM
 * Copyright (C) 1999-2001 Jorg Janke, ComPiere, Inc. All Rights Reserved.
 *
 * converted to postgreSQL by Karsten Thiemann (Schaeffer AG),
 * kthiemann@adempiere.org
 *************************************************************************
 ***
 * Title:	Calculate Paid/Allocated amount in Currency
 * Description:
 *	Add up total amount paid for for C_Invoice_ID.
 *  Split Payments are ignored.
 *  all allocation amounts  converted to invoice C_Currency_ID
 *	round it to the nearest cent
 *	and adjust for CreditMemos by using C_Invoice_v
 *  and for Payments with the multiplierAP (-1, 1)
 *
 *
 * Test:
    SELECT C_Invoice_ID, IsPaid, IsSOTrx, GrandTotal,
    invoicePaid (C_Invoice_ID, C_Currency_ID, MultiplierAP)
    FROM C_Invoice_v;
 *
 ************************************************************************/
DECLARE
	v_Precision         NUMERIC := 0;
    v_Min            	NUMERIC := 0;
	v_MultiplierAP		NUMERIC := 1;
	v_PaymentAmt		NUMERIC := 0;
	ar			RECORD;

BEGIN
	SELECT StdPrecision
	    INTO v_Precision
	    FROM C_Currency
	    WHERE C_Currency_ID = p_C_Currency_ID;

	SELECT 1/10^v_Precision INTO v_Min;

	--	Default
	IF (p_MultiplierAP IS NOT NULL) THEN
		v_MultiplierAP := p_MultiplierAP;
	END IF;
	--	Calculate Allocated Amount
	FOR ar IN
		SELECT	a.AD_Client_ID, a.AD_Org_ID,
		al.Amount, al.DiscountAmt, al.WriteOffAmt,
		a.C_Currency_ID, a.DateTrx
		FROM	C_AllocationLine al
		INNER JOIN C_AllocationHdr a ON (al.C_AllocationHdr_ID=a.C_AllocationHdr_ID)
		WHERE	al.C_Invoice_ID = p_C_Invoice_ID
		AND   a.IsActive='Y'
	LOOP
		v_PaymentAmt := v_PaymentAmt
			+ currencyConvert(ar.Amount + ar.DisCountAmt + ar.WriteOffAmt,
				ar.C_Currency_ID, p_C_Currency_ID, ar.DateTrx, null, ar.AD_Client_ID, ar.AD_Org_ID);
	END LOOP;

	--	Ignore Rounding
	IF (v_PaymentAmt > -v_Min AND v_PaymentAmt < v_Min) THEN
		v_PaymentAmt := 0;
	END IF;

	--	Round to currency precision
	v_PaymentAmt := ROUND(COALESCE(v_PaymentAmt,0), v_Precision);

	RETURN	v_PaymentAmt * v_MultiplierAP;
END;

$$;

CREATE OR REPLACE FUNCTION invoicepaidtodate(p_c_invoice_id numeric, p_c_currency_id numeric, p_multiplierap numeric, p_dateacct timestamp with time zone) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
DECLARE
	v_Precision         NUMERIC := 0;
    v_Min            	NUMERIC := 0;
	v_MultiplierAP		numeric := 1;
	v_PaymentAmt		numeric := 0;
	allocation 		record;
BEGIN
	SELECT StdPrecision
	    INTO v_Precision
	    FROM C_Currency
	    WHERE C_Currency_ID = p_C_Currency_ID;

	SELECT 1/10^v_Precision INTO v_Min;

	--	Default
	IF (p_MultiplierAP IS NOT NULL) THEN
		v_MultiplierAP := p_MultiplierAP;
	END IF;
	--	Calculate Allocated Amount
	FOR allocation IN
	SELECT	al.AD_Client_ID, al.AD_Org_ID,al.Amount, al.DiscountAmt, al.WriteOffAmt,a.C_Currency_ID, a.DateTrx
	FROM	C_ALLOCATIONLINE al
	INNER JOIN C_ALLOCATIONHDR a ON (al.C_AllocationHdr_ID=a.C_AllocationHdr_ID)
    WHERE	al.C_Invoice_ID = p_C_Invoice_ID AND   a.IsActive='Y' AND a.DateAcct <= p_DateAcct
	LOOP
		v_PaymentAmt := v_PaymentAmt
			+ Currencyconvert(allocation.Amount + allocation.DisCountAmt + allocation.WriteOffAmt,
				allocation.C_Currency_ID, p_C_Currency_ID, allocation.DateTrx, NULL, allocation.AD_Client_ID, allocation.AD_Org_ID);
	END LOOP;

	--	Ignore Rounding
	IF (v_PaymentAmt > -v_Min AND v_PaymentAmt < v_Min) THEN
		v_PaymentAmt := 0;
	END IF;

	--	Round to currency precision
	v_PaymentAmt := ROUND(COALESCE(v_PaymentAmt,0), v_Precision);

	RETURN	v_PaymentAmt * v_MultiplierAP;
END;
$$;

CREATE OR REPLACE FUNCTION invoicewriteoff(p_c_invoice_id numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
DECLARE
    v_Amount NUMERIC;
    v_ClientId C_Invoice.AD_Client_ID%TYPE;
    custom_function AD_SysConfig.Value%TYPE;
    command VARCHAR(1000);
BEGIN
    SELECT AD_Client_ID INTO v_ClientId FROM C_Invoice WHERE C_Invoice_ID=p_C_Invoice_ID;
    custom_function := get_Sysconfig('PAYSELECTION_CUSTOM_INVOICEWRITEOFF_FUNCTION', '', v_ClientId, 0);
    IF LENGTH(custom_function) > 0
    THEN
	command := 'SELECT '||custom_function||'('||p_C_Invoice_ID||')';
        EXECUTE command INTO v_Amount;
    ELSE
        v_Amount := 0;
    END IF;
    RETURN v_Amount;
END;
$$;

CREATE OR REPLACE FUNCTION ismemberofacctschema(p_ad_client_id numeric, p_ad_org_id numeric, p_c_acctschema_id numeric) RETURNS boolean
	LANGUAGE plpgsql
AS
$$
DECLARE
 v_ad_org_id numeric;
 v_count numeric;
BEGIN
v_ad_org_id = -1;
v_count = 0;

SELECT count(*) into v_count from C_AcctSchema c
Where C_AcctSchema_ID <> p_C_AcctSchema_ID
and AD_OrgOnly_ID= p_AD_Org_ID;


if (v_count = 0 ) Then
  WITH RECURSIVE tr( ad_org_id) as (
	select tn.node_id
	from ad_tree t
	join ad_treenode tn on t.ad_tree_id=tn.ad_tree_id
	join ad_org on tn.node_id=ad_org.ad_org_id
	join c_acctschema ca on ad_org.ad_org_id=ca.AD_OrgOnly_ID and ca.C_AcctSchema_ID=p_C_AcctSchema_ID
	where t.treetype='OO' AND t.ad_client_id= p_AD_Client_ID
	and ((tn.parent_id = 0 and ad_org.issummary='Y') or (ad_org.ad_org_id=p_AD_Org_ID))
   UNION select tn.node_id
	from ad_tree t
	join ad_treenode tn on t.ad_tree_id=tn.ad_tree_id
	join ad_org on tn.node_id=ad_org.ad_org_id
	join tr on tr.ad_org_id=tn.parent_id
	where tn.node_id=p_AD_Org_ID)
	select ad_org_id into v_ad_org_id from tr where ad_org_id=p_ad_org_id;
End If;
   return v_ad_org_id=p_ad_org_id;
END;
$$;

CREATE OR REPLACE FUNCTION migr_fix_payment_cashline() RETURNS void
	LANGUAGE plpgsql
AS
$$
DECLARE
   rc	      RECORD;
   rp	      RECORD;
BEGIN
   FOR rc IN (SELECT cl.C_CashLine_ID, c.NAME, cl.amount,
                     cl.C_BankAccount_ID, cl.AD_Client_ID
                FROM C_CASHLINE cl INNER JOIN C_CASH c
                     ON (c.C_Cash_ID = cl.C_Cash_ID)
               WHERE cl.CashType = 'T' AND cl.C_Payment_ID IS NULL)
   LOOP
      FOR rp IN (SELECT c_payment_id
                   FROM C_PAYMENT p
                  WHERE p.DocumentNo = rc.NAME
                    AND R_PnRef = rc.NAME
                    AND PayAmt = -rc.amount
                    AND C_BankAccount_ID = rc.C_BankAccount_ID
                    AND AD_Client_ID = rc.AD_Client_ID
                    AND TrxType = 'X'
                    AND TenderType = 'X')
      LOOP
         UPDATE C_CASHLINE
            SET C_Payment_ID = rp.C_Payment_ID
          WHERE C_CASHLINE_ID = rc.C_CashLine_ID;
      END LOOP;
   END LOOP;
END;
$$;

CREATE OR REPLACE FUNCTION nextbusinessday(p_date timestamp with time zone, p_ad_client_id numeric) RETURNS timestamp with time zone
	STABLE
	LANGUAGE plpgsql
AS
$$
/**
*This file is part of Adempiere ERP Bazaar
*http://www.adempiere.org
*
*Copyright (C) 2007 Teo Sarca
*
*This program is free software; you can redistribute it and/or
*modify it under the terms of the GNU General Public License
*as published by the Free Software Foundation; either version 2
*of the License, or (at your option) any later version.
*
*This program is distributed in the hope that it will be useful,
*but WITHOUT ANY WARRANTY; without even the implied warranty of
*MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
*GNU General Public License for more details.
*
*You should have received a copy of the GNU General Public License
*along with this program; if not, write to the Free Software
*Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.of
*
* Converted to PostgreSQL by Tony Snook,
* tspc@dodo.com.au
*/
DECLARE
	v_nextDate	date := trunc(p_Date);
	v_offset	numeric	:= 0;
	v_Saturday	numeric	:= TO_CHAR(TO_DATE('2000-01-01', 'YYYY-MM-DD'), 'D');
	v_Sunday	numeric	:= (case when v_Saturday = 7 then 1 else v_Saturday + 1 end);
	v_isHoliday	boolean	:= true;
	v_country       c_country.c_country_id%type;
	nbd C_NonBusinessDay%ROWTYPE;
begin
	v_isHoliday := true;
	loop
		SELECT	CASE TO_CHAR(v_nextDate,'D')::numeric
					WHEN v_Saturday THEN 2
					WHEN v_Sunday THEN 1
					ELSE 0
				END INTO v_offset;
		v_nextDate := v_nextDate + v_offset::integer;
		v_isHoliday := false;
		SELECT COALESCE(MAX(co.c_country_id), 100)
		INTO   v_country
		FROM   ad_client cl
		       JOIN ad_language l ON cl.ad_language = l.ad_language
		       JOIN c_country co ON l.countrycode = co.countrycode
		WHERE  cl.ad_client_id = p_ad_client_id;
		FOR nbd IN	SELECT *
					FROM C_NonBusinessDay
					WHERE AD_Client_ID=p_AD_Client_ID and IsActive ='Y' and Date1 >= v_nextDate
					    AND COALESCE(C_Country_ID,0) IN (0, v_country)
					ORDER BY Date1
		LOOP
			exit when v_nextDate <> trunc(nbd.Date1);
			v_nextDate := v_nextDate + 1;
			v_isHoliday := true;
		end loop;
		exit when v_isHoliday=false;
	end loop;
	--
	return v_nextDate::timestamp with time zone;
end;
$$;

CREATE OR REPLACE FUNCTION nextid(p_ad_sequence_id integer, p_system character varying, OUT o_nextid integer) RETURNS integer
	LANGUAGE plpgsql
AS
$$
/*************************************************************************
 * The contents of this file are subject to the Compiere License.  You may
 * obtain a copy of the License at    http://www.compiere.org/license.html
 * Software is on an  "AS IS" basis,  WITHOUT WARRANTY OF ANY KIND, either
 * express or implied. See the License for details. Code: Compiere ERP+CRM
 * Copyright (C) 1999-2005 Jorg Janke, ComPiere, Inc. All Rights Reserved.
 *
 * converted to postgreSQL by Karsten Thiemann (Schaeffer AG),
 * kthiemann@adempiere.org
 *************************************************************************
 ***
 * Title:	Get Next ID - no Commit
 * Description: Returns the next id of the sequence.
 * Test:
 *	select * from nextid((select ad_sequence_id from ad_sequence where name = 'Test')::Integer, 'Y'::Varchar);
 *
 ************************************************************************/
DECLARE
Isnativeseqon VARCHAR(1);
tablename     VARCHAR(60);
BEGIN
    IF (p_System = 'Y') THEN
	RAISE NOTICE 'system';
        SELECT CurrentNextSys
            INTO o_NextID
        FROM AD_Sequence
        WHERE AD_Sequence_ID=p_AD_Sequence_ID;
        --
        UPDATE AD_Sequence
          SET CurrentNextSys = CurrentNextSys + IncrementNo
        WHERE AD_Sequence_ID=p_AD_Sequence_ID;
    ELSE

        Isnativeseqon := get_Sysconfig('SYSTEM_NATIVE_SEQUENCE','N',0,0);
        IF Isnativeseqon = 'Y' THEN
          SELECT Name
            INTO tablename
            FROM Ad_Sequence
           WHERE Ad_Sequence_Id=P_Ad_Sequence_Id;
	   --
	   EXECUTE 'SELECT nextval('''||tablename||'_sq'''||')' INTO o_NextID;
	   --
       ELSE
          SELECT CurrentNext
            INTO o_NextID
            FROM AD_Sequence
           WHERE AD_Sequence_ID=p_AD_Sequence_ID;
          --
          UPDATE AD_Sequence
             SET CurrentNext = CurrentNext + IncrementNo
           WHERE AD_Sequence_ID=p_AD_Sequence_ID;
       END IF;
    END IF;
    --
EXCEPTION
    WHEN  OTHERS THEN
    	RAISE NOTICE '%',SQLERRM;
END;

$$;

CREATE OR REPLACE FUNCTION nextidfunc(p_ad_sequence_id integer, p_system character varying) RETURNS integer
	LANGUAGE plpgsql
AS
$$
DECLARE
          o_NextIDFunc INTEGER;
	  dummy INTEGER;
BEGIN
    o_NextIDFunc := nextid(p_AD_Sequence_ID, p_System);
    RETURN o_NextIDFunc;
END;
$$;

CREATE OR REPLACE FUNCTION nvl(anyelement, anyelement) RETURNS anyelement
	IMMUTABLE
	LANGUAGE plpgsql
AS
$$
BEGIN
    RETURN coalesce($1, $2);
END;
$$;

CREATE OR REPLACE FUNCTION nvl(integer, numeric) RETURNS numeric
	IMMUTABLE
	LANGUAGE plpgsql
AS
$$
BEGIN
    RETURN nvl($1::numeric, $2);
END;
$$;

CREATE OR REPLACE FUNCTION nvl(numeric, integer) RETURNS numeric
	IMMUTABLE
	LANGUAGE plpgsql
AS
$$
BEGIN
    RETURN nvl($1, $2::numeric);
END;
$$;

CREATE OR REPLACE FUNCTION paymentallocated(p_c_payment_id numeric, p_c_currency_id numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
/*************************************************************************
 * The contents of this file are subject to the Compiere License.  You may
 * obtain a copy of the License at    http://www.compiere.org/license.html
 * Software is on an  "AS IS" basis,  WITHOUT WARRANTY OF ANY KIND, either
 * express or implied. See the License for details. Code: Compiere ERP+CRM
 * Copyright (C) 1999-2001 Jorg Janke, ComPiere, Inc. All Rights Reserved.
 *
 * converted to postgreSQL by Karsten Thiemann (Schaeffer AG),
 * kthiemann@adempiere.org
 *************************************************************************
 * Title:	Calculate Allocated Payment Amount in Payment Currency
 * Description:
    --
    SELECT paymentAllocated(C_Payment_ID,C_Currency_ID), PayAmt, IsAllocated
    FROM C_Payment_v
    WHERE C_Payment_ID<1000000;
    --
    UPDATE C_Payment_v
    SET IsAllocated=CASE WHEN paymentAllocated(C_Payment_ID, C_Currency_ID)=PayAmt THEN 'Y' ELSE 'N' END
    WHERE C_Payment_ID>=1000000;

 ************************************************************************/
DECLARE
	v_Precision         NUMERIC := 0;
    v_Min            	NUMERIC := 0;
	v_AllocatedAmt		NUMERIC := 0;
    	v_PayAmt        	NUMERIC;
    	r   			RECORD;
BEGIN
	SELECT StdPrecision
	    INTO v_Precision
	    FROM C_Currency
	    WHERE C_Currency_ID = p_C_Currency_ID;

	SELECT 1/10^v_Precision INTO v_Min;

    --  Charge - nothing available
    SELECT
      INTO v_PayAmt MAX(PayAmt)
    FROM C_Payment
    WHERE C_Payment_ID=p_C_Payment_ID AND C_Charge_ID > 0;

    IF (v_PayAmt IS NOT NULL) THEN
        RETURN v_PayAmt;
    END IF;

	--	Calculate Allocated Amount
	FOR r IN
		SELECT	a.AD_Client_ID, a.AD_Org_ID, al.Amount, a.C_Currency_ID, a.DateTrx
			FROM	C_AllocationLine al
	          INNER JOIN C_AllocationHdr a ON (al.C_AllocationHdr_ID=a.C_AllocationHdr_ID)
			WHERE	al.C_Payment_ID = p_C_Payment_ID
          	AND   a.IsActive='Y'
	LOOP
		v_AllocatedAmt := v_AllocatedAmt
			+ currencyConvert(r.Amount, r.C_Currency_ID, p_C_Currency_ID, r.DateTrx, null, r.AD_Client_ID, r.AD_Org_ID);
	END LOOP;

	--	Ignore Rounding
	IF (v_AllocatedAmt > -v_Min AND v_AllocatedAmt < v_Min) THEN
		v_AllocatedAmt := 0;
	END IF;

	--	Round to currency precision
	v_AllocatedAmt := ROUND(COALESCE(v_AllocatedAmt,0), v_Precision);

	RETURN	v_AllocatedAmt;
END;

$$;

CREATE OR REPLACE FUNCTION paymentavailable(p_c_payment_id numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
/*************************************************************************
 * The contents of this file are subject to the Compiere License.  You may
 * obtain a copy of the License at    http://www.compiere.org/license.html
 * Software is on an  "AS IS" basis,  WITHOUT WARRANTY OF ANY KIND, either
 * express or implied. See the License for details. Code: Compiere ERP+CRM
 * Copyright (C) 1999-2001 Jorg Janke, ComPiere, Inc. All Rights Reserved.
 *
 * converted to postgreSQL by Karsten Thiemann (Schaeffer AG),
 * kthiemann@adempiere.org
 *************************************************************************
 * Title:	Calculate Available Payment Amount in Payment Currency
 * Description:
 *		similar to C_Invoice_Open
 ************************************************************************/
DECLARE
	v_Currency_ID		NUMERIC(10);
	v_Precision         NUMERIC := 0;
    v_Min            	NUMERIC := 0;
	v_AvailableAmt		NUMERIC := 0;
    	v_IsReceipt         	C_Payment.IsReceipt%TYPE;
    	v_Amt               	NUMERIC := 0;
    	r   			RECORD;

BEGIN
    --  Charge - fully allocated
    SELECT MAX(PayAmt)
      INTO v_Amt
    FROM C_Payment
    WHERE C_Payment_ID=p_C_Payment_ID AND C_Charge_ID > 0;
    IF (v_Amt IS NOT NULL) THEN
        RETURN 0;
    END IF;

	--	Get Currency
	SELECT	C_Currency_ID, PayAmt, IsReceipt
	  INTO	v_Currency_ID, v_AvailableAmt, v_IsReceipt
	FROM	C_Payment_v     -- corrected for AP/AR
	WHERE	C_Payment_ID = p_C_Payment_ID;
--  DBMS_OUTPUT.PUT_LINE('== C_Payment_ID=' || p_C_Payment_ID || ', PayAmt=' || v_AvailableAmt || ', Receipt=' || v_IsReceipt);

	SELECT StdPrecision
	    INTO v_Precision
	    FROM C_Currency
	    WHERE C_Currency_ID = v_Currency_ID;

	SELECT 1/10^v_Precision INTO v_Min;

	--	Calculate Allocated Amount
	FOR r IN
		SELECT	a.AD_Client_ID, a.AD_Org_ID, al.Amount, a.C_Currency_ID, a.DateTrx
		FROM	C_AllocationLine al
	        INNER JOIN C_AllocationHdr a ON (al.C_AllocationHdr_ID=a.C_AllocationHdr_ID)
		WHERE	al.C_Payment_ID = p_C_Payment_ID
          	AND   a.IsActive='Y'
	LOOP
        v_Amt := currencyConvert(r.Amount, r.C_Currency_ID, v_Currency_ID, r.DateTrx, null, r.AD_Client_ID, r.AD_Org_ID);
	    v_AvailableAmt := v_AvailableAmt - v_Amt;
--      DBMS_OUTPUT.PUT_LINE('  Allocation=' || a.Amount || ' - Available=' || v_AvailableAmt);
	END LOOP;

	--	Ignore Rounding
	IF (v_AvailableAmt > -v_Min AND v_AvailableAmt < v_Min) THEN
		v_AvailableAmt := 0;
	END IF;

	--	Round to currency precision
	v_AvailableAmt := ROUND(COALESCE(v_AvailableAmt,0), v_Precision);

	RETURN	v_AvailableAmt;
END;

$$;

CREATE OR REPLACE FUNCTION paymenttermdiscount(amount numeric, currency_id numeric, paymentterm_id numeric, docdate timestamp with time zone, paydate timestamp with time zone) RETURNS numeric
	LANGUAGE plpgsql
AS
$$
/*************************************************************************
 * The contents of this file are subject to the Compiere License.  You may
 * obtain a copy of the License at    http://www.compiere.org/license.html
 * Software is on an  "AS IS" basis,  WITHOUT WARRANTY OF ANY KIND, either
 * express or implied. See the License for details. Code: Compiere ERP+CRM
 * Copyright (C) 1999-2001 Jorg Janke, ComPiere, Inc. All Rights Reserved.
 *
 * converted to postgreSQL by Karsten Thiemann (Schaeffer AG),
 * kthiemann@adempiere.org
 *************************************************************************
 * Title:	Calculate Discount
 * Description:
 *	Calculate the allowable Discount Amount of the Payment Term
 *
 *	Test:	SELECT paymenttermDiscount(110, 103, 106, now(), now()) FROM TEST; => 2.20
 ************************************************************************/

DECLARE
	v_Precision		NUMERIC := 0;
	v_Currency		NUMERIC := 0;
    v_Min			NUMERIC := 0;
	Discount		NUMERIC := 0;
	Discount1Date		timestamp with time zone;
	Discount2Date		timestamp with time zone;
	Add1Date		NUMERIC := 0;
	Add2Date		NUMERIC := 0;
	p   			RECORD;
BEGIN
	v_Currency := Currency_ID;
	IF (v_Currency = 0) THEN
		SELECT COALESCE(MAX(C_Currency_ID),0)
		INTO v_Currency
		FROM AD_ClientInfo ci, C_AcctSchema s, C_PaymentTerm pt
		WHERE ci.AD_Client_ID = s.AD_Client_ID
		AND ci.AD_Client_ID = pt.AD_Client_ID
		AND pt.C_PaymentTerm_ID = PaymentTerm_ID;
	END IF;

	SELECT StdPrecision
	    INTO v_Precision
	    FROM C_Currency
	    WHERE C_Currency_ID = v_Currency;

	SELECT 1/10^v_Precision INTO v_Min;

	--	No Data - No Discount
	IF (Amount IS NULL OR PaymentTerm_ID IS NULL OR DocDate IS NULL) THEN
		RETURN 0;
	END IF;

	FOR p IN
		SELECT	*
		FROM	C_PaymentTerm
		WHERE	C_PaymentTerm_ID = PaymentTerm_ID
	LOOP	--	for convineance only
		Discount1Date := TRUNC(DocDate + p.DiscountDays + p.GraceDays);
		Discount2Date := TRUNC(DocDate + p.DiscountDays2 + p.GraceDays);

		--	Next Business Day
		IF (p.IsNextBusinessDay='Y') THEN
			Discount1Date := nextBusinessDay(Discount1Date, p.AD_Client_ID);
			Discount2Date := nextBusinessDay(Discount2Date, p.AD_Client_ID);
		END IF;

		--	Discount 1
		IF (Discount1Date >= TRUNC(PayDate)) THEN
			Discount := Amount * p.Discount / 100;
		--	Discount 2
		ELSIF (Discount2Date >= TRUNC(PayDate)) THEN
			Discount := Amount * p.Discount2 / 100;
		END IF;
	END LOOP;

	--	Ignore Rounding
	IF (Discount > -v_Min AND Discount < v_Min) THEN
		Discount := 0;
	END IF;

	--	Round to currency precision
	Discount := ROUND(COALESCE(Discount,0), v_Precision);

	RETURN	Discount;
END;

$$;

CREATE OR REPLACE FUNCTION paymenttermduedate(paymentterm_id numeric, docdate timestamp with time zone) RETURNS timestamp with time zone
	STABLE
	LANGUAGE plpgsql
AS
$$
/*************************************************************************
 * The contents of this file are subject to the Compiere License.  You may
 * obtain a copy of the License at    http://www.compiere.org/license.html
 * Software is on an  "AS IS" basis,  WITHOUT WARRANTY OF ANY KIND, either
 * express or implied. See the License for details. Code: Compiere ERP+CRM
 * Copyright (C) 1999-2001 Jorg Janke, ComPiere, Inc. All Rights Reserved.
 *
 * converted to postgreSQL by Karsten Thiemann (Schaeffer AG),
 * kthiemann@adempiere.org
 *************************************************************************
 * Title:	Get Due timestamp with time zone
 * Description:
 *	Returns the due timestamp with time zone
 * Test:
 *	select paymenttermDueDate(106, now()) from Test; => now()+30 days
 ************************************************************************/
DECLARE
 	Days				NUMERIC := 0;
	DueDate				timestamp with time zone := TRUNC(DocDate);
	--
	FirstDay			timestamp with time zone;
	NoDays				NUMERIC;
	p   			RECORD;
BEGIN
	FOR p IN
		SELECT	*
		FROM	C_PaymentTerm
		WHERE	C_PaymentTerm_ID = PaymentTerm_ID
	LOOP	--	for convineance only
		--	Due 15th of following month
		IF (p.IsDueFixed = 'Y') THEN
			FirstDay := TRUNC(DocDate, 'MM');
			NoDays := EXTRACT(day FROM TRUNC(DocDate) - FirstDay);
			DueDate := FirstDay + (p.FixMonthDay-1);	--	starting on 1st
			DueDate := ADD_MONTHS(DueDate, p.FixMonthOffset);
			IF (NoDays > p.FixMonthCutoff) THEN
				DueDate := ADD_MONTHS(DueDate, 1);
			END IF;
		ELSE
			DueDate := TRUNC(DocDate) + p.NetDays;
		END IF;
	END LOOP;
	RETURN DueDate;
END;
$$;

CREATE OR REPLACE FUNCTION paymenttermduedays(paymentterm_id numeric, docdate timestamp with time zone, paydate timestamp with time zone) RETURNS integer
	STABLE
	LANGUAGE plpgsql
AS
$$
/*************************************************************************
 * The contents of this file are subject to the Compiere License.  You may
 * obtain a copy of the License at    http://www.compiere.org/license.html
 * Software is on an  "AS IS" basis,  WITHOUT WARRANTY OF ANY KIND, either
 * express or implied. See the License for details. Code: Compiere ERP+CRM
 * Copyright (C) 1999-2001 Jorg Janke, ComPiere, Inc. All Rights Reserved.
 *
 * converted to postgreSQL by Karsten Thiemann (Schaeffer AG),
 * kthiemann@adempiere.org
 *************************************************************************
 * Title:	Get Due Days
 * Description:
 *	Returns the days due (positive) or the days till due (negative)
 *	Grace days are not considered!
 *	If record is not found it assumes due immediately
 *
 *	Test:	SELECT paymenttermDueDays(103, now(), now());
 *
 * Contributor(s): Carlos Ruiz - globalqss - match with SQLJ version
 ************************************************************************/
DECLARE
 	Days			NUMERIC := 0;
	DueDate			timestamp with time zone := NULL;
	calDueDate		timestamp with time zone;
	FixMonthOffset		C_PaymentTerm.FixMonthOffset%TYPE;
	MaxDayCut		NUMERIC;
	MaxDay			NUMERIC;
	v_PayDate		timestamp with time zone;
	p   			RECORD;
	--
	FirstDay			timestamp with time zone;
	NoDays				NUMERIC;
BEGIN

    	IF PaymentTerm_ID = 0 OR DocDate IS NULL THEN
	    RETURN 0;
	END IF;

    	v_PayDate := PayDate;
	IF v_PayDate IS NULL THEN
	    v_PayDate := TRUNC(now());
	END IF;

	FOR p IN
		SELECT	*
		FROM	C_PaymentTerm
		WHERE	C_PaymentTerm_ID = PaymentTerm_ID
	LOOP	--	for convineance only

		--	Due 15th of following month
		IF (p.IsDueFixed = 'Y') THEN
			FirstDay := TRUNC(DocDate, 'MM');
			NoDays := extract (day from (TRUNC(DocDate) - FirstDay));
			DueDate := FirstDay + (p.FixMonthDay-1);	--	starting on 1st
			DueDate := DueDate + (p.FixMonthOffset || ' month')::interval;

			IF (NoDays > p.FixMonthCutoff) THEN
				DueDate := DueDate + '1 month'::interval;
			END IF;
			-- raise notice 'FirstDay: %, NoDays: %, DueDate: %', FirstDay, NoDays, DueDate;

			calDueDate := TRUNC(DocDate);
			MaxDayCut := extract (day from (cast(date_trunc('month', calDueDate) + '1 month'::interval as date) - 1));
			-- raise notice 'last day(MaxDayCut): %' , MaxDayCut;

			IF p.FixMonthCutoff > MaxDayCut THEN
				-- raise notice 'p.FixMonthCutoff > MaxDayCut';
			    calDueDate := cast(date_trunc('month', TRUNC(calDueDate)) + '1 month'::interval as date) - 1;
				-- raise notice 'last day(calDueDate): %' , calDueDate;
			ELSE
			    -- set day fixmonthcutoff on duedate
			    calDueDate := TRUNC(calDueDate, 'MM') + (((p.FixMonthCutoff-1)|| ' days')::interval);
			    -- raise notice 'calDueDate: %' , calDueDate;

			END IF;
			FixMonthOffset := p.FixMonthOffset;
			IF DocDate > calDueDate THEN
			    FixMonthOffset := FixMonthOffset + 1;
				raise notice 'FixMonthOffset: %' , FixMonthOffset;
			END IF;

			calDueDate := calDueDate + (FixMonthOffset || ' month')::interval;
			-- raise notice 'calDueDate: %' , calDueDate;

			MaxDay := extract (day from (cast(date_trunc('month', calDueDate) + '1 month'::interval as date) - 1));


			IF    (p.FixMonthDay > MaxDay)    --	32 -> 28
			   OR (p.FixMonthDay >= 30 AND MaxDay > p.FixMonthDay) THEN  	--	30 -> 31
				calDueDate := TRUNC(calDueDate, 'MM') + (((MaxDay-1)|| ' days')::interval);
				-- raise notice 'calDueDate: %' , calDueDate;
			ELSE
				calDueDate := TRUNC(calDueDate, 'MM') + (((p.FixMonthDay-1)|| ' days')::interval);
				-- raise notice 'calDueDate: %' , calDueDate;
			END IF;
			DueDate := calDueDate;

		ELSE
			DueDate := TRUNC(DocDate) + p.NetDays;
		END IF;
	END LOOP;

    IF DueDate IS NULL THEN
	    RETURN 0;
	END IF;


	Days := EXTRACT(day from (TRUNC(v_PayDate) - DueDate));
	RETURN Days;
END;

$$;

CREATE OR REPLACE FUNCTION prodqtyordered(p_product_id numeric, p_warehouse_id numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
DECLARE
	v_Warehouse_ID			numeric;
 	v_Quantity			numeric := 99999;	--	unlimited
	v_IsBOM				CHAR(1);
	v_IsStocked			CHAR(1);
	v_ProductType			CHAR(1);
 	v_ProductQty			numeric;
	v_StdPrecision			int;
BEGIN
	--	Check Parameters
	v_Warehouse_ID := p_Warehouse_ID;
	IF (v_Warehouse_ID IS NULL) THEN
		RETURN 0;
	END IF;
--	DBMS_OUTPUT.PUT_LINE('Warehouse=' || v_Warehouse_ID);

	--	Check, if product exists and if it is stocked
	BEGIN
		SELECT	IsBOM, ProductType, IsStocked
		  INTO	v_IsBOM, v_ProductType, v_IsStocked
		FROM M_PRODUCT
		WHERE M_Product_ID=p_Product_ID;
		--
	EXCEPTION	--	not found
		WHEN OTHERS THEN
			RETURN 0;
	END;

	--	No reservation for non-stocked
	IF (v_IsStocked='Y') THEN
		--	Get ProductQty
		SELECT 	COALESCE(SUM(MovementQty), 0)
		  INTO	v_ProductQty
		FROM 	M_ProductionLine p
		WHERE M_Product_ID=p_Product_ID AND MovementQty > 0 AND p.Processed = 'N'
		  AND EXISTS (SELECT * FROM M_LOCATOR l WHERE p.M_Locator_ID=l.M_Locator_ID
		  	AND l.M_Warehouse_ID=v_Warehouse_ID);
		--
		RETURN v_ProductQty;
	END IF;

	--	Unlimited (e.g. only services)
	IF (v_Quantity = 99999) THEN
		RETURN 0;
	END IF;

	IF (v_Quantity > 0) THEN
		--	Get Rounding Precision for Product
		SELECT 	COALESCE(MAX(u.StdPrecision), 0)
		  INTO	v_StdPrecision
		FROM 	C_UOM u, M_PRODUCT p
		WHERE 	u.C_UOM_ID=p.C_UOM_ID AND p.M_Product_ID=p_Product_ID;
		--
		RETURN ROUND (v_Quantity, v_StdPrecision);
	END IF;
	RETURN 0;
END;
$$;

CREATE OR REPLACE FUNCTION prodqtyreserved(p_product_id numeric, p_warehouse_id numeric) RETURNS numeric
	STABLE
	LANGUAGE plpgsql
AS
$$
DECLARE
	v_Warehouse_ID			numeric;
 	v_Quantity			numeric := 99999;	--	unlimited
	v_IsBOM				CHAR(1);
	v_IsStocked			CHAR(1);
	v_ProductType			CHAR(1);
 	v_ProductQty			numeric;
	v_StdPrecision			int;
BEGIN
	--	Check Parameters
	v_Warehouse_ID := p_Warehouse_ID;
	IF (v_Warehouse_ID IS NULL) THEN
		RETURN 0;
	END IF;
--	DBMS_OUTPUT.PUT_LINE('Warehouse=' || v_Warehouse_ID);

	--	Check, if product exists and if it is stocked
BEGIN
		SELECT	IsBOM, ProductType, IsStocked
		  INTO	v_IsBOM, v_ProductType, v_IsStocked
		FROM M_PRODUCT
		WHERE M_Product_ID=p_Product_ID;
		--
	EXCEPTION	--	not found
		WHEN OTHERS THEN
			RETURN 0;
	END;

	--	No reservation for non-stocked
	IF (v_IsStocked='Y') THEN
		--	Get ProductQty
		SELECT 	-1*COALESCE(SUM(MovementQty), 0)
		  INTO	v_ProductQty
		FROM 	M_ProductionLine p
		WHERE M_Product_ID=p_Product_ID AND MovementQty < 0 AND p.Processed = 'N'
		  AND EXISTS (SELECT * FROM M_LOCATOR l WHERE p.M_Locator_ID=l.M_Locator_ID
		  	AND l.M_Warehouse_ID=v_Warehouse_ID);
		--
		RETURN v_ProductQty;
	END IF;

	--	Unlimited (e.g. only services)
	IF (v_Quantity = 99999) THEN
	RETURN 0;
	END IF;

	IF (v_Quantity > 0) THEN
		--	Get Rounding Precision for Product
		SELECT 	COALESCE(MAX(u.StdPrecision), 0)
		  INTO	v_StdPrecision
		FROM 	C_UOM u, M_PRODUCT p
		WHERE 	u.C_UOM_ID=p.C_UOM_ID AND p.M_Product_ID=p_Product_ID;
		--
	RETURN ROUND (v_Quantity, v_StdPrecision);
	END IF;
	RETURN 0;
END;
$$;

CREATE OR REPLACE FUNCTION productattribute(p_m_attributesetinstance_id numeric) RETURNS character varying
	STABLE
	LANGUAGE plpgsql
AS
$$

/*************************************************************************
 * The contents of this file are subject to the Compiere License.  You may
 * obtain a copy of the License at    http://www.compiere.org/license.html
 * Software is on an  "AS IS" basis,  WITHOUT WARRANTY OF ANY KIND, either
 * express or implied. See the License for details. Code: Compiere ERP+CRM
 * Copyright (C) 1999-2001 Jorg Janke, ComPiere, Inc. All Rights Reserved.
 *
 * converted to postgreSQL by Karsten Thiemann (Schaeffer AG),
 * kthiemann@adempiere.org
 *************************************************************************
 * Title: Return Instance Attribute Info
 * Description:
 *
 * Test:
    SELECT ProductAttribute (M_AttributeSetInstance_ID)
    FROM M_InOutLine WHERE M_AttributeSetInstance_ID > 0
    --
    SELECT p.Name
    FROM C_InvoiceLine il LEFT OUTER JOIN M_Product p ON (il.M_Product_ID=p.M_Product_ID);
    SELECT p.Name || ProductAttribute (il.M_AttributeSetInstance_ID)
    FROM C_InvoiceLine il LEFT OUTER JOIN M_Product p ON (il.M_Product_ID=p.M_Product_ID);

 ************************************************************************/


DECLARE

    v_Name          VARCHAR(2000) := '';
    v_NameAdd       VARCHAR(2000) := '';
    --
    v_Lot           M_AttributeSetInstance.Lot%TYPE;
    v_LotStart      M_AttributeSet.LotCharSOverwrite%TYPE;
    v_LotEnd        M_AttributeSet.LotCharEOverwrite%TYPE;
    v_SerNo         M_AttributeSetInstance.SerNo%TYPE;
    v_SerNoStart    M_AttributeSet.SerNoCharSOverwrite%TYPE;
    v_SerNoEnd      M_AttributeSet.SerNoCharEOverwrite%TYPE;
    v_GuaranteeDate M_AttributeSetInstance.GuaranteeDate%TYPE;

    r   RECORD;
    --

BEGIN
    --  Get Product Attribute Set Instance
    IF (p_M_AttributeSetInstance_ID > 0) THEN
        SELECT asi.Lot, asi.SerNo, asi.GuaranteeDate,
            COALESCE(a.SerNoCharSOverwrite, '#'::CHAR(1)), COALESCE(a.SerNoCharEOverwrite, ''::CHAR(1)),
            COALESCE(a.LotCharSOverwrite, chr(171)), COALESCE(a.LotCharEOverwrite, chr(187))
          INTO v_Lot, v_SerNo, v_GuaranteeDate,
            v_SerNoStart, v_SerNoEnd, v_LotStart, v_LotEnd
        FROM M_AttributeSetInstance asi
          INNER JOIN M_AttributeSet a ON (asi.M_AttributeSet_ID=a.M_AttributeSet_ID)
        WHERE asi.M_AttributeSetInstance_ID=p_M_AttributeSetInstance_ID;
        --
        IF (v_SerNo IS NOT NULL) THEN
            v_NameAdd := v_NameAdd || v_SerNoStart || v_SerNo || v_SerNoEnd || ' ';
        END IF;
        IF (v_Lot IS NOT NULL) THEN
            v_NameAdd := v_NameAdd || v_LotStart || v_Lot || v_LotEnd || ' ';
        END IF;
        IF (v_GuaranteeDate IS NOT NULL) THEN
            v_NameAdd := v_NameAdd || v_GuaranteeDate || ' ';
        END IF;
        --

        FOR r IN
	     SELECT ai.Value, a.Name
	        FROM M_AttributeInstance ai
	        INNER JOIN M_Attribute a ON (ai.M_Attribute_ID=a.M_Attribute_ID AND a.IsInstanceAttribute='Y')
        	WHERE ai.M_AttributeSetInstance_ID=p_M_AttributeSetInstance_ID
    	LOOP
            v_NameAdd := v_NameAdd || r.Name || ':' || r.Value || ' ';
        END LOOP;
        --
        IF (LENGTH(v_NameAdd) > 0) THEN
            v_Name := v_Name || ' (' || TRIM(v_NameAdd) || ')';
	ELSE
	    v_Name := NULL;
        END IF;
    END IF;
    RETURN v_Name;
END;

$$;

CREATE OR REPLACE FUNCTION register_migration_script(p_script character varying) RETURNS character varying
	LANGUAGE plpgsql
AS
$$
DECLARE
    v_return CHARACTER VARYING;
    v_scriptid INTEGER;
BEGIN
    v_return := p_script || ' successfully registered';
    UPDATE AD_System
      SET LastMigrationScriptApplied=p_script
    WHERE LastMigrationScriptApplied<p_script
       OR LastMigrationScriptApplied IS NULL;
    SELECT MAX(AD_MigrationScript_ID)
	INTO v_scriptid
        FROM AD_MigrationScript
	WHERE Name = p_script;
    IF (v_scriptid IS NULL)
    THEN
        INSERT INTO ad_migrationscript
            (isapply, scriptroll, ad_migrationscript_uu,
             status, projectname, releaseno,
             name, filename, ad_client_id,
             ad_org_id, created, createdby,
             updated, updatedby, isactive,
             ad_migrationscript_id)
        VALUES
            ('Y', 'N', generate_uuid(),
             'CO', 'iDempiere', (select releaseno from ad_system),
             p_script, 'postgresql/'||p_script, 0,
             0, now(), 100,
             now(), 100, 'Y',
             nextidfunc(53081,'N'));
    ELSE
        v_return := p_script || ' was already applied';
        RAISE NOTICE '%', v_return;
	UPDATE ad_migrationscript
	    SET updated=now(), description = COALESCE(description, ' ') || ' reapplied'
	    WHERE ad_migrationscript_id = v_scriptid;
    END IF;
    RETURN v_return;
END;
$$;

CREATE OR REPLACE FUNCTION round(numeric, numeric) RETURNS numeric
	IMMUTABLE
	LANGUAGE plpgsql
AS
$$
 BEGIN
	RETURN ROUND($1, cast($2 as integer));
 END;
$$;

CREATE OR REPLACE FUNCTION subtractdays(inter interval, days numeric) RETURNS integer
	LANGUAGE plpgsql
AS
$$
BEGIN
RETURN ( EXTRACT( EPOCH FROM ( inter ) ) / 86400 ) - days;
END;
$$;

CREATE OR REPLACE FUNCTION subtractdays(day timestamp with time zone, days numeric) RETURNS date
	IMMUTABLE
	LANGUAGE plpgsql
AS
$$
BEGIN
    RETURN addDays(day,(days * -1));
END;
$$;

CREATE OR REPLACE FUNCTION trunc(datetime timestamp without time zone) RETURNS timestamp without time zone
	IMMUTABLE
	LANGUAGE plpgsql
AS
$$
BEGIN
        RETURN CAST(datetime AS DATE);
END;
$$;

CREATE OR REPLACE FUNCTION trunc(datetime timestamp with time zone, format character varying) RETURNS date
	IMMUTABLE
	LANGUAGE plpgsql
AS
$$
BEGIN
	IF format = 'Q' THEN
		RETURN CAST(DATE_Trunc('quarter',datetime) as DATE);
	ELSIF format = 'Y' or format = 'YEAR' THEN
		RETURN CAST(DATE_Trunc('year',datetime) as DATE);
	ELSIF format = 'MM' or format = 'MONTH' THEN
		RETURN CAST(DATE_Trunc('month',datetime) as DATE);
	ELSIF format = 'DD' THEN
		RETURN CAST(DATE_Trunc('day',datetime) as DATE);
	ELSIF format = 'DY' THEN
		RETURN CAST(DATE_Trunc('day',datetime) as DATE);
	ELSE
		RETURN CAST(datetime AS DATE);
	END IF;
END;
$$;

CREATE OR REPLACE FUNCTION currencyconvertinvoice(p_c_invoice_id numeric, p_currency_to_id numeric, p_amt numeric DEFAULT NULL::numeric, p_conversiondate timestamp with time zone DEFAULT NULL::timestamp with time zone) RETURNS numeric
	LANGUAGE plpgsql
AS
$$

DECLARE
	v_GrandTotal NUMERIC;
	v_ConversionType_ID NUMERIC;
	v_Client_ID NUMERIC;
	v_Org_ID NUMERIC;
	v_Currency_ID NUMERIC;
	v_CurrencyRate NUMERIC;
	v_DateAcct timestamp with time zone;
	v_BaseCurrency_ID NUMERIC;
	v_IsOverrideCurrencyRate character(1);
BEGIN
	SELECT AD_Client_ID, AD_Org_ID, DateAcct, C_Currency_ID, C_ConversionType_ID, CurrencyRate, GrandTotal, IsOverrideCurrencyRate
	INTO v_Client_ID, v_Org_ID, v_DateAcct, v_Currency_ID, v_ConversionType_ID, v_CurrencyRate, v_GrandTotal, v_IsOverrideCurrencyRate
	FROM C_Invoice
	WHERE C_Invoice_ID=p_C_Invoice_ID;

	SELECT sc.C_Currency_ID
	INTO v_BaseCurrency_ID
	FROM AD_ClientInfo ci
	JOIN C_AcctSchema sc ON ci.C_AcctSchema1_ID=sc.C_AcctSchema_ID
	WHERE ci.AD_Client_ID=v_Client_ID;

	IF v_BaseCurrency_ID=p_Currency_To_id AND Coalesce(v_CurrencyRate,0) > 0 AND v_Currency_ID != p_Currency_To_id AND v_IsOverrideCurrencyRate='Y' THEN
		RETURN currencyRound(Coalesce(p_Amt,v_GrandTotal)*v_CurrencyRate, p_Currency_To_id, null);
	END IF;

	RETURN currencyConvert(Coalesce(p_Amt,v_GrandTotal), v_Currency_ID, p_Currency_To_id, Coalesce(p_conversionDate,v_DateAcct), v_ConversionType_ID, v_Client_ID, v_Org_ID);
END;

$$;

CREATE OR REPLACE FUNCTION currencyconvertpayment(p_c_payment_id numeric, p_currency_to_id numeric, p_amt numeric DEFAULT NULL::numeric, p_conversiondate timestamp with time zone DEFAULT NULL::timestamp with time zone) RETURNS numeric
	LANGUAGE plpgsql
AS
$$
DECLARE
	v_PayAmt NUMERIC;
	v_ConversionType_ID NUMERIC;
	v_Client_ID NUMERIC;
	v_Org_ID NUMERIC;
	v_Currency_ID NUMERIC;
	v_CurrencyRate NUMERIC;
	v_ConvertedAmt NUMERIC;
	v_DateAcct timestamp with time zone;
	v_BaseCurrency_ID NUMERIC;
	v_IsOverrideCurrencyRate character(1);
BEGIN
	SELECT AD_Client_ID, AD_Org_ID, DateAcct, C_Currency_ID, C_ConversionType_ID, CurrencyRate, ConvertedAmt, PayAmt, IsOverrideCurrencyRate
	INTO v_Client_ID, v_Org_ID, v_DateAcct, v_Currency_ID, v_ConversionType_ID, v_CurrencyRate, v_ConvertedAmt, v_PayAmt, v_IsOverrideCurrencyRate
	FROM C_Payment
	WHERE C_Payment_ID=p_C_Payment_ID;

	SELECT sc.C_Currency_ID
	INTO v_BaseCurrency_ID
	FROM AD_ClientInfo ci
	JOIN C_AcctSchema sc ON ci.C_AcctSchema1_ID=sc.C_AcctSchema_ID
	WHERE ci.AD_Client_ID=v_Client_ID;

	IF v_BaseCurrency_ID=p_Currency_To_id AND Coalesce(v_CurrencyRate,0) > 0 AND Coalesce(v_ConvertedAmt,0) != 0 AND v_Currency_ID != p_Currency_To_id AND v_IsOverrideCurrencyRate='Y' THEN
		IF p_Amt IS NULL THEN
			RETURN v_ConvertedAmt;
		ELSE
			RETURN currencyRound(p_Amt*v_CurrencyRate, p_Currency_To_id, null);
		END IF;
	END IF;

	RETURN currencyConvert(Coalesce(p_Amt,v_PayAmt), v_Currency_ID, p_Currency_To_id, Coalesce(p_conversionDate,v_DateAcct), v_ConversionType_ID, v_Client_ID, v_Org_ID);
END;
$$;

-- Remove eve_bpartner & bandahealth_bpartners
DELETE
FROM
	ad_column
WHERE
	ad_column_uu in ('80ed368a-7b59-44d3-b977-9583e60e4528', '6709aa10-f347-451e-9824-c09f29082bb3');

SELECT
	register_migration_script('202403081917_GO-2887.sql')
FROM
	dual;
