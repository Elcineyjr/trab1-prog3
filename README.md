# trab1-prog3
Primeiro trabalho pratico da discioplina ProgramaÃ§Ã£o 3

Classes de erros:
--------------------------------Erros que retornam "Código repetido para <objeto>: <código>."----------------------------------------

O mesmo código foi usado para dois
docentes diferentes.
Código repetido para <objeto>: <código>.

A mesma matrícula foi usada para dois
discentes diferentes.
Código repetido para <objeto>: <código>.

O mesmo código de curso foi usado para
dois cursos diferentes.
Código repetido para <objeto>: <código>.

O mesmo código de disciplina foi usado
para duas disciplinas diferentes.
Código repetido para <objeto>: <código>.

-------------------------------Outros erros retornam mensagens específicas, ou seja, não dá para generalizar------------------------
DocenteDisciplinaInvalidCodeException
O código de docente em disciplina refere-se
a um código inválido.
Código de docente inválido na disciplina
"<nome>": <código>.


DocenteOrientacaoInvalidCodeException
O código de docente em orientação refere-se
a um código inválido.
Código de docente inválido na orientação
do aluno "<nome>": <código>.


DocenteProducaoInvalidCodeException
O código do docente em publicação
científica refere-se a um código inválido.
Código de docente inválido na publicação
"<titulo>": <código>.


CursoOrientacaoInvalidCodeException
O código do curso em orientação refere-se
a um código inválido.
Código de curso inválido na orientação do
aluno "<nome>": <código>.

CursoDisciplinaInvalidCodeException
O código do curso em disciplina refere-se a
um código inválido.
Código de curso inválido na disciplina
"<nome>": <código>.

CourseLevelException
Um curso não foi marcado nem como
graduação nem como pós-graduação, ou foi
marcado como ambos.
Inconsistência ao definir o nível do curso:
<código> - <nome>.

InvalidFutureDateException
A data de ingresso de um discente em um
programa de pós-graduação está no futuro.
Data de ingresso do aluno "<nome>" está
no futuro: <data (DD/MM/AAAA)>.



