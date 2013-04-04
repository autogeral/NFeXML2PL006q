/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.portalfiscal.nfe.xml.pl006q.consultaNfe;

import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
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
public class ConsultaSituacaoNfeTest {
    
    public ConsultaSituacaoNfeTest() {
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
        ObjectFactory of = new ObjectFactory();
        TConsSitNFe consSitNfe = of.createTConsSitNFe();
        
        String chave = "35130405437537000137550010001235761507008292";
        consSitNfe.setChNFe(chave);
        consSitNfe.setTpAmb("1");
        consSitNfe.setVersao("2.00");
        consSitNfe.setXServ("CONSULTAR");
        
        JAXBContext context = JAXBContext.newInstance("br.inf.portalfiscal.nfe.xml.pl006q.consultaNfe");
        
        Marshaller marshaller = context.createMarshaller();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        marshaller.marshal(consSitNfe, baos);
        String xml = baos.toString();
        xml = xml.replaceAll("xmlns:ns2=\".+#\"\\s", "").replaceAll("ns2:", "");
        System.out.print(xml);
        
        Unmarshaller unmarshaller = context.createUnmarshaller();
        ByteArrayInputStream bais = new ByteArrayInputStream(xml.getBytes("UTF-8"));
        consSitNfe = unmarshaller.unmarshal(new StreamSource(bais), TConsSitNFe.class).getValue();
        bais.close();
        
        assertNotNull(consSitNfe);
        assertNotNull(consSitNfe.getChNFe());
    }
}
