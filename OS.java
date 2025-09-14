
import java.util.Calendar;

public class OS {
    protected int numero_OS;
    protected Calendar data_OS;
    protected String nomeProduto;
    protected Cliente cliente;

    public OS(int numero_OS, Calendar data_OS, String nomeProduto, Cliente cliente) {
        this.numero_OS = numero_OS;
        this.data_OS = data_OS;
        this.nomeProduto = nomeProduto;
        this.cliente = cliente;
    }

    public int getNumero_OS() { return numero_OS; }
    public void setNumero_OS(int numero_OS) { this.numero_OS = numero_OS; }
    public Calendar getData_OS() { return data_OS; }
    public void setData_OS(Calendar data_OS) { this.data_OS = data_OS; }
    public String getNomeProduto() { return nomeProduto; }
    public void setNomeProduto(String nomeProduto) { this.nomeProduto = nomeProduto; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
}