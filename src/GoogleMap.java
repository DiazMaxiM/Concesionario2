import java.io.*;
import java.net.*;
import javax.xml.parsers.*;
import org.xml.sax.InputSource;
import org.w3c.dom.*;

public class GoogleMap {
public Integer obtenerDistancia(String direccion1,String direccion2) throws Exception {
	
	 direccion1=URLEncoder.encode(direccion1, "UTF-8");
	 direccion2=URLEncoder.encode(direccion2, "UTF-8");
	
	
	URL url;
    String xml = "";
        
        String urlString="https://maps.googleapis.com/maps/api/distancematrix/xml?origins="+direccion1+"&destinations="+direccion2+"&language=ES&key=AIzaSyADGv2YOdI2lNWU-hA3dG6enVwRGqMSHQc";
        url = new URL(urlString);
        
        URLConnection conexion = url.openConnection();

        // open the stream and put it into BufferedReader
        BufferedReader br = new BufferedReader(
                           new InputStreamReader(conexion.getInputStream()));

        String lectura;
        
        while ((lectura = br.readLine()) != null) {
                xml +=lectura;
        }
        br.close();
        
    String distancia = "";
	
    DocumentBuilderFactory dbf =DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    InputSource is = new InputSource();
    is.setCharacterStream(new StringReader(xml));

    Document documento = db.parse(is);
    NodeList nodo = documento.getElementsByTagName("DistanceMatrixResponse");
    Element elemento = (Element) nodo.item(0);
    NodeList nodo2= elemento.getElementsByTagName("row");
    Element elemento2 = (Element) nodo2.item(0);
    NodeList nodo3= elemento2.getElementsByTagName("distance");
    Element elemento3 = (Element) nodo3.item(0);
    NodeList nodo4 = elemento3.getElementsByTagName("value");
    Element elemento4 = (Element) nodo4.item(0);
    distancia = elemento4.getTextContent();
    return new Integer(distancia);
   
}
}
