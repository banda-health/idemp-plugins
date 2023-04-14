-- This has to be done in a transaction to ensure no problems
BEGIN;

update ad_form_access set ad_form_id = 1000001 where ad_form_id = (select ad_form_id from ad_form where ad_form_uu = '03ea6763-f298-4468-bab6-045d3e853685');

update ad_form_trl set ad_form_id = 1000001 where ad_form_id = (select ad_form_id from ad_form where ad_form_uu = '03ea6763-f298-4468-bab6-045d3e853685');

update bh_dbrdbtngrp_btn set ad_form_id = 1000001 where ad_form_id = (select ad_form_id from ad_form where ad_form_uu = '03ea6763-f298-4468-bab6-045d3e853685');

update ad_form set ad_form_id = 1000001 where ad_form_uu = '03ea6763-f298-4468-bab6-045d3e853685';

COMMIT;

SELECT register_migration_script('202008011201_Galmi-Sync.sql') FROM dual;
