package br.com.digitalhouse.desafio

data class ProfessorTitular(override var nome: String, override var sobrenome: String, override var tempoDeCasa: Int,
                            override var codigo: Int, var especialidade: String): Professor{

    override fun equals(other: Any?): Boolean {
        return other == codigo
    }
}