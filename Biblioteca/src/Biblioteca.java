import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {
    private List<Livro> livros;
    private List<Usuario> usuarios;
    private List<Emprestimo> emprestimos;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public boolean realizarEmprestimo(String isbn, String matricula) {
        Livro livro = buscarLivroPorISBN(isbn);
        Usuario usuario = buscarUsuarioPorMatricula(matricula);

        if (livro == null || usuario == null) {
            return false;
        }

        if (livro.getQuantidadeDisponivel() <= 0) {
            return false;
        }

        Emprestimo emprestimo = new Emprestimo(livro, usuario);
        emprestimos.add(emprestimo);
        livro.setQuantidadeDisponivel(livro.getQuantidadeDisponivel() - 1);

        return true;
    }

    public boolean realizarDevolucao(String isbn, String matricula) {
        for (Emprestimo emp : emprestimos) {
            if (emp.getLivro().getISBN().equals(isbn) &&
                    emp.getUsuario().getMatricula().equals(matricula) &&
                    !emp.isFinalizado()) {
                emp.finalizarEmprestimo();
                return true;
            }
        }
        return false;
    }

    private Livro buscarLivroPorISBN(String isbn) {
        for (Livro livro : livros) {
            if (livro.getISBN().equals(isbn)) {
                return livro;
            }
        }
        return null;
    }

    private Usuario buscarUsuarioPorMatricula(String matricula) {
        for (Usuario usuario : usuarios) {
            if (usuario.getMatricula().equals(matricula)) {
                return usuario;
            }
        }
        return null;
    }

    public List<Livro> listarLivros() {
        return new ArrayList<>(livros);
    }

    public List<Emprestimo> listarEmprestimosAtivos() {
        return emprestimos.stream()
                .filter(emp -> !emp.isFinalizado())
                .collect(Collectors.toList());
    }

    public List<Emprestimo> historicoUsuario(String matricula) {
        return emprestimos.stream()
                .filter(emp -> emp.getUsuario().getMatricula().equals(matricula))
                .collect(Collectors.toList());
    }

    public List<Livro> getLivros() { return livros; }
    public List<Usuario> getUsuarios() { return usuarios; }
    public List<Emprestimo> getEmprestimos() { return emprestimos; }
}