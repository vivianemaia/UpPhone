//Sistema de Gerenciamento de Comércio de loja de celulares (com Estoque, Pedidos de Vendas e Ordens de manutenção. Futura integração com banco de dados e desenvolvimento de front end )


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.GregorianCalendar;

public class Main {
    // Listas para armazenar os objetos
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static ArrayList<Vendedor> vendedores = new ArrayList<>();
    private static ArrayList<Pedidos> pedidos = new ArrayList<>();
    private static ArrayList<OS> ordensServico = new ArrayList<>();
    private static ArrayList<Administradores> administradores = new ArrayList<>();
    private static ArrayList<Estoque> estoque = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            // Menu principal
            System.out.println("\n==== SISTEMA DE GERENCIAMENTO ====");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Vendedor");
            System.out.println("3 - Cadastrar Pedido");
            System.out.println("4 - Cadastrar Ordem de Serviço (OS)");
            System.out.println("5 - Cadastrar Administrador");
            System.out.println("6 - Cadastrar Produto");
            System.out.println("7 - Listar todos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    cadastrarCliente(sc);
                    break;
                case 2:
                    cadastrarVendedor(sc);
                    break;
                case 3:
                    cadastrarPedido(sc);
                    break;
                case 4:
                    cadastrarOS(sc);
                    break;
                case 5:
                    cadastrarAdministrador(sc);
                    break;
                case 6:
                    cadastrarProduto(sc);
                    break;
                case 7:
                    listarTodos();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }

    // ===== Métodos de cadastro =====
    private static void cadastrarCliente(Scanner sc) {
        System.out.print("Nome do cliente: ");
        String nome = sc.nextLine();
        Calendar nascimento = obterData(sc);
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        Endereco endereco = obterEndereco(sc);
        System.out.print("Nacionalidade: ");
        String nacionalidade = sc.nextLine();

        Cliente cliente = new Cliente(nome, nascimento, cpf, endereco, nacionalidade);

        System.out.print("Telefone: ");
        cliente.setTelefone(sc.nextLine());
        System.out.print("Email: ");
        cliente.setEmail(sc.nextLine());

        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }


    private static void cadastrarProduto(Scanner sc) {
        System.out.print("Nome do Produto: ");
        String nomeProduto = sc.nextLine();
        System.out.print("Valor do Produto: ");
        float valorProduto = Float.parseFloat(sc.nextLine());
        System.out.print("Quantidade de itens novos adicionados: ");
        int qtdeItensProduto = Integer.parseInt(sc.nextLine());
        System.out.print("Quantidade Minima Estoque: ");
        int qtdeMinimaEstoque = Integer.parseInt(sc.nextLine());
         System.out.print("Quantidade Itens no Estoque: ");
        int qtdeItensEstoque = Integer.parseInt(sc.nextLine());
        
       Estoque produto = new Estoque(nomeProduto, valorProduto, qtdeItensProduto, qtdeMinimaEstoque, qtdeItensEstoque);

              estoque.add(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }
    private static void cadastrarVendedor(Scanner sc) {
        System.out.print("Nome do vendedor: ");
        String nome = sc.nextLine();
        Calendar nascimento = obterData(sc);
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        Endereco endereco = obterEndereco(sc);
        System.out.print("Nacionalidade: ");
        String nacionalidade = sc.nextLine();

        Vendedor vendedor = new Vendedor(nome, nascimento, cpf, endereco, nacionalidade);
        vendedor.setDataInicioTrabalho(obterData(sc));
        System.out.print("Taxa de comissão inicial (ex: 0.05): ");
        vendedor.setTaxaComissao(sc.nextFloat());
        sc.nextLine();

        vendedores.add(vendedor);
        System.out.println("Vendedor cadastrado com sucesso!");
    }

    private static void cadastrarPedido(Scanner sc) {
        System.out.print("Número do pedido: ");
        int numero = sc.nextInt();
        sc.nextLine();
        Calendar dataPedido = obterData(sc);

        System.out.println("Escolha o cliente:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(i + " - " + clientes.get(i).getNome());
        }
        int idxCliente = sc.nextInt();
        sc.nextLine();

        System.out.println("Escolha o vendedor:");
        for (int i = 0; i < vendedores.size(); i++) {
            System.out.println(i + " - " + vendedores.get(i).getNome());
        }
        int idxVendedor = sc.nextInt();
        sc.nextLine();

        Pedidos pedido = new Pedidos(numero, dataPedido, clientes.get(idxCliente), vendedores.get(idxVendedor));
        pedidos.add(pedido);
        System.out.println("Pedido cadastrado com sucesso!");
    }

    private static void cadastrarOS(Scanner sc) {
        System.out.print("Número da OS: ");
        int numero = sc.nextInt();
        sc.nextLine();
        Calendar dataOS = obterData(sc);

        System.out.print("Nome do produto: ");
        String produto = sc.nextLine();

        System.out.println("Escolha o cliente:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(i + " - " + clientes.get(i).getNome());
        }
        int idxCliente = sc.nextInt();
        sc.nextLine();

        OS os = new OS(numero, dataOS, produto, clientes.get(idxCliente));
        ordensServico.add(os);
        System.out.println("Ordem de Serviço cadastrada com sucesso!");
    }

    private static void cadastrarAdministrador(Scanner sc) {
        System.out.print("Nome do administrador: ");
        String nome = sc.nextLine();
        Calendar nascimento = obterData(sc);
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        Endereco endereco = obterEndereco(sc);
        System.out.print("Nacionalidade: ");
        String nacionalidade = sc.nextLine();
        Calendar dataInicio = obterData(sc);

        Administradores admin = new Administradores(nome, nascimento, cpf, endereco, nacionalidade, dataInicio);
        administradores.add(admin);
        System.out.println("Administrador cadastrado com sucesso!");
    }

    // ===== Métodos auxiliares =====
    private static Calendar obterData(Scanner sc) {
        System.out.print("Ano de Nascimento: ");
        int ano = sc.nextInt();
        System.out.print("Mês (1-12): ");
        int mes = sc.nextInt() - 1; // Calendar usa 0-11
        System.out.print("Dia: ");
        int dia = sc.nextInt();
        sc.nextLine(); // limpar buffer
        return new GregorianCalendar(ano, mes, dia);
    }

    private static Endereco obterEndereco(Scanner sc) {
        System.out.print("Rua: ");
        String rua = sc.nextLine();
        System.out.print("Número: ");
        String numero = sc.nextLine();
        System.out.print("Cidade: ");
        String cidade = sc.nextLine();
        System.out.print("Estado: ");
        String estado = sc.nextLine();
        System.out.print("CEP: ");
        String cep = sc.nextLine();
        return new Endereco(rua, numero, cidade, estado, cep);
    }

    private static void listarTodos() {
        System.out.println("\n=== CLIENTES ===");
        for (Cliente c : clientes) {
            System.out.println(c);
        }

        System.out.println("\n=== VENDEDORES ===");
        for (Vendedor v : vendedores) {
            System.out.println(v.getNome() + " | Comissão: " + v.getTaxaComissao());
        }

        System.out.println("\n=== PEDIDOS ===");
        for (Pedidos p : pedidos) {
            p.exibirPedido();
        }

        System.out.println("\n=== ORDEM DE SERVIÇO ===");
        for (OS os : ordensServico) {
            System.out.println("OS nº " + os.getNumero_OS() + " | Produto: " + os.getNomeProduto() + " | Cliente: " + os.getCliente().getNome());
        }

        System.out.println("\n=== ADMINISTRADORES ===");
        for (Administradores a : administradores) {
            a.exibirInfo();
        }
    }
}