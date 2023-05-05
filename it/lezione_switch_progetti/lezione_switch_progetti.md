# Lezione 3: Switch progetti

## Obiettivi
- Implementare nuove funzionalità, legate al medesimo dominio oggetto di analisi e sviluppi delle lezioni precedenti (**Pawtropolis**), sulla codebase di un altro team.  

----

## Requisiti
Introdurre la possibilità di avere delle stanze non accessibili, bloccate da porte chiuse.  
Dette porte si potranno aprire tramite appositi oggetti-chiave che il giocatore dovrà possedere nella propria borsa.  
Implementare, a tal fine, le seguenti modifiche:
- Fornire al player informazioni in merito allo stato (aperta/chiusa) di ogni porta nei comandi in cui allo stato attuale riceve descrizioni dell'ambiente (es.: `look`)  
- Modificare il comando `go` al fine di verificare, prima di far spostare di stanza il player, che la porta sia aperta  
  - In caso positivo, eseguire le normali operazioni di cambio stanza  
  - In caso negativo, chiedere al player di usare un oggetto per aprire la porta

**ESEMPIO INTERAZIONE**  
> `go nord`  

> "The door is locked: would you like to use an item to unlock it?"  

> [input da tastiera "Y/N"]  

#### Caso N
Output: niente  
Stato: **immutato** - il player è rimasto nella stanza in cui si trovava prima del comando  


#### Caso Y
> "Type the name of the chosen item"
> [input da tastiera]


#### Se l'item sbocca effettivamente la porta  
Output: "You unlocked the door!"  
Stato:
- il player si è spostato nella stanza richiesta e ne riceve la descrizione come di consueto
- l'item utilizzato viene rimosso dalla borsa del player

#### Se l'item non è corretto
Output: "This is not the right item"
Stato: **immutato** - il player è rimasto nella stanza in cui si trovava prima del comando  


## N.B.
Una volta sbloccata una porta, lo rimane per sempre.