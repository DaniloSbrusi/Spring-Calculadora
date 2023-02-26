# Calculadora

Um pequeno projeto Spring REST para cálculos matemáticos básicos

## Métodos disponíveis:
- Soma
- Subtração
- Multiplicação
- Divisão
- Média
- Potenciação
- Raiz Quadrada

Há suporte de dois recursos para cada operação, onde os valores podem ser informados de forma diferente:
- como Parâmetros de consulta (Request Param)
- como Parâmetros de caminho (Path Variable)

## Como testar?
1. Faça um git clone desse repositório
2. Execute o projeto
3. Faça requisições para a URL "http://localhost:8080/api/calculadora/" seguida do nome do recurso e os parâmetros

### Exemplos de URI
> "http://localhost:8080/api/calculadora/somar?num1=2&num2=4,3"
> "http://localhost:8080/api/calculadora/somar/10,8/58"
> "http://localhost:8080/api/calculadora/potenciacao?num1=12&num2=3"
> "http://localhost:8080/api/calculadora/raiz-quadrada/16"

Alguns erros frequentes foram tratados como:
- Separador decimal vírgula/ponto
- Divisão por zero
- Raiz quadrada negativa
