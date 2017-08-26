package pub.guoxin.demo;

import com.google.zxing.WriterException;

import java.io.IOException;

/**
 * Created by guoxin on 17-8-26.
 */
public class QRCodeApplication {
    public static void main(String[] args) {
        try {
            QRCodeGenernate.gen200("你好吗？");
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
    }
}
