package br.com.digitalhouse.desafio



import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class DigitalHouseManager(var listAlunos: MutableList<Aluno>, var listProfessores: MutableList<Professor>, var listCursos: MutableList<Curso>) {

    var listMatriculas: MutableList<Matricula> = mutableListOf()

    constructor(listAlunos: MutableList<Aluno>, listProfessores: MutableList<Professor>, listCursos: MutableList<Curso>, listaMatriculas: MutableList<Matricula>): this(listAlunos, listProfessores, listCursos){
        listMatriculas = listaMatriculas
    }

//ok
    fun registrarCurso(nome: String, codigoCurso: Int, quantidadeMaxAlunos: Int){
        var curso = Curso(nome, codigoCurso, quantidadeMaxAlunos)
        var retorno = false

        listCursos.forEach() {
            if (it.equals(curso)) {
                println("O curso com código ${it.codigo} já está registrado como ${it.nome} ")
                retorno = true
            }
        }

        if(!retorno){
            listCursos.add(curso)
            println("Curso $nome adicionado com sucesso!")
        }

    }

//ok
    fun excluirCurso(codigoCurso: Int){
        var retorno = false
        lateinit var aux:Curso

        listCursos.forEach() {
            if (it.codigo.equals(codigoCurso)) {
                aux =  it
                println("Curso ${it.nome} ")
                retorno = true
            }
        }

        if(!retorno) println("O curso não consta na lista de cursos cadastrados.")
        else if (retorno){
            listCursos.removeAt(listCursos.indexOf(aux))
            println("Curso excluído com sucesso!")
        }

    }

//ok
    fun registrarProfAdjunto(nome: String, sobrenome: String, codigoProfessor: Int, qtdHMonitoria: Int){
        var profAdj = ProfessorAdjunto(nome, sobrenome, 0,codigoProfessor, qtdHMonitoria)
        var retorno = false


        listProfessores.forEach(){
            if (it.equals(profAdj)){
                println("O professor adjunto com código ${it.codigo} já está registrado como ${it.nome} ${it.sobrenome}!")
                retorno = true
            }
        }

        if(!retorno){
            listProfessores.add(profAdj)
            println("Professor adjunto ${profAdj.nome} ${profAdj.sobrenome} foi adicionado com sucesso!")
        }
    }

//ok
    fun registrarProfTitular(nome: String, sobrenome: String, codigoProfessor: Int, especialidade: String){
        var profTit = ProfessorTitular(nome, sobrenome, 0,codigoProfessor, especialidade)
        var retorno = false

        listProfessores.forEach(){
            if (it.equals(profTit)){
                println("O professor titular com código ${it.codigo} já está registrado como ${it.nome} ${it.sobrenome}!")
                retorno = true
            }
        }

        if(!retorno){
            listProfessores.add(profTit)
            println("Professor titular ${profTit.nome} ${profTit.sobrenome} foi adicionado com sucesso!")
        }
    }

//ok
    fun excluirProfessor(codigoProfessor: Int) {
        var retorno = false
        lateinit var aux: Professor

        listProfessores.forEach() {
            if (it.codigo.equals(codigoProfessor)) {
                aux = it
                println("Professor ${it.nome} ${it.sobrenome} excluído com sucesso!")
                retorno = true
            }
        }

        if (!retorno) println("O professor não consta na lista de professores registrados.")
        else if(retorno){
            listProfessores.removeAt(listProfessores.indexOf(aux))
            println("Professor excluído com sucesso!")
        }

    }

    //ok
    fun registrarAluno(nome: String, sobrenome: String, codigoAluno:Int){
        var aluno = Aluno(nome, sobrenome, codigoAluno)
        var retorno = false

        listAlunos.forEach() {
            if (it.equals(aluno)) {
                println("O aluno com código ${it.codigo} já está registrado como ${it.nome} ${it.sobrenome}")
                retorno = true
            }
        }

        if(!retorno){
            listAlunos.add(aluno)
            println("O aluno ${aluno.nome} ${aluno.sobrenome} foi adicionado com sucesso!")
        }

    }

    //ok
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

    //ok
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