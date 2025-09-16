public class Professor extends Usuario {
    public Professor(String nome, String matricula) {
        super(nome, matricula);
    }

    @Override
    public int calcularPrazoDevolucao() {
        return 20; // Professores têm 20 dias para devolver
    }
}
