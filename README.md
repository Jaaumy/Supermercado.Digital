# Supermercado Digital

## Descrição do Projeto

O "Supermercado Digital" é uma aplicação de console desenvolvida em Java que simula as operações básicas de um sistema de supermercado. O projeto foi criado com o objetivo de aplicar e demonstrar conceitos fundamentais de Programação Orientada a Objetos (POO), como herança, encapsulamento e polimorfismo.

Usuários podem navegar por diferentes categorias de produtos, adicionar itens a um carrinho de compras, visualizar e modificar o carrinho, gerenciar o estoque de produtos e, finalmente, simular a finalização de uma compra, com a respectiva baixa no estoque.

## Funcionalidades Principais

*   **Navegação por Categorias:** Produtos organizados e acessíveis através de menus de categorias específicas (ex: Hortifruti, Frios, Bebidas, Eletrônicos).
*   **Gerenciamento de Produtos:**
    *   Classe base `Produto` com atributos comuns (ID, nome, preço, quantidade em estoque).
    *   Classes especializadas para cada categoria (`Hortifruti`, `Frios`, etc.) que herdam de `Produto` e adicionam atributos específicos.
    *   Geração automática de ID único para cada produto.
*   **Carrinho de Compras (`Carrinho.java`):**
    *   Adicionar produtos com quantidade desejada.
    *   Verificar disponibilidade de estoque antes de adicionar ao carrinho.
    *   Atualizar a quantidade de um item específico no carrinho.
    *   Remover unidades ou um item por completo do carrinho.
    *   Visualizar todos os itens no carrinho, com subtotal por item e valor total da compra.
    *   Limpar o carrinho.
*   **Finalização de Compra:**
    *   Simula o processo de compra.
    *   Realiza a baixa automática dos itens comprados no estoque global.
*   **Gerenciamento de Estoque (`MenuEstoque.java`):**
    *   Interface administrativa para listar todos os produtos e seus respectivos estoques.
    *   Adicionar unidades ao estoque de um produto específico (identificado por ID).
    *   Remover unidades do estoque de um produto específico.
*   **Interface de Usuário:** Interação via console com menus numerados e entrada de dados pelo teclado.

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

*   **`Main.java`**: Classe principal que contém o método `main`, controla o fluxo da aplicação e a interação com o usuário através do menu principal.
*   **Pacote `Produtos/`**:
    *   `Produto.java`: Superclasse que define a estrutura e comportamentos básicos de um produto (ex: gerenciamento de seu próprio estoque com `aumentarEstoque` e `reduzirEstoque`).
    *   `Hortifruti.java`, `Frios.java`, `Bebidas.java`, `Carnes.java`, `Automobilismo.java`, `Esporte.java`, `Eletronicos.java`: Classes que herdam de `Produto` e representam categorias específicas, adicionando atributos particulares.
*   **Pacote `Menus/`**:
    *   `Menu<NomeDaCategoria>.java` (ex: `MenuHortifruti.java`, `MenuFrios.java`): Classes responsáveis por apresentar os produtos de uma categoria específica e permitir a seleção pelo usuário.
    *   `MenuEstoque.java`: Classe que fornece a interface para o usuário administrador gerenciar o estoque de todos os produtos do sistema.
*   **`Carrinho.java`**: Classe responsável por todas as funcionalidades do carrinho de compras, incluindo a adição de itens, cálculo de totais e a lógica de finalização da compra com a respectiva baixa no estoque.

## Como Compilar e Executar

### Pré-requisitos

*   Java Development Kit (JDK) instalado (versão 8 ou superior recomendada).

### Compilação

1.  Navegue até o diretório raiz do projeto onde o arquivo `Main.java` e as pastas dos pacotes (`Produtos`, `Menus`) estão localizados.
2.  Compile os arquivos Java. Se estiver na raiz e os pacotes estiverem corretamente estruturados, você pode compilar o `Main.java` que, por sua vez, compilará as dependências:
    ```bash
    javac Main.java Produtos/*.java Menus/*.java
    ```
    Ou, de forma mais abrangente, se todos os `.java` estiverem na estrutura de pacotes correta a partir de um diretório `src` (por exemplo):
    ```bash
    javac src/Main.java src/Produtos/*.java src/Menus/*.java src/Carrinho.java -d out
    ```
    (Ajuste os caminhos conforme a sua estrutura exata. O primeiro comando é mais simples se você estiver na pasta que contém `Main.java` e as subpastas `Produtos` e `Menus`).

### Execução

1.  Após a compilação bem-sucedida (assumindo que os arquivos `.class` estão na mesma estrutura dos `.java` ou em um diretório de saída como `out`), execute a classe principal:
    ```bash
    java Main
    ```
    Se você usou a opção `-d out` na compilação:
    ```bash
    java -cp out Main
    ```

## Tecnologias Utilizadas

*   **Java Standard Edition (Java SE)**

## Conceitos de POO Demonstrados

*   **Herança:** A classe `Produto` serve como superclasse para diversas categorias de produtos (`Hortifruti`, `Frios`, etc.), que herdam seus atributos e métodos.
*   **Encapsulamento:** Atributos das classes são majoritariamente privados ou protegidos, com acesso controlado por métodos públicos (getters/setters). A lógica de manipulação de estoque, por exemplo, está encapsulada dentro da própria classe `Produto`.
*   **Polimorfismo:** Principalmente através da sobrescrita do método `toString()` nas classes de produto para fornecer representações textuais específicas de cada categoria.

