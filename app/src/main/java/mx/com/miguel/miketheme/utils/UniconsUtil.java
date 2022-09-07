package mx.com.miguel.miketheme.utils;

public class UniconsUtil {

    public String icono(String icono){
        String valHexStr = icono.replace("&#x", "").replace(";", "");
        long valLong = Long.parseLong(valHexStr,16);
        return String.valueOf((char) valLong+"");
    }


}
