* "TAREFA: API CRUD de clientes - Infelizmente seu trabalho nao foi aceito, verifique que o método para atualizar um cliente não está funcionando 
* de forma adequada além do delete que está com o retorno incorreto!"

# SOBRE O METODO UPDATE:
  eu tentei economizar metodos criando um contrutor na entidade recebendo um dto
  mas não percebi que isto criava uma nova instancia do objeto perdendo a referencia
  ao objeto do banco de dados.

  percebi tambem que só poderia atualizar um registro passando todas as informações
  mesmo que precisasse atualizar apenas uma. sendo assim, no metodo responsavel por 
  copiar as informações do DTO para a entidade a ser salva, eu fiz com que testasse 
  a informação antes de copiá-la, e prosseguisse apenas caso a informação do DTO não
  fosse nula, e assim, não preciso mais passar todas as informações na hora de 
  atualizar, apenas a que quero atualizar. espero que isso esteja correto.
              CORRIGIDO ✅

# SOBRE O METODO DELETE:
  mesmo após analisar com muita atenção, não consegui detectar qual foi o erro :(
  na camada de recurso o metodo retorna ResponseEntity<Void> como deve ser..
  na camada de serviço o metodo não retorna nada como deve ser também..
  testei o metodo sem TryCatch e ele não lançou nenhuma excessão ao tentar deletar
  um recurso que não existe, entao creio que não há problemas no tratamento de 
  excessão, também assisti a aula novamente de deleção de registros e comparei com 
  o metodo da classe Product, está igual, o erro passou despercebido por min e eu
  não consigo detectá-lo :(
              NÃO SOLUCIONADO ❌

  
  sei que o projeto não pode ser aceito, mas nesse caso, admito que preciso de um esclarecimento do erro ou que me aponte o local onde o mesmo ocorre, 
  pq mesmo pesquisando sendo um erro simples, não faço ideia de onde estou errando
