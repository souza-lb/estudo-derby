Repare que estou usando o JDK 17.

* Baixe os arquivos deste repositório (conforme a primeira imagem abaixo)
* Vá na pasta que você baixou o arquivo "estudo-derby-main.zip" e extraia usando o descompactador de sua preferência (pode ser o nativo do sistema).
* Abra o seu NetBeans (pode ser o ide java que você quiser)
* Selecione no menu arquivo (File)
* Em seguida abrir projeto (Open Project)
* Selecione a pasta na qual você baixou e fez a extração dos arquivos deste repositório

* Rode o projeto


  Usando o maven você não precisa se preocupar em baixar as dependências manualmente e possíveis conflitos de versões.
  Espero que isso te ajude.

  É um exemplo bem bobo e básico so cria uma tabela insere uns dados de exemplo e lista esses dados (tente dar uma melhorada nele , faça testes..
  Depois aprofunde e busque sobre PreparedStatements (Como evitar SQLInjection)

  Use a opção para baixar o zip do repositório ou use o git clone (se você já souber como usar o git no terminal)
  Observe a imagem abaixo:


  ![Baixar Repositório](baixar.png)

  
  Projeto rodando:

  ![Exemplo Derby](exemplo-derby.png)

  Aqui você pode observar as dependências usadas nesse projeto de exemplo (Viu como fica mais prático).
  Isso evita o trabalho de você ir em cada site baixar dependência por dependência. Tudo fica uniforme e garante que
  funcione em qualquer máquina (basta você ter o Java,o IDE de sua preferência e o Maven). Lembrando que o Maven geralmente vai instalado
  com o seu IDE.

  ![Dependências](dependencias.png)



  Faça testes, clique com o botão direito e remova algumas dependências , quebre o funcionamento do código observe as mensagens de erro.
  Aqui por exemplo eu reproduzi o erro que o professor relatou:

    ![Erro Driver](erro-derby.png)

