------------------------------------------------------- company and employee -------------------------------------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `CompanyID` int(11) DEFAULT NULL,
  `Salary` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `company` (`ID`, `NAME`) VALUES ('1', 'hp');
INSERT INTO `company` (`ID`, `NAME`) VALUES ('2', 'golive');

INSERT INTO `employee` (`ID`, `NAME`,`CompanyID`,`Salary`) VALUES ('1', 'sfxie1', '1',12);
INSERT INTO `employee` (`ID`, `NAME`,`CompanyID`,`Salary`) VALUES ('2', 'sfxie2', '1',11);

INSERT INTO `employee` (`ID`, `NAME`,`CompanyID`,`Salary`) VALUES ('765', 'sfxie765', '1',23);
INSERT INTO `employee` (`ID`, `NAME`,`CompanyID`,`Salary`) VALUES ('767', 'sfxie767', '1',21);
INSERT INTO `employee` (`ID`, `NAME`,`CompanyID`,`Salary`) VALUES ('768', 'sfxie768', '1',12);
INSERT INTO `employee` (`ID`, `NAME`,`CompanyID`,`Salary`) VALUES ('769', 'sfxie769', '1',22);

INSERT INTO `employee` (`ID`, `NAME`,`CompanyID`,`Salary`) VALUES ('1023', 'sfxie1023', '2',16);
INSERT INTO `employee` (`ID`, `NAME`,`CompanyID`,`Salary`) VALUES ('1024', 'sfxie1024', '2',14);
INSERT INTO `employee` (`ID`, `NAME`,`CompanyID`,`Salary`) VALUES ('1025', 'sfxie1025', '2',8);

-- 联合查询(排序)
select c.`NAME` , COUNT(1)  from company c,employee e where e.COMPANYID = c.ID and e.ID in(768,765,1,1024) GROUP BY `NAME`;
-- 联合查询(排序,分页)
select c.`NAME` name1 ,e.`NAME` name2 from company c,employee e where e.COMPANYID = c.ID   ORDER BY name2 DESC  LIMIT 0,111;
------------------------------------------------------- company and employee -------------------------------------------------------