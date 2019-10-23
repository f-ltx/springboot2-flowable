INSERT INTO `t_user` VALUES (1, '数据中心/申请人1', '申请人1', 'sqr1');
INSERT INTO `t_user` VALUES (2, '数据中心/申请人2', '申请人2', 'sqr2');
INSERT INTO `t_user` VALUES (3, '海关/审批人1', '审批人1', 'spr1');
INSERT INTO `t_user` VALUES (4, '海关/审批人2', '审批人2', 'spr2');
INSERT INTO `t_user` VALUES (5, '数据中心/执行人1', '执行人1', 'zxr1');
INSERT INTO `t_user` VALUES (6, '数据中心/执行人2', '执行人2', 'zxr2');

INSERT INTO `t_role` VALUES (1, 'sq', 'shenqing', '申请');
INSERT INTO `t_role` VALUES (2, 'sp', 'shenpi', '审批');
INSERT INTO `t_role` VALUES (3, 'zx', 'zhixing', '执行');

INSERT INTO `t_user_role` VALUES (1, 1, 1);
INSERT INTO `t_user_role` VALUES (2, 1, 2);
INSERT INTO `t_user_role` VALUES (3, 2, 3);
INSERT INTO `t_user_role` VALUES (4, 2, 4);
INSERT INTO `t_user_role` VALUES (5, 3, 5);
INSERT INTO `t_user_role` VALUES (6, 3, 6);

INSERT INTO `t_verification` VALUES (1, 'vfname01', 'vfreason01');
INSERT INTO `t_verification` VALUES (2, 'vfname02', 'vfreason02');
INSERT INTO `t_verification` VALUES (3, 'vfname03', 'vfreason03');
INSERT INTO `t_verification` VALUES (4, 'vfname04', 'vfreason04');
INSERT INTO `t_verification` VALUES (5, 'vfname05', 'vfreason05');
INSERT INTO `t_verification` VALUES (6, 'vfname06', 'vfreason06');
