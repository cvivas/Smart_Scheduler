


package Agenda;

import java.io.*;
/**
* Clase GestionDatos necesaria para poder guardar y cargar sin perder la informacion
* del sistema

* Descripcion: Clase GestionDatos
* Autor: Sergi Salvador
* Ultima data: 19 d'abril 2009
* Relacionada con las clases: -

 
 */
public class GestionDatos implements Serializable {

	public void guardar(Object obj, String fitxer) throws IOException {

		FileOutputStream fout = new FileOutputStream(fitxer);
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(obj);
		oos.close();
	}//fin operacion

	public Object cargar(String fitxer) throws IOException,
			ClassNotFoundException {

		Object obj = null;
		FileInputStream fin = new FileInputStream(fitxer);
		ObjectInputStream ois = new ObjectInputStream(fin);
		obj = ois.readObject();
		ois.close();

		return obj;
	}//fin operacion

}//fin clase