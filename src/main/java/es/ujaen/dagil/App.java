package es.ujaen.dagil;

import java.util.Scanner;

/**
 * Cálculo de fórmulas para tiro parabólico SIN rozamiento, CON gravedad.
 * Calculadas según:
 * https://www.areaciencias.com/fisica/tiro-parabolico-formulas/
 *
 */
public class App {
    /**
     * Calcula el desplazamiento en el eje X durante un tiempo t.
     * Consideramos el rozamiento nulo.
     * 
     * Esta función se proporciona completa para que sirva de ejemplo para el resto de ejercicios.
     * 
     * @param x_ini  Posición X inicial
     * @param v_ini  Velocidad inicial
     * @param angulo Ángulo (expresado en radianes) con el que se lanza el
     *               proyectil.
     * @param t      Tiempo (medido en segundos) para el que se quiere calcular X
     * @post Si t<0, lanza una excepción de tipo ArithmeticException
     * @post Si angulo<0 o angulo>pi/2, lanza una excepción de tipo
     *       ArithmeticException
     * @return Distancia calculada como: x_ini + v_ini * Math.cos(angulo) * t
     */

    public static double calcular_X_dado_T(final double x_ini, final double v_ini, final double angulo,
            final double t) {
        if (t < 0)
            throw (new ArithmeticException("El tiempo no puede ser negativo."));
        if (angulo < 0 || angulo > Math.PI / 2)
            throw (new ArithmeticException("El ángulo debe estar entre 0 y PI/2"));
        if (t == 0)
            return x_ini;
        double x = x_ini + v_ini * Math.cos(angulo) * t;
        return x;
    }

    /**
     * Calcula el tiempo que tarda el proyectil en alcanzar un determinado punto X
     * Consideramos el rozamiento nulo.
     * 
     * @param x_ini  Posición X inicial
     * @param v_ini  Velocidad inicial
     * @param angulo Ángulo (expresado en radianes) con el que se lanza el
     *               proyectil.
     * @param x_fin  Posición final X para la que se quiere saber el tiempo en que
     *               la alcanzará.
     * @post Si el coseno del angulo es 0, lanza una excepción de tipo
     *       ArithmeticException
     * @return  Tiempo calculado como: (x_fin - x_ini) / (v_ini * Math.cos(angulo))
     */

    public static double calcular_T_dado_X(final double x_ini, final double v_ini, final double angulo,
            final double x_fin) {
            final double t;
            if(x_ini==x_fin){
                t=0;
                return t;
            }
            if (angulo < 0 || angulo > Math.PI / 2)
            throw (new ArithmeticException("El ángulo debe estar entre 0 y PI/2"));
            if(angulo == Math.PI /2)
            throw (new ArithmeticException("El ángulo no puede ser PI/2"));
            t=(x_fin - x_ini) / (v_ini * Math.cos(angulo));
            return t;
    }

    /**
     * Calcula el desplazamiento en el eje Y durante un tiempo t.
     * Consideramos el rozamiento nulo
     * 
     * @param y_ini Posición Y inicial
     * @param v_ini Velocidad inicial
     * @param angulo Ángulo (expresado en radianes) con el que se lanza el proyectil.
     * @param g Valor para la gravedad (normalmente -9.8)
     * @param t Tiempo (medido en segundos) para el que se quiere calcular Y
     *
     * @post Si t<0, lanza una excepción de tipo ArithmeticException
     * @post Si angulo<0 o angulo>pi/2, lanza una excepción de tipo ArithmeticException
     * 
     * @return Altura (=desplazamiento en eje Y) calculada como:  y_ini + v_0y * t + (1 / 2.0) * g * t * t
     * 
     */

    public static double calcular_Y_dado_T(final double y_ini, final double v_ini, final double angulo, final double g,
            final double t) {
        final double result;
        if(t<0){
            throw (new ArithmeticException("t no puede ser un valor negativo o 0"));
        }
        if (angulo < 0 || angulo > Math.PI / 2)
            throw (new ArithmeticException("El ángulo debe estar entre 0 y PI/2"));
        if(t==0){
            return y_ini;
        }
        double v_0y= v_ini*Math.sin(angulo);
        result=y_ini + v_0y * t + (1 / 2.0) * g * t * t;
        return result;
    }
    /**
     * Calcula el valor que tendra Y para un determinado valor de X
     * Consideramos el rozamiento nulo
     * 
     * @param X_ini Posición X inicial
     * @param y_ini Posición Y inicial
     * @param v_ini Velocidad inicial
     * @param angulo Ángulo (expresado en radianes) con el que se lanza el proyectil.
     * @param g Valor para la gravedad (normalmente -9.8)
     * @param x_fin Valor de X para el que se quiere calcular Y
     *
     * @post Si angulo<0 o angulo>pi/2, lanza una excepción de tipo ArithmeticException
     * 
     * @return Valor que tendrá la altura (o sea Y) para un determinado valor de X.
     * 
     */

    public static double calcular_Y_dado_X(final double x_ini, final double y_ini, final double v_ini, final double angulo, final double g,
            final double x_fin) {
                if (angulo < 0 || angulo > Math.PI / 2)
            throw (new ArithmeticException("El ángulo debe estar entre 0 y PI/2"));
        if(x_fin==x_ini){
            return y_ini;
        }
        double t=calcular_T_dado_X(x_ini, v_ini, angulo, x_fin);
        double y=y_ini+v_ini*Math.sin(angulo)*t+(1/2.0)*g*t*t;
        return y;
    }

     /**
     * Calcula si el disparo impacta en un muro o no
     * Consideramos el rozamiento nulo
     * 
     * @param X_ini Posición X inicial
     * @param y_ini Posición Y inicial
     * @param v_ini Velocidad inicial
     * @param angulo Ángulo (expresado en radianes) con el que se lanza el proyectil.
     * @param g Valor para la gravedad (normalmente -9.8)
     * @param posicion_x_muro Valor de X en la que está el muro
     * @param altura_muro Altura del muro
     *
     * @post Si angulo<0 o angulo>pi/2, lanza una excepción de tipo ArithmeticException
     * 
     * @return Devuelve true si el valor de Y (=altura) que se obtiene para el valor  posicion_x_muro está entre 0 y la altura del muro. 
     */

    public static boolean impacta_en_muro(final double x_ini, final double y_ini, final double v_ini, final double angulo, final double g,
            final double posicion_x_muro, final double altura_muro) {
                if (angulo < 0 || angulo > Math.PI / 2)
                throw (new ArithmeticException("El ángulo debe estar entre 0 y PI/2"));
        double result=calcular_Y_dado_X(x_ini, y_ini, v_ini, angulo, g, posicion_x_muro);
        if(altura_muro> result)
            return (boolean) true;
        else
            return (boolean) false;
        
    
    }



    /**
     * Comprueba si para unos valores introducidos por el usuario, se impactaría en un muro o no.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Este programa calcula si un tiro parabólico impacta en un muro o no");
        Scanner myObj = new Scanner(System.in);

        System.out.println("Introduce velocidad del disparo:");
        double v_ini = myObj.nextDouble();

        System.out.println("Introduce ángulo de disparo (entre 0 y 90):");
        double angulo = Math.toRadians( myObj.nextDouble());

        System.out.println("Introduce distancia a la que está el muro:");
        double posicion_x_muro = myObj.nextDouble();

        System.out.println("Introduce altura del muro:");
        double altura = myObj.nextDouble();

        boolean impacta = impacta_en_muro(0,0, v_ini, angulo, -9.8, posicion_x_muro, altura);

        System.out.println((impacta?"Sí":"No")+" impacta en el muro");
    }


}