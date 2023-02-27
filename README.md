# Tiro parabólico: TDD+Java+Maven+JUnit 4
### Ejemplo de TDD para la asignatura Desarrollo Ágil.
Ejemplo que servirá de base para un ejercicio de TDD en el que se use Java, Maven JUNit4 y VS Code.

Este ejemplo muestra cómo podemos calcular las fórmulas involucradas en un tiro parabólico en el que solo afecta la gravedad, dado que no introducimos ni coeficiente de rozamiento ni ninguna otra fuerza que afecte a la trayectoria.

Las fórmulas están calculas siguiendo las indicaciones encontradas en: https://www.areaciencias.com/fisica/tiro-parabolico-formulas/ 

### Creación del proyecto desde el código descargado de GitHub
Para poder usar la plantilla del proyecto y hacer los ejercicios, es impresincidible que tengas instalado algún JDK en tu ordenador. Además, tendrás que instalar en VS Code la extensión denominada: **Extension Pack for Java**, la cual nos instalará las siguientes 6 extensiones:
    * Language Support for Java™ by Red Hat
    * Debugger for Java
    * Test Runner for Java (Run & Debug JUnit/TestNG Test Cases)
    * Maven for Java
    * Project Manager for Java
    * Visual Studio IntelliCode

Una vez instalado todo el software necesario, clona el repositorio donde está la plantilla para los ejercicios y modifica los ficheros: *src/main/java/es/ujaen/dagil/App.java* y *src/test/java/es/ujaen/dagil/AppTest.java* para ir realizando los ejercicios indicados en los comentarios.

### Creación del proyecto desde cero.
Para poder ejecutar este proyecto, es necesario instalar previamente algún JDK en nuestro ordenador, de forma que podamos compilar ficheros en Java.

Una vez disponemos del JDK, los pasos que he seguido para conseguir poner en marcha "desde cero" este proyecto en nuestro VS Code son:

1. Abrir VS Code
2. Seleccionar en el menú superior:  *Archivo* -> *Nueva ventana*
3. Instalar la extensión llamada: **Extension Pack for Java**, la cual nos instalará las siguientes 6 extensiones:
    * Language Support for Java™ by Red Hat
    * Debugger for Java
    * Test Runner for Java (Run & Debug JUnit/TestNG Test Cases)
    * Maven for Java
    * Project Manager for Java
    * Visual Studio IntelliCode
4. En el menú de iconos de la izquierda de VS Code, seleccionamos el icono superior, es decir, *EXPLORER*, y pulsamos el botón *Create Java Project*.
5. De entre todos los proyectos posibles, seleccionamos: *Maven create from archetype*
6. De entre todos los "arquetipos" de Maven, seleccionamos: *maven-archetype-quickstart*
    * Para la pregunta sobre la versión, elegimos la superior, en mi caso: 1.4
    * Para la pregunta sobre *Group id*, he cambiado com.example por *es.ujaen.dagil*
    * Para la pregunta sobre *Artifact*, he cambiado *demo* por *tdd_tiro_parabolico*
7. A continuación, seleccionamos el directorio de destino en el disco duro.
8. Comienza el proceso de creción del proyecto. En la ventana llamada *Terminal* de VS Code nos hará un par de preguntas:
    * A la pregunta sobre la versión, indico: *1.0*
    * A la pregunta Y: , indico *Y*  (o simplemente, pulso *Enter*)
9. Finalmente, en la ventana que aparece abajo a la derecha, le indico que abra el directorio.


###