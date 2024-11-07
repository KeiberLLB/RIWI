-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: veterinaria
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.28-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `citas`
--

DROP TABLE IF EXISTS `citas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `citas` (
  `cit_id` int(11) NOT NULL,
  `cit_fecha` date NOT NULL,
  `cit_estado` int(11) DEFAULT NULL,
  `medico_med_id` int(11) NOT NULL,
  `servicio_ser_id` int(11) NOT NULL,
  `mascotas_mas_id` int(11) NOT NULL,
  `sede_sed_id` int(11) NOT NULL,
  PRIMARY KEY (`cit_id`),
  KEY `fk_citas_medico1_idx` (`medico_med_id`),
  KEY `fk_citas_servicio1_idx` (`servicio_ser_id`),
  KEY `fk_citas_mascotas1_idx` (`mascotas_mas_id`),
  KEY `fk_citas_sede1_idx` (`sede_sed_id`),
  CONSTRAINT `fk_citas_mascotas1` FOREIGN KEY (`mascotas_mas_id`) REFERENCES `mascotas` (`mas_id`),
  CONSTRAINT `fk_citas_medico1` FOREIGN KEY (`medico_med_id`) REFERENCES `medico` (`med_id`),
  CONSTRAINT `fk_citas_sede1` FOREIGN KEY (`sede_sed_id`) REFERENCES `sede` (`sed_id`),
  CONSTRAINT `fk_citas_servicio1` FOREIGN KEY (`servicio_ser_id`) REFERENCES `servicio` (`ser_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `citas`
--

LOCK TABLES `citas` WRITE;
/*!40000 ALTER TABLE `citas` DISABLE KEYS */;
INSERT INTO `citas` VALUES (1,'2024-04-01',1,11,1,4,1),(2,'2024-04-02',1,12,2,3,2),(3,'2024-04-03',0,13,3,4,3),(4,'2024-04-04',1,14,4,3,4),(5,'2024-04-05',1,15,5,4,1),(6,'2024-04-06',0,16,6,3,2),(7,'2024-04-07',1,17,7,4,3),(8,'2024-04-08',1,18,8,3,4);
/*!40000 ALTER TABLE `citas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `cli_id` int(11) NOT NULL AUTO_INCREMENT,
  `cli_nombre` varchar(45) DEFAULT NULL,
  `cli_nit` varchar(45) NOT NULL,
  `cli_direccion` varchar(100) DEFAULT NULL,
  `cli_correo` varchar(100) NOT NULL,
  `cli_telefono` varchar(13) DEFAULT NULL,
  PRIMARY KEY (`cli_id`),
  UNIQUE KEY `cli_nit_UNIQUE` (`cli_nit`),
  UNIQUE KEY `cli_correo_UNIQUE` (`cli_correo`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Juan Perez','1234567-8','123 Calle Principal','juan.perez@example.com','12345678'),(2,'Ana Gomez','2345678-9','456 Calle Secundaria','ana.gomez@example.com','87654321'),(13,'Carlos Rivera','345678-9','789 Calle Tercera, Valle Grande','carlos.rivera@example.com','3003456789'),(14,'Lucia Morales','456789-0','101 Calle Cuarta, Montañas Verdes','lucia.morales@example.com','3004567890'),(15,'Fernando Castillo','567890-1','202 Calle Quinta, Ciudad Histórica','fernando.castillo@example.com','3005678901'),(16,'Sofia Cruz','678901-2','303 Calle Sexta, Puerto Azul','sofia.cruz@example.com','3006789012'),(17,'Roberto Díaz','789012-3','404 Calle Séptima, Ciudad Moderna','roberto.diaz@example.com','3007890123'),(18,'María Jiménez','890123-4','505 Calle Octava, Campo Verde','maria.jimenez@example.com','3008901234'),(19,'Eduardo López','901234-5','606 Calle Novena, Ciudad Capital','eduardo.lopez@example.com','3009012345'),(20,'Daniela Martínez','012345-6','707 Calle Décima, Ciudad Lago','daniela.martinez@example.com','3000123456');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especializacion`
--

DROP TABLE IF EXISTS `especializacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `especializacion` (
  `esp_id` int(11) NOT NULL,
  `esp_nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`esp_id`),
  UNIQUE KEY `esp_nombre_UNIQUE` (`esp_nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especializacion`
--

LOCK TABLES `especializacion` WRITE;
/*!40000 ALTER TABLE `especializacion` DISABLE KEYS */;
INSERT INTO `especializacion` VALUES (12,'Anestesiología Veterinaria'),(5,'Cardiología Veterinaria'),(2,'Cirugía Veterinaria'),(3,'Dermatología Veterinaria'),(15,'Etología Veterinaria'),(11,'Medicina Canina'),(10,'Medicina Felina'),(6,'Neurología Veterinaria'),(9,'Nutrición Veterinaria'),(4,'Odontología Veterinaria'),(7,'Oftalmología Veterinaria'),(14,'Oncología Veterinaria'),(8,'Ortopedia Veterinaria'),(13,'Rehabilitación Veterinaria'),(1,'Veterinaria General');
/*!40000 ALTER TABLE `especializacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especializacion_has_medico`
--

DROP TABLE IF EXISTS `especializacion_has_medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `especializacion_has_medico` (
  `especializacion_esp_id` int(11) NOT NULL,
  `medico_med_id` int(11) NOT NULL,
  PRIMARY KEY (`especializacion_esp_id`,`medico_med_id`),
  KEY `fk_especializacion_has_medico_medico1_idx` (`medico_med_id`),
  KEY `fk_especializacion_has_medico_especializacion1_idx` (`especializacion_esp_id`),
  CONSTRAINT `fk_especializacion_has_medico_especializacion1` FOREIGN KEY (`especializacion_esp_id`) REFERENCES `especializacion` (`esp_id`),
  CONSTRAINT `fk_especializacion_has_medico_medico1` FOREIGN KEY (`medico_med_id`) REFERENCES `medico` (`med_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especializacion_has_medico`
--

LOCK TABLES `especializacion_has_medico` WRITE;
/*!40000 ALTER TABLE `especializacion_has_medico` DISABLE KEYS */;
INSERT INTO `especializacion_has_medico` VALUES (1,11),(1,15),(1,19),(2,12),(2,16),(2,20),(3,13),(3,17),(4,14),(4,18);
/*!40000 ALTER TABLE `especializacion_has_medico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especie`
--

DROP TABLE IF EXISTS `especie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `especie` (
  `esp_id` int(11) NOT NULL,
  `esp_nombre` varchar(200) DEFAULT NULL,
  `esp_nombre_cientifico` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`esp_id`),
  UNIQUE KEY `esp_nombre_UNIQUE` (`esp_nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especie`
--

LOCK TABLES `especie` WRITE;
/*!40000 ALTER TABLE `especie` DISABLE KEYS */;
INSERT INTO `especie` VALUES (1,'Perro','Canis lupus familiaris'),(2,'Gato','Felis catus');
/*!40000 ALTER TABLE `especie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historias_clinicas`
--

DROP TABLE IF EXISTS `historias_clinicas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historias_clinicas` (
  `his_id` int(11) NOT NULL,
  `his_fecha` date DEFAULT NULL,
  `his_descripcion` varchar(45) DEFAULT NULL,
  `citas_cit_id` int(11) NOT NULL,
  `his_costo_total` double DEFAULT NULL,
  PRIMARY KEY (`his_id`),
  KEY `fk_historias_clinicas_citas1_idx` (`citas_cit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historias_clinicas`
--

LOCK TABLES `historias_clinicas` WRITE;
/*!40000 ALTER TABLE `historias_clinicas` DISABLE KEYS */;
INSERT INTO `historias_clinicas` VALUES (1,'2024-01-01','Revisión general y vacunación',0,100),(2,'2024-01-15','Tratamiento para otitis',0,80),(3,'2024-02-01','Cirugía menor - extracción de cuerpo extraño',0,200),(4,'2024-02-15','Consulta dermatológica',0,90),(5,'2024-03-01','Limpieza dental',0,75),(6,'2024-03-15','Vacunación antirrábica',0,50),(7,'2024-04-01','Control de parásitos internos y externos',0,60),(8,'2024-04-15','Revisión ortopédica',0,110),(9,'2024-05-01','Evaluación cardiológica',0,150),(10,'2024-05-15','Tratamiento de enfermedades crónicas',0,130);
/*!40000 ALTER TABLE `historias_clinicas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historias_clinicas_has_medicamentos`
--

DROP TABLE IF EXISTS `historias_clinicas_has_medicamentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historias_clinicas_has_medicamentos` (
  `historias_clinicas_his_id` int(11) NOT NULL,
  `medicamentos_med_id` int(11) NOT NULL,
  PRIMARY KEY (`historias_clinicas_his_id`,`medicamentos_med_id`),
  KEY `fk_historias_clinicas_has_medicamentos_medicamentos1_idx` (`medicamentos_med_id`),
  KEY `fk_historias_clinicas_has_medicamentos_historias_clinicas1_idx` (`historias_clinicas_his_id`),
  CONSTRAINT `fk_historias_clinicas_has_medicamentos_historias_clinicas1` FOREIGN KEY (`historias_clinicas_his_id`) REFERENCES `historias_clinicas` (`his_id`),
  CONSTRAINT `fk_historias_clinicas_has_medicamentos_medicamentos1` FOREIGN KEY (`medicamentos_med_id`) REFERENCES `medicamentos` (`med_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historias_clinicas_has_medicamentos`
--

LOCK TABLES `historias_clinicas_has_medicamentos` WRITE;
/*!40000 ALTER TABLE `historias_clinicas_has_medicamentos` DISABLE KEYS */;
INSERT INTO `historias_clinicas_has_medicamentos` VALUES (1,1),(1,5),(2,2),(2,3),(3,4),(3,6),(4,7),(4,8),(5,9),(5,10),(6,11),(6,12),(7,13),(7,14),(8,15),(8,16),(9,17),(9,18),(10,19),(10,20);
/*!40000 ALTER TABLE `historias_clinicas_has_medicamentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mascotas`
--

DROP TABLE IF EXISTS `mascotas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mascotas` (
  `mas_id` int(11) NOT NULL AUTO_INCREMENT,
  `mas_nombre` varchar(120) NOT NULL,
  `mas_edad` int(11) NOT NULL,
  `mas_sexo` tinyint(4) NOT NULL,
  `cliente_cli_id` int(11) NOT NULL,
  `razas_raz_id` int(11) NOT NULL,
  `mas_foto` varchar(65) DEFAULT NULL,
  `historias_clinicas_his_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`mas_id`),
  UNIQUE KEY `mas_foto_UNIQUE` (`mas_foto`),
  UNIQUE KEY `historias_clinicas_his_id` (`historias_clinicas_his_id`),
  KEY `fk_mascotas_copy1_cliente1_idx` (`cliente_cli_id`),
  KEY `fk_mascotas_razas1_idx` (`razas_raz_id`),
  CONSTRAINT `fk_mascotas_copy1_cliente1` FOREIGN KEY (`cliente_cli_id`) REFERENCES `cliente` (`cli_id`),
  CONSTRAINT `fk_mascotas_historias_clinicas` FOREIGN KEY (`historias_clinicas_his_id`) REFERENCES `historias_clinicas` (`his_id`),
  CONSTRAINT `fk_mascotas_razas1` FOREIGN KEY (`razas_raz_id`) REFERENCES `razas` (`raz_id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mascotas`
--

LOCK TABLES `mascotas` WRITE;
/*!40000 ALTER TABLE `mascotas` DISABLE KEYS */;
INSERT INTO `mascotas` VALUES (3,'Firulais',3,1,1,1,'firulais.jpg',1),(4,'Michi',2,0,2,2,'michi.jpg',2);
/*!40000 ALTER TABLE `mascotas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicamentos`
--

DROP TABLE IF EXISTS `medicamentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicamentos` (
  `med_id` int(11) NOT NULL,
  `med_nombre` varchar(100) DEFAULT NULL,
  `med_tipo_consumo` varchar(45) DEFAULT NULL,
  `med_valor` double DEFAULT NULL,
  PRIMARY KEY (`med_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicamentos`
--

LOCK TABLES `medicamentos` WRITE;
/*!40000 ALTER TABLE `medicamentos` DISABLE KEYS */;
INSERT INTO `medicamentos` VALUES (1,'Amoxicilina','Oral',20),(2,'Ibuprofeno','Oral',5),(3,'Prednisolona','Oral',15.5),(4,'Furosemida','Oral',10),(5,'Tramadol','Oral',8.75),(6,'Doxiciclina','Oral',12),(7,'Metronidazol','Oral',7.5),(8,'Carprofeno','Oral',9.25),(9,'Cefalexina','Oral',11),(10,'Enrofloxacina','Inyectable',17),(11,'Ketamina','Inyectable',25),(12,'Insulina','Inyectable',30),(13,'Meloxicam','Oral',6.5),(14,'Piroxicam','Oral',22),(15,'Fluconazol','Oral',18),(16,'Ivermectina','Inyectable',20),(17,'Tetraciclina','Oral',14),(18,'Clindamicina','Oral',16.5),(19,'Levotiroxina','Oral',23),(20,'Atropina','Inyectable',19.5);
/*!40000 ALTER TABLE `medicamentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medico`
--

DROP TABLE IF EXISTS `medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medico` (
  `med_id` int(11) NOT NULL AUTO_INCREMENT,
  `med_nombre` varchar(45) DEFAULT NULL,
  `med_apellido` varchar(45) DEFAULT NULL,
  `med_profesion` varchar(45) DEFAULT NULL,
  `med_nit` varchar(45) NOT NULL,
  PRIMARY KEY (`med_id`),
  UNIQUE KEY `med_nit_UNIQUE` (`med_nit`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medico`
--

LOCK TABLES `medico` WRITE;
/*!40000 ALTER TABLE `medico` DISABLE KEYS */;
INSERT INTO `medico` VALUES (11,'Carlos','Gonzalez','Veterinario','123456789'),(12,'María','Perez','Veterinario','987654321'),(13,'Juan','Martinez','Cirujano','234567891'),(14,'Luisa','Jimenez','Dermatólogo','345678912'),(15,'Fernando','Vega','Veterinario','456789123'),(16,'Sofia','Lopez','Odontólogo','567891234'),(17,'Roberto','Diaz','Cirujano','678912345'),(18,'Ana','Morales','Dermatólogo','789123456'),(19,'Pedro','Alvarez','Veterinario','891234567'),(20,'Lucia','Ruiz','Odontólogo','912345678');
/*!40000 ALTER TABLE `medico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `razas`
--

DROP TABLE IF EXISTS `razas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `razas` (
  `raz_id` int(11) NOT NULL,
  `raz_nombre` varchar(45) NOT NULL,
  `especie_esp_id` int(11) NOT NULL,
  PRIMARY KEY (`raz_id`),
  UNIQUE KEY `raz_nombre_UNIQUE` (`raz_nombre`),
  KEY `fk_razas_especie1_idx` (`especie_esp_id`),
  CONSTRAINT `fk_razas_especie1` FOREIGN KEY (`especie_esp_id`) REFERENCES `especie` (`esp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `razas`
--

LOCK TABLES `razas` WRITE;
/*!40000 ALTER TABLE `razas` DISABLE KEYS */;
INSERT INTO `razas` VALUES (1,'Labrador Retriever',1),(2,'Pastor Alemán',1),(3,'Golden Retriever',1),(4,'Bulldog',1),(5,'Beagle',1),(6,'Poodle',1),(7,'Siberian Husky',1),(8,'Persa',2),(9,'Siamés',2),(10,'Maine Coon',2),(11,'Ragdoll',2),(12,'Bengalí',2),(13,'Sphynx',2),(14,'British Shorthair',2),(15,'Abyssinian',2);
/*!40000 ALTER TABLE `razas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sede`
--

DROP TABLE IF EXISTS `sede`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sede` (
  `sed_id` int(11) NOT NULL,
  `sed_nombre` varchar(45) DEFAULT NULL,
  `sed_ciudad` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`sed_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sede`
--

LOCK TABLES `sede` WRITE;
/*!40000 ALTER TABLE `sede` DISABLE KEYS */;
INSERT INTO `sede` VALUES (1,'Sede Central','Ciudad Capital'),(2,'Sede Norte','Ciudad Capital'),(3,'Sede Sur','Ciudad Costera'),(4,'Sede Este','Ciudad Histórica'),(5,'Sede Oeste','Ciudad Moderna'),(6,'Clínica Veterinaria del Valle','Valle Grande'),(7,'Hospital Veterinario Montañas','Montañas Verdes'),(8,'Centro Veterinario Lago','Ciudad Lago'),(9,'Sede Veterinaria Puerto','Puerto Azul'),(10,'Sede Campo Verde','Campo Verde');
/*!40000 ALTER TABLE `sede` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicio`
--

DROP TABLE IF EXISTS `servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servicio` (
  `ser_id` int(11) NOT NULL,
  `ser_procedimiento` varchar(45) DEFAULT NULL,
  `ser_costo` double DEFAULT NULL,
  `especializacion_esp_id` int(11) NOT NULL,
  PRIMARY KEY (`ser_id`),
  KEY `fk_servicio_especializacion1_idx` (`especializacion_esp_id`),
  CONSTRAINT `fk_servicio_especializacion1` FOREIGN KEY (`especializacion_esp_id`) REFERENCES `especializacion` (`esp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicio`
--

LOCK TABLES `servicio` WRITE;
/*!40000 ALTER TABLE `servicio` DISABLE KEYS */;
INSERT INTO `servicio` VALUES (1,'Consulta general',50,1),(2,'Vacunación',30,1),(3,'Cirugía menor',200,2),(4,'Dermatología avanzada',100,3),(5,'Limpieza dental',80,4),(6,'Cardiología consulta',120,5),(7,'Neurología consulta',150,6),(8,'Oftalmología revisión',90,7),(9,'Ortopedia consulta',110,8),(10,'Nutrición y dieta',60,9),(11,'Medicina felina específica',70,10),(12,'Control de ansiedad y estrés',85,11),(13,'Rehabilitación física',95,12),(14,'Oncología consulta',130,13),(15,'Comportamiento animal',75,14);
/*!40000 ALTER TABLE `servicio` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-29 21:22:32


#seleccionar todos los medicos con la profesion 'Veterinario'
SELECT *
FROM medico
WHERE medico.med_profesion = "Veterinario";

#obtener los medicamentos que tienen una m en su nombre
SELECT *
FROM medicamentos
# %m al principio que busque las que tengan al final
# m% al final que busque las que tengan al principio
# %m% al principio y al final que busque las que tengan
WHERE medicamentos.med_nombre LIKE '%m%';

#Obtener los medicamentos que tienen su valor entre 10 y 15
SELECT *
FROM medicamentos
WHERE medicamentos.med_valor BETWEEN 10 AND 15;

#Obtener solamente el nombre de los medicamentos cuya longitud este entre 1 y 10
#as es alias para el encabezado de la columna (es temporal)
SELECT medicamentos.med_nombre as nombre_medicamento
FROM medicamentos
WHERE CHAR_LENGTH(medicamentos.med_nombre) BETWEEN 1 AND 10;

#Contar el número total de mascotas registradas
# funcion count() cuanta los valores dentro de la tabla que deseamos
SELECT COUNT(*) AS CANTIDAD_MASCOTAS
FROM mascotas;

#Seleccionar los nombres únicos de las especializaciones
#DISTINCT trae un solo valor aunque se repita varias veces
SELECT DISTINCT especializacion.esp_nombre
FROM especializacion;

#Listar los medicamentos ordenados por valor de forma descendente
SELECT *
FROM medicamentos
#DESC ordena de mayor a menor
#ASC ordena de menor a mayor
ORDER BY medicamentos.med_valor DESC;

#Seleccionar las citas programadas entre dos fechas
SELECT *
FROM citas
WHERE citas.cit_fecha BETWEEN '2024-04-01' AND '2024-04-30';

#Obtener el nombre de la mascota y el nombre del cliente
SELECT mascotas.mas_nombre, cliente.cli_nombre
FROM mascotas
INNER JOIN cliente ON mascotas.cliente_cli_id = cliente.cli_id;
#Segunda forma
SELECT mascotas.mas_nombre, cliente.cli_nombre
FROM mascotas,cliente
WHERE mascotas.cliente_cli_id = cliente.cli_id;

#Listar todas las mascotas y sus historias clínicas, incluyendo las mascotas sin historias clínicas
SELECT mascotas.mas_nombre, historias_clinicas.his_descripcion
FROM mascotas
LEFT JOIN historias_clinicas 
ON mascotas.historias_clinicas_his_id = historias_clinicas.his_id;

#Calcular el costo total por cada tipo de servicio
SELECT especializacion.esp_nombre AS especializacion, SUM(servicio.ser_costo) AS precio_total
FROM servicio
INNER JOIN especializacion 
ON especializacion.esp_id = servicio.especializacion_esp_id
GROUP BY servicio.especializacion_esp_id;

#Obtener una lista de citas con un estado 'Pendiente' o 'Realizado' basado en el valor de cit_estado
SELECT mascotas.mas_nombre, citas.cit_estado
FROM citas
INNER JOIN mascotas
ON citas.mascotas_mas_id = mascotas.mas_id;

SELECT citas.cit_fecha, mascotas.mas_nombre,
CASE 
	WHEN citas.cit_estado = 0 THEN 'Pendiente'
    WHEN citas.cit_estado = 1 THEN 'Realizado'
END AS Estado_Cita
FROM citas
INNER JOIN mascotas
ON citas.mascotas_mas_id = mascotas.mas_id;

# 14 Obtener los nombres de las mascotas, el procedimiento del servicio que recibieron, y el nombre de su médico:
SELECT citas.cit_fecha, mascotas.mas_nombre, servicio.ser_procedimiento, medico.med_nombre
from citas
INNER JOIN mascotas
ON citas.mascotas_mas_id = mascotas.mas_id
INNER JOIN servicio
ON citas.servicio_ser_id = servicio.ser_id
INNER JOIN medico
ON citas.medico_med_id = medico.med_id;

#Obtener el promedio del costo de servicios por especialización que superen un costo promedio de 100
SELECT AVG(ser_costo)
FROM servicio
WHERE ser_costo >100;

#Listar información de contacto de clientes, combinando nombre, correo, y teléfono en un solo campo
SELECT CONCAT(cli_nombre, ' ', cli_correo , ' ' , cli_telefono) AS Info_clientes
FROM cliente;

#Obtener la última visita (fecha más reciente de cita) para cada mascota
SELECT mas_nombre, max(cit_fecha) as cita_mas_reciente
FROM citas
INNER JOIN mascotas
ON mascotas_mas_id=mas_id
group by mas_nombre;

#Seleccionar los medicamentos que han sido prescritos en alguna historia clínica
select *
from historias_clinicas_has_medicamentos;

select med_nombre
from historias_clinicas_has_medicamentos
inner join medicamentos
on medicamentos_med_id=med_id
inner join historias_clinicas
on historias_clinicas_his_id=his_id
group by med_nombre;

#Listar todas las citas, incluyendo información de la mascota, el servicio, y la sede, ordenadas por fecha
select cit_fecha, mas_nombre, ser_procedimiento, sed_nombre
from citas
inner join mascotas
on mas_id=mascotas_mas_id
inner join servicio
on ser_id= servicio_ser_id
inner join sede
on sed_id=sede_sed_id
order by cit_fecha desc;