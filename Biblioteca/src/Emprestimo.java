import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Emprestimo {
    private Livro livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoReal;
    private boolean finalizado;

    public Emprestimo(Livro livro, Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucaoPrevista = dataEmprestimo.plusDays(usuario.calcularPrazoDevolucao());
        this.finalizado = false;
    }

    public Livro getLivro() { return livro; }
    public Usuario getUsuario() { return usuario; }
    public LocalDate getDataEmprestimo() { return dataEmprestimo; }
    public LocalDate getDataDevolucaoPrevista() { return dataDevolucaoPrevista; }
    public LocalDate getDataDevolucaoReal() { return dataDevolucaoReal; }
    public boolean isFinalizado() { return finalizado; }

    public void finalizarEmprestimo() {
        this.finalizado = true;
        this.dataDevolucaoReal = LocalDate.now();
        livro.setQuantidadeDisponivel(livro.getQuantidadeDisponivel() + 1);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String status = finalizado ? "Finalizado" : "Ativo";
        String devolucaoReal = dataDevolucaoReal != null ?
                dataDevolucaoReal.format(formatter) : "Não devolvido";

        return "Empréstimo: " + livro.getNome() + " - Usuário: " + usuario.getNome() + " - Empréstimo: " + dataEmprestimo.format(formatter) + " - Devolução Prevista: " + dataDevolucaoPrevista.format(formatter) + " - Devolução Real: " + devolucaoReal + " - Status: " + status;
    }

}
