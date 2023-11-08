package biblioteca.controllers;

import java.util.ArrayList;
import java.util.List;

import biblioteca.models.Membro;

public class MembroControllerImpl implements MembroController {
    private List<Membro> membros;

    public MembroControllerImpl() {
        membros = new ArrayList<>();
    }

    @Override
    public List<Membro> listarMembros() {
        return membros;
    }

    @Override
    public Membro buscarMembroPorIdentificacao(String identificacao) {
        // Lógica de busca
        return null;
    }
}