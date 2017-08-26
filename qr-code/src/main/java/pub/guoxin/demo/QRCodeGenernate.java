package pub.guoxin.demo;

import com.beust.jcommander.internal.Maps;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.springframework.util.FileSystemUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Map;

/**
 * Created by guoxin on 17-8-26.
 */
public class QRCodeGenernate {

    public static final int LENGTH = 200;

    public static final String PNG = "png";

    public static Map<EncodeHintType, Object> HINTS = Maps.newHashMap();

    static {
        HINTS.put(EncodeHintType.CHARACTER_SET, "UTF-8");
    }

    public static void gen(String content, int width, int height, String filePath, String fileName, String imageType) throws WriterException, IOException {
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, HINTS);// 生成矩阵
        File file = new File(filePath);
        if (!file.exists())
            file.mkdirs();
        Path path = FileSystems.getDefault().getPath(filePath, fileName);
        MatrixToImageWriter.writeToPath(bitMatrix, imageType, path); // 输出图像
        System.out.println("Genernate success");
    }

    public static void gen200(String content) throws WriterException, IOException {
        gen(content, LENGTH, LENGTH, "./qr-image", String.valueOf(System.currentTimeMillis()) + "." + PNG, PNG);
    }

}
