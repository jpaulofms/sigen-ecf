/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.infra.impl;

import bemajava.BemaInteger;
import bemajava.BemaString;
import bemajava.Bematech;
import com.sigen.ecf.exception.EcfException;
import com.sigen.ecf.exception.FaltaPapelException;
import com.sigen.ecf.exception.PoucoPapelException;
import com.sigen.ecf.model.bean.BeanFormaPagamento;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author victor
 */
public class BematechECFService extends ECFService implements ECFEstado {

    BemaString cChavePublica = new BemaString();
    BemaString cChavePrivada = new BemaString();
    private static NumberFormat numberFormat = new DecimalFormat("0.00", new DecimalFormatSymbols(new Locale("pt", "BR"))); // formato de moeda, sem o sinal R$
    private static SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yy");
    private static DecimalFormat df = new java.text.DecimalFormat("#,##0.00");
    private BeanFormaPagamento[] formaPagamentos;

    public static void main(String[] args) {
        BematechECFService bm = new BematechECFService();

    }

    public final void geraChaves() {
        try {

            cChavePublica = new BemaString();
            cChavePrivada = new BemaString();
            BemaString pub = new BemaString();
            BemaString pri = new BemaString();
            //int iRetorno = Bematech.genkkey(cChavePublica, cChavePrivada);

            //          analisaiRetorno(iRetorno);

            //        retornoImpressora(iRetorno);

            cChavePublica.buffer = "A29BEF5B4FDCDD152026FF9E0CF46FE567676D835B8DDA0B32A367404398DA1851F610BB02FD853D54526FFEEBF2B05FE4917E8986C66A071E0B915B5C0699A5BF19BA7BDBFBC53EEFE2CCFD6F2B61F063C7A80CB081DA708607F28D9FABE6097A76D9850A9D4377350F7F07AFE60F1E4A8745B17C998BC782C54F7E79CFF6DD";
            cChavePrivada.buffer = "D8C903FCFD746B087F9609028840C2DA73D833B593C148B086B21BA983E01D1728676240B4E3B0A94B7A89221CAB97A96EAFAFECAB1EB37C57FE4B0F8B31784FC0061BEEDD76E6546C639941BA2EB3CBB4C79510459953383F9083A342FC9A198C927B91178970876F8DCD7188924CC3E6FCDC82DA16640C99C09B72E3302713";
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }

    public void analisaiRetorno(int iRetorno) throws EcfException {

        switch (iRetorno) {
            case 0:
                throw new EcfException("Erro de Comunicação!");
            case -1:
                throw new EcfException("Erro de Execução na Função. Verifique!");
            case -2:
                throw new EcfException("Parâmetro Inválido !");
            case -3:
                throw new EcfException("Alíquota não programada !");
            case -4:
                throw new EcfException(
                        "Arquivo BemaFI32.INI não encontrado. Verifique!");
            case -5:
                throw new EcfException("Erro ao Abrir a Porta de Comunicação!");
            case -6:
                throw new EcfException("Impressora Desligada ou Desconectada!");
            case -7:
                throw new EcfException(
                        "Banco Não Cadastrado no Arquivo BemaFI32.ini!");
            case -8:
                throw new EcfException(
                        "Erro ao Criar ou Gravar no Arquivo Retorno.txt ou Status.txt");
            case -18:
                throw new EcfException(
                        "Não foi possível abrir arquivo INTPOS.001 !");
            case -19:
                throw new EcfException("Parâmetro Diferentes !");
            case -20:
                throw new EcfException("Transação Cancelada pelo Operador !");
            case -21:
                throw new EcfException("A Transação não foi Aprovada !");
            case -22:
                throw new EcfException("Não foi Possível Terminar a Impressão !");
            case -23:
                throw new EcfException("Não foi Possível Terminar a Operação !");
            case -24:
                throw new EcfException("Forma de Pagamento não Programada.");
            case -25:
                throw new EcfException("Totalizador não Fiscal não Programado.");
            case -26:
                throw new EcfException("Transação já Efetuada !");
            case -27:
                throw new EcfException(
                        "Status da impressora diferente de 6,0,0 (ACK, ST1 e ST2");
            case -28:
                throw new EcfException("Não há Informações para serem Impressas !");
            case -30:
                throw new EcfException(
                        "Função não compatível com a impressora YANCO");
            default:
                ;
        }
    }

    public void retornoImpressora(int iRetorno) throws FaltaPapelException,
            PoucoPapelException, EcfException {
        BemaInteger iACK = new BemaInteger();
        BemaInteger iST1 = new BemaInteger();
        BemaInteger iST2 = new BemaInteger();

        iRetorno = Bematech.RetornoImpressora(iACK, iST1, iST2);
        if (iACK.number == 6) {
            // Verifica ST1
            if (iST1.number >= 128) {
                iST1.number = iST1.number - 128;
                throw new FaltaPapelException("Fim de Papel");
            }
            if (iST1.number >= 64) {
                iST1.number = iST1.number - 64;
                throw new PoucoPapelException("Pouco Papel, substitua a bobina.");
            }
            if (iST1.number >= 32) {
                iST1.number = iST1.number - 32;
                throw new EcfException("Erro no Relógio");
            }
            if (iST1.number >= 16) {
                iST1.number = iST1.number - 16;
                throw new EcfException("Impressora em ERRO");
            }
            if (iST1.number >= 8) {
                iST1.number = iST1.number - 8;
                throw new EcfException("CMD não iniciado com ESC");
            }
            if (iST1.number >= 4) {
                iST1.number = iST1.number - 4;
                throw new EcfException("Comando Inexistente");
            }
            if (iST1.number >= 2) {
                iST1.number = iST1.number - 2;
                throw new EcfException("Cupom Aberto");
            }
            if (iST1.number >= 1) {
                iST1.number = iST1.number - 1;
                throw new EcfException("Nº de Parâmetros Inválidos");
            }

            // Verifica ST2
            if (iST2.number >= 128) {
                iST2.number = iST2.number - 128;
                throw new EcfException("Tipo de Parâmetro Inválido");
            }
            if (iST2.number >= 64) {
                iST2.number = iST2.number - 64;
                throw new EcfException("Memória Fiscal Lotada");
            }
            if (iST2.number >= 32) {
                iST2.number = iST2.number - 32;
                throw new EcfException("CMOS não Volátil");
            }
            if (iST2.number >= 16) {
                iST2.number = iST2.number - 16;
                throw new EcfException("Alíquota Não Programada");
            }
            if (iST2.number >= 8) {
                iST2.number = iST2.number - 8;
                throw new EcfException("Alíquotas lotadas");
            }
            if (iST2.number >= 4) {
                iST2.number = iST2.number - 4;
                throw new EcfException("Cancelamento não Permitido");
            }
            if (iST2.number >= 2) {
                iST2.number = iST2.number - 2;
                throw new EcfException("CGC/IE não Programados");
            }
            if (iST2.number >= 1) {
                iST2.number = iST2.number - 1;
                throw new EcfException("Comando não Executado");
            }
        }
    }

    @Override
    public void emitirLeituraX() {
        try {
            int iRetorno = Bematech.LeituraX();
            try {
                //Bematech.FechaRelatorioGerencial();
                analisaiRetorno(iRetorno);
            } catch (Exception ex) {
                Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
            }
            retornoImpressora(iRetorno);
        } catch (FaltaPapelException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PoucoPapelException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EcfException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void emitirReducaoZ() {
        try {
            int iRetorno = Bematech.ReducaoZ("", "");

            //Bematech.FechaRelatorioGerencial();
            analisaiRetorno(iRetorno);
            retornoImpressora(iRetorno);
        } catch (FaltaPapelException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PoucoPapelException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EcfException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getCRZ() {
        BemaString crz = new BemaString();
        int iRetorno = Bematech.NumeroReducoes(crz);

        try {
            //Bematech.FechaRelatorioGerencial();
            analisaiRetorno(iRetorno);

            retornoImpressora(iRetorno);
        } catch (FaltaPapelException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PoucoPapelException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EcfException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Integer.parseInt(crz.buffer);
    }

    @Override
    public Date getData() {
        Date dataRetorno = null;
        try {
            BemaString data = new BemaString();
            BemaString hora = new BemaString();

            int iRetorno = Bematech.DataHoraImpressora(data, hora);

            try {
                analisaiRetorno(iRetorno);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            retornoImpressora(iRetorno);

            SimpleDateFormat dateParse = new SimpleDateFormat("ddMMyy");
            SimpleDateFormat sdfDateFormat = new SimpleDateFormat("dd/MM/yy");
            SimpleDateFormat horaParse = new SimpleDateFormat("HHmmss");
            SimpleDateFormat sdfHoraFormat = new SimpleDateFormat("HH:mm:ss");
            SimpleDateFormat sdfFinal = new SimpleDateFormat("dd/MM/yy HH:mm:ss");


            try {
                String dtParse = sdfDateFormat.format(dateParse.parse(data.buffer));
                String hrParse = sdfHoraFormat.format(horaParse.parse(hora.buffer));

                String dataComHora = String.format("%s %s", dtParse, hrParse);

                java.util.Date dataHora = sdfFinal.parse(dataComHora);
                dataRetorno = dataHora;
            } catch (ParseException ex) {
                ex.printStackTrace();


            }

        } catch (FaltaPapelException ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (PoucoPapelException ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (EcfException ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return dataRetorno;
    }

    @Override
    public void abrirCupom(String cpf) {
        try {
            int iRetorno = Bematech.AbreCupom(cpf);
            try {
                //Bematech.FechaRelatorioGerencial();
                analisaiRetorno(iRetorno);


            } catch (Exception ex) {
                Logger.getLogger(BematechECFService.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            retornoImpressora(iRetorno);


        } catch (FaltaPapelException ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (PoucoPapelException ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (EcfException ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private BeanFormaPagamento[] getFormasPagamento() {
        if (formaPagamentos == null) {
            carregaFormasPagamento();
        }
        return formaPagamentos.clone();
    }

    /**
     * Carrega as formas de pagamento programadas no ECF.
     *
     * @see gerFormasPagamento
     * @throws ACBrException
     */
    private List<String> carregaFormasPagamento() {

        BemaString bs = new BemaString();
        int iRetorno = Bematech.VerificaFormasPagamento(bs);

        String formas[] = bs.buffer.split(",");
        List<String> lsFormaPagamento = new ArrayList<String>();

        for (int i = 0; i < formas.length; i++) {
            String forma = formas[i].substring(0, formas[i].indexOf(" "));
            if (!forma.equals("")) {
                lsFormaPagamento.add(forma);
            }
        }

        try {
            //Bematech.FechaRelatorioGerencial();
            analisaiRetorno(iRetorno);


        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        try {
            retornoImpressora(iRetorno);


        } catch (FaltaPapelException ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (PoucoPapelException ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (EcfException ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return lsFormaPagamento;
    }

    @Override
    public List<String> getFormasPagamentoECF() {
        return carregaFormasPagamento();
    }

    public void fechaCupom(String acrescimoDesconto,
            String tipoAcrescimoDesconto, String valorAcrescimoDesconto,
            String mensagem, List<Map<String, Object>> formasPagamento)
            throws FaltaPapelException, PoucoPapelException, EcfException {

        int iRetorno = Bematech.IniciaFechamentoCupom(acrescimoDesconto,
                tipoAcrescimoDesconto, valorAcrescimoDesconto);
        try {
            //Bematech.FechaRelatorioGerencial();
            analisaiRetorno(iRetorno);

        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        retornoImpressora(iRetorno);

        for (int i = 0; i < formasPagamento.size(); i++) {
            iRetorno = Bematech.EfetuaFormaPagamento(
                    String.valueOf(formasPagamento.get(i).get("Descricao")),
                    String.valueOf(formasPagamento.get(i).get("Valor")));
            try {
                //Bematech.FechaRelatorioGerencial();
                analisaiRetorno(iRetorno);

            } catch (Exception ex) {
                Logger.getLogger(BematechECFService.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            retornoImpressora(iRetorno);
        }

        iRetorno = Bematech.TerminaFechamentoCupom(mensagem);
        try {
            //Bematech.FechaRelatorioGerencial();
            analisaiRetorno(iRetorno);
        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        }
        retornoImpressora(iRetorno);
    }

    @Override
    public void imprimirRelatorioGerencial(String valor) throws Exception {

        int iRetorno = Bematech.RelatorioGerencial(valor);

        analisaiRetorno(iRetorno);

        retornoImpressora(iRetorno);

    }

    @Override
    public void fecharRelatorioGerencial() {
        try {
            int iRetorno = Bematech.FechaRelatorioGerencial();
            //Bematech.FechaRelatorioGerencial();
            analisaiRetorno(iRetorno);
            retornoImpressora(iRetorno);

        } catch (FaltaPapelException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PoucoPapelException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EcfException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void abrirCupomVinculado(String formaPagamento, String valor,
            String numeroCupomFiscal) throws FaltaPapelException, PoucoPapelException, EcfException {
        int iRetorno = Bematech.AbreComprovanteNaoFiscalVinculado(
                formaPagamento, valor, numeroCupomFiscal);
        try {
            //Bematech.FechaRelatorioGerencial();
            analisaiRetorno(iRetorno);






        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        retornoImpressora(iRetorno);
    }

    public void imprimirCupomVinculado(String textoCupomVinculado) {
        int iRetorno = Bematech.UsaComprovanteNaoFiscalVinculado(textoCupomVinculado);
        try {
            //Bematech.FechaRelatorioGerencial();
            analisaiRetorno(iRetorno);
            retornoImpressora(iRetorno);

        } catch (FaltaPapelException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PoucoPapelException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EcfException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        }

        iRetorno = Bematech.AcionaGuilhotinaMFD(0);
        try {
            //Bematech.FechaRelatorioGerencial();
            analisaiRetorno(iRetorno);
            retornoImpressora(iRetorno);

        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void fecharCupom(String mensagem) throws FaltaPapelException, PoucoPapelException, EcfException {
        int iRetorno = Bematech.TerminaFechamentoCupom(mensagem);
        //Bematech.FechaRelatorioGerencial();
        analisaiRetorno(iRetorno);

        retornoImpressora(iRetorno);
    }

    public void fecharCupomVinculado() throws FaltaPapelException, PoucoPapelException, EcfException {
        int iRetorno = Bematech.FechaComprovanteNaoFiscalVinculado();
        try {
            //Bematech.FechaRelatorioGerencial();
            analisaiRetorno(iRetorno);






        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        retornoImpressora(iRetorno);
    }

    public void efetuaPagamentoNaoFiscal(String indice, String valor, String nomeForma) throws FaltaPapelException, PoucoPapelException, EcfException {
        int iRetorno = Bematech.RecebimentoNaoFiscal(indice, valor, nomeForma);
        try {
            //Bematech.FechaRelatorioGerencial();
            analisaiRetorno(iRetorno);






        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        retornoImpressora(iRetorno);
    }

    public void abrirPortaSerial() throws FaltaPapelException, PoucoPapelException, EcfException {
        int iRetorno = Bematech.AbrePortaSerial();
        try {
            //Bematech.FechaRelatorioGerencial();
            analisaiRetorno(iRetorno);






        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        retornoImpressora(iRetorno);
    }

    public void fecharPortaSerial() throws FaltaPapelException, PoucoPapelException, EcfException {
        int iRetorno = Bematech.FechaPortaSerial();
        try {
            //Bematech.FechaRelatorioGerencial();
            analisaiRetorno(iRetorno);






        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        retornoImpressora(iRetorno);

    }

    public void horarioVerao() throws FaltaPapelException, PoucoPapelException, EcfException {
        int iRetorno = Bematech.ProgramaHorarioVerao();
        try {
            //Bematech.FechaRelatorioGerencial();
            analisaiRetorno(iRetorno);






        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        retornoImpressora(iRetorno);
    }

    public void memoriaFiscalPorData(String data1, String data2)
            throws FaltaPapelException, PoucoPapelException, EcfException {
        int iRetorno = Bematech.LeituraMemoriaFiscalData(data1, data2);
        try {
            //Bematech.FechaRelatorioGerencial();
            analisaiRetorno(iRetorno);






        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        retornoImpressora(iRetorno);
    }

    public void memoriaFiscalPorReducao(String red1, String red2)
            throws FaltaPapelException, PoucoPapelException, EcfException {
        int iRetorno = Bematech.LeituraMemoriaFiscalReducao(red1, red2);
        try {
            //Bematech.FechaRelatorioGerencial();
            analisaiRetorno(iRetorno);






        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        retornoImpressora(iRetorno);
    }

    @Override
    public void cancelaCupom() throws EcfException, FaltaPapelException, PoucoPapelException {
        int iRetorno = Bematech.CancelaCupom();
        try {
            //Bematech.FechaRelatorioGerencial();
            analisaiRetorno(iRetorno);






        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        retornoImpressora(iRetorno);
    }

    public void cancelaItemAnterior() throws FaltaPapelException, PoucoPapelException, EcfException {
        int iRetorno = Bematech.CancelaItemAnterior();
        try {
            //Bematech.FechaRelatorioGerencial();
            analisaiRetorno(iRetorno);






        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        retornoImpressora(iRetorno);
    }

    @Override
    public void cancelarItemVenda(String item) throws FaltaPapelException, PoucoPapelException, EcfException {
        int iRetorno = Bematech.CancelaItemGenerico(item);
        try {
            //Bematech.FechaRelatorioGerencial();
            analisaiRetorno(iRetorno);






        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        retornoImpressora(iRetorno);
    }

    public void programaAliquota(String aliquota) throws FaltaPapelException, PoucoPapelException, EcfException {
        String[] aliquotas = retornoAliquotas();
        boolean contains = false;
        for (int i = 0; i < aliquotas.length; i++) {
            if (aliquotas[i].equals(aliquota)) {
                contains = true;
                break;
            }
        }

        if (!contains) {
            int iRetorno = Bematech.ProgramaAliquota(aliquota, 0);
            try {
                //Bematech.FechaRelatorioGerencial();
                analisaiRetorno(iRetorno);






            } catch (Exception ex) {
                Logger.getLogger(BematechECFService.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            retornoImpressora(iRetorno);
        }
    }

    /**
     * @param formaPagamento STRING até 16 caracteres com a forma de pagamento
     * @param permiteTEF STRING com 0 (zero) ou 1 (um) indicando se a forma de
     * pagamento permite operação TEF ou não, onde: 1 - permite operação TEF 0 -
     * não permite operação TEF
     */
    public void programaFormaPagamento(String formaPagamento, String permiteTEF)
            throws FaltaPapelException, PoucoPapelException, EcfException {
        int iRetorno = Bematech.ProgramaFormaPagamentoMFD(formaPagamento,
                permiteTEF);
        try {
            //Bematech.FechaRelatorioGerencial();
            analisaiRetorno(iRetorno);






        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        retornoImpressora(iRetorno);
    }

    /**
     *
     * @return Variável string com 6 posições para receber o número do último
     * cupom.
     * @throws Exception
     */
    public String numeroUltimoCupom() throws FaltaPapelException, PoucoPapelException, EcfException {
        BemaString bemaString = new BemaString();

        int iRetorno = Bematech.NumeroCupom(bemaString);
        try {
            //Bematech.FechaRelatorioGerencial();
            analisaiRetorno(iRetorno);






        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        retornoImpressora(iRetorno);

        return bemaString.buffer;
    }

    public String valorUltimoCupom() throws FaltaPapelException, PoucoPapelException, EcfException {
        BemaString bemaString = new BemaString();

        int iRetorno = Bematech.ValorPagoUltimoCupom(bemaString);
        try {
            //Bematech.FechaRelatorioGerencial();
            analisaiRetorno(iRetorno);






        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        retornoImpressora(iRetorno);

        return bemaString.buffer;
    }

    public String[] retornoAliquotas() throws FaltaPapelException, PoucoPapelException, EcfException {
        BemaString bemaString = new BemaString();

        int iRetorno = Bematech.RetornoAliquotas(bemaString);
        try {
            //Bematech.FechaRelatorioGerencial();
            analisaiRetorno(iRetorno);
        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        retornoImpressora(iRetorno);

        return bemaString.buffer.split(",");
    }

    private String downloadMFD(String tipoDownload, String dataInicial, String dataFinal) {
        String nomeDownloadMFD = "C:\\DownloadMFD.MFD";

        try {
            int iRetorno = Bematech.DownloadMFD(nomeDownloadMFD, tipoDownload, dataInicial, dataFinal, "1");
            //Bematech.FechaRelatorioGerencial();
            analisaiRetorno(iRetorno);

            retornoImpressora(iRetorno);
        } catch (FaltaPapelException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PoucoPapelException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EcfException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //RETORNO NOME ARQUIVOMFDGERADO
        return nomeDownloadMFD;
    }

    @Override
    public void vendeItem(String codigo, String descricao, String aliquota,
            String qtde, String vlrUnitario, String vlrDesconto, String tipoIcms)
            throws EcfException, FaltaPapelException, PoucoPapelException {

        if (codigo.length() > 12) {
            codigo = codigo.substring(0, 12);
        }

        if (descricao.length() > 29) {
            descricao = descricao.substring(0, 29);
        }

        if (qtde.length() > 4) {
            throw new EcfException(
                    "impressora não suporta quantidade maior que 4 dígitos");
        }

        if (vlrUnitario.length() > 8) {
            throw new EcfException(
                    "impressora não suporta valor unitário maior que 8 dígitos");
        }

        if (vlrDesconto.length() > 8) {
            throw new EcfException(
                    "impressora não suporta desconto maior que 8 dígitos");
        }

        // BEMAFI32 HELP
        // TipoQuantidade: 1 (um) caracter indicando o tipo de quantidade. I -
        // Inteira e F - Fracionária.
        //
        // Quantidade: STRING com até 4 dígitos para quantidade inteira e 7
        // dígitos para quantidade fracionária. Na quantidade fracionária são 3
        // casas decimais.
        String[] qtdeArray = qtde.split(",");
        String inteiro = qtdeArray[0];
        inteiro = StringUtils.leftPad(inteiro, 4, "0");
        String decimal = "000";
        if (qtdeArray.length > 1) {
            decimal = qtdeArray[1];
            decimal = StringUtils.rightPad(decimal, 3, "0");
        }

        if (tipoIcms.equals("FF")) {
            aliquota = "FF";
        }

        int iRetorno = Bematech.VendeItem(codigo, descricao, aliquota, "F",
                inteiro + decimal, 2, vlrUnitario, "$", vlrDesconto);
        analisaiRetorno(iRetorno);
        retornoImpressora(iRetorno);
    }

    @Override
    public void LMFDataEmitir(String dataIni, String dataFim, String tipo) {

        int iRetorno = Bematech.LeituraMemoriaFiscalDataMFD(dataIni, dataFim, tipo);

        try {
            analisaiRetorno(iRetorno);

            retornoImpressora(iRetorno);

        } catch (FaltaPapelException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PoucoPapelException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EcfException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void LMFReducaoEmitir(String dataIni, String dataFim, String tipo) {

        int iRetorno = Bematech.LeituraMemoriaFiscalReducaoMFD(dataIni, dataFim, tipo);

        try {
            analisaiRetorno(iRetorno);

            retornoImpressora(iRetorno);

        } catch (FaltaPapelException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PoucoPapelException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EcfException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void LMFDataGerar(String inicial, String fim, String tipo) {

        //geraChaves();

        int iRetorno = Bematech.LeituraMemoriaFiscalSerialDataMFD(inicial, fim, tipo);
        //LeituraMemoriaFiscalSerialDataPAFECF(inicial, fim, tipo, cChavePublica.buffer, cChavePrivada.buffer);

        try {
            analisaiRetorno(iRetorno);

            retornoImpressora(iRetorno);

        } catch (FaltaPapelException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PoucoPapelException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EcfException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void LMFReducaoGerar(String rdzIni, String rdzFim, String tipo) {
        geraChaves();

        int iRetorno = Bematech.LeituraMemoriaFiscalSerialReducaoMFD(rdzIni, rdzFim, tipo);
        //LeituraMemoriaFiscalSerialReducaoPAFECF(rdzIni, rdzFim, tipo, cChavePublica.buffer, cChavePrivada.buffer);
        try {
            analisaiRetorno(iRetorno);

            retornoImpressora(iRetorno);

        } catch (FaltaPapelException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PoucoPapelException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EcfException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void gerarDAVEmitidos(String nInicial, String nFinal) {
        try {
            // cChavePublica e cChavePrivada        
            geraChaves();

            SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yy");
            String caminhoDestino = getECF().concat(sdf.format(getData()).concat(".txt"));

            int iRetorno = Bematech.DAVEmitidosArquivo(caminhoDestino, nInicial, nFinal, cChavePublica.buffer, cChavePrivada.buffer);

            analisaiRetorno(iRetorno);

            retornoImpressora(iRetorno);

        } catch (FaltaPapelException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PoucoPapelException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EcfException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void gerarEspelho(String nInicial, String nFinal, String tipo, String codOper) {
        try {
            // cChavePublica e cChavePrivada
            String caminhoDestino = "";
            geraChaves();

            int iRetorno = Bematech.EspelhoMFD(caminhoDestino, nInicial, nFinal, tipo, codOper, cChavePublica.buffer, cChavePrivada.buffer);

            analisaiRetorno(iRetorno);

            retornoImpressora(iRetorno);

        } catch (FaltaPapelException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PoucoPapelException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EcfException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void gerarArquivo(String nInicial, String nFinal, String tipo, String usuario) {
        try {
            String numSerieECF;
            String numECF;
            int tipoGeracao = 1; // MFD
            int unicoArquivo = 1; // Unico arquivo
            // cChavePublica e cChavePrivada
            geraChaves();
            String nomeArquivoMFDGerado = downloadMFD(tipo, nInicial, nFinal);

            int iRetorno = Bematech.ArquivoMFD(nomeArquivoMFDGerado, nInicial, nFinal, tipo, usuario, tipoGeracao, cChavePublica.buffer, cChavePrivada.buffer, unicoArquivo);

            analisaiRetorno(iRetorno);

            // GRAVAR EM DIRETORIO FTP
     /*if (iRetorno == 1) {
             String arquivoMFD = "";
             //CLASSE ENVIO FTP
             if (flagTipo.equalsIgnoreCase("D")) {
             String[] dInicial = inicial.split("/");
             String[] dFim = fim.split("/");
             //JUNTAR
             inicial = "";
             fim = "";
             for (int i = 0; i < dInicial.length; i++) {
             inicial += dInicial[i];
             fim += dFim[i];
             }

             arquivoMFD = "C:\\" + numSerieECF + "_" + inicial + "_" + fim + ".TXT";
             } else if (flagTipo.equalsIgnoreCase("C")) {
             arquivoMFD = "C:\\" + numSerieECF + "_" + inicial + "_" + fim + ".TXT";
             }
             String[] arqMFD = new String[]{arquivoMFD};
             FTPConnection.main(arqMFD, numECF);
             }*/
            retornoImpressora(iRetorno);
        } catch (FaltaPapelException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PoucoPapelException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EcfException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void geraTabelaProdutos() {
    }

    public void arquivoEstoque() {
    }

    public void movimentoECF() {
    }

    private String nomeiaRelatorioMeiosDePagamento() throws FaltaPapelException, PoucoPapelException, EcfException {

        int iRetorno = Bematech.NomeiaRelatorioMeiosDePagamento();
        try {
            analisaiRetorno(iRetorno);
        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        }
        retornoImpressora(iRetorno);
        return String.valueOf(iRetorno);
    }

    public void abreRelatorioMeiosPagamento() throws FaltaPapelException, PoucoPapelException, EcfException {
        //É necessário programar, previamente, um relatório gerencial na impressora com a descrição "MEIOS DE PGTO"
        String indiceGerencial = nomeiaRelatorioMeiosDePagamento();

        int iRetorno = Bematech.AbreRelatorioMeiosPagamento(indiceGerencial);
        try {
            analisaiRetorno(iRetorno);
        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        }
        retornoImpressora(iRetorno);
    }

    public void usaRelatorioMeiosPagamento(String descricaoPagamento, String tipoDocumento, String valorAcumulado, String data) throws FaltaPapelException, PoucoPapelException, EcfException {

        int iRetorno = Bematech.UsaRelatorioMeiosPagamento(descricaoPagamento, tipoDocumento, valorAcumulado, data);
        try {
            analisaiRetorno(iRetorno);
        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        }
        retornoImpressora(iRetorno);
    }

    public void fechaRelatorioMeiosPagamento() throws FaltaPapelException, PoucoPapelException, EcfException {

        int iRetorno = Bematech.FechaRelatorioMeiosPagamento();
        try {
            analisaiRetorno(iRetorno);
        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        }
        retornoImpressora(iRetorno);
    }

    private String nomeiaRelatorioDAVEmitidos() throws FaltaPapelException, PoucoPapelException, EcfException {

        int iRetorno = Bematech.NomeiaRelatorioDAVEmitidos();
        try {
            analisaiRetorno(iRetorno);
        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        }
        retornoImpressora(iRetorno);
        return String.valueOf(iRetorno);
    }

    @Override
    public void emitirDAVEmitidos(String dataIni, String dataFim) {
        try {
            //É necessário programar, previamente, um relatório gerencial na impressora com a descrição "DAV EMITIDOS".
            String indiceGerencial = nomeiaRelatorioDAVEmitidos();

            int iRetorno = Bematech.DAVEmitidosRelatorioGerencial(indiceGerencial, dataIni, dataFim);

            analisaiRetorno(iRetorno);
            retornoImpressora(iRetorno);
        } catch (FaltaPapelException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PoucoPapelException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EcfException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void vendasPeriodo() {
    }

    public void parametrosConfiguracao() {
    }

    public void identficacaooECF(String indiceGerencial, String numeroLaudo, String cnpj, String razaoSocial, String endereco, String telefone,
            String contato, String nomeComercial, String versao, String caminhoPath, String md5, String demaisArquivos, String md5DemaisArquivos,
            String numeroSerie) throws FaltaPapelException, PoucoPapelException, EcfException {

        String indiceGerencialAtu = NomeiaRelatorioIdentificacaoECF();
        //modificar parametros em r01 banco local
        int iRetorno = Bematech.IdentificacaoPAFECF(indiceGerencialAtu, numeroLaudo, cnpj, razaoSocial, endereco, telefone, contato, nomeComercial,
                versao, caminhoPath, md5, demaisArquivos, md5DemaisArquivos, numeroSerie);
        try {
            analisaiRetorno(iRetorno);


        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        }
        retornoImpressora(iRetorno);
    }

    private String NomeiaRelatorioIdentificacaoECF() throws FaltaPapelException, PoucoPapelException, EcfException {

        int iRetorno = Bematech.NomeiaRelatorioIdentificacaoPAFECF();
        try {
            analisaiRetorno(iRetorno);

        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        }
        retornoImpressora(iRetorno);
        return String.valueOf(iRetorno);
    }

    @Override
    public void abrirGaveta() {
        int iRetorno = Bematech.AcionaGaveta();

        try {
            analisaiRetorno(iRetorno);



        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        try {
            retornoImpressora(iRetorno);


        } catch (FaltaPapelException ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (PoucoPapelException ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (EcfException ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void efetuarSangria(String codOper, String nomeOper, String forma, BigDecimal valor) {
        int iRetorno = Bematech.Sangria(valor.toPlainString());

        try {
            imprimeComprovanteSangria(codOper, nomeOper, forma, valor);
            analisaiRetorno(iRetorno);


        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        try {
            retornoImpressora(iRetorno);


        } catch (FaltaPapelException ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (PoucoPapelException ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (EcfException ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void efetuarSuprimento(String suprimento, String descricaoForma) throws FaltaPapelException, PoucoPapelException, EcfException {

        int iRetorno = Bematech.Suprimento(suprimento, "");

        try {
            analisaiRetorno(iRetorno);


        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        retornoImpressora(iRetorno);
    }

    @Override
    public void efetuarPagamento(String dFromaPagamento, BigDecimal valorTipo, String quantiParcelas, String msg) throws Exception {
        if (msg == null) {
            msg = "";
        }
        System.out.println("Forma PG = " + dFromaPagamento);
        //dFromaPagamento = dFromaPagamento.substring(0, 1).toUpperCase().concat(dFromaPagamento.substring(1).toLowerCase());
        int iRetorno = Bematech.EfetuaFormaPagamentoMFD(dFromaPagamento, valorTipo.toString(), quantiParcelas, msg);

        analisaiRetorno(iRetorno);

        retornoImpressora(iRetorno);
    }

    @Override
    public void subTotalizaCupom(String acrescimoDesconto, String tipo) throws FaltaPapelException, PoucoPapelException, EcfException {
        int iRetorno = Bematech.IniciaFechamentoCupom(tipo, "$", acrescimoDesconto.replace(".", ""));
        try {
            analisaiRetorno(iRetorno);


        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        retornoImpressora(iRetorno);
    }

    @Override
    public void espelhoMFD() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void arquivoMFD() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void finalizarCupom() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void relatorioComprovante1() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void relatorioComprovante2() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void relatorioSaldoDevolucao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void relatorioReciboCrediario() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void relatorioPosicaoCaixa() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void inserirDescontoItem(String item, String acrescimoDesconto, String tipo, BigDecimal valor) {
        String tipoAcrescimoDesconto = "%";
        if (tipo.equalsIgnoreCase("V")) {
            tipoAcrescimoDesconto = "$";
        }

        int iRetorno = Bematech.AcrescimoDescontoItemMFD(item, acrescimoDesconto, tipoAcrescimoDesconto, valor.toPlainString());
        try {
            analisaiRetorno(iRetorno);

            retornoImpressora(iRetorno);


        } catch (FaltaPapelException ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (PoucoPapelException ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (EcfException ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getCOO() {
        BemaString coo = new BemaString();
        int iRetorno = Bematech.NumeroCupom(coo);

        try {
            analisaiRetorno(iRetorno);


        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        try {
            retornoImpressora(iRetorno);


        } catch (FaltaPapelException ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (PoucoPapelException ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (EcfException ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return String.valueOf(coo.buffer);

    }

    @Override
    public String getGNF() {
        BemaString gnf = new BemaString();
        int iRetorno = Bematech.NumeroOperacoesNaoFiscais(gnf);

        try {
            analisaiRetorno(iRetorno);

            retornoImpressora(iRetorno);


        } catch (FaltaPapelException ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (PoucoPapelException ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (EcfException ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return String.valueOf(gnf.buffer);
    }

    @Override
    public String getLoja() {
        BemaString loja = new BemaString();
        int iRetorno = Bematech.NumeroLoja(loja);

        try {
            analisaiRetorno(iRetorno);

            retornoImpressora(iRetorno);



        } catch (FaltaPapelException ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (PoucoPapelException ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (EcfException ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return String.valueOf(loja.buffer);
    }

    @Override
    public String getECF() {
        BemaString ecf = new BemaString();
        int iRetorno = Bematech.NumeroCaixa(ecf);

        try {
            analisaiRetorno(iRetorno);

            retornoImpressora(iRetorno);


        } catch (FaltaPapelException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PoucoPapelException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EcfException ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return String.valueOf(ecf.buffer);
    }

    @Override
    public void imprimeComprovanteEntradaOperador(String codOper, String nomeOper, BigDecimal valFdo, BigDecimal valPre) {

        String comprovanteEntrada = "************** Entrada de Operador *************\r\n";
        comprovanteEntrada += "Codigo do Operador:........ " + codOper + "\r\n";
        comprovanteEntrada += "Nome:...................... " + nomeOper + "\r\n";
        comprovanteEntrada += "Fundo de Troco:............ " + numberFormat.format(valFdo) + "\r\n";
        comprovanteEntrada += "Vale-Presente:............. " + numberFormat.format(valPre) + "\r\n";
        comprovanteEntrada += "************************************************\r\n";
        try {

            imprimirRelatorioGerencial(comprovanteEntrada + (char) 13 + (char) 10);
            fecharRelatorioGerencial();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }

    }

    @Override
    public void imprimeComprovanteSaidaOperador(String codOper, String nomeOper) {

        String comprovanteSaida = "************** Saida de Operador ***************\r\n";
        comprovanteSaida += "Codigo do Operador:........ " + codOper + "\r\n";
        comprovanteSaida += "Nome:...................... " + nomeOper + "\r\n";
        comprovanteSaida += "************************************************\r\n";
        try {

            imprimirRelatorioGerencial(comprovanteSaida + (char) 13 + (char) 10);
            fecharRelatorioGerencial();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
    }

    public void imprimeComprovanteSangria(String codOper, String nomeOper, String forma, BigDecimal valor) throws Exception {

        String comrovanteSangria = "******************** Sangria *******************\r\n";
        comrovanteSangria += "Codigo do Operador:............. " + codOper + "\r\n";
        comrovanteSangria += "Nome:........................... " + nomeOper + "\r\n";
        comrovanteSangria += "Forma                              Valor\r\n";
        comrovanteSangria += forma + "                       " + NumberFormat.getCurrencyInstance().format(valor) + "\r\n";
        comrovanteSangria += "************************************************\r\n";

        try {
            imprimirRelatorioGerencial(comrovanteSangria + (char) 13 + (char) 10);
            fecharRelatorioGerencial();
        } catch (Exception ex) {
            throw ex;
        } finally {
        }
    }

    private int getEstadoImpressoraEstendido() {

        BemaInteger ack = new BemaInteger();
        BemaInteger st1 = new BemaInteger();
        BemaInteger st2 = new BemaInteger();
        BemaInteger st3 = new BemaInteger();
        int iRetorno = Bematech.HabilitaDesabilitaRetornoEstendidoMFD("1");
        if (iRetorno == 1) {
            iRetorno = Bematech.VerificaEstadoImpressoraMFD(ack, st1, st2, st3);
        }
        if (ack.number == 0) {
            st3.number = -1;
        }
        return st3.number;
    }

    @Override
    public boolean getECFAtiva() {
        int iRetorno = Bematech.VerificaImpressoraLigada();
        if (iRetorno == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean getECFCupomAberto() {

        BemaInteger ack = new BemaInteger();
        BemaInteger st1 = new BemaInteger();
        BemaInteger st2 = new BemaInteger();

        int iRetorno = Bematech.VerificaEstadoImpressora(ack, st1, st2);
        iRetorno = Bematech.RetornoImpressora(ack, st1, st2);
        if (iRetorno == 1 && ack.number == 6) {
            if (st1.number == 2) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean getECFLivre() {
        int estado = getEstadoImpressoraEstendido();
        if (estado == IMPRESSORA_OFFLINE) {
            return false;
        }
        if (estado == ECF_OCUPADO) {
            return false;
        }
        return true;
    }

    @Override
    public boolean getECFSemPapel() {
        if (getEstadoImpressoraEstendido() == SEM_PAPEL) {
            return true;
        }
        return false;
    }

    @Override
    public boolean getPoucoPapel() {
        BemaInteger ack = new BemaInteger();
        BemaInteger st1 = new BemaInteger();
        BemaInteger st2 = new BemaInteger();

        int iRetorno = Bematech.VerificaEstadoImpressora(ack, st1, st2);

        if (ack.number == 6 && st1.number == 64 && st2.number == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void abrirVinculadoTEF(String conveniadaString, BigDecimal valorTransacao, String nCupom) throws Exception {
        System.out.println("Forma PG TEF = " + conveniadaString);
        int iRetorno = Bematech.AbreComprovanteNaoFiscalVinculado(conveniadaString, valorTransacao.toPlainString(), nCupom);
        analisaiRetorno(iRetorno);

        retornoImpressora(iRetorno);
    }

    @Override
    public void imprimirVinculadoTEF(String texto) throws Exception {
        if(texto.isEmpty())
            return;
        
        int iRetorno = Bematech.UsaComprovanteNaoFiscalVinculado(texto);

        analisaiRetorno(iRetorno);

        retornoImpressora(iRetorno);
    }

    @Override
    public void fecharVinculadoTEF() throws Exception {
        int iRetorno = Bematech.FechaComprovanteNaoFiscalVinculado();
        analisaiRetorno(iRetorno);

        retornoImpressora(iRetorno);
    }

    @Override
    public void cortarPapel() {
        int iRetorno = Bematech.AcionaGuilhotinaMFD(0);
        try {
            analisaiRetorno(iRetorno);

            retornoImpressora(iRetorno);


        } catch (FaltaPapelException ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (PoucoPapelException ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (EcfException ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /* REG 400 */
    @Override
    public String getModelo() {
        BemaString modelo = new BemaString();
        int iRetorno = Bematech.ModeloImpressora(modelo);

        try {
            analisaiRetorno(iRetorno);

            retornoImpressora(iRetorno);


        } catch (FaltaPapelException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PoucoPapelException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EcfException ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return String.valueOf(modelo.buffer);
    }

    @Override
    public String getSerie() {
        BemaString serie = new BemaString();
        int iRetorno = Bematech.NumeroSerie(serie);

        try {
            analisaiRetorno(iRetorno);

            retornoImpressora(iRetorno);


        } catch (FaltaPapelException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PoucoPapelException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EcfException ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return String.valueOf(serie.buffer);
    }

    @Override
    public String dadosUltimaReducaoGerar() {
        BemaString sDados = new BemaString();
        int iRetorno = Bematech.DadosUltimaReducaoMFD(sDados);

        try {
            analisaiRetorno(iRetorno);

            retornoImpressora(iRetorno);


        } catch (FaltaPapelException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PoucoPapelException ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EcfException ex) {
            Logger.getLogger(BematechECFService.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BematechECFService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sDados.buffer;
    }
}