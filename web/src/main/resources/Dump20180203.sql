-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: shopac
-- ------------------------------------------------------
-- Server version	5.7.20-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_address`
--

DROP TABLE IF EXISTS `t_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_address` (
  `id_user` bigint(20) NOT NULL,
  `country` varchar(45) DEFAULT NULL,
  `sity` varchar(45) DEFAULT NULL,
  `street` varchar(45) DEFAULT NULL,
  `house` int(11) DEFAULT NULL,
  `building` varchar(45) DEFAULT NULL,
  `flat` int(11) DEFAULT NULL,
  KEY `address_user_idx` (`id_user`),
  CONSTRAINT `address_user` FOREIGN KEY (`id_user`) REFERENCES `t_user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_address`
--

LOCK TABLES `t_address` WRITE;
/*!40000 ALTER TABLE `t_address` DISABLE KEYS */;
INSERT INTO `t_address` VALUES (2,'By','Minsk','Lenina',23,'2',42),(3,'By','Brest','Marksa',10,NULL,142),(4,'By','Gomel','Pobedi',8,'3',14),(5,'By','Minsk','Molotova',147,NULL,15),(6,'By','Brest','Gintovta',25,'2',64);
/*!40000 ALTER TABLE `t_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_buy`
--

DROP TABLE IF EXISTS `t_buy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_buy` (
  `id_buy` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_user` bigint(20) NOT NULL,
  `date` datetime NOT NULL,
  `status` varchar(45) DEFAULT NULL,
  `cost` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id_buy`),
  KEY `user_buy_idx` (`id_user`),
  CONSTRAINT `user_buy` FOREIGN KEY (`id_user`) REFERENCES `t_user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_buy`
--

LOCK TABLES `t_buy` WRITE;
/*!40000 ALTER TABLE `t_buy` DISABLE KEYS */;
INSERT INTO `t_buy` VALUES (1,2,'2018-01-03 22:37:07',NULL,888.00),(3,2,'2018-01-16 13:08:08',NULL,450.00);
/*!40000 ALTER TABLE `t_buy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_buy_goods`
--

DROP TABLE IF EXISTS `t_buy_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_buy_goods` (
  `id_buy` bigint(20) NOT NULL,
  `id_goods` bigint(20) NOT NULL,
  KEY `buy_goods_idx` (`id_buy`),
  KEY `goods_buy_idx` (`id_goods`),
  CONSTRAINT `buy_goods` FOREIGN KEY (`id_buy`) REFERENCES `t_buy` (`id_buy`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `goods_buy` FOREIGN KEY (`id_goods`) REFERENCES `t_goods` (`id_goods`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_buy_goods`
--

LOCK TABLES `t_buy_goods` WRITE;
/*!40000 ALTER TABLE `t_buy_goods` DISABLE KEYS */;
INSERT INTO `t_buy_goods` VALUES (1,2),(1,1),(1,3),(1,3),(3,2),(3,4);
/*!40000 ALTER TABLE `t_buy_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_comment`
--

DROP TABLE IF EXISTS `t_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_comment` (
  `id_comment` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_news` bigint(20) NOT NULL,
  `comment` text,
  `date` datetime DEFAULT NULL,
  `id_user` bigint(20) NOT NULL,
  PRIMARY KEY (`id_comment`),
  KEY `news_commment_idx` (`id_news`),
  CONSTRAINT `news_commment` FOREIGN KEY (`id_news`) REFERENCES `t_news` (`id_news`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_comment`
--

LOCK TABLES `t_comment` WRITE;
/*!40000 ALTER TABLE `t_comment` DISABLE KEYS */;
INSERT INTO `t_comment` VALUES (1,12,'По сей день набор слов. разница в различных языках. Сегодня существует несколько вариантов lorem ipsum на сайтах и. Внешнего вида контента, просмотра шрифтов, абзацев, отступов и на кириллице значительно. Сайтах и слова, получив текст-рыбу, широко используемый.','2018-01-29 22:53:25',4),(2,13,'Качестве рыбы текст на руку при запуске. Алфавит, могут возникнуть небольшие проблемы. Текст-рыбу, широко используемый и на кириллический контент – написание символов. Существует несколько вариантов lorem вставки на кириллический контент.','2015-01-29 22:53:29',2),(3,5,'Он веб-дизайнерами для вставки на латыни и слова, получив текст-рыбу, широко используемый. ','2020-03-29 22:53:35',2),(4,6,'Ipsum на название, не имеет никакого отношения. Небольшие проблемы: в xvi веке самым. Из его применили в различных языках те или иные буквы.','2021-03-01 22:53:40',4),(5,5,'Частотой, имеется разница в длине наиболее распространенных слов известным рыбным текстом. Вывод, что такое текст-рыба небольшие проблемы: в различных языках те или иные.','2011-05-13 22:53:54',6),(6,6,'Алфавит, могут возникнуть небольшие проблемы: в книгопечатании еще. Используемый и проектах, ориентированных на название.','2013-08-29 22:54:05',5),(7,5,'Все же лучше использовать в книгопечатании еще в xvi веке частотой имеется. О пределах добра и демонстрации внешнего вида контента. ','2013-03-26 22:54:17',3),(8,10,'Книгопечатании еще в различных языках те или иные. Еще в длине наиболее распространенных слов качества восприятия макета буквы встречаются. Название, не имеет никакого отношения к обитателям водоемов. ','2014-04-29 22:54:26',3);
/*!40000 ALTER TABLE `t_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_goods`
--

DROP TABLE IF EXISTS `t_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_goods` (
  `id_goods` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `inv_number` int(11) DEFAULT NULL,
  `soft_delete` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id_goods`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_goods`
--

LOCK TABLES `t_goods` WRITE;
/*!40000 ALTER TABLE `t_goods` DISABLE KEYS */;
INSERT INTO `t_goods` VALUES (1,'TV-set',640.00,'Samsung',12456,NULL),(2,'Radio',12.00,'Toshiba',64558,NULL),(3,'Laptop',740.00,'Lenovo',88524,NULL),(4,'Mouse',15.00,'Logitech',45787,NULL),(5,'CD',2.00,'LG',56555,NULL),(6,'Monitor',220.00,'LG',45000,NULL),(7,'Mouse',17.00,'Lenovo',89745,NULL),(8,'Radio',16.00,'Canyon',44555,NULL),(9,'Table',150.00,'NoName',11545,NULL),(10,'Window',100.00,'10',65789,NULL),(11,'Linux',30.00,'NoName',56234,NULL);
/*!40000 ALTER TABLE `t_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_news`
--

DROP TABLE IF EXISTS `t_news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_news` (
  `id_news` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `text` text,
  `id_user` bigint(20) NOT NULL,
  `date` datetime DEFAULT NULL,
  `pics` varchar(45) DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  `path` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_news`),
  KEY `user_news_idx` (`id_user`),
  CONSTRAINT `user_news` FOREIGN KEY (`id_user`) REFERENCES `t_user` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_news`
--

LOCK TABLES `t_news` WRITE;
/*!40000 ALTER TABLE `t_news` DISABLE KEYS */;
INSERT INTO `t_news` VALUES (5,'Это сгенерированный текс !','Кроме того, есть специальные генераторы, создающие собственные. Восприятия макета иные буквы встречаются с использованием lorem создающие собственные варианты. Вырвал отдельные фразы и демонстрации внешнего вида контента, просмотра шрифтов, абзацев отступов. Разница в xvi веке значительно. Или иные буквы встречаются с разной частотой. Имеется разница в xvi веке отдельные фразы. Оценке качества восприятия макета значительно различается своим появлением lorem языках. Текст-рыбу, широко используемый и по сей день.',5,'2018-01-29 17:42:36','5','Мухин Вася',NULL),(6,'Сгенерированный текст !','Фразы и проектах, ориентированных на кириллице значительно различается текст-рыбу. Разница в различных языках те или иные буквы встречаются с разной. Кроме того, есть специальные генераторы, создающие собственные варианты текста. Книгопечатник вырвал отдельные фразы и на руку при запуске проекта. Оценке качества восприятия макета планируется использовать в различных языках. Именно из его трактата. Того, есть специальные генераторы, создающие собственные варианты текста.',6,'2018-03-29 17:42:59','6','Глебов Пётр',NULL),(9,'Ещё один.','Распространенных слов буквы встречаются с разной частотой. Смысловую нагрузку ему нести совсем необязательно. Текста сыграет на название, не имеет никакого отношения. Разной частотой, имеется разница в длине наиболее распространенных слов латинский алфавит могут. Сайтах и слова, получив текст-рыбу широко. Название, не имеет никакого отношения к обитателям. Ведь именно из его трактата. Имеется разница в книгопечатании еще в различных языках. Вида контента, просмотра шрифтов абзацев.',5,'2015-01-25 19:58:02','','Миха Селеванов',NULL),(10,'Вот ещё следующий','Этот, несмотря на руку. Цицерону, ведь именно из его трактата о пределах добра. Вопросы, связанные с языками, использующими латинский алфавит, могут возникнуть. Использовать в качестве рыбы текст на интернет-страницы и даже. Трактата, благодаря чему появляется возможность получить более длинный. Различных языках те или иные буквы встречаются. Варианты текста на том языке, который планируется использовать. Древнеримскому философу цицерону, ведь именно из. ',5,'2021-07-15 19:58:12',NULL,'Катя Викина',NULL),(11,'Текст','Варианты текста на интернет-страницы и слова, получив текст-рыбу, широко используемый. Разной частотой, имеется разница в качестве рыбы текст на кириллице значительно. Совсем необязательно разной частотой имеется. Разной частотой, имеется разница в длине наиболее распространенных слов языках. Те или иные буквы встречаются с разной частотой, имеется разница. С разной частотой, имеется разница в книгопечатании еще в. Кроме того, нечитабельность текста сыграет на название, не имеет никакого. ',6,'2018-01-29 19:58:49','11','Белкин',NULL),(12,'Ещё один текст','Слова, получив текст-рыбу, широко используемый и т.д. Текст этот, несмотря на название. Символов на латыни и зла средневековый. Обязан древнеримскому философу цицерону, ведь именно из его трактата. Обитателям водоемов качестве рыбы текст этот, несмотря на руку при оценке качества. Совсем необязательно восприятия макета демонстрации внешнего. Его применили в длине наиболее распространенных слов. Конечно, возникают некоторые вопросы, связанные с использованием. ',5,'2014-01-25 20:00:11',NULL,'Васькин',NULL),(13,'Текст тут?','Того, есть специальные генераторы, создающие собственные варианты текста сыграет на сайтах. Отношения к обитателям водоемов фразы. Некоторые вопросы, связанные с языками использующими. Рыбы текст на интернет-страницы. Веб-дизайнерами для вставки на основе оригинального трактата, благодаря чему появляется возможность. Алфавит, могут возникнуть небольшие проблемы. Руку при оценке качества восприятия. Несмотря на интернет-страницы и смысловую нагрузку. Иные буквы встречаются с языками, использующими латинский алфавит, могут возникнуть небольшие проблемы. ',5,'2015-04-08 20:16:51',NULL,'Пупкин',NULL);
/*!40000 ALTER TABLE `t_news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `id_user` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(45) DEFAULT 'user',
  `info` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (2,'Fedya','Fedin','fed@mail.ru',7772233,'login1','login1','ROLE_USER',NULL),(3,'Genya','Zlobin','zlob@gmail.com',2224477,'login2','login2','ROLE_USER',NULL),(4,'Victor','Zimin','zim@tut.by',3334433,'login3','login3','ROLE_USER',NULL),(5,'Sergey','Baklanov','bak@mail.ru',3264877,'login4','login4','ROLE_ADMIN',NULL),(6,'Katya','Belkina','kat@tut.by',2356891,'login5','login5','ROLE_SADMIN',NULL);
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user_msg`
--

DROP TABLE IF EXISTS `t_user_msg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user_msg` (
  `id_user_msg` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_user` bigint(20) NOT NULL,
  `msg` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_user_msg`),
  KEY `user_msg_idx` (`id_user`),
  CONSTRAINT `user_msg` FOREIGN KEY (`id_user`) REFERENCES `t_user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_msg`
--

LOCK TABLES `t_user_msg` WRITE;
/*!40000 ALTER TABLE `t_user_msg` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_user_msg` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-03  9:34:27
