
import java.util.Calendar;

public class Vendedor extends Pessoa {
    private float taxaComissao;
    private Calendar dataInicioTrabalho;
    private int contagemVendas;

    public Vendedor(String nome, Calendar nascimento, String CPF, Endereco endereco, String nacionalidade) {
        super(nome, nascimento, CPF, endereco, nacionalidade);
    }

    public float getTaxaComissao() { return taxaComissao; }
    public void setTaxaComissao(float taxaComissao) { this.taxaComissao = taxaComissao; }

    public Calendar getDataInicioTrabalho() { return dataInicioTrabalho; }
    public void setDataInicioTrabalho(Calendar dataInicioTrabalho) { this.dataInicioTrabalho = dataInicioTrabalho; }

    public int getContagemVendas() { return contagemVendas; }
    public void setContagemVendas(int contagemVendas) { this.contagemVendas = contagemVendas; }

    public void registrarVenda() {
        this.contagemVendas++;
        verificarBonus();
    }

    public void verificarBonus() {
        if (dataInicioTrabalho == null) return;
        long hoje = Calendar.getInstance().getTimeInMillis();
        long inicio = dataInicioTrabalho.getTimeInMillis();
        long diasTrabalhados = (hoje - inicio) / (1000L * 60 * 60 * 24);

        if (diasTrabalhados >= 365 || contagemVendas >= 1000) {
            this.taxaComissao += 0.01f;
            contagemVendas = 0;
            System.out.println("Bônus aplicado! Nova taxa de comissão: " + taxaComissao);
        }
    }
}