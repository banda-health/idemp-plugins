UPDATE bh_dbrdbtngrp_btn SET lineno = 120, iconclassname = 'fas fa-exchange-alt' WHERE bh_dbrdbtngrp_btn_uu = '1da38275-67b8-4bb6-b409-db37b2decc9f';

SELECT register_migration_script('202111091507_GO-1806.sql') FROM dual;
