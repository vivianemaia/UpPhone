
import java.util.Calendar;

public class Pedidos {
    protected int numeroPedido;
    protected Calendar dataPedido;
    protected Cliente cliente;
    protected Vendedor vendedor;

    public Pedidos(int numeroPedido, Calendar dataPedido, Cliente cliente, Vendedor vendedor) {
        this.numeroPedido = numeroPedido;
        this.dataPedido = dataPedido;
        this.cliente = cliente;
        this.vendedor = vendedor;
    }

    public int getNumeroPedido() { return numeroPedido; }
    public void setNumeroPedido(int numeroPedido) { this.numeroPedido = numeroPedido; }
    public Calendar getDataPedido() { return dataPedido; }
    public void setDataPedido(Calendar dataPedido) { this.dataPedido = dataPedido; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Vendedor getVendedor() { return vendedor; }
    public void setVendedor(Vendedor vendedor) { this.vendedor = vendedor; }

    public void exibirPedido() {
        System.out.println("Pedido nº: " + numeroPedido);
        System.out.println("Data: " + dataPedido.getTime());
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Vendedor: " + vendedor.getNome());
    }
}