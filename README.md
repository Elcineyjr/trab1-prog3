# trab1-prog3
Primeiro trabalho pratico da discioplina Programação 3

Classes de erros:
--------------------------------Erros que retornam "C�digo repetido para <objeto>: <c�digo>."----------------------------------------

O mesmo c�digo foi usado para dois
docentes diferentes.
C�digo repetido para <objeto>: <c�digo>.

A mesma matr�cula foi usada para dois
discentes diferentes.
C�digo repetido para <objeto>: <c�digo>.

O mesmo c�digo de curso foi usado para
dois cursos diferentes.
C�digo repetido para <objeto>: <c�digo>.

O mesmo c�digo de disciplina foi usado
para duas disciplinas diferentes.
C�digo repetido para <objeto>: <c�digo>.

-------------------------------Outros erros retornam mensagens espec�ficas, ou seja, n�o d� para generalizar------------------------
DocenteDisciplinaInvalidCodeException
O c�digo de docente em disciplina refere-se
a um c�digo inv�lido.
C�digo de docente inv�lido na disciplina
"<nome>": <c�digo>.


DocenteOrientacaoInvalidCodeException
O c�digo de docente em orienta��o refere-se
a um c�digo inv�lido.
C�digo de docente inv�lido na orienta��o
do aluno "<nome>": <c�digo>.


DocenteProducaoInvalidCodeException
O c�digo do docente em publica��o
cient�fica refere-se a um c�digo inv�lido.
C�digo de docente inv�lido na publica��o
"<titulo>": <c�digo>.


CursoOrientacaoInvalidCodeException
O c�digo do curso em orienta��o refere-se
a um c�digo inv�lido.
C�digo de curso inv�lido na orienta��o do
aluno "<nome>": <c�digo>.

CursoDisciplinaInvalidCodeException
O c�digo do curso em disciplina refere-se a
um c�digo inv�lido.
C�digo de curso inv�lido na disciplina
"<nome>": <c�digo>.

CourseLevelException
Um curso n�o foi marcado nem como
gradua��o nem como p�s-gradua��o, ou foi
marcado como ambos.
Inconsist�ncia ao definir o n�vel do curso:
<c�digo> - <nome>.

InvalidFutureDateException
A data de ingresso de um discente em um
programa de p�s-gradua��o est� no futuro.
Data de ingresso do aluno "<nome>" est�
no futuro: <data (DD/MM/AAAA)>.



