# FastTripPlanner

O FastTripPlanner é um aplicativo Android simples para planejamento de viagens.
A ideia do app é permitir que o usuário informe alguns dados básicos da viagem, escolha opções adicionais e visualize um resumo com o custo total estimado.

O projeto foi desenvolvido em Kotlin utilizando Jetpack Compose para a construção das telas.

## Objetivo do projeto

O objetivo principal deste projeto é praticar conceitos básicos de desenvolvimento mobile em Android, como:

- criação de múltiplas telas;
- navegação entre telas usando Intents explícitas;
- passagem de dados entre Activities;
- criação de interfaces com Jetpack Compose;
- controle de estado dos componentes;
- validação de dados informados pelo usuário;
- preservação de dados ao rotacionar a tela;
- organização simples do código.

## Funcionalidades

O aplicativo possui três telas principais.

### Tela 1 — Dados da Viagem

Nesta tela, o usuário informa os dados iniciais da viagem:

- destino;
- quantidade de dias;
- orçamento diário.

Também são feitas validações para evitar que o usuário avance com campos inválidos ou vazios.

Após preencher os dados corretamente, o usuário pode avançar para a próxima tela.

### Tela 2 — Opções da Viagem

Nesta tela, o usuário escolhe as opções adicionais da viagem.

As opções de hospedagem são:

- econômica;
- conforto;
- luxo.

Também é possível selecionar serviços adicionais:

- transporte;
- alimentação;
- passeios.

A escolha do tipo de hospedagem é feita com RadioButton, pois apenas uma opção pode ser selecionada.
Já os serviços adicionais são feitos com Checkbox, pois o usuário pode selecionar mais de uma opção.

A tela também possui o botão de voltar e o botão de calcular.

### Tela 3 — Resumo da Viagem

A terceira tela exibe o resumo completo da viagem, incluindo:

- destino;
- número de dias;
- orçamento diário;
- tipo de hospedagem selecionado;
- serviços adicionais escolhidos;
- custo total da viagem.

Também existe um botão para voltar e outro para finalizar o planejamento, retornando para a primeira tela.

## Regras de cálculo

O cálculo do custo total da viagem segue a seguinte lógica:

```text
custoBase = dias * orçamentoDiário
```

Depois disso, é aplicado um multiplicador de acordo com o tipo de hospedagem:

```text
Econômica: 1.0
Conforto: 1.5
Luxo: 2.2
```

Além disso, são somados os custos extras conforme os serviços selecionados:

```text
Transporte: + R$ 300,00
Alimentação: + R$ 50,00 por dia
Passeios: + R$ 120,00 por dia
```

Exemplo:

```text
Destino: Rio de Janeiro
Dias: 5
Orçamento diário: R$ 100,00
Hospedagem: Conforto
Alimentação: Sim
Transporte: Sim
Passeios: Não

Custo base = 5 * 100 = 500
Hospedagem conforto = 500 * 1.5 = 750
Transporte = 300
Alimentação = 50 * 5 = 250

Total = 750 + 300 + 250 = R$ 1.300,00
```

## Tecnologias utilizadas

- Kotlin
- Android Studio
- Jetpack Compose
- Activities
- Intents explícitas
- Material 3

## Estrutura do projeto

A estrutura foi organizada separando as responsabilidades principais do app.

```text
fasttripplanner
│
├── activities
│   ├── TripOptionsActivity.kt
│   └── TripSummaryActivity.kt
│
├── screens
│   ├── FastTripPlannerApp.kt
│   ├── TripOptionsScreen.kt
│   └── TripSummaryScreen.kt
│
├── domain
│   ├── HostingType.kt
│   └── TripIntentKeys.kt
│
├── utils
│   ├── CostCalculator.kt
│   ├── DoubleUtils.kt
│   └── TripFormValidator.kt
│
└── MainActivity.kt
```

## Organização das telas

O projeto separa as Activities das telas feitas em Compose.

As Activities são responsáveis por controlar a navegação, receber dados via Intent e abrir outras telas.

As Screens são funções Composable responsáveis por montar a interface visual de cada tela.

Essa separação ajuda a deixar o código mais organizado, pois a interface não fica misturada diretamente com a lógica de navegação.

## Navegação entre telas

A navegação foi feita usando Intents explícitas.

A primeira tela envia os dados da viagem para a segunda tela.
A segunda tela recebe esses dados, adiciona as opções selecionadas pelo usuário e envia tudo para a terceira tela.

Para evitar erros com nomes de chaves, as constantes usadas nas Intents foram centralizadas na classe `TripIntentKeys`.

## Preservação de estado

Os campos e opções selecionadas utilizam `rememberSaveable`, permitindo que os dados sejam preservados quando a tela é rotacionada.

Isso evita que o usuário perca as informações já digitadas ou selecionadas ao mudar a orientação do celular.

## Validação dos dados

A primeira tela valida os dados antes de permitir a navegação.

As validações incluem:

- destino obrigatório;
- número de dias maior que zero;
- orçamento diário maior que zero;
- tratamento de valores decimais com ponto ou vírgula.

As validações foram separadas em uma classe própria para evitar deixar muita regra diretamente dentro da tela.

## Como executar o projeto

Para executar o projeto:

1. Abra o Android Studio.
2. Selecione a opção para abrir um projeto existente.
3. Escolha a pasta do projeto FastTripPlanner.
4. Aguarde o Gradle sincronizar as dependências.
5. Execute o app em um emulador ou dispositivo físico com Android 8.0 ou superior.

## Compatibilidade

O projeto foi desenvolvido considerando compatibilidade com Android 8.0 ou superior.

## Observações finais

Este projeto foi desenvolvido como exercício prático de desenvolvimento mobile.
O foco foi aplicar os conceitos principais da disciplina de forma simples, organizada e funcional.

Durante o desenvolvimento, foram usados componentes básicos de interface, controle de estado com Compose e navegação entre Activities usando Intents explícitas.
