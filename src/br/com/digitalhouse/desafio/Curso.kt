package br.com.digitalhouse.desafio

 class Curso(var nome: String, var codigo: Int, var qtdMaxAlunos: Int){

    var alunosMatriculados:MutableList<Aluno> = mutableListOf()
    lateinit var pAdjunto:Professor
    lateinit var pfTitular:Professor


    constructor(nome: String, codigoCurso: Int, quantidadeMaxAlunos: Int, pfTitular: ProfessorTitular,
                pAdjunto: ProfessorAdjunto, alunosMatriculados: MutableList<Aluno>) : this(nome, codigoCurso, quantidadeMaxAlunos){

        this.alunosMatriculados = alunosMatriculados
        this.pAdjunto = pAdjunto
        this.pfTitular = pfTitular
    }

//ok
    fun adicionarAluno(aluno: Aluno):Boolean{
        if(alunosMatriculados.size < qtdMaxAlunos){
            alunosMatriculados.add(aluno)
            return true
        }

        else return false
    }

 //ok
    fun excluirAluno(aluno: Aluno){
        var retorno = false
        lateinit var aux:Aluno

        alunosMatriculados.forEach() {
            if (it.equals(aluno)) {
                aux = it
                println("O aluno ${it.nome} ${it.sobrenome} com código ${it.codigo}.")
                retorno = true
            }
        }

        if (!retorno) println("O aluno ${aluno.nome} ${aluno.sobrenome} não está matriculado no curso.")
        else if(retorno){
            alunosMatriculados.removeAt(alunosMatriculados.indexOf(aux))
            println("O aluno foi excluído com sucesso!")
        }
    }


    override fun equals(other: Any?): Boolean {
        return other == codigo
    }

}