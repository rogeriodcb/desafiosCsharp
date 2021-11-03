# Implementações C#

Utilizando o Visual Studio 2019 community edition uma interface simples foi elaborada em C# para demonstrar 5 implementações distintas:

![Main User interface](https://github.com/rogeriodcb/desafiosCsharp/blob/main/additional_files/CSharpHMI.png)

**1) votos em relação ao total de eleitores**

Nesta implemntação apresenta-se a porcentagem dos votos válidos, brancos e nulos com relação ao total de eleitores.


**2) Algoritmo de ordenação Bubble Sort**

Nesta implemntação apresenta-se o algoritmo de ordenação Bubble Sort.

**3) Fatorial**
Nesta implemntação apresenta-se o algoritmo de fatorial utilizando recursividade.

**4) Soma dos multiplos de 3 ou 5**
Nesta implemntação apresenta-se o algoritmo que soma os multiplos de 3 e 5 limitados a um número máximo passados pelo usuário.

**5) Cadastro de veículos**
Nesta implemntação apresenta-se um acesso a uma API Rest de cadastro de veículos. Esta API Rest foi feita em Spring Boot framework em Java.
(em desenvolvimento)


**Nota 1:** Os diretórios neste repositório estão separados da seguinte forma:
- TinovaChallenge: contém todos os códigos em C# incluindo a User Interface principal e as classes para cada desafio. Foi utilizado o Visual Studio 2019 Community edition para desenvolvimento. 
As seguintes classes são chamadas dentro de Form1.cs. As classes foram criadas para cada uma das implementações.

```bash
Vote.cs
BubbleSort.cs
Fatorial.cs
Multiplos.cs
```
- additional_files: contem arquivos para montagem deste documento

- cadastroveiculo: contém a API desenvolvida no framework SpringBoot com códigos em Java.

**Nota 2:** a API ainda não está totalmente concluída. Segue as explicações:
- O método Patch (um update de um determinado campo(s) ao invés de se fazer um update inteiro) não foi implementado.
- Embora o método GET all foi implementado não houve um entendimento do requisito **GET /veiculos/find** - **retorna os veículos de acrodo com o termo passado parâmetro q**. Portanto, os demais GETs não foram implementados.
- Testes unitários não foram feitos (com MOCA, JUNIT ou qualquer outro). Ainda em desenvolvimento.
- Não foi feito a consistÊncia de marcas de carro fornecidas. Pretendia-se acessar uma outra API existente e fazê-la retornar os modelos existentes para comparação na própria User Interface ou até mesmo dentro da API. A API que pretendia-se usar é a https://deividfortuna.github.io/fipe/. Ainda em desenvolvimento.
- Uma interface online Swagger foi disponibilizada quando a API está no ar (http://localhost:8080/swagger-ui.html) para poder testar o cadastro veiculos API.
- A chamada pela User Interface principal também não foi concluída (em desenvolvimento).


