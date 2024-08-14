# Planner API
Visão Geral
A Travel Planner API é uma API RESTful que permite aos usuários organizar viagens de trabalho ou lazer. Os usuários podem criar viagens, definir datas de início e fim, e planejar atividades diárias dentro dessas viagens. A API permite gerenciar todas as informações necessárias para uma viagem organizada e bem planejada.

Funcionalidades Principais
Gerenciamento de Viagens: Criar, visualizar, editar e excluir viagens.
Planejamento de Atividades: Adicionar, visualizar, editar e excluir atividades diárias dentro de uma viagem.
Endpoints
1. Viagens
1.1. Criar uma Nova Viagem
Método: POST

Endpoint: /api/trips

Descrição: Cria uma nova viagem com nome, data de início e fim.

Corpo da Requisição:

json
Copiar código
{
    "name": "Nome da Viagem",
    "start_date": "YYYY-MM-DD",
    "end_date": "YYYY-MM-DD"
}
Exemplo de Requisição:

bash
Copiar código
curl -X POST https://example.com/api/trips \
-H "Content-Type: application/json" \
-d '{
    "name": "Viagem para Nova York",
    "start_date": "2024-08-01",
    "end_date": "2024-08-10"
}'
Resposta:

200 OK: Retorna os detalhes da viagem criada.
400 Bad Request: Retorna um erro se os dados fornecidos forem inválidos.
Exemplo de Resposta:

json
Copiar código
{
    "id": 1,
    "name": "Viagem para Nova York",
    "start_date": "2024-08-01",
    "end_date": "2024-08-10"
}
1.2. Listar Todas as Viagens
Método: GET

Endpoint: /api/trips

Descrição: Retorna uma lista de todas as viagens.

Exemplo de Requisição:

bash
Copiar código
curl -X GET https://example.com/api/trips
Resposta:

200 OK: Retorna a lista de viagens.
Exemplo de Resposta:

json
Copiar código
[
    {
        "id": 1,
        "name": "Viagem para Nova York",
        "start_date": "2024-08-01",
        "end_date": "2024-08-10"
    },
    {
        "id": 2,
        "name": "Viagem para Paris",
        "start_date": "2024-09-15",
        "end_date": "2024-09-22"
    }
]
1.3. Detalhar uma Viagem
Método: GET

Endpoint: /api/trips/{trip_id}

Descrição: Retorna os detalhes de uma viagem específica.

Parâmetros de URL:

trip_id: ID da viagem a ser detalhada.
Exemplo de Requisição:

bash
Copiar código
curl -X GET https://example.com/api/trips/1
Resposta:

200 OK: Retorna os detalhes da viagem.
404 Not Found: Retorna um erro se a viagem não for encontrada.
Exemplo de Resposta:

json
Copiar código
{
    "id": 1,
    "name": "Viagem para Nova York",
    "start_date": "2024-08-01",
    "end_date": "2024-08-10",
    "activities": [
        {
            "id": 1,
            "date": "2024-08-02",
            "description": "Visita à Estátua da Liberdade"
        },
        {
            "id": 2,
            "date": "2024-08-05",
            "description": "Passeio no Central Park"
        }
    ]
}
1.4. Atualizar uma Viagem
Método: PUT

Endpoint: /api/trips/{trip_id}

Descrição: Atualiza os detalhes de uma viagem existente.

Parâmetros de URL:

trip_id: ID da viagem a ser atualizada.
Corpo da Requisição:

json
Copiar código
{
    "name": "Novo Nome da Viagem",
    "start_date": "YYYY-MM-DD",
    "end_date": "YYYY-MM-DD"
}
Exemplo de Requisição:

bash
Copiar código
curl -X PUT https://example.com/api/trips/1 \
-H "Content-Type: application/json" \
-d '{
    "name": "Viagem atualizada para Nova York",
    "start_date": "2024-08-01",
    "end_date": "2024-08-12"
}'
Resposta:

200 OK: Retorna os detalhes atualizados da viagem.
400 Bad Request: Retorna um erro se os dados fornecidos forem inválidos.
404 Not Found: Retorna um erro se a viagem não for encontrada.
1.5. Excluir uma Viagem
Método: DELETE

Endpoint: /api/trips/{trip_id}

Descrição: Exclui uma viagem específica.

Parâmetros de URL:

trip_id: ID da viagem a ser excluída.
Exemplo de Requisição:

bash
Copiar código
curl -X DELETE https://example.com/api/trips/1
Resposta:

204 No Content: Confirma que a viagem foi excluída.
404 Not Found: Retorna um erro se a viagem não for encontrada.
2. Atividades
2.1. Adicionar uma Atividade a uma Viagem
Método: POST

Endpoint: /api/trips/{trip_id}/activities

Descrição: Adiciona uma nova atividade a uma viagem específica.

Parâmetros de URL:

trip_id: ID da viagem onde a atividade será adicionada.
Corpo da Requisição:

json
Copiar código
{
    "date": "YYYY-MM-DD",
    "description": "Descrição da Atividade"
}
Exemplo de Requisição:

bash
Copiar código
curl -X POST https://example.com/api/trips/1/activities \
-H "Content-Type: application/json" \
-d '{
    "date": "2024-08-05",
    "description": "Passeio no Central Park"
}'
Resposta:

201 Created: Retorna os detalhes da atividade criada.
400 Bad Request: Retorna um erro se os dados fornecidos forem inválidos.
404 Not Found: Retorna um erro se a viagem não for encontrada.
2.2. Listar Atividades de uma Viagem
Método: GET

Endpoint: /api/trips/{trip_id}/activities

Descrição: Retorna uma lista de todas as atividades planejadas para uma viagem específica.

Parâmetros de URL:

trip_id: ID da viagem cujas atividades serão listadas.
Exemplo de Requisição:

bash
Copiar código
curl -X GET https://example.com/api/trips/1/activities
Resposta:

200 OK: Retorna a lista de atividades.
404 Not Found: Retorna um erro se a viagem não for encontrada.
2.3. Detalhar uma Atividade
Método: GET

Endpoint: /api/trips/{trip_id}/activities/{activity_id}

Descrição: Retorna os detalhes de uma atividade específica de uma viagem.

Parâmetros de URL:

trip_id: ID da viagem.
activity_id: ID da atividade a ser detalhada.
Exemplo de Requisição:

bash
Copiar código
curl -X GET https://example.com/api/trips/1/activities/1
Resposta:

200 OK: Retorna os detalhes da atividade.
404 Not Found: Retorna um erro se a viagem ou a atividade não forem encontradas.
2.4. Atualizar uma Atividade
Método: PUT

Endpoint: /api/trips/{trip_id}/activities/{activity_id}

Descrição: Atualiza os detalhes de uma atividade específica de uma viagem.

Parâmetros de URL:

trip_id: ID da viagem.
activity_id: ID da atividade a ser atualizada.
