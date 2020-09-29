package br.com.digitalhouse.desafio



import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class DigitalHouseManager(var listAlunos: MutableList<Aluno>, var listProfessores: MutableList<Professor>, var listCursos: MutableList<Curso>) {

    var listMatriculas: MutableList<Matricula> = mutableListOf()

    constructor(listAlunos: MutableList<Aluno>, listProfessores: MutableList<Professor>, listCursos: MutableList<Curso>, listaMatriculas: MutableList<Matricula>): this(listAlunos, listProfessores, listCursos){
        listMatriculas = listaMatriculas
    }


    fun registrarCurso(nome: String, codigoCurso: Int, quantidadeMaxAlunos: Int){
        var curso = Curso(nome, codigoCurso, quantidadeMaxAlunos)
        if (listCursos.contains(codigoCurso)){
            println("O curso já está registrado")
        }
        else{
            listCursos.add(curso)
            println("Curso $nome adicionado com sucesso!")
        }

    }


    fun excluirCurso(codigoCurso: Int){
        if (listCursos.contains(codigoCurso)){
            listCursos.removeAt(listCursos.indexOf(codigoCurso))
            println("Curso excluído com sucesso!")
        }

        else{
            println("O curso não consta na lista de cursos cadastrados.")
        }
    }


    fun registrarProfAdjunto(nome: String, sobrenome: String, codigoProfessor: Int, qtdHMonitoria: Int){
        var profAdj = ProfessorAdjunto(nome, sobrenome, 0,codigoProfessor, qtdHMonitoria)
        if (listProfessores.contains(codigoProfessor)){
            println("O professor já está registrado!")
        }
        else{
            listProfessores.add(profAdj)
            println("Professor adjunto adicionado com sucesso!")
        }
    }


    fun registrarProfTitular(nome: String, sobrenome: String, codigoProfessor: Int, especialidade: String){
        var profTit = ProfessorTitular(nome, sobrenome, 0,codigoProfessor, especialidade)
        if (listProfessores.contains(codigoProfessor)){
            println("O professor já está registrado!")
        }
        else{
            listProfessores.add(profTit)
            println("Professor titular adicionado com sucesso!")
        }
    }


    fun excluirProfessor(codigoProfessor: Int){
        if (listProfessores.contains(codigoProfessor)){
            listProfessores.removeAt(listProfessores.indexOf(codigoProfessor))
            println("Professor excluído com sucesso!")
        }

        else{
            println("O Professor não consta na lista de professores cadastrados.")
        }
    }


    fun registrarAluno(nome: String, sobrenome: String, codigoAluno:Int){
        var aluno = Aluno(nome, sobrenome, codigoAluno)
        if (listAlunos.contains(aluno)){
            println("O aluno já está consta na lista de alunos.")
        }

        else{
            listAlunos.add(aluno)
            println("Aluno cadastrado com sucesso!")
        }
    }


    fun matricularAluno(codigoAluno: Int, codigoCurso: Int){
        lateinit var cursoAux: Curso
        lateinit var alunoAux: Aluno

        listCursos.forEach(){
            when(it.codigo){
                codigoCurso -> {
                    println("O aluno está se matriculando no curso ${it.nome}")
                    cursoAux = it
                }
            }

        }

        listAlunos.forEach(){
            when(it.codigo){
                codigoAluno -> {
                    println("Estamos matriculando o aluno ${it.nome} ${it.sobrenome}")
                    alunoAux = it
                }
            }
        }

        if (cursoAux.adicionarAluno(alunoAux)){

            val now =  LocalDateTime.now()
            val formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy")
            val dataFormatada = now.format(formatacao)

            val matriculaAux =  Matricula(alunoAux,cursoAux, dataFormatada)
            listMatriculas.add(matriculaAux)
            println("Matricula realizada com sucesso na data $dataFormatada!")
        }

        else{
            println("Não foi possível realizar a matrícula pois não há vagas!")
        }

    }


    fun alocarProfessores(codigoCurso: Int, codigoPTit: Int, codigoPAdj: Int){
        lateinit var profTitAux: Professor
        lateinit var profAdjAux: Professor
        var cursoAux: Curso

        listProfessores.forEach(){
            when(it.codigo){
                codigoPTit -> {
                    println("Professor titular ${it.nome} ${it.sobrenome}")
                    profTitAux = it
                }

                codigoPAdj -> {
                    println("Professor ajdunto ${it.nome} ${it.sobrenome}")
                    profAdjAux = it
                }
            }
        }

        listCursos.forEach(){
            when(it.codigo){
                codigoCurso ->{
                    it.pAdjunto = profAdjAux
                    it.pfTitular = profTitAux
                    println("Os professores ${profAdjAux.nome} ${profAdjAux.sobrenome} e ${profTitAux.nome} ${profTitAux.sobrenome} foram alocados ao curso ${it.nome}")
                }
            }
        }
    }


}