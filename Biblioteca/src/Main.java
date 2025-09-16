import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== SISTEMA DE BIBLIOTECA ===");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Cadastrar Usuário");
            System.out.println("3. Realizar Empréstimo");
            System.out.println("4. Realizar Devolução");
            System.out.println("5. Listar Livros");
            System.out.println("6. Listar Empréstimos Ativos");
            System.out.println("7. Histórico de Usuário");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    cadastrarLivro(biblioteca, scanner);
                    break;
                case 2:
                    cadastrarUsuario(biblioteca, scanner);
                    break;
                case 3:
                    realizarEmprestimo(biblioteca, scanner);
                    break;
                case 4:
                    realizarDevolucao(biblioteca, scanner);
                    break;
                case 5:
                    listarLivros(biblioteca);
                    break;
                case 6:
                    listarEmprestimosAtivos(biblioteca);
                    break;
                case 7:
                    historicoUsuario(biblioteca, scanner);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void cadastrarLivro(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Ano: ");
        int ano = scanner.nextInt();
        scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Quantidade disponível: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        Livro livro = new Livro(titulo, autor, ano, isbn, quantidade);
        biblioteca.cadastrarLivro(livro);
        System.out.println("Livro cadastrado com sucesso!");
    }

    private static void cadastrarUsuario(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Tipo (1-Aluno, 2-Professor): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        Usuario usuario;
        if (tipo == 1) {
            usuario = new Aluno(nome, matricula);
        } else if (tipo == 2) {
            usuario = new Professor(nome, matricula);
        } else {
            System.out.println("Tipo inválido!");
            return;
        }

        biblioteca.cadastrarUsuario(usuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    private static void realizarEmprestimo(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("ISBN do livro: ");
        String isbn = scanner.nextLine();
        System.out.print("Matrícula do usuário: ");
        String matricula = scanner.nextLine();

        boolean sucesso = biblioteca.realizarEmprestimo(isbn, matricula);
        if (sucesso) {
            System.out.println("Empréstimo realizado com sucesso!");
        } else {
            System.out.println("Falha ao realizar empréstimo. Verifique ISBN, matrícula ou disponibilidade.");
        }
    }

    private static void realizarDevolucao(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("ISBN do livro: ");
        String isbn = scanner.nextLine();
        System.out.print("Matrícula do usuário: ");
        String matricula = scanner.nextLine();

        boolean sucesso = biblioteca.realizarDevolucao(isbn, matricula);
        if (sucesso) {
            System.out.println("Devolução realizada com sucesso!");
        } else {
            System.out.println("Falha ao realizar devolução. Verifique ISBN e matrícula.");
        }
    }

    private static void listarLivros(Biblioteca biblioteca) {
        List<Livro> livros = biblioteca.listarLivros();
        System.out.println("\n=== LIVROS CADASTRADOS ===");
        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }

    private static void listarEmprestimosAtivos(Biblioteca biblioteca) {
        List<Emprestimo> emprestimos = biblioteca.listarEmprestimosAtivos();
        System.out.println("\n=== EMPRÉSTIMOS ATIVOS ===");
        for (Emprestimo emp : emprestimos) {
            System.out.println(emp);
        }
    }

    private static void historicoUsuario(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Matrícula do usuário: ");
        String matricula = scanner.nextLine();

        List<Emprestimo> historico = biblioteca.historicoUsuario(matricula);
        System.out.println("\n=== HISTÓRICO DO USUÁRIO ===");
        for (Emprestimo emp : historico) {
            System.out.println(emp);
        }
    }
}