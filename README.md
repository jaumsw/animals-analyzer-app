## 🐾 Animal Analyzer CLI Application

### 📋 Descrição

O **Animal Analyzer** é um aplicativo de linha de comando (CLI) desenvolvido em Java que permite analisar uma árvore de animais a partir de um arquivo JSON. O aplicativo aceita argumentos para definir a profundidade da árvore, a frase a ser analisada e um modo verbose para exibir tempos de execução.

### 🚀 Como Iniciar

#### Pré-requisitos

- Java 18+
- Maven

#### Passos para Compilar e Executar

1. **Clone o repositório:**
   ```sh
   git clone https://github.com/jaumsw/animals-analyzer-app.git
   cd animals-analyzer-app
   ```

2. **Compile o projeto usando Maven:**
   ```sh
   mvn clean package
   ```

3. **Execute o aplicativo:**
   ```sh
   java -jar target/cli.jar analyze --depth <n> "<frase>" --verbose
   ```

### 🔧 Principais Funcionalidades

- **Carregar Árvore de Animais:** Carrega uma árvore de animais a partir de um arquivo JSON.
- **Analisar Frase:** Analisa uma frase fornecida para encontrar animais e seus pais até uma profundidade especificada.
- **Modo Verbose:** Exibe tempos de execução para carregamento de parâmetros e verificação da frase.

### 📂 Estrutura do Projeto

- `src/main/java/animal_analyzer/CLIApp.java`: Classe principal do aplicativo CLI.
- `src/main/java/animal_analyzer/AnimalTree.java`: Classe que representa a árvore de animais.
- `src/main/java/animal_analyzer/Animal.java`: Classe que representa um animal na árvore.
- `src/main/dicts/animals.json`: Arquivo JSON contendo a estrutura da árvore de animais.
- `src/test/java/AnimalTreeTest.java`: Testes unitários para a classe `AnimalTree`.
- `src/test/java/CliAppTest.java`: Testes unitários para a classe `CLIApp`.

### 🧪 Testes

Para executar os testes, utilize o comando:
```sh
mvn test
```

### 📜 Licença

Este projeto está licenciado sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

### 👥 Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests.

**Divirta-se analisando animais!** 🦁🐯🐵🦅
