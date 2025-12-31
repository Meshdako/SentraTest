# SentraTest
Proyecto desarrollado por Martin Sobarzo Huerta

**Evaluación Técnica: QA Junior**

## Desarrollo
El objetivo de este proyecto es validar de manera automatizada los principales flujos funcionales de una aplicación de gestión de tareas, priorizando escenarios críticos como:

* Inicio de sesión
* Creación de usuario
* Creación de tareas
* Ordenamiento de tareas por título, prioridad y fecha de vencimiento.
* Edición del usuario.

El enfoque del proyecto está orientado a demostrar conocimientos en automatización de pruebas, estructuración de proyectos y análisis de resultados.

## Organización

```
src
└── test
    ├── java
    │   ├── pages
    │   │   ├── BasePage.java        → Clase base con métodos comunes
    │   │   └── *.java               → Page Object de las pantallas principales
    │   ├── runner
    │   │   └── TestRunner.java      → Runner de Cucumber
    │   └── steps
    │       └── *.java               → Definición de pasos (Step Definitions) de las pantallas principales
    └── resources
        └── features
            └── *.feature            → Escenarios escritos en Gherkin para todas las pantallas principales
```
### Teconologías Utilizadas
* Java
* Selenium WebDriver
* Cucumber (Gherkin)
* Gradle
* JUnit


## Ejecución
Para la ejecución del proyecto primero debe clonar el mismo.
```
$ git clone git@github.com:Meshdako/SentraTest.git
$ cd SentraTest
$ cd SentraSeleniumTest
```
Una vez clonado el proyecto, se recomienda ingresar a la carpeta /SentraSeleniumTest y escribir el siguiente comando dentro de la terminal.
```
$ gradle clean test
```
En caso de que no funcione, se recomienda ejecutar el siguiente comando
```
$ gradle build
```
Con esto, se permite la compilación en caso de que exista algún error.

## Resultados
Al finalizar la ejecución de las pruebas, se generan reportes automáticos de Gradle en formato HTML, los cuales contienen:

* Escenarios ejecutados
* Estado de cada escenario (Passed / Failed)
* Detalle de los pasos ejecutados
* Tiempos de ejecución

Los reportes se encuentran en el directorio:
```
SentraSeleniumTest\build\reports\tests\test\index.html
```
Existe otro reporte que se genera si se ejecuta el TestRunner.java el cual quedará dentro del siguiente directorio:
```
SentraSeleniumTest\target\cucumber-reports.html
```
Estos reportes constituyen la evidencia técnica de la ejecución de las pruebas automatizadas y se complementan con la matriz de casos de prueba documentada.

### Reportes
Dentro del repositorio hay una carpeta llamada *reportes*, la cual está en la raíz principal del repositorio. Dicha carpeta posee los últimos reportes hechos en mi equipo, mostrando los resultados obtenidos, de esa manera se pueden comparara con los nuevos resultados que se obtendrán al volver a ejecutar el programa.

Es importante destacar que algunos escenearios tienen un resultado **fallido** y es porque es el resultado esperado. Algunos escenarios deben fallar, porque si continuaran sería un peligro de seguridad o integridad de los datos. Sin embargo, hay escenarios exitosos, pero que muestran la falta de validación de información, como la creación del usuario, ya que permite crear un usuario sin validar el formato de su correo, lo cual crea un usuario *fantasma*, por decir de alguna manera.

---
# Muchas gracias
31/12/2025