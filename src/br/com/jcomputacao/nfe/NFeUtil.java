/*
 * Copyright (C) 2010  J. Computacao LTDA
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * If it is your itention to get support for a commercial version of this
 * application get in touch with J. Computacao LTDA at http://www.jcomputacao.com.br
 *
 * Este programa � software livre: voce pode redistribui-lo e/ou modifica-lo
 * sob os termos da Licenca Pulica Generica (GNU GPL) como publicado pela
 * Free Software Foundation, na versao 3 da licenca ou alguma versao superior.
 *
 * This programa e distribuido na esperanca que seja util,
 * mas SEM QUALQUER GARANTIA; sem sequer a garantia implicita
 * de COMERCIALIZACAO or APTIDAO PARA UMA FINALIDADE PARTICULAR.
 * Leia a GNU GPL para mais detalhes.
 *
 * Voce deveria receber uma copia da GNU GPL junto com este programa
 * se nao o recebeu leia em <http://www.gnu.org/licenses/>.
 *
 * Se for sua intencao obter suporte para uma versao comercial desta
 * aplicacao entre em contato com J. Computacao LTDA em http://www.jcomputacao.com.br
 *
 */
package br.com.jcomputacao.nfe;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author Murilo
 */
public class NFeUtil {
    private static NumberFormat format = null;
    private static NumberFormat formatNumber = null;
    private static int ambiente = 1;
    private static int tipoProcessamento = 3;
    private static String versaoProcessamento = null;
    public static String modelo = "55";

    static {
        formatNumber = NumberFormat.getNumberInstance(Locale.US);
        formatNumber.setMaximumFractionDigits(3);
        formatNumber.setMinimumFractionDigits(3);
        formatNumber.setGroupingUsed(false);
        format = NumberFormat.getNumberInstance(Locale.US);
        format.setMaximumFractionDigits(4);
        format.setMinimumFractionDigits(4);
        format.setGroupingUsed(false);
        ambiente = Integer.parseInt(System.getProperty("nfe.ambiente", "2"));
        tipoProcessamento = Integer.parseInt(System.getProperty("nfe.tipoProcessamento", "0"));
        versaoProcessamento = System.getProperty("nfe.versaoProcessamento", "SP_NFE_PL_006h");
        modelo = System.getProperty("modelo", modelo);
    }

    public static String quatroCasas(double valor){
        return format.format(valor);
    }
    
    public static String tresCasas(double valor){
        return formatNumber.format(valor);
    }

    public static int getAmbiente(){
        return ambiente;
    }

    public static String versaoProcessamento(){
        return versaoProcessamento;
    }

    public static int finalidade(){
        return 1;
    }

    /**
     * 0 - emissão de NF-e com aplicativo do contribuinte;
     * 1 - emissão de NF-e avulsa pelo Fisco;
     * 2 - emissão de NF-e avulsa, pelo contribuinte com seu certificado digital, atrav�s do site do Fisco;
     * 3 - emissão NF-e pelo contribuinte com aplicativo fornecido pelo Fisco.
     */
    public static int tipoProcessamento(){
        return tipoProcessamento;
    }

    public static String getModelo(){
        return modelo;
    }

    public static String getCertificadoSenha() {
        return System.getProperty("nfe.certificado.senha");
    }

    public static String getCertificadoCaminho(){
        return System.getProperty("nfe.certificado.caminho");
    }

    public static String getCertificadoSefazCaminho() {
        return System.getProperty("nfe.certificadoSefaz.caminho", "jssecacerts");
    }

    public static String getCertificadoTipo() {
        return System.getProperty("nfe.certificado.tipo", "A1");
    }

}
