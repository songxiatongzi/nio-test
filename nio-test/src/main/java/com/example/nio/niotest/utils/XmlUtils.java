package com.example.nio.niotest.utils;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.UnmarshallingContext;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.mapper.MapperWrapper;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * @author songxia tongzi
 * @date 2020/11/14 22:41
 */
public class XmlUtils {

    static void addXStream(Map<Class<?>, XStream> map, Class<?> calzz, XStream xst) {
        map.put(calzz, xst);
    }

    static XStream getXStream(Class<?> clazz,String aliasname) {
        Map<Class<?>, XStream> map = new HashMap<Class<?>, XStream>();
        if (map.get(clazz) == null) {

            XStream xs = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_", "_"))) {
                @Override
                protected MapperWrapper wrapMapper(MapperWrapper next) {
                    return new MapperWrapper(next) {
                        @Override
                        @SuppressWarnings("rawtypes")
                        public boolean shouldSerializeMember(Class definedIn, String fieldName) {
                            if (definedIn == Object.class) {
                                return false;
                            }
                            return super.shouldSerializeMember(definedIn, fieldName);
                        }
                    };
                }
            };
            xs.autodetectAnnotations(true);
            xs.processAnnotations(clazz);
            xs.omitField(clazz, "");
            xs.ignoreUnknownElements();
            xs.addPermission(AnyTypePermission.ANY);
            ///xs.registerConverter(new TimestampConverter());
            if(aliasname!=null) {
                xs.alias(aliasname, clazz);
            }
            addXStream(map, clazz, xs);
        }
        return map.get(clazz);
    }

    @SuppressWarnings("unchecked")
    public static <T> T toObject(String xml, Class<?> mainclass) {
        Object obj = getXStream(mainclass,null).fromXML(xml.replace("__", "_"));
        return (T) obj;
    }

    public static String toXml(Object obj) {
        return getXStream(obj.getClass(),null).toXML(obj).replace("__", "_");
    }

    public static String toXML(Object object, String aliasname) {
        XStream xstream = getXStream(object.getClass(),aliasname);
        return xstream.toXML(object);
    }
    public static String toRequestXML(String bodyStr) {
        StringBuilder reqStr = new StringBuilder();
        reqStr.append("<root>");
        reqStr.append(bodyStr);
        reqStr.append("</root>");
        return reqStr.toString();
    }

    public static void toXml() {
    }

    public static <T> T xmlToObject(String xml, Class<T> cls){
        // use xstream:1.4.11
        XStream xstream = getXStream(cls,null);
//        //xstream使用注解转换
//        xstream.processAnnotations(cls);
        return (T) xstream.fromXML(xml);
    }

}
//class TimestampConverter implements Converter {
//
//    public boolean canConvert(@SuppressWarnings("rawtypes") Class clazz) {
//        return Timestamp.class == clazz;
//    }
//
//    public void marshal(Object arg0, HierarchicalStreamWriter arg1,
//                        MarshallingContext arg2) {
//    }
//
//    public Object unmarshal(HierarchicalStreamReader reader,
//                            UnmarshallingContext context) {
//        Timestamp ts = new Timestamp(System.currentTimeMillis());
//        ts = Timestamp.valueOf(reader.getValue());
//        return ts;
//    }
//}
