UPDATE bh_dbrdbtngrp_btn SET name = 'Products And Prices' WHERE BH_DbrdBtnGrp_Btn_UU='beade859-7122-41da-834f-f7a8ac5a81d5';
UPDATE bh_dbrdbtngrp_btn SET name = 'Services And Prices' WHERE BH_DbrdBtnGrp_Btn_UU='a27677ca-cc76-4595-af41-9909d5500f93';
UPDATE bh_dbrdbtngrp_btn SET name = 'Debt Payments' WHERE BH_DbrdBtnGrp_Btn_UU='f0a2ba7a-765c-4239-bb91-910ee85e6017';

SELECT register_migration_script('202104201907_GO-1641.sql') FROM dual;
