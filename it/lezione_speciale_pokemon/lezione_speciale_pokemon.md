# Lezione speciale: Pokémon AO e Pokémon DAJE

![Screenshot of a comment on a GitHub issue showing an image, added in the Markdown, of an Octocat smiling and raising a tentacle.](./asset/logo_lezione_pokemon.png)

## Obiettivi
Sviluppare un semplice gioco a tema Pokémon, dotato di DB, front-end web e back-end con API REST, sia proprie esposte che invocate verso sistemi esterni.

## Svolgimento:
I partecipanti saranno divisi in due squadre, il più possibile bilanciate.  
Ogni squadra, dopo aver letto nella sua interezza i requisiti, eleggerà un proprio capitano e avrà due settimane lavorative (80 ore distribuite in 10 giorni) per completare lo sviluppo del sistema in oggetto.  
Il capitano, oltre a svolgere il suo compito da sviluppatore con i suoi task, ha in aggiunta le seguenti mansioni:
- creare una repository GitHub per il suo team
- interfacciarsi col cliente per delucidazioni sui requisiti
- discutere e assegnare i ruoli ai vari membri del team (sviluppo front-end, back-end, DB, API ecc.)
- individuare, con la collaborazione del team, le attività da svolgere e creare le relative issue su GitHub, assegnandole ai relativi sviluppatori designati

Al termine della sfida si svolgerà un'esposizione del codice con demo live, in cui TUTTI i membri del team che sta presentando dovranno esporre le parti su cui hanno lavorato.  
Infine, sarà assegnato un punteggio che terrà in considerazione SOLO i seguenti aspetti:
- percentuale di completamento dei requisiti (30%)
- applicazione dei design pattern e pulizia del codice (20%)
- gestione delle API (esposte ed utilizzate) (15%)
- progettazione del database con E/R (10%)
- pulizia repository e commit (10%)
- assenza di bug (10%)
- esposizione finale (5%)
- punti bonus: documentazione per interazioni REST (diagramma di sequenza di sistema) (10%)

In particolare, NON saranno oggetto di valutazione:
- qualità front-end (sia del codice che visiva)
- fantasia e qualità asset (immagini e testi) utilizzati
- completamento in anticipo rispetto al tempo limite

----

## Requisiti
### UI
I giochi in questione sono costituiti da un'interfaccia grafica (UI) a cui l'utente (giocatore) accede tramite browser.  
Entrambi i giochi consentono tramite la propria UI di visualizzare i pokémon presenti nei rispettivi database.  
Detti pokémon sono disposti in sequenza, in una griglia di 6 slot (squadra), e di ognuno vengono visualizzate le relative informazioni.

### Scambio
Il giocatore di **Pokémon AO**, tramite il click di un tasto nella UI, può scegliere di avviare uno scambio di Pokémon.  
Uno dei Pokémon del giocatore di **Pokémon AO** verrà scambiato con uno di quelli del giocatore di **Pokémon DAJE**, entrambi scelti a caso dai rispettivi giochi (il Pokémon viene scelto dal gioco che lo invia).  
Al termine dello scambio le UI di entrambi i giochi risulteranno aggiornate rispetto allo scambio avvenuto, con il Pokémon ricevuto nella posizione di quello inviato, mostrando le relative informazioni.  
I database di entrambi i giochi rifletteranno questo scambio effettuato.

## Dominio

### Pokémon
- nome: string
- sprite: image
- HP attuali: integer
- HP massimi: integer
- tipo: **Type**
- mosse (min 1, max 4): **Move**
- nome allenatore originario: string

### Move
- nome: string
- tipo: **Type**
- potenza: integer

### Type
- nome: string
- icona: image

----

## Dettagli implementativi:
- Utilizzare SpringBoot per il back-end e NON usare Thymeleaf per il front-end
- Le modalità di deploy sono a scelta libera
- In caso di assenza di connessione al DB, arrestare l'applicazione
- In caso di errore durante lo scambio (es.: **Pokémon AO** avvia uno scambio ma non c'è un'istanza di **Pokémon DAJE** avviata) comunicarlo all'utente con modalità a scelta libera e lasciare immutate le squadre di entrambi i giocatori
- Utilizzare un file di properties esterno, in formato YAML
- Utilizzare delle properties per configurare la porta su cui si è in ascolto e l'URL su cui contattare l'altro gioco per il caso d'uso dello scambio di Pokémon
- Se il database non contiene Pokémon, utilizzare una squadra costituita da un unico Pokémon di fallback, letto da property
- Se il database contiene più di 6 Pokémon, selezionarne 6 con criteri a scelta libera
- Gestire le immagini nel modo che si preferisce (come e da dove leggerle ecc.), argomentandolo durante l'esposizione
- Path per API REST: da stabilire, attendere nuove istruzioni dal cliente