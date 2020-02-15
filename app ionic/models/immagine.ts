import { Proposta } from './proposta';

export interface Immagine{
    idimmagine: number;
    percorso: string;
    proposta: Proposta;
}