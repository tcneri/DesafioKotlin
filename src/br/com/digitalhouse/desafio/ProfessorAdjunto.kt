package br.com.digitalhouse.desafio


data class ProfessorAdjunto(override var nome: String, override var sobrenome: String, override var tempoDeCasa: Int,
                            override var codigo: Int, var qtdHMonitoria: Int):Professor{

    override fun equals(other: Any?): Boolean {
        return other == codigo
    }
}