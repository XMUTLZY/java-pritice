package LZY.Day20200519_FileExport.controller;

import LZY.Day20200519_FileExport.utils.ExportUtils;
import com.csvreader.CsvWriter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ExportDemoController {

    @GetMapping("/export")
    public void export(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ExportUtils.initCsvFile(response, request, "測試文件導出");
        CsvWriter csvWriter = new CsvWriter(response.getOutputStream(), ',', Charset.forName("UTF-8"));
        String[] header = {"日期", "標題", "评论量"};
        csvWriter.writeRecord(header);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String[] data;
        for (int i = 0; i<10; i++) {
            data = new String[]{
                    format.format(new Date()),
                    "標題" + i,
                    "評論兩" + i,
            };
            csvWriter.writeRecord(data);
        }
        csvWriter.close();
        response.getOutputStream().flush();
    }

}
