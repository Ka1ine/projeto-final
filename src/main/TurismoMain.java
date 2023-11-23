package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import turismo.controllers.*;
import turismo.models.*;
import turismo.models.Pacotes.Destino;
import turismo.models.Pacotes.Pacote;
import turismo.models.Pacotes.Pacote.CategoriaViagem;
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
            System.out.println("---- Menu Turismo ----");
            System.out.println();
            System.out.println("1. Gerenciamento de Viagens");
            System.out.println("2. Gerenciamento de Clientes");
            System.out.println("3. Geração de Relatórios e Estatísticas");
            System.out.println("4. Administração de Funcionários");
            System.out.println("5. Sair");
            System.out.println();
            System.out.println();
            System.out.print("Escolha uma opção: ");

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
            System.out.println("---- Menu Gerenciamento de Viagens ----");
            System.out.println();
            System.out.println("1. Listar Viagens Disponíveis");
            System.out.println("2. Adicionar Viagem");
            System.out.println("3. Editar Viagem");
            System.out.println("4. Remover Viagem");
            System.out.println("5. Empréstimo de Itens");
            System.out.println("6. Renovação de Empréstimos");
            System.out.println("7. Reservas de Viagens");
            System.out.println("8. Voltar");
            System.out.println();
            System.out.println();
            System.out.print("Escolha uma opção: ");

            int opcaoViagens = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoViagens) {
                case 1:
                    menuGerenciamentoListagemPacotes(scanner, turismoView);
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

    private static void menuGerenciamentoListagemPacotes(Scanner scanner, TurismoView turismoView) {
        while (true) {
            System.out.println("---- Menu Gerenciamento de Filtros ----");
            System.out.println();
            System.out.println("1. Listar Todos os Pacotes");
            System.out.println("2. Filtrar Pacotes");
            System.out.println("3. Voltar");
            System.out.println();
            System.out.println();
            System.out.print("Escolha uma opção: ");

            int opcaoFiltro = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoFiltro) {
                case 1:
                    List<? extends Pacote> viagens = turismoController.consultarViagensDisponiveis();
                    turismoView.mostrarViagensDisponiveis(viagens);
                    break;
                case 2:
                    menuGerenciamentoFiltros(scanner, turismoView);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

    private static void menuGerenciamentoFiltros(Scanner scanner, TurismoView turismoView) {
        List<? extends Pacote> viagens = turismoController.consultarViagensDisponiveis();

        while (true) {
            System.out.println("---- Menu Gerenciamento de Filtros ----");
            System.out.println();
            System.out.println("1. Adicionar Filtro de Destino");
            System.out.println("2. Adicionar Filtro de Categoria");
            System.out.println("3. Adicionar Filtro de Preço");
            System.out.println("4. Listar Pacotes");
            System.out.println("5. Voltar");
            System.out.println();
            System.out.println();
            System.out.print("Escolha uma opção: ");

            int opcaoFiltro = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoFiltro) {
                case 1:
                    HashSet<String> set = new HashSet<>();

                    for (Pacote item : viagens) {
                        set.add(item.getDestino().getNome());
                    }

                    int indexDestino = 1;
                    for (String item : set) {
                        System.out.printf("%d. %s\n", indexDestino, item);
                        indexDestino += 1;
                    }

                    System.out.print("Selecione o destino: ");
                    int valorDestino = menuValorFiltro(scanner);
                    System.err.printf("%d", valorDestino);
                    viagens.removeIf(p -> (p.getDestino().getNome() != set.toArray()[valorDestino - 1]));
                    break;
                case 2:
                    List<Pacote.CategoriaViagem> values = Arrays.asList(Pacote.CategoriaViagem.values());
                    
                    int index = 1;
                    for (Pacote.CategoriaViagem item : values) {
                        System.out.printf("%d. %s\n", index, item.name());
                        index += 1;
                    }

                    System.out.println();
                    System.out.println();
                    System.out.print("Selecione a categoria: ");
                    int valorCategoria = menuValorFiltro(scanner);
                    viagens.removeIf(p -> (p.getCategoria() != values.toArray()[valorCategoria - 1]));
                    break;
                case 3:
                    System.out.print("Digite o preço máximo: ");
                    int valorPreco = menuValorFiltro(scanner);
                    viagens.removeIf(p -> (p.getPreco() > valorPreco));
                    break;
                case 4:
                    System.out.println();
                    System.out.println();
                    turismoView.mostrarViagensDisponiveis(viagens);
                    System.out.println();
                    System.out.println();
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

    private static int menuValorFiltro(Scanner scanner) {
        int opcaoFiltro = scanner.nextInt();
        scanner.nextLine();
        return opcaoFiltro;
    }

    private static void menuGerenciamentoClientes(Scanner scanner, ClienteView clienteView) {
        while (true) {
            System.out.println("---- Menu Gerenciamento de Clientes ----");
            System.out.println();
            System.out.println("1. Listar Clientes");
            System.out.println("2. Adicionar Clientes");
            System.out.println("3. Editar Clientes");
            System.out.println("4. Remover Clientes");
            System.out.println("5. Voltar");
            System.out.println();
            System.out.println();
            System.out.print("Escolha uma opção: ");

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
            System.out.println("---- Menu Administração de Funcionários ----");
            System.out.println();
            System.out.println("1. Administradores");
            System.out.println("2. Atendentes");
            System.out.println("3. Gerentes");
            System.out.println("4. Voltar");
            System.out.println();
            System.out.println();
            System.out.print("Escolha uma opção: ");

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
