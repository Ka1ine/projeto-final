package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import java.util.List;
import java.util.Scanner;

import turismo.controllers.*;
import turismo.controllers.ClienteControllerImpl.ViagemCheiaException;
import turismo.models.Adm.Reserva;
import turismo.models.Pacotes.Destino;
import turismo.models.Pacotes.Pacote;
import turismo.models.Pessoas.Cliente;
import turismo.models.Pessoas.Funcionario;
import turismo.views.*;

public class TurismoMain {
    private static TurismoController turismoController;
    private static ClienteController clienteController;
    private static FuncionarioController funcionarioController;
    // private static RelatorioController relatorioController;

    public static void main(String[] args) {
        turismoController = new TurismoControllerImpl();
        clienteController = new ClienteControllerImpl();
        funcionarioController = new FuncionarioControllerImpl();
        // relatorioController = new RelatorioControllerImpl();

        TurismoView turismoView = new TurismoViewImpl(turismoController);
        ClienteView clienteView = new ClienteViewImpl(clienteController);
        FuncionarioView funcionarioView = new FuncionarioViewImpl(funcionarioController);
        // RelatorioView relatorioView = new RelatorioViewImpl(relatorioController);

        // Objetos teste para facilitar nossa vida
        Cliente clienteTeste = new Cliente("Jojo", 123, 2, 12, "jp@gmail.com", LocalDate.parse("2002-05-15"));
        clienteController.adicionarCliente(clienteTeste);
        Funcionario funcionarioTeste = new Funcionario("Trabalhador", 123, 1, 12, "jp@gmail.com",
                LocalDate.parse("2002-05-15"));
        funcionarioController.adicionarFuncionario(funcionarioTeste);
        Destino destinoTeste = new Destino("jacarei", Destino.CategoriaDestino.CIDADE, "velhos");
        ArrayList<Pacote.atrativos> atrativos = new ArrayList<>();
        atrativos.add(Pacote.atrativos.piscina);
        atrativos.add(Pacote.atrativos.spa);
        Pacote pacoteTeste = new Pacote(destinoTeste, LocalDate.parse("2023-11-23"), 10, 100, atrativos,
                "Jacareí Palace", Pacote.CategoriaViagem.AVENTURA, 2, 1);
        turismoController.consultarViagensDisponiveis().add(pacoteTeste);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("╔═════════════════ Menu Turismo ════════════════╗");
            System.out.println("║                                               ║");
            System.out.println("║ 1. Gerenciamento de Pacotes                   ║");
            System.out.println("║ 2. Gerenciamento de Clientes                  ║");
            System.out.println("║ 3. Administração de Funcionários              ║");
            System.out.println("║ 4. Sair                                       ║");
            System.out.println("║                                               ║");
            System.out.println("║ Escolha uma opção:                            ║");
            System.out.println("╚═══════════════════════════════════════════════╝");

            int opcao = inputInt(scanner);

            switch (opcao) {
                case 1:
                    menuViagens(scanner, turismoView);
                    break;
                case 2:
                    menuGerenciamentoClientes(scanner, clienteView);
                    break;
                case 3:
                    menuAdministracaoFuncionarios(scanner, funcionarioView);
                    break;
                case 4:
                    System.out.println("╔═══════════════════════════════════════════════╗");
                    System.out.println("║          Saindo do menu. Até logo!            ║");
                    System.out.println("╚═══════════════════════════════════════════════╝");
                    scanner.close();
                    return;
                default:
                    System.out.println("╔═══════════════════════════════════════════════╗");
                    System.out.println("║                Opção inválida.                ║");
                    System.out.println("║         Por favor, escolha novamente.         ║");
                    System.out.println("╚═══════════════════════════════════════════════╝");
            }
        }
    }

    private static void menuViagens(Scanner scanner, TurismoView turismoView) {
        while (true) {
            System.out.println("╔═══════════════════ Pacotes ═══════════════════╗");
            System.out.println("║                                               ║");
            System.out.println("║ 1. Pacotes disponíveis                        ║");
            System.out.println("║ 2. Reservas                                   ║");
            System.out.println("║ 3. Gerenciamento de Pacotes                   ║");
            System.out.println("║ 4. Voltar                                     ║");
            System.out.println("║                                               ║");
            System.out.println("║ Escolha uma opção:                            ║");
            System.out.println("╚═══════════════════════════════════════════════╝");

            int opcao = inputInt(scanner);

            switch (opcao) {
                case 1:
                    menuGerenciamentoListagemPacotes(scanner, turismoView);
                    break;
                case 2:
                    reservas(scanner);
                    break;
                case 3:
                    gerenciamentoPacotes(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("║                Opção inválida.                ║");
                    System.out.println("║         Por favor, escolha novamente.         ║");
                    System.out.println("╚═══════════════════════════════════════════════╝");
            }
        }
    }

    private static void reservas(Scanner scanner) {
        while (true) {
            System.out.println("╔═══════════════════ Reservas ══════════════════╗");
            System.out.println("║                                               ║");
            System.out.println("║ 1. Acessar reserva                            ║");
            System.out.println("║ 2. Nova reserva                               ║");
            System.out.println("║ 3. Editar reserva                             ║");
            System.out.println("║ 4. Remover reserva                            ║");
            System.out.println("║ 5. Voltar                                     ║");
            System.out.println("║                                               ║");
            System.out.println("║ Escolha uma opção:                            ║");
            System.out.println("╚═══════════════════════════════════════════════╝");

            int opcao = inputInt(scanner);

            switch (opcao) {
                case 1:
                    // acessar reserva
                    acessarReserva(scanner);
                    break;
                case 2:
                    // criar reserva
                    fazerReserva(scanner);
                    break;
                case 3:
                    // editar reserva
                    editarReserva(scanner);
                    break;
                case 4:
                    removerReserva(scanner);
                    // remover reserva
                    break;
                case 5:
                    return;
                default:
                    System.out.println("║                Opção inválida.                ║");
                    System.out.println("║         Por favor, escolha novamente.         ║");
                    System.out.println("╚═══════════════════════════════════════════════╝");
            }
        }
    }

    private static void gerenciamentoPacotes(Scanner scanner) {
        while (true) {
            System.out.println("╔════════════════════ Pacotes ══════════════════╗");
            System.out.println("║                                               ║");
            System.out.println("║ 1. Adicionar Pacote                           ║");
            System.out.println("║ 2. Editar Pacote                              ║");
            System.out.println("║ 3. Remover Pacote                             ║");
            System.out.println("║ 4. Voltar                                     ║");
            System.out.println("║                                               ║");
            System.out.println("║ Escolha uma opção:                            ║");
            System.out.println("╚═══════════════════════════════════════════════╝");

            int opcao = inputInt(scanner);

            switch (opcao) {
                case 1:
                    turismoController.addPacote(scanner);
                    break;
                case 2:
                    turismoController.editarPacote(scanner);
                    break;
                case 3:
                    turismoController.removerPacote(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("║                Opção inválida.                ║");
                    System.out.println("║         Por favor, escolha novamente.         ║");
                    System.out.println("╚═══════════════════════════════════════════════╝");
            }
        }
    }

    private static void menuGerenciamentoListagemPacotes(Scanner scanner, TurismoView turismoView) {
        while (true) {
            System.out.println("╔═════════════════ Menu Filtros ════════════════╗");
            System.out.println("║                                               ║");
            System.out.println("║ 1. Listar Todos os Pacotes                    ║");
            System.out.println("║ 2. Filtrar Pacotes                            ║");
            System.out.println("║ 3. Voltar                                     ║");
            System.out.println("║                                               ║");
            System.out.println("║ Escolha uma opção:                            ║");
            System.out.println("╚═══════════════════════════════════════════════╝");

            int opcao = inputInt(scanner);

            switch (opcao) {
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
                    System.out.println("║                Opção inválida.                ║");
                    System.out.println("║         Por favor, escolha novamente.         ║");
                    System.out.println("╚═══════════════════════════════════════════════╝");
            }
        }
    }

    private static void menuGerenciamentoFiltros(Scanner scanner, TurismoView turismoView) {
        List<? extends Pacote> viagens = turismoController.consultarViagensDisponiveis();

        while (true) {
            System.out.println("╔════════ Menu Gerenciamento de Filtros ════════╗");
            System.out.println("║                                               ║");
            System.out.println("║ Adicione os filtros que deseja depois use a   ║");
            System.out.println("║ opção 4                                       ║");
            System.out.println("║                                               ║");
            System.out.println("║ 1. Adicionar Filtro de Destino                ║");
            System.out.println("║ 2. Adicionar Filtro de Categoria              ║");
            System.out.println("║ 3. Adicionar Filtro de Preço                  ║");
            System.out.println("║ 4. Listar Pacotes com os filtro selecionados  ║");
            System.out.println("║ 5. Voltar                                     ║");
            System.out.println("║                                               ║");
            System.out.print  ("║ Escolha uma opção: ");
            int opcao = inputInt(scanner);
            System.out.println("╚═══════════════════════════════════════════════╝");

            switch (opcao) {
                case 1:
                    HashSet<String> set = new HashSet<>();

                    for (Pacote item : viagens) {
                        set.add(item.getDestino().getNome());
                    }

                    int indexDestino = 1;
                    
                    System.out.println("╔══════════════════ Destinos ═══════════════════╗");
                    System.out.println("║                                               ║");
                    for (String item : set) {
                        System.out.printf("║ %d. %s\n", indexDestino, item);
                        indexDestino += 1;
                    }
                    System.out.println("║                                               ║");
                    System.out.print("║ Selecione o destino: ");
                    int valorDestino = inputInt(scanner);
                    viagens.removeIf(p -> (p.getDestino().getNome() != set.toArray()[valorDestino - 1]));
                    System.out.println("║                                               ║");
                    System.out.println("║ Filtro Adicionado                             ║");
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
                    System.out.print("║ Selecione a categoria: ");
                    int valorCategoria = inputInt(scanner);
                    viagens.removeIf(p -> (p.getCategoria() != values.toArray()[valorCategoria - 1]));
                    System.out.println("║ Filtro Adicionado                             ║");
                    break;
                case 3:
                    System.out.print("║ Digite o preço máximo: ");
                    int valorPreco = inputInt(scanner);
                    viagens.removeIf(p -> (p.getPreco() > valorPreco));
                    System.out.println("║ ID Pacotes disponíveis:                       ║");
                    System.out.println("║ Filtro Adicionado                             ║");
                    break;
                case 4:
                    System.out.println();
                    System.out.println();
                    if (viagens.size() == 0) {
                        System.out.println("Não há pacotes disponíveis com os filtros selecionados");
                    } else {
                        turismoView.mostrarViagensDisponiveis(viagens);
                    }
                    System.out.println();
                    System.out.println();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("║                Opção inválida.                ║");
                    System.out.println("║         Por favor, escolha novamente.         ║");
                    System.out.println("╚═══════════════════════════════════════════════╝");
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

            int opcaoClientes = inputInt(scanner);

            switch (opcaoClientes) {
                case 1:
                    List<Cliente> clientes = clienteController.listarClientes();
                    clienteView.mostrarListaClientes(clientes);
                    break;
                case 2:
                    adicionarCliente(scanner);
                    break;
                case 3:
                    editarCliente(scanner, clienteView);
                    break;
                case 4:
                    removerCliente(scanner, clienteView);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("║                Opção inválida.                ║");
                    System.out.println("║         Por favor, escolha novamente.         ║");
                    System.out.println("╚═══════════════════════════════════════════════╝");
            }
        }
    }

    private static void menuAdministracaoFuncionarios(Scanner scanner, FuncionarioView funcionarioView) {
        int cont = 0;
        int opcaoId = 0;
        int opcaoSenha = 0;

        while (true) {

            System.out.println("╔════════════════ Menu do Gerente ══════════════╗");

            if (cont == 0) {
                System.out.print("║ Digite seu ID: ");
                opcaoId = inputInt(scanner);

                System.out.print("║ Digite sua senha: ");
                opcaoSenha = inputInt(scanner);
            }

            if (opcaoId == 1 && opcaoSenha == 123) {
                cont++;

                if (cont == 10) {
                    cont = 0;
                    System.out.println("║                                               ║");
                    System.out.println("║        Seu tempo de acesso acabou.            ║");
                    System.out.println("╚═══════════════════════════════════════════════╝");
                    return;
                }

                System.out.println("║                                               ║");
                System.out.println("║ 1. Listar Funcionários                        ║");
                System.out.println("║ 2. Adicionar Funcionário                      ║");
                System.out.println("║ 3. Editar Funcionário                         ║");
                System.out.println("║ 4. Remover Funcionário                        ║");
                System.out.println("║ 5. Voltar                                     ║");
                System.out.println("║                                               ║");
                System.out.println("║ Escolha uma opção:                            ║");
                System.out.println("╚═══════════════════════════════════════════════╝");
            } else {
                System.out.println("║                                               ║");
                System.out.println("║                 Acesso negado.                ║");
                System.out.println("╚═══════════════════════════════════════════════╝");
                cont = 0;
                return;
            }

            int opcaoFuncionarios = inputInt(scanner);

            switch (opcaoFuncionarios) {
                case 1:
                    List<Funcionario> funcionarios = funcionarioController.listarFuncionarios();
                    funcionarioView.mostrarListaFuncionarios(funcionarios);
                    break;
                case 2:
                    adicionarFuncionario(scanner);
                    break;
                case 3:
                    editarFuncionario(scanner, funcionarioView);
                    break;
                case 4:
                    removerFuncionario(scanner, funcionarioView);
                    return;
                case 5:
                    return;
                default:
                    System.out.println("║                Opção inválida.                ║");
                    System.out.println("║         Por favor, escolha novamente.         ║");
                    System.out.println("╚═══════════════════════════════════════════════╝");
            }
        }
    }

    private static void fazerReserva(Scanner scanner) {
        Cliente cliente = null;
        Pacote pacote = null;
        Funcionario funcionario = null;
        System.out.println("╔═══════ Operação de Reserva de Pacote ═════════╗");
        System.out.println("║                                               ║");
        System.out.print  ("║ Id do Cliente: ");
        cliente = clienteController.obterClientePorId(inputInt(scanner));
        while(cliente == null){
            System.out.println("║  Cliente não encontrado, digite um ID válido  ║");
            System.out.println("║                                               ║");
            System.out.print  ("║ Id do Cliente: ");
            cliente = clienteController.obterClientePorId(inputInt(scanner));
        }
        
        System.out.print("║ Id do pacote: ");
        pacote = (Pacote) turismoController.obterReservavelporId(scanner.nextLong());
        while(pacote == null){
            System.out.println("║  Pacote não encontrado, digite um ID válido   ║");
            System.out.println("║                                               ║");
            System.out.print  ("║ Id do pacote: ");
            pacote = (Pacote) turismoController.obterReservavelporId(scanner.nextLong());
        }

        System.out.print("║ Id funcionario: ");
        funcionario = funcionarioController.obterFuncionarioPorId(scanner.nextLong());
        while(funcionario == null){
            System.out.println("║Funcionário não encontrado, digite um ID válido║");
            System.out.println("║                                               ║");
            System.out.print  ("║ Id do Funcionário: ");
            funcionario = funcionarioController.obterFuncionarioPorId(scanner.nextLong());
        }

        long id = 0;
        boolean idValido = false;
        while (!idValido) {
            try {
                System.out.print("║ Id da Reserva: ");
                id = scanner.nextLong();
                scanner.nextLine();
                System.out.println("║                                               ║");
                idValido = clienteController.idDisponivelReserva(id);
                if (idValido == false) {
                    System.out.println("║     ID inválido. ID já está sendo usado.      ║");
                    System.out.println("║                                               ║");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("║     ID inválido. ID já está sendo usado.      ║");
                System.out.println("║                                               ║");
                scanner.next();
            }
        }
        try {
            clienteController.reservar(cliente,pacote,funcionario,id);
            System.out.println("║                                               ║");
            System.out.println("║         Viagem Reservada com sucesso!         ║");
            System.out.println("╚═══════════════════════════════════════════════╝");
        } catch (ViagemCheiaException e) {
            e.printStackTrace();
        }
    }

    private static void removerReserva(Scanner scanner) {
        System.out.println("╔════════════════ Remover Reserva ══════════════╗");
        System.out.println("║                                               ║");
        long idReserva;

        try {
            System.out.print("║ Informe o Id da reserva: ");
            idReserva = scanner.nextLong();
        } catch (java.util.InputMismatchException e) {
            System.out.println("║      ID inválido. Digite apenas números.      ║");
            System.out.println("╚═══════════════════════════════════════════════╝");
            scanner.next();
            return;
        }

        Reserva reserva = clienteController.obterReservaPorId(idReserva);
        scanner.nextLine();

        if (reserva == null) {
            System.out.println("║ Reserva não encontrada.                       ║");
            System.out.println("╚═══════════════════════════════════════════════╝");
            return;
        }

        System.out.println("║                                               ║");
        System.out.print  ("║ Tem certeza que quer remover a reserva? (s/n) ");

        String resposta;

        try {
            resposta = scanner.next();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Resposta inválida. Digite 's' para sim ou 'n' para não.");
            scanner.next();
            return;
        }
        switch (resposta) {
            case "s":
                clienteController.getReservas().remove(reserva);
                reserva.getCliente().getReservas().remove(reserva);
                reserva.getReserva().getReservas().remove(reserva);
                System.out.println("║                                               ║");
                System.out.println("║        Reserva Cancelada com sucesso!         ║");
                System.out.println("╚═══════════════════════════════════════════════╝");
                return;
            case "n":
                System.out.println("║                                               ║");
                System.out.println("║              Operação Cancelada               ║");
                System.out.println("╚═══════════════════════════════════════════════╝");
                return;
            default:
                System.out.println("║                                               ║");
                System.out.println("║               Resposta Inválida               ║");
                System.out.println("╚═══════════════════════════════════════════════╝");
                return;
        }
    }

    private static void editarReserva(Scanner scanner) {
        System.out.println("╔═════════════════ Editar Reserva ══════════════╗");
        System.out.println("║                                               ║");
        System.out.print  ("║ Informe o Id da reserva: ");

        long idReserva;

        try {
            idReserva = scanner.nextLong();
        } catch (java.util.InputMismatchException e) {
            System.out.println("ID inválido. Digite apenas números.");
            scanner.next();
            return;
        }

        Reserva reserva = clienteController.obterReservaPorId(idReserva);

        if (reserva == null) {
            System.out.println("║ Reserva não encontrada.                       ║");
            System.out.println("╚═══════════════════════════════════════════════╝");
            return;
        }

        System.out.println("║                                               ║");
        System.out.print  ("║ Escolha o que alterar:                        ║");

        int opcaoAlt;

        try {
            opcaoAlt = inputInt(scanner);
        } catch (java.util.InputMismatchException e) {
            System.out.println("Opção inválida. Digite um número.");
            scanner.next();
            return;
        }
        System.out.println("║ 1. Cliente                                    ║");
        System.out.println("║ 2. Pacote                                     ║");
        System.out.println("║ 3. Funcionario                                ║");
        System.out.println("║                                               ║");

        switch (opcaoAlt) {
            case 1:
                long idNovoC;

                try {
                    System.out.print("║ Informe o Id do novo cliente: ");
                    idNovoC = scanner.nextLong();
                } catch (java.util.InputMismatchException e) {
                    System.out.println("ID do cliente inválido. Digite apenas números.");
                    scanner.next();
                    return;
                }
                reserva.setCliente(clienteController.obterClientePorId(idNovoC));
                System.out.println("║                                               ║");
                System.out.println("║         Reserva Alterada com sucesso!         ║");
                System.out.println("╚═══════════════════════════════════════════════╝");
                return;
            case 2:
                long idNovoP;

                try {
                    System.out.print("║ Informe o Id do novo pacote: ");
                    idNovoP = scanner.nextLong();
                } catch (java.util.InputMismatchException e) {
                    System.out.println("ID do pacote inválido. Digite apenas números.");
                    scanner.next();
                    return;
                }

                reserva.setReserva(turismoController.obterReservavelporId(idNovoP));
                System.out.println("║                                               ║");
                System.out.println("║         Reserva Alterada com sucesso!         ║");
                System.out.println("╚═══════════════════════════════════════════════╝");
                break;
            case 3:
                long idNovoF;

                try {
                    System.out.print("║ Informe o Id do novo funcionário: ");
                    idNovoF = scanner.nextLong();
                } catch (java.util.InputMismatchException e) {
                    System.out.println("ID do funcionário inválido. Digite apenas números.");
                    scanner.next();
                    return;
                }
                reserva.setFuncionario(funcionarioController.obterFuncionarioPorId(idNovoF));
                System.out.println("║                                               ║");
                System.out.println("║         Reserva Alterada com sucesso!         ║");
                System.out.println("╚═══════════════════════════════════════════════╝");
            default:
                System.out.println("║                                               ║");
                System.out.println("║       Entrada inválida, tente novamente!      ║");
                System.out.println("╚═══════════════════════════════════════════════╝");
                return;
        }

    }

    private static void acessarReserva(Scanner scanner) {
        System.out.println("╔════════════════ Acessar Reserva ══════════════╗");
        System.out.println("║                                               ║");
        System.out.print  ("║ Informe o Id da reserva: ");
        long idReserva = scanner.nextLong();
        if(!clienteController.idDisponivelReserva(idReserva)){
            Reserva reserva = clienteController.obterReservaPorId(idReserva);
            System.out.println("║                                               ║");
            System.out.println("║ ID: "+ idReserva);
            System.out.println("║ Id da Viagem: "+ reserva.getReserva().getId());
            System.out.println("║ Id do Cliente: "+ reserva.getCliente().getId());
            System.out.println("║ Id do Funcionário: "+ reserva.getFuncionario().getId());
            System.out.println("║                                               ║");
            System.out.println("╚═══════════════════════════════════════════════╝");
        }else{
            System.out.println("║               Reserva não existe              ║");
            System.out.println("╚═══════════════════════════════════════════════╝");

        }
    }

    // Métodos para adicionar, editar e remover clientes
    private static void adicionarCliente(Scanner scanner) {
        System.out.println("╔═══════════════ Adicionar Cliente ═════════════╗");

        System.out.print("║ Nome: ");
        String nome = scanner.nextLine();

        long documento = 0;
        boolean documentoValido = false;
        while (!documentoValido) {
            try {
                System.out.print("║ Documento: ");
                documento = scanner.nextLong();
                documentoValido = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("║ Documento inválido. Digite apenas números.");
                scanner.next();
            }
        }

        long id = 0;
        boolean idValido = false;
        while (!idValido) {
            try {
                System.out.print("║ ID: ");
                id = scanner.nextLong();
                idValido = clienteController.idDisponivel(id);
                if(idValido == false){
                    System.out.println("║     ID inválido. ID já está sendo usado.      ║");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("║ ID inválido. Digite apenas números.");
                scanner.next();
                scanner.next(); 
            }
        }
        scanner.nextLine();

        long telefone = 0;
        boolean telefoneValido = false;
        while (!telefoneValido) {
            try {
                System.out.print("║ Telefone: ");
                telefone = scanner.nextLong();
                scanner.nextLine();
                telefoneValido = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("║ Telefone inválido. Digite apenas números.");
                scanner.next();
                scanner.next(); 
            }
        }

        String email = "";
        boolean emailValido = false;
        while (!emailValido) {
            System.out.print("║ E-mail: ");
            email = scanner.nextLine();
            if (email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                emailValido = true;
            } else {
                System.out.println("║ E-mail inválido. ");
            }
        }

        LocalDate aniversario = null;
        boolean dataValida = false;
        while (!dataValida) {
            try {
                System.out.print("║ Aniversário (AAAA-MM-DD): ");
                aniversario = LocalDate.parse(scanner.nextLine());
                dataValida = true;
            } catch (java.time.format.DateTimeParseException e) {
                System.out.println("║ Data de aniversário inválida.");
            }
        }

        Cliente cliente = new Cliente(nome, documento, id, telefone, email, aniversario);
        clienteController.listarClientes().add(cliente);
        System.out.println("║                                               ║");
        System.out.println("║         Cliente adicionado com sucesso!       ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
    }

    private static void editarCliente(Scanner scanner, ClienteView clienteView) {
        System.out.println("╔════════════════ Editar Cliente ═══════════════╗");
        System.out.println("║                                               ║");
        System.out.print("║ Informe o ID do cliente: ");
        long idClienteEditar = scanner.nextLong();

        System.out.println("║                                               ║");

        Cliente clienteParaEditar = clienteController.obterClientePorId(idClienteEditar);

        if (clienteParaEditar != null) {
            clienteView.mostrarDetalhesMembro(clienteParaEditar);
            System.out.println("║ 1. Nome                                       ║");
            System.out.println("║ 2. Documento                                  ║");
            System.out.println("║ 3. Telefone                                   ║");
            System.out.println("║ 4. E-mail                                     ║");
            System.out.println("║ 5. Aniversário                                ║");
            System.out.println("║                                               ║");
            System.out.print("║ O que deseja editar: ");

            int opcaoEdicao = inputInt(scanner);
            System.out.println("║                                               ║");
            switch (opcaoEdicao) {
                case 1:
                    System.out.print("║ Novo Nome: ");
                    clienteParaEditar.setNome(scanner.nextLine());
                    break;
                case 2:
                    long novoDocumento;
                    try {
                        System.out.print("║ Novo Documento: ");
                        novoDocumento = scanner.nextLong();
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Documento inválido. Digite apenas números.");
                        scanner.next();
                        return;
                    }
                    clienteParaEditar.setDocumento(novoDocumento);
                    break;
                case 3:
                    long novoTelefone;
                    try {
                        System.out.print("║ Novo Telefone: ");
                        novoTelefone = scanner.nextLong();
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Telefone inválido. Digite apenas números.");
                        scanner.next();
                        return;
                    }
                    clienteParaEditar.setTelefone(novoTelefone);
                    break;
                case 4:
                    String novoEmail = "";
                    boolean emailValido = false;
                    while (!emailValido) {
                        try {
                            System.out.print("║ Novo E-mail: ");
                            novoEmail = scanner.nextLine();

                            // Adiciona a validação do e-mail usando uma expressão regular
                            if (novoEmail.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                                emailValido = true;
                            } else {
                                throw new IllegalArgumentException("E-mail inválido. Digite um e-mail válido.");
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    clienteParaEditar.setEmail(novoEmail);
                    break;
                case 5:
                    LocalDate novoAniversario;
                    try {
                        System.out.print("║ Nova Data de Aniversário (AAAA-MM-DD): ");
                        novoAniversario = LocalDate.parse(scanner.nextLine());
                    } catch (java.time.format.DateTimeParseException e) {
                        System.out.println("Data de aniversário inválida. Digite no formato correto (AAAA-MM-DD).");
                        return;
                    }
                    clienteParaEditar.setAniversario(novoAniversario);
                    break;
                default:
                    System.out.println("║                                               ║");
                    System.out.println("║               Opção inválida!                 ║");
                    System.out.println("╚═══════════════════════════════════════════════╝");
                    return;
            }
            clienteController.atualizarCliente(clienteParaEditar);

            System.out.println("║                                               ║");
            System.out.println("║        Cliente editado com sucesso!           ║");
            System.out.println("╚═══════════════════════════════════════════════╝");
        } else {

            System.out.println("║                                               ║");
            System.out.println("║           Cliente não encontrado.             ║");
            System.out.println("╚═══════════════════════════════════════════════╝");
        }
    }

    private static void removerCliente(Scanner scanner, ClienteView clienteView) {
        System.out.println("╔════════════════ Remover Cliente ══════════════╗");
        System.out.println("║                                               ║");
        System.out.print("║ Informe o ID do cliente: ");
        long idClienteRemover = scanner.nextLong();
        scanner.nextLine();

        Cliente clienteParaRemover = clienteController.obterClientePorId(idClienteRemover);

        if (clienteParaRemover != null) {
            clienteView.mostrarDetalhesMembro(clienteParaRemover);
            System.out.println("║                                               ║");
            System.out.print("║ Tem certeza que deseja remover? (s/n):");
            String confirmacao = scanner.nextLine().toLowerCase();

            if (confirmacao.equals("s")) {
                clienteController.removerCliente(clienteParaRemover);
                System.out.println("║                                               ║");
                System.out.println("║         Cliente removido com sucesso!         ║");
                System.out.println("╚═══════════════════════════════════════════════╝");
            } else {
                System.out.println("║                                               ║");
                System.out.println("║               Remoção cancelada.              ║");
                System.out.println("╚═══════════════════════════════════════════════╝");
            }
        } else {
            System.out.println("║                                               ║");
            System.out.println("║            Cliente não encontrado.            ║");
            System.out.println("╚═══════════════════════════════════════════════╝");
        }
    }

    // Métodos para adicionar, editar e remover funcionarios
    private static void adicionarFuncionario(Scanner scanner) {

        System.out.println("╔════════════ Adicionar Funcionário ═══════════╗");

        System.out.print("║ Nome: ");
        String nome = scanner.nextLine();

        System.out.print("║ Documento: ");
        long documento = scanner.nextLong();

        long id = 0;
        boolean idValido = false;
        while (!idValido) {
            try {
                System.out.print("║ ID: ");
                id = scanner.nextLong();
                idValido = funcionarioController.idDisponivel(id);
                if(idValido == false){
                    System.out.println("║     ID inválido. ID já está sendo usado.      ║");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("║ ID inválido. Digite apenas números.");
                scanner.next();
            }
        }
        scanner.nextLine();

        long telefone = 0;
        boolean telefoneValido = false;
        while (!telefoneValido) {
            try {
                System.out.print("║ Telefone: ");
                telefone = scanner.nextLong();
                telefoneValido = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("║ Telefone inválido. Digite apenas números.");
                scanner.next();
            }
        }
        scanner.nextLine();

        String email = "";
        boolean emailValido = false;
        while (!emailValido) {
            try {
                System.out.print("║ E-mail: ");
                email = scanner.nextLine();
                // Adiciona a validação do e-mail usando uma expressão regular
                if (email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                    emailValido = true;
                } else {
                    throw new IllegalArgumentException("║ E-mail inválido. Digite um e-mail válido.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        LocalDate aniversario = null;
        boolean dataValida = false;
        while (!dataValida) {
            try {
                System.out.print("║ Aniversário (AAAA-MM-DD): ");
                aniversario = LocalDate.parse(scanner.nextLine());
                dataValida = true;
            } catch (java.time.format.DateTimeParseException e) {
                System.out.println("║ Data de aniversário inválida. Digite no formato correto (AAAA-MM-DD).");
            }
        }

        Funcionario novoFuncionario = new Funcionario(nome, documento, id, telefone, email, aniversario);

        funcionarioController.adicionarFuncionario(novoFuncionario);

        System.out.println("║                                               ║");
        System.out.println("║      Funcionário adicionado com sucesso!      ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
    }

    private static void editarFuncionario(Scanner scanner, FuncionarioView funcionarioView) {
        System.out.println("╔═════════════ Editar Funcionário ══════════════╗");
        System.out.println("║                                               ║");
        System.out.print("║ Informe o ID do funcionário: ");
        long idFuncionarioEditar = scanner.nextLong();

        System.out.println("║                                               ║");

        Funcionario funcionarioParaEditar = funcionarioController.obterFuncionarioPorId(idFuncionarioEditar);

        if (funcionarioParaEditar != null) {
            funcionarioView.mostrarDetalhesFuncionario(funcionarioParaEditar);
            System.out.println("║ 1. Nome                                       ║");
            System.out.println("║ 2. Documento                                  ║");
            System.out.println("║ 3. Telefone                                   ║");
            System.out.println("║ 4. E-mail                                     ║");
            System.out.println("║ 5. Aniversário                                ║");
            System.out.println("║                                               ║");
            System.out.print("║ O que deseja editar: ");

            int opcaoEdicao;

            try {
                opcaoEdicao = inputInt(scanner);
            } catch (java.util.InputMismatchException e) {
                System.out.println("Opção inválida. Digite um número.");
                scanner.next();
                return;
            }
            System.out.println("║                                               ║");
            switch (opcaoEdicao) {
                case 1:
                    System.out.print("║ Novo Nome: ");
                    funcionarioParaEditar.setNome(scanner.nextLine());
                    break;
                case 2:
                    try {
                        System.out.print("║ Novo Documento: ");
                        funcionarioParaEditar.setDocumento(scanner.nextLong());
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Documento inválido. Digite apenas números.");
                        scanner.next();
                        return;
                    }
                    break;
                case 3:
                    try {
                        System.out.print("║ Novo Telefone: ");
                        funcionarioParaEditar.setTelefone(scanner.nextLong());
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Telefone inválido. Digite apenas números.");
                        scanner.next();
                        return;
                    }
                    break;
                case 4:
                    String novoEmail = "";
                    boolean emailValido = false;
                    while (!emailValido) {
                        try {
                            System.out.print("║ Novo E-mail: ");
                            novoEmail = scanner.nextLine();
                            // Adiciona a validação do e-mail usando uma expressão regular
                            if (novoEmail.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                                emailValido = true;
                            } else {
                                throw new IllegalArgumentException("E-mail inválido. Digite um e-mail válido.");
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    funcionarioParaEditar.setEmail(novoEmail);
                    break;
                case 5:
                    LocalDate novoAniversario;
                    try {
                        System.out.print("║ Nova Data de Aniversário (AAAA-MM-DD): ");
                        novoAniversario = LocalDate.parse(scanner.nextLine());
                    } catch (java.time.format.DateTimeParseException e) {
                        System.out.println("Data de aniversário inválida. Digite no formato correto (AAAA-MM-DD).");
                        return;
                    }
                    funcionarioParaEditar.setAniversario(novoAniversario);
                    break;
                default:
                    System.out.println("║                                               ║");
                    System.out.println("║               Opção inválida!                 ║");
                    System.out.println("╚═══════════════════════════════════════════════╝");
                    return;
            }
            funcionarioController.atualizarFuncionario(funcionarioParaEditar);

            System.out.println("║                                               ║");
            System.out.println("║      Funcionário editado com sucesso!         ║");
            System.out.println("╚═══════════════════════════════════════════════╝");
        } else {

            System.out.println("║                                               ║");
            System.out.println("║         Funcionário não encontrado.           ║");
            System.out.println("╚═══════════════════════════════════════════════╝");
        }
    }

    private static void removerFuncionario(Scanner scanner, FuncionarioView funcionarioView) {
        System.out.println("╔══════════════ Remover Funcionário ════════════╗");
        System.out.println("║                                               ║");
        System.out.print("║ Informe o ID do funcionário: ");
        long idFuncionarioRemover = scanner.nextLong();
        scanner.nextLine();

        Funcionario funcionarioParaRemover = funcionarioController.obterFuncionarioPorId(idFuncionarioRemover);

        if (funcionarioParaRemover != null) {
            funcionarioView.mostrarDetalhesFuncionario(funcionarioParaRemover);
            System.out.println("║                                               ║");
            System.out.print("║ Tem certeza que deseja remover? (s/n):");
            String confirmacao = scanner.nextLine().toLowerCase();

            if (confirmacao.equals("s")) {
                funcionarioController.removerFuncionario(funcionarioParaRemover);
                System.out.println("║                                               ║");
                System.out.println("║         Funcionário removido com sucesso!         ║");
                System.out.println("╚═══════════════════════════════════════════════╝");
            } else {
                System.out.println("║                                               ║");
                System.out.println("║               Remoção cancelada.              ║");
                System.out.println("╚═══════════════════════════════════════════════╝");
            }
        } else {
            System.out.println("║                                               ║");
            System.out.println("║          Funcionário não encontrado.          ║");
            System.out.println("╚═══════════════════════════════════════════════╝");
        }
    }

    public static int inputInt(Scanner scanner){
        int opcao = 0;
        boolean condicao = true;
        do {
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
                condicao = false;
            } catch (java.util.InputMismatchException e) {
                System.out.println("╔═══════════════════════════════════════════════╗");
                System.out.println("║                Opção inválida.                ║");
                System.out.println("║         Por favor, escolha novamente.         ║");
                System.out.println("╚═══════════════════════════════════════════════╝");
                scanner.nextLine();
            }
        } while (condicao);
        return opcao;
    }
}