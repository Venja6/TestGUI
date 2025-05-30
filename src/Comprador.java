/**
 * Clase que simula a la persona comprando un producto.
 */

class Comprador{
    /**
     * Sonido o sabor del producto consumido.
     */
    private String sonido;

    /**
     * Entero del vuelto que la persona recibe tras comprar.
     */
    private int vuelto;

    /**
     * Crea el comprador que intenta adquirir el producto
     *
     * @param m Moneda con un valor específico.
     * @param cualProducto Constante que elige uno de los productos disponibles.
     * @param exp Expendedor que contiene y retorna las propiedades del producto deseado.
     */
    public Comprador(Moneda m, int cualProducto, Expendedor exp) {
        this.sonido = null;
        this.vuelto = 0;

        Producto b = exp.comprarProducto(m, cualProducto);

        if(b != null){
            this.sonido = b.consumir();
        }

        Moneda monedaVuelto;
        while((monedaVuelto = exp.getVuelto()) != null){
            this.vuelto += monedaVuelto.getValor();
        }
    }

    /**
     * Entrega el vuelto calculado en constructor
     *
     * @return Cantidad de vuelto
     */
    public int cuantoVuelto(){
        return this.vuelto;
    }

    /**
     * Entrega el sabor del producto
     *
     * @return Sabor del producto consumido
     */
    public String queConsumiste(){
        return (this.sonido != null) ? this.sonido : null;
    }
}