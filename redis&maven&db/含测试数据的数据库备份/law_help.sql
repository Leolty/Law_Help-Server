/*
SQLyog Ultimate v8.32 
MySQL - 5.7.33 : Database - law_help
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`law_help` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `law_help`;

/*Table structure for table `attach_file` */

DROP TABLE IF EXISTS `attach_file`;

CREATE TABLE `attach_file` (
  `FILE_ID` varchar(36) NOT NULL COMMENT '主键ID',
  `FILE_TYPE` int(11) DEFAULT NULL COMMENT '文件类型',
  `FILE_URL` varchar(255) DEFAULT NULL COMMENT '链接地址',
  `LINK_TYPE` varchar(36) DEFAULT NULL COMMENT '链接类型 0语音;1答案附件',
  `LINK_ID` varchar(36) DEFAULT NULL COMMENT '链接ID',
  PRIMARY KEY (`FILE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='附件表';

/*Data for the table `attach_file` */

/*Table structure for table `parameter` */

DROP TABLE IF EXISTS `parameter`;

CREATE TABLE `parameter` (
  `PARAM_ID` varchar(36) NOT NULL COMMENT '主键ID',
  `PARAM_KEY` varchar(36) DEFAULT NULL COMMENT '参数',
  `PARAM_VALUE` varchar(255) DEFAULT NULL COMMENT '参数值',
  PRIMARY KEY (`PARAM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='参数表';

/*Data for the table `parameter` */

insert  into `parameter`(`PARAM_ID`,`PARAM_KEY`,`PARAM_VALUE`) values ('0','version','1');

/*Table structure for table `que_answer` */

DROP TABLE IF EXISTS `que_answer`;

CREATE TABLE `que_answer` (
  `ANS_ID` varchar(36) NOT NULL COMMENT '主键ID',
  `QUE_ID` varchar(36) DEFAULT NULL COMMENT '问题ID',
  `ANS_TEXT` varchar(3072) DEFAULT NULL COMMENT '答案文本',
  `CLICK_TIMES` int(11) DEFAULT NULL COMMENT '点击次数',
  `UP_TIME` varchar(36) DEFAULT NULL COMMENT '上传时间',
  `UP_ID` varchar(36) DEFAULT NULL COMMENT '上传者ID',
  `IF_DELETE` int(11) DEFAULT NULL COMMENT '是否失效',
  PRIMARY KEY (`ANS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='问题答案表';

/*Data for the table `que_answer` */

insert  into `que_answer`(`ANS_ID`,`QUE_ID`,`ANS_TEXT`,`CLICK_TIMES`,`UP_TIME`,`UP_ID`,`IF_DELETE`) values ('2bf604b7-158e-448b-8eb6-be13ca69eb31','884cbaa9-d94e-4891-9eab-fbd3a8a32d62','这是bbAns2的答案\n与此同时可以换行\n\n可以搁一行，不知道效不知道效果啊，它怎么样果啊，它怎么样，不知道效果啊，它怎么样,\n\n\n这是搁两行，不知道效果啊，它怎么样不知道效果啊，它怎么样不知道效果啊，它怎么样，不知道效果啊，它怎么样，不知道效果啊，它怎么样\n\n\n不知道效果啊，它怎么样',0,'2021-05-14 18:43:39','o3ipy5aUJMJXDNc-Nvuh4vkUppNI',0),('84f1f711-63d1-42a2-b390-d1806ae179e2','2629ce64-4bcd-4a36-a5c8-8b5266b494ef','这是bbAns1的答案',0,'2021-05-14 18:17:08','o3ipy5aUJMJXDNc-Nvuh4vkUppNI',0),('8631570b-fead-437d-9aaa-df6b504735b4','3a01a24f-c064-44bf-b91c-051194111c9c','由于你们没有领取过结婚证，所以你们之间不存在法律上的婚姻关系，你们现在只是普通的恋爱同居关系，如果现在你决定解除同居关系，那么你只需要和对方提出分手即可。\n\n对于财产或者孩子方面的争议，你们双方可以协商、可以申请调解、也可以去法院提起诉讼。',0,'2021-05-15 17:35:20','o3ipy5aUJMJXDNc-Nvuh4vkUppNI',0),('c9ff7779-e08b-4f0a-9194-77eef68d68ab','4ff311cf-8f19-4e16-9a29-5cbfaa04e7d2','cc2的答案\n这是emojiv❤',0,'2021-05-14 19:01:34','o3ipy5aUJMJXDNc-Nvuh4vkUppNI',0);

/*Table structure for table `que_relationship` */

DROP TABLE IF EXISTS `que_relationship`;

CREATE TABLE `que_relationship` (
  `REL_ID` varchar(36) NOT NULL COMMENT '主键ID',
  `DAD_ID` varchar(36) DEFAULT NULL COMMENT '父问题',
  `SON_ID` varchar(36) DEFAULT NULL COMMENT '子问题',
  `IF_DELETE` int(11) DEFAULT NULL COMMENT '是否失效',
  PRIMARY KEY (`REL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='问题父子关系表';

/*Data for the table `que_relationship` */

/*Table structure for table `que_root` */

DROP TABLE IF EXISTS `que_root`;

CREATE TABLE `que_root` (
  `QUE_ROOT_ID` varchar(36) NOT NULL COMMENT '主键ID',
  `ROOT_ICON` varchar(36) DEFAULT NULL COMMENT '图标样式',
  `ROOT_COLOR` varchar(36) DEFAULT NULL COMMENT '图表颜色',
  `ROOT_NAME` varchar(36) DEFAULT NULL COMMENT '类别名称',
  `ROOT_VERSION` int(11) DEFAULT NULL COMMENT '版本 0审核，1上线版，2测试版',
  PRIMARY KEY (`QUE_ROOT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='根问题表';

/*Data for the table `que_root` */

insert  into `que_root`(`QUE_ROOT_ID`,`ROOT_ICON`,`ROOT_COLOR`,`ROOT_NAME`,`ROOT_VERSION`) values ('0000','discoverfill','purple','星座',0),('0001','clothesfill','blue','穿搭',0),('1000','repairfill','orange','劳动争议',2),('1001','group_fill','red','婚姻家庭',2),('5fd39dc9-ed80-4ffa-9fbd-1c2a86417ccf','group_fill','red','婚姻家事',1),('90e131f8-03f7-44a7-97c2-1cbb01e2ffd3','repairfill','orange','劳动纠纷',1),('9aa697de-7b42-4f1a-986c-4bee800cef9e','roundcheckfill','blue','aa',0);

/*Table structure for table `que_user_ask` */

DROP TABLE IF EXISTS `que_user_ask`;

CREATE TABLE `que_user_ask` (
  `ASK_ID` varchar(36) NOT NULL COMMENT '主键ID',
  `QUE_ID` varchar(36) DEFAULT NULL COMMENT '问题ID',
  `USER_ID` varchar(36) DEFAULT NULL COMMENT '提问者',
  `QUE_TITLE` varchar(36) DEFAULT NULL COMMENT '提问标题',
  `QUE_CONTENT` varchar(1024) DEFAULT NULL COMMENT '提问内容',
  `ASK_TIME` varchar(36) DEFAULT NULL COMMENT '提问时间',
  `ASK_STATUS` int(11) DEFAULT NULL COMMENT '提问状态 0提交待回复；1提交已回复；2回复不了',
  `QUE_ANSWER` varchar(1024) DEFAULT NULL COMMENT '回答',
  `ANSWER_TIME` varchar(36) DEFAULT NULL COMMENT '回答时间',
  `ANSWER_USER_ID` varchar(36) DEFAULT NULL COMMENT '回答者',
  `ANSWER_VERSION` int(11) DEFAULT NULL COMMENT '提问类型 0审核用；1正式用',
  `PUBLIC_STATE` int(11) DEFAULT NULL COMMENT '是否公开;0/1',
  `USER_HAS_READ` int(11) DEFAULT NULL COMMENT '是否已读;0/1',
  PRIMARY KEY (`ASK_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='直接提问问题表';

/*Data for the table `que_user_ask` */

insert  into `que_user_ask`(`ASK_ID`,`QUE_ID`,`USER_ID`,`QUE_TITLE`,`QUE_CONTENT`,`ASK_TIME`,`ASK_STATUS`,`QUE_ANSWER`,`ANSWER_TIME`,`ANSWER_USER_ID`,`ANSWER_VERSION`,`PUBLIC_STATE`,`USER_HAS_READ`) values ('0f2e53c8-fccf-4c7c-af4e-3ccf87bb3869',NULL,'o3ipy5aUJMJXDNc-Nvuh4vkUppNI','直接提问一','直接提问一','2021-05-14 22:53:58',1,'这是直接提问一的答复,这是直接提问一的答复,这是直接提问一的答复,这是直','2021-05-15 14:57:31','o3ipy5aUJMJXDNc-Nvuh4vkUppNI',0,1,0),('23cab313-9c98-4c26-ae4a-bfedddfb9e97','23dfbc32-8942-46f9-befd-39dabbb6e066','o3ipy5aUJMJXDNc-Nvuh4vkUppNI','bb2新标题','bb2新内容','2021-05-15 09:33:42',1,'这是bb2新标题的答复','2021-05-15 14:58:01','o3ipy5aUJMJXDNc-Nvuh4vkUppNI',0,1,0),('52a0c1c7-50ce-4ded-9de5-692635ca37a6',NULL,'o3ipy5aUJMJXDNc-Nvuh4vkUppNI','公司不签劳动合同','工作半年了，公司不签劳动合同。\n\n现在准备离职了，可以要求额外的赔偿吗？','2021-05-15 17:58:24',0,NULL,NULL,NULL,1,1,0),('655f9117-f4f5-427d-a541-129fc2fc4f63','2abc1487-e3c6-421e-8aa3-ef9051f9d88a','o3ipy5aUJMJXDNc-Nvuh4vkUppNI','cc1提问标题','我对cc1不是很懂','2021-05-15 13:54:58',0,NULL,NULL,NULL,0,1,0),('7f2af7a9-e0c4-4cbc-8e8c-342f8512ee80',NULL,'o3ipy5aUJMJXDNc-Nvuh4vkUppNI','同居怎么解除？','我耍朋友两年了，年初和对方搬到了一起住，还没领证，想分手了。请问可以随时分开住吗？','2021-05-15 17:42:14',1,'由于你们没有领取过结婚证，所以你们之间不存在法律上的婚姻关系，你们现在只是普通的恋爱同居关系，如果现在你决定解除同居关系，那么你只需要和对方提出分手即可。\n对于财产或者孩子方面的争议，你们双方可以协商、可以申请调解、也可以去法院提起诉讼。','2021-05-15 17:44:24','o3ipy5aUJMJXDNc-Nvuh4vkUppNI',1,1,0),('86451e2f-873f-4bde-83ae-e054700198ea','23dfbc32-8942-46f9-befd-39dabbb6e066','o3ipy5aUJMJXDNc-Nvuh4vkUppNI','bb2第一个提问','bb2第一个提问','2021-05-14 22:51:23',0,NULL,NULL,NULL,0,1,0),('9a28c7e9-4a35-4dcc-b38e-cf88fe92c65e',NULL,'o3ipy5aUJMJXDNc-Nvuh4vkUppNI','直接提问②','直接提问②','2021-05-14 22:54:03',0,NULL,NULL,NULL,0,1,0),('9ca121b4-2cb9-41df-ad3e-ec954fb64d19',NULL,'o3ipy5aUJMJXDNc-Nvuh4vkUppNI','假证结婚有效吗？','当初朋友领证时，身份证丢了，用的假的。但是他俩当初都是自愿的，现在想离婚了。\n这段婚姻有效吗。','2021-05-15 17:49:34',0,NULL,NULL,NULL,1,1,0),('a7f970d8-b113-4e0e-a54a-211e5302752a',NULL,'o3ipy5aUJMJXDNc-Nvuh4vkUppNI','直接提问的标题直接提问的标题直接提问的标题直接提问的标题直接提问的标题直','直接提问的内容直接提问的内容直接提问的内容直接提问的内容直接提问的内容直接提问的内容直接提问的内容直接提问的内容直接提问的内容直接提问的内容直接提问的内容直接提问的内容直接提问的内容直接提问的内容直接提问的内容直接提问的内容直接提问的内容直接提问的内容直接提问的内容直接提问的内容直接提问的内容直接提问的内容','2021-05-15 09:34:53',0,NULL,NULL,NULL,0,1,0),('b2cae615-2ff5-4ba5-b7fd-bdca3824c9de','8eab8921-d47a-4b91-b6d6-27ae4d6c9686','o3ipy5aUJMJXDNc-Nvuh4vkUppNI','bb3提问','bb3提问','2021-05-14 22:51:50',0,NULL,NULL,NULL,0,1,0),('b60dfdae-b3e6-4ec4-b56d-969664261aa7','2abc1487-e3c6-421e-8aa3-ef9051f9d88a','o3ipy5aUJMJXDNc-Nvuh4vkUppNI','CC1的另一个提问','这是对CC1的另一个提问\n这是一个换行，换行了换行了换行了换行了，换行了换行了换行了。换行了换行了换行了！换行了换行了换行了？\n这是又一换行，换行了。换行了换行了换行了。换行了换行了换行了？换行了换行了换行了！\n换行了换行了换行了换行了换行了。','2021-05-15 14:00:09',0,NULL,NULL,NULL,0,1,0),('b66066bb-c947-4309-811b-48b3d1f128e1',NULL,'o3ipy5aUJMJXDNc-Nvuh4vkUppNI','直接提问的标题2','直接提问的内容2','2021-05-15 09:35:47',0,NULL,NULL,NULL,0,1,0),('d95ddcd0-87d7-4f4e-a26b-726b72b736e5',NULL,'o3ipy5aUJMJXDNc-Nvuh4vkUppNI','直接提问新标题','直接提问新内容','2021-05-15 09:34:12',0,NULL,NULL,NULL,0,1,0),('dbbf9221-feba-4708-9bc7-b381e544e3ec','23dfbc32-8942-46f9-befd-39dabbb6e066','o3ipy5aUJMJXDNc-Nvuh4vkUppNI','bb2第二个提问','bb2第二个提问','2021-05-14 22:51:37',0,NULL,NULL,NULL,0,1,0),('ddf3dc90-36ce-4462-b609-1c03cfa4d5ef',NULL,'o3ipy5aUJMJXDNc-Nvuh4vkUppNI','法律援助要钱吗？','法律援助要钱吗？','2021-05-15 17:44:58',1,'法律援助是指由政府设立的法律援助机构组织法律援助的律师，为经济困难或特殊案件的人给予无偿提供法律服务的一项法律保障制度。申请法律援助是不需要费用。\n\n《法律援助条例》第三条规定，法律援助是政府的责任，县级以上人民政府应当采取积极措施推动法律援助工作，为法律援助提供财政支持，保障法律援助事业与经济、社会协调发展。法律援助经费应当专款专用，接受财政、审计部门的监督。第二十二条规定，办理法律援助案件的人员，应当遵守职业道德和执业纪律，提供法律援助不得收取任何财物。\n\n《律师服务收费管理办法》第二十三条规定，律师事务所应当接受指派承办法律援助案件。办理法律援助案件不得向受援人收取任何费用。对于经济确有困难，但不符合法律援助范围的公民，律师事务所可以酌情减收或免收律师服务费。\n\n法律援助是政府的责任，包括政府要为开展法律援助提供必要的机构和队伍保障，提供必要的经费；也包括政府要充分调动广大律师、社会组织等多方面的积极性，广泛开辟资金渠道，鼓励各方面对法律援助提供支持等。这也明确了政府是主办这项事业的主体，只要确定为法律援助的对象，法律援助的一切经费将由政府承担。','2021-05-15 17:45:25','o3ipy5aUJMJXDNc-Nvuh4vkUppNI',1,1,0),('ebc8d93a-6d81-4402-bab1-7933135c5d6e',NULL,'o3ipy5aUJMJXDNc-Nvuh4vkUppNI','谁当监护人啊','未成年人的父母已经死亡或者没有监护能力时，由谁担任该未成年人的监护人？','2021-05-15 17:46:24',1,'根据民法总则第二十七条第二款的规定，未成年人的父母已经死亡或者没有监护能力时，由下列有监护能力的人按顺序担任监护人：1.祖父母、外祖父母；2.兄、姐；3.其他愿意担任监护人的个人或者组织，但是须经未成年人住所地的居民委员会、村民委员会或者民政部门同意。\n\n这三类人应当按照上述顺序来担任未成年人的监护人。如果依照上述顺序应当担任监护人的个人认为自己不适合担任监护人，或者认为其他具有监护资格的人更适合担任监护人的，可以依照民法总则第三十条的规定进行协商；协商不成的，按照法定的的监护争议解决程序处理，由居民委员会、村民委员会、民政部门或者人民法院综合各方面情况，根据最有利于被监护人的原则在依法具有监护资格的人中指定监护人。例如，未成年人的祖父母作为第一顺位的监护人，认为自己年事已高，未成年人的姐姐各方面条件更好，由其姐姐担任监护人更有利于未成年人成长，可以先与其姐姐进行协商，协商不成的，依法通过监护争议程序解决。但在法院依法指定监护人前，未成年人的祖父母不得拒绝履行监护职责。','2021-05-15 17:46:38','o3ipy5aUJMJXDNc-Nvuh4vkUppNI',1,1,0);

/*Table structure for table `question` */

DROP TABLE IF EXISTS `question`;

CREATE TABLE `question` (
  `QUE_ID` varchar(36) NOT NULL COMMENT '主键ID',
  `QUE_FATHER_ID` varchar(36) DEFAULT NULL COMMENT '父问题ID',
  `QUE_OPTION` varchar(36) DEFAULT NULL COMMENT '父问题的选项',
  `QUE_TEXT` varchar(255) DEFAULT NULL COMMENT '问题内容',
  `QUE_IF_LEAF` int(11) DEFAULT NULL COMMENT '问题层次 0root1node2leaf',
  `QUE_HAS_OTHER` int(11) DEFAULT NULL COMMENT '是否允许其他 0、1',
  `CLICK_TIMES` int(11) DEFAULT NULL COMMENT '点击次数',
  `UP_TIME` varchar(36) DEFAULT NULL COMMENT '上传时间',
  `UP_ID` varchar(36) DEFAULT NULL COMMENT '上传者',
  `IF_DELETE` int(11) DEFAULT NULL COMMENT '是否删除 0、1',
  PRIMARY KEY (`QUE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='问题表 ';

/*Data for the table `question` */

insert  into `question`(`QUE_ID`,`QUE_FATHER_ID`,`QUE_OPTION`,`QUE_TEXT`,`QUE_IF_LEAF`,`QUE_HAS_OTHER`,`CLICK_TIMES`,`UP_TIME`,`UP_ID`,`IF_DELETE`) values ('0b98b7dd-22de-4e5b-9cf9-b213ce5fc601','f507b2a1-e559-420f-a428-bef5ecdfa94f','小孩问题 ','你是男方还是女方？',1,0,0,'2021-05-15 17:36:38','o3ipy5aUJMJXDNc-Nvuh4vkUppNI',0),('127967f0-c82e-49e5-8f2b-f0ceb6a03128','5fd39dc9-ed80-4ffa-9fbd-1c2a86417ccf','小孩问题','你是男方还是女方？',1,0,0,'2021-05-15 17:31:37','o3ipy5aUJMJXDNc-Nvuh4vkUppNI',0),('23dfbc32-8942-46f9-befd-39dabbb6e066','9aa697de-7b42-4f1a-986c-4bee800cef9e','bb2','bb2?',1,1,0,'2021-05-14 18:04:55','o3ipy5aUJMJXDNc-Nvuh4vkUppNI',0),('2629ce64-4bcd-4a36-a5c8-8b5266b494ef','9aa697de-7b42-4f1a-986c-4bee800cef9e','bbAns1',NULL,2,NULL,0,'2021-05-14 18:17:08','o3ipy5aUJMJXDNc-Nvuh4vkUppNI',0),('2abc1487-e3c6-421e-8aa3-ef9051f9d88a','c1eb3d2f-7e93-4362-b61c-75634def3e4e','cc1','cc1?',1,1,0,'2021-05-14 18:09:50','o3ipy5aUJMJXDNc-Nvuh4vkUppNI',0),('33fe1835-e273-48c2-a576-703a1816f6a0','f507b2a1-e559-420f-a428-bef5ecdfa94f','债权债务问题','你是男方还是女方？',1,0,0,'2021-05-15 17:38:16','o3ipy5aUJMJXDNc-Nvuh4vkUppNI',0),('3a01a24f-c064-44bf-b91c-051194111c9c','f507b2a1-e559-420f-a428-bef5ecdfa94f','能不能解除同居关系',NULL,2,NULL,0,'2021-05-15 17:35:20','o3ipy5aUJMJXDNc-Nvuh4vkUppNI',0),('4ff311cf-8f19-4e16-9a29-5cbfaa04e7d2','23dfbc32-8942-46f9-befd-39dabbb6e066','cc2',NULL,2,NULL,0,'2021-05-14 19:01:34','o3ipy5aUJMJXDNc-Nvuh4vkUppNI',0),('5fd39dc9-ed80-4ffa-9fbd-1c2a86417ccf',NULL,NULL,'请选择你要咨询的法律问题',0,NULL,0,'2021-05-15 17:28:06','o3ipy5aUJMJXDNc-Nvuh4vkUppNI',0),('7ecdc5e6-f035-4e0a-920c-d037e6f6053a','5fd39dc9-ed80-4ffa-9fbd-1c2a86417ccf','离婚后问题','你是男方还是女方？',1,0,0,'2021-05-15 17:32:49','o3ipy5aUJMJXDNc-Nvuh4vkUppNI',0),('884cbaa9-d94e-4891-9eab-fbd3a8a32d62','9aa697de-7b42-4f1a-986c-4bee800cef9e','bbAns2',NULL,2,NULL,0,'2021-05-14 18:43:39','o3ipy5aUJMJXDNc-Nvuh4vkUppNI',0),('89e2505f-ba71-4b98-997e-a9d5d4426b0f','9aa697de-7b42-4f1a-986c-4bee800cef9e','bb4','bb4?',1,0,0,'2021-05-14 18:16:25','o3ipy5aUJMJXDNc-Nvuh4vkUppNI',0),('8eab8921-d47a-4b91-b6d6-27ae4d6c9686','9aa697de-7b42-4f1a-986c-4bee800cef9e','bb3','bb3?',1,1,0,'2021-05-14 18:06:34','o3ipy5aUJMJXDNc-Nvuh4vkUppNI',0),('90e131f8-03f7-44a7-97c2-1cbb01e2ffd3',NULL,NULL,'请选择你要咨询的法律问题',0,NULL,0,'2021-05-15 17:27:27','o3ipy5aUJMJXDNc-Nvuh4vkUppNI',0),('9aa697de-7b42-4f1a-986c-4bee800cef9e',NULL,NULL,'bb',0,NULL,NULL,'2021-05-13 19:58:21','o3ipy5aUJMJXDNc-Nvuh4vkUppNI',0),('adc3e84d-8af4-4bab-9925-c7b65d2202ff','5fd39dc9-ed80-4ffa-9fbd-1c2a86417ccf','能不能离婚','你是男方还是女方？',1,0,0,'2021-05-15 17:31:04','o3ipy5aUJMJXDNc-Nvuh4vkUppNI',0),('c1eb3d2f-7e93-4362-b61c-75634def3e4e','9aa697de-7b42-4f1a-986c-4bee800cef9e','bb1','bb1?',1,1,0,'2021-05-14 17:49:33','o3ipy5aUJMJXDNc-Nvuh4vkUppNI',0),('cdd6c01b-2120-4996-86bf-d24672ea1aa2','f507b2a1-e559-420f-a428-bef5ecdfa94f','财产问题','你是男方还是女方？',1,0,0,'2021-05-15 17:37:53','o3ipy5aUJMJXDNc-Nvuh4vkUppNI',0),('e13a123e-bc73-4540-bc17-dae6e645a902','5fd39dc9-ed80-4ffa-9fbd-1c2a86417ccf','婚姻问题','你要咨询以下什么问题？',1,1,0,'2021-05-15 17:30:01','o3ipy5aUJMJXDNc-Nvuh4vkUppNI',0),('f507b2a1-e559-420f-a428-bef5ecdfa94f','5fd39dc9-ed80-4ffa-9fbd-1c2a86417ccf','同居问题','你想咨询以下什么问题？',1,1,0,'2021-05-15 17:33:58','o3ipy5aUJMJXDNc-Nvuh4vkUppNI',0),('f9622b57-3969-436a-b79f-15b3932f0cfc','5fd39dc9-ed80-4ffa-9fbd-1c2a86417ccf','财产问题','你是男方还是女方？',1,0,0,'2021-05-15 17:32:28','o3ipy5aUJMJXDNc-Nvuh4vkUppNI',0),('fe813f7f-3aa3-4126-b4be-7d841a80804f','5fd39dc9-ed80-4ffa-9fbd-1c2a86417ccf','婚前咨询','你是男方还是女方？',1,0,0,'2021-05-15 17:33:22','o3ipy5aUJMJXDNc-Nvuh4vkUppNI',0);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `USER_ID` varchar(36) NOT NULL COMMENT '主键ID',
  `USER_NAME` varchar(36) DEFAULT NULL COMMENT '用户昵称',
  `USER_AVATAR` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `USER_GENDER` int(11) DEFAULT NULL COMMENT '用户性别',
  `USER_TIME` varchar(36) DEFAULT NULL COMMENT '注册时间',
  `USER_TYPE` int(11) DEFAULT NULL COMMENT '用户类型 0普通;1运维;2管理;3开发',
  `USER_SESSION` varchar(36) DEFAULT NULL COMMENT '登陆状态校验码',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `user` */

insert  into `user`(`USER_ID`,`USER_NAME`,`USER_AVATAR`,`USER_GENDER`,`USER_TIME`,`USER_TYPE`,`USER_SESSION`) values ('o3ipy5aUJMJXDNc-Nvuh4vkUppNI','华仞','https://thirdwx.qlogo.cn/mmopen/vi_32/MuBTa5KLibrdEI77obIGwHTH5hAJqS26RpqoV62AIxckic2aTlqUsWILZhN9lEMz6KKmKzjsic67CFW93HibBRJt3g/132',1,'2021-05-10 10:27:14',3,'b14c8edc-5ea0-4270-939f-deb62558cada');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
