package br.com.digitalhouse.desafio



fun main(){

    val curso1 = Curso("Full Stack",20001, 3)
    val curso2 = Curso("Android",20002, 2)
    val listC = mutableListOf<Curso>(curso1,curso2)

    val aluno1 = Aluno("João", "Silva", 11)
    val aluno2 = Aluno("Mario", "Souza", 22)
    val aluno3 = Aluno("Maria", "Pereira", 33)
    val aluno4 = Aluno("Esmeralda", "Reis", 44)
    val aluno5 = Aluno("Luna", "Dantas", 55)

    val listA = mutableListOf(aluno1, aluno2,aluno3,aluno4,aluno5)


    val pA1 = ProfessorAdjunto("Icaro", "Dacius", 2, 144,24)
    val pA2 = ProfessorAdjunto("Paulo", "Jesus", 1, 244,8)
    val pT1 = ProfessorTitular("Eraldo", "Quinze", 4,111, "Kotlin")
    val pT2 = ProfessorTitular("Julia", "Lima", 8,211, "Desenvolvimento Web")
    val lisTP = mutableListOf(pA1,pA2,pT1,pT2)




//    val matricula = Matricula(aluno1,curso, "22/01/2020")


    val dhm = DigitalHouseManager(listA,lisTP,listC)

    println("<---------------ALOCANDO PROFESSOR----------------------->")
    dhm.alocarProfessores(20001,111,144)
    println("\n")
    println("<---------------ALOCANDO PROFESSOR----------------------->")
    dhm.alocarProfessores(20002,211,244)

    println("\n")
    println("<---------------MATRICULANDO ALUNO----------------------->")
    dhm.matricularAluno(11,20001)
    println("\n")
    println("<---------------MATRICULANDO ALUNO----------------------->")
    dhm.matricularAluno(22,20001)
    println("\n")
    println("<---------------MATRICULANDO ALUNO----------------------->")
    dhm.matricularAluno(33,20002)
    println("\n")
    println("<---------------MATRICULANDO ALUNO----------------------->")
    dhm.matricularAluno(44,20002)
    println("\n")
    println("<---------------MATRICULANDO ALUNO----------------------->")
    dhm.matricularAluno(55,20002)


}