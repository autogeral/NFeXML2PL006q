package br.inf.portalfiscal.nfe.schema.nfe;

import br.inf.portalfiscal.nfe.xml.pl006q.nfes.TNfeProc;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author murilo
 */
public class NfeParseTest {

    public NfeParseTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testeParse() throws JAXBException, IOException {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><nfeProc versao=\"3.10\" xmlns=\"http://www.portalfiscal.inf.br/nfe\"><NFe xmlns=\"http://www.portalfiscal.inf.br/nfe\"><infNFe Id=\"NFe35150261490561003630550100002252271387902363\" versao=\"3.10\"><ide><cUF>35</cUF><cNF>38790236</cNF><natOp>VENDA A PRAZO</natOp><indPag>1</indPag><mod>55</mod><serie>10</serie><nNF>225227</nNF><dhEmi>2015-02-13T18:29:00-02:00</dhEmi><tpNF>1</tpNF><idDest>1</idDest><cMunFG>3509502</cMunFG><tpImp>1</tpImp><tpEmis>1</tpEmis><cDV>3</cDV><tpAmb>1</tpAmb><finNFe>1</finNFe><indFinal>1</indFinal><indPres>3</indPres><procEmi>0</procEmi><verProc>3.1.7</verProc></ide><emit><CNPJ>61490561003630</CNPJ><xNome>DISTRIBUIDORA AUTOMOTIVA S.A.</xNome><xFant>DISTRIB</xFant><enderEmit><xLgr>AV.ENG ANT FCO P. SOUZA</xLgr><nro>1444</nro><xBairro>VILA GEORGINA</xBairro><cMun>3509502</cMun><xMun>CAMPINAS</xMun><UF>SP</UF><CEP>13043540</CEP><cPais>1058</cPais><xPais>Brasil</xPais><fone>1921010900</fone></enderEmit><IE>244200140114</IE><CRT>3</CRT></emit><dest><CNPJ>05437537000137</CNPJ><xNome>AUTO GERAL DE ITU LTDA</xNome><enderDest><xLgr>AV DR AV DR OTAVIANO P MENDES,1333</xLgr><nro>_</nro><xBairro>LIBERDADE</xBairro><cMun>3523909</cMun><xMun>ITU</xMun><UF>SP</UF><CEP>13301000</CEP><cPais>1058</cPais><xPais>Brasil</xPais><fone>1140137777</fone></enderDest><indIEDest>1</indIEDest><IE>387034155115</IE><email>nfe.itu.matriz@autogeral.com.br</email></dest><det nItem=\"1\"><prod><cProd>27335</cProd><cEAN/><xProd>SBC 452  0,25 BRONZINA MANCAL - MML</xProd><NCM>84833029</NCM><CFOP>5405</CFOP><uCom>JG</uCom><qCom>1.0000</qCom><vUnCom>58.4000000000</vUnCom><vProd>58.40</vProd><cEANTrib/><uTrib>JG</uTrib><qTrib>1.0000</qTrib><vUnTrib>58.4000000000</vUnTrib><vOutro>0.73</vOutro><indTot>1</indTot><xPed>165959</xPed><nItemPed>1</nItemPed><nFCI>062260FB-83E0-4B84-BCB3-D20E1713C813</nFCI></prod><imposto><ICMS><ICMS60><orig>5</orig><CST>60</CST><vBCSTRet>0.00</vBCSTRet><vICMSSTRet>0.00</vICMSSTRet></ICMS60></ICMS><PIS><PISNT><CST>04</CST></PISNT></PIS><COFINS><COFINSNT><CST>04</CST></COFINSNT></COFINS></imposto><infAdProd>RESOLUCAO DO SENADO FEDERAL 13/12 NUMERO DO FCI 062260FB-83E0-4B84-BCB3-D20E1713C813</infAdProd></det><det nItem=\"2\"><prod><cProd>148129</cProd><cEAN>7894766453339</cEAN><xProd>SDA 7092  STD JOGO DE ANEIS  71,08  STD - MML</xProd><NCM>84099116</NCM><CFOP>5405</CFOP><uCom>JG</uCom><qCom>1.0000</qCom><vUnCom>93.5600000000</vUnCom><vProd>93.56</vProd><cEANTrib/><uTrib>JG</uTrib><qTrib>1.0000</qTrib><vUnTrib>93.5600000000</vUnTrib><vOutro>1.17</vOutro><indTot>1</indTot><xPed>165959</xPed><nItemPed>2</nItemPed></prod><imposto><ICMS><ICMS60><orig>0</orig><CST>60</CST><vBCSTRet>0.00</vBCSTRet><vICMSSTRet>0.00</vICMSSTRet></ICMS60></ICMS><PIS><PISNT><CST>04</CST></PISNT></PIS><COFINS><COFINSNT><CST>04</CST></COFINSNT></COFINS></imposto></det><total><ICMSTot><vBC>0.00</vBC><vICMS>0.00</vICMS><vICMSDeson>0.00</vICMSDeson><vBCST>0.00</vBCST><vST>0.00</vST><vProd>151.96</vProd><vFrete>0.00</vFrete><vSeg>0.00</vSeg><vDesc>0.00</vDesc><vII>0.00</vII><vIPI>0.00</vIPI><vPIS>0.00</vPIS><vCOFINS>0.00</vCOFINS><vOutro>1.90</vOutro><vNF>153.86</vNF></ICMSTot><retTrib/></total><transp><modFrete>0</modFrete><transporta><CNPJ>11134089000103</CNPJ><xNome>TRANSPORTADORA NENO LTDA ME</xNome><IE>795008720114</IE><xEnder>R ANTONIO ZANCANELLA,36</xEnder><xMun>CAMPINAS</xMun><UF>SP</UF></transporta><vol><qVol>1</qVol><pesoL>0.000</pesoL><pesoB>1.000</pesoB></vol></transp><cobr><fat><nFat>225227</nFat><vOrig>153.86</vOrig></fat><dup><nDup>225227-01</nDup><dVenc>2015-03-02</dVenc><vDup>153.86</vDup></dup></cobr><infAdic><infCpl>Telefone de Cobranca (011) 3155-7553 / 3155-7152*C-0269.02.13.165959.00 CR-552*CVE-0020008/0020008-*CP-FS.014.01.00*TCP-N CONPGT- 14 FS*NS-000 RA-21 CIR-8*--- ROTEIRO - 19 18:29 HS  ---*SEPAR:    2629*EMBAL:    6003 CONFER:    6003*------------------------------*ATENCAO !!!  NAO SERAO ACEITAS*DEVOLUCOES SEM PREVIA CONSULTA*A AREA COMERCIAL.!!!!*Imposto Retido por Substituicao Tributaria - Art. 274 do RICMS-SP*</infCpl><obsCont xCampo=\"email-TRANSP\"><xTexto>ctenf@transneno.com.br</xTexto></obsCont></infAdic></infNFe><Signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\"><SignedInfo><CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/><SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\"/><Reference URI=\"#NFe35150261490561003630550100002252271387902363\"><Transforms><Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"/><Transform Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/></Transforms><DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\"/><DigestValue>RAdRrQFLkJ/CwRH1xOauv9zcVcY=</DigestValue></Reference></SignedInfo><SignatureValue>k/+FldizITtwGyG6zdjf5KwDKNgA0/2oZIy+FI7lJdQkkCKcCPD3ul2ZnqSxCOhAJ+YEu3H09adM\n"
                + "I7H5Zzdf1YRhaBqSxVVrfpzmOwmo3vkfdTdsj+tD0u4XPxcEtlCpGcM/WwuiHaN1ZVO8MkJgJqFD\n"
                + "MQlsIGWwG1+SEVHzxuajxz87zERr9FeGxMmxF24amrvoDrsnUmzYrZFYmDlaEEg9IVfAfUrNaPMm\n"
                + "BHhYM+1guxT1+KqDcW/g3QFOXU7jnbqML+OD+9eoqdpiMzry8vaByr0G7fUVDg95LFh7fcX4IiDj\n"
                + "GTLpOn3UwknmnFA8l8GH0gjC81kfhTw28PllYQ==</SignatureValue><KeyInfo><X509Data><X509Certificate>MIIIOjCCBiKgAwIBAgIQb8D4BKUiDEiZs4yPBCfHsTANBgkqhkiG9w0BAQsFADB0MQswCQYDVQQG\n"
                + "EwJCUjETMBEGA1UEChMKSUNQLUJyYXNpbDEtMCsGA1UECxMkQ2VydGlzaWduIENlcnRpZmljYWRv\n"
                + "cmEgRGlnaXRhbCBTLkEuMSEwHwYDVQQDExhBQyBDZXJ0aXNpZ24gTXVsdGlwbGEgRzUwHhcNMTUw\n"
                + "MjEzMDAwMDAwWhcNMTYwMjEyMjM1OTU5WjCBxzELMAkGA1UEBhMCQlIxEzARBgNVBAoUCklDUC1C\n"
                + "cmFzaWwxIDAeBgNVBAsUF0F1dGVudGljYWRvIHBvciBBUiBIYXNhMRswGQYDVQQLFBJBc3NpbmF0\n"
                + "dXJhIFRpcG8gQTExFTATBgNVBAsUDElEIC0gNzU5MTE2NDElMCMGA1UEAxMcRElTVFJJQlVJRE9S\n"
                + "QSBBVVRPTU9USVZBIFMgQTEmMCQGCSqGSIb3DQEJARYXZmlzY2FsQGNvbW9sYXR0aS5jb20uYnIw\n"
                + "ggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCmCjlhDtUSR5lrPlwEwqb/WOnyeShTigd8\n"
                + "z/I5uGBkh5zcecZLjMzfly/CJi1fmykB3wXqrKLAegngsSQ+RGNf3Co7eP6hVfdlItmhfxiridFK\n"
                + "j/dLzng8/YuPYvKH+RoOFkezqDOcHg9NU+K4JwiL3Dl1J1RcWQMDTiJJV/XjgYH5zKNkOuc7DZ16\n"
                + "3hwTdB7s6z21YBGvgnNesK5pLirUDEb+gfVYGikVP1+mEhtCLLP/lsvGTnQwnsbfouFS7xxfKGvv\n"
                + "MLBD1Vg+OjbdvaPTE4f1SW4NdwRIDtLigcBKl1IkQUA3YQ0tXLDDksECqJhK4nO3FWKnFiAdDw/C\n"
                + "63w3AgMBAAGjggNyMIIDbjCBuAYDVR0RBIGwMIGtoD0GBWBMAQMEoDQEMjExMDgxOTU4MDA2MzIw\n"
                + "OTM4MTEwMDAwMDAwMDAwMDAwMDAwMDAxMDY2OTE0NlNTUFNQoB8GBWBMAQMCoBYEFEpPU0UgQUxW\n"
                + "QVJPIFNBUkRJTkhBoBkGBWBMAQMDoBAEDjYxNDkwNTYxMDAwMTAwoBcGBWBMAQMHoA4EDDAwMDAw\n"
                + "MDAwMDAwMIEXZmlzY2FsQGNvbW9sYXR0aS5jb20uYnIwCQYDVR0TBAIwADAfBgNVHSMEGDAWgBSd\n"
                + "UM+9/yTKr7Ez6xfiQnqOaSqOUzAOBgNVHQ8BAf8EBAMCBeAwgYkGA1UdIASBgTB/MH0GBmBMAQIB\n"
                + "CzBzMHEGCCsGAQUFBwIBFmVodHRwOi8vaWNwLWJyYXNpbC5jZXJ0aXNpZ24uY29tLmJyL3JlcG9z\n"
                + "aXRvcmlvL2RwYy9BQ19DZXJ0aXNpZ25fTXVsdGlwbGEvRFBDX0FDX0NlcnRpU2lnbk11bHRpcGxh\n"
                + "LnBkZjCCASUGA1UdHwSCARwwggEYMFygWqBYhlZodHRwOi8vaWNwLWJyYXNpbC5jZXJ0aXNpZ24u\n"
                + "Y29tLmJyL3JlcG9zaXRvcmlvL2xjci9BQ0NlcnRpc2lnbk11bHRpcGxhRzUvTGF0ZXN0Q1JMLmNy\n"
                + "bDBboFmgV4ZVaHR0cDovL2ljcC1icmFzaWwub3V0cmFsY3IuY29tLmJyL3JlcG9zaXRvcmlvL2xj\n"
                + "ci9BQ0NlcnRpc2lnbk11bHRpcGxhRzUvTGF0ZXN0Q1JMLmNybDBboFmgV4ZVaHR0cDovL3JlcG9z\n"
                + "aXRvcmlvLmljcGJyYXNpbC5nb3YuYnIvbGNyL0NlcnRpc2lnbi9BQ0NlcnRpc2lnbk11bHRpcGxh\n"
                + "RzUvTGF0ZXN0Q1JMLmNybDAdBgNVHSUEFjAUBggrBgEFBQcDAgYIKwYBBQUHAwQwgaAGCCsGAQUF\n"
                + "BwEBBIGTMIGQMGQGCCsGAQUFBzAChlhodHRwOi8vaWNwLWJyYXNpbC5jZXJ0aXNpZ24uY29tLmJy\n"
                + "L3JlcG9zaXRvcmlvL2NlcnRpZmljYWRvcy9BQ19DZXJ0aXNpZ25fTXVsdGlwbGFfRzUucDdjMCgG\n"
                + "CCsGAQUFBzABhhxodHRwOi8vb2NzcC5jZXJ0aXNpZ24uY29tLmJyMA0GCSqGSIb3DQEBCwUAA4IC\n"
                + "AQBeg/tcQPi8rUAwwJCgqnxCD6c/NP6OjucHDulo+HzEk/pdw+mOcxbX7OMCuK0vI+y8fsMJwLaQ\n"
                + "+TLjlfOBeFBSz1oHaPk/MW2Y6Jvxty/2nPoXph5iaOke7zY/RIIaRiwzdRcSlRBou+TTWUFHO3A/\n"
                + "O/+Oy8sj1tfxF4dBSMqGuzUAuBRy6iMI3aNeMhdWkZ++ZapuiFbZzZRqyAZiTdLprNEdimv9s6f4\n"
                + "UrdIVZpnAlDltQPBrqaDM3TpmArgRbowXM9oSfa/K2+p4ORSwJm82CkTLMhIN1e5XGa9xhw4AoWX\n"
                + "ryTWeTA8V64LbTaYVTAJvvpJLB1y4zIKenVRFHMEKSe29ROHZaj8rKEWq99IyqImPxm5loJkqZQ0\n"
                + "3v00OSdKbIM3NlLfze5yjO/yeQjLih13lzMWgCS6leq1omQbInAlh5dxI+Hkqp5OVRwuFyZeL/a7\n"
                + "PO758ziNpWUyawkVlyFg4qg6neLjsEK6TKF34gVSUbGmZ6Ha67djCY8Frt8c31RWEVflSD8H/c/f\n"
                + "LBXriiykHPt4v59dd1eItVUL50c6lLVC+9Vp+pyUXaCZgO2/piQrzwcTyswzMVo9AZ/gIhYnR7jW\n"
                + "S2YOvppJnR5yIBZ/2MgFQ0cja9alL6gcysVCwrerPF8CD0XyuMhL+brVAxohsvIgd8OoEvyzD53M\n"
                + "3g==</X509Certificate></X509Data></KeyInfo></Signature></NFe><protNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" xmlns:ns2=\"http://www.w3.org/2000/09/xmldsig#\" versao=\"3.10\"><infProt><tpAmb>1</tpAmb><verAplic>SP_NFE_PL_008f</verAplic><chNFe>35150261490561003630550100002252271387902363</chNFe><dhRecbto>2015-02-13T18:30:45-02:00</dhRecbto><nProt>135150097931798</nProt><digVal>RAdRrQFLkJ/CwRH1xOauv9zcVcY=</digVal><cStat>100</cStat><xMotivo>Autorizado o uso da NF-e</xMotivo></infProt></protNFe></nfeProc>";

        JAXBContext context = JAXBContext.newInstance("br.inf.portalfiscal.nfe.xml.pl006q.nfes");
        Unmarshaller unmarshaller = context.createUnmarshaller();

        ByteArrayInputStream bais = new ByteArrayInputStream(xml.getBytes("UTF-8"));
        Object obj = unmarshaller.unmarshal(new StreamSource(bais));
        bais.close();
        
        assertNotNull(obj);
        assertTrue(obj instanceof TNfeProc);
        
        TNfeProc nota = (TNfeProc) obj;
        System.out.println(nota.getVersao());
        //System.out.println(nota.getNFe().getInfNFe().getVersao());
        assertEquals(nota.getNFe().getInfNFe().getIde().getNNF(), "225227");
    }
}
