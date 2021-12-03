package com.eddd.votarfms.serializer;

import android.content.Context;

import com.eddd.votarfms.models.Batalla;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class JSONSerializer {

    private String mFilename;
    private Context mContext;

    //constructor del objeto que va a serializar en ficheros JSON
    public JSONSerializer(String filename, Context context){
        this.mFilename = filename;
        this.mContext = context;
    }

    public void Save(List<Batalla> battles) throws IOException, JSONException{

        //array de objetos JSON
        JSONArray jsonArray = new JSONArray();

        //convertir cada una de las batallas en objetos JSON y guardarlas dentro del JSONArray
        for (Batalla allBattles: battles){

            //la convertimos a JSON(con el método creado anteriormente) y con el método .put la guardamos en el JSONArray
            jsonArray.put(allBattles.convertBattleToJSON());
        }

        //para guardar el fichero de objetos JSON, hay que usar un Writer
        Writer writer = null;

        try {
            //OutputStream abre el fichero donde guardaremos el JSON
            OutputStream out = mContext.openFileOutput(mFilename, mContext.MODE_PRIVATE);

            //el escritor ya sabe dónde escribir su contenido, en qué fichero JSON
            writer = new OutputStreamWriter(out);

            //el escritor escribe en el disco tooodo el Array pasado a formato String (PASO DE UN JSONARRAY A UN ARRAY DE STRINGS)
            writer.write(jsonArray.toString());

        } finally {
            //si el Writer había podido abrir el fichero es importante cerrarlo, para que no se corrompa
            if (writer!=null){
                writer.close();
            }
        }
    }

    public ArrayList<Batalla> Load() throws IOException, JSONException{

        ArrayList<Batalla> battles = new ArrayList<>();

        //BufferedReader para leer el fichero JSON
        BufferedReader reader = null;

        try {
            //InputStream abre el archivo que vamos a leer y procesar
            InputStream in = mContext.openFileInput(mFilename);

            //el lector ya sabe dónde leer los datos, de qué fichero JSON
            reader = new BufferedReader(new InputStreamReader(in));

            //leemos los String del fichero JSON con un StringBuilder
            StringBuilder jsonString = new StringBuilder();

            //variable para leer la línea actual
            String currentLine;

            //leer el fichero JSON entero hasta acabarlo, y pasarlo tooodo a String mientras que la línea actual no sea null
            while ((currentLine = reader.readLine()) != null){

                jsonString.append(currentLine);
            }

            //hemos pasado de un fichero en formato JSON a un String largo largo, con todos los objetos Batalla

            //ahora pasamos de un Array entero de Strings a un Array de objetos JSON
            JSONArray jArray = (JSONArray) new JSONTokener(jsonString.toString()).nextValue(); //paso de un Array de Strings a un JSONArray

            for (int i = 0; i< jArray.length(); i++){

                //usamos el constructor para crear una Batalla a partir de un objeto JSON
                //(el constructor de la clase Batalla con parámetro JSONObject)
                battles.add(new Batalla(jArray.getJSONObject(i))); //pasamos el JSONArray(jArray) a un Array de Batallas

            }
            //llegados a este punto, ya tenemos el Array de Batalla con todos los objetos de la clase Batalla...

        }catch (FileNotFoundException e){

            //la primera vez va a petar sí o sí, debido a que no habrá  ningún fichero de batallas que leer
            //en este caso nos basta con ignorar la excepción, ya que es normal
        }
        finally {

            //si el reader había abierto el fichero, es momento de cerrarlo para que no se corrompa
            if (reader!=null){
                reader.close();
            }
        }

        return battles;
    }

}
