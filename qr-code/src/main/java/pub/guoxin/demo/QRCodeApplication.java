package pub.guoxin.demo;

import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import pub.guoxin.demo.utils.QRCodeUtils;

import java.io.IOException;

/**
 * Created by guoxin on 17-8-26.
 */
public class QRCodeApplication {
    public static void main(String[] args) {
        String path = null;
        try {
            path = QRCodeUtils.gen200("我愛你");
            System.out.println("QRCodeUtils.gen200 : " + path);
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }

        try {
            String analysis = QRCodeUtils.analysis(path);
            System.out.println("analysis:" + analysis);
        } catch (IOException | NotFoundException e) {
            e.printStackTrace();
        }
    }
}
