/**
 * Superclase que agrupa las clases de tipo moneda.
 * Implementa la interfaz "comparable" para permitir la comparación
 * de monedas en función de su valor.
 */
abstract class Moneda {

    /**
     * Constructor vacio
     */
    public Moneda(){
    }

    /**
     * Retorna el numero de serie de la moneda.
     * @return Numero de serie unico.
     */
    public Moneda getSerie(){
        return this;

    }

    /**
     * Metodo abstracto definido en las subclases para obtener el valor de la moneda.
     * @return Valor de la moneda.
     */
    public abstract int getValor();

}