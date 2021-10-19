package memory;

import models.Session;
import org.json.JSONArray;
import org.json.JSONException;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class SessionMemoryStore {
    private FileStoreMemory fileStoreMemory;

    public SessionMemoryStore() {
        fileStoreMemory=new FileStoreMemory();
    }
    public boolean write(List<Session> list){
        String arr=list.toString();
        fileStoreMemory.writeFile(arr,FileStoreMemory.file.SESSION);
        return true;
    }
    public List<Session> read(){
        String arr=fileStoreMemory.readFile(FileStoreMemory.file.SESSION);
        List<Session> readList=new ArrayList<>();
        try {
            JSONArray jsonArray=new JSONArray(arr);
            for (int i=0;i< jsonArray.length();i++){
                readList.add(new Session(jsonArray.getJSONObject(i)));
            }
        } catch (Exception e) {
            System.out.println("List is Empty");
            e.printStackTrace();
        }
        return readList;
    }
}
