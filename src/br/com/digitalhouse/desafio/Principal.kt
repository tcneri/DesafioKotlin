package br.com.digitalhouse.desafio

val curso1 = Curso("Full Stack", 20001, 3)
val curso2 = Curso("Android", 20002, 2)
val listC = mutableListOf<Curso>(curso1, curso2)

val aluno1 = Aluno("João", "Silva", 11)
val aluno2 = Aluno("Mario", "Souza", 22)
val aluno3 = Aluno("Maria", "Pereira", 33)
val aluno4 = Aluno("Esmeralda", "Reis", 44)
val aluno5 = Aluno("Luna", "Dantas", 55)

val listA = mutableListOf(aluno1, aluno2, aluno3, aluno4, aluno5)


val pA1 = ProfessorAdjunto("Icaro", "Dacius", 2, 144, 24)
val pA2 = ProfessorAdjunto("Paulo", "Jesus", 1, 244, 8)
val pT1 = ProfessorTitular("Eraldo", "Quinze", 4, 111, "Kotlin")
val pT2 = ProfessorTitular("Julia", "Lima", 8, 211, "Desenvolvimento Web")
val lisTP = mutableListOf(pA1, pA2, pT1, pT2)

val dhm = DigitalHouseManager(listA, lisTP, listC)

fun main(){
//

//    dhm.registrarProfAdjunto("paulo", "Walt", 88, 7)
//    dhm.registrarProfTitular("paulo", "Walt", 111, "js")
//    dhm.excluirProfessor(1111)
//    dhm.registrarAluno("thalita", "neri", 22)

//    curso2.excluirAluno(aluno1)

    var res = 0

    while (res == 0) {
        println("\n")
        println("<---------- MENU ---------->")
        println("Informe a opção que deseja:")
        println("0 - Sair do menu ")
        println("1 - Alocar professores aos cursos")
        println("2 - Matricular alunos ao curso Full Stack")
        println("3 - Matricular alunos ao curso Android")
        println("4 - Registrar curso")
        println("5 - Excluir curso")
        println("6 - Registrar professor adjunto")
        println("7 - Registrar professor titular")
        println("8 - Excluir professor")
        println("9 - Registrar aluno")
        println("\n")

        var opcao = readLine().toString()




        when (opcao) {
            "1" -> exibirAlocAluno()

            "2" -> exibirMatAlunFS()

            "3" -> exibirMatAlunA()

            "4" -> exibirResCur()

            "5" -> exibirExcCur()//erro

            "6" -> exibirResPA()

            "7" -> exibirResPT()

            "8" -> exibirExcPro() //erro

            "9" -> exibirResAlu()


            "0" -> {
                res = 1
                println("Você saiu do menu.")
            }

            else -> println("Opção inválida!")
        }

    }

}

fun exibirAlocAluno(){
    println("<---------------ALOCANDO PROFESSOR ----------------------->")
    dhm.alocarProfessores(20001, 111, 144)
    println("\n")
    println("<---------------ALOCANDO PROFESSOR ----------------------->")
    dhm.alocarProfessores(20002, 211, 244)
}

fun exibirMatAlunFS(){
    println("<---------------MATRICULANDO ALUNO AO CURSO FULL STACK ----------------------->")
    dhm.matricularAluno(11, 20001)
    println("\n")
    println("<---------------MATRICULANDO ALUNO AO CURSO FULL STACK ----------------------->")
    dhm.matricularAluno(22, 20001)
}

fun exibirMatAlunA(){
    println("<---------------MATRICULANDO ALUNO AO CURSO ANDROID ----------------------->")
    dhm.matricularAluno(33, 20002)
    println("\n")
    println("<---------------MATRICULANDO ALUNO AO CURSO ANDROID ----------------------->")
    dhm.matricularAluno(44, 20002)
    println("\n")
    println("<---------------MATRICULANDO ALUNO AO CURSO ANDROID ----------------------->")
    dhm.matricularAluno(55, 20002)
}

fun exibirResCur(){
    println("<---------- REGISTRANDO CURSO ---------->")
    println("Insira o nome: ")
    var nomecurs = readLine().toString()
    println("Insira o código: ")
    var codigocurs = readLine()!!.toInt()
    println("Insira a quantidade máxima de alunos: ")
    var qtdMaxAlunocurs = readLine()!!.toInt()
    dhm.registrarCurso(nomecurs, codigocurs, qtdMaxAlunocurs)
}

fun exibirExcCur(){
    println("<---------- EXCLUINDO CURSO ---------->")
    println("Insira o código do curso que deseja excluir: ")
    var curs = readLine()!!.toInt()
    dhm.excluirCurso(curs)

}

fun exibirResPA(){
    println("<---------- REGISTRANDO PROFESSOR ADJUNTO ---------->")
    println("Insira o nome: ")
    var nomePA = readLine().toString()
    println("Insira o sobrenome: ")
    var sobrenomePA = readLine().toString()
    println("Insira o código: ")
    var codigoPA = readLine()!!.toInt()
    println("Insira a quantidade de horas de monitoria: ")
    var qtdHPA = readLine()!!.toInt()
    dhm.registrarProfAdjunto(nomePA, sobrenomePA, codigoPA, qtdHPA)
}

fun exibirResPT(){
    println("<---------- REGISTRANDO PROFESSOR TITULAR ---------->")
    println("Insira o nome: ")
    var nomePT = readLine().toString()
    println("Insira o sobrenome: ")
    var sobrenomePT = readLine().toString()
    println("Insira o código: ")
    var codigoPT = readLine()!!.toInt()
    println("Insira a especialidade: ")
    var espPT = readLine().toString()
    dhm.registrarProfTitular(nomePT, sobrenomePT, codigoPT, espPT)
}

fun exibirExcPro(){
    println("<---------- EXCLUINDO PROFESSOR ---------->")
    println("Insira o código do professor que deseja excluir: ")
    var codigPT = readLine()!!.toInt()
    with(dhm) {
        excluirProfessor(codigPT)
    }
}

fun exibirResAlu(){
    println("<---------- REGISTRANDO ALUNO ---------->")
    println("Insira o nome: ")
    var nomeAl = readLine().toString()
    println("Insira o sobrenome: ")
    var sobrenomeAl = readLine().toString()
    println("Insira o código: ")
    var codigoAl = readLine()!!.toInt()
    dhm.registrarAluno(nomeAl, sobrenomeAl, codigoAl)
}


