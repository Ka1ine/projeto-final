package main;
import java.util.List;
import java.util.Scanner;
import turismo.controllers.*;
import turismo.models.*;
import turismo.models.Pacotes.Pacote;
import turismo.models.Pessoas.Cliente;
import turismo.views.*;

public class TurismoMain {
    private static TurismoController turismoController;
    private static ClienteController clienteController;
    // private static RelatorioController relatorioController;

    public static void main(String[] args) {
        turismoController = new TurismoControllerImpl();
        clienteController = new ClienteControllerImpl();
        // relatorioController = new RelatorioControllerImpl();

        TurismoView turismoView = new TurismoViewImpl(turismoController);
        ClienteView clienteView = new ClienteViewImpl(clienteController);
        // RelatorioView relatorioView = new RelatorioViewImpl(relatorioController);

        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("╔═════════════════ Menu Turismo ════════════════╗");
            System.out.println("║                                               ║");
            System.out.println("║ 1. Gerenciamento de Viagens                   ║");
            System.out.println("║ 2. Gerenciamento de Clientes                  ║");
            System.out.println("║ 3. Geração de Relatórios e Estatísticas       ║");
            System.out.println("║ 4. Administração de Funcionários              ║");
            System.out.println("║ 5. Sair                                       ║");
            System.out.println("║                                               ║");
            System.out.println("║ Escolha uma opção:                            ║");
            System.out.println("╚═══════════════════════════════════════════════╝");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    menuGerenciamentoViagens(scanner, turismoView);
                    break;
                case 2:
                    menuGerenciamentoClientes(scanner, clienteView);
                    break;
                case 3:
                    // Menu de Geração de Relatórios e Estatísticas
                    // menuRelatoriosEstatisticas(scanner, relatorioView);
                    break;
                case 4:
                    // Menu de Administração de Funcionários
                    menuAdministracaoFuncionarios(scanner);
                    break;
                case 5:
                    System.out.println("Saindo do menu. Até logo!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

    private static void menuGerenciamentoViagens(Scanner scanner, TurismoView turismoView) {
        while (true) {
            System.out.println("╔════════════════ Menu de Viagens ══════════════╗");
            System.out.println("║                                               ║");
            System.out.println("║ 1. Listar Viagens Disponíveis                 ║");
            System.out.println("║ 2. Adicionar Viagem                           ║");
            System.out.println("║ 3. Editar Viagem                              ║");
            System.out.println("║ 4. Remover Viagem                             ║");
            System.out.println("║ 5. Empréstimo de Itens                        ║");
            System.out.println("║ 6. Renovação de Empréstimos                   ║");
            System.out.println("║ 7. Reservas de Viagens                        ║");
            System.out.println("║ 8. Voltar                                     ║");
            System.out.println("║                                               ║");
            System.out.println("║ Escolha uma opção:                            ║");
            System.out.println("╚═══════════════════════════════════════════════╝");

            int opcaoViagens = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoViagens) {
                case 1:
                    List<? extends Pacote> viagens = turismoController.consultarViagensDisponiveis();
                    turismoView.mostrarViagensDisponiveis(viagens);
                    break;
                case 2:
                    adicionarViagem(scanner);
                    break;
                case 3:
                    editarViagem(scanner);
                    break;
                case 4:
                    removerViagem(scanner);
                    break;
                case 5:
                    realizarEmprestimo(scanner);
                    break;
                case 6:
                    realizarRenovacao(scanner);
                    break;
                case 7:
                    fazerReserva(scanner);
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

    private static void menuGerenciamentoClientes(Scanner scanner, ClienteView clienteView) {
        while (true) {
            System.out.println("╔═══════════════ Menu de Clientes ══════════════╗");
            System.out.println("║                                               ║");
            System.out.println("║ 1. Listar Clientes                            ║");
            System.out.println("║ 2. Adicionar Clientes                         ║");
            System.out.println("║ 3. Editar Clientes                            ║");
            System.out.println("║ 4. Remover Clientes                           ║");
            System.out.println("║ 5. Voltar                                     ║");
            System.out.println("║                                               ║");
            System.out.println("║ Escolha uma opção:                            ║");
            System.out.println("╚═══════════════════════════════════════════════╝");

            int opcaoClientes = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoClientes) {
                case 1:
                    List<Cliente> clientes = clienteController.listarClientes();
                    clienteView.mostrarListaClientes(clientes);
                    break;
                case 2:
                    adicionarCliente(scanner);
                    break;
                case 3:
                    editarCliente(scanner);
                    break;
                case 4:
                    removerCliente(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

    private static void menuAdministracaoFuncionarios(Scanner scanner) {
        while (true) {
            System.out.println("╔════════════ Menu de Funcionários ═════════════╗");
            System.out.println("║                                               ║");
            System.out.println("║ 1. Administradores                            ║");
            System.out.println("║ 2. Atendentes                                 ║");
            System.out.println("║ 3. Gerentes                                   ║");
            System.out.println("║ 4. Voltar                                     ║");
            System.out.println("║                                               ║");
            System.out.println("║ Escolha uma opção:                            ║");
            System.out.println("╚═══════════════════════════════════════════════╝");
        
            int opcaoFuncionarios = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoFuncionarios) {
                case 1:
                    // Menu de Administração de Administradores
                    menuAdministradores(scanner);
                    break;
                case 2:
                    // Menu de Administração de Atendentes
                    menuAtendentes(scanner);
                    break;
                case 3:
                    // Menu de Administração de Gerentes
                    menuGerentes(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

    private static void menuAdministradores(Scanner scanner) {
        // Lógica para administração de administradores
    }

    private static void menuAtendentes(Scanner scanner) {
        // Lógica para administração de atendentes
    }

    private static void menuGerentes(Scanner scanner) {
        // Lógica para administração de gerentes
    }

    // Métodos para realizar empréstimo, renovação e reserva
    private static void realizarEmprestimo(Scanner scanner) {
        // Lógica para realizar um empréstimo
        System.out.println("Operação de Empréstimo de Itens");
    }

    private static void realizarRenovacao(Scanner scanner) {
        // Lógica para realizar uma renovação de empréstimo
        System.out.println("Operação de Renovação de Empréstimos");
    }

    private static void fazerReserva(Scanner scanner) {
        System.out.println("Operação de Reserva de Viagens");
    }

    // Métodos para adicionar, editar e remover viagens e clientes
    private static void adicionarViagem(Scanner scanner) {
        System.out.println("Operação de Adição de Viagem");
    }

    private static void editarViagem(Scanner scanner) {
        System.out.println("Operação de Edição de Viagem");
    }

    private static void removerViagem(Scanner scanner) {
        System.out.println("Operação de Remoção de Viagem");
    }

    private static void adicionarCliente(Scanner scanner) {
        System.out.println("Operação de Adição de Cliente");
    }

    private static void editarCliente(Scanner scanner) {
        System.out.println("Operação de Edição de Cliente");
    }

    private static void removerCliente(Scanner scanner) {
        System.out.println("Operação de Remoção de Cliente");
    }
}
