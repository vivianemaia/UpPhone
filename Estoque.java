
import java.util.Calendar;

public class Estoque {
  //  protected int id;
    protected String nomeProduto;
    protected float valorProduto;
    protected Calendar dataAtualizacaoPreco;
    protected int qtdeItensEstoque;
    protected int qtdeItensProduto;
    protected int qtdeMinimaEstoque;

    public Estoque(String nomeProduto, float valorProduto, int qtdeItensProduto, int qtdeMinimaEstoque, int qtdeItensEstoque ) {
      //  this.id = id;
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.qtdeItensProduto = qtdeItensProduto;
        this.qtdeMinimaEstoque = qtdeMinimaEstoque;
        this.qtdeItensEstoque = qtdeItensEstoque;
        this.dataAtualizacaoPreco = Calendar.getInstance();
    }

    public void atualizarPreco(float novoValor) {
        this.valorProduto = novoValor;
        this.dataAtualizacaoPreco = Calendar.getInstance();
    }

    public void adicionarProduto(int quantidade) { this.qtdeItensEstoque += quantidade; }

    public boolean retirarProduto(int quantidade) {
        if (quantidade <= qtdeItensEstoque) {
            qtdeItensEstoque -= quantidade;
            return true;
        } else {
            System.out.println("Estoque insuficiente.");
            return false;
        }
    }

    public boolean estoqueBaixo() { return qtdeItensEstoque <= qtdeMinimaEstoque; }

   // public int getId() { return id; }
    public String getNomeProduto() { return nomeProduto; }
    public float getValorProduto() { return valorProduto; }
    public int getQtdeItensEstoque() { return qtdeItensEstoque; }
    public int getQtdeMinimaEstoque() { return qtdeMinimaEstoque; }

    @Override
    public String toString() {
        return "Produto: " + nomeProduto +
               " | Valor: R$" + valorProduto +
               " | Estoque: " + qtdeItensEstoque +
               " | Mínimo: " + qtdeMinimaEstoque;
    }
}