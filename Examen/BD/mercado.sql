# ************************************************************
# Sequel Pro SQL dump
# Versi�n 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.6.37)
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Volcado de tabla productos
# ------------------------------------------------------------

DROP TABLE IF EXISTS `productos`;

CREATE TABLE `productos` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `producto` varchar(50) DEFAULT '',
  `precio` float DEFAULT NULL,
  `seccion` varchar(50) DEFAULT NULL,
  `estanteria` varchar(50) DEFAULT NULL,
  `disponible` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;

INSERT INTO `productos` (`id`, `producto`, `precio`, `seccion`, `estanteria`, `disponible`)
VALUES
	(1,'LIMONES',1.89,'FRUTERIA','PASILLO CENTRAL',15),
	(2,'NARANJAS',1.69,'FRUTERIA','PASILLO CENTRAL',12),
	(3,'PLATANOS',1.75,'FRUTERIA','PASILLO CENTRAL',2),
	(4,'CHORIZO',3.25,'CHARCUTERIA','LATERAL IZQUIERDO',20),
	(5,'JAMON',4.21,'CHARCUTERIA','LATERAL IZQUIERDO',16),
	(6,'SALMON',12.05,'PESCADERIA','LATERAL IZQUIERDO',8),
	(7,'BOLLERIA',2.1,'PANADERIA','PASILLO CENTRAL',7);

/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;


# Volcado de tabla ubicacion
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ubicacion`;

CREATE TABLE `ubicacion` (
  `id_ubic` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `seccion` varchar(50) DEFAULT NULL,
  `ubicacion` varchar(50) DEFAULT NULL,
  `num_estanteria` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_ubic`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `ubicacion` WRITE;
/*!40000 ALTER TABLE `ubicacion` DISABLE KEYS */;

INSERT INTO `ubicacion` (`id_ubic`, `seccion`, `ubicacion`, `num_estanteria`)
VALUES
	(1,'FRUTERIA','PASILLO CENTRAL',5),
	(2,'CHARCUTERIA','LATERAL IZQUIERDO',3),
	(3,'CARNICERIA','LATERAL IZQUIERDO',2),
	(4,'COSMETICOS','PLANTA 2',7),
	(5,'PESCADERIA','LATERAL IZQUIERDO',4),
	(6,'PANADERIA','PASILLO CENTRAL',4);

/*!40000 ALTER TABLE `ubicacion` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

