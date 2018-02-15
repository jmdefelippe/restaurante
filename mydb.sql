-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `camarero`
--

DROP TABLE IF EXISTS `camarero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `camarero` (
  `idCamarero` int(11) NOT NULL AUTO_INCREMENT,
  `dni` int(11) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCamarero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `camarero`
--

LOCK TABLES `camarero` WRITE;
/*!40000 ALTER TABLE `camarero` DISABLE KEYS */;
/*!40000 ALTER TABLE `camarero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `dni` int(11) DEFAULT NULL,
  `importeTotal` float DEFAULT NULL,
  `idTipoCliente` int(11) NOT NULL,
  PRIMARY KEY (`idCliente`),
  KEY `fk_cliente_tipoCliente1_idx` (`idTipoCliente`),
  CONSTRAINT `fk_cliente_tipoCliente1` FOREIGN KEY (`idTipoCliente`) REFERENCES `tipocliente` (`idTipoCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comanda`
--

DROP TABLE IF EXISTS `comanda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comanda` (
  `idComanda` int(11) NOT NULL AUTO_INCREMENT,
  `fechaHora` date DEFAULT NULL,
  `idCamarero` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idMesa` int(11) NOT NULL,
  `idTicket` int(11) NOT NULL,
  PRIMARY KEY (`idComanda`),
  KEY `fk_comanda_camarero1_idx` (`idCamarero`),
  KEY `fk_comanda_cliente1_idx` (`idCliente`),
  KEY `fk_comanda_mesa1_idx` (`idMesa`),
  KEY `fk_comanda_ticket1_idx` (`idTicket`),
  CONSTRAINT `fk_comanda_camarero1` FOREIGN KEY (`idCamarero`) REFERENCES `camarero` (`idCamarero`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_comanda_cliente1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_comanda_mesa1` FOREIGN KEY (`idMesa`) REFERENCES `mesa` (`idMesa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_comanda_ticket1` FOREIGN KEY (`idTicket`) REFERENCES `ticket` (`idTicket`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comanda`
--

LOCK TABLES `comanda` WRITE;
/*!40000 ALTER TABLE `comanda` DISABLE KEYS */;
/*!40000 ALTER TABLE `comanda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `componentemenu`
--

DROP TABLE IF EXISTS `componentemenu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `componentemenu` (
  `idComponenteMenu` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `imagen` varchar(45) DEFAULT NULL,
  `disponibilidad` varchar(45) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `estado` tinyint(4) DEFAULT NULL,
  `idSubrubro` int(11) NOT NULL,
  PRIMARY KEY (`idComponenteMenu`),
  KEY `fk_componenteMenu_subrubro1_idx` (`idSubrubro`),
  CONSTRAINT `fk_componenteMenu_subrubro1` FOREIGN KEY (`idSubrubro`) REFERENCES `subrubro` (`idSubrubro`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `componentemenu`
--

LOCK TABLES `componentemenu` WRITE;
/*!40000 ALTER TABLE `componentemenu` DISABLE KEYS */;
/*!40000 ALTER TABLE `componentemenu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conversion`
--

DROP TABLE IF EXISTS `conversion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conversion` (
  `idConversion` int(11) NOT NULL AUTO_INCREMENT,
  `unidadMedida` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idConversion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conversion`
--

LOCK TABLES `conversion` WRITE;
/*!40000 ALTER TABLE `conversion` DISABLE KEYS */;
/*!40000 ALTER TABLE `conversion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingrediente`
--

DROP TABLE IF EXISTS `ingrediente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingrediente` (
  `idIngrediente` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad` int(11) DEFAULT NULL,
  `unidad` varchar(45) DEFAULT NULL,
  `idPlato` int(11) NOT NULL,
  PRIMARY KEY (`idIngrediente`),
  KEY `fk_ingrediente_plato1_idx` (`idPlato`),
  CONSTRAINT `fk_ingrediente_plato1` FOREIGN KEY (`idPlato`) REFERENCES `plato` (`idPlato`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingrediente`
--

LOCK TABLES `ingrediente` WRITE;
/*!40000 ALTER TABLE `ingrediente` DISABLE KEYS */;
/*!40000 ALTER TABLE `ingrediente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemlistaprecio`
--

DROP TABLE IF EXISTS `itemlistaprecio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemlistaprecio` (
  `idItemListaPrecio` int(11) NOT NULL AUTO_INCREMENT,
  `precio` float DEFAULT NULL,
  `idComponenteMenu` int(11) NOT NULL,
  PRIMARY KEY (`idItemListaPrecio`),
  KEY `fk_itemListaPrecio_componenteMenu1_idx` (`idComponenteMenu`),
  CONSTRAINT `fk_itemListaPrecio_componenteMenu1` FOREIGN KEY (`idComponenteMenu`) REFERENCES `componentemenu` (`idComponenteMenu`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemlistaprecio`
--

LOCK TABLES `itemlistaprecio` WRITE;
/*!40000 ALTER TABLE `itemlistaprecio` DISABLE KEYS */;
/*!40000 ALTER TABLE `itemlistaprecio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `listaprecio`
--

DROP TABLE IF EXISTS `listaprecio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `listaprecio` (
  `idListaPrecio` int(11) NOT NULL AUTO_INCREMENT,
  `fechaDesde` date DEFAULT NULL,
  `fechaHasta` date DEFAULT NULL,
  `idItemListaPrecio` int(11) NOT NULL,
  PRIMARY KEY (`idListaPrecio`),
  KEY `fk_listaPrecio_itemListaPrecio1_idx` (`idItemListaPrecio`),
  CONSTRAINT `fk_listaPrecio_itemListaPrecio1` FOREIGN KEY (`idItemListaPrecio`) REFERENCES `itemlistaprecio` (`idItemListaPrecio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `listaprecio`
--

LOCK TABLES `listaprecio` WRITE;
/*!40000 ALTER TABLE `listaprecio` DISABLE KEYS */;
/*!40000 ALTER TABLE `listaprecio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `idMenu` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `idRestaurant` int(11) NOT NULL,
  PRIMARY KEY (`idMenu`),
  KEY `fk_menu_restaurant1_idx` (`idRestaurant`),
  CONSTRAINT `fk_menu_restaurant1` FOREIGN KEY (`idRestaurant`) REFERENCES `restaurant` (`idRestaurant`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu_has_componentemenu`
--

DROP TABLE IF EXISTS `menu_has_componentemenu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu_has_componentemenu` (
  `idMenu` int(11) NOT NULL,
  `idComponenteMenu` int(11) NOT NULL,
  PRIMARY KEY (`idMenu`,`idComponenteMenu`),
  KEY `fk_menu_has_componenteMenu_componenteMenu1_idx` (`idComponenteMenu`),
  KEY `fk_menu_has_componenteMenu_menu1_idx` (`idMenu`),
  CONSTRAINT `fk_menu_has_componenteMenu_componenteMenu1` FOREIGN KEY (`idComponenteMenu`) REFERENCES `componentemenu` (`idComponenteMenu`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_menu_has_componenteMenu_menu1` FOREIGN KEY (`idMenu`) REFERENCES `menu` (`idMenu`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu_has_componentemenu`
--

LOCK TABLES `menu_has_componentemenu` WRITE;
/*!40000 ALTER TABLE `menu_has_componentemenu` DISABLE KEYS */;
/*!40000 ALTER TABLE `menu_has_componentemenu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mesa`
--

DROP TABLE IF EXISTS `mesa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mesa` (
  `idMesa` int(11) NOT NULL AUTO_INCREMENT,
  `capacidad` int(11) DEFAULT NULL,
  `idMesaN` int(11) NOT NULL,
  `idSalon` int(11) NOT NULL,
  PRIMARY KEY (`idMesa`),
  KEY `fk_mesa_mesa1_idx` (`idMesaN`),
  KEY `fk_mesa_salon1_idx` (`idSalon`),
  CONSTRAINT `fk_mesa_mesa1` FOREIGN KEY (`idMesaN`) REFERENCES `mesa` (`idMesa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_mesa_salon1` FOREIGN KEY (`idSalon`) REFERENCES `salon` (`idSalon`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mesa`
--

LOCK TABLES `mesa` WRITE;
/*!40000 ALTER TABLE `mesa` DISABLE KEYS */;
/*!40000 ALTER TABLE `mesa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permiso`
--

DROP TABLE IF EXISTS `permiso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permiso` (
  `idPermiso` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idPermiso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permiso`
--

LOCK TABLES `permiso` WRITE;
/*!40000 ALTER TABLE `permiso` DISABLE KEYS */;
/*!40000 ALTER TABLE `permiso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plato`
--

DROP TABLE IF EXISTS `plato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plato` (
  `idPlato` int(11) NOT NULL,
  PRIMARY KEY (`idPlato`),
  KEY `fk_plato_componenteMenu1_idx` (`idPlato`),
  CONSTRAINT `fk_plato_componenteMenu1` FOREIGN KEY (`idPlato`) REFERENCES `componentemenu` (`idComponenteMenu`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plato`
--

LOCK TABLES `plato` WRITE;
/*!40000 ALTER TABLE `plato` DISABLE KEYS */;
/*!40000 ALTER TABLE `plato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `cantidad` varchar(45) DEFAULT NULL,
  `idConversion` int(11) NOT NULL,
  PRIMARY KEY (`idProducto`),
  KEY `fk_producto_conversion1_idx` (`idConversion`),
  CONSTRAINT `fk_producto_conversion1` FOREIGN KEY (`idConversion`) REFERENCES `conversion` (`idConversion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant`
--

DROP TABLE IF EXISTS `restaurant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurant` (
  `idRestaurant` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `localidad` varchar(45) DEFAULT NULL,
  `correoElectronico` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idRestaurant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant`
--

LOCK TABLES `restaurant` WRITE;
/*!40000 ALTER TABLE `restaurant` DISABLE KEYS */;
/*!40000 ALTER TABLE `restaurant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rubro`
--

DROP TABLE IF EXISTS `rubro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rubro` (
  `idRubro` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idRubro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rubro`
--

LOCK TABLES `rubro` WRITE;
/*!40000 ALTER TABLE `rubro` DISABLE KEYS */;
/*!40000 ALTER TABLE `rubro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salon`
--

DROP TABLE IF EXISTS `salon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salon` (
  `idSalon` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `idRestaurant` int(11) NOT NULL,
  PRIMARY KEY (`idSalon`),
  KEY `fk_salon_restaurant1_idx` (`idRestaurant`),
  CONSTRAINT `fk_salon_restaurant1` FOREIGN KEY (`idRestaurant`) REFERENCES `restaurant` (`idRestaurant`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salon`
--

LOCK TABLES `salon` WRITE;
/*!40000 ALTER TABLE `salon` DISABLE KEYS */;
/*!40000 ALTER TABLE `salon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subrubro`
--

DROP TABLE IF EXISTS `subrubro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subrubro` (
  `idSubrubro` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `idRubro` int(11) NOT NULL,
  PRIMARY KEY (`idSubrubro`),
  KEY `fk_subrubro_rubro1_idx` (`idRubro`),
  CONSTRAINT `fk_subrubro_rubro1` FOREIGN KEY (`idRubro`) REFERENCES `rubro` (`idRubro`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subrubro`
--

LOCK TABLES `subrubro` WRITE;
/*!40000 ALTER TABLE `subrubro` DISABLE KEYS */;
/*!40000 ALTER TABLE `subrubro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket` (
  `idTicket` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `pagado` tinyint(4) DEFAULT NULL,
  `cortesia` tinyint(4) DEFAULT NULL,
  `total` float DEFAULT NULL,
  `idRestaurant` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  PRIMARY KEY (`idTicket`),
  KEY `fk_ticket_restaurant1_idx` (`idRestaurant`),
  KEY `fk_ticket_usuario1_idx` (`idUsuario`),
  CONSTRAINT `fk_ticket_restaurant1` FOREIGN KEY (`idRestaurant`) REFERENCES `restaurant` (`idRestaurant`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_usuario1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipocliente`
--

DROP TABLE IF EXISTS `tipocliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipocliente` (
  `idTipoCliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `idListaPrecio` int(11) NOT NULL,
  PRIMARY KEY (`idTipoCliente`),
  KEY `fk_tipoCliente_listaPrecio1_idx` (`idListaPrecio`),
  CONSTRAINT `fk_tipoCliente_listaPrecio1` FOREIGN KEY (`idListaPrecio`) REFERENCES `listaprecio` (`idListaPrecio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipocliente`
--

LOCK TABLES `tipocliente` WRITE;
/*!40000 ALTER TABLE `tipocliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipocliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipousuario`
--

DROP TABLE IF EXISTS `tipousuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipousuario` (
  `idTipoUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `idPermiso` int(11) NOT NULL,
  PRIMARY KEY (`idTipoUsuario`),
  KEY `fk_tipoUsuario_permiso1_idx` (`idPermiso`),
  CONSTRAINT `fk_tipoUsuario_permiso1` FOREIGN KEY (`idPermiso`) REFERENCES `permiso` (`idPermiso`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipousuario`
--

LOCK TABLES `tipousuario` WRITE;
/*!40000 ALTER TABLE `tipousuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipousuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `dni` int(11) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `idTipoUsuario` int(11) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `fk_usuario_tipoUsuario1_idx` (`idTipoUsuario`),
  CONSTRAINT `fk_usuario_tipoUsuario1` FOREIGN KEY (`idTipoUsuario`) REFERENCES `tipousuario` (`idTipoUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vianda`
--

DROP TABLE IF EXISTS `vianda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vianda` (
  `idVianda` int(11) NOT NULL,
  `idPlato` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  PRIMARY KEY (`idVianda`),
  KEY `fk_vianda_componenteMenu1_idx` (`idVianda`),
  KEY `fk_vianda_plato1_idx` (`idPlato`),
  KEY `fk_vianda_producto1_idx` (`idProducto`),
  CONSTRAINT `fk_vianda_componenteMenu1` FOREIGN KEY (`idVianda`) REFERENCES `componentemenu` (`idComponenteMenu`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_vianda_plato1` FOREIGN KEY (`idPlato`) REFERENCES `plato` (`idPlato`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_vianda_producto1` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vianda`
--

LOCK TABLES `vianda` WRITE;
/*!40000 ALTER TABLE `vianda` DISABLE KEYS */;
/*!40000 ALTER TABLE `vianda` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-15  8:53:20
