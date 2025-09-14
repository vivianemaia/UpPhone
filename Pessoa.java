
import java.util.Calendar;

public class Pessoa {
    protected String nome;
    protected String nacionalidade;
    protected String identificador;
    private Calendar nascimento;
    private int idade;
    private Endereco endereco;

    public Pessoa(String nome, Calendar nascimento, String identificador, Endereco endereco, String nacionalidade) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.identificador = identificador;
        this.endereco = endereco;
        this.nacionalidade = nacionalidade;
        this.idade = calcularIdade();
    }

    private int calcularIdade() {
        Calendar hoje = Calendar.getInstance();
        int anos = hoje.get(Calendar.YEAR) - nascimento.get(Calendar.YEAR);
        if (hoje.get(Calendar.DAY_OF_YEAR) < nascimento.get(Calendar.DAY_OF_YEAR)) {
            anos--;
        }
        return anos;
    }

    public int getIdade() { return idade; }
    public String getNome() { return nome; }
    public String getIdentificador() { return identificador; }
    public String getNacionalidade() { return nacionalidade; }
    public Endereco getEndereco() { return endereco; }
    public Calendar getNascimento() { return nascimento; }
}