import { Utente } from './utente';

export interface Acquirente{
    
    idacquirente: number;
	telefono: string;
	indirizzo: string;
	citta: string;
    cap:string;
    utente: Utente;
    
}

