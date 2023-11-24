package turismo.controllers;
import java.time.LocalDate;
import java.util.ArrayList;
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
    public void addPacote(Scanner scanner){
        System.out.println("Informe o nome do destino:");
        String nomeDestino = scanner.nextLine();

        System.out.println("Escolha a categoria do destino:");
        System.out.println("1. PRAIA");
        System.out.println("2. MONTANHA");
        System.out.println("3. CAMPO");
        System.out.println("4. CIDADE");
        int categoriaEscolhida = scanner.nextInt();
        scanner.nextLine();
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
                System.out.println("Opção inválida. Categoria do destino não alterada.");
        }

        System.out.println("Informe as atrações do destino:");
        String atracoesDestino = scanner.nextLine();

        System.out.println("Informe a data disponível (Formato YYYY-MM-DD):");
        LocalDate dataDisp = LocalDate.parse(scanner.nextLine());

        System.out.println("Informe a duração do pacote (em dias):");
        int duracao = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Informe o preço do pacote:");
        int preco = scanner.nextInt();
        scanner.nextLine();

        int i = 1;
        ArrayList<atrativos> a = new ArrayList<>();
        while(i == 1){
            System.out.println("Informe os atrativos do pacote:");
            System.out.println("(pode ter mais de um, um de cada vez)");
            System.out.println("1. piscina");
            System.out.println("2. passeio_guiado");
            System.out.println("3. pensao_completa");
            System.out.println("4. spa");
            System.out.println("5. pet_friendly");
            System.out.println("6. Fim");
            int numero = scanner.nextInt();
            scanner.nextLine();
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
                    System.out.println("Opção inválida.");
            }
        }

        System.out.println("Informe o hotel do pacote:");
        String hotel = scanner.nextLine();

        //categoria
        System.out.println("Escolha a categoria do pacote:");
        System.out.println("1. AVENTURA");
        System.out.println("2. CULTURA");
        System.out.println("3. RELAXAMENTO");
        System.out.println("4. ROMANTICO");
        System.out.println("5. ECOTURISMO");
        System.out.println("6. RELIGIOSO");
        int escolha = scanner.nextInt();
        scanner.nextLine();
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
                System.out.println("Opção inválida. Categoria do pacote não alterada.");
        }

        System.out.println("Informe o máximo de reservas do pacote:");
        int maxReservas = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Informe o código do pacote:");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        Pacote novoPacote = new Pacote(
            new Destino(nomeDestino, categoriaDestino, atracoesDestino),
            dataDisp,
            duracao,
            preco,
            a,
            hotel,
            categoria,
            maxReservas,
            codigo
        );

        pacotes.add(novoPacote);

        System.out.println("Pacote adicionado com sucesso!");
    }
    
    @Override
    public void removerPacote(Scanner scanner){
        System.out.println("Informe o código do pacote a ser removido:");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        for(Pacote p : pacotes){
            if(p.getCodigo() == codigo){
                pacotes.remove(p);
                System.out.println("Pacote removido com sucesso");
                return;
            }
        }
        System.out.println("Pacote não encontrado");
    }
    
    @Override
    public void editarPacote(Scanner scanner){
        System.out.println("Informe o código do pacote a ser editado:");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        Pacote pa = null;

        for(Pacote p : pacotes){
            if(p.getCodigo() == codigo){
                pa = p;
            }
        }
        if(pa == null){
            System.out.println("Pacote não encontrado!");
            return;
        }

        System.out.println("╔════════════════════ Pacotes ══════════════════╗");
        System.out.println("║        Qual informação deseja editar?         ║");
        System.out.println("║                                               ║");
        System.out.println("║ 1. Destino                                    ║");
        System.out.println("║ 2. Data disponivel                            ║");
        System.out.println("║ 3. Duração                                    ║");
        System.out.println("║ 4. Preço                                      ║");
        System.out.println("║ 5. Hotel                                      ║");
        System.out.println("║ 6. Categoria                                  ║");
        System.out.println("║ 7. Maximo de reservas                         ║");
        System.out.println("║ 8. Voltar                                     ║");
        System.out.println("║                                               ║");
        System.out.println("║ Escolha uma opção:                            ║");
        System.out.println("╚═══════════════════════════════════════════════╝");

        int numero = scanner.nextInt();
        scanner.nextLine();

        switch (numero) {
            case 1:
                System.out.println("Informe o nome do destino:");
                String nomeDestino = scanner.nextLine();

                System.out.println("Escolha a categoria do destino:");
                System.out.println("1. PRAIA");
                System.out.println("2. MONTANHA");
                System.out.println("3. CAMPO");
                System.out.println("4. CIDADE");
                int categoriaEscolhida = scanner.nextInt();
                scanner.nextLine();
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
                        System.out.println("Opção inválida. Categoria do destino não alterada.");
                }

                System.out.println("Informe as atrações do destino:");
                String atracoesDestino = scanner.nextLine();

                pa.setDestino(new Destino(nomeDestino, categoriaDestino, atracoesDestino));
                break;
            case 2:
                pa.setDatasDisp(LocalDate.parse(scanner.nextLine()));
                break;
            case 3:
                pa.setDuracao(scanner.nextInt());
                scanner.nextLine();
                break;
            case 4:
                pa.setPreco(scanner.nextInt());
                scanner.nextLine();
                break;
            case 5:
                pa.setHotel(scanner.nextLine());
                break;
            case 6:
                System.out.println("╔═══════════════════════════════════════════╗");
                System.out.println("║            Escolha a Categoria            ║");
                System.out.println("║                                           ║");
                System.out.println("║ 1. AVENTURA                               ║");
                System.out.println("║ 2. CULTURA                                ║");
                System.out.println("║ 3. RELAXAMENTO                            ║");
                System.out.println("║ 4. ROMANTICO                              ║");
                System.out.println("║ 5. ECOTURISMO                             ║");
                System.out.println("║ 6. RELIGIOSO                              ║");
                System.out.println("║                                           ║");
                System.out.println("║ Escolha uma opção:                        ║");
                System.out.println("╚═══════════════════════════════════════════╝");

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
                        System.out.println("Opção inválida. Por favor, escolha novamente.");
                        break;
                }
                break;
            case 7:
                pa.setMaxReservas(scanner.nextInt());
                scanner.nextLine();
                break;
            case 8:
                return;
            default:
                System.out.println("Opção inválida. Por favor, escolha novamente.");
        }
    }

}