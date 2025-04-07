package br.inf.portalfiscal.nfe.xml.pl006q.eventoCancelamento;

import br.inf.portalfiscal.nfe.xml.pl006q.nfes.TProcEvento;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
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
 * @author Murilo
 */
public class ProcessamentoEventosTest {

    public ProcessamentoEventosTest() {
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
    public void hello() {

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><procEventoNFe versao=\"1.00\" xmlns=\"http://www.portalfiscal.inf.br/nfe\"><evento versao=\"1.00\"><infEvento Id=\"ID1101113513030543753700048055001000031562156032400701\"><cOrgao>35</cOrgao><tpAmb>1</tpAmb><CNPJ>05437537000480</CNPJ><chNFe>35130305437537000480550010000315621560324007</chNFe><dhEvento>2013-03-11T17:42:12-03:00</dhEvento><tpEvento>110111</tpEvento><nSeqEvento>1</nSeqEvento><verEvento>1.00</verEvento><detEvento versao=\"1.00\"><descEvento>Cancelamento</descEvento><nProt>135130142617123</nProt><xJust>Preenchimento incorreto</xJust></detEvento></infEvento><Signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\"><SignedInfo><CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/><SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\"/><Reference URI=\"#ID1101113513030543753700048055001000031562156032400701\"><Transforms><Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"/><Transform Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/></Transforms><DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\"/><DigestValue>a3TRaNRYi/twEU/KsnIjbKv4zxY=</DigestValue></Reference></SignedInfo><SignatureValue>BeJ8Ilx1deLEzPCkDsC+ZY+w0q8+cw4H/rtcZlyTn50Q38U1DD70iQjwLgwY2VL5Qhl0YPJifAJA\n"
                + "v8zvvIuDw4ajcNK0j9s+V/Is91x/zQ4DKOySfHWLXoOXDmU8XhHyP6ZZ2FDIBSTIW7dyxW83Hq5g\n"
                + "hxHrvMDCSR0reZRoRHJY3gHa5/qtWpNFW8o19K1NPOcv8U5uju43ll2QYTsEcUvMyAj/G8f3fmao\n"
                + "wkBOR2+MPyWCfZ3tB5N2RVVGpCNbEbvDK8ylg+2SkMXI1tH3xXvmyysBUoayOWhy4oeRV7Fo62vU\n"
                + "q/dukdSDJaVGL9C84ZyAbrtekEQTbSD9OxQL6g==</SignatureValue><KeyInfo><X509Data><X509Certificate>MIIITjCCBjagAwIBAgIQFL7eBDTHxJLykXSsCwn7ujANBgkqhkiG9w0BAQsFADB3MQswCQYDVQQG\n"
                + "EwJCUjETMBEGA1UEChMKSUNQLUJyYXNpbDE2MDQGA1UECxMtU2VjcmV0YXJpYSBkYSBSZWNlaXRh\n"
                + "IEZlZGVyYWwgZG8gQnJhc2lsIC0gUkZCMRswGQYDVQQDExJBQyBOb3RhcmlhbCBSRkIgRzMwHhcN\n"
                + "MTMwMzExMDAwMDAwWhcNMTQwMzEwMjM1OTU5WjCB9TELMAkGA1UEBhMCQlIxEzARBgNVBAoUCklD\n"
                + "UC1CcmFzaWwxCzAJBgNVBAgTAlNQMQwwCgYDVQQHFANJVFUxNjA0BgNVBAsULVNlY3JldGFyaWEg\n"
                + "ZGEgUmVjZWl0YSBGZWRlcmFsIGRvIEJyYXNpbCAtIFJGQjEWMBQGA1UECxQNUkZCIGUtQ05QSiBB\n"
                + "MTE2MDQGA1UECxQtQXV0ZW50aWNhZG8gcG9yIEF1dG9yaWRhZGUgZGUgUmVnaXN0cm8gQ05CIFNQ"
                + "MS4wLAYDVQQDEyVBVVRPIEdFUkFMIERFIElUVSBMVERBOjA1NDM3NTM3MDAwMTM3MIIBIjANBgkq"
                + "hkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlIMgUeBDCdsxMDvMHdie3YCGMjzZcuyuvnMp0JAYFWhu"
                + "iWMx6YfLSbeZKLbynPW3KTqu7kNnxWV+vW1FGqjkCV3CTDp4GhXW/0PtaYmL3jqBx2y/PcYx6/aG"
                + "MdEgdV6f8NIfTKwXCHjFfMltHMzgR3J+ZX6GrQtFOxotF/fJe1SOVVFif76rAX5WD4uqvoOj1+ME"
                + "JxllBjI/ld0AlPZysHPuKAN+CNq3UUQJkwE3cASWY1Xz2SnFzaVvTyMghMzSxbgLE5cztJH54O4W"
                + "PcXXc4NE/I2P9s1JlYGNsAANnbNr4qbJ6QW6LYVenc0SOE7st0EofXfzK5hFSqvXxBmLQQIDAQAB"
                + "o4IDVTCCA1Ewgb0GA1UdEQSBtTCBsqA9BgVgTAEDBKA0BDIwNTA4MTk0MTA2ODU5NTAwODU5MDAw"
                + "MDAwMDAwMDAwMDAwMDAwMDg1NTE2OTNTU1BTUKAZBgVgTAEDAqAQBA5HRVJBTERPIFRVVkFOSaAZ"
                + "BgVgTAEDA6AQBA4wNTQzNzUzNzAwMDEzN6AXBgVgTAEDB6AOBAwwMDAwMDAwMDAwMDCBIm1laXJl"
                + "LnBsYW5jb3dza2lAb2ZmaWNlY29udC5jb20uYnIwCQYDVR0TBAIwADAfBgNVHSMEGDAWgBTyeafR"
                + "GoH3fN+d6xzAdLJUb5mLxzAOBgNVHQ8BAf8EBAMCBeAwfgYDVR0gBHcwdTBzBgZgTAECAR4waTBn"
                + "BggrBgEFBQcCARZbaHR0cDovL2ljcC1icmFzaWwuYWNub3RhcmlhbC5jb20uYnIvcmVwb3NpdG9y"
                + "aW8vZHBjL0FDX05vdGFyaWFsX1JGQi9EUENfQUNfTm90YXJpYWxfUkZCLnBkZjCCARQGA1UdHwSC"
                + "AQswggEHMFegVaBThlFodHRwOi8vaWNwLWJyYXNpbC5hY25vdGFyaWFsLmNvbS5ici9yZXBvc2l0"
                + "b3Jpby9sY3IvQUNOb3RhcmlhbFJGQkczL0xhdGVzdENSTC5jcmwwVaBToFGGT2h0dHA6Ly9pY3At"
                + "YnJhc2lsLm91dHJhbGNyLmNvbS5ici9yZXBvc2l0b3Jpby9sY3IvQUNOb3RhcmlhbFJGQkczL0xh"
                + "dGVzdENSTC5jcmwwVaBToFGGT2h0dHA6Ly9yZXBvc2l0b3Jpby5pY3BicmFzaWwuZ292LmJyL2xj"
                + "ci9DZXJ0aXNpZ24vQUNOb3RhcmlhbFJGQkczL0xhdGVzdENSTC5jcmwwHQYDVR0lBBYwFAYIKwYB"
                + "BQUHAwIGCCsGAQUFBwMEMIGbBggrBgEFBQcBAQSBjjCBizBfBggrBgEFBQcwAoZTaHR0cDovL2lj"
                + "cC1icmFzaWwuYWNub3RhcmlhbC5jb20uYnIvcmVwb3NpdG9yaW8vY2VydGlmaWNhZG9zL0FDX05v"
                + "dGFyaWFsX1JGQl9HMy5wN2MwKAYIKwYBBQUHMAGGHGh0dHA6Ly9vY3NwLmNlcnRpc2lnbi5jb20u"
                + "YnIwDQYJKoZIhvcNAQELBQADggIBABfDZsb5Fq92wE9wWfFajeMGIxkdF2urO6zR55/KsMGMWS2a"
                + "LMA4C21xHz/5PU0hwIKGvFZb5anNmRCCaFcO/zViA78cek1NHVsV/RSrwx7s8kG0PDGSdWG4aDte"
                + "U+XJA0H8CgXDSd0TMdNUcWDF4XZi5EbAD7egN3ESFvvX74/h6GiN0O9agNl0eeW8C1QEaw/LjTcz"
                + "3PHoTT1aCiLoAknjiakaD6m+gZ2zgUlT/dzQ66fON9TI8yv58CzR/wXstjYx2fAOtGCXYF1+5X1r"
                + "V8Bd9O1GGqDZsh2LxgcfIJIMzTPXfUkvPYBiQGbN4dHZbYakyqKLA7oFF2XtE/YNwqZihpvZbUxY"
                + "BGFwg9vI+cq6midvvvD0Wu8cIoVAHPanW/wKgH9ViXQNhbOTwLF9GyqKsy5+3cG67yq/9yzvINWW"
                + "lOH6f55uUqrE08kjHvGrRe7ZzZDGZXuF4xjhkrTuOxsAWgATIz7spPPUy+ZDiSnmJpne61EkA/QP"
                + "PlvUvk7u2GtXqzWEpoa+ncGSOVFqHvuqL/Z9rWGKkm8d7EF44UD+mZEdMzJ8/4Cp9DZ7qRIlJWKO"
                + "mrk47uZkqogmoxMM70OLRMpUIn4O32MSYX3jFaUU8ShWMk7hCzMALy4tU9nrv4D5i0/XKmFO/EvS"
                + "ue2mruBl9hduggpKNlRNzSkJEbas</X509Certificate></X509Data></KeyInfo></Signature></evento><retEvento versao=\"1.00\"><infEvento><tpAmb>1</tpAmb><verAplic>SP_EVENTOS_PL_100</verAplic><cOrgao>35</cOrgao><cStat>135</cStat><xMotivo>Evento registrado e vinculado a NF-e</xMotivo><chNFe>35130305437537000480550010000315621560324007</chNFe><tpEvento>110111</tpEvento><xEvento>Cancelamento registrado</xEvento><nSeqEvento>1</nSeqEvento><CPFDest>02891120876</CPFDest><dhRegEvento>2013-03-11T17:42:44-03:00</dhRegEvento><nProt>135130143010831</nProt></infEvento></retEvento></procEventoNFe>";
        Unmarshaller unmarshaller = null;
        TProcEvento procEvent = null;
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance("br.inf.portalfiscal.nfe.xml.pl006q.nfes");
            unmarshaller = context.createUnmarshaller();
            ByteArrayInputStream bais = new ByteArrayInputStream(xml.getBytes("UTF-8"));
            procEvent = unmarshaller.unmarshal(new StreamSource(bais), TProcEvento.class).getValue();
            bais.close();
        } catch (JAXBException ex) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, "Erro JAXB", ex);
        } catch (IOException ex) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, "Erro IO", ex);

        }


        assertNotNull(procEvent);
        System.out.println(procEvent.getVersao());
        assertNotNull(procEvent.getEvento());
        System.out.println(procEvent.getEvento().getInfEvento().getTpEvento());
        System.out.println(procEvent.getEvento().getInfEvento().getCOrgao());
        System.out.println(procEvent.getEvento().getInfEvento().getCNPJ());
        System.out.println(procEvent.getEvento().getInfEvento().getDetEvento().getDescEvento());
        System.out.println(procEvent.getEvento().getInfEvento().getDetEvento().getNProt());
        assertNotNull(procEvent.getRetEvento());
        
        try {
            Marshaller marshaller = context.createMarshaller();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            marshaller.marshal(procEvent, baos);
            xml = baos.toString();
            xml = xml.replaceAll("xmlns:ns2=\".+#\"\\s", "").replaceAll("ns2:", "");
            System.out.println(xml);
        } catch (JAXBException ex) {
            Logger.getLogger(ProcessamentoEventosTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
