package conexaoPostgreSQL;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import dao.LivroDAO;
import modelo.Livro;

public class Principal {
	
	public static void main(String[] args) throws Exception {
		LivroDAO livroDAO = new LivroDAO();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\n---- MENU ----");
            System.out.println("1 - Listar livros");
            System.out.println("2 - Inserir livro");
            System.out.println("3 - Excluir livro");
            System.out.println("4 - Atualizar livro");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Mostrar livros ordenados por código ---");
                    List<Livro> livros = livroDAO.getOrderByCodigo();
                    for (Livro u: livros) {
                        System.out.println(u.toString());
                    }
                    break;

                case 2:
                    System.out.println("\n---- Inserir livro ----");
                    System.out.print("Código: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.print("Titulo: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();

                    float nota = 0;
                    boolean notaValida = false;
                    while (!notaValida) {
                        try {
                            System.out.print("Nota (0/5): ");
                            nota = scanner.nextFloat();
                            if (nota < 0 || nota > 5) {
                                System.out.println("Nota deve estar entre 0 e 5.");
                            } else {
                                notaValida = true; 
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Por favor, insira um número válido entre 0 e 5.");
                            scanner.next(); 
                        }
                    }

                    Livro novoLivro = new Livro(codigo, titulo, autor, nota);
                    if (livroDAO.insert(novoLivro)) {
                        System.out.println("Inserção realizada com sucesso -> " + novoLivro.toString());
                    }
                    break;

                case 3:
                    System.out.println("\n---- Excluir livro ----");
                    System.out.print("Código do livro a ser excluído: ");
                    int codigoExcluir = scanner.nextInt();
                    if (livroDAO.delete(codigoExcluir)) {
                        System.out.println("Exclusão realizada com sucesso!");
                    }
                    break;

                case 4:
                    System.out.println("\n---- Atualizar livro ----");
                    System.out.print("Código: ");
                    int codigoRef = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.print("Novo Título: ");
                    String newTitulo = scanner.nextLine();

                    System.out.print("Novo Autor: ");
                    String newAutor = scanner.nextLine();

                    float newNota = 0;
                    boolean newNotaValida = false;
                    while (!newNotaValida) {
                        try {
                            System.out.print("Nova Nota (0/5): ");
                            newNota = scanner.nextFloat();
                            if (newNota < 0 || newNota > 5) {
                                System.out.println("Nota deve estar entre 0 e 5.");
                            } else {
                                newNotaValida = true; 
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Por favor, insira um número válido entre 0 e 5.");
                            scanner.next(); 
                        }
                    }

                    Livro livroAtualizar = new Livro(codigoRef, newTitulo, newAutor, newNota);
                    if (livroDAO.update(livroAtualizar)) {
                        System.out.println("Atualização realizada com sucesso -> " + livroAtualizar.toString());
                    }
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}