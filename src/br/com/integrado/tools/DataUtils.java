package br.com.integrado.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jsoliveira
 */
public class DataUtils {

    private static final SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");

    private static final SimpleDateFormat formatDateTime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public static String dateToString(Date date) {

        try {
            return formatDate.format(date);
        } catch (Exception ex) {
            return null;
        }
    }
    
    
      public static Date stringToDate(String date) {

        try {
            return formatDate.parse(date);
        } catch (Exception ex) {
            return null;
        }
    }

      
         public static String dateTimeToString(Date date) {

        try {
            return formatDateTime.format(date);
        } catch (Exception ex) {
            return null;
        }
    }
    
    
      public static Date stringToDateTime(String date) {

        try {
            return formatDateTime.parse(date);
        } catch (Exception ex) {
            return null;
        }
    }
      
      public static void main(String[] args) {
          
          System.out.println(new Date());
          System.out.println(DataUtils.dateToString(new Date()));
          
          System.out.println(DataUtils.stringToDate("18/02/1988"));
          
          System.out.println(DataUtils.dateTimeToString(new Date()));
          System.out.println(DataUtils.stringToDateTime("18/02/1988 23:59:25"));
        
    }

}
