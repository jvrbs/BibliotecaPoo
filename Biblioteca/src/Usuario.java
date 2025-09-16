public abstract class Usuario {
    private String nome;
    private String matricula;

    public Usuario(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public abstract int calcularPrazoDevolucao();

    @Override
    public String toString() {
        return "Nome: " + nome + " - Matrícula: " + matricula + " - Tipo: " + this.getClass().getSimpleName();
    }
}


