-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-07-2019 a las 17:58:21
-- Versión del servidor: 10.3.16-MariaDB
-- Versión de PHP: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `statx`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizarUsuario` (`UsuCambio` VARCHAR(45), `Nombre1` VARCHAR(45), `Nombre2` VARCHAR(45), `Apellido1` VARCHAR(45), `Apellido2` VARCHAR(45), `NºIdentificación` INT, `Teléfono` VARCHAR(45), `Celular` VARCHAR(45), `Género` VARCHAR(45), `Correo` VARCHAR(45), `Dirección` VARCHAR(45))  BEGIN
UPDATE `statx`.`usuario` SET `primer_nombre` = Nombre1, `segundo_nombre` = Nombre2, `primer_apellido` = Apellido1, `segundo_apellido` = Apellido2, `numero_identificacion` = NºIdentificación, `telefono` = Teléfono, `numero_celular` = Celular, `genero` = Género, `correo` = Correo , `direccion` =  Dirección
WHERE (`id_usuario` = Usuacambio);

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `buscador` (`Conductor` VARCHAR(10))  BEGIN
Select id_usuario as 'N°', concat_ws (' ', primer_nombre, segundo_nombre, primer_apellido, 
segundo_apellido) as 'Nombres y apellidos', numero_identificacion as 'Numero de identificación',
telefono as 'Teléfono', numero_celular as 'Celular', genero as 'Género', correo as 'Correo', 
direccion as 'Dirección', tipoIdentificacion as 'Tipo de documento', nombre_rol as 'Rol'
from usuario
inner join rol
inner join rol_has_usuario 
on rol_has_usuario.usuario_id_usuario = usuario.id_usuario
and rol_has_usuario.rol_idrol = rol.idrol
where primer_nombre = Conductor;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `crearUsuario` (`Nombre1` VARCHAR(45), `Nombre2` VARCHAR(45), `Apellido1` VARCHAR(45), `Apellido2` VARCHAR(45), `NºIdentificación` INT, `Teléfono` VARCHAR(45), `Celular` VARCHAR(45), `Género` VARCHAR(45), `Correo` VARCHAR(45), `Dirección` VARCHAR(45))  BEGIN
insert into usuario (primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, numero_identificacion, telefono, numero_celular, genero, correo, direccion)
values (Nombre1, Nombre2, Apellido1, Apellido2, NºIdentificación, Teléfono, Celular, Género, Correo, Dirección);
update usuario set contraseña=concat_ws(Nombre1, Apellido1, ' ') 
where (Nombre1 = primer_nombre);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `usuActivos` ()  BEGIN
select primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, estado, nombre_rol 
from usuario
inner join rol
inner join rol_has_usuario 
on rol_has_usuario.usuario_id_usuario = usuario.id_usuario
and rol_has_usuario.rol_idrol = rol.idrol
where estado = 'Activo';
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuota`
--

CREATE TABLE `cuota` (
  `id_cuota` int(11) NOT NULL,
  `cantidad` decimal(45,0) DEFAULT NULL,
  `fechaCuota` date DEFAULT NULL,
  `cuotaEntregada` int(11) DEFAULT NULL,
  `usuario_id_usuario` int(11) NOT NULL,
  `usuario_id_tesorero` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cuota`
--

INSERT INTO `cuota` (`id_cuota`, `cantidad`, `fechaCuota`, `cuotaEntregada`, `usuario_id_usuario`, `usuario_id_tesorero`) VALUES
(2, '100', '2019-07-12', 80, 10, 13);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `documento`
--

CREATE TABLE `documento` (
  `id_documento` int(11) NOT NULL,
  `tarjeta_propiedad` longblob DEFAULT NULL,
  `tecnomecanica` varchar(45) DEFAULT NULL,
  `seguro` varchar(45) DEFAULT NULL,
  `soat` varchar(45) DEFAULT NULL,
  `tarjeton` int(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mantenimiento`
--

CREATE TABLE `mantenimiento` (
  `id_mantenimiento` int(11) NOT NULL,
  `fechaMantenimiento` date DEFAULT NULL,
  `precio` decimal(45,0) DEFAULT NULL,
  `tecnomecanica` varchar(45) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `valor` int(11) DEFAULT NULL,
  `vehiculo_placa` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `idrol` int(11) NOT NULL,
  `nombre_rol` varchar(45) NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`idrol`, `nombre_rol`, `descripcion`) VALUES
(1, 'Administrador', NULL),
(2, 'Secretaria', NULL),
(3, 'Tesoreria', NULL),
(4, 'Tele-operador', NULL),
(5, 'Conductor', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol_has_usuario`
--

CREATE TABLE `rol_has_usuario` (
  `rol_idrol` int(11) NOT NULL,
  `usuario_id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `rol_has_usuario`
--

INSERT INTO `rol_has_usuario` (`rol_idrol`, `usuario_id_usuario`) VALUES
(1, 1),
(2, 1),
(2, 14),
(3, 13),
(5, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicio`
--

CREATE TABLE `servicio` (
  `id_servicio` int(11) NOT NULL,
  `destino` varchar(45) DEFAULT NULL,
  `origen` varchar(45) DEFAULT NULL,
  `valor` int(11) DEFAULT NULL,
  `observaciones` varchar(150) DEFAULT NULL,
  `vehiculo_placa` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solicitud_empleo`
--

CREATE TABLE `solicitud_empleo` (
  `idAfiliacion` int(11) NOT NULL,
  `tipo_afiliacion` varchar(45) NOT NULL,
  `estado_solicitud` varchar(45) NOT NULL,
  `fecha_solicitud` date NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `licencia` varchar(45) NOT NULL,
  `usuario_id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `primer_nombre` varchar(20) NOT NULL,
  `segundo_nombre` varchar(20) DEFAULT NULL,
  `primer_apellido` varchar(20) NOT NULL,
  `segundo_apellido` varchar(20) DEFAULT NULL,
  `numero_identificacion` int(11) NOT NULL,
  `telefono` int(11) NOT NULL,
  `numero_celular` char(10) NOT NULL,
  `genero` varchar(45) DEFAULT NULL,
  `correo` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `contraseña` varchar(45) NOT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `tipoIdentificacion` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `primer_nombre`, `segundo_nombre`, `primer_apellido`, `segundo_apellido`, `numero_identificacion`, `telefono`, `numero_celular`, `genero`, `correo`, `direccion`, `contraseña`, `estado`, `tipoIdentificacion`) VALUES
(1, 'andres', 'felipe', 'martinez', 'segundo', 123456789, 2345678, '3214567898', 'masculino', 'Admin@gmail.com', 'tjshjkfhcjhcja434', 'andresmartinez', 'Activo', NULL),
(10, 'Pedro', 'andres', 'gonzales', 'prieto', 2147483647, 975432, '3109874653', 'masculino', 'conductor@outlook.com', 'calle 123#14', 'osmar_gonzales', 'Activo', NULL),
(11, 'carlosr', 'salomon', 'gomezs', 'pilar', 1234568989, 1234567, '309u098981', 'Hombre', 'Hola@outlook.com', 'calle 123', 'osmar_gonzales', 'Inactivo', NULL),
(13, 'mariana', '', 'sandobal', 'perez', 1234567890, 1234567, '1234567891', 'Femenino', 'tesorera@gmail', 'carrera falsa', 'sandobalmariana ', 'inactivo', NULL),
(14, 'Sandra', '', 'Perez', '', 123456890, 1234567, '1234567890', 'Femenino', 'Secretaria@gmail.com', 'calle falsa av nose', 'PerezSandra ', 'inactivo', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculo`
--

CREATE TABLE `vehiculo` (
  `placa` char(6) NOT NULL,
  `modelo` varchar(45) DEFAULT NULL,
  `dueño` varchar(45) DEFAULT NULL,
  `marca` varchar(20) DEFAULT NULL,
  `usuario_id_usuario` int(11) NOT NULL,
  `documento_id_documento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cuota`
--
ALTER TABLE `cuota`
  ADD PRIMARY KEY (`id_cuota`),
  ADD KEY `fk_cuota_usuario1_idx` (`usuario_id_usuario`),
  ADD KEY `usuario_id_tesorero` (`usuario_id_tesorero`);

--
-- Indices de la tabla `documento`
--
ALTER TABLE `documento`
  ADD PRIMARY KEY (`id_documento`);

--
-- Indices de la tabla `mantenimiento`
--
ALTER TABLE `mantenimiento`
  ADD PRIMARY KEY (`id_mantenimiento`),
  ADD KEY `fk_mantenimiento_vehiculo1_idx` (`vehiculo_placa`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`idrol`);

--
-- Indices de la tabla `rol_has_usuario`
--
ALTER TABLE `rol_has_usuario`
  ADD PRIMARY KEY (`rol_idrol`,`usuario_id_usuario`),
  ADD KEY `fk_rol_has_usuario_usuario1_idx` (`usuario_id_usuario`),
  ADD KEY `fk_rol_has_usuario_rol1_idx` (`rol_idrol`);

--
-- Indices de la tabla `servicio`
--
ALTER TABLE `servicio`
  ADD PRIMARY KEY (`id_servicio`),
  ADD KEY `fk_servicio_vehiculo1_idx` (`vehiculo_placa`);

--
-- Indices de la tabla `solicitud_empleo`
--
ALTER TABLE `solicitud_empleo`
  ADD PRIMARY KEY (`idAfiliacion`),
  ADD KEY `fk_solicitud_empleo_usuario1_idx` (`usuario_id_usuario`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`);

--
-- Indices de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD PRIMARY KEY (`placa`),
  ADD KEY `fk_vehiculo_usuario1_idx` (`usuario_id_usuario`),
  ADD KEY `fk_vehiculo_documento1_idx` (`documento_id_documento`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cuota`
--
ALTER TABLE `cuota`
  MODIFY `id_cuota` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `documento`
--
ALTER TABLE `documento`
  MODIFY `id_documento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1010123457;

--
-- AUTO_INCREMENT de la tabla `mantenimiento`
--
ALTER TABLE `mantenimiento`
  MODIFY `id_mantenimiento` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `idrol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `servicio`
--
ALTER TABLE `servicio`
  MODIFY `id_servicio` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `solicitud_empleo`
--
ALTER TABLE `solicitud_empleo`
  MODIFY `idAfiliacion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cuota`
--
ALTER TABLE `cuota`
  ADD CONSTRAINT `fk_cuota_usuario1` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`),
  ADD CONSTRAINT `usuario_id_tesorero` FOREIGN KEY (`usuario_id_tesorero`) REFERENCES `usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `mantenimiento`
--
ALTER TABLE `mantenimiento`
  ADD CONSTRAINT `fk_mantenimiento_vehiculo1` FOREIGN KEY (`vehiculo_placa`) REFERENCES `vehiculo` (`placa`);

--
-- Filtros para la tabla `rol_has_usuario`
--
ALTER TABLE `rol_has_usuario`
  ADD CONSTRAINT `fk_rol_has_usuario_rol1` FOREIGN KEY (`rol_idrol`) REFERENCES `rol` (`idrol`),
  ADD CONSTRAINT `fk_rol_has_usuario_usuario1` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Filtros para la tabla `servicio`
--
ALTER TABLE `servicio`
  ADD CONSTRAINT `fk_servicio_vehiculo1` FOREIGN KEY (`vehiculo_placa`) REFERENCES `vehiculo` (`placa`);

--
-- Filtros para la tabla `solicitud_empleo`
--
ALTER TABLE `solicitud_empleo`
  ADD CONSTRAINT `fk_solicitud_empleo_usuario1` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Filtros para la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD CONSTRAINT `fk_vehiculo_documento1` FOREIGN KEY (`documento_id_documento`) REFERENCES `documento` (`id_documento`),
  ADD CONSTRAINT `fk_vehiculo_usuario1` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
