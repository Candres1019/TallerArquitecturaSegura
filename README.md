# Taller Aplicación Distribuida Segura en todos sus Frentes

Aplicativo Web diseñado en Java haciendo uso del framework Spark con el objetivo de realizar la implementación y uso de
certificados SSL y el uso del protocolo HTTPS, con una arquitectura basada en 2 nodos que se comunicaran entre sí
haciendo uso de estos certificados (SSL), uno de ellos encargado de prestar un servicio el cual en este caso es una
calculadora encargada de retornar la media y la desviación estándar de un conjunto n de datos, y el segundo nodo
encargado de enviar al primero la cadena de datos con la cual este va a trabajar y de brindar adicionalmente un soporte
a usuarios, los cuales serán capaces de hacer login y hacer logout, este nodo además será el encargado de llevar un
control sobre las sesiones de estos usuarios y de encriptar las contraseñas de los mismos.

## Información Del Proyecto

* La documentación del las clases y los metodos del proyecto se encuentran en el directorio adjunto /Javadoc/apidocs.

### Pre-Requisitos

Para correr este proyecto necesita los siguientes programas instalados, se adjuntan los links de como descargarlos:

> * [Como Instalar Java 8](https://www.oracle.com/co/java/technologies/javase/javase-jdk8-downloads.html)
> * [Como Instalar Apache Maven](http://maven.apache.org/download.html#Installation)
> * [Como Instalar Docker](https://docs.docker.com/engine/install/)

Adicionalmente se recomienda tener descargado los siguientes programas:

> * [Como Instalar Git](http://git-scm.com/book/en/v2/Getting-Started-Installing-Git)

### Video del despliegue en AWS

[![Deployed to AWS](./Img/aws.png)](https://www.youtube.com/watch?v=Q9Yq7MxHnko)

### Calidad del código

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/e0c309d228444068b746127db6a10c62)](https://www.codacy.com/gh/Candres1019/TallerClientesServicios/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Candres1019/TallerClientesServicios&amp;utm_campaign=Badge_Grade)

### Integración Continua

[![CircleCI](https://circleci.com/gh/Candres1019/TallerArquitecturas-IOC-Reflexion.svg?style=svg)](https://app.circleci.com/pipelines/github/Candres1019/TallerArquitecturas-IOC-Reflexion)

### Instalación

1. Clonación o Descarga del Proyecto:

    * Para **Clonar** el proyecto utilice el siguiente comando en la ventana de comandos:

   ```
   git clone https://github.com/Candres1019/TallerArquitecturas-IOC-Reflexion.git
   ```

    * Para **Descargar** el proyecto de
      click [aquí](https://github.com/Candres1019/TallerArquitecturas-IOC-Reflexion/archive/master.zip), la descarga
      comenzara de manera automática.

2. En una ventana de comandos ejecute el siguiente comando, dentro de la carpeta principal del proyecto:

   ```
    mvn package
    ```

3. Para ejecutar la aplicación de manera local utilizamos en la ventana de comandos el siguiente comando:

   > ```
    > java -cp "target/classes" co.edu.escuelaing.arep.picospring.PicoSpringBoot co.edu.escuelaing.arep.controllers.SpringAppController
    > ```

4. Para ver el aplicativo web de manera local ingresamos al siguiente enlace, dentro de este enlace encontrará los
   botones para realizar las acciones específicas (ver imagen, ver js, ver css, ver datos, insertar datos):

   > ```
    > http://localhost:8080/
    > ```

5. Por defecto se creó la documentación JavaDoc y fue dejada en el directorio /Javadoc, si desea generar uno nuevo
   utilice el siguiente comando, esta documentación quedará en el directorio /target/site/apidocs :

   > ```
   > mvn javadoc:javadoc
   > ```

## Ejecución de pruebas

En una ventana de comandos, utilice el siguiente comando:

   ```
    mvn test
   ```

## Construido Con

* [Java](https://www.java.com/es/) - Lenguaje de Programación.
* [JUnit](https://junit.org/junit5/) - Pruebas de Unidad.
* [Maven](https://maven.apache.org/) - Manejo de dependecias.
* [IntelliJ IDEA](https://www.jetbrains.com/es-es/idea/) - Entorno de Desarrollo.

## Authors

* **Andres Mateo Calderón Ortega** - [Candres1019](https://github.com/Candres1019)

# Licencia

Este proyecto está licenciado bajo la GNU v3.0 - ver el archivo [LICENSE](./LICENSE) para más detalles