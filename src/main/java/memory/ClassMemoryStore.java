package memory;

import models.Class;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class ClassMemoryStore {
    private FileStoreMemory fileStoreMemory;
    public ClassMemoryStore(){
        fileStoreMemory= new FileStoreMemory();
    }

    public boolean write(List<Class> list){
        String arr = list.toString();
        fileStoreMemory.writeFile(arr, FileStoreMemory.file.CLASS);
        return true;
    }
    public List<Class> read(){
        String arr = fileStoreMemory.readFile(FileStoreMemory.file.CLASS);
        List<Class> readList =  new ArrayList<>();
        try {
            JSONArray jsonArray =  new JSONArray(arr);
            for (int i = 0; i < jsonArray.length(); i++) {
//            JSONObject explrObject = jsonArray.getJSONObject(i);
                readList.add(new Class(jsonArray.getJSONObject(i)));
            }
        }catch (JSONException exception){
            System.out.println("List is Empty");
       exception.printStackTrace();
        }
//        System.out.println(readList.toString());
        return readList;
    }
}
