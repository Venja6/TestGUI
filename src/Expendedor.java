/**
 * Clase que representa una maquina expendedora que contiene los productos.
 * Los productos se representan con constantes de 1 a 5.
 * El expendedor gestiona la compra, el vuelto y los casos erroneos o imposibles.
 * */

class Expendedor {
    public static final int COCA = 1;
    public static final int SPRITE = 2;
    public static final int FANTA = 3;
    public static final int SNICKERS = 4;
    public static final int SUPER8 = 5;

    private Deposito<Producto> coca;
    private Deposito<Producto> sprite;
    private Deposito<Producto> fanta;
    private Deposito<Producto> snickers;
    private Deposito<Producto> super8;
    private Deposito<Moneda> monVu;
    private int precioProducto;

    /**
     * Constructor que agrega los productos a depositos.
     *
     * @param cantidadProducto Cantidad de los productos que se tendrán en los depositos
     */
    public Expendedor(int cantidadProducto){
        coca = new Deposito<>();
        sprite = new Deposito<>();
        fanta = new Deposito<>();
        snickers = new Deposito<>();
        super8 = new Deposito<>();
        monVu = new Deposito<>();

        for(int i = 0; i < cantidadProducto; i++){
            coca.addElemento(new CocaCola(100+i));
            sprite.addElemento(new Sprite(200+i));
            fanta.addElemento(new Fanta(300+i));
            snickers.addElemento(new Snickers(400+i));
            super8.addElemento(new Super8(500+i));
        }
    }

    /**
     * Entrega un producto al usar una moneda y seleccionar cual producto.
     *
     * @param m Moneda (Con cierto valor) entregada por el comprador.
     * @param cual Tipo de producto deseado, representado por una constante de 1 a 5.
     * @return El producto comprado.
     */
    public Producto comprarProducto(Moneda m, int cual){
        if(m == null){
        }

        if(cual < 1 || cual > EnumeracionPrecios.values().length){
        }

        this.precioProducto = EnumeracionPrecios.values()[cual - 1].getPrecio();

        if (m.getValor() < precioProducto){
            monVu.addElemento(m);
        }

        Deposito<?> deposito;
        deposito = switch (cual) {
            case COCA -> coca;
            case SPRITE -> sprite;
            case FANTA -> fanta;
            case SNICKERS -> snickers;
            case SUPER8 -> super8;
            default -> null;
        };

        Producto temp = (Producto) deposito.getElemento();

        int vuelto = m.getValor() - precioProducto;
        for(int i = 0; i < vuelto / 100; i++){
            monVu.addElemento(new Moneda100());
        }
        return temp;
    }

    /**
     * Retorna una moneda del vuelto (Monedas de 100).
     *
     * @return Una moneda del depósito de vuelto.
     */
    public Moneda getVuelto() {
        return monVu.getElemento();
    }
}