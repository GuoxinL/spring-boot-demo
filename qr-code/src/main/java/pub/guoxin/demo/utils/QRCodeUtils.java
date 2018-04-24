package pub.guoxin.demo.utils;

import com.beust.jcommander.internal.Maps;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Map;

/**
 * Created by guoxin on 17-8-26.
 */
public class QRCodeUtils {

    public static final int LENGTH = 200;

    public static final String PNG = "png";

    public static final String PATH = "./qr-image";
    public static Map<EncodeHintType, String> HINTS_ENCODE = Maps.newHashMap();
    public static Map<DecodeHintType, String> HINTS_DECODE = Maps.newHashMap();

    static {
        HINTS_ENCODE.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        HINTS_DECODE.put(DecodeHintType.CHARACTER_SET, "UTF-8");
    }

    public static String gen(String content, int width, int height, String filePath, String fileName, String imageType) throws WriterException, IOException {
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, HINTS_ENCODE);// 生成矩阵
        File file = new File(filePath);
        if (!file.exists())
            file.mkdirs();
        Path path = FileSystems.getDefault().getPath(filePath, fileName);
        MatrixToImageWriter.writeToPath(bitMatrix, imageType, path); // 输出图像
        System.out.println("Genernate success");
        return path.toString();
    }

    public static String gen200(String content) throws WriterException, IOException {
        return gen(content, LENGTH, LENGTH, PATH, String.valueOf(System.currentTimeMillis()) + "." + PNG, PNG);
    }

    public static String analysis(String qrImageFilePath) throws IOException, NotFoundException {
        File file = new File(qrImageFilePath);
        BufferedImage image = ImageIO.read(file);

        LuminanceSource source = new BufferedImageLuminanceSource(image);
        Binarizer binarizer = new HybridBinarizer(source);
        BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);

        Result result = new MultiFormatReader().decode(binaryBitmap, HINTS_DECODE);// 对图像进行解码
        System.out.println("result:\n" +
                "\tresult.getText():" + result.getText() + "\n" +
                "\tresult.getBarcodeFormat():" + result.getBarcodeFormat() + "\n" +
                "\tresult.getNumBits():" + result.getNumBits() + "\n" +
                "\tresult.getRawBytes():" + result.getRawBytes() + "\n" +
                "\tresult.getResultMetadata():" + result.getResultMetadata() + "\n" +
                "\tresult.getResultPoints():" + result.getResultPoints() + "\n" +
                "\tresult.getTimestamp():" + result.getTimestamp()
        );
        System.out.println(result.getBarcodeFormat());
        return result.getText();
    }
}
