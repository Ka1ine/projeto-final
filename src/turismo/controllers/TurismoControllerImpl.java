package turismo.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import turismo.models.Pacotes.*;
import turismo.models.Pacotes.Destino.CategoriaDestino;
import turismo.models.Pacotes.Pacote.CategoriaViagem;
import turismo.models.Pacotes.Pacote.atrativos;
import turismo.models.Pessoas.*;

public class TurismoControllerImpl implements TurismoController {
    private List<Pacote> pacotes;

    public TurismoControllerImpl() {
        pacotes = new ArrayList<>();
    }

    @Override
    public List<Pacote> consultarViagensDisponiveis() {
        return pacotes;
    }

    @Override
    public boolean emprestarViagem(Cliente cliente, Pacote pacotes) {
        // Lógica de empréstimo
        return true;
    }

    @Override
    public boolean devolverViagem(Cliente cliente, Pacote pacotes) {
        // Lógica de devolução
        return true;
    }

    @Override
    public Reservavel obterReservavelporId(long id) {
        for (Reservavel reservavel : pacotes) {
            if (reservavel.getId() == id) {
                return reservavel;
            }
        }
        return null;
    }

    @Override
    public void addPacote(Scanner scanner) {
        System.out.println("╔═══════════════ Adicionar Pacote ══════════════╗");
        System.out.println("║               Escolha um destino              ║");
        System.out.println("║                                               ║");
        System.out.println("║ 1. Selecionar destino                         ║");
        System.out.println("║ 2. Adicionar novo destino                     ║");
        System.out.println("║                                               ║");
        System.out.print("║ Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        System.out.println("║                                               ║");

        Destino destino;

        if (opcao == 1) {
            HashSet<String> set = new HashSet<>();

            for (Pacote item : pacotes) {
                set.add(item.getDestino().getNome());
            }

            int indexDestino = 1;

            for (String item : set) {
                System.out.printf("║ %d. %s\n", indexDestino, item);
                indexDestino += 1;
            }
            System.out.println("║                                               ║");

            System.out.print("║ Selecione o destino: ");
            int valorDestino = scanner.nextInt();
            scanner.nextLine();

            destino = pacotes.get(valorDestino - 1).getDestino();
        } else {
            System.out.print("║ Informe o nome do destino: ");
            String nomeDestino = scanner.nextLine();
            System.out.println("║                                               ║");
            System.out.println("║ Escolha a categoria do destino:               ║");
            System.out.println("║                                               ║");
            System.out.println("║ 1. PRAIA                                      ║");
            System.out.println("║ 2. MONTANHA                                   ║");
            System.out.println("║ 3. CAMPO                                      ║");
            System.out.println("║ 4. CIDADE                                     ║");
            System.out.println("║                                               ║");
            System.out.print("║ ");
            int categoriaEscolhida = scanner.nextInt();
            scanner.nextLine();
            System.out.println("║                                               ║");
            CategoriaDestino categoriaDestino = null;

            switch (categoriaEscolhida) {
                case 1:
                    categoriaDestino = CategoriaDestino.PRAIA;
                    break;
                case 2:
                    categoriaDestino = CategoriaDestino.MONTANHA;
                    break;
                case 3:
                    categoriaDestino = CategoriaDestino.CAMPO;
                    break;
                case 4:
                    categoriaDestino = CategoriaDestino.CIDADE;
                    break;
                default:
                    System.out.println("║ Opção inválida. Categoria do destino não alterada.");
                    System.out.println("║                                               ║");
            }

            System.out.print("║ Informe as atrações do destino: ");
            System.out.println("║                                               ║");
            String atracoesDestino = scanner.nextLine();

            destino = new Destino(nomeDestino, categoriaDestino, atracoesDestino);
        }

        System.out.println("║ Informe a data disponível                     ║");
        System.out.print("║ (Formato YYYY-MM-DD):  ");
        LocalDate dataDisp = LocalDate.parse(scanner.nextLine());

        System.out.print("║ Informe a duração do pacote (em dias): ");
        int duracao = scanner.nextInt();
        scanner.nextLine();

        System.out.print("║ Informe o preço do pacote: ");
        int preco = scanner.nextInt();
        scanner.nextLine();
        System.out.println("║                                               ║");
        System.out.println("║        Informe os atrativos do pacote:        ║");
        System.out.println("║     (pode ter mais de um, um de cada vez)     ║");
        System.out.println("║                                               ║");
        System.out.println("║ 1. Piscina                                    ║");
        System.out.println("║ 2. Passeio guiado                             ║");
        System.out.println("║ 3. Pensao completa                            ║");
        System.out.println("║ 4. Spa                                        ║");
        System.out.println("║ 5. Pet Friendly                               ║");
        System.out.println("║ 6. Fim                                        ║");
        System.out.println("║                                               ║");

        int i = 1;
        ArrayList<atrativos> a = new ArrayList<>();
        while (i == 1) {
            System.out.print("║ Escolha uma opção: ");
            int numero = scanner.nextInt();
            atrativos categoria = null;

            switch (numero) {
                case 1:
                    categoria = atrativos.piscina;
                    a.add(categoria);
                    break;
                case 2:
                    categoria = atrativos.passeio_guiado;
                    a.add(categoria);
                    break;
                case 3:
                    categoria = atrativos.pensao_completa;
                    a.add(categoria);
                    break;
                case 4:
                    categoria = atrativos.spa;
                    a.add(categoria);
                    break;
                case 5:
                    categoria = atrativos.pet_friendly;
                    a.add(categoria);
                    break;
                case 6:
                    i = 0;
                    break;
                default:
                    System.out.println("║ Opção inválida.");
            }
        }
        scanner.nextLine();

        System.out.println("║                                               ║");
        System.out.print("║ Informe o hotel do pacote: ");
        String hotel = scanner.nextLine();

        System.out.println("║                                               ║");
        System.out.println("║         Escolha a categoria do pacote:        ║");
        System.out.println("║                                               ║");
        System.out.println("║ 1. AVENTURA                                   ║");
        System.out.println("║ 2. CULTURA                                    ║");
        System.out.println("║ 3. RELAXAMENTO                                ║");
        System.out.println("║ 4. ROMANTICO                                  ║");
        System.out.println("║ 5. ECOTURISMO                                 ║");
        System.out.println("║ 6. RELIGIOSO                                  ║");
        System.out.println("║                                               ║");
        System.out.print("║ ");
        int escolha = scanner.nextInt();
        scanner.nextLine();
        System.out.println("║                                               ║");
        CategoriaViagem categoria = null;

        switch (escolha) {
            case 1:
                categoria = CategoriaViagem.AVENTURA;
                break;
            case 2:
                categoria = CategoriaViagem.CULTURA;
                break;
            case 3:
                categoria = CategoriaViagem.RELAXAMENTO;
                break;
            case 4:
                categoria = CategoriaViagem.ROMANTICO;
                break;
            case 5:
                categoria = CategoriaViagem.ECOTURISMO;
                break;
            case 6:
                categoria = CategoriaViagem.RELIGIOSO;
                break;
            default:
                System.out.println("║ Opção inválida. Categoria do pacote não alterada.");
                System.out.println("║                                               ║");
        }

        System.out.print("║ Informe o máximo de reservas do pacote: ");
        int maxReservas = scanner.nextInt();
        scanner.nextLine();
        System.out.println("║                                               ║");

        long id = 0;
        boolean idValido = false;
        while (!idValido) {
            try {
                System.out.print("║ Informe o código do pacote: ");
                id = scanner.nextLong();
                scanner.nextLine();
                System.out.println("║                                               ║");
                idValido = idDisponivel(id);
                if (idValido == false) {
                    System.out.println("║     ID inválido. ID já está sendo usado.      ║");
                    System.out.println("║                                               ║");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("║ ID inválido. Digite apenas números.");
                System.out.println("║                                               ║");
                scanner.next();
            }
        }

        Pacote novoPacote = new Pacote(
                destino,
                dataDisp,
                duracao,
                preco,
                a,
                hotel,
                categoria,
                maxReservas,
                id);

        pacotes.add(novoPacote);

        System.out.println("║         Pacote adicionado com sucesso!        ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
    }

    @Override
    public void removerPacote(Scanner scanner) {
        System.out.println("╔════════════════ Remover Pacote ═══════════════╗");
        System.out.println("║                                               ║");
        System.out.print("║ Informe o código do pacote a ser removido: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("║                                               ║");

        for (Pacote p : pacotes) {
            if (p.getCodigo() == codigo) {
                System.out.print  ("║ Tem certeza que quer remover o pacote? (s/n) ");
                if(scanner.next().equals("s")){
                    pacotes.remove(p);
                    System.out.println("║                                               ║");
                    System.out.println("║          Pacote removido com sucesso!         ║");
                    System.out.println("╚═══════════════════════════════════════════════╝");
                }else{
                    System.out.println("║                                               ║");
                    System.out.println("║               Remoção cancelada!              ║");
                    System.out.println("╚═══════════════════════════════════════════════╝");
                }
                scanner.nextLine();
                return;
            }
        }
        System.out.println("║             Pacote não encontrado             ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
    }

    @Override
    public void editarPacote(Scanner scanner) {
        System.out.println("╔═════════════════ Editar Pacote ═══════════════╗");
        System.out.println("║                                               ║");
        System.out.print("║ Informe o código do pacote a ser editado: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        Pacote pa = null;

        for (Pacote p : pacotes) {
            if (p.getCodigo() == codigo) {
                pa = p;
            }
        }
        if (pa == null) {
            System.out.println("║                                               ║");
            System.out.println("║             Pacote não encontrado             ║");
            System.out.println("╚═══════════════════════════════════════════════╝");
            return;
        }

        System.out.println("║                                               ║");
        System.out.println("║        Qual informação deseja editar?         ║");
        System.out.println("║                                               ║");
        System.out.println("║ 1. Destino                                    ║");
        System.out.println("║ 2. Data disponivel                            ║");
        System.out.println("║ 3. Duração                                    ║");
        System.out.println("║ 4. Preço                                      ║");
        System.out.println("║ 5. Atrativos                                  ║");
        System.out.println("║ 6. Hotel                                      ║");
        System.out.println("║ 7. Categoria                                  ║");
        System.out.println("║ 8. Maximo de reservas                         ║");
        System.out.println("║ 9. Voltar                                     ║");
        System.out.println("║                                               ║");
        System.out.print("║ Escolha uma opção: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        switch (numero) {
            case 1:
                System.out.println("║                                               ║");
                System.out.println("║               Escolha um destino              ║");
                System.out.println("║                                               ║");
                System.out.println("║ 1. Selecionar destino                         ║");
                System.out.println("║ 2. Adicionar novo destino                     ║");
                System.out.println("║                                               ║");
                System.out.print("║ Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();
                System.out.println("║                                               ║");

                Destino destino;

                if (opcao == 1) {
                    HashSet<String> set = new HashSet<>();

                    for (Pacote item : pacotes) {
                        set.add(item.getDestino().getNome());
                    }

                    int indexDestino = 1;

                    for (String item : set) {
                        System.out.printf("║ %d. %s\n", indexDestino, item);
                        indexDestino += 1;
                    }
                    System.out.println("║                                               ║");

                    System.out.print("║ Selecione o destino: ");
                    int valorDestino = scanner.nextInt();
                    scanner.nextLine();

                    destino = pacotes.get(valorDestino - 1).getDestino();
                } else {
                    System.out.print("║ Informe o nome do destino: ");
                    String nomeDestino = scanner.nextLine();
                    System.out.println("║                                               ║");
                    System.out.println("║ Escolha a categoria do destino:               ║");
                    System.out.println("║                                               ║");
                    System.out.println("║ 1. PRAIA                                      ║");
                    System.out.println("║ 2. MONTANHA                                   ║");
                    System.out.println("║ 3. CAMPO                                      ║");
                    System.out.println("║ 4. CIDADE                                     ║");
                    System.out.println("║                                               ║");
                    System.out.print("║ ");
                    int categoriaEscolhida = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("║                                               ║");
                    CategoriaDestino categoriaDestino = null;

                    switch (categoriaEscolhida) {
                        case 1:
                            categoriaDestino = CategoriaDestino.PRAIA;
                            break;
                        case 2:
                            categoriaDestino = CategoriaDestino.MONTANHA;
                            break;
                        case 3:
                            categoriaDestino = CategoriaDestino.CAMPO;
                            break;
                        case 4:
                            categoriaDestino = CategoriaDestino.CIDADE;
                            break;
                        default:
                            System.out.println("║ Opção inválida. Categoria do destino não alterada.");
                            System.out.println("║                                               ║");
                    }

                    System.out.print("║ Informe as atrações do destino: ");
                    String atracoesDestino = scanner.nextLine();

                    destino = new Destino(nomeDestino, categoriaDestino, atracoesDestino);
                }

                pa.setDestino(destino);
                break;
            case 2:
                System.out.println("║ Informe a nova data disponível                ║");
                System.out.print("║ (Formato YYYY-MM-DD):  ");
                pa.setDatasDisp(LocalDate.parse(scanner.nextLine()));
                break;
            case 3:
                System.out.print("║ Informe a duração do pacote (em dias): ");
                pa.setDuracao(scanner.nextInt());
                scanner.nextLine();
                break;
            case 4:
                System.out.print("║ Informe o preço do pacote: ");
                pa.setPreco(scanner.nextInt());
                scanner.nextLine();
                break;
            case 5:
                System.out.println("║                                               ║");
                System.out.println("║        Informe os atrativos do pacote:        ║");
                System.out.println("║     (pode ter mais de um, um de cada vez)     ║");
                System.out.println("║                                               ║");
                System.out.println("║ 1. Piscina                                    ║");
                System.out.println("║ 2. Passeio guiado                             ║");
                System.out.println("║ 3. Pensao completa                            ║");
                System.out.println("║ 4. Spa                                        ║");
                System.out.println("║ 5. Pet Friendly                               ║");
                System.out.println("║ 6. Fim                                        ║");
                System.out.println("║                                               ║");

                int i = 1;
                ArrayList<atrativos> a = new ArrayList<>();
                while (i == 1) {
                    System.out.print("║ Escolha uma opção: ");
                    int num = scanner.nextInt();
                    atrativos categoria = null;

                    switch (num) {
                        case 1:
                            categoria = atrativos.piscina;
                            if(!a.contains(categoria)){
                                a.add(categoria);
                            }
                            break;
                        case 2:
                            categoria = atrativos.passeio_guiado;
                            if(!a.contains(categoria)){
                                a.add(categoria);
                            }
                            break;
                        case 3:
                            categoria = atrativos.pensao_completa;
                            if(!a.contains(categoria)){
                                a.add(categoria);
                            }
                            break;
                        case 4:
                            categoria = atrativos.spa;
                            if(!a.contains(categoria)){
                                a.add(categoria);
                            }
                            break;
                        case 5:
                            categoria = atrativos.pet_friendly;
                            if(!a.contains(categoria)){
                                a.add(categoria);
                            }
                            break;
                        case 6:
                            if(a.isEmpty()){
                                System.out.println("║         Selecione pelo menos uma opção.       ║");
                            }else{
                                i = 0;
                            }
                            break;
                        default:
                            System.out.println("║                 Opção inválida.               ║");
                    }
                }
                scanner.nextLine();
                break;
            case 6:
                System.out.print("║ Informe o hotel do pacote: ");
                pa.setHotel(scanner.nextLine());
                break;
            case 7:
                System.out.println("║                                               ║");
                System.out.println("║              Escolha a Categoria              ║");
                System.out.println("║                                               ║");
                System.out.println("║ 1. AVENTURA                                   ║");
                System.out.println("║ 2. CULTURA                                    ║");
                System.out.println("║ 3. RELAXAMENTO                                ║");
                System.out.println("║ 4. ROMANTICO                                  ║");
                System.out.println("║ 5. ECOTURISMO                                 ║");
                System.out.println("║ 6. RELIGIOSO                                  ║");
                System.out.println("║                                               ║");
                System.out.print  ("║ Escolha uma opção: ");
                int num = scanner.nextInt();
                scanner.nextLine();

                switch (num) {
                    case 1:
                        pa.setCategoria(CategoriaViagem.AVENTURA);
                        break;
                    case 2:
                        pa.setCategoria(CategoriaViagem.CULTURA);
                        break;
                    case 3:
                        pa.setCategoria(CategoriaViagem.RELAXAMENTO);
                        break;
                    case 4:
                        pa.setCategoria(CategoriaViagem.ROMANTICO);
                        break;
                    case 5:
                        pa.setCategoria(CategoriaViagem.ECOTURISMO);
                        break;
                    case 6:
                        pa.setCategoria(CategoriaViagem.RELIGIOSO);
                        break;
                    default:
                        System.out.println("║     Opção inválida. Escolha novamente.    ║");
                        break;
                }
                break;
            case 8:
                System.out.print("║ Informe o máximo de reservas do pacote: ");
                pa.setMaxReservas(scanner.nextInt());
                scanner.nextLine();
                break;
            case 9:
                System.out.println("║                                               ║");
                System.out.println("║                Edição Cancelada               ║");
                System.out.println("╚═══════════════════════════════════════════════╝");
                return;
            default:
                System.out.println("║     Opção inválida. Escolha novamente.    ║");
        }
        System.out.println("║                                               ║");
        System.out.println("║           Pacote Editado com sucesso!         ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
    }

    @Override
    public Boolean idDisponivel(long id) {
        for (Pacote pack : pacotes) {
            if (pack.getId() == id) {
                // ID usado
                return false;
            }
        }
        return true;
    }

}