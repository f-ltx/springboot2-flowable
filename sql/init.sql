INSERT INTO `t_user`(id, all_path_name, display_name, user_guid)
VALUES (1, '数据中心/申请人1', '申请人1', 'sqr1');
INSERT INTO `t_user`(id, all_path_name, display_name, user_guid)
VALUES (2, '数据中心/申请人2', '申请人2', 'sqr2');
INSERT INTO `t_user`(id, all_path_name, display_name, user_guid)
VALUES (3, '海关/审批人1', '审批人1', 'spr1');
INSERT INTO `t_user`(id, all_path_name, display_name, user_guid)
VALUES (4, '海关/审批人2', '审批人2', 'spr2');
INSERT INTO `t_user`(id, all_path_name, display_name, user_guid)
VALUES (5, '数据中心/执行人1', '执行人1', 'zxr1');
INSERT INTO `t_user`(id, all_path_name, display_name, user_guid)
VALUES (6, '数据中心/执行人2', '执行人2', 'zxr2');

INSERT INTO `t_role`(id, code_name, role_id, role_name)
VALUES (1, 'sq', 'shenqing', '申请');
INSERT INTO `t_role`(id, code_name, role_id, role_name)
VALUES (2, 'sp', 'shenpi', '审批');
INSERT INTO `t_role`(id, code_name, role_id, role_name)
VALUES (3, 'zx', 'zhixing', '执行');

INSERT INTO `t_user_role`(user_id, role_id) VALUES (1, 1);
INSERT INTO `t_user_role`(user_id, role_id) VALUES (2, 1);
INSERT INTO `t_user_role`(user_id, role_id) VALUES (3, 2);
INSERT INTO `t_user_role`(user_id, role_id) VALUES (4, 2);
INSERT INTO `t_user_role`(user_id, role_id) VALUES (5, 3);
INSERT INTO `t_user_role`(user_id, role_id) VALUES (6, 3);

INSERT INTO `t_verification`(id, name, reason)
VALUES (1, 'vfname01', 'vfreason01');
INSERT INTO `t_verification`(id, name, reason)
VALUES (2, 'vfname02', 'vfreason02');
INSERT INTO `t_verification`(id, name, reason)
VALUES (3, 'vfname03', 'vfreason03');
INSERT INTO `t_verification`(id, name, reason)
VALUES (4, 'vfname04', 'vfreason04');
INSERT INTO `t_verification`(id, name, reason)
VALUES (5, 'vfname05', 'vfreason05');
INSERT INTO `t_verification`(id, name, reason)
VALUES (6, 'vfname06', 'vfreason06');
