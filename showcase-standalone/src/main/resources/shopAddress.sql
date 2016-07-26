/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table shop_addresses
# ------------------------------------------------------------

DROP TABLE IF EXISTS `shop_addresses`;

CREATE TABLE `shop_addresses` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(20) NOT NULL COMMENT '店铺id',
  `shop_name` varchar(50) DEFAULT NULL COMMENT '店铺名称',
  `phone` varchar(32) DEFAULT NULL COMMENT '固定电话',
  `province` varchar(50) DEFAULT '' COMMENT '省',
  `city` varchar(50) DEFAULT '' COMMENT '市',
  `region` varchar(50) DEFAULT NULL COMMENT '区',
  `street` varchar(50) DEFAULT NULL COMMENT '街道，可以为空',
  `detail` varchar(256) DEFAULT 'null' COMMENT '详细地址',
  `status` tinyint(1) DEFAULT NULL COMMENT '状态 0:删除, 1:正常',
  `extra_json` varchar(1000) DEFAULT NULL,
  `created_at` datetime NOT NULL COMMENT '创建时间',
  `updated_at` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_bk_shop_id` (`shop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `shop_addresses` WRITE;
/*!40000 ALTER TABLE `shop_addresses` DISABLE KEYS */;

INSERT INTO `shop_addresses` (`id`, `shop_id`, `shop_name`, `phone`, `province`, `city`, `region`, `street`, `detail`, `status`, `extra_json`, `created_at`, `updated_at`)
VALUES
	(1,1,'老李快印','18610696090','北京','北京市','东城区','文化西路',NULL,1,NULL,'2016-06-24 17:30:35','2016-06-24 17:30:35'),
	(2,2,'华苑店','13488858881','天津','天津市','南开区','开华道科馨公寓23号底商',NULL,1,NULL,'2016-07-01 20:41:03','2016-07-04 14:39:05'),
	(3,2,'2333','13488858881','天津','天津市','南开区','322',NULL,0,NULL,'2016-07-21 13:54:59','2016-07-21 13:54:59'),
	(4,8,'朝阳门店','19013931291','北京','北京市','东城区','虹口大道',NULL,1,NULL,'2016-07-21 15:00:34','2016-07-21 15:00:34'),
	(5,2,'2333','13488858881','天津','天津市','南开区','322',NULL,0,NULL,'2016-07-21 13:54:59','2016-07-21 13:54:59'),
	(6,2,'2333','13488858881','天津','天津市','南开区','322',NULL,0,NULL,'2016-07-21 13:54:59','2016-07-21 13:54:59'),
	(7,89,'天津',NULL,'山东','',NULL,NULL,'胡同里面走',NULL,NULL,'2016-07-26 14:22:32','2016-07-26 14:36:08');

/*!40000 ALTER TABLE `shop_addresses` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
