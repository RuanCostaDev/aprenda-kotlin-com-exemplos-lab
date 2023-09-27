// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val name: String)

data class ConteudoEducacional(var nome: String, val duracao: Int)

class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {


    val inscritos = mutableListOf<Usuario>()


    fun matricular(nome: String) {
        try {
        val novoUsuario = Usuario(nome)
        inscritos.add(novoUsuario)

        } catch (e: IllegalArgumentException) {
            println("Argumento inválido para novo de usuário!")
            e.printStackTrace()
        }
    }

    override fun toString(): String {
        var retornoConteudo = ""
        conteudos.forEach {
            retornoConteudo += "[${it.nome}, ${it.duracao}min.]\n"
        }

        var retornoUsuario = ""
        inscritos.forEach {
            retornoUsuario += "[${it.name}]\n"
        }
        return "Formação: ${nome}\nNível: $nivel\nConteúdos: \n$retornoConteudo\nMatriculados:\n$retornoUsuario"
    }
}

fun main() {
    val backEndComKotlinEJava = Formacao("TQI - backend com Kotlin e Java", mutableListOf(
        ConteudoEducacional("Conhecendo Kotlin e sua documentação", 60),
        ConteudoEducacional("Introdução Prática à Linguagem de Programação Kotlin", 120),
        ConteudoEducacional("Estruturas de Controle de Fluxo e Coleções em Kotlin", 120),
        ConteudoEducacional("Orientação a Objetos e Tipos de Classes na Prática com Kotlin", 120),
        ConteudoEducacional("O Poder das Funções em Kotlin", 120),
        ConteudoEducacional("Tratamento de Exceções em Kotlin", 120),
        ConteudoEducacional("Abstraindo Formações da DIO Usando Orientação a Objetos com Kotlin", 120),
        ), Nivel.INTERMEDIARIO)


    backEndComKotlinEJava.matricular("Ruan Costa")
    backEndComKotlinEJava.matricular("Venilton Falvo")
    backEndComKotlinEJava.matricular("Iglá Generoso")
    backEndComKotlinEJava.matricular("Renan")

    println(backEndComKotlinEJava)

}
