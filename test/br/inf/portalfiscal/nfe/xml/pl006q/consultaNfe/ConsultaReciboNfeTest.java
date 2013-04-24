/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.portalfiscal.nfe.xml.pl006q.consultaNfe;

import br.inf.portalfiscal.nfe.xml.pl006q.nfes.TRetConsReciNFe;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
 * @author Murilo.Lima
 */
public class ConsultaReciboNfeTest {
    
    public ConsultaReciboNfeTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
     @Test
     public void hello() throws JAXBException, UnsupportedEncodingException, IOException {     
         String xml = "<retConsReciNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"2.00\">"
                + "<tpAmb>1</tpAmb><verAplic>SP_NFE_PL_006e</verAplic><nRec>351000556516387</nRec>"
                + "<cStat>104</cStat>"
                + "<xMotivo>Lote processado</xMotivo><cUF>35</cUF><protNFe versao=\"2.00\">"
                + "<infProt><tpAmb>1</tpAmb><verAplic>SP_NFE_PL_006e</verAplic>"
                + "<chNFe>35110405437537000137550010000398471000002000</chNFe>"
                + "<dhRecbto>2011-04-13T15:19:17</dhRecbto><cStat>502</cStat>"
                + "<xMotivo>Rejei\u00e7\u00e3o: Erro na Chave de Acesso - Campo Id n\u00e3o corresponde à concatena\u00e7\u00e3o dos campos correspondentes</xMotivo>"
                + "</infProt>"
                + "</protNFe></retConsReciNFe>";
        Unmarshaller unmarshaller = null;
        TRetConsReciNFe ret = null;
        JAXBContext context = null;
        
        context = JAXBContext.newInstance("br.inf.portalfiscal.nfe.xml.pl006q.nfes");
        unmarshaller = context.createUnmarshaller();
        ByteArrayInputStream bais = new ByteArrayInputStream(xml.getBytes("UTF-8"));
        ret = unmarshaller.unmarshal(new StreamSource(bais), TRetConsReciNFe.class).getValue();
        bais.close();
        
        assertNotNull(ret);
        assertNotNull(ret.getProtNFe());
        assertTrue(ret.getProtNFe().size()==1);
        assertEquals("351000556516387", ret.getNRec());
     }
}
