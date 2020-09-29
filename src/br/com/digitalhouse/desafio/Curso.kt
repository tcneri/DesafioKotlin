package br.com.digitalhouse.desafio

 class Curso(var nome: String, var codigo: Int, var qtdMaxAlunos: Int){

    var alunosMatriculados:MutableList<Aluno> = mutableListOf()
    lateinit var pAdjunto:Professor
    lateinit var pfTitular:Professor


    constructor(nome: String, codigoCurso: Int, quantidadeMaxAlunos: Int, pfTitular: Professor,
                pAdjunto: Professor, alunosMatriculados: MutableList<Aluno>) : this(nome, codigoCurso, quantidadeMaxAlunos){

        this.alunosMatriculados = alunosMatriculados
        this.pAdjunto = pAdjunto
        this.pfTitular = pfTitular
    }


    fun adicionarAluno(aluno: Aluno):Boolean{
        if(alunosMatriculados.size < qtdMaxAlunos){
            alunosMatriculados.add(aluno)
            return true
        }

        else return false
    }


    fun excluirAluno(aluno: Aluno){
        if (alunosMatriculados.contains(aluno)){
            alunosMatriculados.remove(aluno)
            println("Aluno excluído do curso com sucesso.")
        }

        else {
            println("Esse aluno não está matriculado no curso.")
        }
    }


    override fun equals(other: Any?): Boolean {
        return other == codigo
    }

}