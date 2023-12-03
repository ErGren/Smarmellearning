# DLC Pokémon AO e Pokémon DAJE

## Obiettivi
A partire da uno dei due giochi sviluppati precedentemente, realizzare un'applicazione che non disponga di funzioni di scambio ma esponga tramite API REST una serie di funzionalità.  
In particolare si è interessati alla realizzazione di operazioni CRUD rispetto alle entità presenti nel database.  
Il dominio è invariato rispetto alle due applicazioni di partenza.

## Requisiti
L'applicazione da realizzare è costituita da front-end e back-end, eseguiti e sviluppati in modo indipendente tra loro.  
È inoltre richiesto un database analogo a quello dell'esercizio precedente.  
Il database deve essere accessibile dall'esterno anche tramite strumenti di sviluppo (es.: DataGrip).  
Deve essere inoltre fornito di due utenze, una con permessi completi e una di sola lettura.

### Operazioni
È richiesto che il sistema esponga le seguenti operazioni (back-end) e sia in grado di essere interrogato in merito dall'utente (front-end).  

- **inserimento** di un nuovo Pokémon
- **inserimento** di una nuova mossa
- **modifica** di un Pokémon presente
- **modifica** di una mossa presente
- **cancellazione** di un Pokémon presente
- **cancellazione** di una mossa presente

### Front-end
Realizzare la UI tramite una SPA con le medesime caratteristiche delle applicazioni di partenza, al netto delle funzionalità di scambio.  
È richiesto l'utilizzo delle seguenti tecnologie:
- TypeScript
- React
- SCSS

### Back-end
I requisiti in merito a questo componente non hanno subito variazioni rispetto alle applicazioni di partenza.  

## Deploy
È richiesto che database, front-end e back-end siano rilasciati in tre container Docker, tramite opportuni script docker-compose per avviare:
- solo database
- database e back-end
- solo front-end
- intero sistema