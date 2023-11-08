package biblioteca.controllers;

import java.util.ArrayList;
import java.util.List;

import biblioteca.models.ItemMultimidia;
import biblioteca.models.Membro;

public class BibliotecaControllerImpl implements BibliotecaController {
    private List<ItemMultimidia> itens;

    public BibliotecaControllerImpl() {
        itens = new ArrayList<>();
    }

    @Override
    public List<ItemMultimidia> consultarItensDisponiveis() {
        return itens;
    }

    @Override
    public boolean emprestarItem(Membro membro, ItemMultimidia item) {
        // Lógica de empréstimo
        return true;
    }

    @Override
    public boolean devolverItem(Membro membro, ItemMultimidia item) {
        // Lógica de devolução
        return true;
    }
}