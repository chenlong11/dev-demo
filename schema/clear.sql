delete from sys_user where account_name <> 'super';
delete from sys_local_auth where account_name <> 'super';
delete from sys_role where org_id > 3 and reserved_flag <> 1;
delete from sys_user_role where role_id not in (select id from sys_role where role_code = 'super');
delete from sys_module_role;
delete from sys_dept;
delete from sys_org where lv >1;
delete from sys_attachment;
delete from worker_node;



