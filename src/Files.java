import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.PatternDocument;

import java.io.*;
import java.util.regex.Pattern;

public class Files {
    public Files(String name) throws IOException {
        XSSFWorkbook number = new XSSFWorkbook(new FileInputStream(name));
        XSSFSheet list = number.getSheetAt(0);
        Pattern pattern = Pattern.compile("^(\\d{1}\\s)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{2}[\\s.-]?\\d{2}$");
        FileWriter writer = new FileWriter("D:\\Zapis.txt");
        for (int i = 0; i < list.getLastRowNum(); i++) {
        String a = String.valueOf(list.getRow(i).getCell(0));
        if (a.matches(String.valueOf(pattern))){
            writer.write(a + "\n");
            writer.flush();
        }
        }
    }
}
