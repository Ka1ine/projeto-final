package biblioteca.views;

import java.util.List;

import biblioteca.models.Membro;

public interface MembroView {
    void mostrarListaMembros(List<Membro> membros);
    void mostrarDetalhesMembro(Membro membro);
}