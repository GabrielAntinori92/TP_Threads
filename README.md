# TP_Threads

1) los bloques sinchronized deben serlos para que los threads puedan acceder al recurso compartido de manera sincrona,es decir,
  que las operaciones que realiza un thread no se vea afectada por la operacion de otro que acceda al recurso compartido. Evita
  que 2 o mas threads utilicen el recurso compartido al mismo tiempo
  
  2) el recurso compartido es una zona de memoria a la que los threads acceden de forma concurrente para realizar operaciones,
    este puede ser compartido por varios threads
    
  3) - utilizando una clase que herede de Thread
     - utilizando una clase que implemente la interfaz Runnable
