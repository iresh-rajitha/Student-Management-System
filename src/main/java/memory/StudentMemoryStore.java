package memory;

import models.Student;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class StudentMemoryStore {
    private FileStoreMemory fileStoreMemory;
    public StudentMemoryStore(){
        fileStoreMemory= new FileStoreMemory();
    }

    public boolean write(List<Student> list){
        String arr = list.toString();
        fileStoreMemory.writeFile(arr, FileStoreMemory.file.STUDENT);
        return true;
    }
    public List<Student> read(){
        String arr = fileStoreMemory.readFile(FileStoreMemory.file.STUDENT);
        List<Student> readList =  new ArrayList<>();
        try {
            JSONArray jsonArray =  new JSONArray(arr);
            for (int i = 0; i < jsonArray.length(); i++) {
//            JSONObject explrObject = jsonArray.getJSONObject(i);
                readList.add(new Student(jsonArray.getJSONObject(i)));
            }
        }catch (JSONException exception){
            System.out.println("List is Empty");
//            exception.printStackTrace();
        }
//        System.out.println(readList.toString());
        return readList;
    }
}
