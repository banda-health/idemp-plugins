-- Sick-off notes issued during a visit, plus a durable print-audit log (every reprint recorded, not just last-modified).
-- BH_SickOff is snapshotted at creation (see MBHSickOffInput) — corrections require voiding and re-issuing.
CREATE TABLE BH_SickOff
(
	AD_Client_ID                  NUMERIC(10) NOT NULL,
	AD_Org_ID                     NUMERIC(10) NOT NULL,
	BH_Additional_Clinical_Notes  TEXT                                                    DEFAULT NULL,
	BH_Clinician_User_ID          NUMERIC(10) NOT NULL,
	BH_SickOff_ID                 NUMERIC(10) NOT NULL,
	BH_SickOff_UU                 VARCHAR(36)                                             DEFAULT NULL,
	BH_Visit_ID                   NUMERIC(10) NOT NULL,
	Created                       TIMESTAMP   NOT NULL                                    DEFAULT getDate(),
	CreatedBy                     NUMERIC(10) NOT NULL,
	EndDate                       TIMESTAMP   NOT NULL,
	IsActive                      CHAR(1)     NOT NULL CHECK (IsActive IN ('Y', 'N'))     DEFAULT 'Y',
	StartDate                     TIMESTAMP   NOT NULL,
	Updated                       TIMESTAMP   NOT NULL                                    DEFAULT getDate(),
	UpdatedBy                     NUMERIC(10) NOT NULL,
	CONSTRAINT BH_SickOff_Key PRIMARY KEY (BH_SickOff_ID),
	CONSTRAINT BH_SickOff_UU_idx UNIQUE (BH_SickOff_UU)
);
ALTER TABLE BH_SickOff
	ADD CONSTRAINT ADClient_BHSickOff FOREIGN KEY (AD_Client_ID) REFERENCES ad_client (ad_client_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_SickOff
	ADD CONSTRAINT ADOrg_BHSickOff FOREIGN KEY (AD_Org_ID) REFERENCES ad_org (ad_org_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_SickOff
	ADD CONSTRAINT ADUser_BHSickOff FOREIGN KEY (BH_Clinician_User_ID) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_SickOff
	ADD CONSTRAINT BHVisit_BHSickOff FOREIGN KEY (BH_Visit_ID) REFERENCES bh_visit (bh_visit_id) DEFERRABLE INITIALLY DEFERRED;

CREATE TABLE BH_SickOff_Print_Log
(
	AD_Client_ID            NUMERIC(10) NOT NULL,
	AD_Org_ID               NUMERIC(10) NOT NULL,
	BH_SickOff_ID           NUMERIC(10) NOT NULL,
	BH_SickOff_Print_Log_ID NUMERIC(10) NOT NULL,
	BH_SickOff_Print_Log_UU VARCHAR(36)                                         DEFAULT NULL,
	Created                 TIMESTAMP   NOT NULL                                DEFAULT getDate(),
	CreatedBy               NUMERIC(10) NOT NULL,
	IsActive                CHAR(1)     NOT NULL CHECK (IsActive IN ('Y', 'N')) DEFAULT 'Y',
	Printed                 TIMESTAMP   NOT NULL                                DEFAULT getDate(),
	PrintedBy               NUMERIC(10) NOT NULL,
	Updated                 TIMESTAMP   NOT NULL                                DEFAULT getDate(),
	UpdatedBy               NUMERIC(10) NOT NULL,
	CONSTRAINT BH_SickOff_Print_Log_Key PRIMARY KEY (BH_SickOff_Print_Log_ID),
	CONSTRAINT BH_SickOff_Print_Log_UU_idx UNIQUE (BH_SickOff_Print_Log_UU)
);
ALTER TABLE BH_SickOff_Print_Log
	ADD CONSTRAINT ADClient_BHSickOffPrintLog FOREIGN KEY (AD_Client_ID) REFERENCES ad_client (ad_client_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_SickOff_Print_Log
	ADD CONSTRAINT ADOrg_BHSickOffPrintLog FOREIGN KEY (AD_Org_ID) REFERENCES ad_org (ad_org_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_SickOff_Print_Log
	ADD CONSTRAINT BHSickOff_BHSickOffPrintLog FOREIGN KEY (BH_SickOff_ID) REFERENCES bh_sickoff (bh_sickoff_id) DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE BH_SickOff_Print_Log
	ADD CONSTRAINT PrintedBy_BHSickOffPrintLog FOREIGN KEY (PrintedBy) REFERENCES ad_user (ad_user_id) DEFERRABLE INITIALLY DEFERRED;

-- Insert the elements (BH_Visit_ID element already exists from an earlier migration — reused by columnname below, not re-inserted)
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((
		 SELECT MAX(ad_element_id) + 1
		 FROM ad_element
	 ), 0, 0, 'Y', '2026-07-01 10:00:00.000000', 100, '2026-07-01 10:00:00.000000', 100, 'BH_SickOff_ID', 'U', 'Sick Off',
	 'Sick Off', NULL, NULL, NULL, NULL, NULL, NULL, 'd3f412a3-ec83-44ee-8789-9290f6e70fc4', NULL);
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((
		 SELECT MAX(ad_element_id) + 1
		 FROM ad_element
	 ), 0, 0, 'Y', '2026-07-01 10:00:01.000000', 100, '2026-07-01 10:00:01.000000', 100, 'BH_SickOff_UU', 'U',
	 'BH_SickOff_UU', 'BH_SickOff_UU', NULL, NULL, NULL, NULL, NULL, NULL, '091f08d2-b5be-4e81-a3e2-5b1a918e922a', NULL);
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((
		 SELECT MAX(ad_element_id) + 1
		 FROM ad_element
	 ), 0, 0, 'Y', '2026-07-01 10:00:02.000000', 100, '2026-07-01 10:00:02.000000', 100, 'BH_Additional_Clinical_Notes', 'U',
	 'Additional Clinical Notes', 'Additional Clinical Notes',
	 'Any further instructions for the employer or patient', NULL, NULL, NULL, NULL, NULL,
	 '0979bad6-65f7-4e69-8713-84c5aea68d65', 'Any further instructions for the employer or patient...');
-- StartDate/EndDate elements already exist (shared across many standard tables) — reused by columnname below, not re-inserted
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((
		 SELECT MAX(ad_element_id) + 1
		 FROM ad_element
	 ), 0, 0, 'Y', '2026-07-01 10:00:05.000000', 100, '2026-07-01 10:00:05.000000', 100, 'BH_SickOff_Print_Log_ID', 'U',
	 'Sick Off Print Log', 'Sick Off Print Log', NULL, NULL, NULL, NULL, NULL, NULL,
	 'd39855e2-ce91-4cc1-bd67-3ecda4ceac05', NULL);
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((
		 SELECT MAX(ad_element_id) + 1
		 FROM ad_element
	 ), 0, 0, 'Y', '2026-07-01 10:00:06.000000', 100, '2026-07-01 10:00:06.000000', 100, 'BH_SickOff_Print_Log_UU', 'U',
	 'BH_SickOff_Print_Log_UU', 'BH_SickOff_Print_Log_UU', NULL, NULL, NULL, NULL, NULL, NULL,
	 '2032ea1a-eb2c-42ce-8f5e-2dabd9dd1b9d', NULL);
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((
		 SELECT MAX(ad_element_id) + 1
		 FROM ad_element
	 ), 0, 0, 'Y', '2026-07-01 10:00:07.000000', 100, '2026-07-01 10:00:07.000000', 100, 'PrintedBy', 'U', 'Printed By',
	 'Printed By', 'User who printed this record', NULL, NULL, NULL, NULL, NULL,
	 '1775ad16-d685-4c98-acd5-b4899282ba8b', NULL);
INSERT INTO
	ad_element (ad_element_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, columnname,
	            entitytype, name, printname, description, help, po_name, po_printname, po_description, po_help,
	            ad_element_uu, placeholder)
VALUES
	((
		 SELECT MAX(ad_element_id) + 1
		 FROM ad_element
	 ), 0, 0, 'Y', '2026-07-01 10:00:08.000000', 100, '2026-07-01 10:00:08.000000', 100, 'Printed', 'U', 'Printed',
	 'Printed', 'Date and time this record was printed', NULL, NULL, NULL, NULL, NULL,
	 '1aa49719-0bb4-40cb-8a72-635e7466c493', NULL);

-- Insert the tables
INSERT INTO
	ad_table (ad_table_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, tablename, isview, accesslevel, entitytype, ad_window_id, ad_val_rule_id, loadseq, issecurityenabled,
	          isdeleteable, ishighvolume, importtable, ischangelog, replicationtype, po_window_id, copycolumnsfromtable,
	          iscentrallymaintained, ad_table_uu, processing, databaseviewdrop, copycomponentsfromview,
	          createwindowfromtable, isshowindrilloptions, ispartition, createpartition)
VALUES
	((
		 SELECT MAX(ad_table_id) + 1
		 FROM ad_table
	 ), 0, 0, 'Y', '2026-07-01 10:01:00.000000', 100, '2026-07-01 10:01:00.000000', 100, 'Sick Off', NULL, NULL,
	 'BH_SickOff', 'N', '3', 'U', NULL, NULL, 0, 'N', 'Y', 'N', 'N', 'Y', 'L', NULL, 'N', 'Y',
	 'c0a196e6-b994-4459-9c9d-9773c97be915', 'N', 'N', 'N', 'N', 'N', 'N', 'N');
INSERT INTO
	ad_table (ad_table_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name, description,
	          help, tablename, isview, accesslevel, entitytype, ad_window_id, ad_val_rule_id, loadseq, issecurityenabled,
	          isdeleteable, ishighvolume, importtable, ischangelog, replicationtype, po_window_id, copycolumnsfromtable,
	          iscentrallymaintained, ad_table_uu, processing, databaseviewdrop, copycomponentsfromview,
	          createwindowfromtable, isshowindrilloptions, ispartition, createpartition)
VALUES
	((
		 SELECT MAX(ad_table_id) + 1
		 FROM ad_table
	 ), 0, 0, 'Y', '2026-07-01 10:01:01.000000', 100, '2026-07-01 10:01:01.000000', 100, 'Sick Off Print Log', NULL, NULL,
	 'BH_SickOff_Print_Log', 'N', '3', 'U', NULL, NULL, 0, 'N', 'Y', 'N', 'N', 'Y', 'L', NULL, 'N', 'Y',
	 '50917e4c-0db8-4b7d-b539-5175f612fe32', 'N', 'N', 'N', 'N', 'N', 'N', 'N');

-- Insert the sequences
INSERT INTO
	ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
	             description, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys, isaudited,
	             istableid, prefix, suffix, startnewyear, datecolumn, decimalpattern, ad_sequence_uu, startnewmonth,
	             isorglevelsequence, orgcolumn)
VALUES
	((
		 SELECT MAX(ad_sequence_id) + 1
		 FROM ad_sequence
	 ), 0, 0, 'Y', '2026-07-01 10:01:00.000000', 100, '2026-07-01 10:01:00.000000', 100, 'BH_SickOff',
	 'Table BH_SickOff', NULL, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', NULL, NULL, 'N', NULL, NULL,
	 '23b1d694-3d64-4450-8263-53b9f5398a20', 'N', 'N', NULL);
INSERT INTO
	ad_sequence (ad_sequence_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name,
	             description, vformat, isautosequence, incrementno, startno, currentnext, currentnextsys, isaudited,
	             istableid, prefix, suffix, startnewyear, datecolumn, decimalpattern, ad_sequence_uu, startnewmonth,
	             isorglevelsequence, orgcolumn)
VALUES
	((
		 SELECT MAX(ad_sequence_id) + 1
		 FROM ad_sequence
	 ), 0, 0, 'Y', '2026-07-01 10:01:01.000000', 100, '2026-07-01 10:01:01.000000', 100, 'BH_SickOff_Print_Log',
	 'Table BH_SickOff_Print_Log', NULL, 'Y', 1, 1000000, 1000000, 200000, 'N', 'Y', NULL, NULL, 'N', NULL, NULL,
	 '2eaee0bc-c24a-4b63-ac2f-b6301d5c6c52', 'N', 'N', NULL);

-- Insert the columns: BH_SickOff
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-07-01 10:02:00.000000', '2026-07-01 10:02:00.000000', 100, 100, 'Sick Off', NULL, NULL, 1, 'U',
	 'BH_SickOff_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c0a196e6-b994-4459-9c9d-9773c97be915'
	 ), 13, NULL, NULL, 22, NULL, 'Y', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'd3f412a3-ec83-44ee-8789-9290f6e70fc4'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'e0ff3a4e-2098-44c2-8e45-0e66268cc99b', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-07-01 10:02:01.000000', '2026-07-01 10:02:01.000000', 100, 100, 'BH_SickOff_UU', NULL, NULL, 1,
	 'U', 'BH_SickOff_UU', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c0a196e6-b994-4459-9c9d-9773c97be915'
	 ), 200231, NULL, NULL, 36, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '091f08d2-b5be-4e81-a3e2-5b1a918e922a'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'c3d974f4-2d71-4000-b850-290a07133e1b', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-07-01 10:02:02.000000', '2026-07-01 10:02:02.000000', 100, 100, 'Visit', NULL, NULL, 0, 'U',
	 'BH_Visit_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c0a196e6-b994-4459-9c9d-9773c97be915'
	 ), 19, NULL, NULL, 22, NULL, 'N', 'Y', 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE columnname = 'BH_Visit_ID' ORDER BY ad_element_id LIMIT 1
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '5901e642-d984-4748-8e46-f8e3eb774eec', 'Y', 0, 'N', 'N', NULL,
	 'BHVisit_BHSickOff', 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-07-01 10:02:03.000000', '2026-07-01 10:02:03.000000', 100, 100, 'Additional Clinical Notes', NULL,
	 'Any further instructions for the employer or patient', 0, 'U', 'BH_Additional_Clinical_Notes', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c0a196e6-b994-4459-9c9d-9773c97be915'
	 ), 36, NULL, NULL, 0, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '0979bad6-65f7-4e69-8713-84c5aea68d65'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'cee89de9-8245-436b-9f59-4661de1e647c', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-07-01 10:02:04.000000', '2026-07-01 10:02:04.000000', 100, 100, 'Start Date', NULL, NULL, 0, 'U',
	 'StartDate', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c0a196e6-b994-4459-9c9d-9773c97be915'
	 ), 15, NULL, NULL, 7, NULL, 'N', 'N', 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE columnname = 'StartDate' ORDER BY ad_element_id LIMIT 1
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '0ddd44e6-0d6f-4e21-9cdd-875b920c1b7d', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-07-01 10:02:05.000000', '2026-07-01 10:02:05.000000', 100, 100, 'End Date', NULL, NULL, 0, 'U',
	 'EndDate', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c0a196e6-b994-4459-9c9d-9773c97be915'
	 ), 15, NULL, NULL, 7, NULL, 'N', 'N', 'Y', 'Y', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE columnname = 'EndDate' ORDER BY ad_element_id LIMIT 1
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'a19d5c7d-1706-415d-9b07-ce053fa740d8', 'Y', 0, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-07-01 10:02:06.000000', '2026-07-01 10:02:06.000000', 100, 100, 'Created',
	 'Date this record was created', 'The Created field indicates the date that this record was created.', 1, 'U',
	 'Created', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c0a196e6-b994-4459-9c9d-9773c97be915'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 245,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '45860155-46a2-463b-b09d-6f9d827b69d2', 'N', NULL, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-07-01 10:02:07.000000', '2026-07-01 10:02:07.000000', 100, 100, 'Created By',
	 'User who created this records', 'The Created By field indicates the user who created this record.', 1, 'U',
	 'CreatedBy', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c0a196e6-b994-4459-9c9d-9773c97be915'
	 ), 30, 110, NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 246, NULL,
	 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '5ef628c5-4739-45ad-9d8c-2dbade4c382b', 'N', NULL, 'N', 'N', NULL, NULL,
	 'D', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-07-01 10:02:08.000000', '2026-07-01 10:02:08.000000', 100, 100, 'Updated',
	 'Date this record was updated', 'The Updated field indicates the date that this record was updated.', 1, 'U',
	 'Updated', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c0a196e6-b994-4459-9c9d-9773c97be915'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 607,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '1498da08-917b-48a8-a7b9-6acc97dd803b', 'N', NULL, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-07-01 10:02:09.000000', '2026-07-01 10:02:09.000000', 100, 100, 'Updated By',
	 'User who updated this records', 'The Updated By field indicates the user who updated this record.', 1, 'U',
	 'UpdatedBy', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c0a196e6-b994-4459-9c9d-9773c97be915'
	 ), 30, 110, NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 608, NULL,
	 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '729ceb3b-9296-4eee-9739-9a6582bd871e', 'N', NULL, 'N', 'N', NULL, NULL,
	 'D', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-07-01 10:02:10.000000', '2026-07-01 10:02:10.000000', 100, 100, 'Active',
	 'The record is active in the system', e'There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record. A de-activated record is not available for selection, but available for reports.
There are two reasons for de-activating and not deleting records:
(1) The system requires the record for audit purposes.
(2) The record is referenced by other records. E.g., you cannot delete a Business Partner, if there are invoices for this partner record existing. You de-activate the Business Partner and prevent that this record is used for future entries.',
	 1, 'U', 'IsActive', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c0a196e6-b994-4459-9c9d-9773c97be915'
	 ), 20, NULL, NULL, 1, 'Y', 'N', 'N', 'Y', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 348, NULL,
	 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'cf4f11ef-56f6-4641-83b5-8c631e71a925', 'N', NULL, 'N', 'N', NULL, NULL,
	 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-07-01 10:02:11.000000', '2026-07-01 10:02:11.000000', 100, 100, 'Tenant',
	 'Tenant for this installation.', 'A Tenant is a company or a legal entity. You cannot share data between Tenants.',
	 1, 'U', 'AD_Client_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c0a196e6-b994-4459-9c9d-9773c97be915'
	 ), 19, NULL, 129, 22, '@#AD_Client_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N',
	 102, NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '2fd809d2-c350-4a15-8d2b-1606f26b525e', 'N', NULL, 'N', 'N',
	 NULL, 'ADClient_BHSickOff', 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-07-01 10:02:12.000000', '2026-07-01 10:02:12.000000', 100, 100, 'Organization',
	 'Organizational entity within tenant',
	 'An organization is a unit of your tenant or legal entity - examples are store, department. You can share data between organizations.',
	 1, 'U', 'AD_Org_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c0a196e6-b994-4459-9c9d-9773c97be915'
	 ), 19, NULL, 104, 22, '@#AD_Org_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N',
	 113, NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'e32973d8-8627-4bc4-8595-b8ce6d5ab837', 'N', NULL, 'N', 'N',
	 NULL, 'ADOrg_BHSickOff', 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-07-01 10:02:13.000000', '2026-07-01 10:02:13.000000', 100, 100, 'BH_Clinician_User_ID', NULL, NULL,
	 0, 'U', 'BH_Clinician_User_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = 'c0a196e6-b994-4459-9c9d-9773c97be915'
	 ), 30, 110, NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE columnname = 'BH_Clinician_User_ID' ORDER BY ad_element_id LIMIT 1
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '2d578fc9-b8b1-4973-8bc4-33872083d646', 'N', NULL, 'N', 'N', NULL,
	 'ADUser_BHSickOff', 'D', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

-- Insert the columns: BH_SickOff_Print_Log
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-07-01 10:03:00.000000', '2026-07-01 10:03:00.000000', 100, 100, 'Sick Off Print Log', NULL, NULL,
	 1, 'U', 'BH_SickOff_Print_Log_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '50917e4c-0db8-4b7d-b539-5175f612fe32'
	 ), 13, NULL, NULL, 22, NULL, 'Y', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'd39855e2-ce91-4cc1-bd67-3ecda4ceac05'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '163166b1-e511-410e-92b4-4b2cafcacc55', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-07-01 10:03:01.000000', '2026-07-01 10:03:01.000000', 100, 100, 'BH_SickOff_Print_Log_UU', NULL,
	 NULL, 1, 'U', 'BH_SickOff_Print_Log_UU', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '50917e4c-0db8-4b7d-b539-5175f612fe32'
	 ), 200231, NULL, NULL, 36, NULL, 'N', 'N', 'N', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '2032ea1a-eb2c-42ce-8f5e-2dabd9dd1b9d'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '015a3d31-1d76-4807-8603-5e749ddfc118', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-07-01 10:03:02.000000', '2026-07-01 10:03:02.000000', 100, 100, 'Sick Off', NULL, NULL, 0, 'U',
	 'BH_SickOff_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '50917e4c-0db8-4b7d-b539-5175f612fe32'
	 ), 19, NULL, NULL, 22, NULL, 'N', 'Y', 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = 'd3f412a3-ec83-44ee-8789-9290f6e70fc4'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '15c24ce6-f0de-4f92-bdbf-2cec2b27c3f8', 'Y', 0, 'N', 'N', NULL,
	 'BHSickOff_BHSickOffPrintLog', 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-07-01 10:03:03.000000', '2026-07-01 10:03:03.000000', 100, 100, 'Printed By', NULL,
	 'User who printed this record', 0, 'U', 'PrintedBy', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '50917e4c-0db8-4b7d-b539-5175f612fe32'
	 ), 30, 110, NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '1775ad16-d685-4c98-acd5-b4899282ba8b'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '49007b02-b11d-41a1-8b41-74d8ae20534e', 'N', NULL, 'N', 'N',
	 NULL, 'PrintedBy_BHSickOffPrintLog', 'D', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-07-01 10:03:04.000000', '2026-07-01 10:03:04.000000', 100, 100, 'Printed', NULL,
	 'Date and time this record was printed', 0, 'U', 'Printed', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '50917e4c-0db8-4b7d-b539-5175f612fe32'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', 0, 'N', 'N', NULL, NULL, NULL, NULL, 'N', (
		 SELECT ad_element_id FROM ad_element WHERE ad_element_uu = '1aa49719-0bb4-40cb-8a72-635e7466c493'
	 ), NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '9f0ae2a8-f626-4039-a218-7c624fece0cb', 'N', NULL, 'N', 'N',
	 NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-07-01 10:03:05.000000', '2026-07-01 10:03:05.000000', 100, 100, 'Created',
	 'Date this record was created', 'The Created field indicates the date that this record was created.', 1, 'U',
	 'Created', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '50917e4c-0db8-4b7d-b539-5175f612fe32'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 245,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '38f528c0-afd5-420a-864c-7b19f2fc19f9', 'N', NULL, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-07-01 10:03:06.000000', '2026-07-01 10:03:06.000000', 100, 100, 'Created By',
	 'User who created this records', 'The Created By field indicates the user who created this record.', 1, 'U',
	 'CreatedBy', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '50917e4c-0db8-4b7d-b539-5175f612fe32'
	 ), 30, 110, NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 246, NULL,
	 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'b2ab3463-be78-4012-afac-b4cb9df5d45d', 'N', NULL, 'N', 'N', NULL, NULL,
	 'D', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-07-01 10:03:07.000000', '2026-07-01 10:03:07.000000', 100, 100, 'Updated',
	 'Date this record was updated', 'The Updated field indicates the date that this record was updated.', 1, 'U',
	 'Updated', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '50917e4c-0db8-4b7d-b539-5175f612fe32'
	 ), 16, NULL, NULL, 7, 'SYSDATE', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 607,
	 NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '316fd0a3-9921-4e22-9a89-632d4c68ab14', 'N', NULL, 'N', 'N', NULL,
	 NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-07-01 10:03:08.000000', '2026-07-01 10:03:08.000000', 100, 100, 'Updated By',
	 'User who updated this records', 'The Updated By field indicates the user who updated this record.', 1, 'U',
	 'UpdatedBy', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '50917e4c-0db8-4b7d-b539-5175f612fe32'
	 ), 30, 110, NULL, 22, NULL, 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 608, NULL,
	 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, 'db172f01-bc3f-4839-912d-12c46f4fd67a', 'N', NULL, 'N', 'N', NULL, NULL,
	 'D', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-07-01 10:03:09.000000', '2026-07-01 10:03:09.000000', 100, 100, 'Active',
	 'The record is active in the system', e'There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record. A de-activated record is not available for selection, but available for reports.
There are two reasons for de-activating and not deleting records:
(1) The system requires the record for audit purposes.
(2) The record is referenced by other records. E.g., you cannot delete a Business Partner, if there are invoices for this partner record existing. You de-activate the Business Partner and prevent that this record is used for future entries.',
	 1, 'U', 'IsActive', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '50917e4c-0db8-4b7d-b539-5175f612fe32'
	 ), 20, NULL, NULL, 1, 'Y', 'N', 'N', 'Y', 'Y', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N', 348, NULL,
	 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '6e2f8f74-048a-48b5-ad3a-09e91a921054', 'N', NULL, 'N', 'N', NULL, NULL,
	 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-07-01 10:03:10.000000', '2026-07-01 10:03:10.000000', 100, 100, 'Tenant',
	 'Tenant for this installation.', 'A Tenant is a company or a legal entity. You cannot share data between Tenants.',
	 1, 'U', 'AD_Client_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '50917e4c-0db8-4b7d-b539-5175f612fe32'
	 ), 19, NULL, 129, 22, '@#AD_Client_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N',
	 102, NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '9b7c85bd-8a48-493f-9a58-7368b6e8dc2c', 'N', NULL, 'N', 'N',
	 NULL, 'ADClient_BHSickOffPrintLog', 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);
INSERT INTO
	ad_column (ad_column_id, ad_client_id, ad_org_id, isactive, created, updated, createdby, updatedby, name, description,
	           help, version, entitytype, columnname, ad_table_id, ad_reference_id, ad_reference_value_id, ad_val_rule_id,
	           fieldlength, defaultvalue, iskey, isparent, ismandatory, isupdateable, readonlylogic, isidentifier, seqno,
	           istranslated, isencrypted, callout, vformat, valuemin, valuemax, isselectioncolumn, ad_element_id,
	           ad_process_id, issyncdatabase, isalwaysupdateable, columnsql, mandatorylogic, infofactoryclass,
	           isautocomplete, isallowlogging, formatpattern, ad_column_uu, isallowcopy, seqnoselection, istoolbarbutton,
	           issecure, ad_chart_id, fkconstraintname, fkconstrainttype, pa_dashboardcontent_id, placeholder, ishtml,
	           ad_val_rule_lookup_id, ad_infowindow_id, alwaysupdatablelogic, fkconstraintmsg_id, partitioningmethod,
	           ispartitionkey, seqnopartition, rangepartitioninterval)
VALUES
	((
		 SELECT MAX(ad_column_id) + 1
		 FROM ad_column
	 ), 0, 0, 'Y', '2026-07-01 10:03:11.000000', '2026-07-01 10:03:11.000000', 100, 100, 'Organization',
	 'Organizational entity within tenant',
	 'An organization is a unit of your tenant or legal entity - examples are store, department. You can share data between organizations.',
	 1, 'U', 'AD_Org_ID', (
		 SELECT ad_table_id FROM ad_table WHERE ad_table_uu = '50917e4c-0db8-4b7d-b539-5175f612fe32'
	 ), 19, NULL, 104, 22, '@#AD_Org_ID@', 'N', 'N', 'Y', 'N', NULL, 'N', NULL, 'N', 'N', NULL, NULL, NULL, NULL, 'N',
	 113, NULL, 'N', 'N', NULL, NULL, NULL, 'N', 'Y', NULL, '8b3cf5a0-0122-4353-8443-3e7fe7d8e8ee', 'N', NULL, 'N', 'N',
	 NULL, 'ADOrg_BHSickOffPrintLog', 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, 'N', NULL, NULL);

-- Update the GraphQL generator template table list
UPDATE bh_graphqlgeneratortemplate
SET
	tablename = REGEXP_REPLACE(
		tablename,
		'''BH_Feature_Flag_Rule''',
		'''BH_Feature_Flag_Rule'',''BH_SickOff'',''BH_SickOff_Print_Log''',
		'i'
	)
WHERE
	bh_graphqlgeneratortemplate_uu = '0b9c9d6a-6e59-4ba4-995a-6762c9effe03'
	AND tablename NOT ILIKE '%BH_SickOff%';

SELECT
	register_migration_script('202607010000_GO-3458.sql')
FROM
	dual;
