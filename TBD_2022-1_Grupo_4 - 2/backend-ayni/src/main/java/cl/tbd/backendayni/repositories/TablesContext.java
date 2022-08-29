package cl.tbd.backendayni.repositories;

import org.sql2o.Connection;

public class TablesContext {
        public Connection con;

        public TablesContext(Connection con) {
                this.con = con;

        }

        public void crearTablas() {

                // CREACION DE TABLAS
                System.out.println("| Creando las tablas de la Base de datos ayni|");

                // Extension postgis en la base de datos
                con.createQuery("CREATE EXTENSION IF NOT EXISTS postgis").executeUpdate();

                // Tabla de Regiones

                con.createQuery("CREATE TABLE IF NOT EXISTS regiones"
                                +"(id serial primary key, id_region serial, nom_reg text, geom geometry(MultiPolygon, 4326))").executeUpdate();

                // Tabla de los modelos

                con.createQuery("create table IF NOT EXISTS emergencia"
                                + "(id serial primary key, nombre text, descripcion text unique, fecha date, reqs_grupales text, reqs_individuales text,longitude NUMERIC(5,3), latitude NUMERIC(5,3)) ")
                                .executeUpdate();
                con.createQuery("create table IF NOT EXISTS voluntario"
                                + "(id serial primary key, correo text unique, usuario text, nombre text, password text, atributos text) ")
                                .executeUpdate();
                con.createQuery("create table IF NOT EXISTS tarea"
                                + "(id serial primary key, id_emergencia serial, nombre text, descripcion text, fecha date, requerimientos text, longitude NUMERIC(5,3), latitude numeric(5,3)) ")
                                .executeUpdate();
                con.createQuery("create table IF NOT EXISTS estado" + "(id serial primary key, nombre text) ")
                                .executeUpdate();
                con.createQuery("create table IF NOT EXISTS habilidad" + "(id serial primary key, nombre text) ")
                                .executeUpdate();
                con.createQuery("create table IF NOT EXISTS institucion"
                                + "(id serial primary key, nombre text unique, usuario text, password text, correo text unique, numero text) ")
                                .executeUpdate();
                con.createQuery("create table IF NOT EXISTS ranking"
                                + "(id serial primary key, porcentaje real, id_tarea serial, id_voluntario serial) ")
                                .executeUpdate();

                /*
                 * Tablas intermedias
                 */
                // Tabla de relaciones entre emergencia y habilidad
                con.createQuery("create table IF NOT EXISTS emergencia_habilidad"
                                + "(id serial primary key, id_emergencia serial, id_habilidad serial) ")
                                .executeUpdate();
                // Tabla de relaciones entre estado y tarea
                con.createQuery("create table IF NOT EXISTS estado_tarea"
                                + "(id serial primary key, id_estado serial, id_tarea serial) ")
                                .executeUpdate();
                // Tabla de relaciones entre tarea y habilidad
                con.createQuery("create table IF NOT EXISTS tarea_habilidad"
                                + "(id serial primary key, id_tarea serial, id_habilidad serial) ")
                                .executeUpdate();
                // Tabla de relaciones entre voluntario y habilidad
                con.createQuery("create table IF NOT EXISTS voluntario_habilidad"
                                + "(id serial primary key, id_voluntario serial, id_habilidad serial) ")
                                .executeUpdate();

        }

        public void dump() {
                /* Ahora el dump */
                
                // TABLAS
                // Añadir valores a la tabla emergencia

                con.createQuery(
                                "insert into emergencia (nombre, descripcion, fecha, reqs_grupales, reqs_individuales, longitude, latitude)"
                                                + " values ('Incendio', 'Incendio en Cafetería Baker Cat, Arica', '2022-04-21', 'Especialistas medicos, Material medico', 'No tener problemas respiratorios, Extintor', '-18.474162', '-70.293878')")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia (nombre, descripcion, fecha, reqs_grupales, reqs_individuales, longitude, latitude)"
                                                + " values ('Derrumbe', 'Derrumbe cerca de Centor Médico Arauco, Los Vilos', '2022-04-25', 'Especialistas medicos, Material medico', 'No tener problemas respiratorios, Extintor', '-31.916272', '-71.512124')")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia (nombre, descripcion, fecha, reqs_grupales, reqs_individuales, longitude, latitude)"
                                                + " values ('Inundación', 'Inundación en Av. Juan Larrondo con Luis Infante, Canela Baja', '2022-05-02', 'Especialistas medicos, Material medico', 'No tener problemas respiratorios, Extintor', '-31.397671', '-71.457410')")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia (nombre, descripcion, fecha, reqs_grupales, reqs_individuales, longitude, latitude)"
                                                + " values ('Terremoto', 'Terremoto en Punta Arenas', '2022-05-14', 'Especialistas medicos, Material medico', 'No tener problemas respiratorios, Extintor', '-53.141895', '-70.890551')")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia (nombre, descripcion, fecha, reqs_grupales, reqs_individuales, longitude, latitude)"
                                                + " values ('Accidente', 'Accidente en Av. Los Carrera, Concepción', '2022-05-23', 'Especialistas medicos, Material medico', 'No tener problemas respiratorios, Extintor', '-36.827106', '-73.060376')")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia (nombre, descripcion, fecha, reqs_grupales, reqs_individuales, longitude, latitude)"
                                                +
                                                " values ('Socavon', 'Socavon en Av. Heroes de la Concepción, Iquique', '2022-05-29', 'Especialistas medicos, Material medico', 'No tener problemas respiratorios, Extintor', '-20.235734', '-70.143236')")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia (nombre, descripcion, fecha, reqs_grupales, reqs_individuales, longitude, latitude)"
                                                +
                                                " values ('Incendio', 'Incendio en ELECNET.SPA, Talca', '2022-06-07', 'Especialistas medicos, Material medico', 'No tener problemas respiratorios, Extintor', '-35.431311', '-71.666043')")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia (nombre, descripcion, fecha, reqs_grupales, reqs_individuales, longitude, latitude)"
                                                +
                                                " values ('Accidente', 'Accidente en Av. Crucero con Los Maquis, Puerto Montt', '2022-06-08', 'Especialistas medicos, Material medico', 'No tener problemas respiratorios, Extintor', '-41.473424', '-72.958259')")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia (nombre, descripcion, fecha, reqs_grupales, reqs_individuales, longitude, latitude)"
                                                +
                                                " values ('Persona extraviada', 'Persona extraviada en Villarrica, vista por última vez cerca del Salón de Belleza Estilos y Sonrisas', '2022-06-10', 'Especialistas medicos, Material medico', 'No tener problemas respiratorios, Extintor', '-39.283742', '-72.227936')")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia (nombre, descripcion, fecha, reqs_grupales, reqs_individuales, longitude, latitude)"
                                                +
                                                " values ('Incendio', 'Incendio en Cerro Colorado, Valparaíso', '2022-06-11', 'Especialistas medicos, Material medico', 'No tener problemas respiratorios, Extintor', '-33.073912', '-71.627030')")
                                .executeUpdate();

                // Insertar valores en tabla voluntario
                con.createQuery(
                                "insert into voluntario (correo, usuario, nombre, password, atributos) values ('michaelRThomas@gmail.com', 'Hatter','Michael Thomas', 'baebe2jei1Oh','Responsable, Esforzado')")
                                .executeUpdate();

                con.createQuery(
                                "insert into voluntario (correo, usuario, nombre, password, atributos) values ('kyleFDulac@gmail.com', 'Hinceeng49', 'Kyle Dulac', 'jeeFi7ae','Eficiente, Acertivo')")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario (correo, usuario, nombre, password, atributos) values ('susanBTaylor@gmail.com', 'Beeked', 'Susan Taylor', 'oahee9AeNg5','Flojo, Certero')")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario (correo, usuario, nombre, password, atributos) values ('maryDWisniewski@gmail.com', 'Dialt1937','Mary DWisneiwski','Aeveip5xu2','Honesto, Insoportable')")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario (correo, usuario, nombre, password, atributos) values ('kennethRSegura@gmail.com', 'Prearknot91','Kenneth Segura','aZaeTh9oh','Inquieto, Hiperactivo')")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario (correo, usuario, nombre, password, atributos) values ('Dumbdlore@gmail.com', 'Merlin','Percival Dumbdlore','OoZ4baek2ch','Magia, Dominio de Miradas')")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario (correo, usuario, nombre, password, atributos) values ('leslieSTaylor@gmail.com', 'Sominever', 'Leslie Taylor', 'iS2poqu7zeeN','Proactivo, Elegante')")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario (correo, usuario, nombre, password, atributos) values ('sherryCTomaszewski@gmail.com', 'Dought', 'Sherry Tomaszewski', 'Rooyidei1','Diligente, Pudiente')")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario (correo, usuario, nombre, password, atributos) values ('vetaCGalvin@gmail.com', 'Fory1957','Veta Galvin','aejoofo8Ree','Honesto, Perpicaz')")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario (correo, usuario, nombre, password, atributos) values ('Denji@gmail.com', 'Winiter','Denji','eiVoopi6xie','Simp')")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario (correo, usuario, nombre, password, atributos) values ('DootitleJFreeman@gmail.com', 'Watich94','Dootitle Freeman','aek6gi5Ae','Hablar con animales')")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario (correo, usuario, nombre, password, atributos) values ('JessicaJones@gmail.com', 'Imser1986','Jessica Jones','rai3Aecah','Superfuerza')")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario (correo, usuario, nombre, password, atributos) values ('Kaliuchis@gmail.com', 'Frizost1974','Kailuchis','Am0iechai','Telepatía')")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario (correo, usuario, nombre, password, atributos) values ('PedritoEngel@gmail.com', 'Clumadich','Pedro Engel','phoo8Ohxei6','Leer tarot')")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario (correo, usuario, nombre, password, atributos) values ('patrickCSaylor@gmail.com', 'Andento','Patrick Saylor','fiev3zeiDah','Sacar la carta astral, Leer la mano')")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario (correo, usuario, nombre, password, atributos) values ('gokuReal@gmail.com', 'Kakaroto','Son Goku','Kamehameha1234','Comer, Teletransportacion')")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario (correo, usuario, nombre, password, atributos) values ('KuuJOJOtarou@gmail.com', 'DolphinLover22','Kuu Jotaro','S0n0Ch1N0S4D4M3','Amante de la vida marina')")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario (correo, usuario, nombre, password, atributos) values ('wadewilson@canada.com', 'Piscinadelamuerte','Wade Wilson','D3adp00l','Romper la cuarta pared, Regeneracion')")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario (correo, usuario, nombre, password, atributos) values ('ashketchup@pokemon.com', 'MaestroPokemon','Ash Ketchup','P15a1asd1','Ser el mejor, Mejor que nadie más')")
                                .executeUpdate();

                // Insertar valores en tabla tarea
                con.createQuery(
                                "insert into tarea (id_emergencia, nombre, descripcion, fecha, requerimientos, longitude, latitude) values (1, 'Recoger basura', 'Recoger escombros, botarlos en un sitio seguro', '2022-04-21', 'Pala, Rastrillo', '-33.389804', '-70.655240')")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea (id_emergencia, nombre, descripcion, fecha, requerimientos, longitude, latitude) values (2, 'Recoger Ropa', 'Recoger ropa para los necesitados', '2022-04-25', 'Auto, Bolsas tamaño jumbo', '-33.450758', '-70.679715')")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea (id_emergencia, nombre, descripcion, fecha, requerimientos, longitude, latitude) values (2, 'Limpiar zona', 'Limpiar zona afectada por la emergencia', '2022-05-14', 'Pala, Chuzo', '-32.878800', '-71.455213')")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea (id_emergencia, nombre, descripcion, fecha, requerimientos, longitude, latitude) values (3, 'Alertar a personas', 'Anunciar a las personas sobre la emergencia', '2022-05-14', 'Megafono, Parlante', '-33.444194', '-70.653674')")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea (id_emergencia, nombre, descripcion, fecha, requerimientos, longitude, latitude) values (3, 'Poner centros de acopio', 'Colocar centros de acopio para las personas necesitadas', '2022-05-02', 'Mesas, Toldos', '-33.458078', '-70.640655')")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea (id_emergencia, nombre, descripcion, fecha, requerimientos, longitude, latitude) values (4, 'Recolectar agua', 'Traer agua de las zonas aledañadas a la zona de emergencia', '2022-06-07', 'Auto, Bidones', '-34.985543', '-71.237379')")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea (id_emergencia, nombre, descripcion, fecha, requerimientos, longitude, latitude) values (4, 'Registrar zona', 'Buscar los alrededores por señales de vida', '2022-06-08', 'Binoculares, Walkie Talkies', '-33.404486', '-70.568487')")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea (id_emergencia, nombre, descripcion, fecha, requerimientos, longitude, latitude) values (4, 'Ayudar autoridades', 'Guiar autoridades a zonas más criticas de la emergencia', '2022-07-14', 'Chaqueta reflectante, Auto', '-36.827106', '-73.060376')")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea (id_emergencia, nombre, descripcion, fecha, requerimientos, longitude, latitude) values (5, 'Señalizar emergencia', 'Colocar los señalimientos disponibles para advertir en las carreteras', '2022-06-25', 'Chaqueta reflectante, Linterna', '-32.878800', '-71.455213')")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea (id_emergencia, nombre, descripcion, fecha, requerimientos, longitude, latitude) values (6, 'Limpiar calles', 'Limpiar las calles aleñadas', '2022-06-11', 'Linterna, Pala', '-31.914141', '-71.512250')")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea (id_emergencia, nombre, descripcion, fecha, requerimientos, longitude, latitude) values (7, 'Levantar escombros', 'Realizar la extracción de escombros para restablecer carreteras', '2022-04-15', 'Chuzo, Bolsas', '-32.880890', '-71.454937')")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea (id_emergencia, nombre, descripcion, fecha, requerimientos, longitude, latitude) values (8, 'Buscar perro', 'Se perdio un perro con chip dentro del sector de Estacion Central', '2022-06-11', 'Silbato, Juguetes de perro', '-33.389804', '-70.655240')")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea (id_emergencia, nombre, descripcion, fecha, requerimientos, longitude, latitude) values (9, 'Control de maleza', 'Casas con excesiva maleza presentan un peligro para la vecindad', '2022-06-11', 'Tijeras de Podar, Bolsas', '-33.024652', '-71.548455')")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea (id_emergencia, nombre, descripcion, fecha, requerimientos, longitude, latitude) values (6, 'Busqueda de animales', 'Examinar las areas por especies o animales que requieran atención', '2022-04-26', 'Binoculares, Walkie Talkies', '-40.355142', '-72.483366')")
                                .executeUpdate();

                // Insertar valores en tabla estado
                con.createQuery("insert into estado (nombre) values ('Asignada')")
                                .executeUpdate();
                con.createQuery("insert into estado (nombre) values ('Rechazada')")
                                .executeUpdate();
                con.createQuery("insert into estado (nombre) values ('Aceptada')")
                                .executeUpdate();
                con.createQuery("insert into estado (nombre) values ('Finalizada')")
                                .executeUpdate();

                // Insertar valores en tabla habilidad
                con.createQuery("insert into habilidad (nombre) values ('Correr rapido')")
                                .executeUpdate();

                con.createQuery("insert into habilidad (nombre) values ('Saber primeros auxilios')")
                                .executeUpdate();
                con.createQuery("insert into habilidad (nombre) values ('Liderazgo nato')")
                                .executeUpdate();
                con.createQuery("insert into habilidad (nombre) values ('Nadar excelente')")
                                .executeUpdate();
                con.createQuery("insert into habilidad (nombre) values ('Saber tecnicas de supervivencia')")
                                .executeUpdate();
                con.createQuery("insert into habilidad (nombre) values ('Saber lenguaje de señas')")
                                .executeUpdate();
                con.createQuery("insert into habilidad (nombre) values ('Manejo de varias de varios lenguajes')")
                                .executeUpdate();
                con.createQuery("insert into habilidad (nombre) values ('Muy fuerte')")
                                .executeUpdate();
                con.createQuery("insert into habilidad (nombre) values ('Habilidades inquisitivas')")
                                .executeUpdate();
                con.createQuery("insert into habilidad (nombre) values ('Trato con niños en situaciones de estrés')")
                                .executeUpdate();
                con.createQuery("insert into habilidad (nombre) values ('Hablar con animales')")
                                .executeUpdate();
                con.createQuery("insert into habilidad (nombre) values ('Usuario Stand')")
                                .executeUpdate();
                con.createQuery("insert into habilidad (nombre) values ('Telepatía')")
                                .executeUpdate();
                con.createQuery("insert into habilidad (nombre) values ('Omnipotencia')")
                                .executeUpdate();
                con.createQuery("insert into habilidad (nombre) values ('Agua control')")
                                .executeUpdate();
                con.createQuery("insert into habilidad (nombre) values ('Mira a ambos lados antes de cruzar')")
                                .executeUpdate();

                // Insertar valores en tabla institucion

                con.createQuery(
                                "insert into institucion (nombre, usuario, password, correo, numero) values ('Ayni', 'Ayni', 'pabloelpato', 'correoOficial@ayni.cl','+569968435251')")
                                .executeUpdate();
                con.createQuery(
                                "insert into institucion (nombre, usuario, password, correo, numero) values ('Bomberos', 'Bomberos', '123456', 'soporte@bomberos.cl','132')")
                                .executeUpdate();
                con.createQuery(
                                "insert into institucion (nombre, usuario, password, correo, numero) values ('Carabineros', 'Carabineros', '123456', 'soporte@carabineros.cl','133')")
                                .executeUpdate();
                con.createQuery(
                                "insert into institucion (nombre, usuario, password, correo, numero) values ('VeriSure', 'VeriSure', '654321', 'soporte@verisure.com','6005000111')")
                                .executeUpdate();
                con.createQuery(
                                "insert into institucion (nombre, usuario, password, correo, numero) values ('007', '007', '456123', 'soporte@007.com','007')")
                                .executeUpdate();
                con.createQuery(
                                "insert into institucion (nombre, usuario, password, correo, numero) values ('Admin', 'Admin', 'admin1234', 'Admin@gmail.com','0')")
                                .executeUpdate();

                // Insertar valores en tabla ranking

                // Tarea 1
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '1', '1')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('50', '1', '2')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('50', '1', '3')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('50', '1', '4')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '1', '5')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('50', '1', '6')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('50', '1', '7')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('50', '1', '8')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('50', '1', '9')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('50', '1', '10')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('50', '1', '11')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('50', '1', '12')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('50', '1', '13')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('100', '1', '14')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '1', '15')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('50', '1', '16')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '1', '17')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '1', '18')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '1', '19')")
                                .executeUpdate();

                // Tarea 2
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('25', '2', '1')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '2', '2')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('50', '2', '3')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('75', '2', '4')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('25', '2', '5')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('25', '2', '6')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('25', '2', '7')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '2', '8')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('25', '2', '9')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('50', '2', '10')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('25', '2', '11')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('25', '2', '12')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('25', '2', '13')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('25', '2', '14')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '2', '15')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '2', '16')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '2', '17')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('25', '2', '18')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '2', '19')")
                                .executeUpdate();

                // Tarea 3
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('25', '3', '1')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('25', '3', '2')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '3', '3')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '3', '4')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('25', '3', '5')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '3', '6')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('25', '3', '7')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('25', '3', '8')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '3', '9')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('25', '3', '10')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '3', '11')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '3', '12')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '3', '13')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '3', '14')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('25', '3', '15')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('25', '3', '16')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '3', '17')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '3', '18')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('25', '3', '19')")
                                .executeUpdate();

                // Tarea 4
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '4', '1')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '4', '2')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('66.6', '4', '3')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('66.6', '4', '4')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '4', '5')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '4', '6')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '4', '7')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '4', '8')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('66.6', '4', '9')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '4', '10')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '4', '11')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '4', '12')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('66.6', '4', '13')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '4', '14')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '4', '15')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '4', '16')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '4', '17')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '4', '18')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '4', '19')")
                                .executeUpdate();
                // Tarea 5

                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('50', '5', '1')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '5', '2')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('50', '5', '3')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('100', '5', '4')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('50', '5', '5')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '5', '6')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('50', '5', '7')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '5', '8')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('50', '5', '9')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('50', '5', '10')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '5', '11')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '5', '12')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('50', '5', '13')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('50', '5', '14')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '5', '15')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '5', '16')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '5', '17')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '5', '18')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '5', '19')")
                                .executeUpdate();

                // Tarea 6

                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '6', '1')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '6', '2')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('66.6', '6', '3')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '6', '4')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '6', '5')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '6', '6')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '6', '7')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '6', '8')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '6', '9')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '6', '10')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '6', '11')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '6', '12')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '6', '13')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '6', '14')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '6', '15')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '6', '16')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '6', '17')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '6', '18')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '6', '19')")
                                .executeUpdate();

                // Tarea 7

                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '7', '1')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('50', '7', '2')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('50', '7', '3')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '7', '4')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '7', '5')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '7', '6')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '7', '7')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('50', '7', '8')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('50', '7', '9')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('50', '7', '10')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('50', '7', '11')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '7', '12')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('50', '7', '13')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('50', '7', '14')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '7', '15')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '7', '16')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '7', '17')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '7', '18')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '7', '19')")
                                .executeUpdate();

                // Tarea 8

                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('50', '8', '1')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('50', '8', '2')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '8', '3')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('25', '8', '4')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('50', '8', '5')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '8', '6')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('25', '8', '7')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('50', '8', '8')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '8', '9')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('25', '8', '10')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('25', '8', '11')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '8', '12')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '8', '13')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '8', '14')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('25', '8', '15')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('50', '8', '16')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '8', '17')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '8', '18')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('25', '8', '19')")
                                .executeUpdate();

                // Tarea 9

                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '9', '1')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '9', '2')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '9', '3')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '9', '4')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '9', '5')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '9', '6')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '9', '7')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '9', '8')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '9', '9')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '9', '10')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '9', '11')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '9', '12')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '9', '13')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '9', '14')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '9', '15')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '9', '16')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '9', '17')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '9', '18')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '9', '19')")
                                .executeUpdate();

                // Tarea 10

                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '10', '1')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('66.6', '10', '2')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '10', '3')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('66.6', '10', '4')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '10', '5')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('66.6', '10', '6')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '10', '7')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('100', '10', '8')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '10', '9')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('66.6', '10', '10')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('66.6', '10', '11')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('100', '10', '12')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '10', '13')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '10', '14')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '10', '15')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('66.6', '10', '16')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '10', '17')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '10', '18')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '10', '19')")
                                .executeUpdate();

                // Tarea 11

                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '11', '1')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('66.6', '11', '2')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('66.6', '11', '3')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '11', '4')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '11', '5')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '11', '6')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '11', '7')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '11', '8')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '11', '9')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('66.6', '11', '10')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '11', '11')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '11', '12')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '11', '13')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '11', '14')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '11', '15')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '11', '16')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '11', '17')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '11', '18')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '11', '19')")
                                .executeUpdate();

                // Tarea 12

                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '12', '1')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('66.6', '12', '2')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('66.6', '12', '3')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('66.6', '12', '4')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '12', '5')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('66.6', '12', '6')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '12', '7')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('66.6', '12', '8')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '12', '9')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('66.6', '12', '10')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('66.6', '12', '11')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('66.6', '12', '12')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '12', '13')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '12', '14')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '12', '15')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '12', '16')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('33.3', '12', '17')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('66.6', '12', '18')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '12', '19')")
                                .executeUpdate();

                // Tarea 13

                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '13', '1')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('50', '13', '2')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '13', '3')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('25', '13', '4')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('25', '13', '5')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('25', '13', '6')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('25', '13', '7')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('75', '13', '8')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '13', '9')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('25', '13', '10')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('50', '13', '11')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('25', '13', '12')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '13', '13')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('25', '13', '14')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('25', '13', '15')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('75', '13', '16')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '13', '17')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('0', '13', '18')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('25', '13', '19')")
                                .executeUpdate();

                // Tarea 14

                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('18.75', '14', '1')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('31.25', '14', '2')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('18.75', '14', '3')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('31.25', '14', '4')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('12.5', '14', '5')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('18.75', '14', '6')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('25', '14', '7')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('37.5', '14', '8')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('12.5', '14', '9')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('25', '14', '10')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('18.75', '14', '11')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('12.5', '14', '12')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('18.75', '14', '13')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('12.5', '14', '14')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('12.5', '14', '15')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('25', '14', '16')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('12.5', '14', '17')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('12.5', '14', '18')")
                                .executeUpdate();
                con.createQuery(
                                "insert into ranking (porcentaje, id_tarea, id_voluntario) values ('12.5', '14', '19')")
                                .executeUpdate();

                // Tablas Intermedias

                // Insertar valores en tabla intermedia emergencia_habilidad

                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (1, 2)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (1, 3)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (2, 1)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (2, 2)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (2, 5)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (2, 14)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (2, 11)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (2, 7)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (2, 8)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (2, 13)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (3, 2)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (3, 6)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (3, 8)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (3, 1)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (4, 9)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (4, 6)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (4, 4)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (4, 2)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (4, 1)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (4, 8)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (4, 7)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (5, 12)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (5, 14)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (5, 2)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (6, 3)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (6, 5)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (6, 7)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (7, 4)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (7, 2)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (7, 9)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (8, 4)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (8, 5)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (8, 3)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (9, 12)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (9, 3)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (9, 7)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (9, 9)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (10, 1)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (10, 2)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (10, 3)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (10, 4)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (10, 5)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (10, 6)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (10, 7)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (10, 8)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (10, 9)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (10, 10)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (10, 11)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (10, 12)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (10, 13)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (10, 14)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (10, 15)")
                                .executeUpdate();
                con.createQuery(
                                "insert into emergencia_habilidad (id_emergencia, id_habilidad) values (10, 16)")
                                .executeUpdate();

                // Insertar valores en tabla intermedia estado_tarea

                con.createQuery(
                                "insert into estado_tarea (id_estado, id_tarea) values (2, 1)")
                                .executeUpdate();
                con.createQuery(
                                "insert into estado_tarea (id_estado, id_tarea) values (1, 2)")
                                .executeUpdate();
                con.createQuery(
                                "insert into estado_tarea (id_estado, id_tarea) values (3, 3)")
                                .executeUpdate();
                con.createQuery(
                                "insert into estado_tarea (id_estado, id_tarea) values (4, 4)")
                                .executeUpdate();
                con.createQuery(
                                "insert into estado_tarea (id_estado, id_tarea) values (1, 5)")
                                .executeUpdate();
                con.createQuery(
                                "insert into estado_tarea (id_estado, id_tarea) values (2, 6)")
                                .executeUpdate();
                con.createQuery(
                                "insert into estado_tarea (id_estado, id_tarea) values (4, 7)")
                                .executeUpdate();
                con.createQuery(
                                "insert into estado_tarea (id_estado, id_tarea) values (3, 8)")
                                .executeUpdate();
                con.createQuery(
                                "insert into estado_tarea (id_estado, id_tarea) values (1, 9)")
                                .executeUpdate();
                con.createQuery(
                                "insert into estado_tarea (id_estado, id_tarea) values (4, 10)")
                                .executeUpdate();
                con.createQuery(
                                "insert into estado_tarea (id_estado, id_tarea) values (1, 11)")
                                .executeUpdate();
                con.createQuery(
                                "insert into estado_tarea (id_estado, id_tarea) values (2, 12)")
                                .executeUpdate();
                con.createQuery(
                                "insert into estado_tarea (id_estado, id_tarea) values (3, 13)")
                                .executeUpdate();
                con.createQuery(
                                "insert into estado_tarea (id_estado, id_tarea) values (1, 14)")
                                .executeUpdate();

                // Insertar valores en tabla intermedia tarea_habilidad

                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (1, 2)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (1, 3)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (2, 1)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (2, 2)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (2, 5)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (2, 14)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (3, 11)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (3, 7)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (3, 8)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (3, 13)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (4, 2)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (4, 6)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (4, 8)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (5, 1)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (5, 2)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (6, 9)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (6, 6)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (6, 4)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (7, 2)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (7, 9)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (8, 1)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (8, 8)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (8, 7)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (8, 9)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (9, 12)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (9, 14)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (9, 2)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (10, 3)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (10, 5)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (10, 7)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (11, 4)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (11, 2)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (11, 9)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (12, 4)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (12, 5)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (12, 3)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (13, 12)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (13, 3)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (13, 7)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (13, 9)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (14, 1)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (14, 2)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (14, 3)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (14, 4)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (14, 5)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (14, 6)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (14, 7)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (14, 8)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (14, 9)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (14, 10)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (14, 11)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (14, 12)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (14, 13)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (14, 14)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (14, 15)")
                                .executeUpdate();
                con.createQuery(
                                "insert into tarea_habilidad (id_tarea, id_habilidad) values (14, 16)")
                                .executeUpdate();

                // Insertar valores en tabla intermedia voluntario_habilidad

                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (1, 1)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (1, 4)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (1, 8)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (2, 7)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (2, 3)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (2, 4)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (2, 9)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (2, 10)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (3, 2)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (3, 4)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (3, 5)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (3, 6)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (4, 3)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (4, 1)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (4, 2)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (4, 5)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (4, 6)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (5, 7)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (5, 1)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (6, 3)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (6, 5)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (6, 6)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (7, 1)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (7, 10)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (7, 8)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (7, 3)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (8, 5)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (8, 7)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (8, 6)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (8, 10)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (8, 3)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (8, 9)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (9, 2)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (9, 6)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (10, 4)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (10, 2)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (10, 7)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (10, 5)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (11, 9)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (11, 3)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (11, 5)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (12, 3)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (12, 5)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (13, 2)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (13, 6)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (13, 10)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (14, 2)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (14, 3)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (15, 6)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (15, 7)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (16, 3)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (16, 6)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (16, 7)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (16, 9)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (17, 4)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (17, 10)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (18, 4)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (18, 5)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (19, 7)")
                                .executeUpdate();
                con.createQuery(
                                "insert into voluntario_habilidad (id_voluntario, id_habilidad) values (19, 10)")
                                .executeUpdate();

                con.createQuery("alter table tarea add geom geometry(Point, 4326)").executeUpdate();
                con.createQuery("update tarea set geom = ST_MakePoint(latitude, longitude)").executeUpdate();
                con.createQuery("alter table emergencia add geom geometry(Point, 4326)").executeUpdate();
                con.createQuery("update emergencia set geom = ST_MakePoint(latitude, longitude)").executeUpdate();

        }

}