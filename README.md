# sicredi



# Tarefa Bônus 4 
- Versionamento da API
○ Como você versionaria a API da sua aplicação? Que estratégia usar?

Para cada funcionalidade é criada um branch feature/0.0.1.
Uma vez que a funcionalidade é validada nos ambientes de Desenvolvimento e integração, 
é feito um merge de feature/0.0.1 sobre branch develop, removendo logo apos a branch feature/0.0.1

Uma vez que develop contenha todas as funcionalidades de um delivery, a branch release/feature_1_2_3 deve ser criada a partir de develop.
No momento em que a branch release/feature_1_2_3 estiver corretamente implantada em produção, um merge de release/feature_1_2_3 na branch master, removendo logo após o branch release/feature_1_2_3.

<img src='https://1.bp.blogspot.com/-KOhx1uXwz-8/XwJUSj1qZ4I/AAAAAAAAJHE/hxQC-VWYvXIpu2naeL24LnKyNPfNcpGLwCLcBGAsYHQ/s1600/Screen%2BShot%2B2020-07-05%2Bat%2B19.28.47.png'/>
