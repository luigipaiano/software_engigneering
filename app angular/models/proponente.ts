import { Utente } from './utente';

export interface Proponente{
    
    idproponente: number;
	telefono: string;
	indirizzo: string;
	citta: string;
    cap:string;
    utente: Utente;
    
}

