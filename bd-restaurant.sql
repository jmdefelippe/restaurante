-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema bd-restaurant
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bd-restaurant
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bd-restaurant` DEFAULT CHARACTER SET utf8 ;
USE `bd-restaurant` ;

-- -----------------------------------------------------
-- Table `bd-restaurant`.`rubro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-restaurant`.`rubro` (
  `idRubro` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`idRubro`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-restaurant`.`subrubro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-restaurant`.`subrubro` (
  `idSubrubro` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `idRubro` INT NOT NULL,
  PRIMARY KEY (`idSubrubro`),
  INDEX `fk_subrubro_rubro1_idx` (`idRubro` ASC),
  CONSTRAINT `fk_subrubro_rubro1`
    FOREIGN KEY (`idRubro`)
    REFERENCES `bd-restaurant`.`rubro` (`idRubro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-restaurant`.`componenteMenu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-restaurant`.`componenteMenu` (
  `idComponenteMenu` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `descripcion` VARCHAR(45) NULL,
  `imagen` VARCHAR(45) NULL,
  `disponibilidad` VARCHAR(45) NULL,
  `fecha` DATE NULL,
  `estado` TINYINT NULL,
  `idSubrubro` INT NOT NULL,
  PRIMARY KEY (`idComponenteMenu`),
  INDEX `fk_componenteMenu_subrubro1_idx` (`idSubrubro` ASC),
  CONSTRAINT `fk_componenteMenu_subrubro1`
    FOREIGN KEY (`idSubrubro`)
    REFERENCES `bd-restaurant`.`subrubro` (`idSubrubro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-restaurant`.`plato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-restaurant`.`plato` (
  `idPlato` INT NOT NULL,
  PRIMARY KEY (`idPlato`),
  INDEX `fk_plato_componenteMenu1_idx` (`idPlato` ASC),
  CONSTRAINT `fk_plato_componenteMenu1`
    FOREIGN KEY (`idPlato`)
    REFERENCES `bd-restaurant`.`componenteMenu` (`idComponenteMenu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-restaurant`.`ingrediente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-restaurant`.`ingrediente` (
  `idIngrediente` INT NOT NULL AUTO_INCREMENT,
  `cantidad` INT NULL,
  `unidad` VARCHAR(45) NULL,
  `idPlato` INT NOT NULL,
  PRIMARY KEY (`idIngrediente`),
  INDEX `fk_ingrediente_plato1_idx` (`idPlato` ASC),
  CONSTRAINT `fk_ingrediente_plato1`
    FOREIGN KEY (`idPlato`)
    REFERENCES `bd-restaurant`.`plato` (`idPlato`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-restaurant`.`conversion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-restaurant`.`conversion` (
  `idConversion` INT NOT NULL AUTO_INCREMENT,
  `unidadMedida` VARCHAR(45) NULL,
  PRIMARY KEY (`idConversion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-restaurant`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-restaurant`.`producto` (
  `idProducto` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `descripcion` VARCHAR(45) NULL,
  `cantidad` VARCHAR(45) NULL,
  `idConversion` INT NOT NULL,
  PRIMARY KEY (`idProducto`),
  INDEX `fk_producto_conversion1_idx` (`idConversion` ASC),
  CONSTRAINT `fk_producto_conversion1`
    FOREIGN KEY (`idConversion`)
    REFERENCES `bd-restaurant`.`conversion` (`idConversion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-restaurant`.`vianda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-restaurant`.`vianda` (
  `idVianda` INT NOT NULL,
  `idPlato` INT NOT NULL,
  `idProducto` INT NOT NULL,
  PRIMARY KEY (`idVianda`),
  INDEX `fk_vianda_componenteMenu1_idx` (`idVianda` ASC),
  INDEX `fk_vianda_plato1_idx` (`idPlato` ASC),
  INDEX `fk_vianda_producto1_idx` (`idProducto` ASC),
  CONSTRAINT `fk_vianda_componenteMenu1`
    FOREIGN KEY (`idVianda`)
    REFERENCES `bd-restaurant`.`componenteMenu` (`idComponenteMenu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vianda_plato1`
    FOREIGN KEY (`idPlato`)
    REFERENCES `bd-restaurant`.`plato` (`idPlato`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vianda_producto1`
    FOREIGN KEY (`idProducto`)
    REFERENCES `bd-restaurant`.`producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-restaurant`.`restaurant`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-restaurant`.`restaurant` (
  `idRestaurant` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  `direccion` VARCHAR(45) NULL,
  `localidad` VARCHAR(45) NULL,
  `correoElectronico` VARCHAR(45) NULL,
  PRIMARY KEY (`idRestaurant`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-restaurant`.`menu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-restaurant`.`menu` (
  `idMenu` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `fecha` DATE NULL,
  `idRestaurant` INT NOT NULL,
  PRIMARY KEY (`idMenu`),
  INDEX `fk_menu_restaurant1_idx` (`idRestaurant` ASC),
  CONSTRAINT `fk_menu_restaurant1`
    FOREIGN KEY (`idRestaurant`)
    REFERENCES `bd-restaurant`.`restaurant` (`idRestaurant`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-restaurant`.`menu_has_componenteMenu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-restaurant`.`menu_has_componenteMenu` (
  `idMenu` INT NOT NULL,
  `idComponenteMenu` INT NOT NULL,
  PRIMARY KEY (`idMenu`, `idComponenteMenu`),
  INDEX `fk_menu_has_componenteMenu_componenteMenu1_idx` (`idComponenteMenu` ASC),
  INDEX `fk_menu_has_componenteMenu_menu1_idx` (`idMenu` ASC),
  CONSTRAINT `fk_menu_has_componenteMenu_menu1`
    FOREIGN KEY (`idMenu`)
    REFERENCES `bd-restaurant`.`menu` (`idMenu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_menu_has_componenteMenu_componenteMenu1`
    FOREIGN KEY (`idComponenteMenu`)
    REFERENCES `bd-restaurant`.`componenteMenu` (`idComponenteMenu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-restaurant`.`itemListaPrecio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-restaurant`.`itemListaPrecio` (
  `idItemListaPrecio` INT NOT NULL AUTO_INCREMENT,
  `precio` FLOAT NULL,
  `idComponenteMenu` INT NOT NULL,
  PRIMARY KEY (`idItemListaPrecio`),
  INDEX `fk_itemListaPrecio_componenteMenu1_idx` (`idComponenteMenu` ASC),
  CONSTRAINT `fk_itemListaPrecio_componenteMenu1`
    FOREIGN KEY (`idComponenteMenu`)
    REFERENCES `bd-restaurant`.`componenteMenu` (`idComponenteMenu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-restaurant`.`listaPrecio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-restaurant`.`listaPrecio` (
  `idListaPrecio` INT NOT NULL AUTO_INCREMENT,
  `fechaDesde` DATE NULL,
  `fechaHasta` DATE NULL,
  `idItemListaPrecio` INT NOT NULL,
  PRIMARY KEY (`idListaPrecio`),
  INDEX `fk_listaPrecio_itemListaPrecio1_idx` (`idItemListaPrecio` ASC),
  CONSTRAINT `fk_listaPrecio_itemListaPrecio1`
    FOREIGN KEY (`idItemListaPrecio`)
    REFERENCES `bd-restaurant`.`itemListaPrecio` (`idItemListaPrecio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-restaurant`.`camarero`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-restaurant`.`camarero` (
  `idCamarero` INT NOT NULL AUTO_INCREMENT,
  `dni` INT NULL,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  PRIMARY KEY (`idCamarero`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-restaurant`.`tipoCliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-restaurant`.`tipoCliente` (
  `idTipoCliente` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `idListaPrecio` INT NOT NULL,
  PRIMARY KEY (`idTipoCliente`),
  INDEX `fk_tipoCliente_listaPrecio1_idx` (`idListaPrecio` ASC),
  CONSTRAINT `fk_tipoCliente_listaPrecio1`
    FOREIGN KEY (`idListaPrecio`)
    REFERENCES `bd-restaurant`.`listaPrecio` (`idListaPrecio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-restaurant`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-restaurant`.`cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `dni` INT NULL,
  `importeTotal` FLOAT NULL,
  `idTipoCliente` INT NOT NULL,
  PRIMARY KEY (`idCliente`),
  INDEX `fk_cliente_tipoCliente1_idx` (`idTipoCliente` ASC),
  CONSTRAINT `fk_cliente_tipoCliente1`
    FOREIGN KEY (`idTipoCliente`)
    REFERENCES `bd-restaurant`.`tipoCliente` (`idTipoCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-restaurant`.`salon`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-restaurant`.`salon` (
  `idSalon` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NULL,
  `idRestaurant` INT NOT NULL,
  PRIMARY KEY (`idSalon`),
  INDEX `fk_salon_restaurant1_idx` (`idRestaurant` ASC),
  CONSTRAINT `fk_salon_restaurant1`
    FOREIGN KEY (`idRestaurant`)
    REFERENCES `bd-restaurant`.`restaurant` (`idRestaurant`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-restaurant`.`mesa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-restaurant`.`mesa` (
  `idMesa` INT NOT NULL AUTO_INCREMENT,
  `capacidad` INT NULL,
  `idMesaN` INT NOT NULL,
  `idSalon` INT NOT NULL,
  PRIMARY KEY (`idMesa`),
  INDEX `fk_mesa_mesa1_idx` (`idMesaN` ASC),
  INDEX `fk_mesa_salon1_idx` (`idSalon` ASC),
  CONSTRAINT `fk_mesa_mesa1`
    FOREIGN KEY (`idMesaN`)
    REFERENCES `bd-restaurant`.`mesa` (`idMesa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_mesa_salon1`
    FOREIGN KEY (`idSalon`)
    REFERENCES `bd-restaurant`.`salon` (`idSalon`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-restaurant`.`tipoUsuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-restaurant`.`tipoUsuario` (
  `idTipoUsuario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`idTipoUsuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-restaurant`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-restaurant`.`usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `dni` INT NULL,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `idTipoUsuario` INT NOT NULL,
  PRIMARY KEY (`idUsuario`),
  INDEX `fk_usuario_tipoUsuario1_idx` (`idTipoUsuario` ASC),
  CONSTRAINT `fk_usuario_tipoUsuario1`
    FOREIGN KEY (`idTipoUsuario`)
    REFERENCES `bd-restaurant`.`tipoUsuario` (`idTipoUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-restaurant`.`ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-restaurant`.`ticket` (
  `idTicket` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NULL,
  `pagado` TINYINT NULL,
  `cortesia` TINYINT NULL,
  `total` FLOAT NULL,
  `idRestaurant` INT NOT NULL,
  `idUsuario` INT NOT NULL,
  PRIMARY KEY (`idTicket`),
  INDEX `fk_ticket_restaurant1_idx` (`idRestaurant` ASC),
  INDEX `fk_ticket_usuario1_idx` (`idUsuario` ASC),
  CONSTRAINT `fk_ticket_restaurant1`
    FOREIGN KEY (`idRestaurant`)
    REFERENCES `bd-restaurant`.`restaurant` (`idRestaurant`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_usuario1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `bd-restaurant`.`usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-restaurant`.`comanda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-restaurant`.`comanda` (
  `idComanda` INT NOT NULL AUTO_INCREMENT,
  `fechaHora` DATE NULL,
  `idCamarero` INT NOT NULL,
  `idCliente` INT NOT NULL,
  `idMesa` INT NOT NULL,
  `idTicket` INT NOT NULL,
  PRIMARY KEY (`idComanda`),
  INDEX `fk_comanda_camarero1_idx` (`idCamarero` ASC),
  INDEX `fk_comanda_cliente1_idx` (`idCliente` ASC),
  INDEX `fk_comanda_mesa1_idx` (`idMesa` ASC),
  INDEX `fk_comanda_ticket1_idx` (`idTicket` ASC),
  CONSTRAINT `fk_comanda_camarero1`
    FOREIGN KEY (`idCamarero`)
    REFERENCES `bd-restaurant`.`camarero` (`idCamarero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comanda_cliente1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `bd-restaurant`.`cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comanda_mesa1`
    FOREIGN KEY (`idMesa`)
    REFERENCES `bd-restaurant`.`mesa` (`idMesa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comanda_ticket1`
    FOREIGN KEY (`idTicket`)
    REFERENCES `bd-restaurant`.`ticket` (`idTicket`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-restaurant`.`itemComanda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-restaurant`.`itemComanda` (
  `idItemComanda` INT NOT NULL AUTO_INCREMENT,
  `cantidad` INT NULL,
  `idComponenteMenu` INT NOT NULL,
  `idComanda` INT NOT NULL,
  PRIMARY KEY (`idItemComanda`),
  INDEX `fk_itemComanda_componenteMenu1_idx` (`idComponenteMenu` ASC),
  INDEX `fk_itemComanda_comanda1_idx` (`idComanda` ASC),
  CONSTRAINT `fk_itemComanda_componenteMenu1`
    FOREIGN KEY (`idComponenteMenu`)
    REFERENCES `bd-restaurant`.`componenteMenu` (`idComponenteMenu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_itemComanda_comanda1`
    FOREIGN KEY (`idComanda`)
    REFERENCES `bd-restaurant`.`comanda` (`idComanda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-restaurant`.`itemTicket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-restaurant`.`itemTicket` (
  `idItemTicket` INT NOT NULL AUTO_INCREMENT,
  `cantidad` INT NULL,
  `importe` FLOAT NULL,
  `idComponenteMenu` INT NOT NULL,
  `idTicket` INT NOT NULL,
  PRIMARY KEY (`idItemTicket`),
  INDEX `fk_itemTicket_componenteMenu1_idx` (`idComponenteMenu` ASC),
  INDEX `fk_itemTicket_ticket1_idx` (`idTicket` ASC),
  CONSTRAINT `fk_itemTicket_componenteMenu1`
    FOREIGN KEY (`idComponenteMenu`)
    REFERENCES `bd-restaurant`.`componenteMenu` (`idComponenteMenu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_itemTicket_ticket1`
    FOREIGN KEY (`idTicket`)
    REFERENCES `bd-restaurant`.`ticket` (`idTicket`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd-restaurant`.`login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-restaurant`.`login` (
  `idLogin` INT NOT NULL AUTO_INCREMENT,
  `nick` VARCHAR(45) NULL,
  `clave` VARCHAR(45) NULL,
  `idUsuario` INT NOT NULL,
  PRIMARY KEY (`idLogin`),
  INDEX `fk_login_usuario1_idx` (`idUsuario` ASC),
  CONSTRAINT `fk_login_usuario1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `bd-restaurant`.`usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


INSERT INTO `bd-restaurant`.`tipousuario` (`idTipoUsuario`, `nombre`) VALUES ('1', 'administrador');
INSERT INTO `bd-restaurant`.`tipousuario` (`idTipoUsuario`, `nombre`) VALUES ('2', 'adicionista');
INSERT INTO `bd-restaurant`.`tipousuario` (`idTipoUsuario`, `nombre`) VALUES ('3', 'gerente');

INSERT INTO `bd-restaurant`.`usuario` (`idUsuario`, `dni`, `nombre`, `apellido`, `idTipoUsuario`) VALUES ('1', '35229055', 'joan manuel', 'defelippe', '1');
INSERT INTO `bd-restaurant`.`usuario` (`idUsuario`, `dni`, `nombre`, `apellido`, `idTipoUsuario`) VALUES ('2', '36958478', 'gino', 'nazzi', '2');
INSERT INTO `bd-restaurant`.`usuario` (`idUsuario`, `dni`, `nombre`, `apellido`, `idTipoUsuario`) VALUES ('3', '30265948', 'leandro', 'rios', '3');

INSERT INTO `bd-restaurant`.`login` (`idLogin`, `nick`, `clave`, `idUsuario`) VALUES ('1', 'administrador', '1234', '1');
INSERT INTO `bd-restaurant`.`login` (`idLogin`, `nick`, `clave`, `idUsuario`) VALUES ('2', 'adicionista', '1234', '2');
INSERT INTO `bd-restaurant`.`login` (`idLogin`, `nick`, `clave`, `idUsuario`) VALUES ('3', 'gerente', '1234', '3');

INSERT INTO `bd-restaurant`.`rubro` (`idRubro`, `nombre`) VALUES ('1', 'entrada');
INSERT INTO `bd-restaurant`.`rubro` (`idRubro`, `nombre`) VALUES ('2', 'principal');
INSERT INTO `bd-restaurant`.`rubro` (`idRubro`, `nombre`) VALUES ('3', 'postre');
INSERT INTO `bd-restaurant`.`rubro` (`idRubro`, `nombre`) VALUES ('4', 'minuta');
INSERT INTO `bd-restaurant`.`rubro` (`idRubro`, `nombre`) VALUES ('5', 'bebida');

INSERT INTO `bd-restaurant`.`subrubro` (`idSubrubro`, `nombre`, `idRubro`) VALUES ('1', 'pasta', '2');
INSERT INTO `bd-restaurant`.`subrubro` (`idSubrubro`, `nombre`, `idRubro`) VALUES ('2', 'carne', '2');
INSERT INTO `bd-restaurant`.`subrubro` (`idSubrubro`, `nombre`, `idRubro`) VALUES ('3', 'pescado', '2');
INSERT INTO `bd-restaurant`.`subrubro` (`idSubrubro`, `nombre`, `idRubro`) VALUES ('4', 'sandwich', '2');
INSERT INTO `bd-restaurant`.`subrubro` (`idSubrubro`, `nombre`, `idRubro`) VALUES ('5', 'gaseosa', '5');
INSERT INTO `bd-restaurant`.`subrubro` (`idSubrubro`, `nombre`, `idRubro`) VALUES ('6', 'jugo', '5');
INSERT INTO `bd-restaurant`.`subrubro` (`idSubrubro`, `nombre`, `idRubro`) VALUES ('7', 'agua', '5');
INSERT INTO `bd-restaurant`.`subrubro` (`idSubrubro`, `nombre`, `idRubro`) VALUES ('8', 'cerveza', '5');

INSERT INTO `bd-restaurant`.`camarero` (`idCamarero`, `dni`, `nombre`, `apellido`) VALUES ('1', '32568956', 'pedro', 'lopez');
INSERT INTO `bd-restaurant`.`camarero` (`idCamarero`, `dni`, `nombre`, `apellido`) VALUES ('2', '30548789', 'sergio', 'gonzalez');
INSERT INTO `bd-restaurant`.`camarero` (`idCamarero`, `dni`, `nombre`, `apellido`) VALUES ('3', '31564859', 'carlos', 'perez');















