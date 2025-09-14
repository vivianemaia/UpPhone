
import java.util.Calendar;

public class Cliente extends Pessoa {
    private String telefone;
    private String email;

    public Cliente(String nome, Calendar nascimento, String CPF, Endereco endereco, String nacionalidade) {
        super(nome, nascimento, CPF, endereco, nacionalidade);
    }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return super.toString() +
               "\nTelefone: " + telefone +
               "\nEmail: " + email;
    }
}