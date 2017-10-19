DROP TABLE IF EXISTS `ncdc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ncdc` (
  `STN` varchar(45) DEFAULT NULL,
  `WBAN` varchar(45) DEFAULT NULL,
  `YEARMODA` varchar(45) DEFAULT NULL,
  `TEMP` varchar(45) DEFAULT NULL,
  `DEWP` varchar(45) DEFAULT NULL,
  `SLP` varchar(45) DEFAULT NULL,
  `STP` varchar(45) DEFAULT NULL,
  `VISIB` varchar(45) DEFAULT NULL,
  `WDSP` varchar(45) DEFAULT NULL,
  `MXSPD` varchar(45) DEFAULT NULL,
  `GUST` varchar(45) DEFAULT NULL,
  `MAX` varchar(45) DEFAULT NULL,
  `MIN` varchar(45) DEFAULT NULL,
  `PRCP` varchar(45) DEFAULT NULL,
  `SNDP` varchar(45) DEFAULT NULL,
  `FRSHTT` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
