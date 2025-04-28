import java.util.ArrayList;
import java.util.List;

public class LinearSearchAll {
    public static List<StudentResult> linearSearchAll(List<StudentResult> list, String searchKey) {
        List<StudentResult> resultList = new ArrayList<>();
        
        searchKey = searchKey.trim().toLowerCase().replaceAll("\\s+", "");  
        
        int i = 0;
        while (i < list.size()) {
            StudentResult student = list.get(i);

            String rollNo = normalizeString(student.getRollNo());
            String name = normalizeString(student.getName());
            String gender = normalizeString(student.getGender());
            String section = normalizeString(student.getSection());
            String semester = normalizeString(student.getSemester());
            String contactNo = normalizeString(student.getContactNo());
            String email = normalizeString(student.getEmail());
            String marks = String.valueOf(student.getMarks());

            // searchKey matches (including partial matches)
            if (rollNo.contains(searchKey) ||
                name.contains(searchKey) ||
                gender.contains(searchKey) ||
                section.contains(searchKey) ||
                semester.contains(searchKey) ||
                contactNo.contains(searchKey) ||
                email.contains(searchKey) ||
                marks.contains(searchKey)) {
                
                resultList.add(student); 
            }
            i++;
        }
        return resultList;
    }

    private static String normalizeString(String field) {
        if (field == null) {
            return "";
        }
        return field.trim().toLowerCase().replaceAll("\\s+", "");  // Remove extra spaces between words
    }

}
