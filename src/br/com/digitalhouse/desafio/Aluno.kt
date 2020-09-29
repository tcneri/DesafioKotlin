package br.com.digitalhouse.desafio

class Aluno (var nome: String, var sobrenome: String, var codigo: Int) {

    override fun equals(other: Any?): Boolean {
        return other == codigo
    }
}