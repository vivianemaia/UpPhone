
import java.util.Calendar;

public class Administradores extends Pessoa {
    private Calendar dataInicioTrabalho;

    public Administradores(String nome, Calendar nascimento, String CPF, Endereco endereco, String nacionalidade, Calendar dataInicioTrabalho) {
        super(nome, nascimento, CPF, endereco, nacionalidade);
        this.dataInicioTrabalho = dataInicioTrabalho;
    }

    public Calendar getDataInicioTrabalho() { return dataInicioTrabalho; }
    public void setDataInicioTrabalho(Calendar dataInicioTrabalho) { this.dataInicioTrabalho = dataInicioTrabalho; }

    public void exibirInfo() {
        System.out.println("Nome: " + getNome());
        System.out.println("Data de nascimento: " + getNascimento().getTime());
        System.out.println("CPF: " + getIdentificador());
        System.out.println("Endereço: " + getEndereco());
        System.out.println("Nacionalidade: " + getNacionalidade());
        System.out.println("Data de início do trabalho: " + dataInicioTrabalho.getTime());
    }
}