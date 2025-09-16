public class Livro {
    private String nome;
    private String autor;
    private int ano;
    private String ISBN;
    private int quantidadeDisponivel;

    public Livro(String nome, String autor, int ano, String ISBN, int quantidadeDisponivel) {
        this.nome = nome;
        this.autor = autor;
        this.ano = ano;
        this.ISBN = ISBN;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public String getNome() {return nome;}
    public String getAutor() {return autor;}
    public int getAno() {return ano;}
    public String getISBN() {return ISBN;}
    public int getQuantidadeDisponivel() {return quantidadeDisponivel;}

    public void setNome(String nome) {this.nome = nome;}
    public void setAutor(String autor) {this.autor = autor;}
    public void setAno(int ano) {this.ano = ano;}
    public void setISBN(String ISBN) {this.ISBN = ISBN;}
    public void setQuantidadeDisponivel(int quantidadeDisponivel) {this.quantidadeDisponivel = quantidadeDisponivel;}

    @Override
    public String toString(){
        return "Livro: " + nome + " - Autor: " + autor + " - Ano: " + ano + " - ISBN: " + ISBN + " - Disponível: " + quantidadeDisponivel;    }
}
