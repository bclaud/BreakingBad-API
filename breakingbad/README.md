## Breaking Bad API

**Endpoints**

GET em /api/v1/characters: Retorna em lista todos os personagens de Breaking Bad

GET em /api/v1/characters/{id}: Retorna o personagem do respectivo ID

POST em /api/v1/favorites/{id}: favorita o personagem do respectivo ID

PATCH em /api/v1/favorites: aceita formatado JSON com os atributos id(int) e favorite(boolean)

GET em /api/v1/favorites: retorna todos os favoritos

GET em /api/v1/favorites/{id}: retorna o personagem favorito do respectivo ID

