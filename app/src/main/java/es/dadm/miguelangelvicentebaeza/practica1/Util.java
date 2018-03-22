package es.dadm.miguelangelvicentebaeza.practica1;

/**
 * Created by Desert on 22/03/2018.
 */

public class Util {
    public static boolean isNumber(String str){
        if (str.matches("[0-9]+")){
            return true;
        }
        else {
            return false;
        }
    }
}

