import java.util.Scanner

data class Livro(val titulo: String,val paginastotais: Int, var paginaatual: Int = 0)

class Leitura {
    private val livros = mutableListOf<Livro>()
    private val scanner = Scanner(System.`in`)

    fun addLivro() {
        println("Título da livro:")
        val titulo = scanner.nextLine()
        println("Total de páginas:")
        val paginastotais = scanner.nextInt()
        scanner.nextLine()
        livros.add(Livro(titulo, paginastotais))
        println("Livro '$titulo")
    }

    fun marcarprogresso() {
        println("Título para atualizar:")
        val titulo = scanner.nextLine()
        val livro = livros.find { it.titulo.equals(titulo, ignoreCase = true) }

        if (livro != null) {
            println("Digite o número da página atual:")
            val paginaAtual = scanner.nextInt()
            scanner.nextLine()  // Consumir a nova linha

            if (paginaAtual in 0..livro.paginastotais) {
                livro.paginaatual = paginaAtual
                println("Progresso do livro '${livro.titulo}' atualizado para a página $paginaAtual.")
            } else {
                println("Número inválido. O livro tem ${livro.paginastotais} páginas.")
            }
        } else {
            println("Livro não encontrado.")
        }
    }

    fun listarLivros() {
        if (livros.isEmpty()) {
            println("Nenhum livro encontrado.")
            return
        }

        println("Lista de livros:")
        livros.forEach { livro ->
            println("Título: ${livro.titulo}, Páginas Totais: ${livro.paginastotais}, Página Atual: ${livro.paginaatual}")
        }
    }

    fun menu() {
        while (true) {
            println("\n--- Menu ---")
            println("1. Adicionar livro")
            println("2. Marcar progresso")
            println("3. Listar livros")
            println("4. Sair")
            println("Escolha uma opção:")
            when (scanner.nextInt()) {
                1 -> {
                    scanner.nextLine()  // Consumir a nova linha
                    addLivro()
                }
                2 -> {
                    scanner.nextLine()  // Consumir a nova linha
                    marcarprogresso()
                }
                3 -> listarLivros()
                4 -> {
                    println("Saindo...")
                    return
                }
                else -> println("Inválida.")
            }
        }
    }
}

fun main() {
    val tracker = Leitura()
    tracker.menu()
}
