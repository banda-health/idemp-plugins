ALTER TABLE c_order ALTER COLUMN bh_patienttype TYPE varchar(10);

UPDATE adempiere.ad_column SET fieldlength = 10 WHERE ad_column_uu = '3e9e18e0-475d-4325-ad47-dbb20024bbaf';

SELECT register_migration_script('202202011750_GO-2146.sql') FROM dual;
