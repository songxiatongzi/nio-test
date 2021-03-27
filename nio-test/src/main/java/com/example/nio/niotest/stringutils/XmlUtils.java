package com.example.nio.niotest.stringutils;

import lombok.Data;
import org.xml.sax.InputSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

/**
 * @author songxia tongzi
 * @date 2020/11/12 22:37
 */
public class XmlUtils {

//    /**
//     * 将xml转换成为clazz
//     * @param clazz
//     * @param xml
//     * @param
//     * @return
//     * @throws Exception
//     */
//    public static Object xmlToObjectSafe(Class<?> clazz, String xml) throws Exception {
//        //T t = null;
//        JAXBContext context = JAXBContext.newInstance(clazz);
//        Unmarshaller unmarshaller = context.createUnmarshaller();
//
//        XMLInputFactory xif = XMLInputFactory.newFactory();
//        xif.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
//        xif.setProperty(XMLInputFactory.SUPPORT_DTD, true);
//        XMLStreamReader xsr = xif.createXMLStreamReader(new StringReader(xml));
//        return unmarshaller.unmarshal(xsr);
//    }

    /**
     * 对象转换成为xml
     * @param klass
     * @param obj
     * @return
     * @throws Exception
     */
    public static String objectToXML(Class<?> klass, Object obj) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(klass);
        Marshaller marshaller = jaxbContext.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);

        StringWriter writer = new StringWriter();
        marshaller.marshal(obj, writer);
        writer.close();

        return writer.toString();
    }



    public static<T> T converyToJavaBean(String xml,Class<T> clazz){
        T t = null;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            t = (T)unmarshaller.unmarshal(new StringReader(xml));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return t;
    }
}
@Data
 class Student{
   
}