package streams;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LowerCaseInputStream extends InputStream {
    private ByteArrayInputStream byteArrayInputStream;

    LowerCaseInputStream(ByteArrayInputStream byteArrayInputStream) {
        this.byteArrayInputStream = byteArrayInputStream;
    }

    @Override
    public int read() throws IOException {
        int raw = byteArrayInputStream.read();
        return raw >= 0
                ? Character.toLowerCase(raw)
                : raw;
    }
}
