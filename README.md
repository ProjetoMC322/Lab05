# Lab05 - Mundo de Wumpus

## Destaque do código 

As linhas abaixo são consideradas pelo grupo um destaque do código pois exploram o princípio de polimorfismo ao adicionar componentes na sala, por meio deste método sobrescrito podemos adicionar qualquer componente com suas especificidades (e.g. quando se adiciona Wumpus deve-se adicionar fedor, mas o mesmo não se aplica ao adicionar Ouro...) sem passar parâmetros adicionais.

## Recorte do código que achamos interessante:
```java
    //Na classe abstrata Componente
    public void add(Caverna caverna) {
		return ;
	}
    //Na classe Wumpus:
    public void add(Caverna caverna) {
		caverna.associaSala(this, x, y);
		caverna.associaSala(new Fedor(x, y + 1, 'f'), x, y + 1);
		caverna.associaSala(new Fedor(x, y - 1, 'f'), x, y - 1);
		caverna.associaSala(new Fedor(x + 1, y, 'f'), x + 1, y);
		caverna.associaSala(new Fedor(x - 1, y, 'f'), x - 1, y);
	}
```
Estrutura de pastas:

~~~
├── README.md  <- arquivo apresentando a tarefa
│
└── src <- pasta de arquivos fonte Java (.java)
|   │
|   └── pt <- raiz do seu pacote
|       │
|       └── c40task
|           │
|           └── l05wumpus <- arquivos fonte .java (feitos no eclipse ou equivalente)
│
└── bin <- pasta de arquivos binários Java (.class)
    │
    └── pt <- raiz do seu pacote
        │
        └── c40task
|           │
|           └── l05wumpus <- arquivos binários .class
~~~

## Arquivos Java sobre "O Mundo de Wumpus"

> [Pasta onde estão os arquivos java da resolução da tarefa.](src/pt/c40task/l05wumpus)