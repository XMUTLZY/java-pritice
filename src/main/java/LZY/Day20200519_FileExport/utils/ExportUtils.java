package LZY.Day20200519_FileExport.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class ExportUtils {
    public static void initCsvFile(HttpServletResponse response, HttpServletRequest request, String fileName) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", String.format("attachment;filename=%s.csv", encodeFileName(fileName, request)));
        response.setCharacterEncoding("UTF-8");
        OutputStream out = response.getOutputStream();
        out.write(new byte[]{(byte) 0xEF, (byte) 0xBB, (byte) 0xBF});
    }

    public static String encodeFileName(String fileName, HttpServletRequest request) throws UnsupportedEncodingException {
        String file = fileName;
        if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0) {
            file = URLEncoder.encode(file, "UTF-8");
        } else {
            file = new String(file.getBytes("UTF-8"), "ISO8859-1");
        }
        return file;
    }
}
