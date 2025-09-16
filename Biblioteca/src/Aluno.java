public class Aluno extends Usuario {
    public Aluno(String nome, String matricula) {
        super(nome, matricula);
    }

    @Override
    public int calcularPrazoDevolucao() {
        return 10;
    }
}
