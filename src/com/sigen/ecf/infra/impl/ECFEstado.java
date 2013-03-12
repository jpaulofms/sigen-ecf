package com.sigen.ecf.infra.impl;

public interface ECFEstado {

    /**
     * Componente n�o inicializado.
     */
    //public final int NAO_INICIALIZADA = 0;
    public final int IMPRESSORA_OFFLINE = 13;
    /**
     * Estado desconhecido.
     */
    //public final int DESCONHECIDO = 1;         ERRO DESCONHECIDO
    public final int DESCONHECIDO = 2;
    /**
     * ECF Livre
     */
    public final int LIVRE = 2;
    //public final int LIVRE = 2; 8        CUPOM FISCAL FECHADO // LIVRE
    public final int CUPOM_FECHADO = 8;
    /**
     * Cupom fiscal aberto, vendendo itens.
     */
    //public final int VENDA = 2; 7        CUPOM FISCAL ABERTO // EM VENDA
    public final int CUPOM_ABERTO = 7;
    /**
     * Cupom fiscal totalizado, aguardando pagamentos.
     */
    public final int PAGAMENTO = 4;
    /**
     * Emitindo relat�rio
     */
    public final int RELATORIO = 5;
    /**
     * Bloqueada at� o pr�ximo movimento.
     */
    //public final int BLOQUEADA = 6; 10        IMPRESSORA EM ERRO // BLOQUEADA
    public final int IMPRESSORA_EM_ERRO = 10;
    /**
     * Requer leitura X.
     */
//    public final int REQUER_Z = 7;66        AGUARDANDO RZ // AGUARDANDOZ
    public final int REQUER_Z = 66;
    /**
     * Requer redu��o Z.
     */
    public final int REQUER_X = 8;
    /**
     * Emitindo cupom n�o fiscal.
     */
    public final int NAO_FISCAL = 9;
    /*
     * Impressora Ocupada
     */
    public final int ECF_OCUPADO = 9;
    /*
     * Impressora sem papel
     */
    public final int SEM_PAPEL = 11; // SEM PAPEL
}
