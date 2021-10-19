package memory;

import models.Attendance;
import models.Student;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class AttendanceMemoryStore {

    private FileStoreMemory fileStoreMemory;
    public AttendanceMemoryStore(){
        fileStoreMemory= new FileStoreMemory();
    }

    public boolean write(List<Attendance> list){
        String arr = list.toString();
        fileStoreMemory.writeFile(arr, FileStoreMemory.file.ATTENDANCE);
        return true;
    }

    public List<Attendance> read(){
        String arr = fileStoreMemory.readFile(FileStoreMemory.file.ATTENDANCE);
        List<Attendance> readList =  new ArrayList<>();
        try {
            JSONArray jsonArray =  new JSONArray(arr);
            for (int i = 0; i < jsonArray.length(); i++) {
                readList.add(new Attendance(jsonArray.getJSONObject(i)));
            }
        }catch (JSONException exception){
            System.out.println("List is Empty");
        }
//        System.out.println(readList.toString());
        return readList;
    }
}
