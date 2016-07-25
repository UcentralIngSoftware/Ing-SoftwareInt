/*
* RockFlowersUtil.java
*
* Version 1.0
*
* 16 julio 2016
*
* Este archivo es confidencial de la aplicacion rockflowers y no se puede distribuir de manera comercial dado que es de uso estudiantil
*/


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr.core.ikea.vista.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author rm-rf
 */
public class RockFlowersUtil {

    public final static String PATH_UPLOAD_IMAGES = "/rockflowers";

    public enum EstadosDB {
        Activo("A"),
        Eliminado("E");

        private String label;

        private EstadosDB(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

    }
    
    /**
    * Carga una imagen en una ruta local en la cual se encuentran los archivos
    * guardados y cargados por los usuarios
    *
    * @param path       Ruta de destino en la cual se almacenaran los archivos
    * @param nameFile   Nombre de archivo con el cual quedara almacenado 
    * @param fis        El inputStream generado por el framework
    * 
    * @throws FileNotFoundException Si existe algun problema al momento de escribir el archivo en la ruta enviada
    * @throws IOException           Si existe algun problema de lectura con el IntpuStream
    */
    public static void uploadFile(String path, String nameFile, InputStream fis) throws FileNotFoundException, IOException {
        OutputStream fos = null;
        try {
            File f = new File(path);
            if (!f.exists()) {
                f.mkdirs();
            }
            f = new File(path, nameFile);
            fos = new FileOutputStream(f);
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, read);
            }
        } finally {
            fos.close();
        }
    }
    
    public static String encodePasswd(String passwd){
        return String.valueOf(passwd.hashCode());
    }

}
